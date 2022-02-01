package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;

public final class CstFieldRef
  extends CstMemberRef
{
  public CstFieldRef(CstType paramCstType, CstNat paramCstNat)
  {
    super(paramCstType, paramCstNat);
  }
  
  public static CstFieldRef forPrimitiveType(Type paramType)
  {
    return new CstFieldRef(CstType.forBoxedPrimitiveType(paramType), CstNat.PRIMITIVE_TYPE_NAT);
  }
  
  protected int compareTo0(Constant paramConstant)
  {
    int i = super.compareTo0(paramConstant);
    if (i != 0) {
      return i;
    }
    paramConstant = (CstFieldRef)paramConstant;
    return getNat().getDescriptor().compareTo(paramConstant.getNat().getDescriptor());
  }
  
  public Type getType()
  {
    return getNat().getFieldType();
  }
  
  public String typeName()
  {
    return "field";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstFieldRef
 * JD-Core Version:    0.7.0.1
 */