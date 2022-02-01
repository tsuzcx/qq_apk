package com.tencent.luggage.wxa.pd;

import androidx.annotation.Nullable;
import com.eclipsesource.mmv8.ScriptPartObject;
import com.tencent.luggage.wxa.iu.ab;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.appcache.h.a;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;

public class m
{
  private static String a;
  
  private static String a()
  {
    if (af.c(a)) {
      a = com.tencent.luggage.wxa.jk.a.a(r.a());
    }
    return a;
  }
  
  private static String a(h paramh, m.a parama)
  {
    if (parama == m.a.a) {
      return paramh.s();
    }
    if (parama == m.a.b) {
      return paramh.r();
    }
    return "";
  }
  
  public static void a(d paramd, i parami, String paramString, h.a parama, l.a parama1)
  {
    if ((paramd != null) && (paramd.ae() != null))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(com.tencent.luggage.wxa.nn.a.a(parama.i).replace('/', '_'));
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(parama.d);
      String str1 = ((StringBuilder)localObject1).toString();
      String str2 = parama.f;
      localObject1 = m.a.b;
      Object localObject2 = a(paramd.ae(), (m.a)localObject1);
      localObject1 = localObject2;
      if (((String)localObject2).endsWith("/")) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(k.b(paramString));
      localObject1 = ((StringBuilder)localObject2).toString();
      if (ab.a(paramd, paramString))
      {
        o.d("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: inject sourceMap appId[%s] virtualAccessScriptPath[%s]", new Object[] { paramd.aa(), paramString });
        localObject2 = parama.h;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(parama.i);
        localStringBuilder.append(".map");
        l.a(parami, ab.a((String)localObject2, localStringBuilder.toString(), a(), (String)localObject1), null, null, null, null);
      }
      o.d("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: inject wxa script with appId:%s, virtualPath:%s, fileEntry.name:%s, sourceURL:%s, cacheCategory:%s, cacheKey:%s", new Object[] { paramd.aa(), paramString, parama.i, localObject1, str1, str2 });
      paramd = new ScriptPartObject();
      paramd.type = 2;
      paramd.wxaPkgPath = parama.h;
      paramd.wxaFileName = parama.i;
      paramd.wxaPkgKeyFilePath = a();
      paramString = new ArrayList(2);
      paramString.add(paramd);
      l.a(parami, paramString, (String)localObject1, str1, str2, parama1);
      return;
    }
    o.b("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: virtualAccessScriptPath[%s] runtime or service is null!", new Object[] { paramString });
  }
  
  public static void a(d paramd, i parami, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, m.a parama, @Nullable l.a parama1)
  {
    if ((paramd != null) && (paramd.ae() != null))
    {
      String str = ab.a(paramd, paramString1, a(paramd.ae(), parama));
      if (!af.c(str)) {
        l.a(parami, str, null);
      }
      a(paramd.ae(), parami, paramString1, paramString2, paramString3, paramInt, paramString4, parama, parama1);
      return;
    }
    o.d("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
  }
  
  public static void a(d paramd, i parami, String paramString1, String paramString2, String paramString3, String paramString4, m.a parama, l.a parama1)
  {
    if ((paramd != null) && (paramd.ae() != null))
    {
      Object localObject2 = k.b(paramString2);
      Object localObject1 = localObject2;
      if (((String)localObject2).startsWith("/__APP__")) {
        localObject1 = k.b(((String)localObject2).substring(8));
      }
      parama = a(paramd.ae(), parama);
      if (ab.a(paramd, paramString2))
      {
        o.d("MicroMsg.JsValidationInjectorWC", "inject sourceMap appId[%s] filePath[%s]", new Object[] { paramd.aa(), paramString2 });
        paramd = new StringBuilder();
        paramd.append((String)localObject1);
        paramd.append(".map");
        paramd = paramd.toString();
        localObject2 = a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(parama);
        localStringBuilder.append(paramString2);
        paramd = ab.a(paramString1, paramd, (String)localObject2, localStringBuilder.toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(parama);
        ((StringBuilder)localObject2).append(paramString2);
        l.a(parami, paramd, ((StringBuilder)localObject2).toString(), paramString3, paramString4, parama1);
      }
      paramd = new ScriptPartObject();
      paramd.type = 2;
      paramd.wxaPkgPath = paramString1;
      paramd.wxaFileName = ((String)localObject1);
      paramd.wxaPkgKeyFilePath = a();
      paramString1 = new ArrayList(2);
      paramString1.add(paramd);
      paramd = new StringBuilder();
      paramd.append(parama);
      paramd.append(paramString2);
      l.a(parami, paramString1, paramd.toString(), paramString3, paramString4, parama1);
      return;
    }
    o.d("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
  }
  
  public static void a(h paramh, i parami, String paramString1, String paramString2, m.a parama, l.a parama1)
  {
    if (af.c(paramString2))
    {
      if (parama1 != null) {
        parama1.b("isNullOrNil script");
      }
      return;
    }
    parami = (com.tencent.mm.plugin.appbrand.jsruntime.l)parami.a(com.tencent.mm.plugin.appbrand.jsruntime.l.class);
    if (parami == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(String.format(Locale.ENGLISH, ";(function(){return %d;})();", new Object[] { Integer.valueOf(11111) }));
    paramString2 = localStringBuilder.toString();
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(paramh, parama));
      localStringBuilder.append(paramString1);
      paramh = new URL(localStringBuilder.toString());
      parami.a(paramString2, paramh.toString(), new m.1(parama1));
      return;
    }
    catch (MalformedURLException paramh) {}
  }
  
  public static void a(h paramh, i parami, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, m.a parama, l.a parama1)
  {
    if (paramh == null)
    {
      o.c("MicroMsg.JsValidationInjectorWC", "hy: service is null! abort");
      return;
    }
    parama = a(paramh, parama);
    paramh = paramh.a(paramString1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parama);
    localStringBuilder.append(paramString1);
    l.a(parami, localStringBuilder.toString(), paramString2, paramString3, paramInt, paramString4, paramh, parama1);
  }
  
  public static void a(i parami, String paramString)
  {
    parami = (com.tencent.mm.plugin.appbrand.jsruntime.l)parami.a(com.tencent.mm.plugin.appbrand.jsruntime.l.class);
    if (parami == null) {
      return;
    }
    parami.a(paramString);
  }
  
  public static void b(i parami, String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("break.js");
      paramString = new URL(localStringBuilder.toString());
      parami.a(paramString, "breakprogram();", null);
      return;
    }
    catch (MalformedURLException parami) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.m
 * JD-Core Version:    0.7.0.1
 */