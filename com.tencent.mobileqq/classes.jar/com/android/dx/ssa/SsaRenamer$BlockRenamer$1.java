package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;

class SsaRenamer$BlockRenamer$1
  implements PhiInsn.Visitor
{
  SsaRenamer$BlockRenamer$1(SsaRenamer.BlockRenamer paramBlockRenamer) {}
  
  public void visitPhiInsn(PhiInsn paramPhiInsn)
  {
    int i = paramPhiInsn.getRopResultReg();
    if (SsaRenamer.access$800(this.this$1.this$0, i)) {}
    RegisterSpec localRegisterSpec;
    do
    {
      return;
      localRegisterSpec = SsaRenamer.BlockRenamer.access$200(this.this$1)[i];
    } while (SsaRenamer.access$900(this.this$1.this$0, localRegisterSpec.getReg()));
    paramPhiInsn.addPhiOperand(localRegisterSpec, SsaRenamer.BlockRenamer.access$1000(this.this$1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.SsaRenamer.BlockRenamer.1
 * JD-Core Version:    0.7.0.1
 */