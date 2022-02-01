package com.tencent.luggage.wxa.ed;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.jj.h;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.or.n;
import com.tencent.luggage.wxa.pa.a;
import com.tencent.mm.plugin.appbrand.ui.i;
import java.util.Iterator;

public class b
  extends com.tencent.luggage.wxa.iu.e<d>
  implements com.tencent.luggage.wxa.iu.o
{
  public b(a parama, Class<? extends d> paramClass)
  {
    super(parama, paramClass);
  }
  
  private void a(c paramc)
  {
    Object localObject = s().f();
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      localObject = m().v();
      if (localObject == null)
      {
        com.tencent.luggage.wxa.qz.o.b("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "tryRequestOrientationWithSplashAd, appId:%s, orientation:%s, NULL orientationHandler", new Object[] { paramc.D, paramc.H });
        return;
      }
      String str = paramc.D;
      com.tencent.luggage.wxa.qz.o.d("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "tryRequestOrientationWithSplashAd, appId:%s, config.Orientation:%s", new Object[] { paramc.D, paramc.H });
      ((com.tencent.luggage.wxa.oq.e)localObject).a(e.b.a, new b.2(this, str));
    }
  }
  
  private void a(d paramd)
  {
    if (paramd != null)
    {
      if (paramd.j() == null) {
        return;
      }
      if (paramd.aS())
      {
        a(paramd.j());
        return;
      }
      b(paramd.j());
    }
  }
  
  private void b(c paramc)
  {
    if (!TextUtils.isEmpty(paramc.H))
    {
      if (!paramc.g()) {
        return;
      }
      com.tencent.luggage.wxa.or.b localb = m().v();
      if (localb == null)
      {
        com.tencent.luggage.wxa.qz.o.b("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "tryRequestOrientationWithoutAd appId[%s] orientation[%s], NULL orientationHandler", new Object[] { paramc.D, paramc.H });
        return;
      }
      String str = paramc.D;
      com.tencent.luggage.wxa.qz.o.d("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "tryRequestOrientationWithoutAd, appId:%s, config.Orientation:%s", new Object[] { paramc.D, paramc.H });
      localb.a(e.b.a(paramc), new b.3(this, str));
    }
  }
  
  protected d a(@NonNull h paramh)
  {
    d locald = g.a.a((c)paramh, this);
    if (locald != null) {
      return locald;
    }
    return (d)super.b(paramh);
  }
  
  public void a(c paramc, com.tencent.luggage.wxa.ou.d paramd)
  {
    a(null, paramc, paramd);
  }
  
  public void a(d paramd, c paramc, com.tencent.luggage.wxa.ou.d paramd1)
  {
    if (paramc != null)
    {
      if (paramd1 == null) {
        return;
      }
      u().runOnUiThread(new b.1(this, paramd, paramc, paramd1));
    }
  }
  
  protected void a(d paramd1, d paramd2, h paramh)
  {
    super.a(paramd1, paramd2, paramh);
    if (paramd1 != null)
    {
      paramh = new b.6(this, paramd2);
      ((i)com.tencent.luggage.wxa.ba.e.a(i.class)).a(paramd2, paramh, paramd1, null);
    }
  }
  
  protected void a(@Nullable com.tencent.luggage.wxa.iu.d paramd1, @NonNull com.tencent.luggage.wxa.iu.d paramd2, @NonNull Runnable paramRunnable)
  {
    String str;
    if (paramd1 == null) {
      str = "null";
    } else {
      str = paramd1.aa();
    }
    com.tencent.luggage.wxa.qz.o.d("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "onRuntimeClose entered, in.appId[%s], out.appId[%s], out.isFinishing[%b], out.canDoCloseAnimation[%b], mIsActivityPaused[%b], stackSize[%d]", new Object[] { str, paramd2.aa(), Boolean.valueOf(paramd2.av()), Boolean.valueOf(paramd2.aK()), Boolean.valueOf(l()), Integer.valueOf(o()) });
    paramRunnable = new b.4(this, paramd1, paramd2, paramRunnable);
    if (l()) {
      paramd2.b(false);
    }
    if (!paramd2.av())
    {
      if (o() > 1)
      {
        if (paramd2.aK())
        {
          ((i)com.tencent.luggage.wxa.ba.e.a(i.class)).b(paramd1, null, paramd2, paramRunnable);
          return;
        }
        paramRunnable.run();
        return;
      }
      a(true, paramd2);
      return;
    }
    if (!b(paramd2))
    {
      paramRunnable.run();
      return;
    }
    if (o() > 1)
    {
      if (paramd2.aK())
      {
        ((i)com.tencent.luggage.wxa.ba.e.a(i.class)).b(paramd1, null, paramd2, paramRunnable);
        return;
      }
      paramRunnable.run();
      return;
    }
    a(false, paramd2);
  }
  
  protected void a(boolean paramBoolean, @Nullable com.tencent.luggage.wxa.iu.d paramd)
  {
    paramd = u();
    if (paramd == null) {
      return;
    }
    if (!paramd.isFinishing())
    {
      boolean bool = s().e();
      int i = o();
      if ((bool) && (paramBoolean)) {
        paramd.moveTaskToBack(true);
      } else {
        paramd.finish();
      }
      if (i <= 0)
      {
        paramd.overridePendingTransition(0, 0);
        return;
      }
      ((i)com.tencent.luggage.wxa.ba.e.a(i.class)).a(paramd);
    }
  }
  
  protected void b(d paramd1, d paramd2, h paramh)
  {
    super.b(paramd1, paramd2, paramh);
    if (paramd1 != null)
    {
      paramh = new b.5(this, paramd2);
      ((i)com.tencent.luggage.wxa.ba.e.a(i.class)).a(paramd2, paramh, paramd1, null);
    }
  }
  
  public void e()
  {
    super.e();
    g.a.b();
  }
  
  public void f_()
  {
    Iterator localIterator = q();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      boolean bool = g.a.c(locald);
      if ((locald.aw()) && (bool) && (!locald.av()) && (!locald.au()))
      {
        if (locald.aQ()) {
          locald.ay();
        }
        f(locald);
        g.a.a(locald);
      }
    }
  }
  
  public boolean g()
  {
    if (o() <= 0)
    {
      a(false, null);
      return true;
    }
    return false;
  }
  
  public void h()
  {
    if (g()) {
      return;
    }
    super.h();
  }
  
  public void j()
  {
    Iterator localIterator = r();
    while (localIterator.hasNext()) {
      new com.tencent.luggage.wxa.ec.d((d)localIterator.next()).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ed.b
 * JD-Core Version:    0.7.0.1
 */