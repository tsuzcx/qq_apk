package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import uev;
import ufd;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadCallBack$OnInstallSucceed;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadCallBack;", "onCallBack", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "info", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class AdDownloadCallBack$OnInstallSucceed
  extends AdDownloadCallBack
{
  AdDownloadCallBack$OnInstallSucceed()
  {
    super(str, i, null);
  }
  
  protected void onCallBack(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable uev paramuev)
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = new StringBuilder().append("OnInstallSucceed: ");
    if (paramuev != null) {}
    for (Object localObject1 = paramuev.a();; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" view = ");
      localObject1 = localObject2;
      if (paramRIJDownloadView != null) {
        localObject1 = Integer.valueOf(paramRIJDownloadView.hashCode());
      }
      QLog.d("AD_DOWNLOAD_TAG", 1, localObject1);
      onInstallSucceedUI(paramRIJDownloadView);
      ufd.a.a("downloadInstall", paramuev);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadCallBack.OnInstallSucceed
 * JD-Core Version:    0.7.0.1
 */