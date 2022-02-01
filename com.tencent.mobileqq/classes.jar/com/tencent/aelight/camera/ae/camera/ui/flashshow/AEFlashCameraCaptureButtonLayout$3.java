package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class AEFlashCameraCaptureButtonLayout$3
  implements Animation.AnimationListener
{
  AEFlashCameraCaptureButtonLayout$3(AEFlashCameraCaptureButtonLayout paramAEFlashCameraCaptureButtonLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AEFlashCameraCaptureButtonLayout.a(this.a).startAnimation(this.a.m);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashCameraCaptureButtonLayout.3
 * JD-Core Version:    0.7.0.1
 */