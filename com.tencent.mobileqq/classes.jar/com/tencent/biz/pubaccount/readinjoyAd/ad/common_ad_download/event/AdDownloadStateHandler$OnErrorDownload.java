package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.RIJAdDownloadCache;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler$OnErrorDownload;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler;", "onCallBack", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "info", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class AdDownloadStateHandler$OnErrorDownload
  extends AdDownloadStateHandler
{
  AdDownloadStateHandler$OnErrorDownload()
  {
    super(str, i, null);
  }
  
  protected void onCallBack(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = new StringBuilder().append("OnErrorDownload: ");
    if (paramAdDownloadInfo != null)
    {
      localObject1 = paramAdDownloadInfo.a();
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" view = ");
      if (paramRIJDownloadView == null) {
        break label129;
      }
      localObject1 = Integer.valueOf(paramRIJDownloadView.hashCode());
      label51:
      localStringBuilder = localStringBuilder.append(localObject1).append(" , errorMsg = ");
      if (paramAdDownloadInfo == null) {
        break label134;
      }
    }
    label129:
    label134:
    for (Object localObject1 = paramAdDownloadInfo.b();; localObject1 = null)
    {
      QLog.d("AD_DOWNLOAD_TAG", 1, (String)localObject1);
      onErrorDownloadUI(paramRIJDownloadView);
      RIJAdDownloadReport.a.a("downloadFail", paramAdDownloadInfo);
      localObject1 = RIJAdDownloadCache.a;
      paramRIJDownloadView = localObject2;
      if (paramAdDownloadInfo != null) {
        paramRIJDownloadView = paramAdDownloadInfo.a();
      }
      ((RIJAdDownloadCache)localObject1).a(paramRIJDownloadView);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label51;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler.OnErrorDownload
 * JD-Core Version:    0.7.0.1
 */