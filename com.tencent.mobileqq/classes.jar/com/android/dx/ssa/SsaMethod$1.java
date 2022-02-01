package com.android.dx.ssa;

class SsaMethod$1
  implements SsaInsn.Visitor
{
  SsaMethod$1(SsaMethod paramSsaMethod) {}
  
  public void visitMoveInsn(NormalSsaInsn paramNormalSsaInsn)
  {
    SsaMethod.access$000(this.this$0)[paramNormalSsaInsn.getResult().getReg()] = paramNormalSsaInsn;
  }
  
  public void visitNonMoveInsn(NormalSsaInsn paramNormalSsaInsn)
  {
    if (paramNormalSsaInsn.getResult() != null) {
      SsaMethod.access$000(this.this$0)[paramNormalSsaInsn.getResult().getReg()] = paramNormalSsaInsn;
    }
  }
  
  public void visitPhiInsn(PhiInsn paramPhiInsn)
  {
    SsaMethod.access$000(this.this$0)[paramPhiInsn.getResult().getReg()] = paramPhiInsn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.SsaMethod.1
 * JD-Core Version:    0.7.0.1
 */