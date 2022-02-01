package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import uet;
import uev;
import ufd;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadCallBack$OnSuccessDownload;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadCallBack;", "onCallBack", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "info", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class AdDownloadCallBack$OnSuccessDownload
  extends AdDownloadCallBack
{
  AdDownloadCallBack$OnSuccessDownload()
  {
    super(str, i, null);
  }
  
  protected void onCallBack(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable uev paramuev)
  {
    Object localObject2 = null;
    Object localObject3 = new StringBuilder().append("OnSuccessDownload: ");
    Object localObject1;
    if (paramuev != null)
    {
      localObject1 = paramuev.a();
      localObject3 = ((StringBuilder)localObject3).append((String)localObject1).append(" view = ");
      if (paramRIJDownloadView == null) {
        break label147;
      }
      localObject1 = Integer.valueOf(paramRIJDownloadView.hashCode());
      label51:
      QLog.d("AD_DOWNLOAD_TAG", 1, localObject1);
      onSuccessDownloadUI(paramRIJDownloadView);
      localObject3 = ufd.a;
      if (paramRIJDownloadView == null) {
        break label152;
      }
      localObject1 = paramRIJDownloadView.getContext();
      label85:
      if (paramRIJDownloadView == null) {
        break label157;
      }
    }
    label147:
    label152:
    label157:
    for (paramRIJDownloadView = paramRIJDownloadView.a();; paramRIJDownloadView = null)
    {
      ufd.a((ufd)localObject3, (Context)localObject1, paramRIJDownloadView, null, 4, null);
      reportPercentIfNeed(paramuev, 100);
      ufd.a.a("downloadSucc", paramuev);
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
      localObject1 = null;
      break label85;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadCallBack.OnSuccessDownload
 * JD-Core Version:    0.7.0.1
 */