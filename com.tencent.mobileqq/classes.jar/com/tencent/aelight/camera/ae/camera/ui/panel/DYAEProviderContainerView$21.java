package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.app.Activity;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;

class DYAEProviderContainerView$21
  implements Animation.AnimationListener
{
  DYAEProviderContainerView$21(DYAEProviderContainerView paramDYAEProviderContainerView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setAlpha(1.0F);
    this.a.setVisibility(8);
    if ((DYAEProviderContainerView.t(this.a) != null) && (!AECameraEntryManager.p(((Activity)this.a.getContext()).getIntent()))) {
      DYAEProviderContainerView.t(this.a).a(false, 150);
    }
    if (DYAEProviderContainerView.p(this.a) != null) {
      DYAEProviderContainerView.p(this.a).b(131075, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEProviderContainerView.21
 * JD-Core Version:    0.7.0.1
 */