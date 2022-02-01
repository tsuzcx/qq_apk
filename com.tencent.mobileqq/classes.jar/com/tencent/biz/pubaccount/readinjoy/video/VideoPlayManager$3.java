package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.mobileqq.qroute.QRoute;

class VideoPlayManager$3
  implements Runnable
{
  VideoPlayManager$3(VideoPlayManager paramVideoPlayManager, VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoRecommendManager paramVideoRecommendManager) {}
  
  public void run()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) {
      return;
    }
    int i;
    long l;
    if ((VideoPlayManager.a(this.this$0) != null) && (VideoPlayManager.a(this.this$0).getIntent() != null))
    {
      i = VideoPlayManager.a(this.this$0).getIntent().getIntExtra("channel_from", -1);
      l = VideoPlayManager.a(this.this$0).getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    }
    for (;;)
    {
      String str2 = new VideoR5.Builder(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.k, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j).c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a).a((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long).e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_g_of_type_Long).c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_g_of_type_Int).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_Long).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager).d(VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.k)).e(VideoPlayManager.a(this.this$0)).g(VideoReporter.a).c(VideoPlayManager.a(this.this$0)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Int * 1000).a(Boolean.valueOf(RIJFeedsType.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).z(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.m).A(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.n).B(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.k).C(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.l).N(i).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, true).aa(VideoFeedsHelper.f()).W(RIJFeedsType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)).a().a();
      Object localObject = new ReportInfo.VideoExtraRepoerData();
      ((ReportInfo.VideoExtraRepoerData)localObject).d = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Int * 1000);
      ((ReportInfo.VideoExtraRepoerData)localObject).e = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Int * 1000);
      label467:
      IPublicAccountReportUtils localIPublicAccountReportUtils;
      String str3;
      if (l == 0L)
      {
        i = 1;
        ((ReportInfo.VideoExtraRepoerData)localObject).c = i;
        if (VideoPlayManager.a(this.this$0) != null)
        {
          ((ReportInfo.VideoExtraRepoerData)localObject).b = true;
          if (VideoPlayManager.a(this.this$0).a()) {
            break label607;
          }
          ((ReportInfo.VideoExtraRepoerData)localObject).a = bool;
        }
        VideoReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long, 12, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a, (ReportInfo.VideoExtraRepoerData)localObject);
        localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        str3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.k;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_Long != l) {
          break label612;
        }
        localObject = "1";
        label540:
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j)) {
          break label620;
        }
      }
      label607:
      label612:
      label620:
      for (String str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j;; str1 = "0")
      {
        localIPublicAccountReportUtils.videoDataReportWithFansInfoInR5(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a = 0L;
        return;
        i = 2;
        break;
        bool = false;
        break label467;
        localObject = "2";
        break label540;
      }
      l = 0L;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.3
 * JD-Core Version:    0.7.0.1
 */