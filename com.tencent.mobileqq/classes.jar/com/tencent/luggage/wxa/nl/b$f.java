package com.tencent.luggage.wxa.nl;

import com.tencent.mm.plugin.appbrand.appcache.aa;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "progress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "invoke"}, k=3, mv={1, 1, 16})
final class b$f
  extends Lambda
  implements Function1<aa, Unit>
{
  b$f(b.c paramc, j.d paramd)
  {
    super(1);
  }
  
  public final void a(@NotNull aa paramaa)
  {
    Intrinsics.checkParameterIsNotNull(paramaa, "progress");
    b.c localc = this.a;
    j.d locald = this.b;
    Intrinsics.checkExpressionValueIsNotNull(locald, "request");
    localc.a(locald, paramaa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.b.f
 * JD-Core Version:    0.7.0.1
 */