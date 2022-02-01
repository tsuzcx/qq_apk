package com.tencent.luggage.wxa.iu;

import androidx.annotation.NonNull;
import com.tencent.luggage.util.b;
import com.tencent.luggage.wxa.do.d;
import com.tencent.luggage.wxa.jj.n;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.s.a;
import com.tencent.luggage.wxa.jj.s.c;
import com.tencent.luggage.wxa.jj.s.c.a;
import java.util.ArrayList;

public class ad
{
  public static <T extends d> T a(@NonNull T paramT, @NonNull s params)
  {
    paramT.I = params.e;
    paramT.K = params.j;
    paramT.J = params.d;
    paramT.L = params.d().a.d;
    paramT.j = params.d().a.e;
    paramT.m = params.d().a.h;
    paramT.n = params.d().a.i;
    paramT.o = params.d().a.j;
    paramT.p = params.d().a.k;
    paramT.q = params.d().a.l;
    paramT.l = params.d().a.g;
    paramT.k = params.d().a.f;
    paramT.r = params.d().a.m;
    paramT.s = params.d().a.n;
    paramT.t = ((ArrayList)b.a(new ArrayList(), params.c().e));
    paramT.u = ((ArrayList)b.a(new ArrayList(), params.c().f));
    paramT.w = ((ArrayList)b.a(new ArrayList(), params.c().h));
    paramT.v = ((ArrayList)b.a(new ArrayList(), params.c().g));
    paramT.x = ((ArrayList)b.a(new ArrayList(), params.c().i));
    paramT.F = params.c().a;
    paramT.Q = params.d().a.p;
    paramT.R = params.d().a.q;
    paramT.y = params.d().a.r;
    paramT.E = new String[] { params.h, params.g, params.i };
    paramT.A = params.d().a.a;
    paramT.B = params.d().a.b;
    paramT.b = n.a(paramT.J);
    return paramT;
  }
  
  @NonNull
  public static <T extends d> T a(@NonNull ad.a<T> parama, @NonNull s params)
  {
    parama = (d)parama.a();
    a(parama, params);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.ad
 * JD-Core Version:    0.7.0.1
 */