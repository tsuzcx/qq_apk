package com.tencent.luggage.wxa.em;

import com.tencent.luggage.wxa.en.e.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.coroutines.Continuation;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/standalone_ext/WxaRuntimeBoostPrepareProcess$ensureXWeb$2$1", "Lcom/tencent/luggage/standalone_ext/boost/XWebPreloader$PreloadCallback;", "onPreloadDone", "", "onPreloadFailed", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class g$c
  implements e.a
{
  g$c(Continuation paramContinuation) {}
  
  public void a()
  {
    Continuation localContinuation = this.a;
    Result.Companion localCompanion = Result.Companion;
    localContinuation.resumeWith(Result.constructor-impl(Boolean.valueOf(true)));
  }
  
  public void b()
  {
    Continuation localContinuation = this.a;
    Result.Companion localCompanion = Result.Companion;
    localContinuation.resumeWith(Result.constructor-impl(Boolean.valueOf(false)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.g.c
 * JD-Core Version:    0.7.0.1
 */