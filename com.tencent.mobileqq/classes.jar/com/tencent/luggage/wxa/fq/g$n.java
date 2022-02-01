package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.LaunchWxaAppResultListener;
import com.tencent.luggage.wxaapi.LaunchWxaAppResultListenerEx;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxaapi/internal/WxaApiImpl$launchWxaAppInner$1", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResultListener;", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResultListenerEx;", "onLaunchResourcePrepareCompleted", "", "wxaAppID", "", "versionType", "", "timestamp", "", "onLaunchResult", "result", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResult;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class g$n
  implements LaunchWxaAppResultListener, LaunchWxaAppResultListenerEx
{
  g$n(LaunchWxaAppResultListener paramLaunchWxaAppResultListener) {}
  
  public void onLaunchResourcePrepareCompleted(@Nullable String paramString, int paramInt, long paramLong)
  {
    LaunchWxaAppResultListener localLaunchWxaAppResultListener = this.a;
    Object localObject = localLaunchWxaAppResultListener;
    if (!(localLaunchWxaAppResultListener instanceof LaunchWxaAppResultListenerEx)) {
      localObject = null;
    }
    localObject = (LaunchWxaAppResultListenerEx)localObject;
    if (localObject != null) {
      ((LaunchWxaAppResultListenerEx)localObject).onLaunchResourcePrepareCompleted(paramString, paramInt, paramLong);
    }
  }
  
  public void onLaunchResult(@Nullable String paramString, int paramInt, long paramLong, @Nullable LaunchWxaAppResult paramLaunchWxaAppResult)
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
    ((g.d)localObject).a("launchWxaApp", bool, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.n
 * JD-Core Version:    0.7.0.1
 */