package com.tencent.luggage.wxa.r;

import com.tencent.luggage.wxa.ao.k.b;

final class j$a$a
{
  private boolean a;
  private boolean b;
  private k.b c;
  private int d;
  private int e;
  private int f;
  private int g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  
  private boolean a(a parama)
  {
    boolean bool1 = this.a;
    boolean bool2 = true;
    if (bool1)
    {
      bool1 = bool2;
      if (!parama.a) {
        break label281;
      }
      bool1 = bool2;
      if (this.f != parama.f) {
        break label281;
      }
      bool1 = bool2;
      if (this.g != parama.g) {
        break label281;
      }
      bool1 = bool2;
      if (this.h != parama.h) {
        break label281;
      }
      if ((this.i) && (parama.i))
      {
        bool1 = bool2;
        if (this.j != parama.j) {
          break label281;
        }
      }
      int i1 = this.d;
      int i2 = parama.d;
      if (i1 != i2)
      {
        bool1 = bool2;
        if (i1 == 0) {
          break label281;
        }
        bool1 = bool2;
        if (i2 == 0) {
          break label281;
        }
      }
      if ((this.c.h == 0) && (parama.c.h == 0))
      {
        bool1 = bool2;
        if (this.m != parama.m) {
          break label281;
        }
        bool1 = bool2;
        if (this.n != parama.n) {
          break label281;
        }
      }
      if ((this.c.h == 1) && (parama.c.h == 1))
      {
        bool1 = bool2;
        if (this.o != parama.o) {
          break label281;
        }
        bool1 = bool2;
        if (this.p != parama.p) {
          break label281;
        }
      }
      boolean bool3 = this.k;
      boolean bool4 = parama.k;
      bool1 = bool2;
      if (bool3 != bool4) {
        break label281;
      }
      if ((bool3) && (bool4) && (this.l != parama.l)) {
        return true;
      }
    }
    bool1 = false;
    label281:
    return bool1;
  }
  
  public void a()
  {
    this.b = false;
    this.a = false;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
    this.b = true;
  }
  
  public void a(k.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.c = paramb;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramInt4;
    this.h = paramBoolean1;
    this.i = paramBoolean2;
    this.j = paramBoolean3;
    this.k = paramBoolean4;
    this.l = paramInt5;
    this.m = paramInt6;
    this.n = paramInt7;
    this.o = paramInt8;
    this.p = paramInt9;
    this.a = true;
    this.b = true;
  }
  
  public boolean b()
  {
    if (this.b)
    {
      int i1 = this.e;
      if ((i1 == 7) || (i1 == 2)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.j.a.a
 * JD-Core Version:    0.7.0.1
 */