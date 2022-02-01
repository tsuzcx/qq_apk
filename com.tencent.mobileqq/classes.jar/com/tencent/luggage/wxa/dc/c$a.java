package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "REQUEST", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "RESPONSE", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "response", "kotlin.jvm.PlatformType", "onTerminate", "(Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;)V"}, k=3, mv={1, 1, 16})
final class c$a<T>
  implements e.c<RESPONSE>
{
  c$a(CancellableContinuation paramCancellableContinuation) {}
  
  public final void a(RESPONSE paramRESPONSE)
  {
    CancellableContinuation localCancellableContinuation = this.a;
    Result.Companion localCompanion = Result.Companion;
    localCancellableContinuation.resumeWith(Result.constructor-impl(paramRESPONSE));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.c.a
 * JD-Core Version:    0.7.0.1
 */