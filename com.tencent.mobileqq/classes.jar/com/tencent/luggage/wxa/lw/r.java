package com.tencent.luggage.wxa.lw;

import com.tencent.luggage.wxa.jj.g;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import org.json.JSONObject;

public class r
  extends a<h>
{
  public static final int CTRL_INDEX = 16;
  public static final String NAME = "setStorage";
  private r.a a = new r.1(this);
  
  private void a(int paramInt1, int paramInt2, long paramLong, h paramh)
  {
    q.a(paramInt1, 1, paramInt2, 1, System.currentTimeMillis() - paramLong, paramh);
  }
  
  private void a(h paramh, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, r.a parama)
  {
    long l = System.currentTimeMillis();
    paramh.q().e(new r.2(this, paramh, paramInt2, paramString4, paramString1, paramString2, paramString3, parama, paramInt1, l));
  }
  
  private void b(h paramh, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, r.a parama)
  {
    long l = System.currentTimeMillis();
    t localt = new t();
    localt.a = paramString4;
    localt.b = paramInt2;
    localt.a(paramString1, paramString2, paramString3);
    localt.c = new r.3(this, parama, localt, paramh, paramInt1, paramString1, paramString2, l);
    localt.h();
    localt.g();
  }
  
  protected String a(h paramh)
  {
    return paramh.q().aa();
  }
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    String str1 = paramJSONObject.optString("key");
    String str2 = paramJSONObject.optString("data");
    String str3 = paramJSONObject.optString("dataType");
    int i = 0;
    int j = paramJSONObject.optInt("storageId", 0);
    if (af.c(str1))
    {
      paramh.a(paramInt, b("fail:key is empty"));
      return;
    }
    if (com.tencent.mm.plugin.appbrand.appstorage.r.a(j))
    {
      paramh.a(paramInt, b("fail:nonexistent storage space"));
      return;
    }
    paramJSONObject = a(paramh);
    if (af.c(paramJSONObject))
    {
      paramh.a(paramInt, b("fail:appID is empty"));
      return;
    }
    l locall = paramh.q().A();
    if (locall == null)
    {
      o.b("MicroMsg.JsApiSetStorage", "invoke with appId[%s] callbackId[%d], NULL sysConfig", new Object[] { paramh.getAppId(), Integer.valueOf(paramInt) });
      paramh.a(paramInt, b("fail:internal error"));
      return;
    }
    int k = ((com.tencent.luggage.wxa.do.d)locall).D.g;
    int m = str1.length();
    if (str2 != null) {
      i = str2.length();
    }
    if (m + i > k)
    {
      paramh.a(paramInt, b("fail:entry size limit reached"));
      return;
    }
    i = locall.T;
    if (i == 2)
    {
      a(paramh, paramInt, j, str1, str2, str3, paramJSONObject, this.a);
      return;
    }
    if (i == 3)
    {
      a(paramh, paramInt, j, str1, str2, str3, paramJSONObject, this.a);
      b(paramh, paramInt, j, str1, str2, str3, paramJSONObject, null);
      return;
    }
    b(paramh, paramInt, j, str1, str2, str3, paramJSONObject, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.r
 * JD-Core Version:    0.7.0.1
 */