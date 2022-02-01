package com.android.dx.cf.attrib;

import com.android.dx.rop.annotation.AnnotationsList;
import com.android.dx.util.MutabilityException;

public abstract class BaseParameterAnnotations
  extends BaseAttribute
{
  private final int byteLength;
  private final AnnotationsList parameterAnnotations;
  
  public BaseParameterAnnotations(String paramString, AnnotationsList paramAnnotationsList, int paramInt)
  {
    super(paramString);
    try
    {
      if (paramAnnotationsList.isMutable()) {
        throw new MutabilityException("parameterAnnotations.isMutable()");
      }
    }
    catch (NullPointerException paramString)
    {
      throw new NullPointerException("parameterAnnotations == null");
    }
    this.parameterAnnotations = paramAnnotationsList;
    this.byteLength = paramInt;
  }
  
  public final int byteLength()
  {
    return this.byteLength + 6;
  }
  
  public final AnnotationsList getParameterAnnotations()
  {
    return this.parameterAnnotations;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.attrib.BaseParameterAnnotations
 * JD-Core Version:    0.7.0.1
 */