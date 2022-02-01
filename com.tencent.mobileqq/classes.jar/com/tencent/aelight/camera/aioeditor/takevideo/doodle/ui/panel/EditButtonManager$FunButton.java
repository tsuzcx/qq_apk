package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class EditButtonManager$FunButton
{
  int jdField_a_of_type_Int;
  @NonNull
  View jdField_a_of_type_AndroidViewView;
  @Nullable
  EditButtonManager.FunGroup jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunGroup;
  
  EditButtonManager$FunButton(EditButtonManager paramEditButtonManager, int paramInt, @NonNull View paramView)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramView.setOnClickListener(new EditButtonManager.FunButton.1(this, paramEditButtonManager, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager.FunButton
 * JD-Core Version:    0.7.0.1
 */