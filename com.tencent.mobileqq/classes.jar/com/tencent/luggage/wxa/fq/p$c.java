package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.ea.g;
import com.tencent.luggage.wxa.hj.e;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResult;
import com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResultListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/luggage/wxaapi/PreloadWxaProcessEnvResult;", "kotlin.jvm.PlatformType", "onCallback"}, k=3, mv={1, 1, 16})
final class p$c<T>
  implements e<ResultType>
{
  p$c(String paramString, g paramg, PreloadWxaProcessEnvResultListener paramPreloadWxaProcessEnvResultListener) {}
  
  public final void a(PreloadWxaProcessEnvResult paramPreloadWxaProcessEnvResult)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("preloadNextProcess(main) process:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" type:");
    ((StringBuilder)localObject).append(this.b.name());
    ((StringBuilder)localObject).append(" result:");
    ((StringBuilder)localObject).append(paramPreloadWxaProcessEnvResult);
    o.d("WxaProcessPreloaderService", ((StringBuilder)localObject).toString());
    localObject = this.c;
    if (localObject != null) {
      ((PreloadWxaProcessEnvResultListener)localObject).onPreloadResult(paramPreloadWxaProcessEnvResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.p.c
 * JD-Core Version:    0.7.0.1
 */