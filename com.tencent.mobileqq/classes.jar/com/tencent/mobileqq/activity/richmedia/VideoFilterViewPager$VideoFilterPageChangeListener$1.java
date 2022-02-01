package com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import android.view.animation.AlphaAnimation;

class VideoFilterViewPager$VideoFilterPageChangeListener$1
  implements Runnable
{
  VideoFilterViewPager$VideoFilterPageChangeListener$1(VideoFilterViewPager.VideoFilterPageChangeListener paramVideoFilterPageChangeListener, int paramInt, View paramView) {}
  
  public void run()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(1000L);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new VideoFilterViewPager.AnimationProxy(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPageChangeListener.a, VideoFilterViewPager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$VideoFilterPageChangeListener.a), this.jdField_a_of_type_Int));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.VideoFilterPageChangeListener.1
 * JD-Core Version:    0.7.0.1
 */