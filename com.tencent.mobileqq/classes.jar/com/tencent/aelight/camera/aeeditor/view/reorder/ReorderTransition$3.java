package com.tencent.aelight.camera.aeeditor.view.reorder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class ReorderTransition$3
  extends AnimatorListenerAdapter
{
  ReorderTransition$3(View paramView, float paramFloat) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.setTranslationX(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.reorder.ReorderTransition.3
 * JD-Core Version:    0.7.0.1
 */