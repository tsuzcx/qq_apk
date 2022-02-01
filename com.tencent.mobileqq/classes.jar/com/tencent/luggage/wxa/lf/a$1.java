package com.tencent.luggage.wxa.lf;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.nz.d;
import com.tencent.luggage.wxa.nz.d.a;
import com.tencent.luggage.wxa.nz.f;
import com.tencent.luggage.wxa.pd.p;
import com.tencent.luggage.wxa.pd.p.a;
import com.tencent.luggage.wxa.pd.p.b;
import com.tencent.luggage.wxa.qy.b;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class a$1
  implements d.a
{
  a$1(a parama, WeakReference paramWeakReference, long paramLong, String paramString) {}
  
  public void a(String paramString, Object paramObject, int paramInt, JSONObject paramJSONObject, Map paramMap)
  {
    int i;
    if ((paramObject != null) && ((paramObject instanceof ByteBuffer))) {
      i = ((ByteBuffer)paramObject).array().length;
    } else if ((paramObject != null) && ((paramObject instanceof String))) {
      i = ((String)paramObject).length();
    } else {
      i = 0;
    }
    c localc = (c)this.a.get();
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.BaseCreateRequestTask", "onRequestResultWithCode, time: %d, data size: %d, code %s,requestTaskId %s, service:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.b), Integer.valueOf(i), Integer.valueOf(paramInt), this.c, localc });
    if (localc == null) {
      return;
    }
    Object localObject = f.b().a(localc.getAppId());
    if ((localObject != null) && (((d)localObject).b(this.c)))
    {
      com.tencent.luggage.wxa.qz.o.e("MicroMsg.BaseCreateRequestTask", "request abort %s", new Object[] { this.c });
      return;
    }
    localObject = new HashMap();
    ((Map)localObject).put("requestTaskId", this.c);
    if (paramString.equalsIgnoreCase("ok"))
    {
      ((Map)localObject).put("state", "success");
      ((Map)localObject).put("data", paramObject);
      if ((paramMap != null) && (paramMap.size() > 0)) {
        ((Map)localObject).put("profile", paramMap);
      }
    }
    else
    {
      ((Map)localObject).put("state", "fail");
    }
    ((Map)localObject).put("statusCode", Integer.valueOf(paramInt));
    if (paramJSONObject != null) {
      ((Map)localObject).put("header", paramJSONObject);
    }
    paramString = new a.a();
    paramJSONObject = p.a(localc.getJsRuntime(), (Map)localObject, (p.a)localc.b(p.a.class));
    if (((paramObject != null) && ((paramObject instanceof String))) || (paramJSONObject == p.b.a))
    {
      paramObject = new JSONObject((Map)localObject).toString();
      paramString.b(localc).b(paramObject).a(a.a(this.d).a(this.c));
    }
    else if (paramJSONObject == p.b.b)
    {
      p.a(localc, "onRequestTaskStateChange");
    }
    a.a(this.d).b(this.c);
  }
  
  public void a(String paramString1, String paramString2)
  {
    c localc = (c)this.a.get();
    long l1 = System.currentTimeMillis();
    long l2 = this.b;
    int i;
    if (paramString2 == null) {
      i = 0;
    } else {
      i = paramString2.length();
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.BaseCreateRequestTask", "onRequestResult, time: %d, data size: %d,requestTaskId %s, service:%s", new Object[] { Long.valueOf(l1 - l2), Integer.valueOf(i), this.c, localc });
    if (localc == null) {
      return;
    }
    if ("fail".equals(paramString1)) {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.BaseCreateRequestTask", "onRequestResult taskId[%s] reason[%s] data[%s]", new Object[] { this.c, paramString1, paramString2 });
    }
    paramString1 = f.b().a(localc.getAppId());
    if ((paramString1 != null) && (paramString1.b(this.c)))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.BaseCreateRequestTask", "request abort %s", new Object[] { this.c });
      return;
    }
    a.a(this.d, localc, this.c, paramString2);
    ((com.tencent.luggage.wxa.nz.o)e.b(com.tencent.luggage.wxa.nz.o.class)).a(localc.getAppId());
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    Object localObject1 = (c)this.a.get();
    if (localObject1 == null) {
      return;
    }
    if (paramJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
    {
      if (!((com.tencent.luggage.wxa.nz.a)((c)localObject1).b(com.tencent.luggage.wxa.nz.a.class)).y) {
        return;
      }
      paramJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
      localObject1 = new com.tencent.luggage.wxa.gz.a();
      ((com.tencent.luggage.wxa.gz.a)localObject1).a.a = "request";
      ((com.tencent.luggage.wxa.gz.a)localObject1).a.c = paramJSONObject;
      ((com.tencent.luggage.wxa.gz.a)localObject1).a.b = this.c;
      com.tencent.luggage.wxa.qy.a.a.a((b)localObject1);
      return;
    }
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("requestTaskId", this.c);
    ((Map)localObject2).put("state", "headersReceived");
    ((Map)localObject2).put("header", paramJSONObject);
    paramJSONObject = new a.a();
    localObject2 = new JSONObject((Map)localObject2).toString();
    paramJSONObject.b((c)localObject1).b((String)localObject2).a(a.a(this.d).a(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lf.a.1
 * JD-Core Version:    0.7.0.1
 */