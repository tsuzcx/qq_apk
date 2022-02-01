package com.tencent.luggage.wxa.bk;

import com.tencent.magicbrush.ak;
import com.tencent.mm.plugin.appbrand.jsruntime.u;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;", "invoke"}, k=3, mv={1, 1, 16})
final class g$c
  extends Lambda
  implements Function0<ak>
{
  g$c(u paramu)
  {
    super(0);
  }
  
  @NotNull
  public final ak a()
  {
    u localu = this.a;
    Intrinsics.checkExpressionValueIsNotNull(localu, "addonV8");
    long l1 = localu.k();
    localu = this.a;
    Intrinsics.checkExpressionValueIsNotNull(localu, "addonV8");
    long l2 = localu.j();
    localu = this.a;
    Intrinsics.checkExpressionValueIsNotNull(localu, "addonV8");
    return new ak(l1, l2, localu.i());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bk.g.c
 * JD-Core Version:    0.7.0.1
 */