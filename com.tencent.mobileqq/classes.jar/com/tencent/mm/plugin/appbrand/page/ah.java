package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.oq.d;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.j;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView;
import java.net.URL;
import java.util.Map;

public class ah
  extends DtWebView
  implements an
{
  private String a;
  private aa b;
  private ae c;
  private ac d;
  private d e;
  private Animator f;
  private WebViewClient g = new ah.3(this);
  private WebChromeClient h = new ah.4(this);
  
  public ah(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ah(Context paramContext, aa paramaa)
  {
    super(paramContext);
    this.b = paramaa;
    a();
  }
  
  private void a()
  {
    getSettings().setDomStorageEnabled(true);
    getSettings().setJavaScriptEnabled(true);
    getSettings().setMediaPlaybackRequiresUserGesture(false);
    if (Build.VERSION.SDK_INT >= 21) {
      getSettings().setMixedContentMode(0);
    }
    WebSettings localWebSettings = getSettings();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getSettings().getUserAgentString());
    localStringBuilder.append("/ DEMO");
    localWebSettings.setUserAgentString(localStringBuilder.toString());
    this.a = getSettings().getUserAgentString();
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
    setWebViewClient(this.g);
    setWebChromeClient(this.h);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
  }
  
  public <T extends j> T a(Class<T> paramClass)
  {
    return null;
  }
  
  public void a(int paramInt, long paramLong)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      ((Animator)localObject).cancel();
      this.f = null;
    }
    localObject = ValueAnimator.ofInt(new int[] { getContentView().getScrollY(), paramInt });
    ((ValueAnimator)localObject).addUpdateListener(new ah.2(this));
    ((ValueAnimator)localObject).setInterpolator(new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(paramLong);
    ((ValueAnimator)localObject).start();
    this.f = ((Animator)localObject);
  }
  
  public void a(Context paramContext)
  {
    if (!(getContext() instanceof MutableContextWrapper)) {
      return;
    }
    ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
  }
  
  public void a(@Nullable Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      postOnAnimation(paramRunnable);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    super.loadDataWithBaseURL(paramString1, paramString2, "text/html", "UTF-8", null);
  }
  
  public void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    evaluateJavascript(paramString, paramValueCallback);
  }
  
  public void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback)
  {
    evaluateJavascript(paramString3, paramValueCallback);
  }
  
  public boolean a(@NonNull Canvas paramCanvas)
  {
    draw(paramCanvas);
    return true;
  }
  
  public boolean c()
  {
    return getWebScrollY() == 0;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  public void e()
  {
    super.onPause();
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    paramString = new ah.1(this, paramString, paramValueCallback);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramString.run();
      return;
    }
    t.a(paramString);
  }
  
  public void f()
  {
    super.onResume();
  }
  
  public void g()
  {
    super.scrollTo(getScrollX(), 0);
  }
  
  public View getContentView()
  {
    return this;
  }
  
  public d getFullscreenImpl()
  {
    return this.e;
  }
  
  public String getUserAgentString()
  {
    return this.a;
  }
  
  public int getWebScrollX()
  {
    return getScrollX();
  }
  
  public int getWebScrollY()
  {
    return getScrollY();
  }
  
  public View getWrapperView()
  {
    return this;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ac localac = this.d;
    if (localac != null) {
      localac.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ae localae = this.c;
    if (localae != null) {
      localae.a(paramInt1, paramInt2, paramInt3, paramInt4, this);
    }
  }
  
  public void setAppBrandInfo(Map<String, String> paramMap) {}
  
  public void setAppBrandWebViewClient(aa paramaa)
  {
    this.b = paramaa;
  }
  
  public void setFullscreenImpl(d paramd)
  {
    this.e = paramd;
  }
  
  public void setJsExceptionHandler(h paramh) {}
  
  public void setOnScrollChangedListener(ae paramae)
  {
    this.c = paramae;
  }
  
  public void setOnTrimListener(ad paramad) {}
  
  public void setWebViewLayoutListener(ac paramac)
  {
    this.d = paramac;
  }
  
  public void setXWebKeyboardImpl(ag paramag) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ah
 * JD-Core Version:    0.7.0.1
 */