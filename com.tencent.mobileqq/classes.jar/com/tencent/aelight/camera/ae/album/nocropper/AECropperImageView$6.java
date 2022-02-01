package com.tencent.aelight.camera.ae.album.nocropper;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AECropperImageView$6
  extends D8SafeAnimatorListener
{
  AECropperImageView$6(AECropperImageView paramAECropperImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, false);
    AECropperImageView.c(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.AECropperImageView.6
 * JD-Core Version:    0.7.0.1
 */