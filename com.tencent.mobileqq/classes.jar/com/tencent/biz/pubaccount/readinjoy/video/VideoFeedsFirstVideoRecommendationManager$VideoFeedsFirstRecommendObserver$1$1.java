package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.VideoUrlInfo;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  VideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1$1(VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1 param1, VideoPreDownloadMgr paramVideoPreDownloadMgr) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoFeedsFirstVideoRecommendationManager.a(), 2, "UUIDToUrlCallback Callback vid=" + paramVideoUrlInfo.jdField_b_of_type_JavaLangString + ", url=" + paramVideoUrlInfo.jdField_a_of_type_JavaLangString + ", isH265=" + paramVideoUrlInfo.jdField_a_of_type_Boolean + ", isHWCodec=" + paramVideoUrlInfo.jdField_b_of_type_Boolean + ", fileBitRate=" + paramVideoUrlInfo.c);
    }
    if ((!TextUtils.isEmpty(paramVideoUrlInfo.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramVideoUrlInfo.jdField_a_of_type_JavaLangString, paramVideoUrlInfo.jdField_b_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramVideoUrlInfo.jdField_a_of_type_JavaLangString, paramVideoUrlInfo.jdField_b_of_type_JavaLangString, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1.1
 * JD-Core Version:    0.7.0.1
 */