package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.log.AEQLog;

class AEWaterMarkPanel$8
  implements Animation.AnimationListener
{
  AEWaterMarkPanel$8(AEWaterMarkPanel paramAEWaterMarkPanel, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AEWaterMarkPanel.b(this.b, false);
    paramAnimation = this.a;
    if (paramAnimation != null) {
      paramAnimation.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    AEWaterMarkPanel.b(this.b, true);
    if (this.b.a != null)
    {
      this.b.a.setAlpha(1.0F);
      this.b.a.setVisibility(0);
      AEBaseDataReporter.a().aB();
      this.b.a.a();
      return;
    }
    AEQLog.d("AEWaterMarkPanel", "[openWithAnimation] alpha - onAnimationStart, mContentView == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkPanel.8
 * JD-Core Version:    0.7.0.1
 */