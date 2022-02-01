package com.tencent.luggage.wxa.ct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.pc.m.a;
import com.tencent.luggage.wxa.pp.u.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.xweb.WebView;
import com.tencent.xweb.w;
import com.tencent.xweb.y;
import java.io.File;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@SuppressLint({"ViewConstructor"})
public final class a
  extends FrameLayout
  implements com.tencent.luggage.wxa.mq.a
{
  private final com.tencent.luggage.wxa.cv.c a;
  private String b;
  private i c;
  private com.tencent.mm.plugin.appbrand.widget.i d;
  private com.tencent.luggage.wxa.dq.c e;
  private b f;
  private com.tencent.luggage.wxa.oi.f g;
  private int h = 0;
  private String i = "";
  private boolean j = true;
  private boolean k = false;
  private final LinkedList<com.tencent.mm.plugin.appbrand.widget.dialog.b> l = new LinkedList();
  private Map<Integer, ValueCallback<Uri[]>> m = null;
  private int n = 0;
  private final Function2<String, String, Unit> o = new a.1(this);
  private com.tencent.luggage.wxa.pp.u p = null;
  private final u.c q = new a.2(this);
  private boolean r = false;
  private final y s = new a.7(this);
  private final h t = new a.8(this);
  
  public a(Context paramContext, com.tencent.luggage.wxa.iu.d paramd, com.tencent.luggage.wxa.dq.c paramc)
  {
    super(paramContext);
    this.b = paramd.aa();
    this.e = paramc;
    this.c = new a.3(this, paramContext);
    this.c.setWebViewClient(this.s);
    this.c.setWebChromeClient(this.t);
    this.c.getSettings().j(true);
    this.c.getSettings().g(true);
    this.c.getSettings().a(false);
    if (Build.VERSION.SDK_INT >= 21) {
      this.c.getSettings().c(0);
    }
    paramd = this.c.getSettings().a();
    paramd = com.tencent.luggage.wxa.pc.m.a(getContext(), paramd, (m.a)e.a(m.a.class));
    paramc = new StringBuilder();
    paramc.append(paramd);
    paramc.append(" miniProgram");
    paramd = paramc.toString();
    this.c.getSettings().b(paramd);
    this.c.setHorizontalScrollBarEnabled(false);
    this.c.setVerticalScrollBarEnabled(false);
    this.c.getSettings().b(true);
    this.c.getSettings().f(true);
    this.c.getSettings().c(true);
    this.c.getSettings().e(false);
    this.c.getSettings().d(false);
    this.c.getSettings().k(true);
    this.c.getSettings().l(true);
    this.c.getSettings().a(10485760L);
    this.c.getSettings().a(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.c.getSettings().h(true);
    this.c.getSettings().i(true);
    this.c.getSettings().m(true);
    addView(this.c, new ViewGroup.LayoutParams(-1, -1));
    this.d = new com.tencent.mm.plugin.appbrand.widget.i(paramContext);
    this.d.setProgressDrawable(ContextCompat.getDrawable(paramContext, 2130853486));
    addView(this.d, new ViewGroup.LayoutParams(-1, com.tencent.luggage.wxa.qx.a.e(paramContext, 3)));
    this.e.a(new a.4(this));
    this.f = new b(this);
    this.a = new com.tencent.luggage.wxa.cv.c(new a.5(this));
    try
    {
      getHTMLExitReporter().b();
    }
    catch (Exception paramContext)
    {
      o.a("Luggage.STANDALONE.AppBrandHTMLWebView", paramContext, "", new Object[0]);
    }
    this.d.a();
  }
  
  private void a(com.tencent.mm.plugin.appbrand.page.u paramu, String paramString)
  {
    paramu = this.g;
    if (paramu != null) {
      paramu.b(paramString);
    }
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    e();
    this.d.a();
    new a.b(null).a(this.e).a("src", paramString).a("htmlId", Integer.valueOf(this.h)).a();
  }
  
  private boolean b(String paramString)
  {
    if (this.a.a(paramString)) {
      return false;
    }
    this.a.a(paramString, this.o);
    return true;
  }
  
  private void c(String paramString)
  {
    this.e.g(paramString);
  }
  
  private void d(String paramString)
  {
    e();
    f();
    this.f.k();
    this.d.b();
    if ((!this.j) && (!this.k)) {
      try
      {
        getHTMLExitReporter().a(this.e, this.i, paramString);
      }
      catch (Exception localException)
      {
        o.a("Luggage.STANDALONE.AppBrandHTMLWebView", localException, "", new Object[0]);
      }
    }
    this.j = false;
    this.k = false;
    setCurrentURL(paramString);
    new a.a(null).a(this.e).a("src", paramString).a("htmlId", Integer.valueOf(this.h)).a();
  }
  
  private void e()
  {
    this.c.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
  }
  
  private void e(String paramString)
  {
    f();
  }
  
  private void f()
  {
    String str = com.tencent.luggage.wxa.pc.c.a("wxjs-new.js");
    this.c.evaluateJavascript(str, null);
  }
  
  private com.tencent.luggage.wxa.ov.m getHTMLExitReporter()
  {
    return getPageView().f().k().getReporter().d();
  }
  
  private com.tencent.luggage.wxa.ov.n getHTMLResourceLoadReporter()
  {
    return getPageView().f().k().getReporter().e();
  }
  
  @UiThread
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    if ((getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    }
    this.c.a(paramContext);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (t.a())
    {
      paramRunnable.run();
      return;
    }
    post(paramRunnable);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.c.loadUrl(paramString);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    new a.c(null).a(this.e).a("htmlId", Integer.valueOf(this.h)).a("errorCode", Integer.valueOf(paramInt)).a("description", paramString2).a("src", paramString1).a();
  }
  
  public boolean a()
  {
    if (getWebView().canGoBack())
    {
      try
      {
        getHTMLExitReporter().a(getPageView(), true);
      }
      catch (Exception localException1)
      {
        o.a("Luggage.STANDALONE.AppBrandHTMLWebView", localException1, "", new Object[0]);
      }
      getWebView().goBack();
      this.k = true;
      return true;
    }
    try
    {
      getHTMLExitReporter().a(getPageView(), false);
      return false;
    }
    catch (Exception localException2)
    {
      o.a("Luggage.STANDALONE.AppBrandHTMLWebView", localException2, "", new Object[0]);
    }
    return false;
  }
  
  public void b()
  {
    this.c.onResume();
    this.f.i();
  }
  
  public void c()
  {
    this.f.j();
    this.c.onPause();
  }
  
  public void d()
  {
    a.6 local6 = new a.6(this);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local6.run();
      return;
    }
    new Handler(Looper.getMainLooper()).post(local6);
  }
  
  public String getCurrentURL()
  {
    if (TextUtils.isEmpty(this.i)) {
      try
      {
        String str = this.c.getUrl();
        return str;
      }
      catch (Exception localException)
      {
        o.b("Luggage.STANDALONE.AppBrandHTMLWebView", "getCurrentURL e=%s", new Object[] { localException });
      }
    }
    return this.i;
  }
  
  public com.tencent.luggage.wxa.dq.c getPageView()
  {
    return this.e;
  }
  
  public String getUrl()
  {
    return getWebView().getUrl();
  }
  
  public WebView getWebView()
  {
    return this.c;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.p = com.tencent.luggage.wxa.pp.n.c(this);
    com.tencent.luggage.wxa.pp.u localu = this.p;
    if (localu != null) {
      localu.a(this.q);
    }
    this.g = ((com.tencent.luggage.wxa.oi.f)this.e.d(com.tencent.luggage.wxa.oi.f.class));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (!this.e.d()) {
      getWebView().destroy();
    }
    com.tencent.luggage.wxa.pp.u localu = this.p;
    if (localu != null) {
      localu.b(this.q);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    if ((getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)getParent();
      i1 = View.MeasureSpec.getMode(paramInt2);
      if (i1 != -2147483648)
      {
        if (i1 != 0)
        {
          if (i1 != 1073741824)
          {
            i1 = paramInt2;
          }
          else
          {
            i1 = paramInt2;
            if (View.MeasureSpec.getSize(paramInt2) > localViewGroup.getMeasuredHeight()) {
              i1 = View.MeasureSpec.makeMeasureSpec(localViewGroup.getMeasuredHeight(), 1073741824);
            }
          }
        }
        else {
          i1 = View.MeasureSpec.makeMeasureSpec(localViewGroup.getMeasuredHeight(), -2147483648);
        }
      }
      else {
        i1 = View.MeasureSpec.makeMeasureSpec(Math.max(0, Math.min(localViewGroup.getMeasuredHeight(), View.MeasureSpec.getSize(paramInt2))), -2147483648);
      }
    }
    super.onMeasure(paramInt1, i1);
  }
  
  public void setCurrentURL(String paramString)
  {
    this.i = paramString;
    if (!af.c(paramString))
    {
      paramString = Uri.parse(paramString).getHost();
      if (af.c(paramString))
      {
        a(this.e, "");
        return;
      }
      a(this.e, paramString);
      return;
    }
    a(this.e, "");
  }
  
  public void setViewId(int paramInt)
  {
    this.h = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.a
 * JD-Core Version:    0.7.0.1
 */