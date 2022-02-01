package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import uet;
import uev;
import ufd;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadCallBack$OnErrorDownload;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadCallBack;", "onCallBack", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "info", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class AdDownloadCallBack$OnErrorDownload
  extends AdDownloadCallBack
{
  AdDownloadCallBack$OnErrorDownload()
  {
    super(str, i, null);
  }
  
  protected void onCallBack(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable uev paramuev)
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = new StringBuilder().append("OnErrorDownload: ");
    if (paramuev != null)
    {
      localObject1 = paramuev.a();
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" view = ");
      if (paramRIJDownloadView == null) {
        break label129;
      }
      localObject1 = Integer.valueOf(paramRIJDownloadView.hashCode());
      label51:
      localStringBuilder = localStringBuilder.append(localObject1).append(" , errorMsg = ");
      if (paramuev == null) {
        break label134;
      }
    }
    label129:
    label134:
    for (Object localObject1 = paramuev.b();; localObject1 = null)
    {
      QLog.d("AD_DOWNLOAD_TAG", 1, (String)localObject1);
      onErrorDownloadUI(paramRIJDownloadView);
      ufd.a.a("downloadFail", paramuev);
      localObject1 = uet.a;
      paramRIJDownloadView = localObject2;
      if (paramuev != null) {
        paramRIJDownloadView = paramuev.a();
      }
      ((uet)localObject1).a(paramRIJDownloadView);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label51;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadCallBack.OnErrorDownload
 * JD-Core Version:    0.7.0.1
 */