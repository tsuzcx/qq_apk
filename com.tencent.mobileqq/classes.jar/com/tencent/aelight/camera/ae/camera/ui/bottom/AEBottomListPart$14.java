package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AEBottomListPart$14
  implements Animation.AnimationListener
{
  AEBottomListPart$14(AEBottomListPart paramAEBottomListPart) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((this.a.b != null) && (AEBottomListPart.j(this.a)))
    {
      this.a.b.setAlpha(1.0F);
      this.a.b.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.14
 * JD-Core Version:    0.7.0.1
 */