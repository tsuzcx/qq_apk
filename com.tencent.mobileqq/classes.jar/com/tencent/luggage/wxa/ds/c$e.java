package com.tencent.luggage.wxa.ds;

import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.o;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class c$e
  extends Lambda
  implements Function0<Unit>
{
  c$e(c paramc)
  {
    super(0);
  }
  
  public final void a()
  {
    Iterator localIterator = c.a(this.a).g();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "pageContainer.stackIterator()");
    int i = 0;
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (i >= this.a.a())
      {
        c localc = this.a;
        Intrinsics.checkExpressionValueIsNotNull(localm, "page");
        c.a(localc, localm);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ds.c.e
 * JD-Core Version:    0.7.0.1
 */