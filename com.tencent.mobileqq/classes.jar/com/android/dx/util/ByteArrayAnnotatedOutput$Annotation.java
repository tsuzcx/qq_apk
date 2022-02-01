package com.android.dx.util;

class ByteArrayAnnotatedOutput$Annotation
{
  private int end;
  private final int start;
  private final String text;
  
  public ByteArrayAnnotatedOutput$Annotation(int paramInt1, int paramInt2, String paramString)
  {
    this.start = paramInt1;
    this.end = paramInt2;
    this.text = paramString;
  }
  
  public ByteArrayAnnotatedOutput$Annotation(int paramInt, String paramString)
  {
    this(paramInt, 2147483647, paramString);
  }
  
  public int getEnd()
  {
    return this.end;
  }
  
  public int getStart()
  {
    return this.start;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public void setEnd(int paramInt)
  {
    this.end = paramInt;
  }
  
  public void setEndIfUnset(int paramInt)
  {
    if (this.end == 2147483647) {
      this.end = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.ByteArrayAnnotatedOutput.Annotation
 * JD-Core Version:    0.7.0.1
 */