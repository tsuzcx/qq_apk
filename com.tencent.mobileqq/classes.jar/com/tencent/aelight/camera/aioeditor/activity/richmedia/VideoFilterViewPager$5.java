package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.view.View;
import android.view.animation.AlphaAnimation;

class VideoFilterViewPager$5
  implements Runnable
{
  VideoFilterViewPager$5(VideoFilterViewPager paramVideoFilterViewPager, View paramView) {}
  
  public void run()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(1000L);
    localAlphaAnimation.setFillAfter(true);
    this.a.startAnimation(localAlphaAnimation);
    localAlphaAnimation.setAnimationListener(new VideoFilterViewPager.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.5
 * JD-Core Version:    0.7.0.1
 */