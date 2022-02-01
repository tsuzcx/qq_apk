package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import uev;
import ufd;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadCallBack$OnResumeDownload;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadCallBack;", "onCallBack", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "info", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class AdDownloadCallBack$OnResumeDownload
  extends AdDownloadCallBack
{
  AdDownloadCallBack$OnResumeDownload()
  {
    super(str, i, null);
  }
  
  protected void onCallBack(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable uev paramuev)
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = new StringBuilder().append("OnResumeDownload: ");
    if (paramuev != null)
    {
      localObject1 = paramuev.a();
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" view = ");
      if (paramRIJDownloadView == null) {
        break label111;
      }
    }
    label111:
    for (Object localObject1 = Integer.valueOf(paramRIJDownloadView.hashCode());; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(" data = ");
      localObject1 = localObject2;
      if (paramRIJDownloadView != null) {
        localObject1 = paramRIJDownloadView.a();
      }
      QLog.d("AD_DOWNLOAD_TAG", 1, localObject1);
      onResumeDownloadUI(paramRIJDownloadView);
      ufd.a.a("downloadResume", paramuev);
      return;
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadCallBack.OnResumeDownload
 * JD-Core Version:    0.7.0.1
 */