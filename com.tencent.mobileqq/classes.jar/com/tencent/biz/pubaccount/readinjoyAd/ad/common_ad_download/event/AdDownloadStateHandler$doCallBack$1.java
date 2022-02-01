package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AdDownloadStateHandler$doCallBack$1
  implements Runnable
{
  AdDownloadStateHandler$doCallBack$1(AdDownloadStateHandler paramAdDownloadStateHandler, RIJDownloadView paramRIJDownloadView, AdDownloadInfo paramAdDownloadInfo) {}
  
  public final void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
    String str = null;
    if (localObject != null)
    {
      localObject = ((RIJDownloadView)localObject).a();
      if (localObject != null)
      {
        localObject = ((ADVideoAppDownloadData)localObject).d;
        break label30;
      }
    }
    localObject = null;
    label30:
    if (localObject != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadDataAdDownloadInfo;
      if (localObject != null) {
        localObject = ((AdDownloadInfo)localObject).a();
      } else {
        localObject = null;
      }
      ADVideoAppDownloadData localADVideoAppDownloadData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a();
      if (localADVideoAppDownloadData != null) {
        str = localADVideoAppDownloadData.d;
      }
      if (Intrinsics.areEqual(localObject, str))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.f();
        this.this$0.onCallBack(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadDataAdDownloadInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler.doCallBack.1
 * JD-Core Version:    0.7.0.1
 */