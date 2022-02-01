package com.tencent.luggage.wxa.jz;

import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.rt.i;
import org.json.JSONObject;

public class o
  extends com.tencent.luggage.wxa.jx.a
{
  public static final int CTRL_INDEX = 160;
  public static final String NAME = "setBackgroundAudioState";
  protected o.a a;
  
  @NonNull
  private Pair<String, String> a(@NonNull com.tencent.luggage.wxa.jx.c paramc, @NonNull JSONObject paramJSONObject)
  {
    com.tencent.luggage.wxa.lr.a locala = (com.tencent.luggage.wxa.lr.a)e.a(com.tencent.luggage.wxa.lr.a.class);
    Object localObject = null;
    if (locala == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerHelper is null");
      return new Pair(null, "invalidReferrer");
    }
    String str = locala.a(paramJSONObject);
    if (str != null)
    {
      com.tencent.luggage.wxa.lr.c localc = locala.a(str);
      paramJSONObject = localc;
      if (localc == null) {
        paramJSONObject = locala.a(paramc);
      }
      if (com.tencent.luggage.wxa.lr.c.b == paramJSONObject)
      {
        paramc = localObject;
        break label112;
      }
      if (com.tencent.luggage.wxa.lr.c.a == paramJSONObject)
      {
        paramc = locala.b(paramc);
        break label112;
      }
    }
    paramc = "invalidReferrer";
    label112:
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerPolicyStr: %s, referrer: %s", new Object[] { str, paramc });
    return new Pair(str, paramc);
  }
  
  protected o.b a(com.tencent.luggage.wxa.jx.a parama, com.tencent.luggage.wxa.jx.c paramc, int paramInt)
  {
    return new o.b(this, paramc, paramInt);
  }
  
  protected String a(JSONObject paramJSONObject, com.tencent.luggage.wxa.jx.c paramc)
  {
    paramJSONObject = paramJSONObject.optString("src");
    if (paramJSONObject != null)
    {
      if (paramJSONObject.length() <= 0) {
        return "";
      }
      if (!paramJSONObject.startsWith("http://"))
      {
        if (paramJSONObject.startsWith("https://")) {
          return paramJSONObject;
        }
        paramJSONObject = paramc.getFileSystem().g(paramJSONObject);
        if ((paramJSONObject != null) && (paramJSONObject.j()))
        {
          paramc = paramJSONObject.l();
          paramJSONObject = paramc;
          if (!paramc.startsWith("file://"))
          {
            paramJSONObject = new StringBuilder();
            paramJSONObject.append("file://");
            paramJSONObject.append(paramc);
            paramJSONObject = paramJSONObject.toString();
          }
          return paramJSONObject;
        }
        return "";
      }
      return paramJSONObject;
    }
    return "";
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      paramc.a(paramInt, b("fail:data is null"));
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState data is null");
      return;
    }
    String str = paramc.getAppId();
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState appId:%s ,data:%s", new Object[] { str, paramJSONObject.toString() });
    if (this.a == null) {
      this.a = b(this, paramc, paramInt);
    }
    ??? = this.a;
    ((o.a)???).c = paramInt;
    ((o.a)???).g = str;
    o.a.a((o.a)???, true);
    ??? = new StringBuilder();
    ((StringBuilder)???).append("AppBrandService#");
    ((StringBuilder)???).append(paramc.hashCode());
    ??? = com.tencent.luggage.wxa.id.a.c(((StringBuilder)???).toString());
    a((String)???, paramc);
    synchronized (com.tencent.luggage.wxa.id.a.a().a((String)???, true))
    {
      if ((c.c)((a.b)???).b("AppBrandLifeCycle.Listener", null) == null)
      {
        o.1 local1 = new o.1(this, (a.b)???, paramc, paramInt);
        ((a.b)???).a("AppBrandLifeCycle.Listener", local1);
        ((a.b)???).a("appId", str);
        this.a.a = local1;
      }
      this.a.g();
      ??? = a(this, paramc, paramInt);
      ((o.b)???).b = paramInt;
      ((o.b)???).c = str;
      ((o.b)???).e = paramJSONObject.toString();
      ((o.b)???).d = a(paramJSONObject, paramc);
      paramc = a(paramc, paramJSONObject);
      ((o.b)???).h = ((String)paramc.first);
      ((o.b)???).i = ((String)paramc.second);
      ((o.b)???).g();
      return;
    }
  }
  
  protected void a(String paramString, com.tencent.luggage.wxa.jx.c paramc) {}
  
  protected o.a b(com.tencent.luggage.wxa.jx.a parama, com.tencent.luggage.wxa.jx.c paramc, int paramInt)
  {
    return new o.a(this, paramc, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.o
 * JD-Core Version:    0.7.0.1
 */