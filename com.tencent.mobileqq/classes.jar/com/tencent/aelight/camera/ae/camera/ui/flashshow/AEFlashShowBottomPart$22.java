package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AEFlashShowBottomPart$22
  implements Animation.AnimationListener
{
  AEFlashShowBottomPart$22(AEFlashShowBottomPart paramAEFlashShowBottomPart) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (AEFlashShowBottomPart.s(this.a) != null)
    {
      AEFlashShowBottomPart.s(this.a).setAlpha(1.0F);
      AEFlashShowBottomPart.s(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.22
 * JD-Core Version:    0.7.0.1
 */