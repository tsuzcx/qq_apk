package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.LaunchWxaAppResultListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "wxaAppID", "", "versionType", "", "timestamp", "", "result", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResult;", "kotlin.jvm.PlatformType", "onLaunchResult"}, k=3, mv={1, 1, 16})
final class g$p$a
  implements LaunchWxaAppResultListener
{
  g$p$a(Function1 paramFunction1) {}
  
  public final void onLaunchResult(@Nullable String paramString, int paramInt, long paramLong, LaunchWxaAppResult paramLaunchWxaAppResult)
  {
    if (paramString != null) {
      j.a.a(paramString);
    }
    paramString = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramLaunchWxaAppResult, "result");
    paramString.invoke(paramLaunchWxaAppResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.p.a
 * JD-Core Version:    0.7.0.1
 */