package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.aelight.camera.log.AEQLog;

class AEARCakePanel$4
  implements Animation.AnimationListener
{
  AEARCakePanel$4(AEARCakePanel paramAEARCakePanel, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.b.b = false;
    paramAnimation = this.a;
    if (paramAnimation != null) {
      paramAnimation.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    paramAnimation = this.b;
    paramAnimation.b = true;
    if (paramAnimation.a != null)
    {
      this.b.a.setAlpha(1.0F);
      this.b.a.setVisibility(0);
      return;
    }
    AEQLog.d("AEARCakePanel", "[openWithAnimation] alpha - onAnimationStart, mContentView == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel.4
 * JD-Core Version:    0.7.0.1
 */