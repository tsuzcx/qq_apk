package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.tencent.luggage.util.h;
import com.tencent.luggage.wxa.jj.a.d;
import com.tencent.luggage.wxa.oj.c;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.sv.a.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

public abstract class m
  extends com.tencent.luggage.wxa.sv.a
{
  final boolean[] a = { false };
  private o b;
  private View c;
  private boolean d = true;
  private boolean e = false;
  private final Map<com.tencent.luggage.wxa.oj.d, c> f = new HashMap();
  private final Set<Runnable> g = new HashSet();
  private int h;
  private int i;
  private boolean j = false;
  private final a.a k = new m.4(this);
  private boolean l = false;
  
  public m(Context paramContext, o paramo)
  {
    super(paramContext);
    this.b = paramo;
    paramContext = new StringBuilder();
    paramContext.append("AppBrandPageProfile| ");
    paramContext.append(getLocalClassName());
    paramContext.append(" <init>:initView()");
    com.tencent.luggage.wxa.ef.d.a(paramContext.toString(), new m.1(this));
  }
  
  private void a(float paramFloat)
  {
    if (this.d) {
      if (paramFloat >= 0.0F) {
        v();
      } else {
        w();
      }
    }
    a(this, getWidth() / 4.0F * (1.0F - paramFloat) * -1.0F);
  }
  
  private void a(View paramView, float paramFloat)
  {
    paramView.clearAnimation();
    paramView.setTranslationX(paramFloat);
  }
  
  private void a(String paramString, bg parambg, @Nullable o.h paramh)
  {
    HashMap localHashMap = new HashMap();
    String str1 = getCurrentUrl();
    String str2 = com.tencent.luggage.util.m.b(str1);
    Map localMap = com.tencent.luggage.util.m.c(str1);
    localHashMap.put("path", str2);
    localHashMap.put("query", localMap);
    localHashMap.put("rawPath", str1);
    if (parambg != null) {
      localHashMap.put("openType", parambg.toString());
    }
    if (paramh != null) {
      localHashMap.put("pipMode", paramh.c);
    }
    if ("onAppRoute".equals(paramString))
    {
      localHashMap.put("resizing", Boolean.valueOf(getCurrentPageView().aG()));
      if (bg.c != parambg)
      {
        if (this.b.getAppConfig().l() != null) {
          localHashMap.put("page", this.b.getAppConfig().l().opt(str2));
        }
        if (this.b.getAppConfig().m() != null)
        {
          paramh = StringUtils.substring(str2, 0, str2.lastIndexOf(".html"));
          localHashMap.put("preloadRule", this.b.getAppConfig().m().opt(paramh));
        }
      }
      getCurrentPageView().a(localHashMap, parambg);
    }
    com.tencent.luggage.util.g.a(localHashMap);
    getCurrentPageView().a(paramString, new JSONObject(localHashMap).toString(), null);
  }
  
  private void f()
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.g.clear();
  }
  
  private View getContentView()
  {
    return this.c;
  }
  
  private String getLocalClassName()
  {
    return getClass().getName().replaceFirst(Pattern.quote("com.tencent.mm.plugin.appbrand"), "");
  }
  
  private void u() {}
  
  private void v()
  {
    setVisibility(0);
  }
  
  private void w()
  {
    if (this.d) {
      setVisibility(4);
    }
  }
  
  private void x()
  {
    this.c = a();
    addView(getContentView());
    setContentView(getContentView());
  }
  
  private void y()
  {
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setScrimColor(0);
    x();
    a(this.k);
  }
  
  protected abstract View a();
  
  @Nullable
  public c a(com.tencent.luggage.wxa.oj.d paramd)
  {
    synchronized (this.f)
    {
      paramd = (c)this.f.get(paramd);
      return paramd;
    }
  }
  
  public void a(bg parambg, @Nullable o.h paramh)
  {
    a("onAppRoute", parambg, paramh);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPage", "onAppRoute: %s, %s", new Object[] { parambg.toString(), getCurrentUrl() });
  }
  
  protected void a(u paramu, q paramq)
  {
    if ((paramq != null) && (paramq.getParent() == null))
    {
      paramu = this.c;
      if ((paramu instanceof ViewGroup)) {
        ((ViewGroup)paramu).addView(paramq, new ViewGroup.LayoutParams(-1, -1));
      }
    }
  }
  
  public final void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      f.a.a(new m.2(this, paramRunnable));
      return;
    }
    Object localObject = getTag(o.e);
    if ((localObject instanceof Animator))
    {
      ((Animator)localObject).addListener(new m.3(this, paramRunnable));
      return;
    }
    if (getAnimation() == null)
    {
      paramRunnable.run();
      return;
    }
    this.g.add(paramRunnable);
  }
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  protected boolean a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length == 0) {
        return true;
      }
      int n = paramArrayOfInt.length;
      int m = 0;
      while (m < n)
      {
        if (paramArrayOfInt[m] == paramInt) {
          return true;
        }
        m += 1;
      }
      return false;
    }
    return true;
  }
  
  @CallSuper
  protected void b() {}
  
  public abstract boolean b(String paramString);
  
  @CallSuper
  protected void c()
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandPage", "onPageDestroy: %s", new Object[] { getCurrentUrl() });
  }
  
  public void c(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  @CallSuper
  protected void d()
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandPage", "onPageForeground: %s", new Object[] { getCurrentUrl() });
    m();
    v();
  }
  
  @CallSuper
  protected void e()
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandPage", "onPageBackground: %s", new Object[] { getCurrentUrl() });
    u();
  }
  
  public final int g()
  {
    o localo = this.b;
    if (localo == null) {
      return -1;
    }
    return localo.c(this);
  }
  
  public String getAppId()
  {
    return this.b.getAppId();
  }
  
  protected o getContainer()
  {
    return this.b;
  }
  
  public abstract u getCurrentPageView();
  
  public abstract String getCurrentUrl();
  
  public a.d getPageConfig()
  {
    return getCurrentPageView().am();
  }
  
  final void h()
  {
    u localu = getCurrentPageView();
    if (localu != null) {
      localu.F();
    }
  }
  
  final void i()
  {
    if (this.d)
    {
      this.d = false;
      this.e = false;
      d();
    }
  }
  
  final void j()
  {
    if (!this.d)
    {
      this.d = true;
      e();
    }
  }
  
  public final void k()
  {
    c();
  }
  
  public final void l()
  {
    b();
  }
  
  public void m()
  {
    if (this.b.getRuntime().aW()) {
      setEnableGesture(false);
    } else {
      setEnableGesture(this.b.f());
    }
    setEdgeTrackingEnabled(1);
    a(1.0F);
    this.a[0] = false;
    this.j = false;
    super.t();
  }
  
  protected final boolean n()
  {
    return this.d;
  }
  
  public void o()
  {
    a("onAppRouteDone", null, null);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPage", "onAppRouteDone: %s", new Object[] { getCurrentUrl() });
  }
  
  protected final void onAnimationEnd()
  {
    super.onAnimationEnd();
    f();
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.d) {
      this.e = true;
    }
    u localu = getCurrentPageView();
    if (localu != null) {
      localu.a(paramConfiguration);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m;
    if ((this.d) && (!this.e) && (this.h > 0) && (this.i > 0)) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.h, 1073741824), View.MeasureSpec.makeMeasureSpec(this.i, 1073741824));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    this.h = getMeasuredWidth();
    this.i = getMeasuredHeight();
  }
  
  protected final void p()
  {
    h.a(getContext());
  }
  
  protected void q()
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandPage", "onSwipeBack %s", new Object[] { Log.getStackTraceString(new Throwable()) });
    this.j = true;
    post(new m.5(this));
  }
  
  public boolean r()
  {
    return this.j;
  }
  
  public boolean s()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.m
 * JD-Core Version:    0.7.0.1
 */