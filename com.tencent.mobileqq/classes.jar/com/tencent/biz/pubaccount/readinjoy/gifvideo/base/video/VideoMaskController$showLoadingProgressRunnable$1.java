package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VideoMaskController$showLoadingProgressRunnable$1
  implements Runnable
{
  VideoMaskController$showLoadingProgressRunnable$1(VideoMaskController paramVideoMaskController) {}
  
  public final void run()
  {
    this.this$0.a().clearAnimation();
    this.this$0.a().setVisibility(0);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(1000L);
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setRepeatMode(1);
    localRotateAnimation.setStartTime(-1);
    localRotateAnimation.setInterpolator((Interpolator)new LinearInterpolator());
    this.this$0.a().setBackgroundResource(2130843457);
    this.this$0.a().startAnimation((Animation)localRotateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoMaskController.showLoadingProgressRunnable.1
 * JD-Core Version:    0.7.0.1
 */