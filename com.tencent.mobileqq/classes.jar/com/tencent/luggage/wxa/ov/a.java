package com.tencent.luggage.wxa.ov;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.bg;
import java.util.LinkedList;

public final class a
  implements f
{
  private final String a;
  private final com.tencent.luggage.wxa.ed.d b;
  private Intent c;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private j g = null;
  private k h = null;
  private m i = null;
  private n j = null;
  private volatile h k = null;
  private final com.tencent.luggage.wxa.ot.d l;
  private final com.tencent.luggage.wxa.ot.c m;
  
  public a(com.tencent.luggage.wxa.ed.d paramd)
  {
    this.a = paramd.aa();
    this.b = paramd;
    this.j = n.a(this.b);
    c();
    this.l = ((com.tencent.luggage.wxa.ot.d)e.b(com.tencent.luggage.wxa.ot.d.class));
    this.m = ((com.tencent.luggage.wxa.ot.c)e.b(com.tencent.luggage.wxa.ot.c.class));
  }
  
  private void a(long paramLong, int paramInt)
  {
    if (this.l == null)
    {
      o.b("MicroMsg.AppBrandPageContainerReporter", "reportKv13543 costTime:%d, loadType:%d, null kvRepoter", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      return;
    }
    int n = this.b.i().S.pkgVersion;
    this.l.a(13543, new Object[] { this.a, Integer.valueOf(n), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
  }
  
  private void a(@NonNull com.tencent.luggage.wxa.dq.c paramc1, @Nullable com.tencent.luggage.wxa.dq.c paramc2)
  {
    if (paramc2 != null)
    {
      this.g.a(paramc2, paramc1.ao());
      this.i.a(paramc2, paramc1.ao());
    }
    this.h.b(paramc1);
  }
  
  public h a()
  {
    return this.k;
  }
  
  public void a(long paramLong)
  {
    a(paramLong, 4);
  }
  
  public void a(long paramLong, bg parambg)
  {
    int n = a.1.a[parambg.ordinal()];
    int i1 = 5;
    if (n != 1)
    {
      if ((n != 2) && (n != 3) && (n != 4) && (n != 5)) {
        n = 2;
      } else {
        n = 3;
      }
    }
    else {
      n = 1;
    }
    a(paramLong, n);
    com.tencent.luggage.wxa.ot.c localc = this.m;
    if (localc == null)
    {
      o.b("MicroMsg.AppBrandPageContainerReporter", "reportPageLoadTime, time:%d, type:%s, null idKeyReporter", new Object[] { Long.valueOf(paramLong), parambg });
      return;
    }
    localc.a(390L, 0L, 1L, false);
    n = i1;
    switch ((int)paramLong / 250)
    {
    default: 
      n = 7;
      break;
    case 6: 
    case 7: 
      n = 6;
      break;
    case 3: 
      n = 4;
      break;
    case 2: 
      n = 3;
      break;
    case 1: 
      n = 2;
      break;
    case 0: 
      n = 1;
    }
    this.m.a(390L, n, 1L, false);
  }
  
  public void a(Intent paramIntent)
  {
    this.c = paramIntent;
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.dq.c paramc)
  {
    this.d = true;
    this.k.a(paramc);
    paramc.b().f();
    this.g.a(paramc);
    this.i.a(paramc);
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.dq.c paramc1, @Nullable com.tencent.luggage.wxa.dq.c paramc2, @NonNull bg parambg)
  {
    Object localObject = bg.g;
    int n = 0;
    if ((localObject == parambg) && (this.f))
    {
      this.f = false;
      c();
    }
    else
    {
      this.f = false;
    }
    if ((bg.g == parambg) || (paramc2 == null) || (com.tencent.luggage.wxa.qz.af.c(paramc2.ao())) || (paramc2 == paramc1)) {
      n = 1;
    }
    h localh = this.k;
    if (n != 0) {
      localObject = null;
    } else {
      localObject = paramc2;
    }
    localh.a(paramc1, (com.tencent.luggage.wxa.dq.c)localObject, parambg);
    if (n == 0)
    {
      paramc2.b().f();
      a(paramc1, paramc2);
      return;
    }
    a(paramc1, null);
  }
  
  public Intent b()
  {
    return this.c;
  }
  
  public void b(com.tencent.luggage.wxa.dq.c paramc)
  {
    if (paramc != null)
    {
      if (this.d) {
        return;
      }
      a(paramc);
    }
  }
  
  public void c()
  {
    if (com.tencent.luggage.wxa.qz.af.c(this.a))
    {
      o.b("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", new Object[] { com.tencent.luggage.wxa.qz.af.a(new Throwable()) });
      this.k = h.a;
      this.h = k.a();
      this.g = j.a();
      this.i = m.a();
      return;
    }
    String str1 = this.b.j().h();
    String str2 = com.tencent.luggage.wxa.ou.f.a(this.b.j().h);
    this.k = new c(str2, this.b.as());
    this.g = j.a(this.b, str1, this.k);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.push(com.tencent.luggage.wxa.qz.af.b(str2));
    this.i = m.a(this.b, str1, localLinkedList);
    this.h = k.a(this.b, str1, this.k);
  }
  
  public void c(@NonNull com.tencent.luggage.wxa.dq.c paramc)
  {
    this.c = null;
    if (this.e)
    {
      this.e = false;
      return;
    }
    this.k.c(paramc);
    this.h.a(paramc);
  }
  
  public m d()
  {
    return this.i;
  }
  
  public n e()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ov.a
 * JD-Core Version:    0.7.0.1
 */