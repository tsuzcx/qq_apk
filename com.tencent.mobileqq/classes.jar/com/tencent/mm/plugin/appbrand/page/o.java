package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.Choreographer;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.annotation.AnyThread;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.luggage.wxa.jj.a.g;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.page.capsulebar.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public class o
  extends FrameLayout
{
  static final int e = 2131428548;
  private volatile boolean a = false;
  private com.tencent.luggage.wxa.iu.d b;
  private String c;
  private boolean d = false;
  private boolean f = false;
  private o.a g;
  private o.b h;
  private final Map<com.tencent.luggage.wxa.oj.d, com.tencent.luggage.wxa.oj.a> i = new HashMap();
  private final byte[] j = new byte[0];
  private final LinkedList<m> k = new LinkedList();
  private final LinkedList<m> l = new LinkedList();
  private final LinkedList<o.c> m = new LinkedList();
  private u n;
  private boolean o = false;
  @Nullable
  private m p;
  private bf q;
  private boolean r = true;
  @Nullable
  private o.f s;
  @Nullable
  private o.i t = null;
  @Nullable
  private o.h u = null;
  private boolean v = false;
  @Nullable
  private o.e w = null;
  
  public o(Context paramContext, com.tencent.luggage.wxa.iu.d paramd)
  {
    super(paramContext);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPageContainer", "AppBrandPageContainerProfile| <init> appId[%s]", new Object[] { paramd.aa() });
    this.b = paramd;
    this.c = paramd.aa();
    this.q = new bf.a();
  }
  
  private Object a(m paramm, Object paramObject, Runnable paramRunnable)
  {
    Object localObject;
    if ((paramObject instanceof Animator))
    {
      localObject = (Animator)paramObject;
      i(paramm);
      paramm.setTag(e, localObject);
      ((Animator)localObject).addListener(new o.19(this, paramm, paramRunnable));
      ((Animator)localObject).start();
      return paramObject;
    }
    if ((paramObject instanceof Animation))
    {
      localObject = (Animation)paramObject;
      ((Animation)localObject).setAnimationListener(new o.20(this, paramRunnable, paramm));
      i(paramm);
      paramm.setTag(e, localObject);
      paramm.startAnimation((Animation)localObject);
      return paramObject;
    }
    if (paramObject == null)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      return paramObject;
    }
    throw new IllegalArgumentException("Page animation should be Animator or Animation");
  }
  
  private Object a(m paramm, Runnable paramRunnable)
  {
    return a(paramm, e(paramm), paramRunnable);
  }
  
  private Object a(m paramm, boolean paramBoolean)
  {
    if (paramm == null) {
      return null;
    }
    synchronized (this.j)
    {
      this.k.remove(paramm);
      this.k.push(paramm);
      this.l.remove(paramm);
      paramm.bringToFront();
      requestLayout();
      invalidate();
      paramm.i();
      ??? = new o.16(this, paramm);
      if (paramBoolean) {
        return b(paramm, (Runnable)???);
      }
      i(paramm);
      ((Runnable)???).run();
      return null;
    }
  }
  
  private Object a(m paramm, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramm == null) {
      return null;
    }
    if (paramBoolean2) {
      synchronized (this.j)
      {
        this.k.remove(paramm);
        this.l.remove(paramm);
      }
    }
    paramm.j();
    ??? = new o.15(this, paramBoolean2, paramm);
    if (paramBoolean1) {
      return a(paramm, (Runnable)???);
    }
    i(paramm);
    ((Runnable)???).run();
    return null;
  }
  
  private void a()
  {
    synchronized (this.j)
    {
      Object localObject2 = new LinkedList(this.m);
      this.m.clear();
      ??? = ((LinkedList)localObject2).descendingIterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (o.c)((Iterator)???).next();
        ((o.c)localObject2).a(true);
        ((o.c)localObject2).run();
        ((Iterator)???).remove();
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  private void a(bg parambg, m paramm1, m paramm2, o.g paramg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("processPageSwitchResult, pageSwitchResult: ");
    localStringBuilder.append(paramg);
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandPageContainer", localStringBuilder.toString());
    if (this.w == null)
    {
      com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandPageContainer", "processPageSwitchResult, null == mOnPageSwitchListener");
      return;
    }
    paramg = paramg.a;
    if ((paramg instanceof ValueAnimator))
    {
      paramg = (ValueAnimator)paramg;
      paramg.addListener(new o.21(this, parambg, paramm1, paramm2));
      paramg.addUpdateListener(new o.22(this, parambg, paramm1, paramm2));
      return;
    }
    if ((paramg instanceof Animation))
    {
      paramg = (Animation)paramg;
      long l1 = paramg.getDuration();
      parambg = new o.24(this, SystemClock.elapsedRealtime(), l1, parambg, paramm1, paramm2, paramg);
      Choreographer.getInstance().postFrameCallback(parambg);
      return;
    }
    c(parambg, paramm1, paramm2);
  }
  
  private void a(m paramm1, m paramm2, bg parambg, o.h paramh)
  {
    synchronized (this.j)
    {
      this.k.remove(paramm2);
      this.l.remove(paramm2);
      boolean bool = paramm2.r() ^ true;
      Object localObject2 = null;
      if (bool)
      {
        ??? = d(paramm2, new o.13(this, paramm2));
      }
      else
      {
        h(paramm2);
        ??? = null;
      }
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPageContainer", "switchPageClear, in: %s out: %s", new Object[] { paramm1.getCurrentUrl(), paramm2.getCurrentUrl() });
      com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandPageContainer", "switchPageClear, dispatchRoute, type: %s, pipMode: %s", new Object[] { parambg, paramh });
      paramm1.a(parambg, paramh);
      paramm1.i();
      if (bool)
      {
        paramh = c(paramm1, new o.14(this, paramm1));
      }
      else
      {
        paramm1.o();
        paramh = localObject2;
      }
      a(parambg, paramm2, paramm1, new o.g(paramh, ???));
      return;
    }
  }
  
  @MainThread
  private void a(String paramString, bg parambg)
  {
    if (this.b == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandPageContainer", "navigateToImpl destroyed, url[%s], type[%s]", new Object[] { paramString, parambg });
      return;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPageContainer", "navigateTo: %s, type[%s]", new Object[] { paramString, parambg });
    paramString = k(paramString);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPageContainer", "navigateTo: %s fixed, type[%s]", new Object[] { paramString, parambg });
    a();
    if ((parambg == bg.h) && (h(paramString))) {
      return;
    }
    o.29 local29 = new o.29(this, paramString, parambg);
    if (!a(paramString, parambg, local29)) {
      local29.a();
    }
  }
  
  private void a(String paramString, bg parambg, boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.j)
      {
        int i1 = this.l.size();
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPageContainer", "navigateToNext: %s (%s), Staging Count: %d, disableAnimation %b", new Object[] { paramString, parambg.name(), Integer.valueOf(i1), Boolean.valueOf(paramBoolean) });
        m localm = (m)com.tencent.luggage.wxa.ef.d.a("AppBrandPageContainerProfile| createPage", new o.7(this, paramString, parambg));
        if (localm != null) {
          ??? = (ViewGroup)localm.getParent();
        } else {
          ??? = null;
        }
        if (??? != null)
        {
          com.tencent.luggage.wxa.qz.o.a("MicroMsg.AppBrandPageContainer", new Throwable(), "page already has a parent", new Object[0]);
          ((ViewGroup)???).removeView(localm);
        }
        addView(localm, 0);
        synchronized (this.j)
        {
          ??? = (m)this.k.peekFirst();
          boolean bool = paramBoolean | bh.a(parambg) ^ true;
          if (!bool) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          o.h localh = a((m)???, localm, parambg, paramString, paramBoolean);
          o.8 local8 = new o.8(this, parambg, (m)???, localm);
          local8.a(bool);
          synchronized (this.j)
          {
            this.l.push(localm);
            this.m.push(local8);
            if (this.k.size() == 0)
            {
              postDelayed(local8, 5000L);
            }
            else
            {
              if (parambg != bg.g) {
                break label473;
              }
              l1 = 0L;
              postDelayed(local8, l1);
            }
            if ((!bh.b(parambg)) && (!bh.c(parambg))) {
              break label481;
            }
            ??? = (m)this.k.peekFirst();
            if ((??? == null) || (??? == localm)) {
              break label481;
            }
            com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPageContainer", "navigateToNext mStagingStack push done, appId[%s] url[%s] type[%s]", new Object[] { getAppId(), paramString, parambg });
            if (??? != null) {
              ((m)???).h();
            }
            l1 = af.b();
            localm.getCurrentPageView().a(new o.9(this, l1, parambg, paramString, localm, local8));
            if (bg.a == parambg) {
              localm.getCurrentPageView().aK();
            }
            localm.a(paramString);
            com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandPageContainer", "navigateToNext, dispatchRoute, type: %s, pipMode: %s", new Object[] { parambg, localh });
            localm.a(parambg, localh);
            return;
          }
        }
      }
      label473:
      long l1 = 500L;
      continue;
      label481:
      ??? = null;
    }
  }
  
  @MainThread
  private boolean a(@NonNull String paramString, @NonNull bg parambg, @NonNull o.d paramd)
  {
    o.a locala = this.g;
    if (locala != null) {
      return locala.a(paramString, parambg, this, paramd);
    }
    return false;
  }
  
  private m b(String paramString, bg parambg)
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((o.a)localObject).a(paramString, parambg, this, new o.6(this, paramString, parambg));
      if (localObject != null) {
        return localObject;
      }
    }
    return c(paramString, parambg);
  }
  
  @Nullable
  private u b()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((o.a)localObject).a(this);
      if (localObject != null) {
        return localObject;
      }
    }
    return null;
  }
  
  private Object b(m paramm, Runnable paramRunnable)
  {
    return a(paramm, d(paramm), paramRunnable);
  }
  
  private void b(int paramInt, String paramString, com.tencent.luggage.wxa.oj.b paramb)
  {
    a();
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPageContainer", "navigateBackImpl");
    o.5 local5 = new o.5(this, paramInt);
    boolean bool = a(paramString, local5);
    if (paramb != null) {
      paramb.a(bool);
    }
    if (!bool) {
      local5.run();
    }
  }
  
  private void b(m paramm1, m paramm2)
  {
    LinkedList localLinkedList = new LinkedList();
    arrayOfByte = this.j;
    int i1 = 0;
    for (;;)
    {
      try
      {
        localIterator = this.k.iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        localm = (m)localIterator.next();
        if (localm != paramm1) {
          continue;
        }
        i1 = 1;
        continue;
      }
      finally
      {
        Iterator localIterator;
        m localm;
        continue;
        throw paramm1;
        continue;
        if (localm != paramm2) {
          continue;
        }
        continue;
      }
      if (i1 != 0)
      {
        localLinkedList.add(localm);
        localIterator.remove();
        this.l.remove(localm);
      }
    }
    paramm1 = localLinkedList.iterator();
    while (paramm1.hasNext())
    {
      paramm2 = (m)paramm1.next();
      i(paramm2);
      h(paramm2);
    }
  }
  
  private void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    synchronized (this.j)
    {
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext()) {
        ((m)localIterator.next()).a(paramString1, paramString2, paramArrayOfInt);
      }
      localIterator = this.l.iterator();
      while (localIterator.hasNext()) {
        ((m)localIterator.next()).a(paramString1, paramString2, paramArrayOfInt);
      }
      ??? = this.n;
      if ((??? != null) && (paramArrayOfInt != null) && (com.tencent.luggage.wxa.he.a.a(paramArrayOfInt, ((u)???).getComponentId()))) {
        this.n.a(paramString1, paramString2);
      }
      ??? = this.p;
      if (??? != null) {
        ((m)???).a(paramString1, paramString2, paramArrayOfInt);
      }
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  private m c(String paramString, bg parambg)
  {
    if (d(paramString, parambg)) {
      return new f(getContext(), this);
    }
    return new z(getContext(), this);
  }
  
  private Object c(m paramm, Runnable paramRunnable)
  {
    return a(paramm, f(paramm), paramRunnable);
  }
  
  private void c(bg parambg, m paramm1, m paramm2)
  {
    o.e locale = this.w;
    if (locale == null) {
      return;
    }
    if (!this.v)
    {
      this.u = locale.a(parambg, paramm1, paramm2);
      this.v = true;
    }
    this.w.b(parambg, paramm1, paramm2);
    this.v = false;
  }
  
  private Object d(m paramm, Runnable paramRunnable)
  {
    return a(paramm, g(paramm), paramRunnable);
  }
  
  private boolean d(String paramString, bg parambg)
  {
    if (parambg == bg.h) {
      return true;
    }
    if ((parambg != bg.f) && (parambg != bg.g)) {}
    for (;;)
    {
      synchronized (this.j)
      {
        if (parambg == bg.d) {
          break label130;
        }
        if (parambg != bg.e) {
          break label125;
        }
        break label130;
        int i2 = this.k.size();
        if (i1 == 0) {
          break label135;
        }
        i1 = 1;
        return (this.b.aj().e().a(paramString)) && (i2 + 1 - i1 == 1);
      }
      return this.b.aj().e().a(paramString);
      label125:
      int i1 = 0;
      continue;
      label130:
      i1 = 1;
      continue;
      label135:
      i1 = 0;
    }
  }
  
  private int getActualPageStackSize()
  {
    synchronized (this.j)
    {
      int i1 = this.k.size();
      return i1;
    }
  }
  
  private void h(m paramm)
  {
    o.i locali = this.t;
    if (locali != null) {
      locali.a(paramm);
    }
    paramm.setVisibility(8);
    paramm.j();
    if (!paramm.s()) {
      paramm.k();
    }
    removeView(paramm);
    if (!paramm.s()) {
      paramm.l();
    }
  }
  
  private boolean h(String arg1)
  {
    m localm = getCurrentPage();
    f localf = i(???);
    if (localf != null)
    {
      localf.a(???, new o.10(this, localm, new o.h[1]));
      return true;
    }
    localf = j(???);
    if (localf != null)
    {
      o.h[] arrayOfh = new o.h[1];
      localf.a(???, new o.11(this, localm, arrayOfh));
      synchronized (this.j)
      {
        localm = (m)this.k.getFirst();
        b(localm, localf);
        a(localf, localm, bg.h, arrayOfh[0]);
        return true;
      }
    }
    return false;
  }
  
  private f i(String paramString)
  {
    synchronized (this.j)
    {
      m localm = (m)this.k.peekFirst();
      if (((localm instanceof f)) && (localm.b(paramString)))
      {
        paramString = (f)localm;
        return paramString;
      }
      return null;
    }
  }
  
  private void i(@NonNull m paramm)
  {
    paramm.clearAnimation();
    paramm = paramm.getTag(e);
    if ((paramm instanceof Animator))
    {
      paramm = (Animator)paramm;
      paramm.cancel();
      paramm.removeAllListeners();
      return;
    }
    if ((paramm instanceof Animation))
    {
      paramm = (Animation)paramm;
      paramm.setAnimationListener(null);
      paramm.cancel();
    }
  }
  
  private f j(String paramString)
  {
    synchronized (this.j)
    {
      if (this.k.size() < 2) {
        return null;
      }
      ListIterator localListIterator = this.k.listIterator(1);
      while (localListIterator.hasNext())
      {
        m localm = (m)localListIterator.next();
        if (((localm instanceof f)) && (localm.b(paramString)))
        {
          paramString = (f)localm;
          return paramString;
        }
      }
      return null;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private String k(String paramString)
  {
    String str = paramString;
    if (af.c(paramString)) {
      str = this.b.aj().h();
    }
    paramString = str;
    if (str.startsWith("?"))
    {
      paramString = new StringBuilder();
      paramString.append(this.b.aj().h());
      paramString.append(str);
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  @CallSuper
  @Nullable
  protected o.h a(m paramm1, m paramm2)
  {
    paramm2.getClass();
    Object localObject2 = getAppId();
    if (paramm1 == null) {
      localObject1 = null;
    } else {
      localObject1 = com.tencent.luggage.util.m.b(paramm1.getCurrentUrl());
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPageContainer", "onNavigateBack, appId[%s] out[%s], in[%s], mActuallyVisible[%b]", new Object[] { localObject2, localObject1, com.tencent.luggage.util.m.b(paramm2.getCurrentUrl()), Boolean.valueOf(this.d) });
    if (this.d) {
      paramm2.getCurrentPageView().as();
    }
    if (paramm1 != null) {
      paramm1.p();
    }
    getRuntime().aV().a(paramm2.getCurrentPageView(), bg.c);
    localObject2 = this.u;
    o.e locale = this.w;
    Object localObject1 = localObject2;
    if (locale != null)
    {
      localObject1 = localObject2;
      if (!this.v)
      {
        localObject1 = locale.a(bg.c, paramm1, paramm2);
        this.v = true;
      }
    }
    return localObject1;
  }
  
  @CallSuper
  @Nullable
  public o.h a(@Nullable m paramm1, @NonNull m paramm2, @NonNull bg parambg, @NonNull String paramString, boolean paramBoolean)
  {
    Object localObject2 = getAppId();
    if (paramm1 == null) {
      localObject1 = null;
    } else {
      localObject1 = com.tencent.luggage.util.m.b(paramm1.getCurrentUrl());
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPageContainer", "onNavigateStart, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", new Object[] { localObject2, localObject1, com.tencent.luggage.util.m.b(paramString), Boolean.valueOf(this.d), parambg });
    if (paramm1 != null) {
      paramm1.p();
    }
    Object localObject1 = this.u;
    localObject2 = this.w;
    paramString = (String)localObject1;
    if (localObject2 != null)
    {
      paramString = (String)localObject1;
      if (!this.v)
      {
        paramString = ((o.e)localObject2).a(parambg, paramm1, paramm2);
        this.v = true;
      }
    }
    if (bg.a == parambg) {
      getRuntime().aV().a(paramm2.getCurrentPageView(), parambg);
    }
    if ((paramm1 != null) && (paramm1.getCurrentPageView() != null) && (paramm1.getCurrentPageView().af() != null) && (paramm1.getCurrentPageView().af().d())) {
      paramm1.getCurrentPageView().af().c();
    }
    return paramString;
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, paramString, null);
  }
  
  public void a(int paramInt, String paramString, @Nullable com.tencent.luggage.wxa.oj.b paramb)
  {
    a(new o.2(this, paramInt, paramString, paramb));
  }
  
  void a(bg parambg, m paramm1, m paramm2)
  {
    o.e locale = this.w;
    if ((locale != null) && (!this.v))
    {
      this.u = locale.a(parambg, paramm1, paramm2);
      this.v = true;
    }
  }
  
  void a(bg parambg, m paramm1, m paramm2, float paramFloat)
  {
    o.e locale = this.w;
    if (locale == null) {
      return;
    }
    if (!this.v)
    {
      this.u = locale.a(parambg, paramm1, paramm2);
      this.v = true;
    }
    this.w.a(parambg, paramm1, paramm2, paramFloat);
  }
  
  @CallSuper
  public void a(@Nullable m paramm1, @NonNull m paramm2, @NonNull bg parambg)
  {
    String str = getAppId();
    if (paramm1 == null) {
      paramm1 = null;
    } else {
      paramm1 = com.tencent.luggage.util.m.b(paramm1.getCurrentUrl());
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPageContainer", "onNavigateEnd, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", new Object[] { str, paramm1, com.tencent.luggage.util.m.b(paramm2.getCurrentUrl()), Boolean.valueOf(this.d), parambg });
    if (this.d) {
      paramm2.getCurrentPageView().as();
    }
    if (bg.a != parambg) {
      getRuntime().aV().a(paramm2.getCurrentPageView(), parambg);
    }
    if (a(paramm2)) {
      paramm2.getCurrentPageView().aM();
    }
  }
  
  public void a(m paramm, String paramString)
  {
    a(new o.3(this, paramm, paramString));
  }
  
  protected final void a(Runnable paramRunnable)
  {
    if ((Looper.myLooper() != null) && (Looper.myLooper() == Looper.getMainLooper()))
    {
      paramRunnable.run();
      return;
    }
    com.tencent.luggage.wxa.iu.d locald = this.b;
    if (locald == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandPageContainer", "runOnUiThread but mRuntime==NULL, appId:%s, stack:%s", new Object[] { getAppId(), Log.getStackTraceString(new Throwable()) });
      return;
    }
    locald.d(paramRunnable);
  }
  
  public void a(String paramString)
  {
    a(new o.23(this, paramString));
  }
  
  public void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    a(new o.17(this, paramString1, paramString2, paramArrayOfInt));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(new o.26(this, paramString, paramBoolean));
  }
  
  protected boolean a(@NonNull m paramm)
  {
    String str = paramm.getCurrentUrl();
    boolean[] arrayOfBoolean = new boolean[5];
    int i2;
    if (getPageCount() == 1) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    arrayOfBoolean[0] = i2;
    arrayOfBoolean[1] = (str.startsWith(getRuntime().aj().h()) ^ true);
    if (paramm.getCurrentPageView().ah() != null) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    arrayOfBoolean[2] = i2;
    arrayOfBoolean[3] = (paramm.getCurrentPageView().ah().h() ^ true);
    if (!(paramm instanceof f)) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    arrayOfBoolean[4] = i2;
    int i1 = 0;
    while (i1 < arrayOfBoolean.length)
    {
      if (arrayOfBoolean[i1] == 0)
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPageContainer", "[%s,%s]->shouldShowActionBarHomeButton: test fail cause #[%d] condition,", new Object[] { paramm.getAppId(), paramm.getCurrentUrl(), Integer.valueOf(i1) });
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  public boolean a(String paramString, Runnable paramRunnable)
  {
    Object localObject = getNavigateBackInterceptorChain();
    boolean bool1 = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      boolean bool2 = ((com.tencent.luggage.wxa.oj.a)((Iterator)localObject).next()).a(getRuntime(), paramString, paramRunnable);
      bool1 = bool2;
      if (bool2) {
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public m b(m paramm)
  {
    synchronized (this.j)
    {
      if (this.l.indexOf(paramm) >= 0)
      {
        paramm = (m)this.k.peekFirst();
        return paramm;
      }
      int i1 = this.k.indexOf(paramm);
      if (i1 >= this.k.size() - 1) {
        return null;
      }
      paramm = (m)this.k.get(i1 + 1);
      return paramm;
    }
  }
  
  void b(bg parambg, m paramm1, m paramm2)
  {
    o.e locale = this.w;
    if (locale != null)
    {
      locale.c(parambg, paramm1, paramm2);
      this.v = false;
    }
  }
  
  public void b(m paramm, String paramString)
  {
    a(new o.4(this, paramm, paramString));
  }
  
  @AnyThread
  public void b(String paramString)
  {
    a(new o.25(this, paramString));
  }
  
  final int c(m paramm)
  {
    synchronized (this.j)
    {
      int i1 = this.k.indexOf(paramm);
      return i1;
    }
  }
  
  public void c()
  {
    synchronized (this.j)
    {
      m localm = (m)this.k.peekFirst();
      if (localm == null) {
        return;
      }
      localm.i();
      if (this.d)
      {
        com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandPageContainer", "onForeground, call onUserVisible, appId[%s] url[%s]", new Object[] { getAppId(), localm.getCurrentPageView().an() });
        localm.getCurrentPageView().as();
      }
      return;
    }
  }
  
  @AnyThread
  public void c(String paramString)
  {
    a(paramString, false);
  }
  
  public Object d(@NonNull m paramm)
  {
    paramm = ObjectAnimator.ofFloat(paramm, "translationX", new float[] { paramm.getWidth(), 0.0F });
    paramm.setDuration(250L);
    return paramm;
  }
  
  public void d()
  {
    synchronized (this.j)
    {
      m localm = (m)this.k.peekFirst();
      if (localm == null) {
        return;
      }
      localm.j();
      return;
    }
  }
  
  @AnyThread
  public void d(String paramString)
  {
    a(new o.27(this, paramString));
  }
  
  public Object e(@NonNull m paramm)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramm, "translationX", new float[] { 0.0F, -(paramm.getWidth() * 0.25F) });
    localObjectAnimator.setDuration(250L);
    paramm = ObjectAnimator.ofFloat(paramm, "translationX", new float[] { 0.0F });
    paramm.setDuration(0L);
    new AnimatorSet().playSequentially(new Animator[] { localObjectAnimator, paramm });
    return localObjectAnimator;
  }
  
  protected void e() {}
  
  @UiThread
  public final boolean e(String paramString)
  {
    if (getCurrentPage() != null)
    {
      u localu = getCurrentPage().getCurrentPageView();
      if (localu != null) {
        return localu.e(paramString);
      }
    }
    com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandPageContainer", "rewriteRoute invalid page appId:%s, url:%s", new Object[] { getAppId(), paramString });
    return false;
  }
  
  public Object f(@NonNull m paramm)
  {
    paramm = ObjectAnimator.ofFloat(paramm, "translationX", new float[] { -(paramm.getWidth() * 0.25F), 0.0F });
    paramm.setDuration(250L);
    return paramm;
  }
  
  @AnyThread
  public void f(String paramString)
  {
    a(new o.28(this, paramString));
  }
  
  public boolean f()
  {
    int i1 = getActualPageStackSize();
    boolean bool = true;
    if (i1 <= 1)
    {
      if (getRuntime().aL()) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public Object g(@NonNull m paramm)
  {
    paramm = ObjectAnimator.ofFloat(paramm, "translationX", new float[] { 0.0F, paramm.getWidth() });
    paramm.setDuration(250L);
    return paramm;
  }
  
  public Iterator<m> g()
  {
    return new o.12(this);
  }
  
  public void g(String paramString)
  {
    a(new o.30(this, paramString));
  }
  
  public final com.tencent.luggage.wxa.jj.a getAppConfig()
  {
    return this.b.aj();
  }
  
  public String getAppId()
  {
    return this.c;
  }
  
  @Nullable
  public m getCurrentPage()
  {
    byte[] arrayOfByte = this.j;
    int i1;
    try
    {
      if (!this.l.isEmpty()) {
        localm = (m)this.l.getFirst();
      }
    }
    finally
    {
      m localm;
      if (this.b == null) {}
    }
    try
    {
      if (this.b != null)
      {
        if ((!this.b.F()) || (this.b.aw())) {
          break label345;
        }
        i1 = 1;
        if ((localm == null) && (i1 == 0)) {
          com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandPageContainer", "getCurrentPage returns NULL, appId[%s] mStagingStack.size[%d] mPageStack.size[%d] stack:%s", new Object[] { getAppId(), Integer.valueOf(this.l.size()), Integer.valueOf(this.k.size()), Log.getStackTraceString(new Throwable()) });
        }
      }
      return localm;
    }
    finally {}
    localm = (m)this.k.peekFirst();
    if (this.b != null)
    {
      if ((!this.b.F()) || (this.b.aw())) {
        break label350;
      }
      i1 = 1;
      label173:
      if ((localm == null) && (i1 == 0)) {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandPageContainer", "getCurrentPage returns NULL, appId[%s] mStagingStack.size[%d] mPageStack.size[%d] stack:%s", new Object[] { getAppId(), Integer.valueOf(this.l.size()), Integer.valueOf(this.k.size()), Log.getStackTraceString(new Throwable()) });
      }
    }
    return localm;
    if ((this.b.F()) && (!this.b.aw())) {
      i1 = 1;
    }
    for (;;)
    {
      if (i1 == 0) {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandPageContainer", "getCurrentPage returns NULL, appId[%s] mStagingStack.size[%d] mPageStack.size[%d] stack:%s", new Object[] { getAppId(), Integer.valueOf(this.l.size()), Integer.valueOf(this.k.size()), Log.getStackTraceString(new Throwable()) });
      }
      throw localObject1;
      label345:
      i1 = 0;
      break;
      label350:
      i1 = 0;
      break label173;
      i1 = 0;
    }
  }
  
  public String getCurrentUrl()
  {
    m localm = getCurrentPage();
    if (localm != null) {
      return localm.getCurrentUrl();
    }
    return null;
  }
  
  @NonNull
  public bf getDecorWidgetFactory()
  {
    return this.q;
  }
  
  @Nullable
  public List<com.tencent.luggage.wxa.oj.a> getNavigateBackInterceptorChain()
  {
    synchronized (this.i)
    {
      if ((this.i.size() != 0) && (getCurrentPage() != null))
      {
        ArrayList localArrayList = new ArrayList(this.i.values());
        Collections.sort(localArrayList, new o.1(this));
        return localArrayList;
      }
      return null;
    }
  }
  
  public final int getPageCount()
  {
    synchronized (this.j)
    {
      int i1 = this.k.size();
      int i2 = this.l.size();
      return i1 + i2;
    }
  }
  
  @Nullable
  public final u getPageView()
  {
    if (this.a) {
      return null;
    }
    boolean bool = this.b.X();
    Object localObject = getCurrentPage();
    if (localObject == null)
    {
      if (bool)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getPageView() assert by NULL page, appId=");
        ((StringBuilder)localObject).append(getAppId());
        junit.framework.a.a(((StringBuilder)localObject).toString());
      }
      return null;
    }
    localObject = ((m)localObject).getCurrentPageView();
    if ((localObject == null) && (bool))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPageView() assert by NULL pv, appId=");
      localStringBuilder.append(getAppId());
      junit.framework.a.a(localStringBuilder.toString());
    }
    return localObject;
  }
  
  @Nullable
  protected final u getPreloadedPageView()
  {
    return this.n;
  }
  
  public com.tencent.luggage.wxa.iu.d getRuntime()
  {
    return this.b;
  }
  
  public void h()
  {
    a(this.b.aj().h(), true);
  }
  
  public void i()
  {
    this.a = true;
    e();
    Object localObject1 = new LinkedList();
    synchronized (this.k)
    {
      ((LinkedList)localObject1).addAll(this.k);
      ((LinkedList)localObject1).addAll(this.l);
      this.k.clear();
      this.l.clear();
      ??? = ((LinkedList)localObject1).iterator();
      while (((Iterator)???).hasNext())
      {
        m localm = (m)((Iterator)???).next();
        localm.j();
        localm.k();
        localm.l();
        i(localm);
      }
      ((LinkedList)localObject1).clear();
      localObject1 = this.n;
      if (localObject1 == null) {}
    }
  }
  
  public final u j()
  {
    boolean bool = this.o ^ true;
    this.o = true;
    Object localObject = this.n;
    if (localObject == null)
    {
      u localu = b();
      localObject = localu;
      if (localu == null) {
        localObject = new u();
      }
      if (bool) {
        ((u)localObject).aK();
      }
      ((u)localObject).a(getDecorWidgetFactory());
      ((u)localObject).a(getContext(), this.b);
      return localObject;
    }
    this.n = null;
    if (bool) {
      ((u)localObject).aK();
    }
    ((u)localObject).w();
    removeView(((u)localObject).getContentView());
    return localObject;
  }
  
  final void k()
  {
    if (!this.d)
    {
      this.f = true;
      return;
    }
    this.f = false;
    o.a locala = this.g;
    if ((locala != null) && (locala.a())) {
      return;
    }
    getRuntime().a(new o.18(this), 200L);
  }
  
  protected final void l()
  {
    if (this.b == null) {
      return;
    }
    if (this.r)
    {
      o.f localf = this.s;
      if (localf != null) {
        localf.a();
      }
      m();
      this.r = false;
    }
  }
  
  protected void m() {}
  
  public void n()
  {
    m localm = getCurrentPage();
    if (localm == null) {
      return;
    }
    if (localm.getCurrentPageView().ay()) {
      return;
    }
    for (;;)
    {
      synchronized (this.j)
      {
        if (!this.l.isEmpty())
        {
          i1 = 1;
          if ((i1 == 0) && (localm.getTag(e) == null))
          {
            g("scene_back_key_pressed");
            return;
          }
          com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandPageContainer", "onBackPressed, has navigating pages, skip");
          return;
        }
      }
      int i1 = 0;
    }
  }
  
  public void setActuallyVisible(boolean paramBoolean)
  {
    int i1;
    if (this.d != paramBoolean) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    this.d = paramBoolean;
    if ((paramBoolean) && (i1 != 0))
    {
      getCurrentPage().getCurrentPageView().as();
      super.setVisibility(0);
      if (this.f) {
        k();
      }
    }
    if ((!paramBoolean) && (i1 != 0)) {
      super.setVisibility(4);
    }
  }
  
  public void setDecorWidgetFactory(bf parambf)
  {
    if (parambf != null)
    {
      this.q = parambf;
      return;
    }
    throw new NullPointerException("Should not be null");
  }
  
  public final void setDelegate(o.a parama)
  {
    if (this.g == null)
    {
      o.b localb = this.h;
      o.a locala = parama;
      if (localb != null) {
        locala = localb.a(parama);
      }
      this.g = locala;
      return;
    }
    throw new IllegalAccessError("Duplicated call!!!");
  }
  
  public void setDelegateWrapperFactory(@NonNull o.b paramb)
  {
    this.h = paramb;
    o.a locala = this.g;
    if (locala != null) {
      this.g = paramb.a(locala);
    }
  }
  
  @MainThread
  public void setOnPageSwitchListener(@Nullable o.e parame)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setOnPageSwitchListener, onPageSwitchListener: ");
    localStringBuilder.append(parame);
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandPageContainer", localStringBuilder.toString());
    this.w = parame;
  }
  
  public void setOnReadyListener(@Nullable o.f paramf)
  {
    this.s = paramf;
  }
  
  @MainThread
  public void setPipPageLifeCycleListener(@Nullable o.i parami)
  {
    this.t = parami;
  }
  
  public void setPipVideoRelatedPage(@Nullable m paramm)
  {
    if (paramm != null) {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPageContainer", "setPipVideoRelatedPage, page(%s)", new Object[] { paramm.getCurrentUrl() });
    } else {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPageContainer", "setPipVideoRelatedPage, page is null");
    }
    this.p = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o
 * JD-Core Version:    0.7.0.1
 */