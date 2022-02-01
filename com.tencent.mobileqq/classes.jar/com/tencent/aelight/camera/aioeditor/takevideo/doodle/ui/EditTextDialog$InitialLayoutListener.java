package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class EditTextDialog$InitialLayoutListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private EditTextDialog$InitialLayoutListener(EditTextDialog paramEditTextDialog) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.jdField_a_of_type_AndroidViewView.getBottom();
    Object localObject;
    if (this.a.b < 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGlobalLayout first bottom:");
        ((StringBuilder)localObject).append(i);
        QLog.i("EditTextDialog", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.a;
      ((EditTextDialog)localObject).b = i;
      ((EditTextDialog)localObject).jdField_a_of_type_MqqOsMqqHandler.post(new EditTextDialog.InitialLayoutListener.1(this));
      return;
    }
    if (this.a.b - i > this.a.jdField_a_of_type_Int)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGlobalLayout second bottom:");
        ((StringBuilder)localObject).append(i);
        QLog.i("EditTextDialog", 2, ((StringBuilder)localObject).toString());
      }
      this.a.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      this.a.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.a.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      localObject = this.a;
      ((EditTextDialog)localObject).b = i;
      ((EditTextDialog)localObject).jdField_a_of_type_AndroidViewViewGroup.requestLayout();
      this.a.jdField_a_of_type_MqqOsMqqHandler.post(new EditTextDialog.InitialLayoutListener.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.InitialLayoutListener
 * JD-Core Version:    0.7.0.1
 */