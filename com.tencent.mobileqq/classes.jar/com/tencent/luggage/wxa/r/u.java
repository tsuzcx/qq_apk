package com.tencent.luggage.wxa.r;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.l.d;
import com.tencent.luggage.wxa.l.f;
import com.tencent.luggage.wxa.l.g;
import com.tencent.luggage.wxa.l.j;
import com.tencent.luggage.wxa.l.k.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class u
  implements d
{
  public static final g a = new u.1();
  private static final long b = x.f("AC-3");
  private static final long c = x.f("EAC3");
  private static final long d = x.f("HEVC");
  private final int e;
  private final List<com.tencent.luggage.wxa.ao.u> f;
  private final m g;
  private final SparseIntArray h;
  private final v.c i;
  private final SparseArray<v> j;
  private final SparseBooleanArray k;
  private f l;
  private int m;
  private boolean n;
  private v o;
  
  public u()
  {
    this(0);
  }
  
  public u(int paramInt)
  {
    this(1, paramInt);
  }
  
  public u(int paramInt1, int paramInt2)
  {
    this(paramInt1, new com.tencent.luggage.wxa.ao.u(0L), new e(paramInt2));
  }
  
  public u(int paramInt, com.tencent.luggage.wxa.ao.u paramu, v.c paramc)
  {
    this.i = ((v.c)a.a(paramc));
    this.e = paramInt;
    if ((paramInt != 1) && (paramInt != 2))
    {
      this.f = new ArrayList();
      this.f.add(paramu);
    }
    else
    {
      this.f = Collections.singletonList(paramu);
    }
    this.g = new m(9400);
    this.k = new SparseBooleanArray();
    this.j = new SparseArray();
    this.h = new SparseIntArray();
    e();
  }
  
  private void e()
  {
    this.k.clear();
    this.j.clear();
    SparseArray localSparseArray = this.i.a();
    int i2 = localSparseArray.size();
    int i1 = 0;
    while (i1 < i2)
    {
      this.j.put(localSparseArray.keyAt(i1), localSparseArray.valueAt(i1));
      i1 += 1;
    }
    this.j.put(0, new r(new u.a(this)));
    this.o = null;
  }
  
  public int a(com.tencent.luggage.wxa.l.e parame, j paramj)
  {
    paramj = this.g.a;
    if (9400 - this.g.d() < 188)
    {
      i1 = this.g.b();
      if (i1 > 0) {
        System.arraycopy(paramj, this.g.d(), paramj, 0, i1);
      }
      this.g.a(paramj, i1);
    }
    int i2;
    while (this.g.b() < 188)
    {
      i1 = this.g.c();
      i2 = parame.a(paramj, i1, 9400 - i1);
      if (i2 == -1) {
        return -1;
      }
      this.g.b(i1 + i2);
    }
    int i4 = this.g.c();
    int i1 = this.g.d();
    while ((i1 < i4) && (paramj[i1] != 71)) {
      i1 += 1;
    }
    this.g.c(i1);
    int i5 = i1 + 188;
    if (i5 > i4) {
      return 0;
    }
    int i7 = this.g.n();
    if ((0x800000 & i7) != 0)
    {
      this.g.c(i5);
      return 0;
    }
    int i3 = 1;
    boolean bool;
    if ((0x400000 & i7) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    int i6 = (0x1FFF00 & i7) >> 8;
    if ((i7 & 0x20) != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i7 & 0x10) != 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (this.e != 2)
    {
      i7 &= 0xF;
      int i8 = this.h.get(i6, i7 - 1);
      this.h.put(i6, i7);
      if (i8 == i7)
      {
        if (i2 != 0)
        {
          this.g.c(i5);
          return 0;
        }
      }
      else {
        if (i7 != (i8 + 1 & 0xF)) {
          break label352;
        }
      }
    }
    i3 = 0;
    label352:
    if (i1 != 0)
    {
      i1 = this.g.g();
      this.g.d(i1);
    }
    if (i2 != 0)
    {
      parame = (v)this.j.get(i6);
      if (parame != null)
      {
        if (i3 != 0) {
          parame.a();
        }
        this.g.b(i5);
        parame.a(this.g, bool);
        this.g.b(i4);
      }
    }
    this.g.c(i5);
    return 0;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    int i2 = this.f.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((com.tencent.luggage.wxa.ao.u)this.f.get(i1)).d();
      i1 += 1;
    }
    this.g.a();
    this.h.clear();
    e();
  }
  
  public void a(f paramf)
  {
    this.l = paramf;
    paramf.a(new k.a(-9223372036854775807L));
  }
  
  public boolean a(com.tencent.luggage.wxa.l.e parame)
  {
    byte[] arrayOfByte = this.g.a;
    parame.c(arrayOfByte, 0, 940);
    int i1 = 0;
    if (i1 < 188)
    {
      int i2 = 0;
      for (;;)
      {
        if (i2 == 5)
        {
          parame.b(i1);
          return true;
        }
        if (arrayOfByte[(i2 * 188 + i1)] != 71)
        {
          i1 += 1;
          break;
        }
        i2 += 1;
      }
    }
    return false;
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.u
 * JD-Core Version:    0.7.0.1
 */