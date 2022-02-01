package com.tencent.luggage.wxa.fv;

import com.tencent.luggage.wxa.hu.d;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"}, k=3, mv={1, 1, 16})
final class j$c
  extends Lambda
  implements Function1<d, Unit>
{
  j$c(j paramj)
  {
    super(1);
  }
  
  public final void a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "it");
    o.d(this.a.i(), "main process logout complete");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fv.j.c
 * JD-Core Version:    0.7.0.1
 */