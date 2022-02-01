package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;

class VideoView$7
  implements Animator.AnimatorListener
{
  VideoView$7(VideoView paramVideoView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (VideoView.access$600(this.a) != null) {
      VideoView.access$600(this.a).setVisibility(4);
    }
    if (VideoView.access$700(this.a) != null) {
      VideoView.access$700(this.a).setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.7
 * JD-Core Version:    0.7.0.1
 */