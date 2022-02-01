package com.tencent.luggage.wxa.ct;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.oi.e;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.j;
import com.tencent.xweb.WebView;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/HTMLWebViewJsRuntimeImpl;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPauseRenderingExtension;", "webview", "Lcom/tencent/xweb/WebView;", "(Lcom/tencent/xweb/WebView;)V", "mShown", "", "Ljava/lang/Boolean;", "addJavascriptInterface", "", "obj", "", "name", "", "destroy", "evaluateJavascript", "sourceURL", "Ljava/net/URL;", "script", "cb", "Landroid/webkit/ValueCallback;", "cacheCategory", "cacheKey", "cacheType", "", "getAddon", "T", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "addon", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "pauseRendering", "restoreRendering", "setJsExceptionHandler", "handler", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsExceptionHandler;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class d
  implements e, i
{
  private Boolean a;
  private final WebView b;
  
  public d(@NotNull WebView paramWebView)
  {
    this.b = paramWebView;
  }
  
  @Nullable
  public <T extends j> T a(@Nullable Class<T> paramClass)
  {
    boolean bool = Intrinsics.areEqual(e.class, paramClass);
    Object localObject = null;
    paramClass = localObject;
    if (bool)
    {
      paramClass = localObject;
      if (this.b.supportFeature(1040)) {
        paramClass = (j)this;
      }
    }
    return paramClass;
  }
  
  public void a()
  {
    Boolean localBoolean1 = this.a;
    Boolean localBoolean2 = Boolean.valueOf(true);
    if ((Intrinsics.areEqual(localBoolean1, localBoolean2) ^ true))
    {
      this.b.onShow();
      this.a = localBoolean2;
    }
  }
  
  public void a(@Nullable URL paramURL, @Nullable String paramString, @Nullable ValueCallback<String> paramValueCallback)
  {
    evaluateJavascript(paramString, paramValueCallback);
  }
  
  public void a(@Nullable URL paramURL, @Nullable String paramString1, @Nullable String paramString2, int paramInt, @Nullable String paramString3, @Nullable ValueCallback<String> paramValueCallback)
  {
    evaluateJavascript(paramString3, paramValueCallback);
  }
  
  public void addJavascriptInterface(@Nullable Object paramObject, @Nullable String paramString)
  {
    if (paramObject != null)
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      int i;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        return;
      }
      this.b.addJavascriptInterface(paramObject, paramString);
    }
  }
  
  public void b()
  {
    Boolean localBoolean1 = this.a;
    Boolean localBoolean2 = Boolean.valueOf(false);
    if ((Intrinsics.areEqual(localBoolean1, localBoolean2) ^ true))
    {
      this.b.onHide();
      this.a = localBoolean2;
    }
  }
  
  public void destroy()
  {
    this.b.destroy();
  }
  
  public void evaluateJavascript(@Nullable String paramString, @Nullable ValueCallback<String> paramValueCallback)
  {
    this.b.evaluateJavascript(paramString, paramValueCallback);
  }
  
  public void setJsExceptionHandler(@Nullable h paramh) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.d
 * JD-Core Version:    0.7.0.1
 */