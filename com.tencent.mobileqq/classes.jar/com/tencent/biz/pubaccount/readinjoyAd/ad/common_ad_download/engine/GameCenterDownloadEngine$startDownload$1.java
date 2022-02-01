package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GameCenterDownloadEngine$startDownload$1
  implements Runnable
{
  public final void run()
  {
    AdDownloadStateHandler localAdDownloadStateHandler = null;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData == null)) {
      return;
    }
    Object localObject2 = GameCenterDownloadEngine.a(GameCenterDownloadEngine.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
    Object localObject1 = new AdDownloadInfo();
    ((AdDownloadInfo)localObject1).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d);
    ((AdDownloadInfo)localObject1).c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.jdField_a_of_type_JavaLangString);
    if (localObject2 == null)
    {
      localAdDownloadStateHandler = AdDownloadStateHandler.OnErrorDownload;
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      ((AdDownloadInfo)localObject1).c(-1);
      ((AdDownloadInfo)localObject1).b("wadlParams is empty");
      ((AdDownloadInfo)localObject1).a(6);
      localAdDownloadStateHandler.doCallBack((RIJDownloadView)localObject2, (AdDownloadInfo)localObject1);
      return;
    }
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.jdField_a_of_type_Int == 4)
    {
      AdDownloadStateHandler.OnResumeDownload.doCallBack(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, (AdDownloadInfo)localObject1);
      localStringBuilder = new StringBuilder().append("startDownload: pkg = ");
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      if (localObject1 == null) {
        break label213;
      }
    }
    label213:
    for (localObject1 = ((ADVideoAppDownloadData)localObject1).d;; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append("  url = ");
      ADVideoAppDownloadData localADVideoAppDownloadData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      localObject1 = localAdDownloadStateHandler;
      if (localADVideoAppDownloadData != null) {
        localObject1 = localADVideoAppDownloadData.c;
      }
      ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", (String)localObject1);
      WadlProxyServiceUtil.a().b((WadlParams)localObject2);
      return;
      AdDownloadStateHandler.OnStartDownload.doCallBack(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, (AdDownloadInfo)localObject1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.GameCenterDownloadEngine.startDownload.1
 * JD-Core Version:    0.7.0.1
 */