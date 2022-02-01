package com.tencent.luggage.wxa.ds;

import com.tencent.luggage.wxa.qz.v.a;
import com.tencent.mm.plugin.appbrand.page.m;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "onTimerExpired"}, k=3, mv={1, 1, 16})
final class c$b$1
  implements v.a
{
  c$b$1(c.b paramb) {}
  
  public final boolean p_()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[wxa_reload]onBackground appId[");
      ((StringBuilder)localObject1).append(c.d(this.a.a));
      ((StringBuilder)localObject1).append("] try pause all pages's rendering, delay[");
      ((StringBuilder)localObject1).append(c.c(this.a.a));
      ((StringBuilder)localObject1).append("] switch[");
      ((StringBuilder)localObject1).append(this.a.a.b());
      ((StringBuilder)localObject1).append(']');
      com.tencent.luggage.wxa.qz.o.d("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", ((StringBuilder)localObject1).toString());
      Object localObject2;
      if (this.a.a.b())
      {
        localObject1 = c.a(this.a.a).g();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "pageContainer.stackIterator()");
        int i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (m)((Iterator)localObject1).next();
          int j = i + 1;
          i = j;
          if (j > this.a.a.c())
          {
            c localc = this.a.a;
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "page");
            c.a(localc, (m)localObject2);
            i = j;
          }
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[wxa_reload]onBackground appId[");
      ((StringBuilder)localObject2).append(c.d(this.a.a));
      ((StringBuilder)localObject2).append(']');
      com.tencent.luggage.wxa.qz.o.a("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", localThrowable, ((StringBuilder)localObject2).toString(), new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ds.c.b.1
 * JD-Core Version:    0.7.0.1
 */