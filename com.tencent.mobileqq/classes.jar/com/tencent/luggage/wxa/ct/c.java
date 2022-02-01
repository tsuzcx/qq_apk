package com.tencent.luggage.wxa.ct;

import android.webkit.JavascriptInterface;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.xweb.WebView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/HTMLWebViewJsBridgeDelegate;", "", "env", "Lcom/tencent/luggage/jsapi/webview/HTMLWebViewComponentImpl;", "(Lcom/tencent/luggage/jsapi/webview/HTMLWebViewComponentImpl;)V", "webView", "Lcom/tencent/xweb/WebView;", "kotlin.jvm.PlatformType", "getWebView", "()Lcom/tencent/xweb/WebView;", "callback", "", "callbackId", "", "data", "", "cleanup", "dispatch", "event", "invokeHandler", "apiName", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class c
{
  @Deprecated
  public static final c.a a = new c.a(null);
  private final b b;
  
  public c(@NotNull b paramb)
  {
    this.b = paramb;
    b().addJavascriptInterface(this, "WeixinJSCore");
  }
  
  private final WebView b()
  {
    return this.b.l().getWebView();
  }
  
  public final void a()
  {
    try
    {
      b().removeJavascriptInterface("WeixinJSCore");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public final void a(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(af.a(paramString, "{}"));
    localStringBuilder.append(')');
    paramString = localStringBuilder.toString();
    b().evaluateJavascript(paramString, null);
  }
  
  public final void a(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (paramString1 != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler('");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("', ");
      localStringBuilder.append(af.a(paramString2, "{}"));
      localStringBuilder.append(')');
      paramString1 = localStringBuilder.toString();
      paramString2 = new StringBuilder();
      paramString2.append("dispatch with script:");
      paramString2.append(paramString1);
      o.e("Luggage.STANDALONE.HTMLWebViewJsBridgeDelegate", paramString2.toString());
      b().evaluateJavascript(paramString1, null);
    }
  }
  
  @JavascriptInterface
  @Nullable
  public final String invokeHandler(@Nullable String paramString1, @Nullable String paramString2, int paramInt)
  {
    if (paramString1 != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invokeHandler api:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", data.size:");
      ((StringBuilder)localObject).append(af.b(paramString2).length());
      ((StringBuilder)localObject).append(", callbackId:");
      ((StringBuilder)localObject).append(paramInt);
      o.e("Luggage.STANDALONE.HTMLWebViewJsBridgeDelegate", ((StringBuilder)localObject).toString());
      paramString2 = this.b.a(paramString1, paramString2, paramInt);
      localObject = (CharSequence)paramString2;
      int i;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("invokeHandler with api:");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" callbackId:");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", return ");
        ((StringBuilder)localObject).append(paramString2);
        o.e("Luggage.STANDALONE.HTMLWebViewJsBridgeDelegate", ((StringBuilder)localObject).toString());
      }
      return paramString2;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.c
 * JD-Core Version:    0.7.0.1
 */