package com.tencent.luggage.wxa.lw;

import com.tencent.luggage.wxa.dp.a;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.jx.u;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import org.json.JSONObject;

public class o
  extends u<h>
{
  public static final int CTRL_INDEX = 98;
  public static final String NAME = "removeStorageSync";
  
  private void a(h paramh, String paramString, int paramInt)
  {
    ((a)com.tencent.luggage.wxa.ba.e.a(a.class)).a(paramh.getAppId()).b(paramInt, paramh.getAppId(), paramString);
  }
  
  private void b(h paramh, String paramString, int paramInt)
  {
    p localp = new p();
    localp.a = paramh.getAppId();
    localp.b = paramInt;
    localp.c = paramString;
    localp.f();
  }
  
  public String a(h paramh, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("key");
    int i = paramJSONObject.optInt("storageId", 0);
    if (af.c(str)) {
      return b("fail");
    }
    if (r.a(i)) {
      return b("fail:nonexistent storage space");
    }
    if (af.c(paramh.getAppId())) {
      return b("fail:appID is empty");
    }
    int j = paramh.q().A().T;
    if (j == 2)
    {
      a(paramh, str, i);
    }
    else if (j == 3)
    {
      a(paramh, str, i);
      b(paramh, str, i);
    }
    else
    {
      b(paramh, str, i);
    }
    return b("ok");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.o
 * JD-Core Version:    0.7.0.1
 */