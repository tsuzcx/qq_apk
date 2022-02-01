package com.tencent.luggage.wxa.ds;

import com.tencent.luggage.wxa.qz.v;
import com.tencent.mm.plugin.appbrand.page.m;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class c$1$2
  extends Lambda
  implements Function0<Unit>
{
  c$1$2(c.1 param1)
  {
    super(0);
  }
  
  public final void a()
  {
    c.b(this.a.a).c();
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[wxa_reload]onSuspend appId[");
      ((StringBuilder)localObject1).append(c.d(this.a.a));
      ((StringBuilder)localObject1).append("] try pause all pages's rendering");
      com.tencent.luggage.wxa.qz.o.d("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", ((StringBuilder)localObject1).toString());
      localObject1 = c.a(this.a.a).g();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "pageContainer.stackIterator()");
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (m)((Iterator)localObject1).next();
        c localc = this.a.a;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "page");
        c.a(localc, (m)localObject2);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[wxa_reload]onSuspend appId[");
      ((StringBuilder)localObject2).append(c.d(this.a.a));
      ((StringBuilder)localObject2).append(']');
      com.tencent.luggage.wxa.qz.o.a("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", localThrowable, ((StringBuilder)localObject2).toString(), new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ds.c.1.2
 * JD-Core Version:    0.7.0.1
 */