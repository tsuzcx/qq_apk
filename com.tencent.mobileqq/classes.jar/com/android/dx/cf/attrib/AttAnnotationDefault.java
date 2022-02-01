package com.android.dx.cf.attrib;

import com.android.dx.rop.cst.Constant;

public final class AttAnnotationDefault
  extends BaseAttribute
{
  public static final String ATTRIBUTE_NAME = "AnnotationDefault";
  private final int byteLength;
  private final Constant value;
  
  public AttAnnotationDefault(Constant paramConstant, int paramInt)
  {
    super("AnnotationDefault");
    if (paramConstant == null) {
      throw new NullPointerException("value == null");
    }
    this.value = paramConstant;
    this.byteLength = paramInt;
  }
  
  public int byteLength()
  {
    return this.byteLength + 6;
  }
  
  public Constant getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.attrib.AttAnnotationDefault
 * JD-Core Version:    0.7.0.1
 */