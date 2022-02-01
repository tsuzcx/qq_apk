package com.android.dx.ssa;

public abstract interface SsaInsn$Visitor
{
  public abstract void visitMoveInsn(NormalSsaInsn paramNormalSsaInsn);
  
  public abstract void visitNonMoveInsn(NormalSsaInsn paramNormalSsaInsn);
  
  public abstract void visitPhiInsn(PhiInsn paramPhiInsn);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.SsaInsn.Visitor
 * JD-Core Version:    0.7.0.1
 */