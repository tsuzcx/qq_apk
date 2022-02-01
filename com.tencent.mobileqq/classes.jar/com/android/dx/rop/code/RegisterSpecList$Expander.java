package com.android.dx.rop.code;

import java.util.BitSet;

class RegisterSpecList$Expander
{
  private int base;
  private BitSet compatRegs;
  private boolean duplicateFirst;
  private RegisterSpecList regSpecList;
  private RegisterSpecList result;
  
  private RegisterSpecList$Expander(RegisterSpecList paramRegisterSpecList, BitSet paramBitSet, int paramInt, boolean paramBoolean)
  {
    this.regSpecList = paramRegisterSpecList;
    this.compatRegs = paramBitSet;
    this.base = paramInt;
    this.result = new RegisterSpecList(paramRegisterSpecList.size());
    this.duplicateFirst = paramBoolean;
  }
  
  private void expandRegister(int paramInt)
  {
    expandRegister(paramInt, (RegisterSpec)RegisterSpecList.access$300(this.regSpecList, paramInt));
  }
  
  private void expandRegister(int paramInt, RegisterSpec paramRegisterSpec)
  {
    int i = 1;
    if (this.compatRegs == null) {}
    for (;;)
    {
      RegisterSpec localRegisterSpec = paramRegisterSpec;
      if (i != 0)
      {
        localRegisterSpec = paramRegisterSpec.withReg(this.base);
        if (!this.duplicateFirst) {
          this.base += localRegisterSpec.getCategory();
        }
        this.duplicateFirst = false;
      }
      RegisterSpecList.access$400(this.result, paramInt, localRegisterSpec);
      return;
      if (this.compatRegs.get(paramInt)) {
        i = 0;
      }
    }
  }
  
  private RegisterSpecList getResult()
  {
    if (this.regSpecList.isImmutable()) {
      this.result.setImmutable();
    }
    return this.result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.RegisterSpecList.Expander
 * JD-Core Version:    0.7.0.1
 */