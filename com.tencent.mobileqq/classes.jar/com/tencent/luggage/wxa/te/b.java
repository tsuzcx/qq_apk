package com.tencent.luggage.wxa.te;

import java.io.InputStream;
import java.io.OutputStream;

public class b
{
  com.tencent.luggage.wxa.td.a a = new com.tencent.luggage.wxa.td.a();
  com.tencent.luggage.wxa.tf.b b = new com.tencent.luggage.wxa.tf.b();
  short[] c = new short['À'];
  short[] d = new short[12];
  short[] e = new short[12];
  short[] f = new short[12];
  short[] g = new short[12];
  short[] h = new short['À'];
  com.tencent.luggage.wxa.tf.a[] i = new com.tencent.luggage.wxa.tf.a[4];
  short[] j = new short[114];
  com.tencent.luggage.wxa.tf.a k = new com.tencent.luggage.wxa.tf.a(4);
  b.a l = new b.a(this);
  b.a m = new b.a(this);
  b.b n = new b.b(this);
  int o = -1;
  int p = -1;
  int q;
  
  public b()
  {
    int i1 = 0;
    while (i1 < 4)
    {
      this.i[i1] = new com.tencent.luggage.wxa.tf.a(6);
      i1 += 1;
    }
  }
  
  void a()
  {
    com.tencent.luggage.wxa.td.a locala = this.a;
    int i1 = 0;
    locala.a(false);
    com.tencent.luggage.wxa.tf.b.a(this.c);
    com.tencent.luggage.wxa.tf.b.a(this.h);
    com.tencent.luggage.wxa.tf.b.a(this.d);
    com.tencent.luggage.wxa.tf.b.a(this.e);
    com.tencent.luggage.wxa.tf.b.a(this.f);
    com.tencent.luggage.wxa.tf.b.a(this.g);
    com.tencent.luggage.wxa.tf.b.a(this.j);
    this.n.a();
    while (i1 < 4)
    {
      this.i[i1].a();
      i1 += 1;
    }
    this.l.a();
    this.m.a();
    this.k.a();
    this.b.b();
  }
  
  boolean a(int paramInt)
  {
    if (paramInt < 0) {
      return false;
    }
    if (this.o != paramInt)
    {
      this.o = paramInt;
      this.p = Math.max(this.o, 1);
      this.a.a(Math.max(this.p, 4096));
    }
    return true;
  }
  
  boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= 8) && (paramInt2 <= 4) && (paramInt3 <= 4))
    {
      this.n.a(paramInt2, paramInt1);
      paramInt1 = 1 << paramInt3;
      this.l.a(paramInt1);
      this.m.a(paramInt1);
      this.q = (paramInt1 - 1);
      return true;
    }
    return false;
  }
  
  public boolean a(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong)
  {
    this.b.a(paramInputStream);
    this.a.a(paramOutputStream);
    a();
    int i5 = a.a();
    long l1 = 0L;
    byte b1 = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i7;
    for (int i4 = 0;; i4 = i7)
    {
      int i6 = 1;
      int i13;
      int i8;
      if ((paramLong < 0L) || (l1 < paramLong))
      {
        i7 = (int)l1;
        i13 = this.q & i7;
        paramInputStream = this.b;
        paramOutputStream = this.c;
        i8 = (i5 << 4) + i13;
        if (paramInputStream.a(paramOutputStream, i8) == 0)
        {
          paramInputStream = this.n.a(i7, b1);
          if (!a.e(i5)) {
            b1 = paramInputStream.a(this.b, this.a.b(i3));
          } else {
            b1 = paramInputStream.a(this.b);
          }
          this.a.a(b1);
          i5 = a.a(i5);
          l1 += 1L;
          i7 = i4;
          i6 = i3;
          i3 = i2;
          i4 = i1;
        }
      }
      for (;;)
      {
        break;
        if (this.b.a(this.d, i5) == 1)
        {
          int i12;
          int i9;
          int i10;
          int i11;
          if (this.b.a(this.e, i5) == 0)
          {
            if (this.b.a(this.h, i8) == 0)
            {
              i12 = a.d(i5);
              i8 = i1;
              i9 = i2;
              i10 = i3;
              i11 = i4;
            }
            else
            {
              i6 = 0;
              i12 = i5;
              i8 = i1;
              i9 = i2;
              i10 = i3;
              i11 = i4;
            }
          }
          else
          {
            if (this.b.a(this.f, i5) == 0)
            {
              i6 = i2;
              i2 = i4;
            }
            else
            {
              i7 = i1;
              i6 = i4;
              if (this.b.a(this.g, i5) == 0)
              {
                i6 = i1;
                i7 = i4;
              }
              i1 = i2;
              i2 = i7;
            }
            i10 = i6;
            i6 = 0;
            i11 = i2;
            i9 = i3;
            i8 = i1;
            i12 = i5;
          }
          i5 = i12;
          i4 = i8;
          i3 = i9;
          i2 = i10;
          i1 = i11;
          i7 = i6;
          if (i6 == 0)
          {
            i7 = this.m.a(this.b, i13) + 2;
            i5 = a.c(i12);
            i4 = i8;
            i3 = i9;
            i2 = i10;
            i1 = i11;
          }
        }
        else
        {
          i7 = this.l.a(this.b, i13) + 2;
          i5 = a.b(i5);
          i6 = this.i[a.f(i7)].a(this.b);
          if (i6 >= 4)
          {
            i4 = (i6 >> 1) - 1;
            i8 = (i6 & 0x1 | 0x2) << i4;
            if (i6 < 14)
            {
              i4 = i8 + com.tencent.luggage.wxa.tf.a.a(this.j, i8 - i6 - 1, this.b, i4);
            }
            else
            {
              i6 = i8 + (this.b.a(i4 - 4) << 4) + this.k.b(this.b);
              i4 = i6;
              if (i6 < 0)
              {
                if (i6 == -1)
                {
                  this.a.b();
                  this.a.a();
                  this.b.a();
                  return true;
                }
                return false;
              }
            }
            i6 = i4;
            i4 = i2;
            i2 = i6;
          }
          else
          {
            i4 = i2;
            i2 = i6;
          }
        }
        if (i2 >= l1) {
          break label733;
        }
        if (i2 >= this.p) {
          return false;
        }
        this.a.a(i2, i7);
        l1 += i7;
        b1 = this.a.b(0);
        i6 = i2;
        i7 = i1;
      }
      i1 = i4;
      i2 = i3;
      i3 = i6;
    }
    label733:
    return false;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 5) {
      return false;
    }
    int i4 = paramArrayOfByte[0] & 0xFF;
    int i5 = i4 / 9;
    int i6 = i5 / 5;
    int i1 = 0;
    int i2 = 0;
    while (i1 < 4)
    {
      int i3 = i1 + 1;
      i2 += ((paramArrayOfByte[i3] & 0xFF) << i1 * 8);
      i1 = i3;
    }
    if (!a(i4 % 9, i5 % 5, i6)) {
      return false;
    }
    return a(i2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.te.b
 * JD-Core Version:    0.7.0.1
 */