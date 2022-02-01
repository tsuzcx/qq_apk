package com.tencent.luggage.wxa.bi;

import android.app.Activity;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.cx.u;
import com.tencent.luggage.wxa.dc.q;
import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.ew.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

class a$a
{
  @NonNull
  final com.tencent.luggage.wxa.eo.a a;
  @NonNull
  final com.tencent.luggage.wxa.ou.d b;
  
  public a$a(c paramc, com.tencent.luggage.wxa.ou.d paramd, a.b paramb)
  {
    this.a = new com.tencent.luggage.wxa.eo.a(paramd.p());
    q.a(this.c.D, this.c.E, this.c.F);
    paramd = new HashMap(this.d.f.size());
    Iterator localIterator = this.d.f.iterator();
    while (localIterator.hasNext())
    {
      locala = (com.tencent.luggage.wxa.ew.a)localIterator.next();
      paramd.put(locala.a, locala.b);
    }
    this.a.w = ((String)paramd.get("clientApplicationId"));
    this.a.x = this.d.g;
    this.a.y = this.d.h;
    this.a.s = this.d.m;
    this.a.r = this.d.n;
    this.a.a(this.d.i);
    this.a.z = this.d.k;
    this.a.A = u.b.b();
    this.a.e = this.d.l;
    this.a.j = this.d.o;
    u.b.a(this.a.D, com.tencent.luggage.wxa.dg.d.a.d());
    paramd = paramb;
    if (paramb == null) {
      paramd = paramc.a();
    }
    this.b = paramd;
  }
  
  void a()
  {
    Object localObject;
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      localObject = this.f.u();
      if (localObject == null)
      {
        o.b("Luggage.AppBrandRuntimeContainerStandaloneImpl", "Loader.load(), activity null, return, appId:%s, type:%d", new Object[] { this.a.D, Integer.valueOf(this.a.G) });
        return;
      }
      ((Activity)localObject).runOnUiThread(new a.a.1(this));
      return;
    }
    if (a.a(this.f))
    {
      o.b("Luggage.AppBrandRuntimeContainerStandaloneImpl", "Loader.load() appId:%s, type:%d, container is destroyed, return", new Object[] { this.a.D, Integer.valueOf(this.a.G) });
      localObject = this.e;
      if (localObject != null) {
        ((a.b)localObject).a(false);
      }
      return;
    }
    com.tencent.luggage.wxa.ef.d.a("AppBrandRuntimeContainerStandaloneImpl.loadStandaloneImpl", new a.a.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bi.a.a
 * JD-Core Version:    0.7.0.1
 */