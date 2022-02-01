package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadStateUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class YYBDownloadEngine$queryDownloadState$1
  implements Runnable
{
  YYBDownloadEngine$queryDownloadState$1(RIJDownloadView paramRIJDownloadView, ADVideoAppDownloadData paramADVideoAppDownloadData) {}
  
  public final void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData == null))
    {
      localObject2 = AdDownloadStateHandler.OnQueryResult;
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      localObject4 = new AdDownloadInfo();
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      if (localObject1 != null) {}
      for (localObject1 = ((ADVideoAppDownloadData)localObject1).d;; localObject1 = null)
      {
        ((AdDownloadInfo)localObject4).a((String)localObject1);
        ((AdDownloadInfo)localObject4).a(0);
        ((AdDownloadInfo)localObject4).b(0);
        ((AdDownloadStateHandler)localObject2).doCallBack((RIJDownloadView)localObject3, (AdDownloadInfo)localObject4);
        return;
      }
    }
    ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", "queryDownloadState: pkg = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d + "  url = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.c);
    Object localObject2 = new AdDownloadInfo();
    ((AdDownloadInfo)localObject2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d);
    ((AdDownloadInfo)localObject2).c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.a);
    if (RIJAdDownloadUtil.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d))
    {
      localObject1 = AdDownloadStateHandler.OnQueryResult;
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      ((AdDownloadInfo)localObject2).a(1);
      ((AdDownloadStateHandler)localObject1).doCallBack((RIJDownloadView)localObject3, (AdDownloadInfo)localObject2);
      return;
    }
    if (YYBDownloadEngine.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData))
    {
      localObject1 = AdDownloadStateHandler.OnQueryResult;
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      ((AdDownloadInfo)localObject2).a(5);
      ((AdDownloadStateHandler)localObject1).doCallBack((RIJDownloadView)localObject3, (AdDownloadInfo)localObject2);
      return;
    }
    Object localObject1 = DownloadManagerV2.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.c);
    if (localObject1 != null) {}
    while (localObject1 == null)
    {
      localObject1 = AdDownloadStateHandler.OnQueryResult;
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      ((AdDownloadInfo)localObject2).a(0);
      ((AdDownloadStateHandler)localObject1).doCallBack((RIJDownloadView)localObject3, (AdDownloadInfo)localObject2);
      return;
      localObject1 = DownloadManagerV2.a().c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d);
    }
    Object localObject3 = AdDownloadStateHandler.OnQueryResult;
    Object localObject4 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
    ((AdDownloadInfo)localObject2).a(RIJAdDownloadStateUtil.a.a(((DownloadInfo)localObject1).a()));
    ((AdDownloadInfo)localObject2).b(((DownloadInfo)localObject1).f);
    ((AdDownloadInfo)localObject2).d(((DownloadInfo)localObject1).l);
    RIJAdDownloadExKt.a((AdDownloadInfo)localObject2);
    ((AdDownloadStateHandler)localObject3).doCallBack((RIJDownloadView)localObject4, (AdDownloadInfo)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.YYBDownloadEngine.queryDownloadState.1
 * JD-Core Version:    0.7.0.1
 */