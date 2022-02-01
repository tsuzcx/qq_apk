package com.tencent.luggage.wxa.em;

import com.tencent.mm.plugin.appbrand.keylogger.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "SERVICE", "Lcom/tencent/luggage/standalone_ext/service/AppService;", "PAGEVIEW", "Lcom/tencent/luggage/standalone_ext/PageView;", "run", "com/tencent/luggage/standalone_ext/WxaRuntimeBoostPrepareProcess$preloadService$2$1$3"}, k=3, mv={1, 1, 16})
final class g$e$2
  implements Runnable
{
  g$e$2(g.e parame) {}
  
  public final void run()
  {
    Continuation localContinuation = this.a.c;
    Object localObject = g.c(this.a.d).invoke();
    ((com.tencent.luggage.standalone_ext.service.a)localObject).B();
    d.b(g.a(this.a.d), com.tencent.luggage.wxa.oy.a.x);
    Result.Companion localCompanion = Result.Companion;
    localContinuation.resumeWith(Result.constructor-impl(localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.g.e.2
 * JD-Core Version:    0.7.0.1
 */