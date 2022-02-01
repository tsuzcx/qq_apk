package com.tencent.luggage.wxa.lw;

import com.tencent.luggage.wxa.dp.a;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.jx.u;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.appstorage.m.a;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class k
  extends u<h>
{
  public static final int CTRL_INDEX = 17;
  public static final String NAME = "getStorageSync";
  
  private void a(int paramInt1, int paramInt2, long paramLong, h paramh)
  {
    q.a(paramInt1, 2, paramInt2, 1, System.currentTimeMillis() - paramLong, paramh);
  }
  
  public String a(h paramh, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("key");
    int i = paramJSONObject.optInt("storageId", 0);
    if (af.c(str)) {
      return b("fail:key is empty");
    }
    if (r.a(i)) {
      return b("fail:nonexistent storage space");
    }
    Object localObject1 = paramh.getAppId();
    if (af.c((String)localObject1)) {
      return b("fail:appID is empty");
    }
    long l = System.currentTimeMillis();
    if (paramh.q().A().T != 1)
    {
      localObject1 = ((a)com.tencent.luggage.wxa.ba.e.a(a.class)).a(paramh.getAppId()).a(i, (String)localObject1, str);
      localObject2 = (m.a)localObject1[0];
      localObject3 = m.a.a;
      paramJSONObject = null;
      if (localObject2 == localObject3)
      {
        paramJSONObject = (String)localObject1[1];
        localObject1 = (String)localObject1[2];
      }
      else
      {
        localObject1 = null;
      }
      localObject2 = paramJSONObject;
      i = 2;
      paramJSONObject = (JSONObject)localObject1;
      localObject1 = localObject2;
    }
    else
    {
      paramJSONObject = new l();
      paramJSONObject.a = ((String)localObject1);
      paramJSONObject.b = i;
      paramJSONObject.d = str;
      paramJSONObject.f();
      localObject1 = paramJSONObject.e;
      paramJSONObject = paramJSONObject.f;
      i = 1;
    }
    a(i, r.a(str, (String)localObject1), l, paramh);
    if (localObject1 == null) {
      paramh = "fail:data not found";
    } else {
      paramh = "ok";
    }
    Object localObject3 = new HashMap();
    str = "";
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    ((Map)localObject3).put("data", localObject2);
    if (paramJSONObject == null) {
      paramJSONObject = str;
    }
    ((Map)localObject3).put("dataType", paramJSONObject);
    return a(paramh, (Map)localObject3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.k
 * JD-Core Version:    0.7.0.1
 */