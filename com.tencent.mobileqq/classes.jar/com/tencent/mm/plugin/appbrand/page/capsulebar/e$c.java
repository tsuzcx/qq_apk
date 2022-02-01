package com.tencent.mm.plugin.appbrand.page.capsulebar;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "invoke", "com/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$installCapsuleBar$1$1"}, k=3, mv={1, 1, 16})
final class e$c
  extends Lambda
  implements Function1<com.tencent.luggage.wxa.ef.e, Unit>
{
  e$c(e parame)
  {
    super(1);
  }
  
  public final void a(@NotNull com.tencent.luggage.wxa.ef.e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "$receiver");
    parame.b((Function0)new e.c.1(this));
    parame.a((Function0)new e.c.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.e.c
 * JD-Core Version:    0.7.0.1
 */