package com.android.dx.cf.attrib;

import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstType;

public final class AttEnclosingMethod
  extends BaseAttribute
{
  public static final String ATTRIBUTE_NAME = "EnclosingMethod";
  private final CstNat method;
  private final CstType type;
  
  public AttEnclosingMethod(CstType paramCstType, CstNat paramCstNat)
  {
    super("EnclosingMethod");
    if (paramCstType == null) {
      throw new NullPointerException("type == null");
    }
    this.type = paramCstType;
    this.method = paramCstNat;
  }
  
  public int byteLength()
  {
    return 10;
  }
  
  public CstType getEnclosingClass()
  {
    return this.type;
  }
  
  public CstNat getMethod()
  {
    return this.method;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.attrib.AttEnclosingMethod
 * JD-Core Version:    0.7.0.1
 */