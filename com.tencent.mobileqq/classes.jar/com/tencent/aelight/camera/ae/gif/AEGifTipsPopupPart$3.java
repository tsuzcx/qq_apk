package com.tencent.aelight.camera.ae.gif;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AEGifTipsPopupPart$3
  implements Animation.AnimationListener
{
  AEGifTipsPopupPart$3(AEGifTipsPopupPart paramAEGifTipsPopupPart, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.jdField_a_of_type_JavaLangRunnable;
    if (paramAnimation != null) {
      paramAnimation.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    AEGifTipsPopupPart.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifAEGifTipsPopupPart).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEGifTipsPopupPart.3
 * JD-Core Version:    0.7.0.1
 */