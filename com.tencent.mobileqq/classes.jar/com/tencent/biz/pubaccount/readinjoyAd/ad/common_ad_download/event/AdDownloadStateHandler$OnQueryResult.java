package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler$OnQueryResult;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler;", "onCallBack", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "info", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class AdDownloadStateHandler$OnQueryResult
  extends AdDownloadStateHandler
{
  AdDownloadStateHandler$OnQueryResult()
  {
    super(str, i, null);
  }
  
  protected void onCallBack(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = new StringBuilder().append("OnQueryResult: ");
    if (paramAdDownloadInfo != null)
    {
      localObject1 = paramAdDownloadInfo.a();
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" state = ");
      if (paramAdDownloadInfo == null) {
        break label131;
      }
      localObject1 = Integer.valueOf(paramAdDownloadInfo.a());
      label51:
      localStringBuilder = localStringBuilder.append(localObject1).append(" progress = ");
      if (paramAdDownloadInfo == null) {
        break label136;
      }
    }
    label131:
    label136:
    for (Object localObject1 = Integer.valueOf(paramAdDownloadInfo.b());; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(" view = ");
      localObject1 = localObject2;
      if (paramRIJDownloadView != null) {
        localObject1 = Integer.valueOf(paramRIJDownloadView.hashCode());
      }
      QLog.d("AD_DOWNLOAD_TAG", 1, localObject1);
      onQueryResultUI(paramRIJDownloadView, paramAdDownloadInfo);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label51;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler.OnQueryResult
 * JD-Core Version:    0.7.0.1
 */