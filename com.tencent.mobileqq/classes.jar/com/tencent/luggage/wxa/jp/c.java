package com.tencent.luggage.wxa.jp;

import android.util.Log;
import com.tencent.luggage.wxa.jn.e;
import com.tencent.luggage.wxa.jn.m;
import com.tencent.luggage.wxa.jn.n;
import com.tencent.luggage.wxa.jo.b;
import com.tencent.luggage.wxa.jo.f;
import com.tencent.luggage.wxa.jq.a;
import java.util.HashMap;
import java.util.Map;

public class c
{
  private String a;
  private int b;
  private boolean c = false;
  private Map<String, com.tencent.luggage.wxa.jr.c> d = new HashMap();
  private Map<String, com.tencent.luggage.wxa.jr.c> e = new HashMap();
  private c.a f = new c.5(this);
  
  public static c a()
  {
    return c.b.a();
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://");
    localStringBuilder.append(this.a);
    localStringBuilder.append(":");
    localStringBuilder.append(this.b);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void d()
  {
    if (!this.c) {
      Log.w("MRSubscriptionManager", "checkEnable: MRSubscriptionManager is not enable!");
    }
  }
  
  public void a(com.tencent.luggage.wxa.jo.c paramc, a parama)
  {
    d();
    f localf = paramc.g();
    com.tencent.luggage.wxa.jr.c localc = paramc.e();
    if ((localf != null) && (localc != null) && (localc.a != null))
    {
      paramc = new n(g.a(paramc.a().b, paramc.a().c, localf.e), localc.a);
      h.a().a(paramc, new c.3(this, localc, parama));
      return;
    }
    if (parama != null) {
      parama.b(null);
    }
  }
  
  public void a(com.tencent.luggage.wxa.jo.c paramc, com.tencent.luggage.wxa.jq.c paramc1)
  {
    d();
    Object localObject = paramc.g();
    if (localObject != null)
    {
      String str = a("/upnp/cb/AVTransport");
      localObject = new m(g.a(paramc.a().b, paramc.a().c, ((f)localObject).e), str);
      h.a().a((e)localObject, new c.1(this, paramc, paramc1));
      return;
    }
    if (paramc1 != null) {
      paramc1.a(null);
    }
  }
  
  public void b(com.tencent.luggage.wxa.jo.c paramc, a parama)
  {
    d();
    f localf = paramc.h();
    com.tencent.luggage.wxa.jr.c localc = paramc.f();
    if ((localf != null) && (localc != null) && (localc.a != null))
    {
      paramc = new n(g.a(paramc.a().b, paramc.a().c, localf.e), localc.a);
      h.a().a(paramc, new c.4(this, localc, parama));
      return;
    }
    if (parama != null) {
      parama.b(null);
    }
  }
  
  public void b(com.tencent.luggage.wxa.jo.c paramc, com.tencent.luggage.wxa.jq.c paramc1)
  {
    d();
    Object localObject = paramc.h();
    if (localObject != null)
    {
      String str = a("/upnp/cb/RenderControl");
      localObject = new m(g.a(paramc.a().b, paramc.a().c, ((f)localObject).e), str);
      h.a().a((e)localObject, new c.2(this, paramc, paramc1));
      return;
    }
    if (paramc1 != null) {
      paramc1.a(null);
    }
  }
  
  public boolean b()
  {
    this.c = true;
    d locald = d.a();
    locald.a(this.f);
    locald.b();
    this.a = locald.d();
    this.b = locald.e();
    return true;
  }
  
  public boolean c()
  {
    this.c = false;
    d locald = d.a();
    locald.a(null);
    locald.c();
    this.d.clear();
    this.e.clear();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.c
 * JD-Core Version:    0.7.0.1
 */