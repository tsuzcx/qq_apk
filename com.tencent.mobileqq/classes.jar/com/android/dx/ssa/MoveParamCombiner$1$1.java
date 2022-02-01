package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;

class MoveParamCombiner$1$1
  extends RegisterMapper
{
  MoveParamCombiner$1$1(MoveParamCombiner.1 param1, RegisterSpec paramRegisterSpec1, RegisterSpec paramRegisterSpec2) {}
  
  public int getNewRegisterCount()
  {
    return MoveParamCombiner.access$100(this.this$1.this$0).getRegCount();
  }
  
  public RegisterSpec map(RegisterSpec paramRegisterSpec)
  {
    RegisterSpec localRegisterSpec = paramRegisterSpec;
    if (paramRegisterSpec.getReg() == this.val$specB.getReg()) {
      localRegisterSpec = this.val$specA;
    }
    return localRegisterSpec;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.MoveParamCombiner.1.1
 * JD-Core Version:    0.7.0.1
 */