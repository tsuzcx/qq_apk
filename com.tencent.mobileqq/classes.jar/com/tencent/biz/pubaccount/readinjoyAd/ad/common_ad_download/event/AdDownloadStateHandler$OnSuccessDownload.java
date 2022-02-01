package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdDownloadService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler$OnSuccessDownload;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler;", "onCallBack", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "info", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
final class AdDownloadStateHandler$OnSuccessDownload
  extends AdDownloadStateHandler
{
  AdDownloadStateHandler$OnSuccessDownload()
  {
    super(str, i, null);
  }
  
  protected void onCallBack(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("OnSuccessDownload: ");
    Object localObject2 = null;
    if (paramAdDownloadInfo != null) {
      localObject1 = paramAdDownloadInfo.a();
    } else {
      localObject1 = null;
    }
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(" view = ");
    if (paramRIJDownloadView != null) {
      localObject1 = Integer.valueOf(paramRIJDownloadView.hashCode());
    } else {
      localObject1 = null;
    }
    ((StringBuilder)localObject3).append(localObject1);
    QLog.d("AD_DOWNLOAD_TAG", 1, ((StringBuilder)localObject3).toString());
    onSuccessDownloadUI(paramRIJDownloadView);
    localObject3 = (IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class);
    if (paramRIJDownloadView != null) {
      localObject1 = paramRIJDownloadView.getContext();
    } else {
      localObject1 = null;
    }
    if (paramRIJDownloadView != null) {
      paramRIJDownloadView = paramRIJDownloadView.getAdInfo();
    } else {
      paramRIJDownloadView = null;
    }
    ((IRIJAdDownloadService)localObject3).reportDownloadFinish((Context)localObject1, paramRIJDownloadView);
    reportPercentIfNeed(paramAdDownloadInfo, 100);
    ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).reportBeacon("downloadSucc", paramAdDownloadInfo);
    Object localObject1 = (IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class);
    paramRIJDownloadView = localObject2;
    if (paramAdDownloadInfo != null) {
      paramRIJDownloadView = paramAdDownloadInfo.a();
    }
    ((IRIJAdDownloadService)localObject1).removeReportCache(paramRIJDownloadView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler.OnSuccessDownload
 * JD-Core Version:    0.7.0.1
 */