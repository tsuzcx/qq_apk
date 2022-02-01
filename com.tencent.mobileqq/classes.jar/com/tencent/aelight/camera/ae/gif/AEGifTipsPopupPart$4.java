package com.tencent.aelight.camera.ae.gif;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AEGifTipsPopupPart$4
  implements Animation.AnimationListener
{
  AEGifTipsPopupPart$4(AEGifTipsPopupPart paramAEGifTipsPopupPart) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AEGifTipsPopupPart.b(this.a).setVisibility(8);
    AEGifTipsPopupPart.b(this.a).setAlpha(1.0F);
    AEGifTipsPopupPart.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEGifTipsPopupPart.4
 * JD-Core Version:    0.7.0.1
 */