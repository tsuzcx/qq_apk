package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseVideoItemHolder;

class VideoFeedsAdapter$13
  implements Runnable
{
  VideoFeedsAdapter$13(VideoFeedsAdapter paramVideoFeedsAdapter, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder != null) && (this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.a != null)) {
      this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.a.i(this.a);
    }
    if ((this.a) && (!this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d()) && (VideoFeedsAdapter.a(this.this$0) != null)) {
      VideoFeedsAdapter.a(this.this$0).b();
    }
    while ((this.a) || (!VideoFeedsHelper.b())) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.13
 * JD-Core Version:    0.7.0.1
 */