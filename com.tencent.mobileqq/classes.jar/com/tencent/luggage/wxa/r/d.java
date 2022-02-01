package com.tencent.luggage.wxa.r;

import android.util.Log;
import android.util.Pair;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.l.c;
import com.tencent.luggage.wxa.l.f;
import java.util.Arrays;
import java.util.Collections;

public final class d
  implements h
{
  private static final byte[] a = { 73, 68, 51 };
  private final boolean b;
  private final com.tencent.luggage.wxa.ao.l c = new com.tencent.luggage.wxa.ao.l(new byte[7]);
  private final m d = new m(Arrays.copyOf(a, 10));
  private final String e;
  private String f;
  private com.tencent.luggage.wxa.l.l g;
  private com.tencent.luggage.wxa.l.l h;
  private int i;
  private int j;
  private int k;
  private boolean l;
  private boolean m;
  private long n;
  private int o;
  private long p;
  private com.tencent.luggage.wxa.l.l q;
  private long r;
  
  public d(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public d(boolean paramBoolean, String paramString)
  {
    c();
    this.b = paramBoolean;
    this.e = paramString;
  }
  
  private void a(com.tencent.luggage.wxa.l.l paraml, long paramLong, int paramInt1, int paramInt2)
  {
    this.i = 3;
    this.j = paramInt1;
    this.q = paraml;
    this.r = paramLong;
    this.o = paramInt2;
  }
  
  private boolean a(m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = Math.min(paramm.b(), paramInt - this.j);
    paramm.a(paramArrayOfByte, this.j, i1);
    this.j += i1;
    return this.j == paramInt;
  }
  
  private void b(m paramm)
  {
    byte[] arrayOfByte = paramm.a;
    int i1 = paramm.d();
    int i3 = paramm.c();
    while (i1 < i3)
    {
      int i2 = i1 + 1;
      i1 = arrayOfByte[i1] & 0xFF;
      if ((this.k == 512) && (i1 >= 240) && (i1 != 255))
      {
        boolean bool = true;
        if ((i1 & 0x1) != 0) {
          bool = false;
        }
        this.l = bool;
        e();
        paramm.c(i2);
        return;
      }
      int i4 = this.k;
      i1 |= i4;
      if (i1 != 329)
      {
        if (i1 != 511)
        {
          if (i1 != 836)
          {
            if (i1 != 1075)
            {
              i1 = i2;
              if (i4 != 256)
              {
                this.k = 256;
                i1 = i2 - 1;
              }
            }
            else
            {
              d();
              paramm.c(i2);
            }
          }
          else
          {
            this.k = 1024;
            i1 = i2;
          }
        }
        else
        {
          this.k = 512;
          i1 = i2;
        }
      }
      else
      {
        this.k = 768;
        i1 = i2;
      }
    }
    paramm.c(i1);
  }
  
  private void c()
  {
    this.i = 0;
    this.j = 0;
    this.k = 256;
  }
  
  private void c(m paramm)
  {
    int i1 = Math.min(paramm.b(), this.o - this.j);
    this.q.a(paramm, i1);
    this.j += i1;
    i1 = this.j;
    int i2 = this.o;
    if (i1 == i2)
    {
      this.q.a(this.p, 1, i2, 0, null);
      this.p += this.r;
      c();
    }
  }
  
  private void d()
  {
    this.i = 1;
    this.j = a.length;
    this.o = 0;
    this.d.c(0);
  }
  
  private void e()
  {
    this.i = 2;
    this.j = 0;
  }
  
  private void f()
  {
    this.h.a(this.d, 10);
    this.d.c(6);
    a(this.h, 0L, 10, this.d.s() + 10);
  }
  
  private void g()
  {
    this.c.a(0);
    if (!this.m)
    {
      i2 = this.c.c(2) + 1;
      i1 = i2;
      if (i2 != 2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Detected audio object type: ");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append(", but assuming AAC LC.");
        Log.w("AdtsReader", ((StringBuilder)localObject).toString());
        i1 = 2;
      }
      i2 = this.c.c(4);
      this.c.b(1);
      Object localObject = com.tencent.luggage.wxa.ao.d.a(i1, i2, this.c.c(3));
      Pair localPair = com.tencent.luggage.wxa.ao.d.a((byte[])localObject);
      localObject = k.a(this.f, "audio/mp4a-latm", null, -1, -1, ((Integer)localPair.second).intValue(), ((Integer)localPair.first).intValue(), Collections.singletonList(localObject), null, 0, this.e);
      this.n = (1024000000L / ((k)localObject).s);
      this.g.a((k)localObject);
      this.m = true;
    }
    else
    {
      this.c.b(10);
    }
    this.c.b(4);
    int i2 = this.c.c(13) - 2 - 5;
    int i1 = i2;
    if (this.l) {
      i1 = i2 - 2;
    }
    a(this.g, this.n, 0, i1);
  }
  
  public void a()
  {
    c();
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.p = paramLong;
  }
  
  public void a(m paramm)
  {
    while (paramm.b() > 0)
    {
      int i1 = this.i;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 == 3) {
              c(paramm);
            }
          }
          else
          {
            if (this.l) {
              i1 = 7;
            } else {
              i1 = 5;
            }
            if (a(paramm, this.c.a, i1)) {
              g();
            }
          }
        }
        else if (a(paramm, this.d.a, 10)) {
          f();
        }
      }
      else {
        b(paramm);
      }
    }
  }
  
  public void a(f paramf, v.d paramd)
  {
    paramd.a();
    this.f = paramd.c();
    this.g = paramf.a(paramd.b(), 1);
    if (this.b)
    {
      paramd.a();
      this.h = paramf.a(paramd.b(), 4);
      this.h.a(k.a(paramd.c(), "application/id3", null, -1, null));
      return;
    }
    this.h = new c();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.d
 * JD-Core Version:    0.7.0.1
 */