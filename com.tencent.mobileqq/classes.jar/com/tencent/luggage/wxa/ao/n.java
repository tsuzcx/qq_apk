package com.tencent.luggage.wxa.ao;

public final class n
{
  private byte[] a;
  private int b;
  private int c;
  private int d;
  
  public n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private boolean d(int paramInt)
  {
    if ((2 <= paramInt) && (paramInt < this.b))
    {
      byte[] arrayOfByte = this.a;
      if ((arrayOfByte[paramInt] == 3) && (arrayOfByte[(paramInt - 2)] == 0) && (arrayOfByte[(paramInt - 1)] == 0)) {
        return true;
      }
    }
    return false;
  }
  
  private int f()
  {
    int j = 0;
    int i = 0;
    while (!b()) {
      i += 1;
    }
    if (i > 0) {
      j = c(i);
    }
    return (1 << i) - 1 + j;
  }
  
  private void g()
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
  
  public void a()
  {
    int j = this.d;
    int i = 1;
    j += 1;
    this.d = j;
    if (j == 8)
    {
      this.d = 0;
      j = this.c;
      if (d(j + 1)) {
        i = 2;
      }
      this.c = (j + i);
    }
    g();
  }
  
  public void a(int paramInt)
  {
    int i = this.c;
    int j = paramInt / 8;
    this.c = (i + j);
    this.d += paramInt - j * 8;
    j = this.d;
    paramInt = i;
    if (j > 7)
    {
      this.c += 1;
      this.d = (j - 8);
      paramInt = i;
    }
    for (;;)
    {
      i = paramInt + 1;
      if (i > this.c) {
        break;
      }
      paramInt = i;
      if (d(i))
      {
        this.c += 1;
        paramInt = i + 2;
      }
    }
    g();
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.c = paramInt1;
    this.b = paramInt2;
    this.d = 0;
    g();
  }
  
  public boolean b()
  {
    boolean bool;
    if ((this.a[this.c] & 128 >> this.d) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    a();
    return bool;
  }
  
  public boolean b(int paramInt)
  {
    int k = this.c;
    int i = paramInt / 8;
    int j = k + i;
    int m = this.d + paramInt - i * 8;
    paramInt = j;
    i = m;
    if (m > 7)
    {
      paramInt = j + 1;
      i = m - 8;
    }
    boolean bool = true;
    j = paramInt;
    paramInt = k;
    for (;;)
    {
      k = paramInt + 1;
      if ((k > j) || (j >= this.b)) {
        break;
      }
      paramInt = k;
      if (d(k))
      {
        j += 1;
        paramInt = k + 2;
      }
    }
    paramInt = this.b;
    if (j >= paramInt)
    {
      if ((j == paramInt) && (i == 0)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public int c(int paramInt)
  {
    this.d += paramInt;
    int i = 0;
    int k;
    int j;
    for (;;)
    {
      k = this.d;
      j = 2;
      if (k <= 8) {
        break;
      }
      this.d = (k - 8);
      arrayOfByte = this.a;
      k = this.c;
      i |= (arrayOfByte[k] & 0xFF) << this.d;
      if (!d(k + 1)) {
        j = 1;
      }
      this.c = (k + j);
    }
    byte[] arrayOfByte = this.a;
    int m = this.c;
    int n = arrayOfByte[m];
    if (k == 8)
    {
      this.d = 0;
      if (!d(m + 1)) {
        j = 1;
      }
      this.c = (m + j);
    }
    g();
    return -1 >>> 32 - paramInt & (i | (n & 0xFF) >> 8 - k);
  }
  
  public boolean c()
  {
    int k = this.c;
    int m = this.d;
    boolean bool2 = false;
    int i = 0;
    while ((this.c < this.b) && (!b())) {
      i += 1;
    }
    int j;
    if (this.c == this.b) {
      j = 1;
    } else {
      j = 0;
    }
    this.c = k;
    this.d = m;
    boolean bool1 = bool2;
    if (j == 0)
    {
      bool1 = bool2;
      if (b(i * 2 + 1)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int d()
  {
    return f();
  }
  
  public int e()
  {
    int j = f();
    int i;
    if (j % 2 == 0) {
      i = -1;
    } else {
      i = 1;
    }
    return i * ((j + 1) / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.n
 * JD-Core Version:    0.7.0.1
 */