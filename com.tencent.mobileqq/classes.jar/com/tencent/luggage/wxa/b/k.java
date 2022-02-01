package com.tencent.luggage.wxa.b;

import java.io.Writer;
import java.util.Arrays;

public class k
  extends l
{
  private final char[] c;
  
  protected k(char[] paramArrayOfChar)
  {
    this.c = paramArrayOfChar;
  }
  
  public static k a(int paramInt)
  {
    if (paramInt >= 0)
    {
      char[] arrayOfChar = new char[paramInt];
      Arrays.fill(arrayOfChar, ' ');
      return new k(arrayOfChar);
    }
    throw new IllegalArgumentException("number is negative");
  }
  
  protected i a(Writer paramWriter)
  {
    return new k.a(paramWriter, this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.b.k
 * JD-Core Version:    0.7.0.1
 */