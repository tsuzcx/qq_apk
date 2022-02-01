package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt", "com/tencent/luggage/launch/WxaLaunchPrepareProcess$Loader$runStepGetCode$2$3"}, k=3, mv={1, 1, 16})
final class s$b$e<T>
  implements e.a<Object>
{
  s$b$e(long paramLong, Continuation paramContinuation, s.b paramb) {}
  
  public final void a(Object paramObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("|runProfiled| onError(");
    ((StringBuilder)localObject1).append(paramObject);
    ((StringBuilder)localObject1).append(") appId:");
    ((StringBuilder)localObject1).append(s.b.d(this.c));
    ((StringBuilder)localObject1).append(", ts:");
    ((StringBuilder)localObject1).append(af.d());
    ((StringBuilder)localObject1).append(", cost:");
    ((StringBuilder)localObject1).append(af.b() - this.a);
    o.d("Luggage.WxaLaunchPrepareProcess|runProfiled", ((StringBuilder)localObject1).toString());
    if ((paramObject instanceof Throwable)) {
      paramObject = (Throwable)paramObject;
    } else {
      paramObject = (Throwable)new Error(paramObject.toString());
    }
    localObject1 = t.a;
    Object localObject2 = s.b.h(this.c);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "wxaInstanceId");
    ((t)localObject1).a((String)localObject2, t.d.d, t.c.d, paramObject.getMessage());
    localObject1 = this.b;
    localObject2 = Result.Companion;
    ((Continuation)localObject1).resumeWith(Result.constructor-impl(ResultKt.createFailure(paramObject)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.s.b.e
 * JD-Core Version:    0.7.0.1
 */