package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;

class ConstCollector$2
  extends RegisterMapper
{
  ConstCollector$2(ConstCollector paramConstCollector, RegisterSpec paramRegisterSpec1, RegisterSpec paramRegisterSpec2) {}
  
  public int getNewRegisterCount()
  {
    return ConstCollector.access$000(this.this$0).getRegCount();
  }
  
  public RegisterSpec map(RegisterSpec paramRegisterSpec)
  {
    RegisterSpec localRegisterSpec = paramRegisterSpec;
    if (paramRegisterSpec.getReg() == this.val$origReg.getReg()) {
      localRegisterSpec = this.val$newReg.withLocalItem(paramRegisterSpec.getLocalItem());
    }
    return localRegisterSpec;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.ConstCollector.2
 * JD-Core Version:    0.7.0.1
 */