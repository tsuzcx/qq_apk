package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler$OnPauseDownload;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler;", "onCallBack", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "info", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class AdDownloadStateHandler$OnPauseDownload
  extends AdDownloadStateHandler
{
  AdDownloadStateHandler$OnPauseDownload()
  {
    super(str, i, null);
  }
  
  protected void onCallBack(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = new StringBuilder().append("OnPauseDownload: ");
    if (paramAdDownloadInfo != null)
    {
      localObject1 = paramAdDownloadInfo.a();
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" view = ");
      if (paramRIJDownloadView == null) {
        break label112;
      }
    }
    label112:
    for (Object localObject1 = Integer.valueOf(paramRIJDownloadView.hashCode());; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(" data = ");
      localObject1 = localObject2;
      if (paramRIJDownloadView != null) {
        localObject1 = paramRIJDownloadView.a();
      }
      QLog.d("AD_DOWNLOAD_TAG", 1, localObject1);
      onPauseDownloadUI(paramRIJDownloadView, paramAdDownloadInfo);
      RIJAdDownloadReport.a.a("downloadPause", paramAdDownloadInfo);
      return;
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler.OnPauseDownload
 * JD-Core Version:    0.7.0.1
 */