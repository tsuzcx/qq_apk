package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class EditButtonManager$FunButton
{
  int a;
  @NonNull
  View b;
  @Nullable
  EditButtonManager.FunGroup c;
  
  EditButtonManager$FunButton(EditButtonManager paramEditButtonManager, int paramInt, @NonNull View paramView)
  {
    this.a = paramInt;
    this.b = paramView;
    paramView.setOnClickListener(new EditButtonManager.FunButton.1(this, paramEditButtonManager, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager.FunButton
 * JD-Core Version:    0.7.0.1
 */