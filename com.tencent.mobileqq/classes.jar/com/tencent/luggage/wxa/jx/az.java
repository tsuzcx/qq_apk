package com.tencent.luggage.wxa.jx;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.n;
import java.util.Locale;
import org.json.JSONObject;

public class az
{
  public static String a()
  {
    try
    {
      String str = new JSONObject().put("nativeTime", System.currentTimeMillis()).toString();
      return str;
    }
    catch (Exception localException)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsScriptEvaluator", "makeExtStatJson e = %s", new Object[] { localException });
    }
    return "{}";
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString2;
    if (af.c(paramString2)) {
      str = "{}";
    }
    try
    {
      Locale localLocale = Locale.ENGLISH;
      if (paramInt == 0)
      {
        paramString2 = "undefined";
      }
      else
      {
        paramString2 = new StringBuilder();
        paramString2.append(paramInt);
        paramString2.append("");
        paramString2 = paramString2.toString();
      }
      paramString2 = String.format(localLocale, "WeixinJSCoreAndroid.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramString1, str, paramString2, a() });
      return paramString2;
    }
    catch (OutOfMemoryError paramString2)
    {
      paramString1 = String.format(Locale.ENGLISH, "oom:%s, event:%s, data.size:%d", new Object[] { paramString2.getMessage(), paramString1, Integer.valueOf(af.b(str).length()) });
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsScriptEvaluator", "message:%s", new Object[] { paramString1 });
      throw new OutOfMemoryError(paramString1);
    }
  }
  
  public static void a(@NonNull com.tencent.mm.plugin.appbrand.jsruntime.o paramo, String paramString1, String paramString2, int paramInt)
  {
    if ((paramo instanceof i))
    {
      n localn = (n)((i)paramo).a(n.class);
      if (localn != null)
      {
        localn.a(paramString1, paramString2, paramInt, a());
        return;
      }
    }
    paramo.evaluateJavascript(a(paramString1, paramString2, paramInt), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.az
 * JD-Core Version:    0.7.0.1
 */