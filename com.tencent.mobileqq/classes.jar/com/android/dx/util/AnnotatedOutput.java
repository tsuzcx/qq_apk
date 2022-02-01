package com.android.dx.util;

public abstract interface AnnotatedOutput
  extends Output
{
  public abstract void annotate(int paramInt, String paramString);
  
  public abstract void annotate(String paramString);
  
  public abstract boolean annotates();
  
  public abstract void endAnnotation();
  
  public abstract int getAnnotationWidth();
  
  public abstract boolean isVerbose();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.AnnotatedOutput
 * JD-Core Version:    0.7.0.1
 */