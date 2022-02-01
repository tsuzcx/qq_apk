package com.android.dx.cf.code;

public class LineNumberList$Item
{
  private final int lineNumber;
  private final int startPc;
  
  public LineNumberList$Item(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("startPc < 0");
    }
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("lineNumber < 0");
    }
    this.startPc = paramInt1;
    this.lineNumber = paramInt2;
  }
  
  public int getLineNumber()
  {
    return this.lineNumber;
  }
  
  public int getStartPc()
  {
    return this.startPc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.LineNumberList.Item
 * JD-Core Version:    0.7.0.1
 */