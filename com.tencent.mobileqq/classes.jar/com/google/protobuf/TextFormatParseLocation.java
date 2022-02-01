package com.google.protobuf;

import java.util.Arrays;

public final class TextFormatParseLocation
{
  public static final TextFormatParseLocation a = new TextFormatParseLocation(-1, -1);
  private final int b;
  private final int c;
  
  private TextFormatParseLocation(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof TextFormatParseLocation)) {
      return false;
    }
    paramObject = (TextFormatParseLocation)paramObject;
    return (this.b == paramObject.a()) && (this.c == paramObject.b());
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new int[] { this.b, this.c });
  }
  
  public String toString()
  {
    return String.format("ParseLocation{line=%d, column=%d}", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.c) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.TextFormatParseLocation
 * JD-Core Version:    0.7.0.1
 */