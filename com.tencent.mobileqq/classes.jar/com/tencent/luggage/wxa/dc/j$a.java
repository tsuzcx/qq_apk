package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.qw.bt;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onTerminate"}, k=3, mv={1, 1, 16})
final class j$a<T>
  implements e.c<bt>
{
  j$a(Continuation paramContinuation) {}
  
  public final void a(@Nullable bt parambt)
  {
    Continuation localContinuation = this.a;
    if (parambt == null) {
      Intrinsics.throwNpe();
    }
    Result.Companion localCompanion = Result.Companion;
    localContinuation.resumeWith(Result.constructor-impl(parambt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.j.a
 * JD-Core Version:    0.7.0.1
 */