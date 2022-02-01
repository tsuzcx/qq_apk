package com.android.dx.cf.iface;

import com.android.dx.cf.attrib.AttConstantValue;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.cst.TypedConstant;

public final class StdField
  extends StdMember
  implements Field
{
  public StdField(CstType paramCstType, int paramInt, CstNat paramCstNat, AttributeList paramAttributeList)
  {
    super(paramCstType, paramInt, paramCstNat, paramAttributeList);
  }
  
  public TypedConstant getConstantValue()
  {
    AttConstantValue localAttConstantValue = (AttConstantValue)getAttributes().findFirst("ConstantValue");
    if (localAttConstantValue == null) {
      return null;
    }
    return localAttConstantValue.getConstantValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.iface.StdField
 * JD-Core Version:    0.7.0.1
 */