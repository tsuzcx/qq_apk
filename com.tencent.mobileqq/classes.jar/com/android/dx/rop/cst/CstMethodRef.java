package com.android.dx.rop.cst;

public final class CstMethodRef
  extends CstBaseMethodRef
{
  public CstMethodRef(CstType paramCstType, CstNat paramCstNat)
  {
    super(paramCstType, paramCstNat);
  }
  
  public String typeName()
  {
    return "method";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstMethodRef
 * JD-Core Version:    0.7.0.1
 */