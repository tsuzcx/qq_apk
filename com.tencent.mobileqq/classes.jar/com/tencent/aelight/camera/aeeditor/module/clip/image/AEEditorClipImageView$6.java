package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AEEditorClipImageView$6
  extends D8SafeAnimatorListener
{
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEEditorClipImageView.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEEditorClipImageView.a(this.a, false);
    AEEditorClipImageView.g(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    AEEditorClipImageView.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEEditorClipImageView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipImageView.6
 * JD-Core Version:    0.7.0.1
 */