package com.android.dx.cf.attrib;

import com.android.dx.rop.cst.CstString;

public final class AttSignature
  extends BaseAttribute
{
  public static final String ATTRIBUTE_NAME = "Signature";
  private final CstString signature;
  
  public AttSignature(CstString paramCstString)
  {
    super("Signature");
    if (paramCstString == null) {
      throw new NullPointerException("signature == null");
    }
    this.signature = paramCstString;
  }
  
  public int byteLength()
  {
    return 8;
  }
  
  public CstString getSignature()
  {
    return this.signature;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.attrib.AttSignature
 * JD-Core Version:    0.7.0.1
 */