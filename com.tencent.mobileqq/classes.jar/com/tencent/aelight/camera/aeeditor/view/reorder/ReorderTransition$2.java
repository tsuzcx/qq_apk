package com.tencent.aelight.camera.aeeditor.view.reorder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;
import android.view.View;

final class ReorderTransition$2
  extends AnimatorListenerAdapter
{
  ReorderTransition$2(View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (Build.VERSION.SDK_INT >= 18) {
      this.a.setClipBounds(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.reorder.ReorderTransition.2
 * JD-Core Version:    0.7.0.1
 */