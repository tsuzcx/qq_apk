package com.tencent.luggage.wxa.jj;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.List;
import org.json.JSONObject;

public final class s$a
{
  public long a = 0L;
  public String b;
  public long c = 0L;
  public int d;
  public List<String> e;
  public List<String> f;
  public List<String> g;
  public List<String> h;
  public List<String> i;
  public String j;
  public int k;
  public String l;
  private int m;
  
  public static a a(String paramString)
  {
    if (af.c(paramString))
    {
      o.b("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json is EMPTY");
      return null;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      a locala = new a();
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("RunningFlagInfo");
      if (localJSONObject2 != null)
      {
        locala.a = localJSONObject2.optLong("RunningFlag");
        locala.b = localJSONObject2.optString("AppOpenForbiddenUrl");
        locala.c = localJSONObject2.optLong("CanNotStarWxaBeforeTime", 0L);
      }
      localJSONObject2 = localJSONObject1.optJSONObject("Network");
      if (localJSONObject2 != null)
      {
        locala.e = w.a(localJSONObject2.optJSONArray("RequestDomain"));
        locala.f = w.a(localJSONObject2.optJSONArray("WsRequestDomain"));
        locala.g = w.a(localJSONObject2.optJSONArray("UploadDomain"));
        locala.h = w.a(localJSONObject2.optJSONArray("DownloadDomain"));
        locala.i = w.a(localJSONObject2.optJSONArray("UDPDomain"));
      }
      locala.m = localJSONObject1.optInt("WechatPluginApp", 0);
      locala.d = localJSONObject1.optInt("AppServiceType", 0);
      locala.j = localJSONObject1.optString("fromBusinessUsername");
      locala.k = localJSONObject1.optInt("OriginalFlag", 0);
      locala.l = localJSONObject1.optString("OriginalRedirectUrl");
      return locala;
    }
    catch (Exception localException)
    {
      o.b("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json(%s) parse failed ex = %s", new Object[] { paramString, localException });
    }
    return null;
  }
  
  public boolean a()
  {
    return this.d == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.s.a
 * JD-Core Version:    0.7.0.1
 */