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
    String str = null;
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
    if (localObject != null)
    {
      localObject = ((RIJDownloadView)localObject).a();
      if (localObject != null)
      {
        localObject = ((ADVideoAppDownloadData)localObject).d;
        if (localObject != null)
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadDataAdDownloadInfo;
          if (localObject == null) {
            break label96;
          }
        }
      }
    }
    label96:
    for (localObject = ((AdDownloadInfo)localObject).a();; localObject = null)
    {
      ADVideoAppDownloadData localADVideoAppDownloadData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a();
      if (localADVideoAppDownloadData != null) {
        str = localADVideoAppDownloadData.d;
      }
      if (Intrinsics.areEqual(localObject, str))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.f();
        this.this$0.onCallBack(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadDataAdDownloadInfo);
      }
      return;
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler.doCallBack.1
 * JD-Core Version:    0.7.0.1
 */