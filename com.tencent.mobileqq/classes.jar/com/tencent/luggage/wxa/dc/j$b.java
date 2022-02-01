package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class j$b<T>
  implements e.a<Object>
{
  j$b(Continuation paramContinuation) {}
  
  public final void a(Object paramObject)
  {
    if ((paramObject instanceof Throwable))
    {
      localContinuation = this.a;
      localCompanion = Result.Companion;
      localContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)paramObject)));
      return;
    }
    Continuation localContinuation = this.a;
    if (paramObject != null) {
      paramObject = paramObject.toString();
    } else {
      paramObject = null;
    }
    paramObject = (Throwable)new IllegalArgumentException(paramObject);
    Result.Companion localCompanion = Result.Companion;
    localContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramObject)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.j.b
 * JD-Core Version:    0.7.0.1
 */