package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler$OnInitDownload;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler;", "onCallBack", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "info", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
final class AdDownloadStateHandler$OnInitDownload
  extends AdDownloadStateHandler
{
  AdDownloadStateHandler$OnInitDownload()
  {
    super(str, i, null);
  }
  
  protected void onCallBack(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnInitDownload: ");
    Object localObject = null;
    if (paramAdDownloadInfo != null) {
      paramAdDownloadInfo = paramAdDownloadInfo.a();
    } else {
      paramAdDownloadInfo = null;
    }
    localStringBuilder.append(paramAdDownloadInfo);
    localStringBuilder.append(" view = ");
    paramAdDownloadInfo = localObject;
    if (paramRIJDownloadView != null) {
      paramAdDownloadInfo = Integer.valueOf(paramRIJDownloadView.hashCode());
    }
    localStringBuilder.append(paramAdDownloadInfo);
    QLog.d("AD_DOWNLOAD_TAG", 1, localStringBuilder.toString());
    onInitUI(paramRIJDownloadView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler.OnInitDownload
 * JD-Core Version:    0.7.0.1
 */