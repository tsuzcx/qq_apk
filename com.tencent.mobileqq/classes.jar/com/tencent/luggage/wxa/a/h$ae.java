package com.tencent.luggage.wxa.a;

import java.util.List;

class h$ae
  implements Cloneable
{
  Boolean A;
  Boolean B;
  h.ao C;
  Float D;
  String E;
  h.ae.a F;
  String G;
  h.ao H;
  Float I;
  h.ao J;
  Float K;
  h.ae.i L;
  h.ae.e M;
  long a = 0L;
  h.ao b;
  h.ae.a c;
  Float d;
  h.ao e;
  Float f;
  h.p g;
  h.ae.c h;
  h.ae.d i;
  Float j;
  h.p[] k;
  h.p l;
  Float m;
  h.f n;
  List<String> o;
  h.p p;
  Integer q;
  h.ae.b r;
  h.ae.g s;
  h.ae.h t;
  h.ae.f u;
  Boolean v;
  h.c w;
  String x;
  String y;
  String z;
  
  static ae a()
  {
    ae localae = new ae();
    localae.a = -1L;
    localae.b = h.f.b;
    localae.c = h.ae.a.a;
    Float localFloat = Float.valueOf(1.0F);
    localae.d = localFloat;
    localae.e = null;
    localae.f = localFloat;
    localae.g = new h.p(1.0F);
    localae.h = h.ae.c.a;
    localae.i = h.ae.d.a;
    localae.j = Float.valueOf(4.0F);
    localae.k = null;
    localae.l = new h.p(0.0F);
    localae.m = localFloat;
    localae.n = h.f.b;
    localae.o = null;
    localae.p = new h.p(12.0F, h.bd.g);
    localae.q = Integer.valueOf(400);
    localae.r = h.ae.b.a;
    localae.s = h.ae.g.a;
    localae.t = h.ae.h.a;
    localae.u = h.ae.f.a;
    localae.v = Boolean.valueOf(true);
    localae.w = null;
    localae.x = null;
    localae.y = null;
    localae.z = null;
    localae.A = Boolean.TRUE;
    localae.B = Boolean.TRUE;
    localae.C = h.f.b;
    localae.D = localFloat;
    localae.E = null;
    localae.F = h.ae.a.a;
    localae.G = null;
    localae.H = null;
    localae.I = localFloat;
    localae.J = null;
    localae.K = localFloat;
    localae.L = h.ae.i.a;
    localae.M = h.ae.e.a;
    return localae;
  }
  
  void a(boolean paramBoolean)
  {
    this.A = Boolean.TRUE;
    Boolean localBoolean;
    if (paramBoolean) {
      localBoolean = Boolean.TRUE;
    } else {
      localBoolean = Boolean.FALSE;
    }
    this.v = localBoolean;
    this.w = null;
    this.E = null;
    this.m = Float.valueOf(1.0F);
    this.C = h.f.b;
    this.D = Float.valueOf(1.0F);
    this.G = null;
    this.H = null;
    this.I = Float.valueOf(1.0F);
    this.J = null;
    this.K = Float.valueOf(1.0F);
    this.L = h.ae.i.a;
  }
  
  protected Object clone()
  {
    ae localae = (ae)super.clone();
    h.p[] arrayOfp = this.k;
    if (arrayOfp != null) {
      localae.k = ((h.p[])arrayOfp.clone());
    }
    return localae;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.h.ae
 * JD-Core Version:    0.7.0.1
 */