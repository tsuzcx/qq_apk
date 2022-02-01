package com.tencent.luggage.wxa.ec;

import com.tencent.luggage.wxa.ea.b;
import com.tencent.luggage.wxa.ea.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "invoke"}, k=3, mv={1, 1, 16})
final class a$b
  extends Lambda
  implements Function1<b<h>, Boolean>
{
  a$b(a parama)
  {
    super(1);
  }
  
  public final boolean a(@NotNull b<h> paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "it");
    return Intrinsics.areEqual(paramb.c(), a.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ec.a.b
 * JD-Core Version:    0.7.0.1
 */