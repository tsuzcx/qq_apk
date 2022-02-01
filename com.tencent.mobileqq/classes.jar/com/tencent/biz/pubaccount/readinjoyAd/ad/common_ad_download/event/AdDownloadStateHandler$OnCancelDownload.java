package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.RIJAdDownloadCache;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler$OnCancelDownload;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler;", "onCallBack", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "info", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class AdDownloadStateHandler$OnCancelDownload
  extends AdDownloadStateHandler
{
  AdDownloadStateHandler$OnCancelDownload()
  {
    super(str, i, null);
  }
  
  protected void onCallBack(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = new StringBuilder().append("OnCancelDownload: ");
    if (paramAdDownloadInfo != null)
    {
      localObject1 = paramAdDownloadInfo.a();
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" view = ");
      if (paramRIJDownloadView == null) {
        break label98;
      }
    }
    label98:
    for (Object localObject1 = Integer.valueOf(paramRIJDownloadView.hashCode());; localObject1 = null)
    {
      QLog.d("AD_DOWNLOAD_TAG", 1, localObject1);
      onCancelDownloadUI(paramRIJDownloadView);
      localObject1 = RIJAdDownloadCache.a;
      paramRIJDownloadView = localObject2;
      if (paramAdDownloadInfo != null) {
        paramRIJDownloadView = paramAdDownloadInfo.a();
      }
      ((RIJAdDownloadCache)localObject1).a(paramRIJDownloadView);
      return;
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler.OnCancelDownload
 * JD-Core Version:    0.7.0.1
 */