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
    int i = this.a.e.getBottom();
    Object localObject;
    if (this.a.j < 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGlobalLayout first bottom:");
        ((StringBuilder)localObject).append(i);
        QLog.i("EditTextDialog", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.a;
      ((EditTextDialog)localObject).j = i;
      ((EditTextDialog)localObject).o.post(new EditTextDialog.InitialLayoutListener.1(this));
      return;
    }
    if (this.a.j - i > this.a.i)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGlobalLayout second bottom:");
        ((StringBuilder)localObject).append(i);
        QLog.i("EditTextDialog", 2, ((StringBuilder)localObject).toString());
      }
      this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      this.a.a.getViewTreeObserver().addOnGlobalLayoutListener(this.a.h);
      localObject = this.a;
      ((EditTextDialog)localObject).j = i;
      ((EditTextDialog)localObject).a.requestLayout();
      this.a.o.post(new EditTextDialog.InitialLayoutListener.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.InitialLayoutListener
 * JD-Core Version:    0.7.0.1
 */