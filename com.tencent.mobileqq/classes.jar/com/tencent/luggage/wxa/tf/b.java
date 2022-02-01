package com.tencent.luggage.wxa.tf;

import java.io.InputStream;

public class b
{
  int a;
  int b;
  InputStream c;
  
  public static void a(short[] paramArrayOfShort)
  {
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      paramArrayOfShort[i] = 1024;
      i += 1;
    }
  }
  
  public final int a(int paramInt)
  {
    int i = 0;
    while (paramInt != 0)
    {
      this.a >>>= 1;
      int k = this.b;
      int j = this.a;
      int m = k - j >>> 31;
      this.b = (k - (m - 1 & j));
      i = i << 1 | 1 - m;
      if ((0xFF000000 & j) == 0)
      {
        this.b = (this.b << 8 | this.c.read());
        this.a <<= 8;
      }
      paramInt -= 1;
    }
    return i;
  }
  
  public int a(short[] paramArrayOfShort, int paramInt)
  {
    int i = paramArrayOfShort[paramInt];
    int j = this.a;
    int k = (j >>> 11) * i;
    int m = this.b;
    if ((m ^ 0x80000000) < (0x80000000 ^ k))
    {
      this.a = k;
      paramArrayOfShort[paramInt] = ((short)(i + (2048 - i >>> 5)));
      if ((this.a & 0xFF000000) == 0)
      {
        this.b = (m << 8 | this.c.read());
        this.a <<= 8;
      }
      return 0;
    }
    this.a = (j - k);
    this.b = (m - k);
    paramArrayOfShort[paramInt] = ((short)(i - (i >>> 5)));
    if ((this.a & 0xFF000000) == 0)
    {
      this.b = (this.b << 8 | this.c.read());
      this.a <<= 8;
    }
    return 1;
  }
  
  public final void a()
  {
    this.c = null;
  }
  
  public final void a(InputStream paramInputStream)
  {
    this.c = paramInputStream;
  }
  
  public final void b()
  {
    int i = 0;
    this.b = 0;
    this.a = -1;
    while (i < 5)
    {
      this.b = (this.b << 8 | this.c.read());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.tf.b
 * JD-Core Version:    0.7.0.1
 */