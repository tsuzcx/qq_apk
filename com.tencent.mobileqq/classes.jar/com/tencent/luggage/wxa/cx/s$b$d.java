package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "onTerminate", "com/tencent/luggage/launch/WxaLaunchPrepareProcess$Loader$runStepGetCode$2$2"}, k=3, mv={1, 1, 16})
final class s$b$d<T>
  implements e.c<com.tencent.mm.plugin.appbrand.appcache.af>
{
  s$b$d(long paramLong, Continuation paramContinuation, s.b paramb) {}
  
  public final void a(@Nullable com.tencent.mm.plugin.appbrand.appcache.af paramaf)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("|runProfiled| onSuccess appId:");
    ((StringBuilder)localObject1).append(s.b.d(this.c));
    ((StringBuilder)localObject1).append(", ts:");
    ((StringBuilder)localObject1).append(com.tencent.luggage.wxa.qz.af.d());
    ((StringBuilder)localObject1).append(", cost:");
    ((StringBuilder)localObject1).append(com.tencent.luggage.wxa.qz.af.b() - this.a);
    o.d("Luggage.WxaLaunchPrepareProcess|runProfiled", ((StringBuilder)localObject1).toString());
    localObject1 = t.a;
    Object localObject2 = s.b.h(this.c);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "wxaInstanceId");
    t.a((t)localObject1, (String)localObject2, t.d.d, t.c.c, null, 8, null);
    localObject1 = this.b;
    if (paramaf == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = Result.Companion;
    ((Continuation)localObject1).resumeWith(Result.constructor-impl(paramaf));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.s.b.d
 * JD-Core Version:    0.7.0.1
 */