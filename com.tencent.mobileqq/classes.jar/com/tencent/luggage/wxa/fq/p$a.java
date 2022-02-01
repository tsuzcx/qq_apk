package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.en.a;
import com.tencent.luggage.wxa.en.a.a;
import com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.coroutines.Continuation;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "onReady", "com/tencent/luggage/wxaapi/internal/WxaProcessPreloaderService$asyncPreload$2$callback$1"}, k=3, mv={1, 1, 16})
final class p$a
  implements a.a
{
  p$a(Continuation paramContinuation, a parama) {}
  
  public final void a()
  {
    if (this.b.b() != null)
    {
      localContinuation = this.a;
      localPreloadWxaProcessEnvResult = PreloadWxaProcessEnvResult.Preload_OK;
      localCompanion = Result.Companion;
      localContinuation.resumeWith(Result.constructor-impl(localPreloadWxaProcessEnvResult));
      return;
    }
    Continuation localContinuation = this.a;
    PreloadWxaProcessEnvResult localPreloadWxaProcessEnvResult = PreloadWxaProcessEnvResult.Preload_Fail;
    Result.Companion localCompanion = Result.Companion;
    localContinuation.resumeWith(Result.constructor-impl(localPreloadWxaProcessEnvResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.p.a
 * JD-Core Version:    0.7.0.1
 */