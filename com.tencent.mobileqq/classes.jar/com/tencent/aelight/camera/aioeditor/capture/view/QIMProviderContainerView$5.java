package com.tencent.aelight.camera.aioeditor.capture.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.aelight.camera.aioeditor.capture.AbsQIMCaptureController;

class QIMProviderContainerView$5
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QIMProviderContainerView.e(this.b) != null)
    {
      QIMProviderContainerView.e(this.b).setAlpha(1.0F);
      QIMProviderContainerView.e(this.b).setVisibility(8);
    }
    if ((!this.a) && (QIMProviderContainerView.b(this.b) != null)) {
      QIMProviderContainerView.b(this.b).a(false, 150);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMProviderContainerView.5
 * JD-Core Version:    0.7.0.1
 */