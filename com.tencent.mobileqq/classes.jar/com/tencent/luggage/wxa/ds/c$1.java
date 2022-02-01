package com.tencent.luggage.wxa.ds;

import com.tencent.luggage.wxa.ef.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "invoke"}, k=3, mv={1, 1, 16})
final class c$1
  extends Lambda
  implements Function1<e, Unit>
{
  c$1(c paramc)
  {
    super(1);
  }
  
  public final void a(@NotNull e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "$receiver");
    parame.b((Function0)new c.1.1(this));
    parame.c((Function0)new c.1.2(this));
    parame.a((Function0)new c.1.3(this));
    parame.d((Function0)new c.1.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ds.c.1
 * JD-Core Version:    0.7.0.1
 */