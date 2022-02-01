package com.tencent.luggage.wxa.ea;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "PROCESS", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "it", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "invoke"}, k=3, mv={1, 1, 16})
final class c$d
  extends Lambda
  implements Function1<d, Unit>
{
  c$d(ArrayList paramArrayList)
  {
    super(1);
  }
  
  public final void a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "it");
    this.a.add(paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ea.c.d
 * JD-Core Version:    0.7.0.1
 */