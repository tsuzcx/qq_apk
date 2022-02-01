package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class RIJAdDownloadViewBase$setAdData$1
  implements View.OnClickListener
{
  RIJAdDownloadViewBase$setAdData$1(RIJAdDownloadViewBase paramRIJAdDownloadViewBase) {}
  
  public final void onClick(View paramView)
  {
    RIJDownloadView localRIJDownloadView = this.a.a();
    if (localRIJDownloadView != null) {
      localRIJDownloadView.a(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJAdDownloadViewBase.setAdData.1
 * JD-Core Version:    0.7.0.1
 */