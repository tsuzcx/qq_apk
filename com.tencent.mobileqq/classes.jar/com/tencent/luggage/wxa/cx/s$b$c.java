package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.ef.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "invoke"}, k=3, mv={1, 1, 16})
final class s$b$c
  extends Lambda
  implements Function1<e, Unit>
{
  s$b$c(Job paramJob)
  {
    super(1);
  }
  
  public final void a(@NotNull e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "$receiver");
    parame.d((Function0)new s.b.c.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.s.b.c
 * JD-Core Version:    0.7.0.1
 */