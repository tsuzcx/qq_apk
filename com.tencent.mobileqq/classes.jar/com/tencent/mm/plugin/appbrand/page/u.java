package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.AnyThread;
import androidx.annotation.CallSuper;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.jj.a.d;
import com.tencent.luggage.wxa.oi.f;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.pp.ae;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang.ArrayUtils;

@SuppressLint({"ViewConstructor"})
public class u
  extends c
  implements com.tencent.luggage.wxa.jx.e
{
  private static final int c = 2131428521;
  private aa A;
  private bf B = null;
  private com.tencent.luggage.wxa.oq.c C = new com.tencent.luggage.wxa.or.n();
  private boolean D = false;
  private final k E = new u.1(this);
  private String F;
  private boolean G = false;
  private int[] H = new int[0];
  private final AtomicBoolean I = new AtomicBoolean(false);
  private boolean J = false;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.d b_;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.b d;
  protected b e;
  private final int f = 2131428520;
  @Nullable
  private w g;
  @Nullable
  private final Class<? extends w> h;
  private Context i;
  private volatile com.tencent.luggage.wxa.iu.d j;
  private String k;
  private String l;
  private ViewGroup m;
  private FrameLayout n;
  private ab o;
  private aq p;
  private am q;
  private com.tencent.luggage.wxa.nj.a r;
  private volatile boolean s = false;
  private volatile boolean t = false;
  private volatile boolean u = false;
  private e.a v = null;
  private com.tencent.luggage.wxa.oq.d w;
  private List<com.tencent.luggage.wxa.nu.a> x;
  private final com.tencent.luggage.wxa.py.a y = new com.tencent.luggage.wxa.py.a(this);
  private m z;
  
  public u()
  {
    this(null);
  }
  
  protected u(@Nullable Class<? extends w> paramClass)
  {
    this.h = paramClass;
  }
  
  private int a(a.d paramd)
  {
    try
    {
      int i1 = com.tencent.luggage.wxa.pc.g.b(paramd.e);
      return i1;
    }
    catch (Exception localException)
    {
      label10:
      break label10;
    }
    return com.tencent.luggage.wxa.pc.g.a(paramd.h, -1);
  }
  
  private void a()
  {
    if (S() != null)
    {
      View localView = (View)com.tencent.luggage.wxa.ef.d.a("AppBrandPageViewProfile| onCreateView", new u.12(this));
      com.tencent.luggage.wxa.ef.d.a("AppBrandPageViewProfile| onViewCreated", new u.18(this, localView));
      com.tencent.luggage.wxa.ef.d.a("AppBrandPageViewProfile| initActionBar", new u.19(this));
      this.n = ((FrameLayout)localView);
      this.p = S().c();
      this.o = S().d();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (S() != null)
    {
      f localf = (f)S().a(f.class);
      if (localf != null) {
        localf.a(paramBoolean);
      }
    }
  }
  
  private am b(Context paramContext)
  {
    if (S() != null) {
      return S().b(paramContext);
    }
    return new ah(paramContext, W());
  }
  
  private void b()
  {
    this.d = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)a(be.b).a(getContext(), com.tencent.mm.plugin.appbrand.widget.actionbar.b.class));
    this.d.getActionView().setId(this.f);
    this.d.setBackButtonClickListener(new u.20(this));
    this.d.setCloseButtonClickListener(new u.21(this));
    this.d.a(new u.22(this));
    this.d.setOptionButtonClickListener(new u.23(this));
    this.b_ = ((com.tencent.mm.plugin.appbrand.widget.actionbar.d)a(be.b).a(getContext(), com.tencent.mm.plugin.appbrand.widget.actionbar.d.class));
    this.b_.setId(c);
    this.b_.setActuallyVisible(false);
    this.b_.setDeferStatusBarHeightChange(false);
    this.b_.addView(this.d, new ViewGroup.LayoutParams(-1, -1));
    a(new u.24(this));
    a(this.d);
    a(this.d);
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (S() != null)
    {
      f localf = (f)S().a(f.class);
      if (localf != null) {
        localf.a(paramString1, paramString2);
      }
    }
  }
  
  private void b(@Nullable List<com.tencent.luggage.wxa.nu.a> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      a(paramList);
      return;
    }
    o.c("MicroMsg.AppBrandPageView", "showPageActionSheet appId[%s], url[%s], empty list skip", new Object[] { getAppId(), an() });
  }
  
  private void f()
  {
    this.H = new int[0];
    getComponentId();
  }
  
  private void i()
  {
    this.t = true;
    if (S() != null)
    {
      com.tencent.luggage.wxa.oi.g localg = (com.tencent.luggage.wxa.oi.g)S().a(com.tencent.luggage.wxa.oi.g.class);
      if (localg != null)
      {
        localg.L();
        return;
      }
      throw new IllegalAccessError(String.format(Locale.US, "Renderer[%s] impl not supports preload", new Object[] { S().getClass().getName() }));
    }
  }
  
  private void j(String paramString)
  {
    a(new u.11(this, paramString));
  }
  
  private void k()
  {
    o.d("MicroMsg.AppBrandPageView", "AppBrandPageViewProfile| dispatchStart");
    if (S() != null) {
      S().e();
    }
  }
  
  public final boolean C()
  {
    if (S() != null)
    {
      com.tencent.luggage.wxa.oi.g localg = (com.tencent.luggage.wxa.oi.g)S().a(com.tencent.luggage.wxa.oi.g.class);
      return (localg != null) && (localg.M());
    }
    return q() == null;
  }
  
  public final boolean D()
  {
    if (S() != null)
    {
      com.tencent.luggage.wxa.oi.g localg = (com.tencent.luggage.wxa.oi.g)S().a(com.tencent.luggage.wxa.oi.g.class);
      return (localg != null) && (localg.N());
    }
    return this.t;
  }
  
  protected String H()
  {
    return "AppBrandPageView";
  }
  
  public boolean R()
  {
    return this.u;
  }
  
  @Nullable
  protected final w S()
  {
    Object localObject = this.h;
    if (localObject == null) {
      return null;
    }
    w localw = this.g;
    if (localw != null) {
      return localw;
    }
    localObject = bl.a(this, (Class)localObject);
    this.g = ((w)localObject);
    return localObject;
  }
  
  @Nullable
  public final m T()
  {
    return this.z;
  }
  
  public final bf U()
  {
    return this.B;
  }
  
  public final void V()
  {
    M();
    i();
  }
  
  protected final aa W()
  {
    if (this.A == null) {
      this.A = new aa(this);
    }
    return this.A;
  }
  
  public com.tencent.luggage.wxa.py.a X()
  {
    return this.y;
  }
  
  @Nullable
  public final Activity Y()
  {
    if ((y() instanceof com.tencent.luggage.wxa.or.n)) {
      return ((com.tencent.luggage.wxa.or.n)y()).u();
    }
    return com.tencent.luggage.wxa.rc.a.a(getContext());
  }
  
  public final am Z()
  {
    am localam = b(getContext());
    this.q = localam;
    return localam;
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return null;
  }
  
  protected bf a(be parambe)
  {
    return U();
  }
  
  public void a(double paramDouble)
  {
    a(new u.8(this, paramDouble));
  }
  
  void a(@Dimension int paramInt)
  {
    if (this.J) {
      return;
    }
    if ((this.b_.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.b_.getLayoutParams();
      if (localMarginLayoutParams.bottomMargin != paramInt)
      {
        localMarginLayoutParams.bottomMargin = paramInt;
        this.b_.setLayoutParams(localMarginLayoutParams);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = ae().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.luggage.wxa.nu.a locala = (com.tencent.luggage.wxa.nu.a)localIterator.next();
      if ((locala != null) && (locala.c() == paramInt)) {
        locala.a(paramBoolean);
      }
    }
  }
  
  @CallSuper
  protected void a(Context paramContext)
  {
    this.i = paramContext;
    com.tencent.mm.plugin.appbrand.widget.actionbar.d locald = this.b_;
    if (locald != null) {
      locald.a(paramContext);
    }
  }
  
  public void a(Context paramContext, com.tencent.luggage.wxa.iu.d paramd)
  {
    this.i = paramContext;
    this.j = paramd;
    this.s = true;
    this.e = aP();
    a(paramd.W());
    a(paramd.at());
    super.E();
    a();
    paramd.aV().a(this);
    k();
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (S() != null) {
      S().a(paramConfiguration);
    }
  }
  
  public void a(com.tencent.luggage.wxa.oq.c paramc)
  {
    this.C = paramc;
    if ((this.C != null) && (this.w != null))
    {
      this.w = null;
      af();
    }
  }
  
  final void a(bf parambf)
  {
    this.B = parambf;
  }
  
  final void a(@NonNull m paramm)
  {
    this.z = paramm;
  }
  
  public final void a(String paramString1, String paramString2, int paramInt)
  {
    if (S() != null)
    {
      if (S().a(paramString1, paramString2, paramInt)) {
        return;
      }
      super.a(paramString1, paramString2, paramInt);
      return;
    }
    a(this, paramString1, paramString2, paramInt);
  }
  
  public void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if ((this.j != null) && (this.j.ae() != null))
    {
      if ((S() != null) && (S().a(paramString1, paramString2, paramArrayOfInt))) {
        return;
      }
      this.j.ae().a(paramString1, paramString2, getComponentId());
      return;
    }
    o.b("MicroMsg.AppBrandPageView", "publish runtime destroyed, event %s", new Object[] { paramString1 });
  }
  
  protected void a(@NonNull List<com.tencent.luggage.wxa.nu.a> paramList)
  {
    new n(this, new LinkedList(ae()), false).a();
  }
  
  public void a(@NonNull Map<String, Object> paramMap, bg parambg)
  {
    if (this.G) {
      paramMap.put("notFound", Boolean.valueOf(true));
    }
    w localw = S();
    if (localw != null) {
      localw.a(paramMap, parambg);
    }
  }
  
  protected boolean a(View paramView, Runnable paramRunnable)
  {
    return false;
  }
  
  protected boolean a(View paramView, Runnable paramRunnable, long paramLong)
  {
    return false;
  }
  
  @CallSuper
  public boolean a(String paramString)
  {
    if (this.F == null) {
      this.F = af.b(paramString);
    }
    this.k = com.tencent.luggage.util.m.b(paramString);
    this.l = paramString;
    this.q.setXWebKeyboardImpl(new u.4(this));
    if (S() != null) {
      return S().a(paramString);
    }
    n();
    if (!z().d(this.k))
    {
      b(paramString);
      f("onPageScriptNotFound");
      return false;
    }
    return true;
  }
  
  @CallSuper
  @UiThread
  protected void aA()
  {
    this.s = false;
  }
  
  @AnyThread
  public void aB()
  {
    a(new u.6(this));
  }
  
  @AnyThread
  public void aC()
  {
    a(new u.7(this));
  }
  
  public String aD()
  {
    Object localObject = ah();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject).getMainTitle();
    }
    if (localObject != null) {
      return ((CharSequence)localObject).toString();
    }
    return "";
  }
  
  public void aE()
  {
    d(new u.16(this));
  }
  
  public final String aF()
  {
    com.tencent.luggage.wxa.oi.d locald = (com.tencent.luggage.wxa.oi.d)d(com.tencent.luggage.wxa.oi.d.class);
    if (locald != null) {
      return locald.b();
    }
    return null;
  }
  
  final boolean aG()
  {
    com.tencent.luggage.wxa.oi.d locald = (com.tencent.luggage.wxa.oi.d)d(com.tencent.luggage.wxa.oi.d.class);
    return (locald != null) && (locald.a());
  }
  
  public final e.a aH()
  {
    return this.v;
  }
  
  public View aI()
  {
    return null;
  }
  
  @UiThread
  public Bitmap aJ()
  {
    if (aj() == null) {
      return null;
    }
    Bitmap localBitmap = bj.a(aj().getWrapperView());
    if (localBitmap != null) {
      bj.a(aa(), new Canvas(localBitmap));
    }
    return localBitmap;
  }
  
  public final void aK()
  {
    this.D = true;
  }
  
  public final boolean aL()
  {
    return this.D;
  }
  
  public void aM()
  {
    b localb = this.e;
    if (localb == null) {
      return;
    }
    this.d.setNavResetStyleListener(localb);
    this.d.setNavHidden(false);
    if (this.e.a) {
      aO();
    }
  }
  
  public void aN()
  {
    b localb = this.e;
    if (localb != null) {
      localb.a = true;
    }
  }
  
  public void aO()
  {
    if (this.e != null)
    {
      this.d.setNavHidden(true);
      aN();
    }
  }
  
  protected b aP()
  {
    junit.framework.a.a(t.a());
    return new b(this);
  }
  
  public final ViewGroup aa()
  {
    return ab().getContainer();
  }
  
  public final aq ab()
  {
    return this.p;
  }
  
  @Nullable
  public ae ac()
  {
    if ((getContext() instanceof ae)) {
      return (ae)getContext();
    }
    return null;
  }
  
  protected void ad()
  {
    com.tencent.luggage.wxa.iu.c.a(getAppId(), c.d.a);
    this.j.y();
  }
  
  public final List<com.tencent.luggage.wxa.nu.a> ae()
  {
    if (this.x == null) {
      this.x = s();
    }
    return this.x;
  }
  
  public final com.tencent.luggage.wxa.oq.d af()
  {
    com.tencent.luggage.wxa.oq.d locald = this.w;
    if (locald != null) {
      return locald;
    }
    if (y() == null)
    {
      o.c("MicroMsg.AppBrandPageView", "getFullscreenImpl NULL windowAndroid, appId[%s] url[%s]", new Object[] { getAppId(), an() });
      return null;
    }
    this.w = y().a(new u.2(this));
    this.w.a(new u.3(this));
    return this.w;
  }
  
  public final FrameLayout ag()
  {
    return this.n;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.b ah()
  {
    return this.d;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.d ai()
  {
    return this.b_;
  }
  
  public final am aj()
  {
    return this.q;
  }
  
  public final ab ak()
  {
    return this.o;
  }
  
  public final ab al()
  {
    return q().aU();
  }
  
  public final a.d am()
  {
    if (!d()) {
      return null;
    }
    return q().aj().a(an());
  }
  
  public final String an()
  {
    return this.k;
  }
  
  public final String ao()
  {
    return this.l;
  }
  
  final boolean ap()
  {
    return this.G;
  }
  
  public com.tencent.luggage.wxa.nj.a aq()
  {
    if (this.r != null)
    {
      o.e("MicroMsg.AppBrandPageView", "return keyBoardComponentView(AppBrandKeyBoardComponentView)");
      return this.r;
    }
    this.r = new com.tencent.luggage.wxa.nj.a(getContext(), this);
    o.e("MicroMsg.AppBrandPageView", "make new keyBoardComponentView(AppBrandKeyBoardComponentView)");
    return this.r;
  }
  
  public void ar()
  {
    com.tencent.luggage.wxa.nj.a locala = this.r;
    if (locala != null)
    {
      locala.a();
      this.r = null;
    }
  }
  
  public final void as()
  {
    this.b_.setActuallyVisible(true);
  }
  
  @UiThread
  protected void at() {}
  
  @UiThread
  public final void au()
  {
    a(q().W());
    this.u = true;
    if (S() != null) {
      S().f();
    }
    av();
    J();
  }
  
  @UiThread
  protected void av() {}
  
  @UiThread
  public final void aw()
  {
    this.u = false;
    if (S() != null) {
      S().g();
    }
    ax();
    G();
  }
  
  @UiThread
  protected void ax() {}
  
  @UiThread
  public boolean ay()
  {
    if (this.w.c()) {
      return true;
    }
    if ((S() != null) && (S().i())) {
      return true;
    }
    return B();
  }
  
  @UiThread
  public final void az()
  {
    aA();
    if (S() != null) {
      S().h();
    }
    I();
  }
  
  public void b(int paramInt)
  {
    a(new u.9(this, paramInt));
  }
  
  protected void b(String paramString) {}
  
  public void b(boolean paramBoolean)
  {
    a(new u.15(this, paramBoolean));
  }
  
  public void c(int paramInt)
  {
    a(new u.13(this, paramInt));
  }
  
  public com.tencent.luggage.wxa.nu.a d(int paramInt)
  {
    Iterator localIterator = ae().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.luggage.wxa.nu.a locala = (com.tencent.luggage.wxa.nu.a)localIterator.next();
      if ((locala != null) && (locala.c() == paramInt)) {
        return locala;
      }
    }
    return null;
  }
  
  public final <T> T d(Class<T> paramClass)
  {
    if (S() != null) {
      return S().a(paramClass);
    }
    return null;
  }
  
  public boolean d()
  {
    return (this.s) && (super.d());
  }
  
  public ab e(boolean paramBoolean)
  {
    if (paramBoolean) {
      return al();
    }
    return ak();
  }
  
  protected boolean e(String paramString)
  {
    if (ap())
    {
      int i1 = getComponentId();
      f();
      int i2 = getComponentId();
      a("webviewIdChanged", String.format(Locale.ENGLISH, "{webviewId: %d}", new Object[] { Integer.valueOf(i2) }), 0);
      o.d("MicroMsg.AppBrandPageView", "rewriteRoute --START-- appId:%s, url[%s]->[%s], componentId[%d]->[%d]", new Object[] { getAppId(), an(), paramString, Integer.valueOf(i1), Integer.valueOf(i2) });
      f(false);
      T().c(paramString);
      T().a(bg.e, null);
      T().o();
      o.d("MicroMsg.AppBrandPageView", "rewriteRoute --END-- appId:%s, rewrittenURL:%s, rewrittenComponentId:%d", new Object[] { getAppId(), paramString, Integer.valueOf(getComponentId()) });
      return true;
    }
    o.c("MicroMsg.AppBrandPageView", "rewriteRoute condition mismatch, appId:%s, currentURL:%s, rewrittenURL:%s", new Object[] { getAppId(), an(), paramString });
    return false;
  }
  
  @AnyThread
  public final void f(String paramString)
  {
    boolean bool = this.I.getAndSet(true);
    o.d("MicroMsg.AppBrandPageView", "onInitReady appId:%s, url:%s, reason:%s, called:%b", new Object[] { getAppId(), an(), paramString, Boolean.valueOf(bool) });
    if (bool) {
      return;
    }
    a(new u.5(this));
  }
  
  protected final void f(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }
  
  public final Map<String, com.tencent.luggage.wxa.jx.m> g()
  {
    if (S() != null) {
      return S().j();
    }
    return null;
  }
  
  public void g(String paramString)
  {
    a(new u.10(this, paramString));
  }
  
  public void g(boolean paramBoolean)
  {
    a(new u.14(this, paramBoolean));
  }
  
  public final int getComponentId()
  {
    int[] arrayOfInt = this.H;
    if ((arrayOfInt == null) || (arrayOfInt.length <= 0)) {
      this.H = new int[] { Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Long.valueOf(System.currentTimeMillis()) }) };
    }
    return this.H[0];
  }
  
  public final View getContentView()
  {
    return this.m;
  }
  
  public void h(String paramString)
  {
    d(new u.17(this, paramString));
  }
  
  protected void h(boolean paramBoolean)
  {
    this.J = paramBoolean;
    ViewGroup.LayoutParams localLayoutParams1 = this.b_.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams2 = this.n.getLayoutParams();
    if (((localLayoutParams1 instanceof RelativeLayout.LayoutParams)) && ((localLayoutParams2 instanceof RelativeLayout.LayoutParams)))
    {
      ((RelativeLayout.LayoutParams)localLayoutParams1).addRule(10);
      if (paramBoolean) {
        ((RelativeLayout.LayoutParams)localLayoutParams2).removeRule(3);
      } else {
        ((RelativeLayout.LayoutParams)localLayoutParams2).addRule(3, c);
      }
      this.m.requestLayout();
      this.d.setFullscreenMode(this.J);
      return;
    }
    if (!L()) {
      return;
    }
    throw new IllegalStateException("ActionBarContainer and Renderer's PageArea should be in RelativeLayout");
  }
  
  public final void i(String paramString)
  {
    if ("dark".equalsIgnoreCase(paramString))
    {
      this.v = e.a.a;
      return;
    }
    this.v = e.a.b;
  }
  
  public void i(boolean paramBoolean)
  {
    if (S() != null)
    {
      f localf = (f)S().a(f.class);
      if (localf != null) {
        localf.b(paramBoolean);
      }
    }
  }
  
  protected void j()
  {
    this.q.destroy();
    if (ak() != null) {
      ak().f();
    }
    if (ah() != null) {
      ah().a();
    }
    Object localObject = this.m;
    if (localObject != null) {
      ((ViewGroup)localObject).removeAllViewsInLayout();
    }
    localObject = this.b_;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.appbrand.widget.actionbar.d)localObject).setActuallyVisible(false);
      this.b_.removeAllViewsInLayout();
    }
    localObject = this.n;
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViewsInLayout();
    }
    X().a();
    if (q() != null) {
      q().ao().b(this.E);
    }
    this.q = null;
    this.o = null;
    this.m = null;
    this.b_ = null;
    this.n = null;
    this.d = null;
    this.e = null;
    ar();
  }
  
  public final void l()
  {
    super.l();
    j();
    Q();
  }
  
  public boolean m()
  {
    return false;
  }
  
  public void n()
  {
    a.d locald = am();
    locald.getClass();
    locald = (a.d)locald;
    g(locald.a);
    locald.getClass();
    a(1.0D);
    b(a(locald));
    j(locald.b);
    h(locald.a());
    a(locald.j);
    b(locald.l, locald.h);
    b(locald.g ^ true);
    if (aL()) {
      ah().setNavHidden(true);
    }
  }
  
  public com.tencent.luggage.wxa.iu.h p()
  {
    if (q() == null) {
      return null;
    }
    return q().ae();
  }
  
  public com.tencent.luggage.wxa.iu.d q()
  {
    return this.j;
  }
  
  protected final void r_()
  {
    super.r_();
    if (S() != null) {
      S().l();
    }
  }
  
  @Nullable
  public List<com.tencent.luggage.wxa.nu.a> s()
  {
    return Collections.emptyList();
  }
  
  @Nullable
  public View t()
  {
    return null;
  }
  
  public boolean v()
  {
    e.b localb1 = e.b.c;
    e.b localb2 = e.b.d;
    e.b localb3 = e.b.e;
    e.b localb4 = e.b.f;
    e.b localb5 = y().getOrientationHandler().a();
    return ArrayUtils.contains(new e.b[] { localb1, localb2, localb3, localb4 }, localb5);
  }
  
  public com.tencent.luggage.wxa.oq.c y()
  {
    return this.C;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u
 * JD-Core Version:    0.7.0.1
 */