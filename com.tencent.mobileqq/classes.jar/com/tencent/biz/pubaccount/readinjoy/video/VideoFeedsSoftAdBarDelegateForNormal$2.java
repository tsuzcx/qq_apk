package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;

class VideoFeedsSoftAdBarDelegateForNormal$2
  extends AnimatorListenerAdapter
{
  VideoFeedsSoftAdBarDelegateForNormal$2(VideoFeedsSoftAdBarDelegateForNormal paramVideoFeedsSoftAdBarDelegateForNormal, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (VideoFeedsSoftAdBarDelegateForNormal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal).v != null) {
      VideoFeedsSoftAdBarDelegateForNormal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal).v.setTag(2131362698, null);
    }
    paramAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal;
    paramAnimator.b(VideoFeedsSoftAdBarDelegateForNormal.a(paramAnimator));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    paramAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.a();
    VideoFeedsSoftAdBarDelegateForNormal localVideoFeedsSoftAdBarDelegateForNormal = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal;
    VideoFeedsSoftAdBarDelegateForNormal.a(localVideoFeedsSoftAdBarDelegateForNormal, VideoFeedsSoftAdBarDelegateForNormal.a(localVideoFeedsSoftAdBarDelegateForNormal).g, paramAnimator, this.jdField_a_of_type_Int, 18, -1);
    if (VideoFeedsSoftAdBarDelegateForNormal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal).v != null) {
      VideoFeedsSoftAdBarDelegateForNormal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal).v.setTag(2131362698, null);
    }
    paramAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal;
    paramAnimator.c(VideoFeedsSoftAdBarDelegateForNormal.a(paramAnimator));
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    paramAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal;
    paramAnimator.a(VideoFeedsSoftAdBarDelegateForNormal.a(paramAnimator));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarDelegateForNormal.2
 * JD-Core Version:    0.7.0.1
 */