package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.LaunchWxaAppWithShortLinkResultListener;
import com.tencent.mm.plugin.appbrand.shortlink.WxaShortLinkLaunchErrorCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkLaunchErrorCode;", "launchPhaseRet", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResult;", "invoke"}, k=3, mv={1, 1, 16})
final class g$q
  extends Lambda
  implements Function2<WxaShortLinkLaunchErrorCode, LaunchWxaAppResult, Unit>
{
  g$q(g paramg, LaunchWxaAppWithShortLinkResultListener paramLaunchWxaAppWithShortLinkResultListener, String paramString)
  {
    super(2);
  }
  
  public final void a(@NotNull WxaShortLinkLaunchErrorCode paramWxaShortLinkLaunchErrorCode, @Nullable LaunchWxaAppResult paramLaunchWxaAppResult)
  {
    Intrinsics.checkParameterIsNotNull(paramWxaShortLinkLaunchErrorCode, "errorCode");
    LaunchWxaAppWithShortLinkResultListener localLaunchWxaAppWithShortLinkResultListener = this.b;
    if (localLaunchWxaAppWithShortLinkResultListener != null) {
      localLaunchWxaAppWithShortLinkResultListener.onLaunchResult(this.c, g.a(this.a, paramWxaShortLinkLaunchErrorCode), paramLaunchWxaAppResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.q
 * JD-Core Version:    0.7.0.1
 */