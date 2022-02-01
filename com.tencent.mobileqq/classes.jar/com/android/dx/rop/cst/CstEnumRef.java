package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;

public final class CstEnumRef
  extends CstMemberRef
{
  private CstFieldRef fieldRef = null;
  
  public CstEnumRef(CstNat paramCstNat)
  {
    super(new CstType(paramCstNat.getFieldType()), paramCstNat);
  }
  
  public CstFieldRef getFieldRef()
  {
    if (this.fieldRef == null) {
      this.fieldRef = new CstFieldRef(getDefiningClass(), getNat());
    }
    return this.fieldRef;
  }
  
  public Type getType()
  {
    return getDefiningClass().getClassType();
  }
  
  public String typeName()
  {
    return "enum";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstEnumRef
 * JD-Core Version:    0.7.0.1
 */