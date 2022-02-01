package com.tencent.luggage.wxa.ct;

import android.app.Activity;
import android.net.Uri;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.util.LuggageActivityHelper.ILuggageActivityHelper;
import com.tencent.luggage.wxa.ef.f;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.u.a;
import java.util.HashMap;
import java.util.Map;

class a$8
  extends h
{
  a$8(a parama) {}
  
  public void a()
  {
    this.a.a(new a.8.2(this));
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    o.d("Luggage.STANDALONE.AppBrandHTMLWebView", "onReceivedTitle: title[%s]", new Object[] { paramString });
    a.d(this.a, paramString);
  }
  
  public void a(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    if (a.a(this.a))
    {
      paramCallback.invoke(paramString, false, false);
      return;
    }
    this.a.a(new a.8.1(this, paramCallback, paramString));
  }
  
  public boolean a(ConsoleMessage paramConsoleMessage)
  {
    f.a(paramConsoleMessage, "Luggage.STANDALONE.AppBrandHTMLWebView");
    return super.a(paramConsoleMessage);
  }
  
  public boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, u.a parama)
  {
    int i = hashCode() + a.h(this.a) >> 16;
    if (a.i(this.a) == null) {
      a.a(this.a, new HashMap(1));
    }
    a.i(this.a).put(Integer.valueOf(i), paramValueCallback);
    paramWebView = (Activity)this.a.getContext();
    junit.framework.a.a(paramWebView instanceof LuggageActivityHelper.ILuggageActivityHelper);
    LuggageActivityHelper.FOR(paramWebView).interceptActivityResultOnce(new a.8.5(this));
    paramWebView.startActivityForResult(parama.a(), i);
    return true;
  }
  
  public boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    if (a.a(this.a))
    {
      paramJsResult.cancel();
      return true;
    }
    this.a.a(new a.8.3(this, paramJsResult, paramString2, paramString1));
    return true;
  }
  
  public boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    if (a.a(this.a))
    {
      paramJsResult.cancel();
      return true;
    }
    this.a.a(new a.8.4(this, paramJsResult, paramString2, paramString1));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.a.8
 * JD-Core Version:    0.7.0.1
 */