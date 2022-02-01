package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GameCenterDownloadEngine$queryDownloadState$1
  implements Runnable
{
  GameCenterDownloadEngine$queryDownloadState$1(RIJDownloadView paramRIJDownloadView, ADVideoAppDownloadData paramADVideoAppDownloadData) {}
  
  public final void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData == null) {
        return;
      }
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryDownloadState: pkg = ");
      Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      AdDownloadStateHandler localAdDownloadStateHandler = null;
      if (localObject1 != null) {
        localObject1 = ((ADVideoAppDownloadData)localObject1).d;
      } else {
        localObject1 = null;
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("  url = ");
      ADVideoAppDownloadData localADVideoAppDownloadData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      localObject1 = localAdDownloadStateHandler;
      if (localADVideoAppDownloadData != null) {
        localObject1 = localADVideoAppDownloadData.c;
      }
      localStringBuilder.append((String)localObject1);
      ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", localStringBuilder.toString());
      localObject1 = new AdDownloadInfo();
      ((AdDownloadInfo)localObject1).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d);
      ((AdDownloadInfo)localObject1).c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.a);
      if (RIJAdDownloadUtil.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d))
      {
        localAdDownloadStateHandler = AdDownloadStateHandler.OnQueryResult;
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
        ((AdDownloadInfo)localObject1).a(1);
        localAdDownloadStateHandler.doCallBack((RIJDownloadView)localObject2, (AdDownloadInfo)localObject1);
        return;
      }
      if (YYBDownloadEngine.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData))
      {
        localAdDownloadStateHandler = AdDownloadStateHandler.OnQueryResult;
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
        ((AdDownloadInfo)localObject1).a(5);
        localAdDownloadStateHandler.doCallBack((RIJDownloadView)localObject2, (AdDownloadInfo)localObject1);
        return;
      }
      WadlProxyServiceUtil.a().a((ArrayList)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.GameCenterDownloadEngine.queryDownloadState.1
 * JD-Core Version:    0.7.0.1
 */