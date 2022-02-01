package com.tencent.luggage.wxa.of;

import androidx.annotation.NonNull;
import com.tencent.luggage.util.g;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.nz.a;
import com.tencent.luggage.wxa.pd.p.a;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static b.a a;
  
  public static JSONObject a(@NonNull d paramd)
  {
    JSONObject localJSONObject = new JSONObject();
    b(paramd, localJSONObject);
    c(paramd, localJSONObject);
    d(paramd, localJSONObject);
    a(paramd, localJSONObject);
    b.a locala = a;
    if (locala != null) {
      locala.a(paramd, localJSONObject);
    }
    com.tencent.luggage.wxa.qz.o.f("MicroMsg.PrepareDataForNodeHelper", "prepareDataForNode :%s", new Object[] { localJSONObject.toString() });
    return localJSONObject;
  }
  
  public static void a(@NonNull d paramd, @NonNull JSONObject paramJSONObject)
  {
    if ((paramd.z() instanceof t))
    {
      JSONObject localJSONObject = new JSONObject();
      paramd = ((t)paramd.z()).d();
      int i = 0;
      Object localObject4;
      Object localObject3;
      while (i < paramd.size())
      {
        Object localObject1 = (com.tencent.mm.plugin.appbrand.appstorage.o)paramd.get(i);
        if ((localObject1 instanceof x))
        {
          localObject4 = (x)localObject1;
          localObject1 = ((x)localObject4).d();
          localObject3 = ((x)localObject4).e();
          long l = ((x)localObject4).f();
          com.tencent.luggage.wxa.qz.o.d("MicroMsg.PrepareDataForNodeHelper", "prepareFSData rootPath:%s pathPrefix:%s quota:%d", new Object[] { localObject1, localObject3, Long.valueOf(l) });
          try
          {
            localObject4 = new JSONObject();
            ((JSONObject)localObject4).put("type", 1);
            ((JSONObject)localObject4).put("rootPath", localObject1);
            ((JSONObject)localObject4).put("quota", l);
            localJSONObject.put((String)localObject3, localObject4);
          }
          catch (JSONException localJSONException1)
          {
            com.tencent.luggage.wxa.qz.o.b("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", new Object[] { localJSONException1 });
          }
        }
        i += 1;
      }
      paramd = paramd.iterator();
      while (paramd.hasNext())
      {
        Object localObject2 = (com.tencent.mm.plugin.appbrand.appstorage.o)paramd.next();
        if ((localObject2 instanceof com.tencent.mm.plugin.appbrand.appstorage.l))
        {
          localObject3 = (com.tencent.mm.plugin.appbrand.appstorage.l)localObject2;
          localObject2 = ((com.tencent.mm.plugin.appbrand.appstorage.l)localObject3).d();
          localObject3 = ((com.tencent.mm.plugin.appbrand.appstorage.l)localObject3).f();
          try
          {
            localObject4 = new JSONObject();
            ((JSONObject)localObject4).put("type", 0);
            ((JSONObject)localObject4).put("rootPath", localObject2);
            localJSONObject.put((String)localObject3, localObject4);
          }
          catch (JSONException localJSONException2)
          {
            com.tencent.luggage.wxa.qz.o.b("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", new Object[] { localJSONException2 });
          }
        }
      }
      try
      {
        paramJSONObject.put("fsData", localJSONObject);
        return;
      }
      catch (JSONException paramd)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", new Object[] { paramd });
        return;
      }
    }
    paramd = new IllegalStateException("getFileSystem not LuggageFileSystemRegistry");
    for (;;)
    {
      throw paramd;
    }
  }
  
  public static void a(b.a parama)
  {
    a = parama;
  }
  
  private static void b(@NonNull d paramd, @NonNull JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("appId", paramd.aa());
      int i;
      if (paramd.A() == null) {
        i = 0;
      } else {
        i = paramd.A().S.pkgVersion;
      }
      paramJSONObject.put("appversion", i);
      if (paramd.A() == null) {
        i = 0;
      } else {
        i = paramd.A().c() + 1;
      }
      paramJSONObject.put("appstate", i);
      return;
    }
    catch (JSONException paramd)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.PrepareDataForNodeHelper", "prepareCommonData e:%s", new Object[] { paramd });
    }
  }
  
  private static void c(@NonNull d paramd, @NonNull JSONObject paramJSONObject)
  {
    paramd = (a)paramd.b(a.class);
    if (paramd == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("maxWebsocketConcurrent", paramd.h);
      localJSONObject.put("socketDomains", g.a(paramd.l));
      localJSONObject.put("websocketSkipPortCheck", paramd.t);
      localJSONObject.put("websocketTimeoutMS", paramd.d);
      localJSONObject.put("headerFilterMode", paramd.x);
      localJSONObject.put("blacklistHeaders", g.a(paramd.p));
      localJSONObject.put("whitelistHeaders", g.a(paramd.q));
      localJSONObject.put("referer", paramd.w);
      localJSONObject.put("canSkipCheckDomainsByArg", paramd.a);
      localJSONObject.put("shouldCheckDomains", paramd.b);
      localJSONObject.put("userAgentString", paramd.u);
      paramJSONObject.put("networkConfig", localJSONObject);
      return;
    }
    catch (JSONException paramd)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.PrepareDataForNodeHelper", "prepareNetworkConfigData e:%s", new Object[] { paramd });
    }
  }
  
  private static void d(@NonNull d paramd, @NonNull JSONObject paramJSONObject)
  {
    paramd = (p.a)paramd.b(p.a.class);
    if (paramd == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("nativeBufferSizeLimitByte", paramd.e);
      localJSONObject.put("itemBase64", paramd.d);
      localJSONObject.put("itemID", paramd.c);
      localJSONObject.put("itemKey", paramd.b);
      localJSONObject.put("outKey", paramd.a);
      paramJSONObject.put("nativeBufferConfig", localJSONObject);
      return;
    }
    catch (JSONException paramd)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.PrepareDataForNodeHelper", "prepareNativeBufferConfigData e:%s", new Object[] { paramd });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.of.b
 * JD-Core Version:    0.7.0.1
 */