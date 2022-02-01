package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.AdDownloadScene;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdUrlChangeUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.open.appstore.dl.DownloadProxy;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class YYBDownloadEngine$startDownload$1
  implements Runnable
{
  public final void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData == null) {
        return;
      }
      AdDownloadInfo localAdDownloadInfo = new AdDownloadInfo();
      localAdDownloadInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d);
      localAdDownloadInfo.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.jdField_a_of_type_JavaLangString);
      Object localObject2;
      if (YYBDownloadEngine.a(YYBDownloadEngine.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData))
      {
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
        RIJAdUrlChangeUtil localRIJAdUrlChangeUtil = RIJAdUrlChangeUtil.a;
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
        if (localObject1 != null) {
          localObject1 = ((RIJDownloadView)localObject1).a();
        } else {
          localObject1 = null;
        }
        ((ADVideoAppDownloadData)localObject2).c = localRIJAdUrlChangeUtil.a((AdDownloadScene)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.b);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("needReplaceUrl: pkg = ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d);
        ((StringBuilder)localObject1).append("  url = ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.c);
        ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", ((StringBuilder)localObject1).toString());
        localObject1 = AdDownloadStateHandler.OnReplaceUrl;
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
        localAdDownloadInfo.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.c);
        ((AdDownloadStateHandler)localObject1).doCallBack((RIJDownloadView)localObject2, localAdDownloadInfo);
      }
      if (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.c))
      {
        localObject1 = AdDownloadStateHandler.OnReplaceUrl;
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
        localAdDownloadInfo.e("");
        ((AdDownloadStateHandler)localObject1).doCallBack((RIJDownloadView)localObject2, localAdDownloadInfo);
        localObject1 = AdDownloadStateHandler.OnErrorDownload;
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
        localAdDownloadInfo.c(-1);
        localAdDownloadInfo.b("url is empty");
        localAdDownloadInfo.a(6);
        ((AdDownloadStateHandler)localObject1).doCallBack((RIJDownloadView)localObject2, localAdDownloadInfo);
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.jdField_a_of_type_Int == 4) {
        AdDownloadStateHandler.OnResumeDownload.doCallBack(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, localAdDownloadInfo);
      } else {
        AdDownloadStateHandler.OnStartDownload.doCallBack(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, localAdDownloadInfo);
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startDownload: pkg = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d);
      ((StringBuilder)localObject1).append("  url = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.c);
      ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", ((StringBuilder)localObject1).toString());
      DownloadProxy.a().a(null, YYBDownloadEngine.a(YYBDownloadEngine.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData), "biz_src_feeds_kandianads", null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.YYBDownloadEngine.startDownload.1
 * JD-Core Version:    0.7.0.1
 */