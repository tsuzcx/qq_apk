package com.tencent.luggage.wxa.lf;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.kd.h;
import com.tencent.luggage.wxa.nz.d;
import com.tencent.luggage.wxa.nz.d.b;
import com.tencent.luggage.wxa.nz.f;
import com.tencent.luggage.wxa.nz.j;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mars.cdn.CronetLogic;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class a
  implements h
{
  public static int a = 0;
  public static int b = 1;
  private d.b c;
  private boolean d = false;
  private com.tencent.luggage.wxa.kd.a e;
  private final AtomicBoolean f = new AtomicBoolean(false);
  
  public a(d.b paramb, com.tencent.luggage.wxa.kd.a parama)
  {
    o.d("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask");
    this.c = paramb;
    this.e = parama;
  }
  
  private void a(@NonNull c paramc)
  {
    Object localObject = this.c;
    if (localObject != null) {
      this.d = ((d.b)localObject).a(paramc.getAppId());
    }
    if (this.d)
    {
      localObject = (com.tencent.luggage.wxa.nz.a)paramc.b(com.tencent.luggage.wxa.nz.a.class);
      CronetLogic.initializeNativeLib();
      if (localObject == null)
      {
        o.b("MicroMsg.BaseCreateRequestTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", new Object[] { paramc.getAppId() });
        CronetLogic.setUserCertVerify(false);
        return;
      }
      o.d("MicroMsg.BaseCreateRequestTask", "setupRequestMode(%b),appId(%s)", new Object[] { Boolean.valueOf(((com.tencent.luggage.wxa.nz.a)localObject).A), paramc.getAppId() });
      CronetLogic.setUserCertVerify(((com.tencent.luggage.wxa.nz.a)localObject).A);
    }
  }
  
  private final void a(c paramc, String paramString1, String paramString2)
  {
    o.c("MicroMsg.BaseCreateRequestTask", "sendFailMsg, requestTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("requestTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a.a().b(paramc).b(paramString2).a(this.e.a(paramString1));
    this.e.b(paramString1);
  }
  
  public void a(c paramc, JSONObject paramJSONObject, String paramString)
  {
    o.e("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask");
    if (!this.f.getAndSet(true)) {
      a(paramc);
    }
    a.1 local1 = new a.1(this, new WeakReference(paramc), System.currentTimeMillis(), paramString);
    String str = paramJSONObject.optString("url");
    if (af.c(str))
    {
      o.b("MicroMsg.BaseCreateRequestTask", "url is null appId[%s] taskId[%s]", new Object[] { paramc.getAppId(), paramString });
      a(paramc, paramString, "url is null or nil");
      return;
    }
    com.tencent.luggage.wxa.nz.a locala = (com.tencent.luggage.wxa.nz.a)paramc.b(com.tencent.luggage.wxa.nz.a.class);
    int j = 60000;
    int k = paramJSONObject.optInt("timeout", 0);
    o.d("MicroMsg.BaseCreateRequestTask", "lm:data configTimeout %d", new Object[] { Integer.valueOf(k) });
    int i = k;
    if (k <= 0)
    {
      i = j.a(locala, 0);
      o.d("MicroMsg.BaseCreateRequestTask", "lm:getRequiredTimeout configTimeout %d", new Object[] { Integer.valueOf(i) });
    }
    if (i > 0) {
      j = i;
    }
    o.d("MicroMsg.BaseCreateRequestTask", "lm:configTimeout: %d,timeout: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (locala.g <= 0) {
      o.d("MicroMsg.BaseCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
    }
    Map localMap = j.a(paramJSONObject, locala);
    boolean bool;
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {
      bool = false;
    } else {
      bool = locala.b;
    }
    if ((bool) && (!j.a(locala.k, str)))
    {
      o.d("MicroMsg.BaseCreateRequestTask", "not in domain url %s", new Object[] { str });
      a(paramc, paramString, "url not in domain list");
      return;
    }
    d locald;
    if (f.b().a(paramc.getAppId()) == null)
    {
      locald = new d(paramc, this.d);
      f.b().a(paramc.getAppId(), locald);
    }
    else
    {
      locald = f.b().a(paramc.getAppId());
    }
    o.d("MicroMsg.BaseCreateRequestTask", "request url: %s, appId:%s, taskId:%s", new Object[] { str, paramc.getAppId(), paramString });
    if (locald != null)
    {
      if (!bool)
      {
        o.d("MicroMsg.BaseCreateRequestTask", "debug type, do not verify domains");
        locald.a(paramc, j, paramJSONObject, localMap, null, local1, paramString, "createRequestTask");
        return;
      }
      locald.a(paramc, j, paramJSONObject, localMap, locala.k, local1, paramString, "createRequestTask");
      return;
    }
    a(paramc, paramString, "create request error");
  }
  
  public String x_()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(f.b().a());
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public String y_()
  {
    return "requestTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lf.a
 * JD-Core Version:    0.7.0.1
 */