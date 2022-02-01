package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.aelight.camera.log.AEQLog;

class AEFlashShowBottomPart$20
  implements Animation.AnimationListener
{
  AEFlashShowBottomPart$20(AEFlashShowBottomPart paramAEFlashShowBottomPart, Runnable paramRunnable) {}
  
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
    if (AEFlashShowBottomPart.s(paramAnimation) != null)
    {
      AEFlashShowBottomPart.s(this.b).setAlpha(1.0F);
      AEFlashShowBottomPart.s(this.b).setVisibility(0);
      return;
    }
    AEQLog.d("AEFlashShowBottomPart", "[openWithAnimation] alpha - onAnimationStart, mContentView == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.20
 * JD-Core Version:    0.7.0.1
 */