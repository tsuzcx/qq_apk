package com.android.dx.ssa;

class EscapeAnalysis$2
  implements SsaBasicBlock.Visitor
{
  EscapeAnalysis$2(EscapeAnalysis paramEscapeAnalysis) {}
  
  public void visitBlock(SsaBasicBlock paramSsaBasicBlock1, SsaBasicBlock paramSsaBasicBlock2)
  {
    paramSsaBasicBlock1.forEachInsn(new EscapeAnalysis.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.EscapeAnalysis.2
 * JD-Core Version:    0.7.0.1
 */