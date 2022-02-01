package com.android.dx.rop.cst;

import com.android.dx.rop.annotation.Annotation;

public final class CstAnnotation
  extends Constant
{
  private final Annotation annotation;
  
  public CstAnnotation(Annotation paramAnnotation)
  {
    if (paramAnnotation == null) {
      throw new NullPointerException("annotation == null");
    }
    paramAnnotation.throwIfMutable();
    this.annotation = paramAnnotation;
  }
  
  protected int compareTo0(Constant paramConstant)
  {
    return this.annotation.compareTo(((CstAnnotation)paramConstant).annotation);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CstAnnotation)) {
      return false;
    }
    return this.annotation.equals(((CstAnnotation)paramObject).annotation);
  }
  
  public Annotation getAnnotation()
  {
    return this.annotation;
  }
  
  public int hashCode()
  {
    return this.annotation.hashCode();
  }
  
  public boolean isCategory2()
  {
    return false;
  }
  
  public String toHuman()
  {
    return this.annotation.toString();
  }
  
  public String toString()
  {
    return this.annotation.toString();
  }
  
  public String typeName()
  {
    return "annotation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstAnnotation
 * JD-Core Version:    0.7.0.1
 */