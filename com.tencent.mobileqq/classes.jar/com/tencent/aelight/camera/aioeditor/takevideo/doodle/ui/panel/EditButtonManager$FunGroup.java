package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.view.View;
import androidx.annotation.NonNull;

class EditButtonManager$FunGroup
{
  int jdField_a_of_type_Int;
  @NonNull
  View jdField_a_of_type_AndroidViewView;
  @NonNull
  int[] jdField_a_of_type_ArrayOfInt;
  @NonNull
  View b;
  
  EditButtonManager$FunGroup(EditButtonManager paramEditButtonManager, @NonNull View paramView1, @NonNull View paramView2, @NonNull int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.b = paramView2;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_Int = paramArrayOfInt[0];
    this.b.setOnClickListener(new EditButtonManager.FunGroup.1(this, paramEditButtonManager));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager.FunGroup
 * JD-Core Version:    0.7.0.1
 */