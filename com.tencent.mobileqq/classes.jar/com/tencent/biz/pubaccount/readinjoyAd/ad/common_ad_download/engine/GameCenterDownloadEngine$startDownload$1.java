package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine;

import bmqk;
import bmql;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadCallBack;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import cooperation.wadl.ipc.WadlParams;
import kotlin.Metadata;
import uev;
import uew;
import ukq;
import ule;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class GameCenterDownloadEngine$startDownload$1
  implements Runnable
{
  public GameCenterDownloadEngine$startDownload$1(RIJDownloadView paramRIJDownloadView, ule paramule) {}
  
  public final void run()
  {
    AdDownloadCallBack localAdDownloadCallBack = null;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView == null) || (this.jdField_a_of_type_Ule == null)) {
      return;
    }
    Object localObject2 = uew.a(uew.a, this.jdField_a_of_type_Ule);
    Object localObject1 = new uev();
    ((uev)localObject1).a(this.jdField_a_of_type_Ule.d);
    ((uev)localObject1).c(this.jdField_a_of_type_Ule.jdField_a_of_type_JavaLangString);
    if (localObject2 == null)
    {
      localAdDownloadCallBack = AdDownloadCallBack.OnErrorDownload;
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      ((uev)localObject1).c(-1);
      ((uev)localObject1).b("wadlParams is empty");
      ((uev)localObject1).a(6);
      localAdDownloadCallBack.doCallBack((RIJDownloadView)localObject2, (uev)localObject1);
      return;
    }
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_Ule.jdField_a_of_type_Int == 4)
    {
      AdDownloadCallBack.OnResumeDownload.doCallBack(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, (uev)localObject1);
      localStringBuilder = new StringBuilder().append("startDownload: pkg = ");
      localObject1 = this.jdField_a_of_type_Ule;
      if (localObject1 == null) {
        break label213;
      }
    }
    label213:
    for (localObject1 = ((ule)localObject1).d;; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append("  url = ");
      ule localule = this.jdField_a_of_type_Ule;
      localObject1 = localAdDownloadCallBack;
      if (localule != null) {
        localObject1 = localule.c;
      }
      ukq.a("AD_DOWNLOAD_TAG", (String)localObject1);
      bmqk.a().a((WadlParams)localObject2);
      return;
      AdDownloadCallBack.OnStartDownload.doCallBack(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, (uev)localObject1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.GameCenterDownloadEngine.startDownload.1
 * JD-Core Version:    0.7.0.1
 */