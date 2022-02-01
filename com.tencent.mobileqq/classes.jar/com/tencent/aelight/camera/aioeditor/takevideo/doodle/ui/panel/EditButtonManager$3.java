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
    if (this.jdField_a_of_type_Boolean)
    {
      paramAnimator = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunGroup;
      if (paramAnimator != null) {
        EditButtonManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager, paramAnimator, false);
      }
    }
    EditButtonManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager.3
 * JD-Core Version:    0.7.0.1
 */