package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uev;
import ule;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AdDownloadCallBack$doCallBack$1
  implements Runnable
{
  AdDownloadCallBack$doCallBack$1(AdDownloadCallBack paramAdDownloadCallBack, RIJDownloadView paramRIJDownloadView, uev paramuev) {}
  
  public final void run()
  {
    String str = null;
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
    if (localObject != null)
    {
      localObject = ((RIJDownloadView)localObject).a();
      if (localObject != null)
      {
        localObject = ((ule)localObject).d;
        if (localObject != null)
        {
          localObject = this.jdField_a_of_type_Uev;
          if (localObject == null) {
            break label96;
          }
        }
      }
    }
    label96:
    for (localObject = ((uev)localObject).a();; localObject = null)
    {
      ule localule = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a();
      if (localule != null) {
        str = localule.d;
      }
      if (Intrinsics.areEqual(localObject, str))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.f();
        this.this$0.onCallBack(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, this.jdField_a_of_type_Uev);
      }
      return;
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadCallBack.doCallBack.1
 * JD-Core Version:    0.7.0.1
 */