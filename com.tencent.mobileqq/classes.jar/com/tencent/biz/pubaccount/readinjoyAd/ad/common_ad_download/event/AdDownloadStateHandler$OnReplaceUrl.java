package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdDownloadService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler$OnReplaceUrl;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateHandler;", "onCallBack", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "info", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
final class AdDownloadStateHandler$OnReplaceUrl
  extends AdDownloadStateHandler
{
  AdDownloadStateHandler$OnReplaceUrl()
  {
    super(str, i, null);
  }
  
  protected void onCallBack(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnReplaceUrl: ");
    Object localObject = null;
    String str;
    if (paramAdDownloadInfo != null) {
      str = paramAdDownloadInfo.a();
    } else {
      str = null;
    }
    localStringBuilder.append(str);
    localStringBuilder.append(" view = ");
    if (paramRIJDownloadView != null) {
      paramRIJDownloadView = Integer.valueOf(paramRIJDownloadView.hashCode());
    } else {
      paramRIJDownloadView = null;
    }
    localStringBuilder.append(paramRIJDownloadView);
    localStringBuilder.append(" url = ");
    if (paramAdDownloadInfo != null) {
      paramRIJDownloadView = paramAdDownloadInfo.h();
    } else {
      paramRIJDownloadView = null;
    }
    localStringBuilder.append(paramRIJDownloadView);
    QLog.d("AD_DOWNLOAD_TAG", 1, localStringBuilder.toString());
    paramRIJDownloadView = localObject;
    if (paramAdDownloadInfo != null) {
      paramRIJDownloadView = paramAdDownloadInfo.h();
    }
    if (TextUtils.isEmpty((CharSequence)paramRIJDownloadView)) {
      paramRIJDownloadView = "replaceUrlFail";
    } else {
      paramRIJDownloadView = "replaceUrlSucc";
    }
    ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).reportBeacon(paramRIJDownloadView, paramAdDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler.OnReplaceUrl
 * JD-Core Version:    0.7.0.1
 */