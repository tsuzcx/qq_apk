package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.ef.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "invoke"}, k=3, mv={1, 1, 16})
final class d$a$a
  extends Lambda
  implements Function1<e, Unit>
{
  d$a$a(CoroutineScope paramCoroutineScope)
  {
    super(1);
  }
  
  public final void a(@NotNull e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "$receiver");
    parame.d((Function0)new d.a.a.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.d.a.a
 * JD-Core Version:    0.7.0.1
 */