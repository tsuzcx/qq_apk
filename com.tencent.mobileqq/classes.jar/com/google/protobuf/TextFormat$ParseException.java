package com.google.protobuf;

import java.io.IOException;

public class TextFormat$ParseException
  extends IOException
{
  private static final long serialVersionUID = 3196188060225107702L;
  private final int column;
  private final int line;
  
  public TextFormat$ParseException(int paramInt1, int paramInt2, String paramString)
  {
    super(localStringBuilder.toString());
    this.line = paramInt1;
    this.column = paramInt2;
  }
  
  public TextFormat$ParseException(String paramString)
  {
    this(-1, -1, paramString);
  }
  
  public int getColumn()
  {
    return this.column;
  }
  
  public int getLine()
  {
    return this.line;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.TextFormat.ParseException
 * JD-Core Version:    0.7.0.1
 */