package com.tencent.luggage.wxa.op;

import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.lp.b.a;
import com.tencent.luggage.wxa.lp.i.a;
import com.tencent.luggage.wxa.lp.j;
import com.tencent.luggage.wxa.lp.j.a;
import com.tencent.luggage.wxa.pd.r;
import com.tencent.mm.plugin.appbrand.page.bg;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.o.b;
import com.tencent.mm.plugin.appbrand.page.o.e;
import com.tencent.mm.plugin.appbrand.page.o.i;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class f
{
  private AudioManager.OnAudioFocusChangeListener A;
  @Nullable
  private i B;
  @Nullable
  private h C;
  @Nullable
  private d D;
  private volatile boolean E;
  private final String a;
  @NonNull
  private final Context b;
  @NonNull
  private final com.tencent.luggage.wxa.iu.d c;
  @NonNull
  private final com.tencent.mm.plugin.appbrand.page.o d;
  @Nullable
  private com.tencent.mm.plugin.appbrand.widget.e e;
  private volatile boolean f;
  private final Map<Integer, a> g;
  private Map<Integer, Set<String>> h;
  @Nullable
  private View i;
  @Nullable
  private b j;
  @Nullable
  private com.tencent.luggage.wxa.lp.i k;
  @Nullable
  private String l;
  @Nullable
  private m m;
  private boolean n;
  @Nullable
  private a.a o;
  private j.a p;
  private volatile boolean q;
  private boolean r;
  private boolean s;
  @Nullable
  private volatile Integer t;
  private boolean u;
  private boolean v;
  @Nullable
  private r w;
  @Nullable
  private r x;
  private final AudioManager y;
  private volatile boolean z;
  
  public f(@NonNull Context paramContext, @NonNull com.tencent.luggage.wxa.iu.d paramd)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MicroMsg.AppBrand.AppBrandPipManager#");
    localStringBuilder.append(hashCode());
    this.a = localStringBuilder.toString();
    this.e = null;
    this.f = false;
    this.g = new ConcurrentHashMap();
    this.h = new ConcurrentHashMap();
    this.i = null;
    this.j = null;
    this.k = null;
    this.l = null;
    this.m = null;
    this.n = true;
    this.o = null;
    this.p = null;
    this.q = false;
    this.r = false;
    this.s = false;
    this.t = null;
    this.u = false;
    this.v = false;
    this.w = null;
    this.x = null;
    this.z = false;
    this.A = null;
    this.B = null;
    this.C = null;
    this.D = null;
    this.b = paramContext;
    this.c = paramd;
    this.y = ((AudioManager)paramContext.getApplicationContext().getSystemService("audio"));
    this.d = paramd.C();
    this.E = (paramd.aQ() ^ true);
  }
  
  private void a(int paramInt, String paramString)
  {
    a locala = b(paramInt);
    if (locala == null) {
      return;
    }
    if (!this.f)
    {
      d();
      this.f = true;
    }
    locala.a(paramString);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    Set localSet = (Set)this.h.get(Integer.valueOf(paramInt));
    if (localSet != null)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", mPageView2VideosMap remove ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" for ");
      localStringBuilder.append(paramInt);
      com.tencent.luggage.wxa.qz.o.d(str, localStringBuilder.toString());
      localSet.remove(paramString1);
    }
  }
  
  private void a(a parama, a.a parama1)
  {
    this.l = parama.f();
    this.m = parama.e();
    parama = this.m;
    if (parama != null)
    {
      parama.a(true);
      a(this.m.getCurrentPageView().hashCode(), this.l, "setPipVideoRelated");
    }
    this.o = parama1;
    if (this.l != null)
    {
      parama = this.o;
      if ((parama != null) && (this.m != null) && (parama.e != null)) {
        this.o.e.a(this.o.a).a(this.m);
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("clearPipVideoRelated, mayPause: ");
    ((StringBuilder)localObject2).append(paramBoolean1);
    ((StringBuilder)localObject2).append(", mayDestroyPage: ");
    ((StringBuilder)localObject2).append(paramBoolean2);
    com.tencent.luggage.wxa.qz.o.d((String)localObject1, ((StringBuilder)localObject2).toString());
    if (this.l != null)
    {
      localObject1 = this.o;
      if ((localObject1 != null) && (this.m != null) && (((a.a)localObject1).e != null)) {
        this.o.e.b(this.o.a).a(this.m);
      }
    }
    localObject1 = this.l;
    this.l = null;
    localObject2 = this.m;
    if (localObject2 != null)
    {
      int i1 = ((m)localObject2).getCurrentPageView().hashCode();
      b(i1, (String)localObject1, "clearPipVideoRelated");
      if (paramBoolean2)
      {
        localObject2 = this.d.getCurrentPage();
        if (localObject2 == null)
        {
          com.tencent.luggage.wxa.qz.o.c(this.a, "clearPipVideoRelated, curPage is null");
        }
        else
        {
          ((m)localObject2).a(bg.i, null);
          ((m)localObject2).o();
        }
      }
      this.m.a(false);
      if (paramBoolean1)
      {
        localObject2 = this.o;
        if ((localObject2 != null) && (((a.a)localObject2).g != null)) {
          this.o.g.g();
        }
      }
      if ((paramBoolean2) && (!this.n))
      {
        com.tencent.luggage.wxa.qz.o.d(this.a, "clearPipVideoRelated, performDestroy and performCleanup");
        this.m.k();
        this.m.l();
        localObject2 = this.o;
        if (localObject2 != null) {
          ((a.a)localObject2).a();
        }
        a(i1, (String)localObject1, "clearPipVideoRelated");
      }
    }
    this.m = null;
    this.d.setPipVideoRelatedPage(null);
    this.n = true;
    this.o = null;
  }
  
  private boolean a(bg parambg, b.a parama)
  {
    return ((b.a.b == parama) || (b.a.d == parama)) && (bg.b == parambg);
  }
  
  private boolean a(u paramu, com.tencent.luggage.wxa.lp.h paramh, i.a parama, j paramj)
  {
    if (this.e == null) {
      return false;
    }
    Object localObject1 = this.w;
    if (localObject1 != null)
    {
      ((r)localObject1).run();
      this.w = null;
    }
    this.k = parama.a(paramh);
    parama = new f.11(this);
    localObject1 = new f.12(this);
    com.tencent.luggage.wxa.qz.o.d(this.a, "createVideoContainerView");
    this.i = this.k.a(this.b);
    this.e.a();
    this.e.f();
    Object localObject2 = this.j;
    if (localObject2 != null) {
      ((b)localObject2).c();
    }
    localObject2 = this.e;
    View localView = this.i;
    parama = new r(parama, 2, (Runnable)localObject1);
    this.x = parama;
    this.j = new b(paramu, (com.tencent.mm.plugin.appbrand.widget.e)localObject2, localView, paramh, paramj, parama);
    this.e.a(this.i);
    if (!this.k.a().a()) {
      this.e.c();
    }
    if (this.j.a())
    {
      com.tencent.luggage.wxa.qz.o.d(this.a, "transferTo");
      this.e.a(false);
      this.e.setVisibility(0);
      this.k.b(this.i, new f.13(this));
      paramj.f();
      return true;
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if ((this.e != null) && (this.k != null) && (this.i != null))
    {
      Object localObject1 = this.x;
      if (localObject1 != null)
      {
        ((r)localObject1).c();
        this.x = null;
      }
      Object localObject2 = new f.10(this);
      com.tencent.luggage.wxa.qz.o.d(this.a, "transferFrom");
      if (paramBoolean)
      {
        localObject1 = this.k;
        View localView = this.i;
        localObject2 = new r((Runnable)localObject2);
        this.w = ((r)localObject2);
        ((com.tencent.luggage.wxa.lp.i)localObject1).c(localView, (Runnable)localObject2);
      }
      else
      {
        this.k.c(this.i, null);
        ((Runnable)localObject2).run();
      }
      return true;
    }
    return false;
  }
  
  @Nullable
  private a b(int paramInt)
  {
    a locala2 = (a)this.g.get(Integer.valueOf(paramInt));
    a locala1 = locala2;
    if (locala2 == null)
    {
      com.tencent.luggage.wxa.qz.o.c(this.a, "getPageScopedPipInfo, null == pageScopedPipInfo");
      locala1 = null;
    }
    return locala1;
  }
  
  @Nullable
  private a b(@NonNull u paramu)
  {
    return b(paramu.hashCode());
  }
  
  private static String b(@Nullable m paramm)
  {
    if (paramm == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramm.getClass().getSimpleName());
    localStringBuilder.append("@");
    localStringBuilder.append(paramm.hashCode());
    localStringBuilder.append("(");
    localStringBuilder.append(paramm.getCurrentUrl());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  private void b(int paramInt, String paramString)
  {
    a locala = b(paramInt);
    if (locala == null) {
      return;
    }
    locala.b(paramString);
  }
  
  private void b(int paramInt, String paramString1, String paramString2)
  {
    Object localObject2 = (Set)this.h.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashSet();
      this.h.put(Integer.valueOf(paramInt), localObject1);
    }
    localObject2 = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", mPageView2VideosMap add ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" for ");
    localStringBuilder.append(paramInt);
    com.tencent.luggage.wxa.qz.o.d((String)localObject2, localStringBuilder.toString());
    ((Set)localObject1).add(paramString1);
  }
  
  private boolean b(bg parambg, b.a parama)
  {
    return ((b.a.c == parama) || (b.a.d == parama)) && (bg.c == parambg);
  }
  
  @Nullable
  private a.a c(int paramInt, String paramString)
  {
    a locala = (a)this.g.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      com.tencent.luggage.wxa.qz.o.c(this.a, "getPipVideoSession, null == pageScopedPipInfo");
      return null;
    }
    return locala.c(paramString);
  }
  
  private void c()
  {
    if (this.e != null)
    {
      i locali = this.B;
      if (locali != null)
      {
        if (this.C == null) {
          this.C = locali.a(this.c.aa(), this.e);
        }
        this.C.a(new f.9(this));
      }
    }
  }
  
  private void d()
  {
    this.d.setPipPageLifeCycleListener(h());
    this.d.setOnPageSwitchListener(i());
    com.tencent.luggage.wxa.iu.c.a(this.c.aa(), g());
    this.d.setDelegateWrapperFactory(k());
  }
  
  @Nullable
  private a e()
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.d()) {
        return locala;
      }
    }
    return null;
  }
  
  private void f()
  {
    if (a(false))
    {
      com.tencent.luggage.wxa.qz.o.d(this.a, "exitPip, clearPipVideoRelated");
      a(true, true);
    }
    com.tencent.mm.plugin.appbrand.widget.e locale = this.e;
    if (locale != null) {
      locale.setVisibility(4);
    }
  }
  
  private c.c g()
  {
    return new f.14(this);
  }
  
  private o.i h()
  {
    return new f.2(this);
  }
  
  private o.e i()
  {
    return new f.3(this);
  }
  
  private j.a j()
  {
    if (this.p == null) {
      this.p = new f.4(this);
    }
    return this.p;
  }
  
  private o.b k()
  {
    return new f.5(this);
  }
  
  private boolean l()
  {
    Object localObject = this.t;
    boolean bool2 = false;
    if (localObject == null)
    {
      com.tencent.luggage.wxa.qz.o.c(this.a, "isVideoInPipVideoTargetPageViewPlaying, pipVideoTargetPageViewId is null");
      return false;
    }
    if (this.h.isEmpty()) {
      return false;
    }
    localObject = (Set)this.h.get(localObject);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (!((Set)localObject).isEmpty()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private AudioManager.OnAudioFocusChangeListener m()
  {
    if (this.A == null) {
      this.A = new f.6(this);
    }
    return this.A;
  }
  
  @MainThread
  @NonNull
  public com.tencent.mm.plugin.appbrand.widget.e a()
  {
    if (this.e == null)
    {
      this.e = new com.tencent.mm.plugin.appbrand.widget.e(this.b);
      this.e.setVisibility(4);
      this.e.setOnCloseButtonClickListener(new f.1(this));
      this.e.setOnClickListener(new f.7(this));
      c();
    }
    return this.e;
  }
  
  @MainThread
  public void a(@NonNull Configuration paramConfiguration)
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConfigurationChanged: newConfig: ");
    localStringBuilder.append(paramConfiguration);
    com.tencent.luggage.wxa.qz.o.d((String)localObject, localStringBuilder.toString());
    localObject = this.j;
    if (localObject != null) {
      ((b)localObject).a(paramConfiguration);
    }
  }
  
  public void a(@NonNull u paramu)
  {
    if ((a)this.g.get(Integer.valueOf(paramu.hashCode())) != null) {
      return;
    }
    a locala = new a(paramu);
    locala.a(j());
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createPageScopedPipInfoIfNeed for ");
    localStringBuilder.append(b(paramu.T()));
    com.tencent.luggage.wxa.qz.o.d(str, localStringBuilder.toString());
    this.g.put(Integer.valueOf(paramu.hashCode()), locala);
  }
  
  public void a(@NonNull u paramu, String paramString)
  {
    paramu = b(paramu);
    if (paramu == null) {
      return;
    }
    paramu.b(paramString);
  }
  
  public void a(@NonNull u paramu, String paramString, int paramInt, @NonNull com.tencent.luggage.wxa.lp.b paramb, @NonNull com.tencent.luggage.wxa.lp.h paramh, @NonNull i.a parama, @NonNull com.tencent.luggage.wxa.lp.d paramd, @NonNull c paramc)
  {
    paramu = b(paramu);
    if (paramu == null) {
      return;
    }
    paramu.a(paramString, paramInt, paramb, paramh, parama, paramd, paramc);
  }
  
  public boolean a(int paramInt)
  {
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("exitPip, viewId: ");
    ((StringBuilder)localObject2).append(paramInt);
    com.tencent.luggage.wxa.qz.o.d((String)localObject1, ((StringBuilder)localObject2).toString());
    if (this.q)
    {
      com.tencent.luggage.wxa.qz.o.c(this.a, "exitPip when mPipClickProcessing, return");
      return false;
    }
    localObject1 = this.l;
    if ((localObject1 != null) && (((String)localObject1).contains(String.valueOf(paramInt))))
    {
      localObject1 = this.o;
      if (localObject1 != null)
      {
        localObject2 = this.D;
        if (localObject2 != null) {
          ((d)localObject2).a(((a.a)localObject1).h, e.f);
        }
      }
      localObject1 = this.e;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.appbrand.widget.e)localObject1).post(new f.8(this));
      }
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return Objects.equals(this.l, paramString);
  }
  
  @NonNull
  public String b()
  {
    return this.c.aa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.f
 * JD-Core Version:    0.7.0.1
 */