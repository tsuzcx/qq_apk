package com.tencent.luggage.wxa.o;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.h.p;
import com.tencent.luggage.wxa.l.e;
import com.tencent.luggage.wxa.l.f;
import com.tencent.luggage.wxa.l.h;
import com.tencent.luggage.wxa.l.i;
import com.tencent.luggage.wxa.l.j;
import com.tencent.luggage.wxa.l.l;
import com.tencent.luggage.wxa.x.g.a;
import java.io.EOFException;

public final class b
  implements com.tencent.luggage.wxa.l.d
{
  public static final com.tencent.luggage.wxa.l.g a = new b.1();
  private static final int b = x.f("Xing");
  private static final int c = x.f("Info");
  private static final int d = x.f("VBRI");
  private final int e;
  private final long f;
  private final m g;
  private final i h;
  private final h i;
  private f j;
  private l k;
  private int l;
  private com.tencent.luggage.wxa.v.a m;
  private b.a n;
  private long o;
  private long p;
  private int q;
  
  public b()
  {
    this(0);
  }
  
  public b(int paramInt)
  {
    this(paramInt, -9223372036854775807L);
  }
  
  public b(int paramInt, long paramLong)
  {
    this.e = paramInt;
    this.f = paramLong;
    this.g = new m(10);
    this.h = new i();
    this.i = new h();
    this.o = -9223372036854775807L;
  }
  
  private static int a(m paramm, int paramInt)
  {
    if (paramm.c() >= paramInt + 4)
    {
      paramm.c(paramInt);
      paramInt = paramm.n();
      if ((paramInt == b) || (paramInt == c)) {
        return paramInt;
      }
    }
    if (paramm.c() >= 40)
    {
      paramm.c(36);
      paramInt = paramm.n();
      int i1 = d;
      if (paramInt == i1) {
        return i1;
      }
    }
    return 0;
  }
  
  private static boolean a(int paramInt, long paramLong)
  {
    return (paramInt & 0xFFFE0C00) == (paramLong & 0xFFFE0C00);
  }
  
  private boolean a(e parame, boolean paramBoolean)
  {
    int i4;
    if (paramBoolean) {
      i4 = 16384;
    } else {
      i4 = 131072;
    }
    parame.a();
    int i5;
    int i1;
    int i2;
    int i3;
    if (parame.c() == 0L)
    {
      c(parame);
      i5 = (int)parame.b();
      if (!paramBoolean) {
        parame.b(i5);
      }
      i1 = 0;
      i2 = 0;
      i3 = 0;
    }
    else
    {
      i1 = 0;
      i2 = 0;
      i3 = 0;
      i5 = 0;
    }
    for (;;)
    {
      byte[] arrayOfByte = this.g.a;
      boolean bool;
      if (i1 > 0) {
        bool = true;
      } else {
        bool = false;
      }
      int i6;
      int i7;
      if (parame.b(arrayOfByte, 0, 4, bool))
      {
        this.g.c(0);
        i6 = this.g.n();
        if ((i2 == 0) || (a(i6, i2)))
        {
          i7 = i.a(i6);
          if (i7 != -1) {}
        }
        else
        {
          i1 = i3 + 1;
          if (i3 == i4)
          {
            if (paramBoolean) {
              return false;
            }
            throw new p("Searched too many bytes.");
          }
          if (paramBoolean)
          {
            parame.a();
            parame.c(i5 + i1);
          }
          else
          {
            parame.b(1);
          }
          i3 = i1;
          i1 = 0;
          i2 = 0;
          continue;
        }
        i1 += 1;
        if (i1 == 1)
        {
          i.a(i6, this.h);
        }
        else
        {
          i6 = i2;
          if (i1 != 4) {}
        }
      }
      else
      {
        if (paramBoolean) {
          parame.b(i5 + i3);
        } else {
          parame.a();
        }
        this.l = i2;
        return true;
      }
      parame.c(i7 - 4);
      i2 = i6;
    }
  }
  
  private int b(e parame)
  {
    if (this.q == 0)
    {
      parame.a();
      if (!parame.b(this.g.a, 0, 4, true)) {
        return -1;
      }
      this.g.c(0);
      i1 = this.g.n();
      if ((a(i1, this.l)) && (i.a(i1) != -1))
      {
        i.a(i1, this.h);
        if (this.o == -9223372036854775807L)
        {
          this.o = this.n.a(parame.c());
          if (this.f != -9223372036854775807L)
          {
            l1 = this.n.a(0L);
            this.o += this.f - l1;
          }
        }
        this.q = this.h.c;
      }
      else
      {
        parame.b(1);
        this.l = 0;
        return 0;
      }
    }
    int i1 = this.k.a(parame, this.q, true);
    if (i1 == -1) {
      return -1;
    }
    this.q -= i1;
    if (this.q > 0) {
      return 0;
    }
    long l1 = this.o;
    long l2 = this.p * 1000000L / this.h.d;
    this.k.a(l1 + l2, 1, this.h.c, 0, null);
    this.p += this.h.g;
    this.q = 0;
    return 0;
  }
  
  private void c(e parame)
  {
    int i1 = 0;
    for (;;)
    {
      parame.c(this.g.a, 0, 10);
      this.g.c(0);
      if (this.g.k() != com.tencent.luggage.wxa.x.g.a)
      {
        parame.a();
        parame.c(i1);
        return;
      }
      this.g.d(3);
      int i2 = this.g.s();
      int i3 = i2 + 10;
      if (this.m == null)
      {
        byte[] arrayOfByte = new byte[i3];
        System.arraycopy(this.g.a, 0, arrayOfByte, 0, 10);
        parame.c(arrayOfByte, 10, i2);
        if ((this.e & 0x2) != 0) {
          localObject = h.a;
        } else {
          localObject = null;
        }
        this.m = new com.tencent.luggage.wxa.x.g((g.a)localObject).a(arrayOfByte, i3);
        Object localObject = this.m;
        if (localObject != null) {
          this.i.a((com.tencent.luggage.wxa.v.a)localObject);
        }
      }
      else
      {
        parame.c(i2);
      }
      i1 += i3;
    }
  }
  
  private b.a d(e parame)
  {
    Object localObject = new m(this.h.c);
    parame.c(((m)localObject).a, 0, this.h.c);
    if ((this.h.a & 0x1) != 0)
    {
      if (this.h.e != 1)
      {
        i1 = 36;
        break label84;
      }
    }
    else {
      if (this.h.e == 1) {
        break label81;
      }
    }
    int i1 = 21;
    break label84;
    label81:
    i1 = 13;
    label84:
    int i2 = a((m)localObject, i1);
    if ((i2 != b) && (i2 != c))
    {
      if (i2 == d)
      {
        localObject = c.a(this.h, (m)localObject, parame.c(), parame.d());
        parame.b(this.h.c);
        return localObject;
      }
      parame.a();
      return null;
    }
    localObject = d.a(this.h, (m)localObject, parame.c(), parame.d());
    if ((localObject != null) && (!this.i.a()))
    {
      parame.a();
      parame.c(i1 + 141);
      parame.c(this.g.a, 0, 3);
      this.g.c(0);
      this.i.a(this.g.k());
    }
    parame.b(this.h.c);
    if ((localObject != null) && (!((b.a)localObject).a()) && (i2 == c)) {
      return e(parame);
    }
    return localObject;
  }
  
  private b.a e(e parame)
  {
    parame.c(this.g.a, 0, 4);
    this.g.c(0);
    i.a(this.g.n(), this.h);
    return new a(parame.c(), this.h.f, parame.d());
  }
  
  public int a(e parame, j paramj)
  {
    if (this.l == 0) {}
    try
    {
      a(parame, false);
    }
    catch (EOFException parame)
    {
      label17:
      l locall;
      String str;
      int i1;
      int i2;
      int i3;
      int i4;
      break label17;
    }
    return -1;
    if (this.n == null)
    {
      this.n = d(parame);
      paramj = this.n;
      if ((paramj == null) || ((!paramj.a()) && ((this.e & 0x1) != 0))) {
        this.n = e(parame);
      }
      this.j.a(this.n);
      locall = this.k;
      str = this.h.b;
      i1 = this.h.e;
      i2 = this.h.d;
      i3 = this.i.b;
      i4 = this.i.c;
      if ((this.e & 0x2) != 0) {
        paramj = null;
      } else {
        paramj = this.m;
      }
      locall.a(k.a(null, str, null, -1, 4096, i1, i2, -1, i3, i4, null, null, 0, null, paramj));
    }
    return b(parame);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.l = 0;
    this.o = -9223372036854775807L;
    this.p = 0L;
    this.q = 0;
  }
  
  public void a(f paramf)
  {
    this.j = paramf;
    this.k = this.j.a(0, 1);
    this.j.a();
  }
  
  public boolean a(e parame)
  {
    return a(parame, true);
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.o.b
 * JD-Core Version:    0.7.0.1
 */