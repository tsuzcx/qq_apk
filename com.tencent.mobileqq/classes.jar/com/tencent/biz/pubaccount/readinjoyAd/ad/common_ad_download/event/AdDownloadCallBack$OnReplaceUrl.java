package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import uev;
import ufd;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadCallBack$OnReplaceUrl;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadCallBack;", "onCallBack", "", "viewRIJ", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "info", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class AdDownloadCallBack$OnReplaceUrl
  extends AdDownloadCallBack
{
  AdDownloadCallBack$OnReplaceUrl()
  {
    super(str, i, null);
  }
  
  protected void onCallBack(@Nullable RIJDownloadView paramRIJDownloadView, @Nullable uev paramuev)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("OnReplaceUrl: ");
    Object localObject;
    if (paramuev != null)
    {
      localObject = paramuev.a();
      localObject = localStringBuilder.append((String)localObject).append(" view = ");
      if (paramRIJDownloadView == null) {
        break label117;
      }
      paramRIJDownloadView = Integer.valueOf(paramRIJDownloadView.hashCode());
      label47:
      localObject = ((StringBuilder)localObject).append(paramRIJDownloadView).append(" url = ");
      if (paramuev == null) {
        break label122;
      }
      paramRIJDownloadView = paramuev.e();
      label67:
      QLog.d("AD_DOWNLOAD_TAG", 1, paramRIJDownloadView);
      if (paramuev == null) {
        break label127;
      }
      paramRIJDownloadView = paramuev.e();
      label90:
      if (!TextUtils.isEmpty((CharSequence)paramRIJDownloadView)) {
        break label132;
      }
    }
    label132:
    for (paramRIJDownloadView = "replaceUrlFail";; paramRIJDownloadView = "replaceUrlSucc")
    {
      ufd.a.a(paramRIJDownloadView, paramuev);
      return;
      localObject = null;
      break;
      label117:
      paramRIJDownloadView = null;
      break label47;
      label122:
      paramRIJDownloadView = null;
      break label67;
      label127:
      paramRIJDownloadView = null;
      break label90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadCallBack.OnReplaceUrl
 * JD-Core Version:    0.7.0.1
 */