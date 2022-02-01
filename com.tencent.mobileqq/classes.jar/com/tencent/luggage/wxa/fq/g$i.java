package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.LaunchWxaAppResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "wxaAppID", "", "versionType", "", "timestamp", "", "result", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResult;", "kotlin.jvm.PlatformType", "onLaunchResult"}, k=3, mv={1, 1, 16})
final class g$i
  implements LaunchWxaAppResultListener
{
  g$i(LaunchWxaAppResultListener paramLaunchWxaAppResultListener) {}
  
  public final void onLaunchResult(@Nullable String paramString, int paramInt, long paramLong, LaunchWxaAppResult paramLaunchWxaAppResult)
  {
    if (paramString != null) {
      j.a.a(paramString);
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((LaunchWxaAppResultListener)localObject).onLaunchResult(paramString, paramInt, paramLong, paramLaunchWxaAppResult);
    }
    localObject = g.d.a;
    boolean bool;
    if (paramLaunchWxaAppResult == LaunchWxaAppResult.OK) {
      bool = true;
    } else {
      bool = false;
    }
    ((g.d)localObject).a("launchByQRRawData", bool, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.i
 * JD-Core Version:    0.7.0.1
 */