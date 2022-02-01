package com.tencent.luggage.wxa.lw;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class h
  extends com.tencent.luggage.wxa.jx.a<com.tencent.luggage.wxa.jx.h>
{
  public static final int CTRL_INDEX = 113;
  public static final String NAME = "getStorageInfo";
  
  private void a(int paramInt1, List<String> paramList, int paramInt2, long paramLong, com.tencent.luggage.wxa.jx.h paramh)
  {
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    q.a(paramInt1, 3, paramInt2, i, System.currentTimeMillis() - paramLong, paramh);
  }
  
  private void a(List paramList, int paramInt1, int paramInt2, c paramc, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("keys", paramList);
    localHashMap.put("currentSize", Integer.valueOf(paramInt1));
    localHashMap.put("limitSize", Integer.valueOf(paramInt2));
    paramc.a(paramInt3, a("ok", localHashMap));
  }
  
  protected String a(c paramc)
  {
    return paramc.getAppId();
  }
  
  public void a(com.tencent.luggage.wxa.jx.h paramh, JSONObject paramJSONObject, int paramInt)
  {
    int i = paramJSONObject.optInt("storageId", 0);
    if (r.a(i))
    {
      paramh.a(paramInt, b("fail:nonexistent storage space"));
      return;
    }
    long l = System.currentTimeMillis();
    paramJSONObject = new WeakReference(paramh);
    if (paramh.q().A().T != 1)
    {
      com.tencent.luggage.wxa.rd.a.b(new h.1(this, paramJSONObject, i, paramInt, l), "JsApiGetStorageInfo");
      return;
    }
    j localj = new j();
    localj.a = a(paramh);
    localj.b = i;
    localj.f = new h.2(this, localj, paramJSONObject, paramInt, l);
    localj.h();
    localj.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.h
 * JD-Core Version:    0.7.0.1
 */