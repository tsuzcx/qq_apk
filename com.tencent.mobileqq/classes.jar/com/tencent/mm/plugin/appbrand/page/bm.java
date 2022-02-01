package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.gg.c;
import com.tencent.luggage.wxa.pc.m;
import com.tencent.luggage.wxa.pc.m.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.j;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.u;
import com.tencent.xweb.w;
import com.tencent.xweb.x;
import com.tencent.xweb.x5.export.external.extension.proxy.a;
import com.tencent.xweb.y;
import java.net.URL;
import java.util.LinkedList;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkPreferences;

@SuppressLint({"ViewConstructor"})
public class bm
  extends com.tencent.xweb.WebView
  implements com.tencent.luggage.wxa.fx.b, com.tencent.luggage.wxa.oi.e, am, an
{
  private a A = new bm.2(this);
  private Boolean B = null;
  private ae a;
  private ac k = null;
  private ad l;
  private aa m = null;
  private com.tencent.luggage.wxa.oq.d n;
  private Animator o;
  private boolean p = false;
  private boolean q = false;
  private String r;
  private String s;
  private c t;
  private boolean u = false;
  private ag v;
  private final LinkedList<bm.a> w = new LinkedList();
  private y x = new bm.8(this);
  private u y = new bm.9(this);
  private x z = new bm.10(this);
  
  static
  {
    o.d("Luggage.XWebViewImpl", "initWebviewCore");
    com.tencent.xweb.WebView.initWebviewCore(r.a(), WebView.c.b, "appbrand", null);
  }
  
  public bm(Context paramContext)
  {
    super(new MutableContextWrapper(paramContext));
    h();
  }
  
  private com.tencent.xweb.WebResourceResponse a(android.webkit.WebResourceResponse paramWebResourceResponse)
  {
    if (paramWebResourceResponse == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      return new com.tencent.xweb.WebResourceResponse(paramWebResourceResponse.getMimeType(), paramWebResourceResponse.getEncoding(), paramWebResourceResponse.getStatusCode(), paramWebResourceResponse.getReasonPhrase(), paramWebResourceResponse.getResponseHeaders(), paramWebResourceResponse.getData());
    }
    return new com.tencent.xweb.WebResourceResponse(paramWebResourceResponse.getMimeType(), paramWebResourceResponse.getEncoding(), paramWebResourceResponse.getData());
  }
  
  private com.tencent.xweb.WebResourceResponse a(String paramString)
  {
    return a(this.m.e(paramString));
  }
  
  private void h()
  {
    getSettings().j(true);
    getSettings().g(true);
    getSettings().a(false);
    getSettings().c(0);
    this.s = getSettings().a();
    getSettings().b(m.a(getContext(), getSettings().a(), (m.a)com.tencent.luggage.wxa.ba.e.a(m.a.class)));
    this.r = getSettings().a();
    getSettings().b(100);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(false);
    setWebViewClient(this.x);
    setWebChromeClient(this.y);
    setWebViewCallbackClient(this.z);
    setWebViewClientExtension(this.A);
    getSettings().a(1);
    i();
    setBackgroundColor(0);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setOnLongClickListener(new bm.1(this));
    setDownloadListener(new bm.3(this));
  }
  
  private void i()
  {
    this.t = com.tencent.luggage.wxa.fx.d.a(this, com.tencent.luggage.wxa.gg.b.a(), new com.tencent.luggage.wxa.ju.d(), new bm.4(this));
  }
  
  private void j()
  {
    o.d("Luggage.XWebViewImpl", "fireAllPendingReRenderedTasks size=%d", new Object[] { Integer.valueOf(this.w.size()) });
    while (!this.w.isEmpty()) {
      ((bm.a)this.w.pollFirst()).run();
    }
  }
  
  public static void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    try
    {
      XWalkPreferences.setValue("remote-debugging", paramBoolean);
      if (com.tencent.xweb.WebView.isSys()) {
        android.webkit.WebView.setWebContentsDebuggingEnabled(paramBoolean);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public final <T extends j> T a(Class<T> paramClass)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramClass == com.tencent.luggage.wxa.oi.e.class)
    {
      if (supportFeature(1040)) {
        localObject1 = (j)paramClass.cast(this);
      }
      return localObject1;
    }
    localObject1 = localObject2;
    if (paramClass.isInstance(this)) {
      localObject1 = (j)paramClass.cast(this);
    }
    return localObject1;
  }
  
  public final void a()
  {
    onShow();
  }
  
  public void a(int paramInt, long paramLong)
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      ((Animator)localObject).cancel();
      this.o = null;
    }
    if (super.supportFeature(2005))
    {
      super.smoothScroll(getWebScrollX(), paramInt, paramLong);
      return;
    }
    localObject = ValueAnimator.ofInt(new int[] { getView().getScrollY(), paramInt });
    ((ValueAnimator)localObject).addUpdateListener(new bm.7(this));
    ((ValueAnimator)localObject).setInterpolator(new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(paramLong);
    ((ValueAnimator)localObject).start();
    this.o = ((Animator)localObject);
  }
  
  public void a(Context paramContext)
  {
    if (!(getContext() instanceof MutableContextWrapper)) {
      return;
    }
    MutableContextWrapper localMutableContextWrapper = (MutableContextWrapper)getContext();
    if (localMutableContextWrapper.getBaseContext() == paramContext) {
      return;
    }
    localMutableContextWrapper.setBaseContext(paramContext);
  }
  
  public void a(@Nullable Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (this.q)
    {
      o.c("Luggage.XWebViewImpl", "postOnReRendered webview destroyed, stack=%s", new Object[] { Log.getStackTraceString(new Throwable()) });
      return;
    }
    paramRunnable = new bm.a(this, paramRunnable, null);
    if (isXWalkKernel())
    {
      postDelayed(paramRunnable, 200L);
      return;
    }
    postOnAnimation(paramRunnable);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.p = false;
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
    if (isXWalkKernel()) {
      drawCanvas(paramCanvas);
    } else {
      draw(paramCanvas);
    }
    return true;
  }
  
  public final void b()
  {
    onHide();
  }
  
  public boolean c()
  {
    if ((isXWalkKernel()) && (XWalkEnvironment.getAvailableVersion() >= 472)) {
      return isOverScrollStart();
    }
    return getWebScrollY() == 0;
  }
  
  public boolean d()
  {
    Boolean localBoolean = this.B;
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    try
    {
      localBoolean = Boolean.valueOf(XWalkPreferences.getBooleanValue("remote-debugging"));
      this.B = localBoolean;
      boolean bool = localBoolean.booleanValue();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      label36:
      break label36;
    }
    return false;
  }
  
  public void destroy()
  {
    if (this.q) {
      return;
    }
    j();
    try
    {
      super.destroy();
    }
    catch (Exception localException1)
    {
      o.a("Luggage.XWebViewImpl", localException1, "[CAUGHT CRASH]", new Object[0]);
    }
    Object localObject = this.o;
    if (localObject != null)
    {
      ((Animator)localObject).cancel();
      this.o = null;
    }
    localObject = this.n;
    if (localObject != null)
    {
      ((com.tencent.luggage.wxa.oq.d)localObject).a(null);
      this.n.b();
    }
    this.n = null;
    try
    {
      a(getContext().getApplicationContext());
      label92:
      if ((getParent() instanceof ViewGroup)) {
        ((ViewGroup)getParent()).removeView(this);
      }
      this.q = true;
      o.d("Luggage.XWebViewImpl", "destroyed hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
      return;
    }
    catch (Exception localException2)
    {
      break label92;
    }
  }
  
  public void e()
  {
    onPause();
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    paramString = new bm.6(this, paramString, paramValueCallback);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramString.run();
      return;
    }
    t.a(paramString);
  }
  
  public void f()
  {
    onResume();
  }
  
  public void g()
  {
    getView().scrollTo(getView().getScrollX(), 0);
  }
  
  public View getContentView()
  {
    return super.getView();
  }
  
  public com.tencent.luggage.wxa.oq.d getFullscreenImpl()
  {
    return this.n;
  }
  
  public String getOriginUserAgent()
  {
    return this.s;
  }
  
  public String getUserAgentString()
  {
    return this.r;
  }
  
  public c getWebViewPluginClientProxy()
  {
    return this.t;
  }
  
  public View getWrapperView()
  {
    return this;
  }
  
  public final void onHide()
  {
    if (this.u) {
      return;
    }
    super.onHide();
    this.u = true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ac localac = this.k;
    if (localac != null) {
      localac.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public final void onShow()
  {
    super.onShow();
    this.u = false;
  }
  
  public void setAppBrandInfo(Map<String, String> paramMap)
  {
    paramMap = new bm.5(this, paramMap);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramMap.run();
      return;
    }
    t.a(paramMap);
  }
  
  public void setAppBrandWebViewClient(aa paramaa)
  {
    this.m = paramaa;
  }
  
  public void setFullscreenImpl(com.tencent.luggage.wxa.oq.d paramd)
  {
    this.n = paramd;
  }
  
  public void setJsExceptionHandler(h paramh) {}
  
  public void setOnScrollChangedListener(ae paramae)
  {
    this.a = paramae;
  }
  
  public void setOnTrimListener(ad paramad)
  {
    this.l = paramad;
  }
  
  public void setWebViewLayoutListener(ac paramac)
  {
    this.k = paramac;
  }
  
  public void setXWebKeyboardImpl(ag paramag)
  {
    this.v = paramag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bm
 * JD-Core Version:    0.7.0.1
 */