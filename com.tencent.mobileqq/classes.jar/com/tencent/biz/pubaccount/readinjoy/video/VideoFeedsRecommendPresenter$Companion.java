package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter$Companion;", "", "()V", "SPEED_RATIO_1", "", "SPEED_RATIO_1_5", "SPEED_RATIO_2", "SPEED_RATIO_ARRAY", "", "getSPEED_RATIO_ARRAY", "()[F", "SPEED_RATIO_DRAWABLE_ID", "", "getSPEED_RATIO_DRAWABLE_ID", "()[I", "TAG", "", "isNeedReportAd", "", "playParam", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsRecommendPresenter$Companion
{
  private final boolean a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam != null) {}
    for (VideoInfo localVideoInfo = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo; (localVideoInfo != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null); localVideoInfo = null) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendPresenter.Companion
 * JD-Core Version:    0.7.0.1
 */