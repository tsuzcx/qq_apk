package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;

class VideoFeedsSoftAdBarDelegateForNormal$2
  extends AnimatorListenerAdapter
{
  VideoFeedsSoftAdBarDelegateForNormal$2(VideoFeedsSoftAdBarDelegateForNormal paramVideoFeedsSoftAdBarDelegateForNormal, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (VideoFeedsSoftAdBarDelegateForNormal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal).v != null) {
      VideoFeedsSoftAdBarDelegateForNormal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal).v.setTag(2131362743, null);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.b(VideoFeedsSoftAdBarDelegateForNormal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    paramAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.a();
    VideoFeedsSoftAdBarDelegateForNormal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal, VideoFeedsSoftAdBarDelegateForNormal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal).g, paramAnimator, this.jdField_a_of_type_Int, 18, -1);
    if (VideoFeedsSoftAdBarDelegateForNormal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal).v != null) {
      VideoFeedsSoftAdBarDelegateForNormal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal).v.setTag(2131362743, null);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.c(VideoFeedsSoftAdBarDelegateForNormal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal));
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.a(VideoFeedsSoftAdBarDelegateForNormal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarDelegateForNormal.2
 * JD-Core Version:    0.7.0.1
 */