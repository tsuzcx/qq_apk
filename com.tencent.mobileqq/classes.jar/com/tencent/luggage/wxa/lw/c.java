package com.tencent.luggage.wxa.lw;

import com.tencent.luggage.wxa.dp.a;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.jx.u;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import org.json.JSONObject;

public class c
  extends u<h>
{
  public static final int CTRL_INDEX = 18;
  public static final String NAME = "clearStorageSync";
  
  private String a(h paramh, int paramInt)
  {
    d locald = new d();
    locald.a = paramh.getAppId();
    locald.b = paramInt;
    locald.f();
    return b("ok");
  }
  
  private String b(h paramh, int paramInt)
  {
    ((a)com.tencent.luggage.wxa.ba.e.a(a.class)).a(paramh.getAppId()).a(paramInt, paramh.getAppId());
    return b("ok");
  }
  
  public String a(h paramh, JSONObject paramJSONObject)
  {
    int i = paramh.q().A().T;
    int j = paramJSONObject.optInt("storageId", 0);
    if (r.a(j)) {
      return b("fail:nonexistent storage space");
    }
    if (i == 2) {
      return b(paramh, j);
    }
    if (i == 3)
    {
      a(paramh, j);
      return b(paramh, j);
    }
    return a(paramh, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.c
 * JD-Core Version:    0.7.0.1
 */