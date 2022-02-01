package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AEARCakePanel$8
  implements Animation.AnimationListener
{
  AEARCakePanel$8(AEARCakePanel paramAEARCakePanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.a != null)
    {
      this.a.a.setAlpha(1.0F);
      this.a.a.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel.8
 * JD-Core Version:    0.7.0.1
 */