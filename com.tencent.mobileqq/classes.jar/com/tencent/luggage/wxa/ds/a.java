package com.tencent.luggage.wxa.ds;

import android.content.Context;
import android.content.res.Configuration;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.dq.a.a;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.page.bg;
import com.tencent.mm.plugin.appbrand.page.w;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class a<PAGE extends com.tencent.luggage.wxa.dq.c>
  extends a.a<PAGE>
  implements w
{
  public a(@NonNull PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  @CallSuper
  public void a(Configuration paramConfiguration)
  {
    Iterator localIterator = z().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.luggage.wxa.oi.b)) {
        ((com.tencent.luggage.wxa.oi.b)localObject).a(paramConfiguration);
      }
    }
  }
  
  public void a(@NonNull com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    Iterator localIterator = z().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.luggage.wxa.oi.b)) {
        ((com.tencent.luggage.wxa.oi.b)localObject).a(paramb);
      }
    }
  }
  
  public void a(@NonNull Map<String, Object> paramMap, bg parambg) {}
  
  protected final <T extends com.tencent.luggage.wxa.ba.b> T b(Class<T> paramClass)
  {
    return ((com.tencent.luggage.wxa.dq.c)y()).a(paramClass);
  }
  
  public void e() {}
  
  @CallSuper
  public void f()
  {
    Iterator localIterator = z().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.luggage.wxa.oi.b)) {
        ((com.tencent.luggage.wxa.oi.b)localObject).c();
      }
    }
  }
  
  @CallSuper
  public void g()
  {
    Iterator localIterator = z().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.luggage.wxa.oi.b)) {
        ((com.tencent.luggage.wxa.oi.b)localObject).d();
      }
    }
  }
  
  @CallSuper
  public void h()
  {
    Iterator localIterator = z().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.luggage.wxa.oi.b)) {
        ((com.tencent.luggage.wxa.oi.b)localObject).e();
      }
    }
    super.x();
  }
  
  public d n()
  {
    com.tencent.luggage.wxa.dq.c localc = (com.tencent.luggage.wxa.dq.c)y();
    if (localc == null) {
      return null;
    }
    return localc.f();
  }
  
  public final String o()
  {
    com.tencent.luggage.wxa.jx.c localc = y();
    if (localc == null)
    {
      o.a("Luggage.AbstractPageViewRenderer", new Throwable(), "getAppId", new Object[0]);
      return null;
    }
    return localc.getAppId();
  }
  
  @NonNull
  public Context p()
  {
    Context localContext2 = ((com.tencent.luggage.wxa.dq.c)y()).getContext();
    Context localContext1 = localContext2;
    if (localContext2 == null) {
      localContext1 = r.a();
    }
    return localContext1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ds.a
 * JD-Core Version:    0.7.0.1
 */