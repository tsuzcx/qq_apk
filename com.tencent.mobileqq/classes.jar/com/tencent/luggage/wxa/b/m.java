package com.tencent.luggage.wxa.b;

import java.io.Writer;

class m
  extends Writer
{
  private final Writer a;
  private final char[] b;
  private int c = 0;
  
  m(Writer paramWriter, int paramInt)
  {
    this.a = paramWriter;
    this.b = new char[paramInt];
  }
  
  public void close() {}
  
  public void flush()
  {
    this.a.write(this.b, 0, this.c);
    this.c = 0;
  }
  
  public void write(int paramInt)
  {
    if (this.c > this.b.length - 1) {
      flush();
    }
    char[] arrayOfChar = this.b;
    int i = this.c;
    this.c = (i + 1);
    arrayOfChar[i] = ((char)paramInt);
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
  {
    if (this.c > this.b.length - paramInt2)
    {
      flush();
      if (paramInt2 > this.b.length)
      {
        this.a.write(paramString, paramInt1, paramInt2);
        return;
      }
    }
    paramString.getChars(paramInt1, paramInt1 + paramInt2, this.b, this.c);
    this.c += paramInt2;
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.c > this.b.length - paramInt2)
    {
      flush();
      if (paramInt2 > this.b.length)
      {
        this.a.write(paramArrayOfChar, paramInt1, paramInt2);
        return;
      }
    }
    System.arraycopy(paramArrayOfChar, paramInt1, this.b, this.c, paramInt2);
    this.c += paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.b.m
 * JD-Core Version:    0.7.0.1
 */