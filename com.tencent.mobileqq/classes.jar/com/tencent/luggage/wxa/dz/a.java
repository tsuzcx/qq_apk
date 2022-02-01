package com.tencent.luggage.wxa.dz;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.dq.c;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.ov.f;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.plugin.appbrand.page.bg;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.o.h;

@SuppressLint({"ViewConstructor"})
public class a
  extends com.tencent.mm.plugin.appbrand.page.o
{
  private long a = 0L;
  private final f b = b();
  
  public a(Context paramContext, d paramd)
  {
    super(paramContext, paramd);
  }
  
  @Nullable
  protected o.h a(m paramm1, m paramm2)
  {
    o.h localh = super.a(paramm1, paramm2);
    getReporter().a(0L);
    getReporter().a((c)paramm2.getCurrentPageView(), (c)paramm1.getCurrentPageView(), bg.c);
    return localh;
  }
  
  @Nullable
  public o.h a(@Nullable m paramm1, @NonNull m paramm2, @NonNull bg parambg, @NonNull String paramString, boolean paramBoolean)
  {
    this.a = System.currentTimeMillis();
    paramm1 = super.a(paramm1, paramm2, parambg, paramString, paramBoolean);
    if (bg.a == parambg) {
      getReporter().a((c)paramm2.getCurrentPageView(), null, parambg);
    }
    return paramm1;
  }
  
  public void a(@Nullable m paramm1, @NonNull m paramm2, @NonNull bg parambg)
  {
    super.a(paramm1, paramm2, parambg);
    long l = System.currentTimeMillis() - this.a;
    getReporter().a(l, parambg);
    com.tencent.luggage.wxa.qz.o.d("Luggage.AppBrandPageContainerLU", "onNavigateEnd received, appId:%s, time: %d", new Object[] { getAppId(), Long.valueOf(l) });
    f localf = getReporter();
    paramm2 = (c)paramm2.getCurrentPageView();
    if (paramm1 == null) {
      paramm1 = null;
    } else {
      paramm1 = (c)paramm1.getCurrentPageView();
    }
    localf.a(paramm2, paramm1, parambg);
  }
  
  protected f b()
  {
    return new com.tencent.luggage.wxa.ov.a(getRuntime());
  }
  
  public void c()
  {
    super.c();
    if (getPageCount() > 0) {
      getReporter().c((c)getCurrentPage().getCurrentPageView());
    }
  }
  
  public void d()
  {
    super.d();
    if (getPageCount() > 0) {
      getReporter().a((c)getCurrentPage().getCurrentPageView());
    }
  }
  
  protected void e()
  {
    super.e();
    if (getPageCount() > 0) {
      getReporter().b((c)getCurrentPage().getCurrentPageView());
    }
  }
  
  public final f getReporter()
  {
    return this.b;
  }
  
  public d getRuntime()
  {
    return (d)super.getRuntime();
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return false;
    }
    if ((!ViewCompat.isAttachedToWindow(this)) && (getRuntime() != null) && (getRuntime().w()))
    {
      t.a(paramRunnable);
      return true;
    }
    return super.post(paramRunnable);
  }
  
  public final boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return false;
    }
    if ((!ViewCompat.isAttachedToWindow(this)) && (getRuntime() != null) && (getRuntime().w()))
    {
      t.a(paramRunnable, paramLong);
      return true;
    }
    return super.postDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dz.a
 * JD-Core Version:    0.7.0.1
 */