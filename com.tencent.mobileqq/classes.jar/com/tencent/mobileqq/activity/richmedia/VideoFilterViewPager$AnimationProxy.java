package com.tencent.mobileqq.activity.richmedia;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;

public class VideoFilterViewPager$AnimationProxy
  implements Animation.AnimationListener
{
  private int jdField_a_of_type_Int;
  private VideoFilterViewPager.OnViewPagerItemVisiableChangeListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$OnViewPagerItemVisiableChangeListener;
  
  public VideoFilterViewPager$AnimationProxy(VideoFilterViewPager paramVideoFilterViewPager, VideoFilterViewPager.OnViewPagerItemVisiableChangeListener paramOnViewPagerItemVisiableChangeListener, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$OnViewPagerItemVisiableChangeListener = paramOnViewPagerItemVisiableChangeListener;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$OnViewPagerItemVisiableChangeListener != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.getCurrentItem() == this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$OnViewPagerItemVisiableChangeListener.a(1);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "OnViewPagerItemVisiableChangeListener animation dismiss state: 1");
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.AnimationProxy
 * JD-Core Version:    0.7.0.1
 */