package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine;

import bmqk;
import bmql;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadCallBack;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import java.util.ArrayList;
import kotlin.Metadata;
import uev;
import uey;
import ufg;
import ukq;
import ule;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class GameCenterDownloadEngine$queryDownloadState$1
  implements Runnable
{
  public GameCenterDownloadEngine$queryDownloadState$1(RIJDownloadView paramRIJDownloadView, ule paramule) {}
  
  public final void run()
  {
    AdDownloadCallBack localAdDownloadCallBack = null;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView == null) || (this.jdField_a_of_type_Ule == null)) {
      return;
    }
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(this.jdField_a_of_type_Ule.a);
    StringBuilder localStringBuilder = new StringBuilder().append("queryDownloadState: pkg = ");
    Object localObject1 = this.jdField_a_of_type_Ule;
    if (localObject1 != null) {}
    for (localObject1 = ((ule)localObject1).d;; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append("  url = ");
      ule localule = this.jdField_a_of_type_Ule;
      localObject1 = localAdDownloadCallBack;
      if (localule != null) {
        localObject1 = localule.c;
      }
      ukq.a("AD_DOWNLOAD_TAG", (String)localObject1);
      localObject1 = new uev();
      ((uev)localObject1).a(this.jdField_a_of_type_Ule.d);
      ((uev)localObject1).c(this.jdField_a_of_type_Ule.a);
      if (!ufg.a.a(this.jdField_a_of_type_Ule.d)) {
        break;
      }
      localAdDownloadCallBack = AdDownloadCallBack.OnQueryResult;
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      ((uev)localObject1).a(1);
      localAdDownloadCallBack.doCallBack((RIJDownloadView)localObject2, (uev)localObject1);
      return;
    }
    if (uey.a.a(this.jdField_a_of_type_Ule))
    {
      localAdDownloadCallBack = AdDownloadCallBack.OnQueryResult;
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      ((uev)localObject1).a(5);
      localAdDownloadCallBack.doCallBack((RIJDownloadView)localObject2, (uev)localObject1);
      return;
    }
    bmqk.a().a((ArrayList)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.GameCenterDownloadEngine.queryDownloadState.1
 * JD-Core Version:    0.7.0.1
 */