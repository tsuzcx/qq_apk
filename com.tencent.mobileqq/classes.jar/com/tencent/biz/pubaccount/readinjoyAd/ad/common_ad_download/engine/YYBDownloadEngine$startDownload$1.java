package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine;

import android.text.TextUtils;
import bjju;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.AdDownloadScene;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadCallBack;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uev;
import uey;
import ufl;
import ukq;
import ule;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class YYBDownloadEngine$startDownload$1
  implements Runnable
{
  public YYBDownloadEngine$startDownload$1(RIJDownloadView paramRIJDownloadView, ule paramule) {}
  
  public final void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView == null) || (this.jdField_a_of_type_Ule == null)) {
      return;
    }
    uev localuev = new uev();
    localuev.a(this.jdField_a_of_type_Ule.d);
    localuev.c(this.jdField_a_of_type_Ule.jdField_a_of_type_JavaLangString);
    Object localObject;
    if (uey.a(uey.a, this.jdField_a_of_type_Ule))
    {
      localObject = this.jdField_a_of_type_Ule.b;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a() != AdDownloadScene.VideoFloatButton) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a() != AdDownloadScene.VideoFloatCardButton)) {
        break label302;
      }
    }
    for (;;)
    {
      try
      {
        localObject = URLEncoder.encode("{\"click_pos\":\"8\"}", "utf-8");
        Intrinsics.checkExpressionValueIsNotNull(localObject, "URLEncoder.encode(\"{\\\"cl…k_pos\\\":\\\"8\\\"}\", \"utf-8\")");
        localObject = this.jdField_a_of_type_Ule.b + "&gd=1&feeds_attachment=" + (String)localObject;
        this.jdField_a_of_type_Ule.c = ufl.a.a((String)localObject);
        ukq.a("AD_DOWNLOAD_TAG", "needReplaceUrl: pkg = " + this.jdField_a_of_type_Ule.d + "  url = " + this.jdField_a_of_type_Ule.c);
        localObject = AdDownloadCallBack.OnReplaceUrl;
        RIJDownloadView localRIJDownloadView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
        localuev.e(this.jdField_a_of_type_Ule.c);
        ((AdDownloadCallBack)localObject).doCallBack(localRIJDownloadView, localuev);
        if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_Ule.c)) {
          break;
        }
        localObject = AdDownloadCallBack.OnReplaceUrl;
        localRIJDownloadView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
        localuev.e("");
        ((AdDownloadCallBack)localObject).doCallBack(localRIJDownloadView, localuev);
        localObject = AdDownloadCallBack.OnErrorDownload;
        localRIJDownloadView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
        localuev.c(-1);
        localuev.b("url is empty");
        localuev.a(6);
        ((AdDownloadCallBack)localObject).doCallBack(localRIJDownloadView, localuev);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        str = "";
        continue;
      }
      label302:
      String str = this.jdField_a_of_type_Ule.b + "&gd=1";
    }
    if (this.jdField_a_of_type_Ule.jdField_a_of_type_Int == 4) {
      AdDownloadCallBack.OnResumeDownload.doCallBack(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, localuev);
    }
    for (;;)
    {
      ukq.a("AD_DOWNLOAD_TAG", "startDownload: pkg = " + this.jdField_a_of_type_Ule.d + "  url = " + this.jdField_a_of_type_Ule.c);
      bjju.a().a(null, uey.a(uey.a, this.jdField_a_of_type_Ule), "biz_src_feeds_kandianads", null, 0);
      return;
      AdDownloadCallBack.OnStartDownload.doCallBack(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, localuev);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.YYBDownloadEngine.startDownload.1
 * JD-Core Version:    0.7.0.1
 */