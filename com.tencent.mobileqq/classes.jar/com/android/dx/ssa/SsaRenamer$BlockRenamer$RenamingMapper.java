package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;

class SsaRenamer$BlockRenamer$RenamingMapper
  extends RegisterMapper
{
  public SsaRenamer$BlockRenamer$RenamingMapper(SsaRenamer.BlockRenamer paramBlockRenamer) {}
  
  public int getNewRegisterCount()
  {
    return SsaRenamer.access$100(this.this$1.this$0);
  }
  
  public RegisterSpec map(RegisterSpec paramRegisterSpec)
  {
    if (paramRegisterSpec == null) {
      return null;
    }
    int i = paramRegisterSpec.getReg();
    return paramRegisterSpec.withReg(SsaRenamer.BlockRenamer.access$200(this.this$1)[i].getReg());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.SsaRenamer.BlockRenamer.RenamingMapper
 * JD-Core Version:    0.7.0.1
 */