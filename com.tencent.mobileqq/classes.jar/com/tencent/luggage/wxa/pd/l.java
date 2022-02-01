package com.tencent.luggage.wxa.pd;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.eclipsesource.mmv8.ScriptPartObject;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.u;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import junit.framework.a;

public class l
{
  private static final LinkedList<String> a = new LinkedList();
  
  public static String a()
  {
    return String.format(Locale.ENGLISH, "\n;(function(){return %d;})();", new Object[] { Integer.valueOf(11111) });
  }
  
  public static void a(i parami, String paramString, l.a parama)
  {
    a(parami, null, paramString, parama);
  }
  
  @SuppressLint({"DefaultLocale"})
  public static void a(i parami, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, l.a parama)
  {
    o.d("MicroMsg.JsValidationInjector", "hy: injecting file %s", new Object[] { paramString1 });
    long l = System.currentTimeMillis();
    if (af.c(paramString4))
    {
      o.b("MicroMsg.JsValidationInjector", "hy: empty script!");
      if (parama != null) {
        parama.b("isNullOrNil script");
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString4);
    ((StringBuilder)localObject).append(String.format("\n;(function(){return %d;})();", new Object[] { Integer.valueOf(11111) }));
    paramString4 = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString4);
    ((StringBuilder)localObject).append(af.b(paramString5));
    localObject = ((StringBuilder)localObject).toString();
    paramString5 = null;
    paramString4 = paramString5;
    if (paramString1 != null) {
      paramString4 = paramString5;
    }
    try
    {
      if (paramString1.length() <= 0) {
        break label185;
      }
      paramString4 = new URL(paramString1);
    }
    catch (MalformedURLException parami)
    {
      label168:
      break label168;
    }
    o.b("MicroMsg.JsValidationInjector", "hy: MalformedURLException");
    parama.b("MalformedURLException");
    return;
    label185:
    paramString5 = (u)parami.a(u.class);
    if (paramString5 != null)
    {
      paramString5.a(paramString4, paramString2, paramString3, paramInt, (String)localObject, new l.2(paramString1, parama, l));
      return;
    }
    if ((!af.c(paramString2)) && (!af.c(paramString3)))
    {
      parami.a(paramString4, paramString2, paramString3, paramInt, (String)localObject, new l.4(paramString1, parama, l));
      return;
    }
    parami.a(paramString4, (String)localObject, new l.3(paramString1, parama, l));
  }
  
  public static void a(@NonNull i parami, @Nullable URL paramURL, @NonNull String paramString, @Nullable l.a parama)
  {
    if (af.c(paramString))
    {
      if (parama != null) {
        parama.b("isNullOrNil script");
      }
      return;
    }
    int j = 1;
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!paramString.startsWith((String)localIterator.next()));
      int i = 0;
      ??? = paramString;
      if (i != 0)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append(paramString);
        ((StringBuilder)???).append(a());
        ??? = ((StringBuilder)???).toString();
      }
      paramString = new l.1(parama);
      if (paramURL == null)
      {
        parami.evaluateJavascript((String)???, paramString);
        return;
      }
      parami.a(paramURL, (String)???, paramString);
      return;
    }
    for (;;)
    {
      throw parami;
    }
  }
  
  public static void a(i parami, ArrayList<ScriptPartObject> paramArrayList, String paramString1, String paramString2, String paramString3, l.a parama)
  {
    Object localObject4;
    Object localObject1;
    long l;
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      Iterator localIterator = paramArrayList.iterator();
      localObject4 = null;
      localObject2 = null;
      localObject1 = localObject2;
      Object localObject3 = localObject1;
      while (localIterator.hasNext())
      {
        ScriptPartObject localScriptPartObject = (ScriptPartObject)localIterator.next();
        if (localScriptPartObject.type == 2)
        {
          localObject2 = localScriptPartObject.wxaPkgPath;
          localObject1 = localScriptPartObject.wxaFileName;
          localObject3 = localScriptPartObject.wxaPkgKeyFilePath;
          o.d("MicroMsg.JsValidationInjector", " contain wxa pkg: %s, file: %s", new Object[] { localObject2, localObject1 });
        }
      }
      l = System.currentTimeMillis();
      if ((!af.c((String)localObject2)) && (!af.c((String)localObject1)) && (!af.c((String)localObject3)) && (paramString1 == null)) {}
    }
    try
    {
      if (paramString1.length() <= 0) {
        break label182;
      }
      paramString1 = new URL(paramString1);
    }
    catch (MalformedURLException parami)
    {
      label165:
      break label165;
    }
    o.b("MicroMsg.JsValidationInjector", "MalformedURLException");
    parama.b("MalformedURLException");
    return;
    label182:
    paramString1 = null;
    Object localObject2 = new ScriptPartObject();
    ((ScriptPartObject)localObject2).type = 1;
    ((ScriptPartObject)localObject2).content = String.format(Locale.US, "\n;(function(){return %d;})();", new Object[] { Integer.valueOf(11111) });
    paramArrayList.add(localObject2);
    localObject2 = (u)parami.a(u.class);
    if (localObject2 == null)
    {
      a.a("Only addonV8 supports wxa script");
      return;
    }
    if (parama == null) {
      parami = localObject4;
    } else {
      parami = new l.5((String)localObject1, parama, l);
    }
    ((u)localObject2).a(paramArrayList, paramString1, paramString2, paramString3, parami);
    return;
    o.b("MicroMsg.JsValidationInjector", "empty wxa path or file path or key path!");
    if (parama != null) {
      parama.b("isNullOrNil empty path");
    }
    return;
    o.b("MicroMsg.JsValidationInjector", "empty script list, abort");
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (a)
    {
      a.add(paramString);
      return;
    }
  }
  
  private static void b(String paramString1, l.a parama, String paramString2, long paramLong)
  {
    if ((paramString2 != null) && (paramString2.contains("11111")))
    {
      if (parama != null)
      {
        o.d("MicroMsg.JsValidationInjector", "hy: file %s inject success! cost:%d", new Object[] { paramString1, Long.valueOf(System.currentTimeMillis() - paramLong) });
        parama.a(paramString2);
      }
    }
    else if (parama != null)
    {
      o.b("MicroMsg.JsValidationInjector", "hy: file %s inject failed!", new Object[] { paramString1 });
      parama.b(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.l
 * JD-Core Version:    0.7.0.1
 */