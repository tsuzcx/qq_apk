package com.android.dx.cf.attrib;

import com.android.dx.rop.cst.CstDouble;
import com.android.dx.rop.cst.CstFloat;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstLong;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.TypedConstant;

public final class AttConstantValue
  extends BaseAttribute
{
  public static final String ATTRIBUTE_NAME = "ConstantValue";
  private final TypedConstant constantValue;
  
  public AttConstantValue(TypedConstant paramTypedConstant)
  {
    super("ConstantValue");
    if ((!(paramTypedConstant instanceof CstString)) && (!(paramTypedConstant instanceof CstInteger)) && (!(paramTypedConstant instanceof CstLong)) && (!(paramTypedConstant instanceof CstFloat)) && (!(paramTypedConstant instanceof CstDouble)))
    {
      if (paramTypedConstant == null) {
        throw new NullPointerException("constantValue == null");
      }
      throw new IllegalArgumentException("bad type for constantValue");
    }
    this.constantValue = paramTypedConstant;
  }
  
  public int byteLength()
  {
    return 8;
  }
  
  public TypedConstant getConstantValue()
  {
    return this.constantValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.attrib.AttConstantValue
 * JD-Core Version:    0.7.0.1
 */