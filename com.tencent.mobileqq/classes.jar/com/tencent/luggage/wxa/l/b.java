package com.tencent.luggage.wxa.l;

import com.tencent.luggage.wxa.am.g;
import com.tencent.luggage.wxa.ao.x;
import java.io.EOFException;
import java.util.Arrays;

public final class b
  implements e
{
  private static final byte[] a = new byte[4096];
  private final g b;
  private final long c;
  private long d;
  private byte[] e;
  private int f;
  private int g;
  
  public b(g paramg, long paramLong1, long paramLong2)
  {
    this.b = paramg;
    this.d = paramLong1;
    this.c = paramLong2;
    this.e = new byte[65536];
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!Thread.interrupted())
    {
      paramInt1 = this.b.a(paramArrayOfByte, paramInt1 + paramInt3, paramInt2 - paramInt3);
      if (paramInt1 == -1)
      {
        if ((paramInt3 == 0) && (paramBoolean)) {
          return -1;
        }
        throw new EOFException();
      }
      return paramInt3 + paramInt1;
    }
    throw new InterruptedException();
  }
  
  private int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.g;
    if (i == 0) {
      return 0;
    }
    paramInt2 = Math.min(i, paramInt2);
    System.arraycopy(this.e, 0, paramArrayOfByte, paramInt1, paramInt2);
    f(paramInt2);
    return paramInt2;
  }
  
  private void d(int paramInt)
  {
    paramInt = this.f + paramInt;
    byte[] arrayOfByte = this.e;
    if (paramInt > arrayOfByte.length)
    {
      paramInt = x.a(arrayOfByte.length * 2, 65536 + paramInt, paramInt + 524288);
      this.e = Arrays.copyOf(this.e, paramInt);
    }
  }
  
  private int e(int paramInt)
  {
    paramInt = Math.min(this.g, paramInt);
    f(paramInt);
    return paramInt;
  }
  
  private void f(int paramInt)
  {
    this.g -= paramInt;
    this.f = 0;
    byte[] arrayOfByte2 = this.e;
    int i = this.g;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (i < arrayOfByte2.length - 524288) {
      arrayOfByte1 = new byte[i + 65536];
    }
    System.arraycopy(this.e, paramInt, arrayOfByte1, 0, this.g);
    this.e = arrayOfByte1;
  }
  
  private void g(int paramInt)
  {
    if (paramInt != -1) {
      this.d += paramInt;
    }
  }
  
  public int a(int paramInt)
  {
    int j = e(paramInt);
    int i = j;
    if (j == 0)
    {
      byte[] arrayOfByte = a;
      i = a(arrayOfByte, 0, Math.min(paramInt, arrayOfByte.length), 0, true);
    }
    g(i);
    return i;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = d(paramArrayOfByte, paramInt1, paramInt2);
    int i = j;
    if (j == 0) {
      i = a(paramArrayOfByte, paramInt1, paramInt2, 0, true);
    }
    g(i);
    return i;
  }
  
  public void a()
  {
    this.f = 0;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    byte[] arrayOfByte;
    for (int i = e(paramInt); (i < paramInt) && (i != -1); i = a(arrayOfByte, -i, Math.min(paramInt, arrayOfByte.length + i), i, paramBoolean)) {
      arrayOfByte = a;
    }
    g(i);
    return i != -1;
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    for (int i = d(paramArrayOfByte, paramInt1, paramInt2); (i < paramInt2) && (i != -1); i = a(paramArrayOfByte, paramInt1, paramInt2, i, paramBoolean)) {}
    g(i);
    return i != -1;
  }
  
  public long b()
  {
    return this.d + this.f;
  }
  
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a(paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  public boolean b(int paramInt, boolean paramBoolean)
  {
    d(paramInt);
    int i = Math.min(this.g - this.f, paramInt);
    while (i < paramInt)
    {
      int j = a(this.e, this.f, paramInt, i, paramBoolean);
      i = j;
      if (j == -1) {
        return false;
      }
    }
    this.f += paramInt;
    this.g = Math.max(this.g, this.f);
    return true;
  }
  
  public boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!b(paramInt2, paramBoolean)) {
      return false;
    }
    System.arraycopy(this.e, this.f - paramInt2, paramArrayOfByte, paramInt1, paramInt2);
    return true;
  }
  
  public long c()
  {
    return this.d;
  }
  
  public void c(int paramInt)
  {
    b(paramInt, false);
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b(paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  public long d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.l.b
 * JD-Core Version:    0.7.0.1
 */