package com.tencent.luggage.wxa.n;

import com.tencent.luggage.wxa.l.e;

final class f
{
  private static final long[] a = { 128L, 64L, 32L, 16L, 8L, 4L, 2L, 1L };
  private final byte[] b = new byte[8];
  private int c;
  private int d;
  
  public static int a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      long[] arrayOfLong = a;
      if (i >= arrayOfLong.length) {
        break;
      }
      if ((arrayOfLong[i] & paramInt) != 0L) {
        return i + 1;
      }
      i += 1;
    }
    return -1;
  }
  
  public static long a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    long l2 = paramArrayOfByte[0] & 0xFF;
    long l1 = l2;
    if (paramBoolean) {
      l1 = l2 & (a[(paramInt - 1)] ^ 0xFFFFFFFF);
    }
    int i = 1;
    while (i < paramInt)
    {
      l1 = l1 << 8 | paramArrayOfByte[i] & 0xFF;
      i += 1;
    }
    return l1;
  }
  
  public long a(e parame, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.c == 0)
    {
      if (!parame.a(this.b, 0, 1, paramBoolean1)) {
        return -1L;
      }
      this.d = a(this.b[0] & 0xFF);
      if (this.d != -1) {
        this.c = 1;
      } else {
        throw new IllegalStateException("No valid varint length mask found");
      }
    }
    int i = this.d;
    if (i > paramInt)
    {
      this.c = 0;
      return -2L;
    }
    if (i != 1) {
      parame.b(this.b, 1, i - 1);
    }
    this.c = 0;
    return a(this.b, this.d, paramBoolean2);
  }
  
  public void a()
  {
    this.c = 0;
    this.d = 0;
  }
  
  public int b()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.n.f
 * JD-Core Version:    0.7.0.1
 */