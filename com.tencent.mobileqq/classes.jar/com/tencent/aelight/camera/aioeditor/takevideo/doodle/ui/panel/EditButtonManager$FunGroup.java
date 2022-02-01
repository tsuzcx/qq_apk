package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.view.View;
import androidx.annotation.NonNull;

class EditButtonManager$FunGroup
{
  @NonNull
  View a;
  @NonNull
  View b;
  @NonNull
  int[] c;
  int d;
  
  EditButtonManager$FunGroup(EditButtonManager paramEditButtonManager, @NonNull View paramView1, @NonNull View paramView2, @NonNull int[] paramArrayOfInt)
  {
    this.a = paramView1;
    this.b = paramView2;
    this.c = paramArrayOfInt;
    this.d = paramArrayOfInt[0];
    this.b.setOnClickListener(new EditButtonManager.FunGroup.1(this, paramEditButtonManager));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager.FunGroup
 * JD-Core Version:    0.7.0.1
 */