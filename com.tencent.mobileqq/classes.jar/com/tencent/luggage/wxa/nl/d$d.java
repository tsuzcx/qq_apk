package com.tencent.luggage.wxa.nl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "invoke"}, k=3, mv={1, 1, 16})
final class d$d
  extends Lambda
  implements Function1<j.e, Unit>
{
  d$d(d paramd, Function1 paramFunction1)
  {
    super(1);
  }
  
  public final void a(@NotNull j.e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "it");
    this.b.invoke(parame);
    j.c localc;
    if (parame.b() == j.f.a)
    {
      localc = d.g(this.a);
      if (localc != null) {
        localc.a(d.e(this.a), parame);
      }
    }
    else
    {
      localc = d.g(this.a);
      if (localc != null) {
        localc.b(d.e(this.a), parame);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.d.d
 * JD-Core Version:    0.7.0.1
 */