package com.tencent.biz.webviewplugin;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import com.tencent.image.URLImageView;

class PubAccountUIPlugin$4
  implements Animation.AnimationListener
{
  PubAccountUIPlugin$4(PubAccountUIPlugin paramPubAccountUIPlugin, URLImageView paramURLImageView, ScaleAnimation paramScaleAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PubAccountUIPlugin.4
 * JD-Core Version:    0.7.0.1
 */