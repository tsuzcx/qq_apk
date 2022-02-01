package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class EditButtonManager$3
  extends AnimatorListenerAdapter
{
  EditButtonManager$3(EditButtonManager paramEditButtonManager, boolean paramBoolean, EditButtonManager.FunGroup paramFunGroup) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a)
    {
      paramAnimator = this.b;
      if (paramAnimator != null) {
        EditButtonManager.a(this.c, paramAnimator, false);
      }
    }
    EditButtonManager.a(this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager.3
 * JD-Core Version:    0.7.0.1
 */