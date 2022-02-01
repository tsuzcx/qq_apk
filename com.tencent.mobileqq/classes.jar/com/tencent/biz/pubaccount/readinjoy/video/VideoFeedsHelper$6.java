package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class VideoFeedsHelper$6
  implements Animation.AnimationListener
{
  VideoFeedsHelper$6(View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.a.getTag(-1) != null) && (((Integer)this.a.getTag(-1)).intValue() == 8))
    {
      this.a.clearAnimation();
      this.a.setVisibility(8);
      this.a.setTag(-1, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper.6
 * JD-Core Version:    0.7.0.1
 */