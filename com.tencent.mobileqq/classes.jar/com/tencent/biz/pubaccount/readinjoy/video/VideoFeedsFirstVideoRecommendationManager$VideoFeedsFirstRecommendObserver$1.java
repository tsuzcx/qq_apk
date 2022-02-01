package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager;

class VideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1
  implements Runnable
{
  VideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1(VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver paramVideoFeedsFirstRecommendObserver, VideoFeedsFirstVideoRecommendationManager paramVideoFeedsFirstVideoRecommendationManager, VideoInfo paramVideoInfo) {}
  
  public void run()
  {
    VideoPreDownloadMgr localVideoPreDownloadMgr = VideoFeedsFirstVideoRecommendationManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager);
    if (localVideoPreDownloadMgr != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 1) {
        break label59;
      }
      if (!localVideoPreDownloadMgr.a(null, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString)) {
        localVideoPreDownloadMgr.a(null, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d);
      }
    }
    label59:
    while (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 2) {
      return;
    }
    ThirdVideoManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, new VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1.1(this, localVideoPreDownloadMgr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1
 * JD-Core Version:    0.7.0.1
 */