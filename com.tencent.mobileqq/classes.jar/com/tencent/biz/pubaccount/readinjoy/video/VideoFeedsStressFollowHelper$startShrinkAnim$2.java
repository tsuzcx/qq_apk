package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsStressFollowHelper$startShrinkAnim$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsStressFollowHelper$startShrinkAnim$2
  implements Animator.AnimatorListener
{
  public void onAnimationCancel(@Nullable Animator paramAnimator) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    VideoFeedsStressFollowHelper.a(this.a, false);
    this.a.a().setStressState(VideoFeedsStressFollowLayout.StressState.Shrink);
  }
  
  public void onAnimationRepeat(@Nullable Animator paramAnimator) {}
  
  public void onAnimationStart(@Nullable Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStressFollowHelper.startShrinkAnim.2
 * JD-Core Version:    0.7.0.1
 */