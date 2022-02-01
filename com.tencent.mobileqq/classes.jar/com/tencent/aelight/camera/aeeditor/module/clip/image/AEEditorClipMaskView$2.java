package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AEEditorClipMaskView$2
  extends D8SafeAnimatorListener
{
  AEEditorClipMaskView$2(AEEditorClipMaskView paramAEEditorClipMaskView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEEditorClipMaskView.a(this.a, false);
    paramAnimator = this.a;
    AEEditorClipMaskView.b(paramAnimator, AEEditorClipMaskView.a(paramAnimator));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEEditorClipMaskView.a(this.a, false);
    paramAnimator = this.a;
    AEEditorClipMaskView.b(paramAnimator, AEEditorClipMaskView.a(paramAnimator));
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    AEEditorClipMaskView.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEEditorClipMaskView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipMaskView.2
 * JD-Core Version:    0.7.0.1
 */