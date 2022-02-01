package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRecommendAdHelper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.GameComponentReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class RIJAdDownloadUtil$doGameDownload$1
  implements DialogInterface.OnClickListener
{
  RIJAdDownloadUtil$doGameDownload$1(AdvertisementInfo paramAdvertisementInfo, RIJDownloadView paramRIJDownloadView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 1)
    {
      GameComponentReport.a(Integer.valueOf(0), this.a, 10, "2");
      return;
    }
    FastWebRecommendAdHelper.a(this.b.getContext(), this.a, true, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadUtil.doGameDownload.1
 * JD-Core Version:    0.7.0.1
 */