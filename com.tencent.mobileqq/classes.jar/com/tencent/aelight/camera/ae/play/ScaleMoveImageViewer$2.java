package com.tencent.aelight.camera.ae.play;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ScaleMoveImageViewer$2
  extends AnimatorListenerAdapter
{
  ScaleMoveImageViewer$2(ScaleMoveImageViewer paramScaleMoveImageViewer) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ScaleMoveImageViewer.access$102(this.this$0, false);
    this.this$0.invalidate();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ScaleMoveImageViewer.access$102(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.ScaleMoveImageViewer.2
 * JD-Core Version:    0.7.0.1
 */