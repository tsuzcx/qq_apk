package com.tencent.biz.pubaccount.readinjoy.channelbanner;

import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "jsonData", "", "kotlin.jvm.PlatformType", "onDataUpdated"}, k=3, mv={1, 1, 16})
final class RIJChannelBannerController$ptsUpdateDataListener$1
  implements PTSComposer.IPTSUpdateDataListener
{
  RIJChannelBannerController$ptsUpdateDataListener$1(RIJChannelBannerController paramRIJChannelBannerController) {}
  
  public final void onDataUpdated(String paramString)
  {
    QLog.i("RIJChannelBannerController", 1, "[onDataUpdated] jsonData = " + paramString);
    RIJChannelBannerModule.ChannelBannerInfo localChannelBannerInfo = RIJChannelBannerController.a(this.a);
    if (localChannelBannerInfo != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramString, "jsonData");
      localChannelBannerInfo.c(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerController.ptsUpdateDataListener.1
 * JD-Core Version:    0.7.0.1
 */