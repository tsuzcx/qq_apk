package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AEEditorClipImageView$4
  extends D8SafeAnimatorListener
{
  AEEditorClipImageView$4(AEEditorClipImageView paramAEEditorClipImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEEditorClipImageView.a(this.a, false);
    if (this.a.d != null) {
      this.a.d.onAnimationCancel(paramAnimator);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEEditorClipImageView.a(this.a, false);
    if (this.a.d != null) {
      this.a.d.onAnimationEnd(paramAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    AEEditorClipImageView.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEEditorClipImageView.a(this.a, true);
    if (this.a.d != null) {
      this.a.d.onAnimationStart(paramAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipImageView.4
 * JD-Core Version:    0.7.0.1
 */