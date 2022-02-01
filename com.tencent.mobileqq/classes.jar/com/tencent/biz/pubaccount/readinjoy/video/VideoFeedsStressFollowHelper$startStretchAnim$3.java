package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsStressFollowHelper$startStretchAnim$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsStressFollowHelper$startStretchAnim$3
  implements Animator.AnimatorListener
{
  VideoFeedsStressFollowHelper$startStretchAnim$3(Animator.AnimatorListener paramAnimatorListener) {}
  
  public void onAnimationCancel(@Nullable Animator paramAnimator)
  {
    Animator.AnimatorListener localAnimatorListener = this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationCancel(paramAnimator);
    }
  }
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    VideoFeedsStressFollowHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowHelper, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowHelper.a().setStressState(VideoFeedsStressFollowLayout.StressState.Stretched);
    Animator.AnimatorListener localAnimatorListener = this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationEnd(paramAnimator);
    }
  }
  
  public void onAnimationRepeat(@Nullable Animator paramAnimator)
  {
    Animator.AnimatorListener localAnimatorListener = this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationRepeat(paramAnimator);
    }
  }
  
  public void onAnimationStart(@Nullable Animator paramAnimator)
  {
    Animator.AnimatorListener localAnimatorListener = this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationStart(paramAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStressFollowHelper.startStretchAnim.3
 * JD-Core Version:    0.7.0.1
 */