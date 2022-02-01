package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AEImageCropperView$6
  extends D8SafeAnimatorListener
{
  AEImageCropperView$6(AEImageCropperView paramAEImageCropperView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEImageCropperView.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEImageCropperView.a(this.a, false);
    AEImageCropperView.c(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    AEImageCropperView.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEImageCropperView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEImageCropperView.6
 * JD-Core Version:    0.7.0.1
 */