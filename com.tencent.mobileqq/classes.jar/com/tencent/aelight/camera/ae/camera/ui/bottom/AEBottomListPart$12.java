package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;

class AEBottomListPart$12
  extends D8SafeAnimatorListener
{
  AEBottomListPart$12(AEBottomListPart paramAEBottomListPart) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEBottomListPart", 2, "Watermark panel down");
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.12
 * JD-Core Version:    0.7.0.1
 */