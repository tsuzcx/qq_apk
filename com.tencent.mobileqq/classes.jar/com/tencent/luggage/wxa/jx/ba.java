package com.tencent.luggage.wxa.jx;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.i;

public class ba
{
  public static void a(@NonNull i parami, String paramString1, String paramString2, int paramInt)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "{}";
    }
    o.e("MicroMsg.JsScriptEvaluatorWC", "hy: dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(str.length()), Integer.valueOf(paramInt) });
    parami.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler('%s', %s)", new Object[] { paramString1, str }), new ba.1());
  }
  
  public static void b(@NonNull i parami, String paramString1, String paramString2, int paramInt)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "{}";
    }
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
    parami.evaluateJavascript(String.format("typeof %s !== 'undefined' && %s.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { "WeixinJSBridge", "WeixinJSBridge", paramString1, str, paramString2, az.a() }), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ba
 * JD-Core Version:    0.7.0.1
 */