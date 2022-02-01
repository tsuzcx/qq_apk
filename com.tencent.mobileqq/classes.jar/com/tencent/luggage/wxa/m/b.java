package com.tencent.luggage.wxa.m;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.l.d;
import com.tencent.luggage.wxa.l.f;
import com.tencent.luggage.wxa.l.g;
import com.tencent.luggage.wxa.l.j;
import com.tencent.luggage.wxa.l.k;

public final class b
  implements d, k
{
  public static final g a = new b.1();
  private static final int e = x.f("FLV");
  public int b;
  public int c;
  public long d;
  private final m f = new m(4);
  private final m g = new m(9);
  private final m h = new m(11);
  private final m i = new m();
  private f j;
  private int k = 1;
  private int l;
  private a m;
  private e n;
  private c o;
  
  private boolean b(com.tencent.luggage.wxa.l.e parame)
  {
    byte[] arrayOfByte = this.g.a;
    int i2 = 0;
    if (!parame.a(arrayOfByte, 0, 9, true)) {
      return false;
    }
    this.g.c(0);
    this.g.d(4);
    int i3 = this.g.g();
    int i1;
    if ((i3 & 0x4) != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i3 & 0x1) != 0) {
      i2 = 1;
    }
    if ((i1 != 0) && (this.m == null)) {
      this.m = new a(this.j.a(8, 1));
    }
    if ((i2 != 0) && (this.n == null)) {
      this.n = new e(this.j.a(9, 2));
    }
    if (this.o == null) {
      this.o = new c(null);
    }
    this.j.a();
    this.j.a(this);
    this.l = (this.g.n() - 9 + 4);
    this.k = 2;
    return true;
  }
  
  private void c(com.tencent.luggage.wxa.l.e parame)
  {
    parame.b(this.l);
    this.l = 0;
    this.k = 3;
  }
  
  private boolean d(com.tencent.luggage.wxa.l.e parame)
  {
    if (!parame.a(this.h.a, 0, 11, true)) {
      return false;
    }
    this.h.c(0);
    this.b = this.h.g();
    this.c = this.h.k();
    this.d = this.h.k();
    this.d = ((this.h.g() << 24 | this.d) * 1000L);
    this.h.d(3);
    this.k = 4;
    return true;
  }
  
  private boolean e(com.tencent.luggage.wxa.l.e parame)
  {
    Object localObject;
    if (this.b == 8)
    {
      localObject = this.m;
      if (localObject != null)
      {
        ((a)localObject).b(f(parame), this.d);
        break label99;
      }
    }
    if (this.b == 9)
    {
      localObject = this.n;
      if (localObject != null)
      {
        ((e)localObject).b(f(parame), this.d);
        break label99;
      }
    }
    if (this.b == 18)
    {
      localObject = this.o;
      if (localObject != null)
      {
        ((c)localObject).b(f(parame), this.d);
        label99:
        bool = true;
        break label116;
      }
    }
    parame.b(this.c);
    boolean bool = false;
    label116:
    this.l = 4;
    this.k = 2;
    return bool;
  }
  
  private m f(com.tencent.luggage.wxa.l.e parame)
  {
    if (this.c > this.i.e())
    {
      m localm = this.i;
      localm.a(new byte[Math.max(localm.e() * 2, this.c)], 0);
    }
    else
    {
      this.i.c(0);
    }
    this.i.b(this.c);
    parame.b(this.i.a, 0, this.c);
    return this.i;
  }
  
  public int a(com.tencent.luggage.wxa.l.e parame, j paramj)
  {
    do
    {
      for (;;)
      {
        int i1 = this.k;
        if (i1 == 1) {
          break;
        }
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if ((i1 == 4) && (e(parame))) {
              return 0;
            }
          }
          else if (!d(parame)) {
            return -1;
          }
        }
        else {
          c(parame);
        }
      }
    } while (b(parame));
    return -1;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.k = 1;
    this.l = 0;
  }
  
  public void a(f paramf)
  {
    this.j = paramf;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(com.tencent.luggage.wxa.l.e parame)
  {
    byte[] arrayOfByte = this.f.a;
    boolean bool = false;
    parame.c(arrayOfByte, 0, 3);
    this.f.c(0);
    if (this.f.k() != e) {
      return false;
    }
    parame.c(this.f.a, 0, 2);
    this.f.c(0);
    if ((this.f.h() & 0xFA) != 0) {
      return false;
    }
    parame.c(this.f.a, 0, 4);
    this.f.c(0);
    int i1 = this.f.n();
    parame.a();
    parame.c(i1);
    parame.c(this.f.a, 0, 4);
    this.f.c(0);
    if (this.f.n() == 0) {
      bool = true;
    }
    return bool;
  }
  
  public long b()
  {
    return this.o.a();
  }
  
  public long b(long paramLong)
  {
    return 0L;
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.m.b
 * JD-Core Version:    0.7.0.1
 */