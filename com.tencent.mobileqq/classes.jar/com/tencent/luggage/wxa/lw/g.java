package com.tencent.luggage.wxa.lw;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class g
  extends com.tencent.luggage.wxa.jx.a<h>
{
  public static final int CTRL_INDEX = 17;
  public static final String NAME = "getStorage";
  
  private void a(int paramInt1, int paramInt2, long paramLong, h paramh)
  {
    q.a(paramInt1, 2, paramInt2, 1, System.currentTimeMillis() - paramLong, paramh);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, c paramc, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    localHashMap.put("data", str);
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    localHashMap.put("dataType", paramString2);
    paramc.a(paramInt, a(paramString1, localHashMap));
  }
  
  protected String a(c paramc)
  {
    return paramc.getAppId();
  }
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    String str = paramJSONObject.optString("key");
    int i = paramJSONObject.optInt("storageId", 0);
    if (r.a(i))
    {
      paramh.a(paramInt, b("fail:nonexistent storage space"));
      return;
    }
    if (af.c(str))
    {
      paramh.a(paramInt, b("fail:key is empty"));
      return;
    }
    paramJSONObject = a(paramh);
    if (af.c(paramJSONObject))
    {
      paramh.a(paramInt, b("fail:appID is empty"));
      return;
    }
    long l2 = System.currentTimeMillis();
    Object localObject = paramh.q().A();
    if (localObject == null)
    {
      o.b("MicroMsg.JsApiGetStorage", "invoke with appId[%s] callbackId[%d], NULL sysConfig", new Object[] { paramh.getAppId(), Integer.valueOf(paramInt) });
      paramh.a(paramInt, b("fail:internal error"));
      return;
    }
    if (((com.tencent.luggage.wxa.jj.l)localObject).T != 1)
    {
      com.tencent.luggage.wxa.rd.a.b(new g.1(this, paramh, i, paramJSONObject, str, paramInt, l2), "JsApiGetStorage");
      return;
    }
    localObject = new l();
    ((l)localObject).a = paramJSONObject;
    ((l)localObject).d = str;
    ((l)localObject).b = i;
    ((l)localObject).c = new g.2(this, (l)localObject, paramh, paramInt, str, l2, l1);
    ((l)localObject).h();
    ((l)localObject).g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.g
 * JD-Core Version:    0.7.0.1
 */