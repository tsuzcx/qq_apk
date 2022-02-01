package com.tencent.common.galleryactivity;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class GalleryPageView$1
  implements Animation.AnimationListener
{
  GalleryPageView$1(GalleryPageView paramGalleryPageView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (!this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene.d()) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.GalleryPageView.1
 * JD-Core Version:    0.7.0.1
 */