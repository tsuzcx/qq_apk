package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.util.Log;
import android.view.View;

class EditButtonManager$2
  implements ValueAnimator.AnimatorUpdateListener
{
  EditButtonManager$2(EditButtonManager paramEditButtonManager, boolean paramBoolean, EditButtonManager.FunButton paramFunButton1, EditButtonManager.FunGroup paramFunGroup1, EditButtonManager.FunButton paramFunButton2, EditButtonManager.FunGroup paramFunGroup2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = new StringBuilder();
    paramValueAnimator.append("onAnimation Update, value = ");
    paramValueAnimator.append(f);
    Log.d("[EditButton]", paramValueAnimator.toString());
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunButton.a.getMeasuredWidth();
      int i;
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunGroup != null)
      {
        i = this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunButton.a.getMeasuredWidth();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunGroup.a.getLayoutParams().width = ((int)(i * (2.0F - f)));
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunGroup.a.requestLayout();
      }
      if (this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunGroup != null)
      {
        int j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunButton.a.getMeasuredWidth();
        i = j;
        if (j <= 0) {
          i = this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunGroup.b.getMeasuredWidth();
        }
        this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunGroup.a.getLayoutParams().width = ((int)(i * (f + 1.0F)));
        this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunGroup.a.requestLayout();
      }
    }
    else
    {
      EditButtonManager.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager.2
 * JD-Core Version:    0.7.0.1
 */