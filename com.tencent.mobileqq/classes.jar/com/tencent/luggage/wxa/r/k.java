package com.tencent.luggage.wxa.r;

import android.util.Log;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.l.f;
import com.tencent.luggage.wxa.l.l;
import java.util.Collections;

public final class k
  implements h
{
  private final s a;
  private String b;
  private l c;
  private k.a d;
  private boolean e;
  private final boolean[] f;
  private final n g;
  private final n h;
  private final n i;
  private final n j;
  private final n k;
  private long l;
  private long m;
  private final m n;
  
  public k(s params)
  {
    this.a = params;
    this.f = new boolean[3];
    this.g = new n(32, 128);
    this.h = new n(33, 128);
    this.i = new n(34, 128);
    this.j = new n(39, 128);
    this.k = new n(40, 128);
    this.n = new m();
  }
  
  private static com.tencent.luggage.wxa.h.k a(String paramString, n paramn1, n paramn2, n paramn3)
  {
    byte[] arrayOfByte1 = new byte[paramn1.b + paramn2.b + paramn3.b];
    byte[] arrayOfByte2 = paramn1.a;
    int i1 = paramn1.b;
    int i4 = 0;
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, i1);
    System.arraycopy(paramn2.a, 0, arrayOfByte1, paramn1.b, paramn2.b);
    System.arraycopy(paramn3.a, 0, arrayOfByte1, paramn1.b + paramn2.b, paramn3.b);
    paramn1 = new com.tencent.luggage.wxa.ao.n(paramn2.a, 0, paramn2.b);
    paramn1.a(44);
    int i5 = paramn1.c(3);
    paramn1.a();
    paramn1.a(88);
    paramn1.a(8);
    int i3 = 0;
    i1 = 0;
    while (i3 < i5)
    {
      i2 = i1;
      if (paramn1.b()) {
        i2 = i1 + 89;
      }
      i1 = i2;
      if (paramn1.b()) {
        i1 = i2 + 8;
      }
      i3 += 1;
    }
    paramn1.a(i1);
    if (i5 > 0) {
      paramn1.a((8 - i5) * 2);
    }
    paramn1.d();
    int i11 = paramn1.d();
    if (i11 == 3) {
      paramn1.a();
    }
    int i7 = paramn1.d();
    int i6 = paramn1.d();
    i3 = i7;
    int i2 = i6;
    if (paramn1.b())
    {
      i3 = paramn1.d();
      int i10 = paramn1.d();
      int i8 = paramn1.d();
      int i9 = paramn1.d();
      if ((i11 != 1) && (i11 != 2)) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      if (i11 == 1) {
        i2 = 2;
      } else {
        i2 = 1;
      }
      i3 = i7 - i1 * (i3 + i10);
      i2 = i6 - i2 * (i8 + i9);
    }
    paramn1.d();
    paramn1.d();
    i6 = paramn1.d();
    if (paramn1.b()) {
      i1 = 0;
    } else {
      i1 = i5;
    }
    while (i1 <= i5)
    {
      paramn1.d();
      paramn1.d();
      paramn1.d();
      i1 += 1;
    }
    paramn1.d();
    paramn1.d();
    paramn1.d();
    paramn1.d();
    paramn1.d();
    paramn1.d();
    if ((paramn1.b()) && (paramn1.b())) {
      a(paramn1);
    }
    paramn1.a(2);
    if (paramn1.b())
    {
      paramn1.a(8);
      paramn1.d();
      paramn1.d();
      paramn1.a();
    }
    b(paramn1);
    if (paramn1.b())
    {
      i1 = i4;
      while (i1 < paramn1.d())
      {
        paramn1.a(i6 + 4 + 1);
        i1 += 1;
      }
    }
    paramn1.a(2);
    float f2 = 1.0F;
    float f1;
    if ((paramn1.b()) && (paramn1.b()))
    {
      i1 = paramn1.c(8);
      if (i1 == 255)
      {
        i1 = paramn1.c(16);
        i4 = paramn1.c(16);
        f1 = f2;
        if (i1 != 0)
        {
          f1 = f2;
          if (i4 != 0) {
            f1 = i1 / i4;
          }
        }
      }
      else if (i1 < com.tencent.luggage.wxa.ao.k.b.length)
      {
        f1 = com.tencent.luggage.wxa.ao.k.b[i1];
      }
      else
      {
        paramn1 = new StringBuilder();
        paramn1.append("Unexpected aspect_ratio_idc value: ");
        paramn1.append(i1);
        Log.w("H265Reader", paramn1.toString());
      }
    }
    else
    {
      f1 = 1.0F;
    }
    return com.tencent.luggage.wxa.h.k.a(paramString, "video/hevc", null, -1, -1, i3, i2, -1.0F, Collections.singletonList(arrayOfByte1), -1, f1, null);
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    if (this.e)
    {
      this.d.a(paramLong1, paramInt1, paramInt2, paramLong2);
    }
    else
    {
      this.g.a(paramInt2);
      this.h.a(paramInt2);
      this.i.a(paramInt2);
    }
    this.j.a(paramInt2);
    this.k.a(paramInt2);
  }
  
  private static void a(com.tencent.luggage.wxa.ao.n paramn)
  {
    int i1 = 0;
    while (i1 < 4)
    {
      int i2 = 0;
      while (i2 < 6)
      {
        if (!paramn.b())
        {
          paramn.d();
        }
        else
        {
          int i4 = Math.min(64, 1 << (i1 << 1) + 4);
          if (i1 > 1) {
            paramn.e();
          }
          i3 = 0;
          while (i3 < i4)
          {
            paramn.e();
            i3 += 1;
          }
        }
        int i3 = 3;
        if (i1 != 3) {
          i3 = 1;
        }
        i2 += i3;
      }
      i1 += 1;
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.e)
    {
      this.d.a(paramArrayOfByte, paramInt1, paramInt2);
    }
    else
    {
      this.g.a(paramArrayOfByte, paramInt1, paramInt2);
      this.h.a(paramArrayOfByte, paramInt1, paramInt2);
      this.i.a(paramArrayOfByte, paramInt1, paramInt2);
    }
    this.j.a(paramArrayOfByte, paramInt1, paramInt2);
    this.k.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private void b(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    if (this.e)
    {
      this.d.a(paramLong1, paramInt1);
    }
    else
    {
      this.g.b(paramInt2);
      this.h.b(paramInt2);
      this.i.b(paramInt2);
      if ((this.g.b()) && (this.h.b()) && (this.i.b()))
      {
        this.c.a(a(this.b, this.g, this.h, this.i));
        this.e = true;
      }
    }
    if (this.j.b(paramInt2))
    {
      paramInt1 = com.tencent.luggage.wxa.ao.k.a(this.j.a, this.j.b);
      this.n.a(this.j.a, paramInt1);
      this.n.d(5);
      this.a.a(paramLong2, this.n);
    }
    if (this.k.b(paramInt2))
    {
      paramInt1 = com.tencent.luggage.wxa.ao.k.a(this.k.a, this.k.b);
      this.n.a(this.k.a, paramInt1);
      this.n.d(5);
      this.a.a(paramLong2, this.n);
    }
  }
  
  private static void b(com.tencent.luggage.wxa.ao.n paramn)
  {
    int i5 = paramn.d();
    int i1 = 0;
    boolean bool = false;
    int i3;
    for (int i2 = 0; i1 < i5; i2 = i3)
    {
      if (i1 != 0) {
        bool = paramn.b();
      }
      if (bool)
      {
        paramn.a();
        paramn.d();
        i4 = 0;
        for (;;)
        {
          i3 = i2;
          if (i4 > i2) {
            break;
          }
          if (paramn.b()) {
            paramn.a();
          }
          i4 += 1;
        }
      }
      i3 = paramn.d();
      int i4 = paramn.d();
      i2 = 0;
      while (i2 < i3)
      {
        paramn.d();
        paramn.a();
        i2 += 1;
      }
      i2 = 0;
      while (i2 < i4)
      {
        paramn.d();
        paramn.a();
        i2 += 1;
      }
      i3 += i4;
      i1 += 1;
    }
  }
  
  public void a()
  {
    com.tencent.luggage.wxa.ao.k.a(this.f);
    this.g.a();
    this.h.a();
    this.i.a();
    this.j.a();
    this.k.a();
    this.d.a();
    this.l = 0L;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.m = paramLong;
  }
  
  public void a(m paramm)
  {
    if (paramm.b() > 0)
    {
      int i1 = paramm.d();
      int i2 = paramm.c();
      byte[] arrayOfByte = paramm.a;
      this.l += paramm.b();
      this.c.a(paramm, paramm.b());
      while (i1 < i2)
      {
        int i3 = com.tencent.luggage.wxa.ao.k.a(arrayOfByte, i1, i2, this.f);
        if (i3 == i2)
        {
          a(arrayOfByte, i1, i2);
          return;
        }
        int i4 = com.tencent.luggage.wxa.ao.k.c(arrayOfByte, i3);
        int i6 = i3 - i1;
        if (i6 > 0) {
          a(arrayOfByte, i1, i3);
        }
        int i5 = i2 - i3;
        long l1 = this.l - i5;
        if (i6 < 0) {
          i1 = -i6;
        } else {
          i1 = 0;
        }
        b(l1, i5, i1, this.m);
        a(l1, i5, i4, this.m);
        i1 = i3 + 3;
      }
    }
  }
  
  public void a(f paramf, v.d paramd)
  {
    paramd.a();
    this.b = paramd.c();
    this.c = paramf.a(paramd.b(), 2);
    this.d = new k.a(this.c);
    this.a.a(paramf, paramd);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.k
 * JD-Core Version:    0.7.0.1
 */