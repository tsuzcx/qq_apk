package com.tencent.aelight.camera.ae.play;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class EditTextViewer$3
  extends AnimatorListenerAdapter
{
  EditTextViewer$3(EditTextViewer paramEditTextViewer) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    EditTextViewer.access$102(this.this$0, false);
    this.this$0.invalidate();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    EditTextViewer.access$102(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.EditTextViewer.3
 * JD-Core Version:    0.7.0.1
 */