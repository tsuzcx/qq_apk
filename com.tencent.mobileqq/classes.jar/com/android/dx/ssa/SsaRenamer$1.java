package com.android.dx.ssa;

class SsaRenamer$1
  implements SsaBasicBlock.Visitor
{
  SsaRenamer$1(SsaRenamer paramSsaRenamer) {}
  
  public void visitBlock(SsaBasicBlock paramSsaBasicBlock1, SsaBasicBlock paramSsaBasicBlock2)
  {
    new SsaRenamer.BlockRenamer(this.this$0, paramSsaBasicBlock1).process();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.SsaRenamer.1
 * JD-Core Version:    0.7.0.1
 */