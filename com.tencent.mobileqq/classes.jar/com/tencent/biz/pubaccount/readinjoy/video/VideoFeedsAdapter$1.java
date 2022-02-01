package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver.OnDrawListener;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseVideoItemHolder;

class VideoFeedsAdapter$1
  implements ViewTreeObserver.OnDrawListener
{
  int jdField_a_of_type_Int = 0;
  
  VideoFeedsAdapter$1(VideoFeedsAdapter paramVideoFeedsAdapter, VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam) {}
  
  public void onDraw()
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().post(new VideoFeedsAdapter.1.1(this, this));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.1
 * JD-Core Version:    0.7.0.1
 */