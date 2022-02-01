package com.tencent.luggage.wxa.iu;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.AnyThread;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.luggage.wxa.jx.j;
import com.tencent.luggage.wxa.ny.a.c;
import com.tencent.luggage.wxa.pd.i;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.plugin.appbrand.page.be;
import com.tencent.mm.plugin.appbrand.page.bf;
import com.tencent.mm.plugin.appbrand.page.m;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingDeque;
import org.jetbrains.annotations.NotNull;
import org.joor.Reflect;

public class d
  implements i<com.tencent.luggage.wxa.rm.a>
{
  private com.tencent.luggage.wxa.ny.a A;
  private volatile boolean B;
  private volatile boolean C;
  private volatile boolean D;
  private boolean E = false;
  private boolean F;
  private boolean G;
  private boolean H;
  private boolean I;
  private s J;
  private boolean K = false;
  private boolean L = true;
  private boolean M;
  private long N = 0L;
  private long O = 0L;
  @Nullable
  private com.tencent.luggage.wxa.op.f P;
  private com.tencent.mm.plugin.appbrand.widget.e Q;
  private com.tencent.mm.plugin.appbrand.widget.d R;
  private com.tencent.mm.plugin.appbrand.page.e S;
  private boolean T = false;
  private LinkedList<d.b> U = new LinkedList();
  private ConcurrentLinkedQueue<d.b> V = null;
  private AppBrandMainProcessService.a W = new d.10(this);
  private final com.tencent.luggage.wxa.qz.v X = new com.tencent.luggage.wxa.qz.v(Looper.getMainLooper(), new d.12(this), false);
  private final Deque<Runnable> Y = new LinkedBlockingDeque();
  private SparseArray<Set<p>> Z = new SparseArray();
  Context a;
  com.tencent.mm.plugin.appbrand.widget.f b;
  @Nullable
  private n c;
  private com.tencent.luggage.wxa.oq.c d;
  private final com.tencent.luggage.wxa.qz.s e;
  private final aa f;
  private volatile String g;
  private d h;
  private volatile com.tencent.luggage.wxa.jj.h i;
  private volatile h j;
  private volatile com.tencent.mm.plugin.appbrand.page.o k;
  private com.tencent.mm.plugin.appbrand.ui.d l;
  private com.tencent.mm.plugin.appbrand.widget.dialog.d m;
  private com.tencent.mm.plugin.appbrand.widget.dialog.d n;
  private com.tencent.luggage.wxa.iv.c o;
  private com.tencent.mm.plugin.appbrand.page.capsulebar.e p;
  private volatile Boolean q = null;
  private volatile com.tencent.mm.plugin.appbrand.appstorage.o r = null;
  @TargetApi(21)
  private final ConcurrentLinkedDeque<j> s = new d.1(this);
  private final v t = new v();
  private final ConcurrentSkipListSet<t> u = new ConcurrentSkipListSet(new d.11(this));
  private final w v = new w();
  private final LinkedHashSet<com.tencent.luggage.wxa.jx.k> w = new LinkedHashSet();
  private final k x = new k();
  private com.tencent.luggage.wxa.pd.c y;
  private volatile com.tencent.luggage.wxa.ix.c z;
  
  private d(@NonNull Context paramContext)
  {
    this.a = paramContext;
    this.e = new com.tencent.luggage.wxa.qz.s(Looper.getMainLooper());
    this.f = new aa();
    this.b = a(paramContext);
    this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.m = new com.tencent.mm.plugin.appbrand.widget.dialog.d(this.a);
    this.n = new com.tencent.mm.plugin.appbrand.widget.dialog.d(this.a);
    this.y = new com.tencent.luggage.wxa.pd.c();
    this.M = false;
  }
  
  public d(@NonNull n paramn)
  {
    this(paramn.getContext());
    this.c = paramn;
    this.d = null;
  }
  
  protected d(@NonNull com.tencent.luggage.wxa.oq.c paramc)
  {
    this(paramc.getContext());
    this.c = null;
    this.d = paramc;
  }
  
  private void a()
  {
    ConcurrentLinkedQueue localConcurrentLinkedQueue = this.V;
    this.V = null;
    if ((localConcurrentLinkedQueue != null) && (!localConcurrentLinkedQueue.isEmpty()))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "cancelAllPrepareProcesses size[%d] appId[%s]", new Object[] { Integer.valueOf(localConcurrentLinkedQueue.size()), aa() });
      while (!localConcurrentLinkedQueue.isEmpty()) {
        ((d.b)localConcurrentLinkedQueue.poll()).a();
      }
      return;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "cancelAllPrepareProcesses empty list appId[%s]", new Object[] { aa() });
  }
  
  private void a(d.a parama)
  {
    ConcurrentLinkedQueue localConcurrentLinkedQueue = new ConcurrentLinkedQueue(this.U);
    this.V = localConcurrentLinkedQueue;
    this.U = new LinkedList();
    Iterator localIterator = localConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      d.b localb = (d.b)localIterator.next();
      d.b.a(localb, new d.20(this, localConcurrentLinkedQueue, localb, af.b(), parama));
      localb.b();
    }
  }
  
  @UiThread
  private void b()
  {
    if (au()) {
      return;
    }
    if (this.B)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandRuntime", "initRuntime, mInitialized TRUE !!!  go check callee %s", new Object[] { af.a(new Throwable()) });
      return;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "initRuntime %s", new Object[] { aa() });
    new d.3(this).run();
  }
  
  private void b(@Nullable Configuration paramConfiguration)
  {
    if (this.k == null) {
      return;
    }
    Object localObject = this.k.getCurrentPage();
    if (localObject == null) {
      return;
    }
    localObject = ((m)localObject).getCurrentPageView().ai();
    if ((this.Q != null) && (localObject != null))
    {
      int i1 = ((View)localObject).getHeight();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("adjustPipContainerViewPositionRange, actionBarContainerHeight: ");
      ((StringBuilder)localObject).append(i1);
      com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandRuntime", ((StringBuilder)localObject).toString());
      this.Q.a(i1, paramConfiguration);
    }
  }
  
  private boolean b(com.tencent.luggage.wxa.jj.h paramh)
  {
    if (paramh == null) {
      return false;
    }
    if (this.I)
    {
      this.I = false;
      return true;
    }
    return paramh.G != this.i.G;
  }
  
  private void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(aa());
    localStringBuilder.append(":performInitPageContainer");
    com.tencent.luggage.wxa.ef.d.a(localStringBuilder.toString(), new d.4(this));
  }
  
  private void g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(aa());
    localStringBuilder.append(":performInitService");
    com.tencent.luggage.wxa.ef.d.a(localStringBuilder.toString(), new d.5(this));
  }
  
  @MainThread
  private void i()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| initRuntimeImpl appId:%s", new Object[] { aa() });
    this.O = af.b();
    an();
    n();
    this.j = I();
    this.j.a(this);
    this.A = v();
    this.R = new com.tencent.mm.plugin.appbrand.widget.d(this.a);
    this.S = new com.tencent.mm.plugin.appbrand.page.e(this.R);
    z.d.a(this, this.R);
    this.p = new com.tencent.mm.plugin.appbrand.page.capsulebar.e(this);
    this.p.a();
    boolean bool = F();
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| initRuntimeImpl appId:%s, initServiceBeforePage:%b", new Object[] { aa(), Boolean.valueOf(bool) });
    if (bool)
    {
      g();
      f();
    }
    else
    {
      f();
      g();
    }
    long l1 = af.b();
    this.P = new com.tencent.luggage.wxa.op.f(this.a, this);
    this.Q = this.P.a();
    z.b.a(this, this.Q);
    ViewGroup.LayoutParams localLayoutParams = this.Q.getLayoutParams();
    localLayoutParams.width = com.tencent.mm.plugin.appbrand.widget.e.a;
    localLayoutParams.height = com.tencent.mm.plugin.appbrand.widget.e.b;
    this.Q.setLayoutParams(localLayoutParams);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| appId:%s, install pip, cost %d", new Object[] { aa(), Long.valueOf(af.b() - l1) });
    z.c.a(this, this.m);
    this.m.setShouldBringSelfToFrontWhenDialogShown(false);
    z.f.a(this, this.n);
    this.n.setShouldBringSelfToFrontWhenDialogShown(false);
    this.y.a(this.j);
    aO();
    c();
  }
  
  private void j()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "appOnCreate: %s, %s", new Object[] { this.i.E, this.i.D });
    AppBrandMainProcessService.a(this.W);
    a(com.tencent.luggage.wxa.kd.g.class, new l());
    a(com.tencent.luggage.wxa.ob.e.class, new com.tencent.luggage.wxa.ob.g(this));
    a(com.tencent.luggage.wxa.jl.b.class, new com.tencent.luggage.wxa.np.e(this));
    a(com.tencent.luggage.wxa.jl.a.class, new com.tencent.luggage.wxa.np.d(this));
    d();
    com.tencent.luggage.wxa.nq.a.a(aa());
    this.z.f();
    c.h(this.g);
    c.a(this.g);
    c.a(this.g, c.b.b);
    aO();
  }
  
  private void k()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile|appId:%s, launch -> ready, cost %d", new Object[] { aa(), Long.valueOf(af.b() - this.N) });
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile|appId:%s, initRuntimeImpl -> ready, cost %d", new Object[] { aa(), Long.valueOf(af.b() - this.O) });
    c(new d.6(this));
  }
  
  private void l()
  {
    this.G = false;
    this.H = false;
  }
  
  private void p()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "onServiceReconnected: %s", new Object[] { this.g });
    if (this.B)
    {
      N();
      c.f(this.g);
      return;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandRuntime", "Main Process Restarted, start prepare again");
    a(null, "performServiceReconnected");
  }
  
  private void q()
  {
    this.k.a(as(), true);
  }
  
  private void r()
  {
    this.X.a(10000L);
  }
  
  private void s()
  {
    this.X.c();
  }
  
  private void t()
  {
    while (!this.Y.isEmpty()) {
      d((Runnable)this.Y.removeFirst());
    }
  }
  
  public com.tencent.luggage.wxa.jj.l A()
  {
    return (com.tencent.luggage.wxa.jj.l)b(com.tencent.luggage.wxa.jj.l.class);
  }
  
  public com.tencent.luggage.wxa.jj.h B()
  {
    return this.i;
  }
  
  public com.tencent.mm.plugin.appbrand.page.o C()
  {
    return this.k;
  }
  
  @AnyThread
  public void E()
  {
    if (au())
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandRuntime", "finish but destroyed, appId[%s]", new Object[] { aa() });
      return;
    }
    this.C = true;
    com.tencent.luggage.util.h.a(ah());
    d(new d.7(this));
  }
  
  public boolean F()
  {
    return false;
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.d H()
  {
    return null;
  }
  
  protected h I()
  {
    return new h();
  }
  
  protected com.tencent.mm.plugin.appbrand.page.o J()
  {
    return new com.tencent.mm.plugin.appbrand.page.o(ah(), this);
  }
  
  protected void N() {}
  
  protected void P()
  {
    ax().a();
  }
  
  public void Q()
  {
    if (au())
    {
      locald = this.l;
      if (locald != null) {
        com.tencent.mm.plugin.appbrand.ui.a.a(locald);
      }
      this.l = null;
      return;
    }
    com.tencent.mm.plugin.appbrand.ui.d locald = this.l;
    if (locald == null) {
      return;
    }
    com.tencent.luggage.wxa.qz.o.h("MicroMsg.AppBrandRuntime", "hideSplash[AppBrandSplashAd], splash:%s", new Object[] { locald.getClass().getSimpleName() });
    locald = this.l;
    if ((locald instanceof com.tencent.mm.plugin.appbrand.ui.e))
    {
      ((com.tencent.mm.plugin.appbrand.ui.e)locald).a();
      return;
    }
    locald.b(new d.22(this));
  }
  
  protected void T() {}
  
  @Nullable
  public bf U()
  {
    return null;
  }
  
  protected void V()
  {
    if (this.l == null)
    {
      if (this.n.b()) {
        return;
      }
      if (this.m.b()) {
        return;
      }
      if (this.k != null) {
        this.k.n();
      }
    }
    else
    {
      c.a(aa(), c.d.b);
      E();
    }
  }
  
  @NonNull
  public com.tencent.luggage.wxa.oq.c W()
  {
    if (af() == null)
    {
      String str = aa();
      Object localObject = this.d;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = localObject.getClass().getName();
      }
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandRuntime", "getWindowAndroid getRuntimeContainer is NULL appId[%s], return default %s", new Object[] { str, localObject });
      localObject = this.d;
      if (localObject != null) {
        return localObject;
      }
      localObject = new com.tencent.luggage.wxa.or.n();
      this.d = ((com.tencent.luggage.wxa.oq.c)localObject);
      return localObject;
    }
    return af().getWindowAndroid();
  }
  
  public final boolean X()
  {
    return this.T;
  }
  
  public final void Y()
  {
    try
    {
      if (!this.D)
      {
        this.D = true;
        this.E = true;
        long l1 = af.b();
        this.N = l1;
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch start appId:%s", new Object[] { aa() });
        T();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AppBrandRuntimeProfile| onCreatePrivate");
        localStringBuilder.append(aa());
        com.tencent.luggage.wxa.ef.d.a(localStringBuilder.toString(), new d.17(this));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("AppBrandRuntimeProfile| prepare(AllDoneInitNotify)");
        localStringBuilder.append(aa());
        com.tencent.luggage.wxa.ef.d.a(localStringBuilder.toString(), new d.18(this));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("AppBrandRuntimeProfile| showSplash ");
        localStringBuilder.append(aa());
        com.tencent.luggage.wxa.ef.d.a(localStringBuilder.toString(), new d.19(this));
        r();
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch end appId:%s, cost:%dms", new Object[] { aa(), Long.valueOf(af.b() - l1) });
        return;
      }
      throw new RuntimeException("Already invoked launch()");
    }
    finally {}
  }
  
  public final boolean Z()
  {
    try
    {
      boolean bool = this.D;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected <T extends com.tencent.luggage.wxa.hw.a> T a(Class<T> paramClass)
  {
    return null;
  }
  
  @Nullable
  public <T extends j> T a(@NonNull Class<T> paramClass, boolean paramBoolean)
  {
    Object localObject2 = this.s.descendingIterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (j)((Iterator)localObject2).next();
      if (paramClass.isInstance(localObject1)) {
        break label43;
      }
    }
    Object localObject1 = null;
    label43:
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (!paramBoolean) {}
    }
    try
    {
      localObject2 = (j)Reflect.on(paramClass).create().get();
      if (localObject2 == null) {}
    }
    catch (Exception localException2)
    {
      label92:
      label101:
      break label101;
    }
    try
    {
      at().add(localObject2);
    }
    catch (Exception localException1)
    {
      break label92;
    }
    localObject1 = localObject2;
    break label101;
    return localObject2;
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandRuntime", "Make sure %s has default constructor", new Object[] { paramClass.getName() });
    localObject2 = localObject1;
    return localObject2;
  }
  
  @Nullable
  public bf a(be parambe)
  {
    return U();
  }
  
  @NotNull
  protected com.tencent.mm.plugin.appbrand.widget.f a(Context paramContext)
  {
    if (com.tencent.luggage.wxa.pd.w.a(paramContext)) {
      return new com.tencent.mm.plugin.appbrand.widget.c(paramContext);
    }
    return new com.tencent.mm.plugin.appbrand.widget.f(paramContext);
  }
  
  public void a(int paramInt1, int paramInt2, p paramp)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "addKeyEventObserver");
    d(new d.14(this, paramp, paramInt2, paramInt1));
  }
  
  @CallSuper
  protected void a(Configuration paramConfiguration)
  {
    Looper.myQueue().addIdleHandler(new d.2(this, paramConfiguration));
    com.tencent.luggage.wxa.op.f localf = this.P;
    if (localf != null) {
      localf.a(paramConfiguration);
    }
  }
  
  public final void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    z.e.a(this, paramView);
  }
  
  public final void a(d.b paramb)
  {
    this.U.add(paramb);
  }
  
  void a(d paramd)
  {
    this.h = paramd;
  }
  
  @CallSuper
  public void a(@Nullable n paramn)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "setRuntimeContainer appId:%s, container:%s", new Object[] { aa(), paramn });
    this.c = paramn;
    paramn = this.c;
    if (paramn != null)
    {
      this.t.a(paramn);
      return;
    }
    this.t.a();
  }
  
  public void a(p paramp)
  {
    d(new d.15(this, paramp));
  }
  
  protected final void a(com.tencent.luggage.wxa.jj.a parama)
  {
    at().add(parama);
  }
  
  protected void a(com.tencent.luggage.wxa.jj.h paramh, Object paramObject) {}
  
  @CallSuper
  @UiThread
  protected void a(@Nullable com.tencent.luggage.wxa.jj.h paramh, String paramString)
  {
    if (!aQ())
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "reload but !isResumed, destroy and update config, appId:%s, reason:%s", new Object[] { aa(), paramString });
      aC();
      if (paramh != null) {
        this.i = paramh;
      }
      return;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "reload --START-- appId:%s, reason:%s stacktrace=%s", new Object[] { aa(), paramString, Log.getStackTraceString(new Throwable()) });
    aC();
    if (paramh == null) {
      paramh = B();
    }
    c(paramh);
    Y();
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "reload --END-- appId:%s", new Object[] { aa() });
  }
  
  public final <T extends j> void a(T paramT)
  {
    at().add(paramT);
  }
  
  public void a(com.tencent.luggage.wxa.rm.a parama)
  {
    this.f.a(parama);
  }
  
  public final <T extends com.tencent.luggage.wxa.hw.a, N extends T> void a(Class<T> paramClass, N paramN)
  {
    this.x.a(paramClass, paramN);
  }
  
  public final void a(@Nullable Object paramObject)
  {
    d(new d.9(this, paramObject));
  }
  
  public final void a(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return;
    }
    if (au())
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandRuntime", "scheduleToUiThreadDelayed() but finished, stackTrace = %s", new Object[] { Log.getStackTraceString(new Throwable()) });
      return;
    }
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = 0L;
    }
    if ((com.tencent.luggage.wxa.qz.t.a()) && (0L == l1))
    {
      paramRunnable.run();
      return;
    }
    paramRunnable = com.tencent.luggage.wxa.pd.n.a(this.f, paramRunnable);
    a(paramRunnable);
    this.e.b(paramRunnable, l1);
  }
  
  protected final void a(String paramString)
  {
    Object localObject = this.V;
    Iterator localIterator;
    if ((localObject != null) && (((Collection)localObject).size() > 0)) {
      localIterator = ((Collection)localObject).iterator();
    }
    while (localIterator.hasNext())
    {
      d.b localb = (d.b)localIterator.next();
      String str = localb.c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = localb.toString();
      }
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, process[%s]", new Object[] { paramString, localObject });
      continue;
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, no pending processes", new Object[] { paramString });
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = (Set)this.Z.get(paramInt);
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localp = (p)((Iterator)localObject).next();
      if ((localp.c == -1) || (localp.c == paramKeyEvent.getAction())) {
        bool |= localp.a(paramKeyEvent);
      }
    }
    return bool;
  }
  
  @CallSuper
  protected boolean a(com.tencent.luggage.wxa.jj.h paramh)
  {
    this.i = paramh;
    return true;
  }
  
  public boolean a(com.tencent.luggage.wxa.jx.k paramk)
  {
    if (paramk == null) {
      return false;
    }
    synchronized (this.w)
    {
      this.w.add(paramk);
      return true;
    }
  }
  
  protected boolean a(Runnable paramRunnable)
  {
    return false;
  }
  
  protected final void aA()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "dispatchResume appId:%s, initialized:%b", new Object[] { aa(), Boolean.valueOf(aw()) });
    if (!aw()) {
      return;
    }
    if ((!au()) && (!this.G))
    {
      this.E = true;
      c.h(this.g);
      c.e(this.g);
      c.a(this.g, c.b.c);
      boolean bool = this.H;
      this.k.c();
      this.z.e();
      this.j.a(bool);
      e();
      if (bool) {
        q();
      }
      this.y.a();
      aO();
      l();
      return;
    }
    this.E = true;
    aE();
  }
  
  protected void aB() {}
  
  /* Error */
  protected final void aC()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 360	com/tencent/luggage/wxa/iu/d:au	()Z
    //   4: istore_1
    //   5: ldc_w 282
    //   8: ldc_w 1034
    //   11: iconst_3
    //   12: anewarray 5	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokevirtual 298	com/tencent/luggage/wxa/iu/d:aa	()Ljava/lang/String;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: iload_1
    //   25: invokestatic 523	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   28: aastore
    //   29: dup
    //   30: iconst_2
    //   31: aload_0
    //   32: invokevirtual 1013	com/tencent/luggage/wxa/iu/d:aw	()Z
    //   35: invokestatic 523	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   38: aastore
    //   39: invokestatic 303	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: iload_1
    //   43: ifeq +4 -> 47
    //   46: return
    //   47: aload_0
    //   48: monitorenter
    //   49: aload_0
    //   50: iconst_1
    //   51: putfield 1036	com/tencent/luggage/wxa/iu/d:F	Z
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield 789	com/tencent/luggage/wxa/iu/d:D	Z
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_0
    //   62: invokevirtual 1038	com/tencent/luggage/wxa/iu/d:o	()V
    //   65: aload_0
    //   66: getfield 218	com/tencent/luggage/wxa/iu/d:f	Lcom/tencent/luggage/wxa/iu/aa;
    //   69: invokevirtual 1039	com/tencent/luggage/wxa/iu/aa:a	()V
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 117	com/tencent/luggage/wxa/iu/d:r	Lcom/tencent/mm/plugin/appbrand/appstorage/o;
    //   77: aload_0
    //   78: invokevirtual 298	com/tencent/luggage/wxa/iu/d:aa	()Ljava/lang/String;
    //   81: invokestatic 1041	com/tencent/luggage/wxa/nq/a:b	(Ljava/lang/String;)V
    //   84: aload_0
    //   85: getfield 178	com/tencent/luggage/wxa/iu/d:W	Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandMainProcessService$a;
    //   88: invokestatic 1043	com/tencent/mm/plugin/appbrand/ipc/AppBrandMainProcessService:b	(Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandMainProcessService$a;)V
    //   91: aload_0
    //   92: getfield 626	com/tencent/luggage/wxa/iu/d:g	Ljava/lang/String;
    //   95: invokestatic 1044	com/tencent/luggage/wxa/iu/c:b	(Ljava/lang/String;)V
    //   98: aload_0
    //   99: getfield 626	com/tencent/luggage/wxa/iu/d:g	Ljava/lang/String;
    //   102: getstatic 1046	com/tencent/luggage/wxa/iu/c$b:f	Lcom/tencent/luggage/wxa/iu/c$b;
    //   105: invokestatic 639	com/tencent/luggage/wxa/iu/c:a	(Ljava/lang/String;Lcom/tencent/luggage/wxa/iu/c$b;)V
    //   108: aload_0
    //   109: invokevirtual 712	com/tencent/luggage/wxa/iu/d:ah	()Landroid/app/Activity;
    //   112: invokestatic 717	com/tencent/luggage/util/h:a	(Landroid/content/Context;)Z
    //   115: pop
    //   116: aload_0
    //   117: getfield 621	com/tencent/luggage/wxa/iu/d:z	Lcom/tencent/luggage/wxa/ix/c;
    //   120: invokevirtual 1047	com/tencent/luggage/wxa/ix/c:i	()V
    //   123: aload_0
    //   124: aconst_null
    //   125: putfield 1049	com/tencent/luggage/wxa/iu/d:J	Lcom/tencent/luggage/wxa/iu/s;
    //   128: invokestatic 1054	com/tencent/luggage/wxa/nz/f:b	()Lcom/tencent/luggage/wxa/nz/f;
    //   131: aload_0
    //   132: invokevirtual 298	com/tencent/luggage/wxa/iu/d:aa	()Ljava/lang/String;
    //   135: invokevirtual 1057	com/tencent/luggage/wxa/nz/f:b	(Ljava/lang/String;)Z
    //   138: pop
    //   139: invokestatic 1062	com/tencent/luggage/wxa/nz/c:b	()Lcom/tencent/luggage/wxa/nz/c;
    //   142: aload_0
    //   143: invokevirtual 298	com/tencent/luggage/wxa/iu/d:aa	()Ljava/lang/String;
    //   146: invokevirtual 1063	com/tencent/luggage/wxa/nz/c:b	(Ljava/lang/String;)Z
    //   149: pop
    //   150: invokestatic 1068	com/tencent/luggage/wxa/nz/i:b	()Lcom/tencent/luggage/wxa/nz/i;
    //   153: aload_0
    //   154: invokevirtual 298	com/tencent/luggage/wxa/iu/d:aa	()Ljava/lang/String;
    //   157: invokevirtual 1069	com/tencent/luggage/wxa/nz/i:b	(Ljava/lang/String;)Z
    //   160: pop
    //   161: invokestatic 1074	com/tencent/luggage/wxa/nz/l:a	()Lcom/tencent/luggage/wxa/nz/l;
    //   164: aload_0
    //   165: invokevirtual 298	com/tencent/luggage/wxa/iu/d:aa	()Ljava/lang/String;
    //   168: invokevirtual 1075	com/tencent/luggage/wxa/nz/l:b	(Ljava/lang/String;)Z
    //   171: pop
    //   172: aload_0
    //   173: getfield 626	com/tencent/luggage/wxa/iu/d:g	Ljava/lang/String;
    //   176: invokestatic 1077	com/tencent/luggage/wxa/iu/c:g	(Ljava/lang/String;)V
    //   179: aload_0
    //   180: getfield 223	com/tencent/luggage/wxa/iu/d:b	Lcom/tencent/mm/plugin/appbrand/widget/f;
    //   183: aconst_null
    //   184: invokevirtual 1081	com/tencent/mm/plugin/appbrand/widget/f:setOnHierarchyChangeListener	(Landroid/view/ViewGroup$OnHierarchyChangeListener;)V
    //   187: aload_0
    //   188: getfield 223	com/tencent/luggage/wxa/iu/d:b	Lcom/tencent/mm/plugin/appbrand/widget/f;
    //   191: invokevirtual 1084	com/tencent/mm/plugin/appbrand/widget/f:removeAllViewsInLayout	()V
    //   194: aload_0
    //   195: getfield 240	com/tencent/luggage/wxa/iu/d:m	Lcom/tencent/mm/plugin/appbrand/widget/dialog/d;
    //   198: invokevirtual 1085	com/tencent/mm/plugin/appbrand/widget/dialog/d:a	()V
    //   201: aload_0
    //   202: getfield 242	com/tencent/luggage/wxa/iu/d:n	Lcom/tencent/mm/plugin/appbrand/widget/dialog/d;
    //   205: invokevirtual 1085	com/tencent/mm/plugin/appbrand/widget/dialog/d:a	()V
    //   208: aload_0
    //   209: getfield 513	com/tencent/luggage/wxa/iu/d:p	Lcom/tencent/mm/plugin/appbrand/page/capsulebar/e;
    //   212: astore_2
    //   213: aload_2
    //   214: ifnull +7 -> 221
    //   217: aload_2
    //   218: invokevirtual 1086	com/tencent/mm/plugin/appbrand/page/capsulebar/e:b	()V
    //   221: aload_0
    //   222: aconst_null
    //   223: putfield 115	com/tencent/luggage/wxa/iu/d:q	Ljava/lang/Boolean;
    //   226: aload_0
    //   227: getfield 1088	com/tencent/luggage/wxa/iu/d:o	Lcom/tencent/luggage/wxa/iv/c;
    //   230: astore_2
    //   231: aload_2
    //   232: ifnull +12 -> 244
    //   235: aload_2
    //   236: invokevirtual 1093	com/tencent/luggage/wxa/iv/c:removeAllViews	()V
    //   239: aload_0
    //   240: aconst_null
    //   241: putfield 1088	com/tencent/luggage/wxa/iu/d:o	Lcom/tencent/luggage/wxa/iv/c;
    //   244: aload_0
    //   245: getfield 356	com/tencent/luggage/wxa/iu/d:B	Z
    //   248: ifeq +27 -> 275
    //   251: aload_0
    //   252: getfield 479	com/tencent/luggage/wxa/iu/d:j	Lcom/tencent/luggage/wxa/iu/h;
    //   255: invokevirtual 1094	com/tencent/luggage/wxa/iu/h:l	()V
    //   258: aload_0
    //   259: aconst_null
    //   260: putfield 479	com/tencent/luggage/wxa/iu/d:j	Lcom/tencent/luggage/wxa/iu/h;
    //   263: aload_0
    //   264: getfield 270	com/tencent/luggage/wxa/iu/d:k	Lcom/tencent/mm/plugin/appbrand/page/o;
    //   267: invokevirtual 1095	com/tencent/mm/plugin/appbrand/page/o:i	()V
    //   270: aload_0
    //   271: aconst_null
    //   272: putfield 270	com/tencent/luggage/wxa/iu/d:k	Lcom/tencent/mm/plugin/appbrand/page/o;
    //   275: aload_0
    //   276: invokespecial 1096	com/tencent/luggage/wxa/iu/d:a	()V
    //   279: aload_0
    //   280: invokevirtual 852	com/tencent/luggage/wxa/iu/d:at	()Ljava/util/Collection;
    //   283: invokeinterface 1099 1 0
    //   288: aload_0
    //   289: getfield 149	com/tencent/luggage/wxa/iu/d:w	Ljava/util/LinkedHashSet;
    //   292: astore_2
    //   293: aload_2
    //   294: monitorenter
    //   295: aload_0
    //   296: getfield 149	com/tencent/luggage/wxa/iu/d:w	Ljava/util/LinkedHashSet;
    //   299: invokevirtual 1100	java/util/LinkedHashSet:clear	()V
    //   302: aload_2
    //   303: monitorexit
    //   304: aload_0
    //   305: invokestatic 1105	com/tencent/mm/plugin/appbrand/appcache/ad:c	(Lcom/tencent/luggage/wxa/iu/d;)Z
    //   308: pop
    //   309: aload_0
    //   310: getfield 154	com/tencent/luggage/wxa/iu/d:x	Lcom/tencent/luggage/wxa/iu/k;
    //   313: invokevirtual 1106	com/tencent/luggage/wxa/iu/k:a	()V
    //   316: aload_0
    //   317: getfield 199	com/tencent/luggage/wxa/iu/d:Y	Ljava/util/Deque;
    //   320: invokeinterface 1107 1 0
    //   325: aload_0
    //   326: getfield 213	com/tencent/luggage/wxa/iu/d:e	Lcom/tencent/luggage/wxa/qz/s;
    //   329: aconst_null
    //   330: invokevirtual 1109	com/tencent/luggage/wxa/qz/s:a	(Ljava/lang/Object;)V
    //   333: aload_0
    //   334: invokespecial 457	com/tencent/luggage/wxa/iu/d:s	()V
    //   337: aload_0
    //   338: getfield 204	com/tencent/luggage/wxa/iu/d:Z	Landroid/util/SparseArray;
    //   341: invokevirtual 1110	android/util/SparseArray:clear	()V
    //   344: aload_0
    //   345: invokestatic 1113	com/tencent/mm/plugin/appbrand/page/r:a	(Lcom/tencent/luggage/wxa/iu/d;)V
    //   348: aload_0
    //   349: getfield 139	com/tencent/luggage/wxa/iu/d:u	Ljava/util/concurrent/ConcurrentSkipListSet;
    //   352: invokevirtual 1114	java/util/concurrent/ConcurrentSkipListSet:clear	()V
    //   355: aload_0
    //   356: getfield 144	com/tencent/luggage/wxa/iu/d:v	Lcom/tencent/luggage/wxa/iu/w;
    //   359: invokevirtual 1115	com/tencent/luggage/wxa/iu/w:b	()V
    //   362: return
    //   363: astore_3
    //   364: aload_2
    //   365: monitorexit
    //   366: aload_3
    //   367: athrow
    //   368: astore_2
    //   369: aload_0
    //   370: monitorexit
    //   371: aload_2
    //   372: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	373	0	this	d
    //   4	39	1	bool	boolean
    //   368	4	2	localObject2	Object
    //   363	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   295	304	363	finally
    //   364	366	363	finally
    //   49	61	368	finally
    //   369	371	368	finally
  }
  
  public final void aD()
  {
    b(false);
    if (af() != null) {
      af().e(this);
    }
    E();
    if ((af() instanceof o)) {
      ((o)af()).g();
    }
  }
  
  @UiThread
  public final void aE()
  {
    a(null, "");
  }
  
  protected final void aF()
  {
    this.G = true;
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandRuntime", "setWillRestart");
  }
  
  protected final boolean aG()
  {
    return this.G;
  }
  
  protected final void aH()
  {
    if (aG())
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s, ignore by willRestart", new Object[] { aa() });
      return;
    }
    this.H = true;
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s", new Object[] { aa() });
  }
  
  protected final boolean aI()
  {
    return this.H;
  }
  
  public boolean aJ()
  {
    return aI();
  }
  
  public final boolean aK()
  {
    boolean bool1 = this.L;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    Activity localActivity = ah();
    if ((localActivity != null) && (localActivity.isFinishing())) {
      return false;
    }
    bool1 = bool2;
    if (this.k != null)
    {
      bool1 = bool2;
      if (this.k.getCurrentPage() != null)
      {
        bool1 = bool2;
        if (!this.k.getCurrentPage().r()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final boolean aL()
  {
    return this.K;
  }
  
  @Nullable
  public final s aM()
  {
    return this.J;
  }
  
  void aN()
  {
    this.z.g();
    c.c(aa());
  }
  
  public void aO()
  {
    e(new d.13(this));
  }
  
  public boolean aP()
  {
    int i1;
    if (this.z.a() == com.tencent.luggage.wxa.ix.b.c) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      aC();
      return true;
    }
    return false;
  }
  
  public boolean aQ()
  {
    try
    {
      boolean bool = this.E;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Nullable
  public com.tencent.luggage.wxa.op.f aR()
  {
    return this.P;
  }
  
  public boolean aS()
  {
    if (this.q == null) {
      this.q = Boolean.valueOf(((com.tencent.luggage.wxa.iv.d)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.iv.d.class)).a(this));
    }
    return this.q.booleanValue();
  }
  
  public boolean aT()
  {
    Object localObject = this.l;
    boolean bool;
    if ((localObject instanceof com.tencent.mm.plugin.appbrand.ui.e)) {
      bool = ((com.tencent.mm.plugin.appbrand.ui.e)localObject).b();
    } else {
      bool = false;
    }
    String str = aa();
    localObject = this.l;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = localObject.getClass().getSimpleName();
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "isShowingSplashAd[AppBrandSplashAd]:%s, appId:%s, splash:%s", new Object[] { Boolean.valueOf(bool), str, localObject });
    return bool;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.e aU()
  {
    return this.S;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.capsulebar.e aV()
  {
    return this.p;
  }
  
  public boolean aW()
  {
    return this.M;
  }
  
  public String aa()
  {
    return this.g;
  }
  
  public int ab()
  {
    return this.i.G;
  }
  
  public final d ac()
  {
    n localn = this.c;
    if (localn == null) {
      return null;
    }
    return localn.a(this);
  }
  
  public boolean ad()
  {
    n localn = this.c;
    return (localn != null) && (localn.b(this));
  }
  
  public h ae()
  {
    return this.j;
  }
  
  @Nullable
  public n af()
  {
    return this.c;
  }
  
  @NonNull
  public final Context ag()
  {
    return this.a;
  }
  
  @Nullable
  public final Activity ah()
  {
    return com.tencent.luggage.wxa.rc.a.a(this.a);
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.f ai()
  {
    return this.b;
  }
  
  public com.tencent.luggage.wxa.jj.a aj()
  {
    return (com.tencent.luggage.wxa.jj.a)a(com.tencent.luggage.wxa.jj.a.class, false);
  }
  
  public void ak() {}
  
  public com.tencent.luggage.wxa.ix.c al()
  {
    return this.z;
  }
  
  public com.tencent.luggage.wxa.ny.a am()
  {
    return this.A;
  }
  
  protected final void an()
  {
    if (this.r == null) {
      this.r = h();
    }
  }
  
  public com.tencent.mm.plugin.appbrand.widget.dialog.l ao()
  {
    return this.m;
  }
  
  public com.tencent.mm.plugin.appbrand.widget.dialog.l ap()
  {
    return this.n;
  }
  
  protected void aq()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      com.tencent.mm.plugin.appbrand.ui.a.a((com.tencent.mm.plugin.appbrand.ui.d)localObject);
      this.l = null;
    }
    localObject = H();
    if (localObject == null) {
      return;
    }
    ((com.tencent.mm.plugin.appbrand.ui.d)localObject).a(B().F, B().E);
    View localView = ((com.tencent.mm.plugin.appbrand.ui.d)localObject).getView();
    z.g.a(this, localView);
    this.l = ((com.tencent.mm.plugin.appbrand.ui.d)localObject);
    String str = aa();
    localObject = this.l;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = localObject.getClass().getSimpleName();
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "showSplash[AppBrandSplashAd], appId:%s, splash:%s", new Object[] { str, localObject });
    localView.setClickable(true);
    this.b.setOnHierarchyChangeListener(new d.21(this, localView));
  }
  
  protected void ar() {}
  
  public String as()
  {
    if (this.i == null) {
      return "";
    }
    if (af.c(this.i.I))
    {
      if (aj() == null) {
        return "";
      }
      return aj().h();
    }
    return this.i.I;
  }
  
  public final Collection<j> at()
  {
    return this.s;
  }
  
  public final boolean au()
  {
    try
    {
      boolean bool = this.F;
      return bool;
    }
    finally {}
  }
  
  public final boolean av()
  {
    return this.C;
  }
  
  public final boolean aw()
  {
    return this.B;
  }
  
  protected final w ax()
  {
    return this.v;
  }
  
  public final void ay()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "dispatchPause appId:%s, initialized:%b, destroyed:%b", new Object[] { aa(), Boolean.valueOf(aw()), Boolean.valueOf(au()) });
    if (!aw()) {
      return;
    }
    if (au()) {
      return;
    }
    this.E = false;
    az();
    this.z.d();
    this.j.n();
    this.k.d();
    c.d(this.g);
    c.a(this.g, c.b.d);
    this.y.b();
  }
  
  protected void az() {}
  
  @NonNull
  public <T extends j> T b(@NonNull Class<T> paramClass)
  {
    return a(paramClass, this.T ^ true);
  }
  
  final void b(com.tencent.luggage.wxa.jj.h paramh, @Nullable Object paramObject)
  {
    a(paramh, paramObject);
  }
  
  public void b(com.tencent.luggage.wxa.rm.a parama)
  {
    this.f.b(parama);
  }
  
  public final void b(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      al().a(new d.8(this, paramRunnable));
    }
    E();
  }
  
  public final void b(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return;
    }
    if (au()) {
      return;
    }
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = 0L;
    }
    paramRunnable = com.tencent.luggage.wxa.pd.n.a(this.f, paramRunnable);
    a(paramRunnable);
    com.tencent.luggage.wxa.rz.f.a.b(paramRunnable, l1);
  }
  
  public final void b(boolean paramBoolean)
  {
    this.L = paramBoolean;
  }
  
  public boolean b(com.tencent.luggage.wxa.jx.k paramk)
  {
    if (paramk == null) {
      return false;
    }
    synchronized (this.w)
    {
      this.w.remove(paramk);
      return true;
    }
  }
  
  @Nullable
  public <T extends com.tencent.luggage.wxa.jx.k> T c(@NonNull Class<T> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    synchronized (this.w)
    {
      Iterator localIterator = this.w.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.luggage.wxa.jx.k localk = (com.tencent.luggage.wxa.jx.k)localIterator.next();
        if (paramClass.isInstance(localk)) {
          return localk;
        }
      }
      return null;
    }
    for (;;)
    {
      throw paramClass;
    }
  }
  
  protected void c() {}
  
  protected final void c(com.tencent.luggage.wxa.jj.h paramh)
  {
    if (paramh == null)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "null current config, ignored");
      return;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| init start config:%s", new Object[] { paramh });
    this.i = paramh;
    this.g = paramh.D;
    this.z = new com.tencent.luggage.wxa.ix.c(this);
    this.z.h();
    this.z.a(new d.16(this));
    this.B = false;
    try
    {
      this.F = false;
      this.C = false;
      this.G = false;
      this.H = false;
      this.I = false;
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| init end appId:%s", new Object[] { aa() });
      return;
    }
    finally {}
  }
  
  public void c(@NonNull Runnable paramRunnable)
  {
    if ((!av()) && (!au()))
    {
      if (this.B)
      {
        d(paramRunnable);
        return;
      }
      this.Y.offerLast(paramRunnable);
      return;
    }
    com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandRuntime", "runOnRuntimeInitialized runtime[%s] finishing, stack %s", new Object[] { aa(), Log.getStackTraceString(new Throwable()) });
  }
  
  public final void c(boolean paramBoolean)
  {
    this.K = paramBoolean;
    m localm;
    if (C() == null) {
      localm = null;
    } else {
      localm = C().getCurrentPage();
    }
    if (localm != null) {
      localm.m();
    }
  }
  
  @Nullable
  public final <T extends com.tencent.luggage.wxa.hw.a> T d(Class<T> paramClass)
  {
    com.tencent.luggage.wxa.hw.a locala = this.x.a(paramClass);
    if (locala != null) {
      return (com.tencent.luggage.wxa.hw.a)paramClass.cast(locala);
    }
    if (paramClass == com.tencent.mm.plugin.appbrand.widget.h.class) {
      return (com.tencent.luggage.wxa.hw.a)paramClass.cast(com.tencent.mm.plugin.appbrand.widget.h.a);
    }
    return a(paramClass);
  }
  
  protected void d() {}
  
  protected final void d(@NonNull com.tencent.luggage.wxa.jj.h paramh)
  {
    if (!this.B)
    {
      com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandRuntime", "updateConfig %s, not initialized", new Object[] { paramh });
      if ((!au()) && (!av()))
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandRuntime", "dispatchNewConfig appId[%s] !mInitialized !mFinished !mFinishing, try reload", new Object[] { aa() });
        a(paramh, "dispatchNewConfigBeforeInitialized");
      }
      return;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntime", "dispatchNewConfig, appId[%s] config[%s]", new Object[] { aa(), paramh });
    if (b(paramh)) {
      aF();
    }
    a(paramh);
  }
  
  public final void d(Runnable paramRunnable)
  {
    a(paramRunnable, 0L);
  }
  
  public void d(boolean paramBoolean)
  {
    this.M = paramBoolean;
  }
  
  protected void e() {}
  
  public final void e(Runnable paramRunnable)
  {
    b(paramRunnable, 0L);
  }
  
  protected void finalize()
  {
    super.finalize();
    this.e.a(null);
  }
  
  protected com.tencent.mm.plugin.appbrand.appstorage.o h()
  {
    return new com.tencent.mm.plugin.appbrand.appstorage.u(this);
  }
  
  protected void m() {}
  
  protected void n() {}
  
  protected void o() {}
  
  protected com.tencent.luggage.wxa.ny.a v()
  {
    return new a.c();
  }
  
  @CallSuper
  public void y()
  {
    com.tencent.luggage.util.h.a(ah());
    a(null);
  }
  
  public com.tencent.mm.plugin.appbrand.appstorage.o z()
  {
    return this.r;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.d
 * JD-Core Version:    0.7.0.1
 */