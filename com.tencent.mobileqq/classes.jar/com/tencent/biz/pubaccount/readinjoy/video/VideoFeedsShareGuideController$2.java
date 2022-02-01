package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class VideoFeedsShareGuideController$2
  implements Animation.AnimationListener
{
  VideoFeedsShareGuideController$2(VideoFeedsShareGuideController paramVideoFeedsShareGuideController) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VideoFeedsShareGuideController.a(this.a).startAnimation(VideoFeedsShareGuideController.a(this.a));
    VideoFeedsShareGuideController.a(this.a).sendEmptyMessageDelayed(1, 300L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareGuideController.2
 * JD-Core Version:    0.7.0.1
 */