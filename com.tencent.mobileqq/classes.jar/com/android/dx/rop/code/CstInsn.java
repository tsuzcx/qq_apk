package com.android.dx.rop.code;

import com.android.dx.rop.cst.Constant;

public abstract class CstInsn
  extends Insn
{
  private final Constant cst;
  
  public CstInsn(Rop paramRop, SourcePosition paramSourcePosition, RegisterSpec paramRegisterSpec, RegisterSpecList paramRegisterSpecList, Constant paramConstant)
  {
    super(paramRop, paramSourcePosition, paramRegisterSpec, paramRegisterSpecList);
    if (paramConstant == null) {
      throw new NullPointerException("cst == null");
    }
    this.cst = paramConstant;
  }
  
  public boolean contentEquals(Insn paramInsn)
  {
    return (super.contentEquals(paramInsn)) && (this.cst.equals(((CstInsn)paramInsn).getConstant()));
  }
  
  public Constant getConstant()
  {
    return this.cst;
  }
  
  public String getInlineString()
  {
    return this.cst.toHuman();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.CstInsn
 * JD-Core Version:    0.7.0.1
 */