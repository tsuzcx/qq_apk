package com.tencent.luggage.wxa.ao;

import com.tencent.luggage.wxa.t.b;
import java.nio.charset.Charset;

public final class m
{
  public byte[] a;
  private int b;
  private int c;
  
  public m() {}
  
  public m(int paramInt)
  {
    this.a = new byte[paramInt];
    this.c = paramInt;
  }
  
  public m(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    this.c = paramArrayOfByte.length;
  }
  
  public m(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = paramArrayOfByte;
    this.c = paramInt;
  }
  
  public String a(int paramInt, Charset paramCharset)
  {
    paramCharset = new String(this.a, this.b, paramInt, paramCharset);
    this.b += paramInt;
    return paramCharset;
  }
  
  public void a()
  {
    this.b = 0;
    this.c = 0;
  }
  
  public void a(int paramInt)
  {
    byte[] arrayOfByte;
    if (e() < paramInt) {
      arrayOfByte = new byte[paramInt];
    } else {
      arrayOfByte = this.a;
    }
    a(arrayOfByte, paramInt);
  }
  
  public void a(l paraml, int paramInt)
  {
    a(paraml.a, 0, paramInt);
    paraml.a(0);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = paramArrayOfByte;
    this.c = paramInt;
    this.b = 0;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    System.arraycopy(this.a, this.b, paramArrayOfByte, paramInt1, paramInt2);
    this.b += paramInt2;
  }
  
  public int b()
  {
    return this.c - this.b;
  }
  
  public void b(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 0) && (paramInt <= this.a.length)) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(bool);
    this.c = paramInt;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void c(int paramInt)
  {
    boolean bool = true;
    if ((paramInt < 0) || (paramInt > this.c)) {
      b.a("ExoPlayer", "position%d, limit:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.c) });
    }
    if ((paramInt < 0) || (paramInt > this.c)) {
      bool = false;
    }
    a.a(bool);
    this.b = paramInt;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public void d(int paramInt)
  {
    c(this.b + paramInt);
  }
  
  public int e()
  {
    byte[] arrayOfByte = this.a;
    if (arrayOfByte == null) {
      return 0;
    }
    return arrayOfByte.length;
  }
  
  public String e(int paramInt)
  {
    return a(paramInt, Charset.forName("UTF-8"));
  }
  
  public char f()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    int j = arrayOfByte[i];
    return (char)(arrayOfByte[(i + 1)] & 0xFF | (j & 0xFF) << 8);
  }
  
  public String f(int paramInt)
  {
    if (paramInt == 0) {
      return "";
    }
    int i = this.b + paramInt - 1;
    if ((i < this.c) && (this.a[i] == 0)) {
      i = paramInt - 1;
    } else {
      i = paramInt;
    }
    String str = new String(this.a, this.b, i);
    this.b += paramInt;
    return str;
  }
  
  public int g()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public int h()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    i = arrayOfByte[i];
    int j = this.b;
    this.b = (j + 1);
    return arrayOfByte[j] & 0xFF | (i & 0xFF) << 8;
  }
  
  public int i()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    i = arrayOfByte[i];
    int j = this.b;
    this.b = (j + 1);
    return (arrayOfByte[j] & 0xFF) << 8 | i & 0xFF;
  }
  
  public short j()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    i = arrayOfByte[i];
    int j = this.b;
    this.b = (j + 1);
    return (short)(arrayOfByte[j] & 0xFF | (i & 0xFF) << 8);
  }
  
  public int k()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    i = arrayOfByte[i];
    int j = this.b;
    this.b = (j + 1);
    j = arrayOfByte[j];
    int k = this.b;
    this.b = (k + 1);
    return arrayOfByte[k] & 0xFF | (i & 0xFF) << 16 | (j & 0xFF) << 8;
  }
  
  public long l()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    long l1 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    long l2 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    long l3 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    return (l1 & 0xFF) << 24 | (l2 & 0xFF) << 16 | (l3 & 0xFF) << 8 | 0xFF & arrayOfByte[i];
  }
  
  public long m()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    long l1 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    long l2 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    long l3 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    return l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (0xFF & arrayOfByte[i]) << 24;
  }
  
  public int n()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    i = arrayOfByte[i];
    int j = this.b;
    this.b = (j + 1);
    j = arrayOfByte[j];
    int k = this.b;
    this.b = (k + 1);
    k = arrayOfByte[k];
    int m = this.b;
    this.b = (m + 1);
    return arrayOfByte[m] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  public int o()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    i = arrayOfByte[i];
    int j = this.b;
    this.b = (j + 1);
    j = arrayOfByte[j];
    int k = this.b;
    this.b = (k + 1);
    k = arrayOfByte[k];
    int m = this.b;
    this.b = (m + 1);
    return (arrayOfByte[m] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  public long p()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    long l1 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    long l2 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    long l3 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    long l4 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    long l5 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    long l6 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    long l7 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    return (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | 0xFF & arrayOfByte[i];
  }
  
  public long q()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    long l1 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    long l2 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    long l3 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    long l4 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    long l5 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    long l6 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    long l7 = arrayOfByte[i];
    i = this.b;
    this.b = (i + 1);
    return l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48 | (0xFF & arrayOfByte[i]) << 56;
  }
  
  public int r()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    i = arrayOfByte[i];
    int j = this.b;
    this.b = (j + 1);
    j = arrayOfByte[j];
    this.b += 2;
    return j & 0xFF | (i & 0xFF) << 8;
  }
  
  public int s()
  {
    return g() << 21 | g() << 14 | g() << 7 | g();
  }
  
  public int t()
  {
    int i = n();
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Top bit not zero: ");
    localStringBuilder.append(i);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public int u()
  {
    int i = o();
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Top bit not zero: ");
    localStringBuilder.append(i);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public long v()
  {
    long l = p();
    if (l >= 0L) {
      return l;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Top bit not zero: ");
    localStringBuilder.append(l);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public double w()
  {
    return Double.longBitsToDouble(p());
  }
  
  public String x()
  {
    if (b() == 0) {
      return null;
    }
    int i = this.b;
    while ((i < this.c) && (this.a[i] != 0)) {
      i += 1;
    }
    Object localObject = this.a;
    int j = this.b;
    localObject = new String((byte[])localObject, j, i - j);
    this.b = i;
    i = this.b;
    if (i < this.c) {
      this.b = (i + 1);
    }
    return localObject;
  }
  
  public String y()
  {
    if (b() == 0) {
      return null;
    }
    int i = this.b;
    while ((i < this.c) && (!x.a(this.a[i]))) {
      i += 1;
    }
    int j = this.b;
    if (i - j >= 3)
    {
      localObject = this.a;
      if ((localObject[j] == -17) && (localObject[(j + 1)] == -69) && (localObject[(j + 2)] == -65)) {
        this.b = (j + 3);
      }
    }
    Object localObject = this.a;
    j = this.b;
    localObject = new String((byte[])localObject, j, i - j);
    this.b = i;
    i = this.b;
    j = this.c;
    if (i == j) {
      return localObject;
    }
    if (this.a[i] == 13)
    {
      this.b = (i + 1);
      if (this.b == j) {
        return localObject;
      }
    }
    byte[] arrayOfByte = this.a;
    i = this.b;
    if (arrayOfByte[i] == 10) {
      this.b = (i + 1);
    }
    return localObject;
  }
  
  public long z()
  {
    long l = this.a[this.b];
    int i = 7;
    int j;
    int k;
    for (;;)
    {
      j = 1;
      if (i < 0) {
        break;
      }
      k = 1 << i;
      if ((k & l) == 0L)
      {
        if (i < 6)
        {
          l &= k - 1;
          i = 7 - i;
          break label78;
        }
        if (i != 7) {
          break;
        }
        i = 1;
        break label78;
      }
      i -= 1;
    }
    i = 0;
    label78:
    if (i != 0)
    {
      while (j < i)
      {
        k = this.a[(this.b + j)];
        if ((k & 0xC0) == 128)
        {
          l = l << 6 | k & 0x3F;
          j += 1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid UTF-8 sequence continuation byte: ");
          ((StringBuilder)localObject).append(l);
          throw new NumberFormatException(((StringBuilder)localObject).toString());
        }
      }
      this.b += i;
      return l;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid UTF-8 sequence first byte: ");
    ((StringBuilder)localObject).append(l);
    localObject = new NumberFormatException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.m
 * JD-Core Version:    0.7.0.1
 */