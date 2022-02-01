package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.QualityReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;

class VideoPlayManager$5
  implements Runnable
{
  VideoPlayManager$5(VideoPlayManager paramVideoPlayManager, int paramInt1, int paramInt2, String paramString, VideoPlayerWrapper paramVideoPlayerWrapper) {}
  
  public void run()
  {
    if (VideoPlayManager.a(this.this$0) != null)
    {
      int i = this.jdField_a_of_type_Int;
      int j = this.b;
      VideoPlayManager.a(this.this$0, VideoPlayManager.a(this.this$0), VideoPlayManager.a(this.this$0), 6, new int[] { i, j });
      VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_JavaLangString = (this.jdField_a_of_type_Int + ":" + this.b);
      VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = 0L;
      VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = false;
      VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.n = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c();
      VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.g = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.e();
      VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.h = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.f();
      VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.jdField_b_of_type_Boolean;
      VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.q = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.jdField_b_of_type_Long;
      VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.p = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.jdField_a_of_type_Long;
      VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.r = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.g();
      VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.p();
      VideoPlayManager.a(this.this$0, VideoPlayManager.a(this.this$0));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.b());
      RIJStatisticCollectorReport.a(VideoPlayManager.a(this.this$0).getApplicationContext(), ReadInJoyUtils.a(), false, VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a());
      QualityReporter.a(VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData);
      RIJStatisticCollectorReport.a(false, VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Boolean, VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.h, VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Int, VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long, 56, VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_JavaLangString, VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_JavaLangString);
      BaseArticleInfo localBaseArticleInfo = VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (ReadInJoyAdUtils.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && (VideoPlayManager.a(this.this$0).jdField_b_of_type_Boolean))
      {
        i = (int)VideoPlayManager.a(this.this$0).a(true);
        NativeAdUtils.a(new AdReportData().a(VideoPlayManager.a(this.this$0)).a(6).b(11).a((AdvertisementInfo)localBaseArticleInfo).a(NativeAdUtils.a(0, i, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration * 1000, 1, 2, 0, ReportConstants.VideoEndType.OTHER)));
      }
      localBaseArticleInfo = VideoPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))) {
        NativeAdUtils.a(new AdReportData().a(VideoPlayManager.a(this.this$0)).a(6).b(4).a((AdvertisementInfo)localBaseArticleInfo).a(NativeAdUtils.a(0, 0, 0, 0, 0, 0, localBaseArticleInfo.mVideoDuration * 1000, 9, 2, 0, ReportConstants.VideoEndType.OTHER)));
      }
    }
    VideoPlayManager.a(this.this$0, null);
    VideoPlayManager.a(this.this$0, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.5
 * JD-Core Version:    0.7.0.1
 */