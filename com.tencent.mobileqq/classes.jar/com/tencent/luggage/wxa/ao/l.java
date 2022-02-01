package com.tencent.luggage.wxa.ao;

public final class l
{
  public byte[] a;
  private int b;
  private int c;
  private int d;
  
  public l() {}
  
  public l(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public l(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = paramArrayOfByte;
    this.d = paramInt;
  }
  
  private void g()
  {
    int i = this.b;
    if (i >= 0)
    {
      int j = this.d;
      if ((i < j) || ((i == j) && (this.c == 0)))
      {
        bool = true;
        break label38;
      }
    }
    boolean bool = false;
    label38:
    a.b(bool);
  }
  
  public int a()
  {
    return (this.d - this.b) * 8 - this.c;
  }
  
  public void a(int paramInt)
  {
    this.b = (paramInt / 8);
    this.c = (paramInt - this.b * 8);
    g();
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = paramArrayOfByte;
    this.b = 0;
    this.c = 0;
    this.d = paramInt;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (this.c == 0) {
      bool = true;
    } else {
      bool = false;
    }
    a.b(bool);
    System.arraycopy(this.a, this.b, paramArrayOfByte, paramInt1, paramInt2);
    this.b += paramInt2;
    g();
  }
  
  public int b()
  {
    return this.b * 8 + this.c;
  }
  
  public void b(int paramInt)
  {
    int i = paramInt / 8;
    this.b += i;
    this.c += paramInt - i * 8;
    paramInt = this.c;
    if (paramInt > 7)
    {
      this.b += 1;
      this.c = (paramInt - 8);
    }
    g();
  }
  
  public int c()
  {
    boolean bool;
    if (this.c == 0) {
      bool = true;
    } else {
      bool = false;
    }
    a.b(bool);
    return this.b;
  }
  
  public int c(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    this.c += paramInt;
    int i = 0;
    int j;
    for (;;)
    {
      j = this.c;
      if (j <= 8) {
        break;
      }
      this.c = (j - 8);
      arrayOfByte = this.a;
      j = this.b;
      this.b = (j + 1);
      i |= (arrayOfByte[j] & 0xFF) << this.c;
    }
    byte[] arrayOfByte = this.a;
    int k = this.b;
    int m = arrayOfByte[k];
    if (j == 8)
    {
      this.c = 0;
      this.b = (k + 1);
    }
    g();
    return -1 >>> 32 - paramInt & (i | (m & 0xFF) >> 8 - j);
  }
  
  public void d()
  {
    int i = this.c + 1;
    this.c = i;
    if (i == 8)
    {
      this.c = 0;
      this.b += 1;
    }
    g();
  }
  
  public void d(int paramInt)
  {
    boolean bool;
    if (this.c == 0) {
      bool = true;
    } else {
      bool = false;
    }
    a.b(bool);
    this.b += paramInt;
    g();
  }
  
  public boolean e()
  {
    boolean bool;
    if ((this.a[this.b] & 128 >> this.c) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    d();
    return bool;
  }
  
  public void f()
  {
    if (this.c == 0) {
      return;
    }
    this.c = 0;
    this.b += 1;
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.l
 * JD-Core Version:    0.7.0.1
 */