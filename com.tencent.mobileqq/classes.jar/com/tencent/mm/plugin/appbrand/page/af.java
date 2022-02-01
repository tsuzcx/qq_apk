package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.webkit.ValueCallback;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.oq.d;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.j;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "webview", "(Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;)V", "wrappedWebView", "getWrappedWebView", "()Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "addJavascriptInterface", "", "p0", "", "kotlin.jvm.PlatformType", "p1", "", "canOverScroll", "", "destroy", "drawScreenshotOnCanvas", "canvas", "Landroid/graphics/Canvas;", "evaluateJavascript", "Ljava/net/URL;", "p2", "Landroid/webkit/ValueCallback;", "p3", "", "p4", "p5", "getAddon", "T", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "getContentHeight", "getContentView", "Landroid/view/View;", "getFullscreenImpl", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "getHeight", "getUrl", "getUserAgentString", "getWebScrollX", "getWebScrollY", "getWidth", "getWrapperView", "isInspectorEnabled", "loadData", "url", "data", "onBackground", "onForeground", "postOnReRendered", "runnable", "Ljava/lang/Runnable;", "resetContext", "context", "Landroid/content/Context;", "scrollToTop", "setAppBrandInfo", "map", "", "", "setBackgroundColor", "backgroundColor", "setFullscreenImpl", "impl", "setHorizontalScrollBarEnabled", "horizontalScrollBarEnabled", "setJsExceptionHandler", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsExceptionHandler;", "setOnScrollChangedListener", "l", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewScrollListener;", "setOnTrimListener", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewOnTrimListener;", "setVerticalScrollBarEnabled", "verticalScrollBarEnabled", "setWebViewLayoutListener", "listener", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewLayoutListener;", "setXWebKeyboardImpl", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandXWebKeyboard;", "smoothScrollTo", "top", "duration", "", "trimmed", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public class af
  implements am
{
  private final am a;
  
  public af(@NotNull am paramam)
  {
    this.a = paramam;
  }
  
  public <T extends j> T a(Class<T> paramClass)
  {
    return this.a.a(paramClass);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.a.a(paramInt, paramLong);
  }
  
  public void a(Context paramContext)
  {
    this.a.a(paramContext);
  }
  
  public void a(@androidx.annotation.Nullable @org.jetbrains.annotations.Nullable Runnable paramRunnable)
  {
    this.a.a(paramRunnable);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.a(paramString1, paramString2);
  }
  
  public void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    this.a.a(paramURL, paramString, paramValueCallback);
  }
  
  public void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback)
  {
    this.a.a(paramURL, paramString1, paramString2, paramInt, paramString3, paramValueCallback);
  }
  
  public boolean a(@NonNull @NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    return this.a.a(paramCanvas);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    this.a.addJavascriptInterface(paramObject, paramString);
  }
  
  @NotNull
  public final am b()
  {
    return this.a;
  }
  
  public boolean c()
  {
    return this.a.c();
  }
  
  public boolean d()
  {
    return this.a.d();
  }
  
  public void destroy()
  {
    this.a.destroy();
  }
  
  public void e()
  {
    this.a.e();
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    this.a.evaluateJavascript(paramString, paramValueCallback);
  }
  
  public void f()
  {
    this.a.f();
  }
  
  public void g()
  {
    this.a.g();
  }
  
  public int getContentHeight()
  {
    return this.a.getContentHeight();
  }
  
  public View getContentView()
  {
    return this.a.getContentView();
  }
  
  public d getFullscreenImpl()
  {
    return this.a.getFullscreenImpl();
  }
  
  public int getHeight()
  {
    return this.a.getHeight();
  }
  
  public String getUserAgentString()
  {
    return this.a.getUserAgentString();
  }
  
  public int getWebScrollX()
  {
    return this.a.getWebScrollX();
  }
  
  public int getWebScrollY()
  {
    return this.a.getWebScrollY();
  }
  
  public int getWidth()
  {
    return this.a.getWidth();
  }
  
  public View getWrapperView()
  {
    return this.a.getWrapperView();
  }
  
  public void setAppBrandInfo(Map<String, String> paramMap)
  {
    this.a.setAppBrandInfo(paramMap);
  }
  
  public void setBackgroundColor(@ColorInt int paramInt)
  {
    this.a.setBackgroundColor(paramInt);
  }
  
  public void setFullscreenImpl(d paramd)
  {
    this.a.setFullscreenImpl(paramd);
  }
  
  public void setJsExceptionHandler(h paramh)
  {
    this.a.setJsExceptionHandler(paramh);
  }
  
  public void setOnScrollChangedListener(ae paramae)
  {
    this.a.setOnScrollChangedListener(paramae);
  }
  
  public void setOnTrimListener(ad paramad)
  {
    this.a.setOnTrimListener(paramad);
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    this.a.setVerticalScrollBarEnabled(paramBoolean);
  }
  
  public void setWebViewLayoutListener(ac paramac)
  {
    this.a.setWebViewLayoutListener(paramac);
  }
  
  public void setXWebKeyboardImpl(ag paramag)
  {
    this.a.setXWebKeyboardImpl(paramag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.af
 * JD-Core Version:    0.7.0.1
 */