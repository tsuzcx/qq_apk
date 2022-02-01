package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdDownloadService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler$OnCancelDownload;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler;", "onCallBack", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "info", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
final class AdDownloadStateHandler$OnCancelDownload
  extends AdDownloadStateHandler
{
  AdDownloadStateHandler$OnCancelDownload()
  {
    super(str, i, null);
  }
  
  protected void onCallBack(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnCancelDownload: ");
    Object localObject2 = null;
    if (paramAdDownloadInfo != null) {
      localObject1 = paramAdDownloadInfo.a();
    } else {
      localObject1 = null;
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(" view = ");
    if (paramRIJDownloadView != null) {
      localObject1 = Integer.valueOf(paramRIJDownloadView.hashCode());
    } else {
      localObject1 = null;
    }
    localStringBuilder.append(localObject1);
    QLog.d("AD_DOWNLOAD_TAG", 1, localStringBuilder.toString());
    onCancelDownloadUI(paramRIJDownloadView);
    Object localObject1 = (IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class);
    paramRIJDownloadView = localObject2;
    if (paramAdDownloadInfo != null) {
      paramRIJDownloadView = paramAdDownloadInfo.a();
    }
    ((IRIJAdDownloadService)localObject1).removeReportCache(paramRIJDownloadView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler.OnCancelDownload
 * JD-Core Version:    0.7.0.1
 */