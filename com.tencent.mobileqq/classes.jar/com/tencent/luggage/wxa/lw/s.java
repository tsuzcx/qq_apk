package com.tencent.luggage.wxa.lw;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.dp.a;
import com.tencent.luggage.wxa.jj.g;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import org.json.JSONObject;

public class s
  extends com.tencent.luggage.wxa.jx.u<h>
{
  public static final int CTRL_INDEX = 16;
  public static final String NAME = "setStorageSync";
  
  private String a(h paramh, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    long l = System.currentTimeMillis();
    try
    {
      t localt = new t();
      localt.a = paramh.getAppId();
      localt.b = paramInt;
      localt.a(paramString1, paramString2, paramString3);
      if (localt.f()) {}
      for (paramString3 = localt.d;; paramString3 = "fail")
      {
        q.a(1, 1, r.a(paramString1, paramString2), 1, System.currentTimeMillis() - l, paramh);
        return paramString3;
        o.b("Luggage.FULL.JsApiSetStorageSync", "invokeWithDB appId[%s] key[%s] execSync failed", new Object[] { paramh.getAppId(), paramString1 });
      }
      throw paramString3;
    }
    finally
    {
      q.a(1, 1, r.a(paramString1, paramString2), 1, System.currentTimeMillis() - l, paramh);
    }
    for (;;) {}
  }
  
  @NonNull
  private String b(h paramh, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    long l = System.currentTimeMillis();
    try
    {
      paramString3 = u.a(((a)com.tencent.luggage.wxa.ba.e.a(a.class)).a(paramh.getAppId()).a(paramInt, paramh.getAppId(), paramString1, paramString2, paramString3));
      return paramString3;
    }
    finally
    {
      q.a(2, 1, r.a(paramString1, paramString2), 1, System.currentTimeMillis() - l, paramh);
    }
  }
  
  public String a(h paramh, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("key");
    String str2 = paramJSONObject.optString("data");
    String str3 = paramJSONObject.optString("dataType");
    int i = 0;
    int j = paramJSONObject.optInt("storageId", 0);
    if (af.c(str1)) {
      return b("fail:key is empty");
    }
    if (r.a(j)) {
      return b("fail:nonexistent storage space");
    }
    if (af.c(paramh.getAppId())) {
      return b("fail:appID is empty");
    }
    int k = ((com.tencent.luggage.wxa.ed.d)paramh.q()).i().D.g;
    int m = str1.length();
    if (str2 != null) {
      i = str2.length();
    }
    if (m + i > k) {
      return b("fail:entry size limit reached");
    }
    i = paramh.q().A().T;
    if (i == 2)
    {
      paramh = b(paramh, str1, str2, str3, j);
    }
    else if (i == 3)
    {
      paramJSONObject = b(paramh, str1, str2, str3, j);
      a(paramh, str1, str2, str3, j);
      paramh = paramJSONObject;
    }
    else
    {
      paramh = a(paramh, str1, str2, str3, j);
    }
    return b(paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.s
 * JD-Core Version:    0.7.0.1
 */