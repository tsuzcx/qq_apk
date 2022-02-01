package com.tencent.luggage.wxa.i;

import com.tencent.luggage.wxa.ao.a;
import java.nio.ShortBuffer;
import java.util.Arrays;

final class k
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final short[] f;
  private int g;
  private short[] h;
  private int i;
  private short[] j;
  private int k;
  private short[] l;
  private int m;
  private int n;
  private float o;
  private float p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  
  public k(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = (paramInt1 / 400);
    this.d = (paramInt1 / 65);
    this.e = (this.d * 2);
    paramInt1 = this.e;
    this.f = new short[paramInt1];
    this.g = paramInt1;
    this.h = new short[paramInt1 * paramInt2];
    this.i = paramInt1;
    this.j = new short[paramInt1 * paramInt2];
    this.k = paramInt1;
    this.l = new short[paramInt1 * paramInt2];
    this.m = 0;
    this.n = 0;
    this.u = 0;
    this.o = 1.0F;
    this.p = 1.0F;
  }
  
  private int a(short[] paramArrayOfShort, int paramInt1, float paramFloat, int paramInt2)
  {
    int i1;
    if (paramFloat >= 2.0F)
    {
      i1 = (int)(paramInt2 / (paramFloat - 1.0F));
    }
    else
    {
      this.t = ((int)(paramInt2 * (2.0F - paramFloat) / (paramFloat - 1.0F)));
      i1 = paramInt2;
    }
    a(i1);
    a(i1, this.b, this.j, this.r, paramArrayOfShort, paramInt1, paramArrayOfShort, paramInt1 + paramInt2);
    this.r += i1;
    return i1;
  }
  
  private int a(short[] paramArrayOfShort, int paramInt1, int paramInt2, int paramInt3)
  {
    int i9 = paramInt1 * this.b;
    int i4 = 1;
    int i3 = 0;
    int i2 = 0;
    int i7;
    for (int i1 = 255; paramInt2 <= paramInt3; i1 = i7)
    {
      int i5 = 0;
      paramInt1 = 0;
      while (i5 < paramInt2)
      {
        paramInt1 += Math.abs(paramArrayOfShort[(i9 + i5)] - paramArrayOfShort[(i9 + paramInt2 + i5)]);
        i5 += 1;
      }
      int i6 = i4;
      i5 = i3;
      if (paramInt1 * i3 < i4 * paramInt2)
      {
        i5 = paramInt2;
        i6 = paramInt1;
      }
      int i8 = i2;
      i7 = i1;
      if (paramInt1 * i1 > i2 * paramInt2)
      {
        i7 = paramInt2;
        i8 = paramInt1;
      }
      paramInt2 += 1;
      i4 = i6;
      i3 = i5;
      i2 = i8;
    }
    this.w = (i4 / i3);
    this.x = (i2 / i1);
    return i3;
  }
  
  private int a(short[] paramArrayOfShort, int paramInt, boolean paramBoolean)
  {
    int i1 = this.a;
    if (i1 > 4000) {
      i1 /= 4000;
    } else {
      i1 = 1;
    }
    if ((this.b == 1) && (i1 == 1))
    {
      paramInt = a(paramArrayOfShort, paramInt, this.c, this.d);
    }
    else
    {
      b(paramArrayOfShort, paramInt, i1);
      int i2 = a(this.f, 0, this.c / i1, this.d / i1);
      if (i1 != 1)
      {
        i2 *= i1;
        int i3 = i1 * 4;
        i1 = i2 - i3;
        i3 = i2 + i3;
        i2 = this.c;
        if (i1 < i2) {
          i1 = i2;
        }
        int i4 = this.d;
        i2 = i3;
        if (i3 > i4) {
          i2 = i4;
        }
        if (this.b == 1)
        {
          paramInt = a(paramArrayOfShort, paramInt, i1, i2);
        }
        else
        {
          b(paramArrayOfShort, paramInt, 1);
          paramInt = a(this.f, 0, i1, i2);
        }
      }
      else
      {
        paramInt = i2;
      }
    }
    if (a(this.w, this.x, paramBoolean)) {
      i1 = this.u;
    } else {
      i1 = paramInt;
    }
    this.v = this.w;
    this.u = paramInt;
    return i1;
  }
  
  private void a(float paramFloat, int paramInt)
  {
    if (this.r == paramInt) {
      return;
    }
    int i1 = this.a;
    int i2 = (int)(i1 / paramFloat);
    for (;;)
    {
      if ((i2 <= 16384) && (i1 <= 16384))
      {
        e(paramInt);
        paramInt = 0;
        int i3;
        for (;;)
        {
          i3 = this.s;
          boolean bool = true;
          if (paramInt >= i3 - 1) {
            break;
          }
          int i4;
          for (;;)
          {
            i3 = this.m;
            i4 = this.n;
            if ((i3 + 1) * i2 <= i4 * i1) {
              break;
            }
            a(1);
            i3 = 0;
            for (;;)
            {
              i4 = this.b;
              if (i3 >= i4) {
                break;
              }
              this.j[(this.r * i4 + i3)] = b(this.l, i4 * paramInt + i3, i1, i2);
              i3 += 1;
            }
            this.n += 1;
            this.r += 1;
          }
          this.m = (i3 + 1);
          if (this.m == i1)
          {
            this.m = 0;
            if (i4 != i2) {
              bool = false;
            }
            a.b(bool);
            this.n = 0;
          }
          paramInt += 1;
        }
        f(i3 - 1);
        return;
      }
      i2 /= 2;
      i1 /= 2;
    }
  }
  
  private void a(int paramInt)
  {
    int i1 = this.r;
    int i2 = this.i;
    if (i1 + paramInt > i2)
    {
      this.i = (i2 + (i2 / 2 + paramInt));
      this.j = Arrays.copyOf(this.j, this.i * this.b);
    }
  }
  
  private static void a(int paramInt1, int paramInt2, short[] paramArrayOfShort1, int paramInt3, short[] paramArrayOfShort2, int paramInt4, short[] paramArrayOfShort3, int paramInt5)
  {
    int i1 = 0;
    while (i1 < paramInt2)
    {
      int i3 = paramInt4 * paramInt2 + i1;
      int i2 = paramInt5 * paramInt2 + i1;
      int i5 = paramInt3 * paramInt2 + i1;
      int i4 = 0;
      while (i4 < paramInt1)
      {
        paramArrayOfShort1[i5] = ((short)((paramArrayOfShort2[i3] * (paramInt1 - i4) + paramArrayOfShort3[i2] * i4) / paramInt1));
        i5 += paramInt2;
        i3 += paramInt2;
        i2 += paramInt2;
        i4 += 1;
      }
      i1 += 1;
    }
  }
  
  private void a(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    a(paramInt2);
    int i1 = this.b;
    System.arraycopy(paramArrayOfShort, paramInt1 * i1, this.j, this.r * i1, i1 * paramInt2);
    this.r += paramInt2;
  }
  
  private boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 != 0)
    {
      if (this.u == 0) {
        return false;
      }
      if (paramBoolean)
      {
        if (paramInt2 > paramInt1 * 3) {
          return false;
        }
        if (paramInt1 * 2 <= this.v * 3) {
          return false;
        }
      }
      else if (paramInt1 <= this.v)
      {
        return false;
      }
      return true;
    }
    return false;
  }
  
  private int b(short[] paramArrayOfShort, int paramInt1, float paramFloat, int paramInt2)
  {
    int i1;
    if (paramFloat < 0.5F)
    {
      i1 = (int)(paramInt2 * paramFloat / (1.0F - paramFloat));
    }
    else
    {
      this.t = ((int)(paramInt2 * (2.0F * paramFloat - 1.0F) / (1.0F - paramFloat)));
      i1 = paramInt2;
    }
    int i2 = paramInt2 + i1;
    a(i2);
    int i3 = this.b;
    System.arraycopy(paramArrayOfShort, paramInt1 * i3, this.j, this.r * i3, i3 * paramInt2);
    a(i1, this.b, this.j, this.r + paramInt2, paramArrayOfShort, paramInt1 + paramInt2, paramArrayOfShort, paramInt1);
    this.r += i2;
    return i1;
  }
  
  private short b(short[] paramArrayOfShort, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramArrayOfShort[paramInt1];
    paramInt1 = paramArrayOfShort[(paramInt1 + this.b)];
    int i4 = this.n;
    int i2 = this.m;
    int i3 = (i2 + 1) * paramInt3;
    paramInt2 = i3 - i4 * paramInt2;
    paramInt3 = i3 - i2 * paramInt3;
    return (short)((i1 * paramInt2 + (paramInt3 - paramInt2) * paramInt1) / paramInt3);
  }
  
  private void b(int paramInt)
  {
    int i1 = this.q;
    int i2 = this.g;
    if (i1 + paramInt > i2)
    {
      this.g = (i2 + (i2 / 2 + paramInt));
      this.h = Arrays.copyOf(this.h, this.g * this.b);
    }
  }
  
  private void b(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int i3 = this.e / paramInt2;
    int i4 = this.b;
    int i5 = paramInt2 * i4;
    paramInt2 = 0;
    while (paramInt2 < i3)
    {
      int i1 = 0;
      int i2 = 0;
      while (i1 < i5)
      {
        i2 += paramArrayOfShort[(paramInt2 * i5 + paramInt1 * i4 + i1)];
        i1 += 1;
      }
      i1 = i2 / i5;
      this.f[paramInt2] = ((short)i1);
      paramInt2 += 1;
    }
  }
  
  private void c()
  {
    int i1 = this.r;
    float f1 = this.o / this.p;
    double d1 = f1;
    if ((d1 <= 1.00001D) && (d1 >= 0.9999900000000001D))
    {
      a(this.h, 0, this.q);
      this.q = 0;
    }
    else
    {
      c(f1);
    }
    f1 = this.p;
    if (f1 != 1.0F) {
      a(f1, i1);
    }
  }
  
  private void c(float paramFloat)
  {
    int i3 = this.q;
    if (i3 < this.e) {
      return;
    }
    int i2 = 0;
    int i1;
    do
    {
      if (this.t > 0) {
        i1 = d(i2);
      }
      for (;;)
      {
        i1 = i2 + i1;
        break;
        i1 = a(this.h, i2, true);
        if (paramFloat > 1.0D) {
          i1 += a(this.h, i2, paramFloat, i1);
        } else {
          i1 = b(this.h, i2, paramFloat, i1);
        }
      }
      i2 = i1;
    } while (this.e + i1 <= i3);
    c(i1);
  }
  
  private void c(int paramInt)
  {
    int i1 = this.q - paramInt;
    short[] arrayOfShort = this.h;
    int i2 = this.b;
    System.arraycopy(arrayOfShort, paramInt * i2, arrayOfShort, 0, i2 * i1);
    this.q = i1;
  }
  
  private int d(int paramInt)
  {
    int i1 = Math.min(this.e, this.t);
    a(this.h, paramInt, i1);
    this.t -= i1;
    return i1;
  }
  
  private void e(int paramInt)
  {
    int i1 = this.r - paramInt;
    int i2 = this.s;
    int i3 = this.k;
    if (i2 + i1 > i3)
    {
      this.k = (i3 + (i3 / 2 + i1));
      this.l = Arrays.copyOf(this.l, this.k * this.b);
    }
    short[] arrayOfShort = this.j;
    i2 = this.b;
    System.arraycopy(arrayOfShort, paramInt * i2, this.l, this.s * i2, i2 * i1);
    this.r = paramInt;
    this.s += i1;
  }
  
  private void f(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    short[] arrayOfShort = this.l;
    int i1 = this.b;
    System.arraycopy(arrayOfShort, paramInt * i1, arrayOfShort, 0, (this.s - paramInt) * i1);
    this.s -= paramInt;
  }
  
  public void a()
  {
    int i2 = this.q;
    float f2 = this.o;
    float f1 = this.p;
    f2 /= f1;
    int i3 = this.r + (int)((i2 / f2 + this.s) / f1 + 0.5F);
    b(this.e * 2 + i2);
    int i1 = 0;
    int i4;
    for (;;)
    {
      i4 = this.e;
      int i5 = this.b;
      if (i1 >= i4 * 2 * i5) {
        break;
      }
      this.h[(i5 * i2 + i1)] = 0;
      i1 += 1;
    }
    this.q += i4 * 2;
    c();
    if (this.r > i3) {
      this.r = i3;
    }
    this.q = 0;
    this.t = 0;
    this.s = 0;
  }
  
  public void a(float paramFloat)
  {
    this.o = paramFloat;
  }
  
  public void a(ShortBuffer paramShortBuffer)
  {
    int i2 = paramShortBuffer.remaining();
    int i1 = this.b;
    i2 /= i1;
    b(i2);
    paramShortBuffer.get(this.h, this.q * this.b, i1 * i2 * 2 / 2);
    this.q += i2;
    c();
  }
  
  public int b()
  {
    return this.r;
  }
  
  public void b(float paramFloat)
  {
    this.p = paramFloat;
  }
  
  public void b(ShortBuffer paramShortBuffer)
  {
    int i1 = Math.min(paramShortBuffer.remaining() / this.b, this.r);
    paramShortBuffer.put(this.j, 0, this.b * i1);
    this.r -= i1;
    paramShortBuffer = this.j;
    int i2 = this.b;
    System.arraycopy(paramShortBuffer, i1 * i2, paramShortBuffer, 0, this.r * i2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.i.k
 * JD-Core Version:    0.7.0.1
 */