package com.tencent.luggage.wxa.qc;

import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.appbrand.v8.g;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.xweb.ad;

public class a
{
  private static boolean a;
  private static Boolean b;
  private static Boolean c;
  
  public static void a()
  {
    if (a)
    {
      o.d("MicroMsg.XWebNativeTransInitLogic", "bind already");
      return;
    }
    o.d("MicroMsg.XWebNativeTransInitLogic", "bind");
    ad.a(g.a());
    a = true;
  }
  
  public static void a(@NonNull i parami, int paramInt1, int paramInt2, String paramString)
  {
    o.d("MicroMsg.XWebNativeTransInitLogic", "initNativeTransServiceId serviceId:%d, componentId:%d, appId:%s, stack:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Log.getStackTraceString(new Throwable()) });
    paramString = new StringBuilder();
    paramString.append("console.log('initNativeTransServiceId. ntrans:' + typeof ntrans + ' componentId :");
    paramString.append(paramInt2);
    paramString.append("')");
    parami.evaluateJavascript(paramString.toString(), null);
    paramString = new StringBuilder();
    paramString.append("if (typeof ntrans !== 'undefined') { ntrans.serviceId = ");
    paramString.append(paramInt1);
    paramString.append("; }");
    parami.evaluateJavascript(paramString.toString(), null);
  }
  
  public static void a(@NonNull i parami, int paramInt, String paramString)
  {
    o.d("MicroMsg.XWebNativeTransInitLogic", "initNativeTransComponentId componentId: %d appId:%s , stack: %s", new Object[] { Integer.valueOf(paramInt), paramString, Log.getStackTraceString(new Throwable()) });
    paramString = new StringBuilder();
    paramString.append("console.log('initNativeTransComponentId. ntrans:' + typeof ntrans + ' componentId :");
    paramString.append(paramInt);
    paramString.append("')");
    parami.evaluateJavascript(paramString.toString(), null);
    paramString = new StringBuilder();
    paramString.append("if (typeof ntrans !== 'undefined') { ntrans.id = ");
    paramString.append(paramInt);
    paramString.append("; }");
    parami.evaluateJavascript(paramString.toString(), null);
  }
  
  public static boolean a(b paramb)
  {
    if (c == null) {
      c = Boolean.valueOf(Boolean.parseBoolean(paramb.A().b("nativeTrans")));
    }
    return c.booleanValue();
  }
  
  public static Boolean b()
  {
    if (b == null) {
      b = Boolean.valueOf(ad.a(2009));
    }
    return Boolean.valueOf(b.booleanValue());
  }
  
  public static void b(@NonNull i parami, int paramInt, String paramString)
  {
    o.d("MicroMsg.XWebNativeTransInitLogic", "enableXwebNativeTrans componentId:%s ,appId:%s , stack:%s", new Object[] { Integer.valueOf(paramInt), paramString, Log.getStackTraceString(new Throwable()) });
    paramString = new StringBuilder();
    paramString.append("console.log('enableXwebNativeTrans. ntrans:' + typeof ntrans + ' componentId :");
    paramString.append(paramInt);
    paramString.append("')");
    parami.evaluateJavascript(paramString.toString(), null);
    parami.evaluateJavascript("xweb.enableNativeTrans()", null);
    paramString = new StringBuilder();
    paramString.append("console.log('enableXwebNativeTrans. end ntrans:' + typeof ntrans  + ' componentId :");
    paramString.append(paramInt);
    paramString.append("')");
    parami.evaluateJavascript(paramString.toString(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qc.a
 * JD-Core Version:    0.7.0.1
 */