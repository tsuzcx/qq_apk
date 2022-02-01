package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AEImageCropperMask$2
  extends D8SafeAnimatorListener
{
  AEImageCropperMask$2(AEImageCropperMask paramAEImageCropperMask) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEImageCropperMask.a(this.a, false);
    paramAnimator = this.a;
    AEImageCropperMask.b(paramAnimator, AEImageCropperMask.a(paramAnimator));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEImageCropperMask.a(this.a, false);
    paramAnimator = this.a;
    AEImageCropperMask.b(paramAnimator, AEImageCropperMask.a(paramAnimator));
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    AEImageCropperMask.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEImageCropperMask.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEImageCropperMask.2
 * JD-Core Version:    0.7.0.1
 */