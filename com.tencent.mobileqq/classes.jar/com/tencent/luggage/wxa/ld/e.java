package com.tencent.luggage.wxa.ld;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.nz.j;
import com.tencent.luggage.wxa.nz.k;
import com.tencent.luggage.wxa.nz.k.a;
import com.tencent.luggage.wxa.nz.k.c;
import com.tencent.luggage.wxa.nz.l;
import com.tencent.luggage.wxa.pm.f;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  extends b
{
  public static final int CTRL_INDEX = 346;
  public static final String NAME = "createSocketTask";
  public static int a = 0;
  public static int b = 1;
  private static k.a c;
  private k.c d;
  private int e = a;
  private boolean f = false;
  private boolean g = false;
  private final AtomicBoolean h = new AtomicBoolean(false);
  
  public e(int paramInt, k.c paramc)
  {
    o.d("MicroMsg.JsApiCreateSocketTask", "JsApiCreateSocketTask, programType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.e = paramInt;
    this.d = paramc;
  }
  
  private JSONObject a(f paramf)
  {
    localJSONObject = new JSONObject();
    Iterator localIterator = paramf.c();
    try
    {
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramf.b(str));
      }
      return localJSONObject;
    }
    catch (JSONException paramf)
    {
      o.a("MicroMsg.JsApiCreateSocketTask", paramf, "JSONExceptions ", new Object[0]);
    }
  }
  
  private void a(@NonNull com.tencent.luggage.wxa.jx.c paramc)
  {
    k.c localc = this.d;
    if (localc != null)
    {
      this.f = localc.a(paramc.getAppId());
      this.g = this.d.b(paramc.getAppId());
    }
    WcWss.a();
  }
  
  public static void a(com.tencent.luggage.wxa.jx.c paramc, String paramString1, com.tencent.luggage.wxa.ix.b paramb, String paramString2, e parame)
  {
    if ((paramb == com.tencent.luggage.wxa.ix.b.c) || (paramb == com.tencent.luggage.wxa.ix.b.d))
    {
      paramString1 = l.a().a(paramString1);
      if (paramString1 == null) {
        return;
      }
      paramString1.b(paramString1.a(paramString2));
      paramString1 = new HashMap();
      paramString1.put("reason", "interrupted");
      paramString1.put("socketTaskId", paramString2);
      paramString1.put("state", "close");
      paramString1 = new JSONObject(paramString1).toString();
      new e.a().b(paramc).b(paramString1).a(parame.c().a(paramString2));
      parame.c().b(paramString2);
    }
  }
  
  private void a(com.tencent.luggage.wxa.jx.c paramc, String paramString1, String paramString2)
  {
    if (af.c(paramString2))
    {
      paramString2 = "fail";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fail:");
      ((StringBuilder)localObject).append(paramString2);
      paramString2 = ((StringBuilder)localObject).toString();
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("socketTaskId", paramString1);
    ((Map)localObject).put("state", "error");
    ((Map)localObject).put("errMsg", paramString2);
    paramString2 = new JSONObject((Map)localObject).toString();
    new e.a().b(paramc).b(paramString2).a(c().a(paramString1));
    c().b(paramString1);
    o.e("MicroMsg.JsApiCreateSocketTask", "onSocketConnectFail jsonResult:%s ", new Object[] { paramString2 });
    ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(972L, 3L, 1L, false);
  }
  
  public static void a(k.a parama)
  {
    c = parama;
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, String paramString)
  {
    if (!this.h.getAndSet(true)) {
      a(paramc);
    }
    Object localObject2 = l.a().a(paramc.getAppId());
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (((this.e == a) && (this.f)) || ((this.e == b) && (this.g) && ((c().a(paramString) == null) || ((c().a(paramString) instanceof i)))))
      {
        localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.websocket.a((com.tencent.luggage.wxa.nz.a)paramc.b(com.tencent.luggage.wxa.nz.a.class));
      }
      else
      {
        o.e("MicroMsg.JsApiCreateSocketTask", "hy: trigger use legacy ws");
        localObject1 = new k((com.tencent.luggage.wxa.nz.a)paramc.b(com.tencent.luggage.wxa.nz.a.class));
      }
      l.a().a(paramc.getAppId(), (d)localObject1);
    }
    boolean bool = paramJSONObject.optBoolean("enableProfile", true);
    localObject2 = new e.1(this, paramc, paramString, bool);
    String str = paramJSONObject.optString("url");
    if (af.c(str))
    {
      o.d("MicroMsg.JsApiCreateSocketTask", "url is null");
      a(paramc, paramString, "url is null");
      return;
    }
    o.d("MicroMsg.JsApiCreateSocketTask", "useProfile:%b,url is:%s", new Object[] { Boolean.valueOf(bool), str });
    com.tencent.luggage.wxa.nz.a locala = (com.tencent.luggage.wxa.nz.a)paramc.b(com.tencent.luggage.wxa.nz.a.class);
    Map localMap = j.a(paramJSONObject, locala);
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {
      bool = false;
    } else {
      bool = locala.b;
    }
    if ((bool) && (!j.a(locala.l, str, locala.t)))
    {
      o.d("MicroMsg.JsApiCreateSocketTask", "not in domain url %s", new Object[] { str });
      a(paramc, paramString, "url not in domain list");
      return;
    }
    int j = paramJSONObject.optInt("timeout", 0);
    int i = j;
    if (j <= 0) {
      i = j.a(locala, 1);
    }
    if (i <= 0) {
      i = 60000;
    }
    ((d)localObject1).a(paramc.getAppId(), paramString, this.e, i, paramJSONObject, localMap, (d.a)localObject2);
    if ((!this.f) && (!this.g)) {
      ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(972L, 0L, 1L, false);
    } else {
      ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(972L, 10L, 1L, false);
    }
    o.d("MicroMsg.JsApiCreateSocketTask", "connectSocket, url is : %s , componentId: %s", new Object[] { str, Integer.valueOf(paramc.getComponentId()) });
  }
  
  public String x_()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l.a().b());
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public String y_()
  {
    return "socketTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ld.e
 * JD-Core Version:    0.7.0.1
 */