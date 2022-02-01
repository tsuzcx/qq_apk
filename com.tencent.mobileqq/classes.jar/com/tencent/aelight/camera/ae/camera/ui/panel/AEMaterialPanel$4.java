package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.aelight.camera.log.AEQLog;

class AEMaterialPanel$4
  implements Animation.AnimationListener
{
  AEMaterialPanel$4(AEMaterialPanel paramAEMaterialPanel, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AEMaterialPanel.a(this.b, false);
    if (AEMaterialPanel.d(this.b) != null) {
      AEMaterialPanel.d(this.b).b();
    }
    paramAnimation = this.a;
    if (paramAnimation != null) {
      paramAnimation.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    AEMaterialPanel.a(this.b, true);
    if (AEMaterialPanel.c(this.b) != null)
    {
      AEMaterialPanel.c(this.b).setAlpha(1.0F);
      AEMaterialPanel.c(this.b).setVisibility(0);
      return;
    }
    AEQLog.d("AEMaterialPanel", "[openWithAnimation] alpha - onAnimationStart, mContentView == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel.4
 * JD-Core Version:    0.7.0.1
 */