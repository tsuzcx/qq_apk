package com.tencent.aelight.camera.aioeditor.capture.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class QIMProviderContainerView$3
  implements Animation.AnimationListener
{
  QIMProviderContainerView$3(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QIMProviderContainerView.e(this.a) != null)
    {
      QIMProviderContainerView.e(this.a).setAlpha(1.0F);
      QIMProviderContainerView.e(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMProviderContainerView.3
 * JD-Core Version:    0.7.0.1
 */