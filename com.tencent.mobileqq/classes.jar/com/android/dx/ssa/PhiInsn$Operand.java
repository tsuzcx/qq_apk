package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;

class PhiInsn$Operand
{
  public final int blockIndex;
  public RegisterSpec regSpec;
  public final int ropLabel;
  
  public PhiInsn$Operand(RegisterSpec paramRegisterSpec, int paramInt1, int paramInt2)
  {
    this.regSpec = paramRegisterSpec;
    this.blockIndex = paramInt1;
    this.ropLabel = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.PhiInsn.Operand
 * JD-Core Version:    0.7.0.1
 */