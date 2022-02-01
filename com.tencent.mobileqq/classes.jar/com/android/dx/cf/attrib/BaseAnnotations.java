package com.android.dx.cf.attrib;

import com.android.dx.rop.annotation.Annotations;
import com.android.dx.util.MutabilityException;

public abstract class BaseAnnotations
  extends BaseAttribute
{
  private final Annotations annotations;
  private final int byteLength;
  
  public BaseAnnotations(String paramString, Annotations paramAnnotations, int paramInt)
  {
    super(paramString);
    try
    {
      if (paramAnnotations.isMutable()) {
        throw new MutabilityException("annotations.isMutable()");
      }
    }
    catch (NullPointerException paramString)
    {
      throw new NullPointerException("annotations == null");
    }
    this.annotations = paramAnnotations;
    this.byteLength = paramInt;
  }
  
  public final int byteLength()
  {
    return this.byteLength + 6;
  }
  
  public final Annotations getAnnotations()
  {
    return this.annotations;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.attrib.BaseAnnotations
 * JD-Core Version:    0.7.0.1
 */