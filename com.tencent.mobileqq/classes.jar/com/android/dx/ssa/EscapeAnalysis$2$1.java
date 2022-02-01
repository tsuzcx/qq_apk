package com.android.dx.ssa;

class EscapeAnalysis$2$1
  implements SsaInsn.Visitor
{
  EscapeAnalysis$2$1(EscapeAnalysis.2 param2) {}
  
  public void visitMoveInsn(NormalSsaInsn paramNormalSsaInsn) {}
  
  public void visitNonMoveInsn(NormalSsaInsn paramNormalSsaInsn)
  {
    EscapeAnalysis.access$100(this.this$1.this$0, paramNormalSsaInsn);
  }
  
  public void visitPhiInsn(PhiInsn paramPhiInsn) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.EscapeAnalysis.2.1
 * JD-Core Version:    0.7.0.1
 */