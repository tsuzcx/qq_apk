package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class EditTextDialog$LayoutChangeListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private EditTextDialog$LayoutChangeListener(EditTextDialog paramEditTextDialog) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.e.getBottom();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGlobalLayout third bottom:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" last:");
      ((StringBuilder)localObject).append(this.a.j);
      QLog.i("EditTextDialog", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.f != null)
    {
      localObject = new int[2];
      this.a.f.getLocationOnScreen((int[])localObject);
      int j = localObject[1];
      int k = j - AIOUtils.b(62.0F, BaseApplicationImpl.getContext().getResources());
      if (k < EditTextDialog.f(this.a)) {
        EditTextDialog.b(this.a, k);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("max height");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append("preViewTextMaxHeight");
        ((StringBuilder)localObject).append(EditTextDialog.f(this.a));
        ((StringBuilder)localObject).append("y");
        ((StringBuilder)localObject).append(j);
        QLog.d("EditTextDialog", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (i - this.a.j > this.a.i)
    {
      this.a.a(false);
      if (this.a.y != null) {
        this.a.y.o = false;
      }
    }
    else
    {
      this.a.o.post(new EditTextDialog.LayoutChangeListener.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.LayoutChangeListener
 * JD-Core Version:    0.7.0.1
 */