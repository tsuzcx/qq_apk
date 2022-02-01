package com.tencent.luggage.wxa.ds;

import com.tencent.luggage.wxa.dt.a;
import com.tencent.luggage.wxa.ef.i;
import com.tencent.luggage.wxa.oi.e;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.mm.plugin.appbrand.page.bg;
import com.tencent.mm.plugin.appbrand.page.f;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/jsapi/component/page/AppBrandPageViewMemoryRecycleStrategy;", "", "pageContainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;)V", "appId", "", "kotlin.jvm.PlatformType", "checkPauseRenderingDelayAfterBackground", "", "getCheckPauseRenderingDelayAfterBackground", "()J", "checkPauseRenderingDelayAfterBackground$delegate", "Lkotlin/Lazy;", "checkPauseRenderingTimerAfterBackground", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getCheckPauseRenderingTimerAfterBackground", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "checkPauseRenderingTimerAfterBackground$delegate", "keepInvisbileTabbarPagesActive", "", "getKeepInvisbileTabbarPagesActive", "()Z", "setKeepInvisbileTabbarPagesActive", "(Z)V", "maxKeepRenderingPageCount", "", "getMaxKeepRenderingPageCount", "()I", "setMaxKeepRenderingPageCount", "(I)V", "maxKeepRenderingPageCountOnBackground", "getMaxKeepRenderingPageCountOnBackground", "setMaxKeepRenderingPageCountOnBackground", "pauseWhenAppBackground", "getPauseWhenAppBackground", "setPauseWhenAppBackground", "onNavigateBack", "", "out", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPage;", "in", "onNavigateEnd", "type", "Lcom/tencent/mm/plugin/appbrand/page/PageOpenType;", "onNavigateStart", "tryPauseRenderingOfInvisiblePages", "tryPauseRenderingOfInvisibleTabbarPages", "tryReloadNearestInvisiblePage", "tryRestoreRenderingOfNearestInvisiblePage", "tryPauseRendering", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "tryRestoreRendering", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class c
{
  private final String a;
  private int b;
  private boolean c;
  private boolean d;
  private int e;
  private final Lazy f;
  private final Lazy g;
  private final com.tencent.mm.plugin.appbrand.page.o h;
  
  public c(@NotNull com.tencent.mm.plugin.appbrand.page.o paramo)
  {
    this.h = paramo;
    paramo = i.a;
    com.tencent.luggage.wxa.iu.d locald = this.h.getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(locald, "pageContainer.runtime");
    paramo.a(locald, (Function1)new c.1(this));
    this.a = this.h.getAppId();
    this.b = 2;
    this.c = true;
    this.d = true;
    this.e = 1;
    this.f = LazyKt.lazy((Function0)new c.a(this));
    this.g = LazyKt.lazy((Function0)new c.b(this));
  }
  
  private final void a(bg parambg)
  {
    try
    {
      m localm = this.h.b(this.h.getCurrentPage());
      if (localm != null)
      {
        b(localm);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[wxa_reload]tryRestoreRenderingOfNearestInvisiblePage appId[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("] type[");
      localStringBuilder.append(parambg);
      localStringBuilder.append(']');
      com.tencent.luggage.wxa.qz.o.a("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", localThrowable, localStringBuilder.toString(), new Object[0]);
    }
  }
  
  private final void a(@NotNull m paramm)
  {
    if ((paramm instanceof f))
    {
      paramm = ((f)paramm).f();
      Intrinsics.checkExpressionValueIsNotNull(paramm, "this.pagesIterator()");
      while (paramm.hasNext())
      {
        Object localObject = (u)paramm.next();
        if (localObject != null)
        {
          localObject = (e)((u)localObject).d(e.class);
          if (localObject != null) {
            ((e)localObject).b();
          }
        }
      }
    }
    paramm = paramm.getCurrentPageView();
    if (paramm != null)
    {
      paramm = (e)paramm.d(e.class);
      if (paramm != null) {
        paramm.b();
      }
    }
  }
  
  private final void a(m paramm, bg parambg)
  {
    try
    {
      if (this.h.getPageCount() <= this.b) {
        return;
      }
      paramm.a((Runnable)new d((Function0)new c.e(this)));
      return;
    }
    catch (Throwable paramm)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[wxa_reload]tryPauseRenderingOfInvisiblePages appId[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("] type[");
      localStringBuilder.append(parambg);
      localStringBuilder.append("] maxKeepPageCount[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] keepInvisbileTabbarPagesActive[");
      localStringBuilder.append(this.c);
      localStringBuilder.append(']');
      com.tencent.luggage.wxa.qz.o.a("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", paramm, localStringBuilder.toString(), new Object[0]);
    }
  }
  
  private final void a(@NotNull u paramu)
  {
    paramu = (e)paramu.d(e.class);
    if (paramu != null) {
      paramu.b();
    }
  }
  
  private final void b(bg parambg)
  {
    try
    {
      Object localObject = this.h.b(this.h.getCurrentPage());
      if (localObject != null)
      {
        localObject = (a)((m)localObject).getCurrentPageView().d(a.class);
        if (localObject != null)
        {
          boolean bool = ((a)localObject).a();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[wxa_reload]tryReloadNearestInvisiblePage appId[");
          ((StringBuilder)localObject).append(this.a);
          ((StringBuilder)localObject).append("] reload[");
          ((StringBuilder)localObject).append(bool);
          ((StringBuilder)localObject).append("] type[");
          ((StringBuilder)localObject).append(parambg);
          ((StringBuilder)localObject).append(']');
          com.tencent.luggage.wxa.qz.o.d("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", ((StringBuilder)localObject).toString());
        }
      }
      else {}
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[wxa_reload]tryReloadNearestInvisiblePage appId[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("] type[");
      localStringBuilder.append(parambg);
      localStringBuilder.append(']');
      com.tencent.luggage.wxa.qz.o.a("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", localThrowable, localStringBuilder.toString(), new Object[0]);
    }
  }
  
  private final void b(@NotNull m paramm)
  {
    if ((paramm instanceof f))
    {
      paramm = ((f)paramm).f();
      Intrinsics.checkExpressionValueIsNotNull(paramm, "this.pagesIterator()");
      while (paramm.hasNext())
      {
        Object localObject = (u)paramm.next();
        if (localObject != null)
        {
          localObject = (e)((u)localObject).d(e.class);
          if (localObject != null) {
            ((e)localObject).a();
          }
        }
      }
    }
    paramm = paramm.getCurrentPageView();
    if (paramm != null)
    {
      paramm = (e)paramm.d(e.class);
      if (paramm != null) {
        paramm.a();
      }
    }
  }
  
  private final long d()
  {
    return ((Number)this.f.getValue()).longValue();
  }
  
  private final v e()
  {
    return (v)this.g.getValue();
  }
  
  private final void f()
  {
    try
    {
      if (this.c) {
        return;
      }
      localObject = this.h.getCurrentPage();
      if ((localObject instanceof f))
      {
        u localu1 = ((f)localObject).getCurrentPageView();
        if (localu1 != null)
        {
          localObject = ((f)localObject).f();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "page.pagesIterator()");
          while (((Iterator)localObject).hasNext())
          {
            u localu2 = (u)((Iterator)localObject).next();
            if (Intrinsics.areEqual(localu1, localu2)) {
              return;
            }
            Intrinsics.checkExpressionValueIsNotNull(localu2, "pv");
            a(localu2);
          }
        }
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[wxa_reload]tryPauseRenderingOfInvisibleTabbarPages appId[");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("], switch[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(']');
      com.tencent.luggage.wxa.qz.o.a("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", localThrowable, ((StringBuilder)localObject).toString(), new Object[0]);
    }
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void a(@NotNull m paramm1, @NotNull m paramm2)
  {
    Intrinsics.checkParameterIsNotNull(paramm1, "out");
    Intrinsics.checkParameterIsNotNull(paramm2, "in");
    this.h.post((Runnable)new c.c(this));
    paramm1 = paramm2.getCurrentPageView();
    if (paramm1 != null)
    {
      paramm1 = (e)paramm1.d(e.class);
      if (paramm1 != null) {
        paramm1.a();
      }
    }
  }
  
  public final void a(@Nullable m paramm1, @NotNull m paramm2, @NotNull bg parambg)
  {
    Intrinsics.checkParameterIsNotNull(paramm2, "in");
    Intrinsics.checkParameterIsNotNull(parambg, "type");
    b(paramm2);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final void b(@Nullable m paramm1, @NotNull m paramm2, @NotNull bg parambg)
  {
    Intrinsics.checkParameterIsNotNull(paramm2, "in");
    Intrinsics.checkParameterIsNotNull(parambg, "type");
    if (bg.b == parambg)
    {
      a(parambg);
      a(paramm2, parambg);
    }
    else if (bg.h == parambg)
    {
      f();
    }
    paramm1 = paramm2.getCurrentPageView();
    if (paramm1 != null)
    {
      paramm1 = (e)paramm1.d(e.class);
      if (paramm1 != null) {
        paramm1.a();
      }
    }
    if ((bg.h != parambg) && (bg.b != parambg)) {
      this.h.post((Runnable)new c.d(this, parambg));
    }
  }
  
  public final boolean b()
  {
    return this.d;
  }
  
  public final int c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ds.c
 * JD-Core Version:    0.7.0.1
 */