package com.tencent.luggage.wxa.n;

import com.tencent.luggage.wxa.ao.m;

final class e
{
  private final m a = new m(8);
  private int b;
  
  private long b(com.tencent.luggage.wxa.l.e parame)
  {
    byte[] arrayOfByte = this.a.a;
    int k = 0;
    parame.c(arrayOfByte, 0, 1);
    int m = this.a.a[0] & 0xFF;
    if (m == 0) {
      return -9223372036854775808L;
    }
    int j = 128;
    int i = 0;
    while ((m & j) == 0)
    {
      j >>= 1;
      i += 1;
    }
    j = m & (j ^ 0xFFFFFFFF);
    parame.c(this.a.a, 1, i);
    while (k < i)
    {
      parame = this.a.a;
      k += 1;
      j = (parame[k] & 0xFF) + (j << 8);
    }
    this.b += i + 1;
    return j;
  }
  
  public boolean a(com.tencent.luggage.wxa.l.e parame)
  {
    long l2 = parame.d();
    long l3 = 1024L;
    long l1 = l3;
    if (l2 != -1L) {
      if (l2 > 1024L) {
        l1 = l3;
      } else {
        l1 = l2;
      }
    }
    int i = (int)l1;
    parame.c(this.a.a, 0, 4);
    l1 = this.a.l();
    this.b = 4;
    while (l1 != 440786851L)
    {
      int j = this.b + 1;
      this.b = j;
      if (j == i) {
        return false;
      }
      parame.c(this.a.a, 0, 1);
      l1 = l1 << 8 & 0xFFFFFF00 | this.a.a[0] & 0xFF;
    }
    l1 = b(parame);
    l3 = this.b;
    if (l1 != -9223372036854775808L)
    {
      if ((l2 != -1L) && (l3 + l1 >= l2)) {
        return false;
      }
      long l4;
      for (;;)
      {
        i = this.b;
        l2 = i;
        l4 = l3 + l1;
        if (l2 >= l4) {
          break label293;
        }
        if (b(parame) == -9223372036854775808L) {
          return false;
        }
        l2 = b(parame);
        if (l2 < 0L) {
          break;
        }
        if (l2 > 2147483647L) {
          return false;
        }
        if (l2 != 0L)
        {
          parame.c((int)l2);
          this.b = ((int)(this.b + l2));
        }
      }
      return false;
      label293:
      return i == l4;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.n.e
 * JD-Core Version:    0.7.0.1
 */