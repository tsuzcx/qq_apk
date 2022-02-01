package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxaapi.LaunchByUsernameResultListener;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.LaunchWxaAppResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "username", "", "versionType", "", "timestamp", "", "result", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResult;", "kotlin.jvm.PlatformType", "onLaunchResult"}, k=3, mv={1, 1, 16})
final class g$k
  implements LaunchWxaAppResultListener
{
  g$k(LaunchByUsernameResultListener paramLaunchByUsernameResultListener) {}
  
  public final void onLaunchResult(@Nullable String paramString, int paramInt, long paramLong, LaunchWxaAppResult paramLaunchWxaAppResult)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((LaunchByUsernameResultListener)localObject).onLaunchResult(paramString, paramInt, paramLong, paramLaunchWxaAppResult);
    }
    localObject = g.d.a;
    boolean bool;
    if (paramLaunchWxaAppResult == LaunchWxaAppResult.OK) {
      bool = true;
    } else {
      bool = false;
    }
    ((g.d)localObject).a("launchByUsername", bool, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.k
 * JD-Core Version:    0.7.0.1
 */