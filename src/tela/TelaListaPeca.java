/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelos.Peca;
import persistencia.ManipulaBancoPecas;

/**
 *
 * @author witorsather
 */
public class TelaListaPeca extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaListaPeca
     */
    public TelaListaPeca() {
        initComponents();
        jFormattedTextFieldQuantidadeReservadas.setEditable(false);
        jFormattedTextFieldQuantidadeReservadas.setText("0");
        jFormattedTextFieldQuantidadeEstoqueMinimo.setText("0");
        jFormattedTextFieldQuantidadeEstoque.setText("0");
        LoadTableListaPecas();

        jButtonVoltar.setVisible(false);

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTableListaPecas.getModel());
        jTableListaPecas.setRowSorter(sorter);
    }

    private void LoadTableListaPecas() {
        try {
            DefaultTableModel table = (DefaultTableModel) jTableListaPecas.getModel();
            table.setRowCount(0);
            ArrayList<Peca> listaPecas = new ManipulaBancoPecas().buscarTodos();
            for (Peca p : listaPecas) {
                String[] dados = {String.valueOf(p.getCodigoPeca()),
                    String.valueOf(p.getDescricao()),
                    String.format("%.2f", p.getValorPeca()),
                    String.valueOf(p.getQuantidadeNoEstoque()),
                    String.valueOf(p.getQuantidadeReservadas()),
                    String.valueOf(p.getQuantidadeNoEstoque() - p.getQuantidadeReservadas()),
                    String.valueOf(p.getEstoquequantidadeMinima())};
                table.addRow(dados);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    private void filtraTableListaPecasCodigo(String codigo) {
        try {
            DefaultTableModel table = (DefaultTableModel) jTableListaPecas.getModel();
            table.setRowCount(0);
            ArrayList<Peca> listaPecas = new ManipulaBancoPecas().buscarTodos();
            for (Peca p : listaPecas) {
                if (p.getCodigoPeca().toUpperCase().contains(codigo.toUpperCase())) {
                    String[] dados = {String.valueOf(p.getCodigoPeca()),
                        String.valueOf(p.getDescricao()),
                        String.format("%.2f", p.getValorPeca()),
                        String.valueOf(p.getQuantidadeNoEstoque()),
                        String.valueOf(p.getQuantidadeReservadas()),
                        String.valueOf(p.getQuantidadeNoEstoque() - p.getQuantidadeReservadas()),
                        String.valueOf(p.getEstoquequantidadeMinima())};
                    table.addRow(dados);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    private void filtraTableListaPecasDescricao(String codigo) {
        try {
            DefaultTableModel table = (DefaultTableModel) jTableListaPecas.getModel();
            table.setRowCount(0);
            ArrayList<Peca> listaPecas = new ManipulaBancoPecas().buscarTodos();
            for (Peca p : listaPecas) {
                if (p.getDescricao().toUpperCase().contains(codigo.toUpperCase())) {
                    String[] dados = {String.valueOf(p.getCodigoPeca()),
                        String.valueOf(p.getDescricao()),
                        String.format("%.2f", p.getValorPeca()),
                        String.valueOf(p.getQuantidadeNoEstoque()),
                        String.valueOf(p.getQuantidadeReservadas()),
                        String.valueOf(p.getQuantidadeNoEstoque() - p.getQuantidadeReservadas()),
                        String.valueOf(p.getEstoquequantidadeMinima())};
                    table.addRow(dados);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonExcluir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaPecas = new javax.swing.JTable();
        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();
        jFormattedTextFieldQuantidadeEstoqueMinimo = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonIncluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldQuantidadeReservadas = new javax.swing.JFormattedTextField();
        jTextFieldFiltro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonEditar = new javax.swing.JButton();
        jFormattedTextFieldValorUnitario = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextFieldQuantidadeEstoque = new javax.swing.JFormattedTextField();

        setTitle("Produtos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonExcluir.setBackground(new java.awt.Color(0, 204, 255));
        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-excluir-30.png"))); // NOI18N
        jButtonExcluir.setText("EXCLUIR");
        jButtonExcluir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jLabel6.setText("QUANTIDADE RESERVADAS:");

        jLabel2.setText("DESCRIÇÃO:");

        jTableListaPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Valor unitário", "quantidade total no estoque", "quantidade reservadas", "Quantidade disponível", "Estoque mínimo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableListaPecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableListaPecasMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListaPecas);

        jLabel7.setText("QUANTIDADE ESTOQUE MINIMO:");

        jButtonVoltar.setText("VOLTAR");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jFormattedTextFieldQuantidadeEstoqueMinimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFormattedTextFieldQuantidadeEstoqueMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldQuantidadeEstoqueMinimoActionPerformed(evt);
            }
        });

        jLabel5.setText("QUANTIDADE NO ESTOQUE:");

        jButtonIncluir.setBackground(new java.awt.Color(0, 204, 255));
        jButtonIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-mais-2-matemática-30.png"))); // NOI18N
        jButtonIncluir.setText("INCLUIR");
        jButtonIncluir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtrar");

        jFormattedTextFieldQuantidadeReservadas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFormattedTextFieldQuantidadeReservadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldQuantidadeReservadasActionPerformed(evt);
            }
        });

        jTextFieldFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldFiltroKeyReleased(evt);
            }
        });

        jLabel3.setText("CÓDIGO");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Descrição" }));

        jButtonEditar.setBackground(new java.awt.Color(0, 204, 255));
        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-lápis-30.png"))); // NOI18N
        jButtonEditar.setText("EDITAR");
        jButtonEditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jFormattedTextFieldValorUnitario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));

        jLabel4.setText("VALOR UNITÁRIO:");

        jFormattedTextFieldQuantidadeEstoque.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldCodigo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel2)
                                    .addGap(31, 31, 31)
                                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jFormattedTextFieldValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButtonIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(726, 726, 726)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jFormattedTextFieldQuantidadeEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addGap(16, 16, 16)
                                        .addComponent(jFormattedTextFieldQuantidadeReservadas, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(75, 75, 75)
                                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(120, 120, 120)))
                                .addComponent(jFormattedTextFieldQuantidadeEstoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(78, 78, 78))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jFormattedTextFieldValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jFormattedTextFieldQuantidadeEstoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jFormattedTextFieldQuantidadeEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldQuantidadeReservadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableListaPecasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaPecasMouseReleased
        try {
            int indexItemSelecionado = jTableListaPecas.getSelectedRow();// * peganod index do item que foi selecionado na tabela
            if (indexItemSelecionado >= 0) {//    * clique válido
                String codigoPecaSelecionada = String.valueOf(jTableListaPecas.getValueAt(indexItemSelecionado, 0));//  * pegando o código da peça, que será usado na consulta ao banco
                int idPeca = new ManipulaBancoPecas().buscar(codigoPecaSelecionada);//  * pegando o id da peça selecionada
                Peca p = new ManipulaBancoPecas().buscar(idPeca);// * pegando peça selecionada
                //  * pegou os dados da peça, agora preencher os campos
                jTextFieldCodigo.setText(p.getCodigoPeca());
                jTextFieldDescricao.setText(p.getDescricao());
                jFormattedTextFieldValorUnitario.setText(String.format("%.2f", p.getValorPeca()));//    * formatando antes de mostrar na tela
                jFormattedTextFieldQuantidadeEstoque.setText("" + p.getQuantidadeNoEstoque());
                jFormattedTextFieldQuantidadeReservadas.setText("" + p.getQuantidadeReservadas());
                jFormattedTextFieldQuantidadeEstoqueMinimo.setText("" + p.getEstoquequantidadeMinima());
            } else {//    * clique inválido
                //  * pass
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_jTableListaPecasMouseReleased

    private void jFormattedTextFieldQuantidadeEstoqueMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldQuantidadeEstoqueMinimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldQuantidadeEstoqueMinimoActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        try {
            String codigoPeca = jTextFieldCodigo.getText();
            String descricaoPeca = jTextFieldDescricao.getText();
            float valorUnitario = Float.parseFloat(jFormattedTextFieldValorUnitario.getText().replace(".", "").replace(",", "."));
            Peca p = new Peca(codigoPeca, descricaoPeca, valorUnitario);

            int quantidadeNoEstoque = Integer.parseInt(jFormattedTextFieldQuantidadeEstoque.getText());
            int quantidadeReservadas = Integer.parseInt(jFormattedTextFieldQuantidadeReservadas.getText());
            int quantidadeMinimaNoEstoque = Integer.parseInt(jFormattedTextFieldQuantidadeEstoqueMinimo.getText());
            p.setEstoquequantidadeMinima(quantidadeMinimaNoEstoque);
            p.setQuantidadeNoEstoque(quantidadeNoEstoque);
            p.setQuantidadeReservadas(quantidadeReservadas);

            new ManipulaBancoPecas().incluir(p);//  * incluindo no banco de dados

            LoadTableListaPecas();
            //jLabelCriadoComSucesso.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jFormattedTextFieldQuantidadeReservadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldQuantidadeReservadasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldQuantidadeReservadasActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        try {
            int indexItemSelecionado = jTableListaPecas.getSelectedRow();
            if (indexItemSelecionado >= 0) {//    * clique válido
                String codigoPecaSelecionada = String.valueOf(jTableListaPecas.getValueAt(indexItemSelecionado, 0));
                int idPeca = new ManipulaBancoPecas().buscar(codigoPecaSelecionada);
                Peca p = new ManipulaBancoPecas().buscar(idPeca);

                String codigo = jTextFieldCodigo.getText();
                String descricao = jTextFieldDescricao.getText();
                String valor = jFormattedTextFieldValorUnitario.getText().replace(".", "").replace(",", ".");
                float valorUnitario = Float.parseFloat(jFormattedTextFieldValorUnitario.getText().replace(".", "").replace(",", "."));

                int quantidadeNoEstoque = Integer.parseInt(jFormattedTextFieldQuantidadeEstoque.getText());
                int quantidadeReservadas = Integer.parseInt(jFormattedTextFieldQuantidadeReservadas.getText());
                int quantidadeMinimaNoEstoque = Integer.parseInt(jFormattedTextFieldQuantidadeEstoqueMinimo.getText());
                Peca novaPeca = new Peca(codigo, descricao, valorUnitario, quantidadeNoEstoque, quantidadeMinimaNoEstoque);
                novaPeca.setQuantidadeReservadas(quantidadeReservadas);
                //  * pegou todos os dados, agora editar
                new ManipulaBancoPecas().editar(p, novaPeca);// * removendo p e adicionando novaPeca
                JOptionPane.showMessageDialog(rootPane, "Editado com sucesso");
                LoadTableListaPecas();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione, na tabela, o que deseja editar");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        try {
            int indexItemSelecionado = jTableListaPecas.getSelectedRow();
            if (indexItemSelecionado >= 0) {//    * clique válido
                String codigoPecaSelecionada = String.valueOf(jTableListaPecas.getValueAt(indexItemSelecionado, 0));
                int idPeca = new ManipulaBancoPecas().buscar(codigoPecaSelecionada);
                Peca p = new ManipulaBancoPecas().buscar(idPeca);

                new ManipulaBancoPecas().remover(p);
                LoadTableListaPecas();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione, na tabela, o que deseja editar");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jTextFieldFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFiltroKeyReleased
        if (jComboBox1.getSelectedIndex() == 0) {
            filtraTableListaPecasCodigo(jTextFieldFiltro.getText());
        } else if (jComboBox1.getSelectedIndex() == 1) {
            filtraTableListaPecasDescricao(jTextFieldFiltro.getText());
        }
    }//GEN-LAST:event_jTextFieldFiltroKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextFieldQuantidadeEstoque;
    private javax.swing.JFormattedTextField jFormattedTextFieldQuantidadeEstoqueMinimo;
    private javax.swing.JFormattedTextField jFormattedTextFieldQuantidadeReservadas;
    private javax.swing.JFormattedTextField jFormattedTextFieldValorUnitario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListaPecas;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldFiltro;
    // End of variables declaration//GEN-END:variables
}
