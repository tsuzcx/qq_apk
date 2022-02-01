package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.view.View;
import android.view.animation.AlphaAnimation;

class VideoFilterViewPager$6
  implements Runnable
{
  VideoFilterViewPager$6(VideoFilterViewPager paramVideoFilterViewPager, View paramView) {}
  
  public void run()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(1000L);
    localAlphaAnimation.setFillAfter(true);
    this.a.startAnimation(localAlphaAnimation);
    localAlphaAnimation.setAnimationListener(new VideoFilterViewPager.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.6
 * JD-Core Version:    0.7.0.1
 */