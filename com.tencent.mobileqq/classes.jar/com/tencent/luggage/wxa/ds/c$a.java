package com.tencent.luggage.wxa.ds;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.mm.plugin.appbrand.page.o;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class c$a
  extends Lambda
  implements Function0<Long>
{
  c$a(c paramc)
  {
    super(0);
  }
  
  public final long a()
  {
    d locald = c.a(this.a).getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(locald, "pageContainer.runtime");
    return locald.A().Q * 1000L + 100L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ds.c.a
 * JD-Core Version:    0.7.0.1
 */