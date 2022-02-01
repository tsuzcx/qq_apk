package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jj.a.g;
import com.tencent.luggage.wxa.jj.a.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public class f
  extends m
{
  private String b;
  private ViewGroup c;
  private com.tencent.luggage.wxa.qa.a d;
  private FrameLayout e;
  private u f = getContainer().j();
  private Map<String, u> g = new HashMap();
  private SparseArray<q> h = new SparseArray();
  private boolean i = false;
  private boolean j = false;
  private final Runnable k = new f.1(this);
  private final Runnable l = new f.3(this);
  private final LinkedList<f.c> m = new LinkedList();
  
  public f(Context paramContext, o paramo)
  {
    super(paramContext, paramo);
  }
  
  private void a(f.c paramc, long paramLong)
  {
    this.m.addLast(paramc);
    postDelayed(paramc, paramLong);
  }
  
  private void a(u paramu, String paramString, @Nullable Runnable paramRunnable)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandMultiplePage", "loadAndWait appId[%s] url[%s]", new Object[] { getAppId(), paramString });
    paramRunnable = new f.7(this, paramString, paramRunnable);
    paramu.a(new f.8(this, paramu, paramRunnable, System.currentTimeMillis(), paramString));
    if (this.g.size() > 1) {
      a(paramRunnable, 500L);
    }
    this.i = true;
    paramu.a(paramString);
  }
  
  private void b(boolean paramBoolean)
  {
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      f.c localc = (f.c)localIterator.next();
      removeCallbacks(localc);
      if (paramBoolean) {
        localc.run();
      } else {
        localc.b();
      }
    }
    this.m.clear();
  }
  
  private u d(String paramString)
  {
    try
    {
      u localu;
      if (this.f != null)
      {
        localu = this.f;
        this.f = null;
      }
      else
      {
        localu = getContainer().j();
      }
      localu.a(this);
      this.g.put(paramString, localu);
      this.e.addView(localu.getContentView(), 0);
      return localu;
    }
    finally {}
  }
  
  private void e(String paramString)
  {
    this.i = false;
    u localu2 = (u)this.g.get(com.tencent.luggage.util.m.b(paramString));
    localu2.getContentView().setVisibility(4);
    Iterator localIterator = this.g.values().iterator();
    label48:
    u localu1;
    for (paramString = null; localIterator.hasNext(); paramString = localu1)
    {
      localu1 = (u)localIterator.next();
      if ((localu1.getContentView().getVisibility() != 0) || (localu2 == localu1)) {
        break label48;
      }
    }
    localu2.getContentView().bringToFront();
    localu2.getContentView().setVisibility(0);
    if (paramString != null) {
      paramString.getContentView().setVisibility(4);
    }
    if (paramString != null) {
      paramString.aw();
    }
    localu2.au();
    y();
  }
  
  private void u()
  {
    if (this.j) {
      return;
    }
    post(this.k);
  }
  
  private void v()
  {
    if (this.j) {
      return;
    }
    if (getCurrentPageView() == null) {
      return;
    }
    if (this.i) {
      return;
    }
    if (!"top".equals(this.d.getPosition())) {
      return;
    }
    if (!(this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.d.getLayoutParams();
    com.tencent.mm.plugin.appbrand.widget.actionbar.b localb = getCurrentPageView().ah();
    int n = localb.getTop() + localb.getMeasuredHeight();
    if (localMarginLayoutParams.topMargin != n)
    {
      localMarginLayoutParams.topMargin = n;
      this.d.setLayoutParams(localMarginLayoutParams);
      post(new f.2(this));
    }
    getCurrentPageView().a(this.d.getMeasuredHeight());
  }
  
  private void w()
  {
    if (this.j) {
      return;
    }
    post(this.l);
  }
  
  private ViewGroup x()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    this.e = new FrameLayout(getContext());
    com.tencent.luggage.wxa.ef.d.a("createTabBar", new f.4(this));
    if (getContainer().getAppConfig().e().f) {
      this.d.setVisibility(8);
    }
    if ("top".equals(getContainer().getAppConfig().e().a))
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(10);
      localRelativeLayout.addView(this.e, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(10);
      localRelativeLayout.addView(this.d, localLayoutParams);
      return localRelativeLayout;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    localRelativeLayout.addView(this.d, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(2, this.d.getId());
    localRelativeLayout.addView(this.e, localLayoutParams);
    return localRelativeLayout;
  }
  
  private void y()
  {
    if (this.h.size() <= 0) {
      return;
    }
    int n = 0;
    while (n < this.h.size())
    {
      ((q)this.h.valueAt(n)).setVisibility(4);
      n += 1;
    }
    Object localObject = getCurrentPageView();
    if (localObject == null) {
      return;
    }
    localObject = (q)this.h.get(localObject.hashCode());
    if (localObject != null) {
      ((q)localObject).setVisibility(0);
    }
  }
  
  protected View a()
  {
    if (this.c == null) {
      this.c = x();
    }
    return this.c;
  }
  
  protected com.tencent.luggage.wxa.qa.a a(@Nullable al paramal)
  {
    Object localObject1;
    if (paramal != null) {
      localObject1 = (com.tencent.luggage.wxa.qa.a)paramal.a(com.tencent.luggage.wxa.qa.a.class);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = (com.tencent.luggage.wxa.qa.a)getContainer().getDecorWidgetFactory().a(getContext(), com.tencent.luggage.wxa.qa.a.class);
    }
    ((com.tencent.luggage.wxa.qa.a)localObject2).setId(2131428546);
    a.g localg = getContainer().getAppConfig().e();
    ((com.tencent.luggage.wxa.qa.a)localObject2).setPosition(localg.a);
    ((com.tencent.luggage.wxa.qa.a)localObject2).a(localg.b, localg.c, localg.d, localg.e);
    Iterator localIterator = localg.g.iterator();
    while (localIterator.hasNext())
    {
      a.h localh = (a.h)localIterator.next();
      if (paramal != null) {
        localObject1 = (com.tencent.luggage.wxa.qa.b)paramal.a(com.tencent.luggage.wxa.qa.b.class);
      } else {
        localObject1 = new com.tencent.luggage.wxa.qa.b(getContext());
      }
      ((com.tencent.luggage.wxa.qa.a)localObject2).a(localh.a, localh.b, localh.c, localh.d, (com.tencent.luggage.wxa.qa.b)localObject1);
    }
    ((com.tencent.luggage.wxa.qa.a)localObject2).setClickListener(new f.5(this, localg));
    return localObject2;
  }
  
  protected void a(u paramu, q paramq)
  {
    if (paramu == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandMultiplePage", "getCurrentFullScreenView err, pageView is null");
      return;
    }
    if ((paramq != null) && (paramq.getParent() == null))
    {
      ViewGroup localViewGroup = this.c;
      if ((localViewGroup instanceof ViewGroup))
      {
        localViewGroup.addView(paramq, new ViewGroup.LayoutParams(-1, -1));
        this.h.put(paramu.hashCode(), paramq);
      }
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, null);
  }
  
  public final void a(String paramString, @Nullable f.b paramb)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandMultiplePage", "AppBrandPageProfile| loadUrl");
    if (paramString.equals(this.b))
    {
      if (paramb != null)
      {
        paramb.b(this, paramString);
        paramb.c(this, paramString);
      }
      return;
    }
    int n = this.d.a(paramString);
    if (n < 0)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandMultiplePage", "loadUrl, index not found, appId:%s, url:%s", new Object[] { getAppId(), paramString });
      if (paramb != null) {
        paramb.a(this, paramString);
      }
      return;
    }
    b(true);
    this.b = paramString;
    this.d.a(n);
    if (this.g.get(com.tencent.luggage.util.m.b(paramString)) == null)
    {
      u localu = d(com.tencent.luggage.util.m.b(paramString));
      if (paramb != null) {
        paramb.b(this, paramString);
      }
      a(localu, paramString, new f.6(this, paramb, paramString));
      return;
    }
    if (paramb != null) {
      paramb.b(this, paramString);
    }
    e(paramString);
    if (paramb != null) {
      paramb.c(this, paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    Object localObject = this.f;
    if ((localObject != null) && (a(paramArrayOfInt, ((u)localObject).getComponentId()))) {
      this.f.a(paramString1, paramString2);
    }
    localObject = this.g.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      u localu = (u)((Iterator)localObject).next();
      if (a(paramArrayOfInt, localu.getComponentId())) {
        localu.a(paramString1, paramString2);
      }
    }
  }
  
  public void b()
  {
    this.j = true;
    super.b();
    Object localObject = this.f;
    if (localObject != null) {
      ((u)localObject).l();
    }
    localObject = this.g.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((u)((Iterator)localObject).next()).l();
    }
    b(false);
    removeCallbacks(this.k);
    removeCallbacks(this.l);
  }
  
  public boolean b(String paramString)
  {
    return this.d.a(paramString) != -1;
  }
  
  protected void c()
  {
    super.c();
    Object localObject = this.f;
    if (localObject != null) {
      ((u)localObject).az();
    }
    localObject = this.g.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((u)((Iterator)localObject).next()).az();
    }
  }
  
  public void d()
  {
    super.d();
    getCurrentPageView().au();
  }
  
  public void e()
  {
    super.e();
    getCurrentPageView().aw();
  }
  
  public Iterator<u> f()
  {
    return new f.9(this);
  }
  
  public u getCurrentPageView()
  {
    try
    {
      if (this.f != null)
      {
        localu = this.f;
        return localu;
      }
      u localu = (u)this.g.get(com.tencent.luggage.util.m.b(this.b));
      return localu;
    }
    finally {}
  }
  
  public String getCurrentUrl()
  {
    return this.b;
  }
  
  public com.tencent.luggage.wxa.qa.a getTabBar()
  {
    return this.d;
  }
  
  public void onDescendantInvalidated(@NonNull View paramView1, @NonNull View paramView2)
  {
    super.onDescendantInvalidated(paramView1, paramView2);
    if ((paramView2 instanceof com.tencent.mm.plugin.appbrand.widget.actionbar.d))
    {
      u();
      w();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    u();
    w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.f
 * JD-Core Version:    0.7.0.1
 */