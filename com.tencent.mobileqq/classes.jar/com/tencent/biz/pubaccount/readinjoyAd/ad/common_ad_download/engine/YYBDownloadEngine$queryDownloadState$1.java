package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine;

import bjjq;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadCallBack;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.open.downloadnew.DownloadInfo;
import kotlin.Metadata;
import uev;
import uey;
import ufc;
import uff;
import ufg;
import ukq;
import ule;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class YYBDownloadEngine$queryDownloadState$1
  implements Runnable
{
  public YYBDownloadEngine$queryDownloadState$1(RIJDownloadView paramRIJDownloadView, ule paramule) {}
  
  public final void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView == null) || (this.jdField_a_of_type_Ule == null))
    {
      localObject2 = AdDownloadCallBack.OnQueryResult;
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      localObject4 = new uev();
      localObject1 = this.jdField_a_of_type_Ule;
      if (localObject1 != null) {}
      for (localObject1 = ((ule)localObject1).d;; localObject1 = null)
      {
        ((uev)localObject4).a((String)localObject1);
        ((uev)localObject4).a(0);
        ((uev)localObject4).b(0);
        ((AdDownloadCallBack)localObject2).doCallBack((RIJDownloadView)localObject3, (uev)localObject4);
        return;
      }
    }
    ukq.a("AD_DOWNLOAD_TAG", "queryDownloadState: pkg = " + this.jdField_a_of_type_Ule.d + "  url = " + this.jdField_a_of_type_Ule.c);
    Object localObject2 = new uev();
    ((uev)localObject2).a(this.jdField_a_of_type_Ule.d);
    ((uev)localObject2).c(this.jdField_a_of_type_Ule.a);
    if (ufg.a.a(this.jdField_a_of_type_Ule.d))
    {
      localObject1 = AdDownloadCallBack.OnQueryResult;
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      ((uev)localObject2).a(1);
      ((AdDownloadCallBack)localObject1).doCallBack((RIJDownloadView)localObject3, (uev)localObject2);
      return;
    }
    if (uey.a.a(this.jdField_a_of_type_Ule))
    {
      localObject1 = AdDownloadCallBack.OnQueryResult;
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      ((uev)localObject2).a(5);
      ((AdDownloadCallBack)localObject1).doCallBack((RIJDownloadView)localObject3, (uev)localObject2);
      return;
    }
    Object localObject1 = bjjq.a().b(this.jdField_a_of_type_Ule.c);
    if (localObject1 != null) {}
    while (localObject1 == null)
    {
      localObject1 = AdDownloadCallBack.OnQueryResult;
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      ((uev)localObject2).a(0);
      ((AdDownloadCallBack)localObject1).doCallBack((RIJDownloadView)localObject3, (uev)localObject2);
      return;
      localObject1 = bjjq.a().c(this.jdField_a_of_type_Ule.d);
    }
    Object localObject3 = AdDownloadCallBack.OnQueryResult;
    Object localObject4 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
    ((uev)localObject2).a(uff.a.a(((DownloadInfo)localObject1).a()));
    ((uev)localObject2).b(((DownloadInfo)localObject1).f);
    ((uev)localObject2).d(((DownloadInfo)localObject1).l);
    ufc.a((uev)localObject2);
    ((AdDownloadCallBack)localObject3).doCallBack((RIJDownloadView)localObject4, (uev)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.YYBDownloadEngine.queryDownloadState.1
 * JD-Core Version:    0.7.0.1
 */