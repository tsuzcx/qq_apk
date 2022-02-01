package com.tencent.luggage.wxa.q;

import com.tencent.luggage.wxa.ao.a;

final class i
{
  private final byte[] a;
  private final int b;
  private int c;
  private int d;
  
  public i(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    this.b = paramArrayOfByte.length;
  }
  
  private void c()
  {
    int i = this.c;
    if (i >= 0)
    {
      int j = this.b;
      if ((i < j) || ((i == j) && (this.d == 0)))
      {
        bool = true;
        break label38;
      }
    }
    boolean bool = false;
    label38:
    a.b(bool);
  }
  
  public int a(int paramInt)
  {
    int k = this.c;
    int j = Math.min(paramInt, 8 - this.d);
    byte[] arrayOfByte = this.a;
    int i = k + 1;
    k = (arrayOfByte[k] & 0xFF) >> this.d & 255 >> 8 - j;
    while (j < paramInt)
    {
      k |= (this.a[i] & 0xFF) << j;
      j += 8;
      i += 1;
    }
    b(paramInt);
    return k & -1 >>> 32 - paramInt;
  }
  
  public boolean a()
  {
    boolean bool;
    if (((this.a[this.c] & 0xFF) >> this.d & 0x1) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    b(1);
    return bool;
  }
  
  public int b()
  {
    return this.c * 8 + this.d;
  }
  
  public void b(int paramInt)
  {
    int i = paramInt / 8;
    this.c += i;
    this.d += paramInt - i * 8;
    paramInt = this.d;
    if (paramInt > 7)
    {
      this.c += 1;
      this.d = (paramInt - 8);
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.q.i
 * JD-Core Version:    0.7.0.1
 */