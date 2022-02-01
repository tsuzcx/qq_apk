package com.tencent.luggage.wxa.em;

import com.tencent.luggage.wxa.en.a.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "SERVICE", "Lcom/tencent/luggage/standalone_ext/service/AppService;", "PAGEVIEW", "Lcom/tencent/luggage/standalone_ext/PageView;", "onReady", "com/tencent/luggage/standalone_ext/WxaRuntimeBoostPrepareProcess$checkProcessPreloadResult$2$callback$1"}, k=3, mv={1, 1, 16})
final class g$b
  implements a.a
{
  g$b(Continuation paramContinuation, g paramg, Function0 paramFunction0) {}
  
  public final void a()
  {
    Continuation localContinuation = this.a;
    Object localObject = this.c.invoke();
    Result.Companion localCompanion = Result.Companion;
    localContinuation.resumeWith(Result.constructor-impl(localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.g.b
 * JD-Core Version:    0.7.0.1
 */