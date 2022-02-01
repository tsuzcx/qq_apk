package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter$onVideoStop$1$1"}, k=3, mv={1, 1, 16})
final class VideoFeedsRecommendPresenter$onVideoStop$$inlined$let$lambda$1
  implements Runnable
{
  VideoFeedsRecommendPresenter$onVideoStop$$inlined$let$lambda$1(VideoInfo paramVideoInfo, VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter, List paramList, VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, long paramLong, int paramInt, boolean paramBoolean) {}
  
  public final void run()
  {
    VideoFeedsReporter localVideoFeedsReporter = this.this$0.a();
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    List localList = this.jdField_a_of_type_JavaUtilList;
    ReadinjoyVideoReportData localReadinjoyVideoReportData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a;
    Intrinsics.checkExpressionValueIsNotNull(localReadinjoyVideoReportData, "playParam.reportData");
    localVideoFeedsReporter.a(localVideoInfo, localList, localReadinjoyVideoReportData, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendPresenter.onVideoStop..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */