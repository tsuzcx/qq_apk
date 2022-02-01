package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import com.tencent.mobileqq.mini.notify.MiniAppNotify.IMiniAppNotifyListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "appid", "", "kotlin.jvm.PlatformType", "scene", "", "via", "event", "timestamp", "", "onNotify"}, k=3, mv={1, 1, 16})
final class AdMiniGameGuideManager$miniAppNotifyListener$1
  implements MiniAppNotify.IMiniAppNotifyListener
{
  public static final 1 a = new 1();
  
  public final void onNotify(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if (Intrinsics.areEqual("onResume", paramString3))
    {
      AdMiniGameGuideManager.a.a(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      return;
    }
    if (Intrinsics.areEqual("onPause", paramString3)) {
      AdMiniGameGuideManager.a.b(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager.miniAppNotifyListener.1
 * JD-Core Version:    0.7.0.1
 */