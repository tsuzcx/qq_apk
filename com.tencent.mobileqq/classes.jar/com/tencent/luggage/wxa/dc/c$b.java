package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.ob.a;
import com.tencent.luggage.wxa.ob.a.a;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "REQUEST", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "RESPONSE", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class c$b<T>
  implements e.a<Object>
{
  c$b(CancellableContinuation paramCancellableContinuation) {}
  
  public final void a(Object paramObject)
  {
    if ((paramObject instanceof a))
    {
      localContinuation = (Continuation)this.a;
      localObject = Result.Companion;
      localContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)paramObject)));
      return;
    }
    Continuation localContinuation = (Continuation)this.a;
    Object localObject = a.a.i;
    if (paramObject != null) {
      paramObject = paramObject.toString();
    } else {
      paramObject = null;
    }
    paramObject = (Throwable)new a((a.a)localObject, 0, paramObject);
    localObject = Result.Companion;
    localContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramObject)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.c.b
 * JD-Core Version:    0.7.0.1
 */