package com.android.dx.rop.cst;

public final class CstInterfaceMethodRef
  extends CstBaseMethodRef
{
  private CstMethodRef methodRef = null;
  
  public CstInterfaceMethodRef(CstType paramCstType, CstNat paramCstNat)
  {
    super(paramCstType, paramCstNat);
  }
  
  public CstMethodRef toMethodRef()
  {
    if (this.methodRef == null) {
      this.methodRef = new CstMethodRef(getDefiningClass(), getNat());
    }
    return this.methodRef;
  }
  
  public String typeName()
  {
    return "ifaceMethod";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstInterfaceMethodRef
 * JD-Core Version:    0.7.0.1
 */