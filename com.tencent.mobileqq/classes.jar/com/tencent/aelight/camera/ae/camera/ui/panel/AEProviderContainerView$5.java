package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;

class AEProviderContainerView$5
  implements Animation.AnimationListener
{
  AEProviderContainerView$5(AEProviderContainerView paramAEProviderContainerView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setAlpha(1.0F);
    this.a.setVisibility(8);
    if (AEProviderContainerView.a(this.a) != null) {
      AEProviderContainerView.a(this.a).a(false, 150);
    }
    if (AEProviderContainerView.a(this.a) != null) {
      AEProviderContainerView.a(this.a).a(131075, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderContainerView.5
 * JD-Core Version:    0.7.0.1
 */