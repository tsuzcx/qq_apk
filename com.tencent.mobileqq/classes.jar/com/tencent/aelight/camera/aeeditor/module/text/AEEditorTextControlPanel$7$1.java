package com.tencent.aelight.camera.aeeditor.module.text;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AEEditorTextControlPanel$7$1
  extends D8SafeAnimatorListener
{
  AEEditorTextControlPanel$7$1(AEEditorTextControlPanel.7 param7) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEEditorTextControlPanel.a(this.a.this$0).setVisibility(0);
    if (AEEditorTextControlPanel.a(this.a.this$0) != null) {
      AEEditorTextControlPanel.a(this.a.this$0).c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextControlPanel.7.1
 * JD-Core Version:    0.7.0.1
 */