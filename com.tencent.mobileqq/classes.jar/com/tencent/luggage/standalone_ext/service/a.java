package com.tencent.luggage.standalone_ext.service;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.luggage.util.m;
import com.tencent.luggage.wxa.dq.b.a;
import com.tencent.luggage.wxa.dr.d.b;
import com.tencent.luggage.wxa.du.b.b;
import com.tencent.luggage.wxa.la.b;
import com.tencent.luggage.wxa.ny.f;
import com.tencent.luggage.wxa.ov.e.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.xweb.WebView;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public class a
  extends com.tencent.luggage.wxa.du.c
  implements f
{
  public a()
  {
    this(new b.b());
  }
  
  public a(@NonNull b.a parama)
  {
    super(parama);
    a(r.b());
    a(d.b.class, new com.tencent.luggage.wxa.et.a());
  }
  
  public a(@NonNull Class<? extends com.tencent.luggage.wxa.du.e> paramClass)
  {
    super(paramClass);
    a(r.b());
    a(d.b.class, new com.tencent.luggage.wxa.et.a());
  }
  
  protected final void a(String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    super.a(paramString, paramLong1, paramLong2, paramObject);
    com.tencent.mm.plugin.appbrand.keylogger.d.a(x().aa(), com.tencent.luggage.wxa.oy.a.G, "wxConfig", paramLong1, paramLong2);
  }
  
  public void a(@NonNull JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    a(paramJSONObject, "clientVersion", Integer.valueOf(654316592));
    boolean bool = true;
    com.tencent.luggage.wxa.ju.a.a(true, paramJSONObject);
    com.tencent.luggage.wxa.ju.a.h(com.tencent.luggage.wxa.sq.c.a(getContext()), paramJSONObject);
    com.tencent.luggage.wxa.ju.a.g(com.tencent.luggage.wxa.sq.c.a(getContext()), paramJSONObject);
    com.tencent.luggage.wxa.ju.a.b(true, paramJSONObject);
    com.tencent.luggage.wxa.ju.a.e(true, paramJSONObject);
    com.tencent.luggage.wxa.ju.a.f(true, paramJSONObject);
    com.tencent.luggage.wxa.ju.a.c(false, paramJSONObject);
    if ((!XWalkEnvironment.isCurrentVersionSupportCustomTextAreaForAppbrand()) || (!WebView.isXWalk())) {
      bool = false;
    }
    com.tencent.luggage.wxa.ju.a.d(bool, paramJSONObject);
  }
  
  @NonNull
  public JSONObject j()
  {
    JSONObject localJSONObject2 = super.j();
    a(localJSONObject2, "debug", Boolean.valueOf(x().i().b));
    JSONObject localJSONObject3 = new JSONObject();
    a(localJSONObject2, "appLaunchInfo", localJSONObject3);
    Object localObject = x().as();
    a(localJSONObject3, "path", m.b((String)localObject));
    a(localJSONObject3, "query", new JSONObject(m.c((String)localObject)));
    a(localJSONObject3, "referrerInfo", x().G().l());
    if (!TextUtils.isEmpty(x().G().e)) {
      a(localJSONObject3, "shortLink", x().G().e);
    }
    e.a.a.b(x(), localJSONObject3);
    e.a.a.c(x(), localJSONObject3);
    e.a.a.a(x(), localJSONObject2);
    com.tencent.luggage.wxa.do.d locald = x().i();
    JSONObject localJSONObject4 = new JSONObject();
    a(localJSONObject4, "maxRequestConcurrent", Integer.valueOf(locald.k));
    a(localJSONObject4, "maxUploadConcurrent", Integer.valueOf(locald.l));
    a(localJSONObject4, "maxDownloadConcurrent", Integer.valueOf(locald.m));
    a(localJSONObject4, "maxWebsocketConnect", Integer.valueOf(locald.n));
    a(localJSONObject4, "maxWorkerConcurrent", Integer.valueOf(locald.o));
    try
    {
      localJSONObject1 = localJSONObject2.optJSONObject("env");
      localObject = localJSONObject1;
      if (localJSONObject1 == null)
      {
        localObject = new JSONObject();
        localJSONObject2.put("env", localObject);
      }
      ((JSONObject)localObject).put("USER_DATA_PATH", "wxfile://usr");
      ((JSONObject)localObject).put("OPEN_DATA_PATH", "wxfile://opendata");
      ((JSONObject)localObject).put("CLIENT_DATA_PATH", "wxfile://clientdata");
      ((JSONObject)localObject).put("HAS_SPLASHSCREEN", 0);
    }
    catch (Exception localException1)
    {
      JSONObject localJSONObject1;
      label339:
      break label339;
    }
    a(localJSONObject2, "appLaunchInfo", localJSONObject3);
    a(localJSONObject2, "wxAppInfo", localJSONObject4);
    a(localJSONObject2, "isPluginMiniProgram", Boolean.valueOf(false));
    a(localJSONObject2, "envVersion", b.a(x().G().G).name().toLowerCase());
    localObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject1 = new JSONObject(x().G().b());
        localObject = localJSONObject1;
      }
      catch (Exception localException3)
      {
        continue;
      }
      try
      {
        if (!af.c(locald.i))
        {
          localJSONObject1 = new JSONObject();
          localJSONObject1.put("jsonInfo", new JSONObject(locald.i));
          a((JSONObject)localObject, "operationInfo", localJSONObject1);
        }
      }
      catch (Exception localException2)
      {
        o.b("Luggage.AppService", "postProcessConfig, put operationInfo to appContactInfo fail", new Object[] { localException2 });
      }
    }
    a(localJSONObject2, "appContactInfo", localObject);
    a(localJSONObject2, "accountInfo", x().G().k());
    a(localJSONObject2, "supportAsyncAudio", Boolean.valueOf(true));
    return localJSONObject2;
  }
  
  public com.tencent.luggage.wxa.em.d x()
  {
    return (com.tencent.luggage.wxa.em.d)super.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.standalone_ext.service.a
 * JD-Core Version:    0.7.0.1
 */