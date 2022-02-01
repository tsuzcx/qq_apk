package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResult;
import com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResultListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/luggage/wxaapi/PreloadWxaProcessEnvResult;", "kotlin.jvm.PlatformType", "onPreloadResult"}, k=3, mv={1, 1, 16})
final class g$s$1
  implements PreloadWxaProcessEnvResultListener
{
  g$s$1(g.s params) {}
  
  public final void onPreloadResult(PreloadWxaProcessEnvResult paramPreloadWxaProcessEnvResult)
  {
    g.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("preloadWxaProcessEnv: ");
    ((StringBuilder)localObject).append(this.a.a);
    ((StringBuilder)localObject).append(" result:");
    ((StringBuilder)localObject).append(paramPreloadWxaProcessEnvResult);
    o.d("Luggage.WxaApiImpl", ((StringBuilder)localObject).toString());
    localObject = this.a.b;
    if (localObject != null) {
      ((PreloadWxaProcessEnvResultListener)localObject).onPreloadResult(paramPreloadWxaProcessEnvResult);
    }
    localObject = g.d.a;
    boolean bool;
    if (paramPreloadWxaProcessEnvResult != PreloadWxaProcessEnvResult.Preload_Fail) {
      bool = true;
    } else {
      bool = false;
    }
    g.d.a((g.d)localObject, "preloadWxaProcessEnv", bool, null, 0, 12, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.s.1
 * JD-Core Version:    0.7.0.1
 */