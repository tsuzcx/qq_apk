package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;

class EscapeAnalysis$1
  extends RegisterMapper
{
  EscapeAnalysis$1(EscapeAnalysis paramEscapeAnalysis, RegisterSpec paramRegisterSpec1, RegisterSpec paramRegisterSpec2) {}
  
  public int getNewRegisterCount()
  {
    return EscapeAnalysis.access$000(this.this$0).getRegCount();
  }
  
  public RegisterSpec map(RegisterSpec paramRegisterSpec)
  {
    RegisterSpec localRegisterSpec = paramRegisterSpec;
    if (paramRegisterSpec.getReg() == this.val$result.getReg()) {
      localRegisterSpec = this.val$source;
    }
    return localRegisterSpec;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.EscapeAnalysis.1
 * JD-Core Version:    0.7.0.1
 */