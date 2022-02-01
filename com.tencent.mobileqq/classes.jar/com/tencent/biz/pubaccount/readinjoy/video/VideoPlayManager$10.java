package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.mobileqq.qroute.QRoute;

class VideoPlayManager$10
  implements Runnable
{
  VideoPlayManager$10(VideoPlayManager paramVideoPlayManager, VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoRecommendManager paramVideoRecommendManager, VideoPlayerWrapper paramVideoPlayerWrapper, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) {
      return;
    }
    Activity localActivity = VideoPlayManager.a(this.this$0);
    int j = 0;
    int i = j;
    if (localActivity != null)
    {
      i = j;
      if (localActivity.getIntent() != null) {
        i = localActivity.getIntent().getIntExtra("channel_from", -1);
      }
    }
    Object localObject = new VideoR5.Builder(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.k, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j).c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a).a((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long).e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_g_of_type_Long).c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_g_of_type_Int).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_Long).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager).d(VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.k)).g(VideoReporter.jdField_a_of_type_Int).e(VideoPlayManager.a(this.this$0)).c(VideoPlayManager.a(this.this$0)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.d).a(Boolean.valueOf(RIJFeedsType.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).z(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.m).A(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.n).B(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.k).C(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.l).N(i).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, false).i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID).W(RIJFeedsType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
    i = RIJItemViewType.a((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    String str2;
    if (6 == i)
    {
      ((VideoR5.Builder)localObject).aa(VideoFeedsHelper.f());
      str2 = ((VideoR5.Builder)localObject).a().a();
      if ((localActivity == null) || (localActivity.getIntent() == null)) {
        break label806;
      }
    }
    label784:
    label790:
    label798:
    label806:
    for (long l = localActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);; l = 0L)
    {
      localObject = new ReportInfo.VideoExtraRepoerData();
      ((ReportInfo.VideoExtraRepoerData)localObject).d = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.d);
      ((ReportInfo.VideoExtraRepoerData)localObject).e = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Int * 1000);
      label463:
      boolean bool;
      label501:
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
            break label784;
          }
          bool = true;
          ((ReportInfo.VideoExtraRepoerData)localObject).jdField_a_of_type_Boolean = bool;
        }
        VideoReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long, 12, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a, (ReportInfo.VideoExtraRepoerData)localObject);
        localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        str3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.k;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_Long != l) {
          break label790;
        }
        localObject = "1";
        label577:
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j)) {
          break label798;
        }
      }
      for (String str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j;; str1 = "0")
      {
        localIPublicAccountReportUtils.videoDataReportWithFansInfoInR5(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8007408", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.k, "", "", "", str2);
        VideoPlayManager.b(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a = 0L;
        VideoPlayManager.a(this.this$0, this.jdField_a_of_type_Boolean, localActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_Int);
        return;
        if (118 == i)
        {
          ((VideoR5.Builder)localObject).aa(VideoFeedsHelper.d());
          ((VideoR5.Builder)localObject).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo);
          break;
        }
        if (128 != i) {
          break;
        }
        ((VideoR5.Builder)localObject).aa(VideoFeedsHelper.h());
        ((VideoR5.Builder)localObject).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo);
        break;
        i = 2;
        break label463;
        bool = false;
        break label501;
        localObject = "2";
        break label577;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.10
 * JD-Core Version:    0.7.0.1
 */