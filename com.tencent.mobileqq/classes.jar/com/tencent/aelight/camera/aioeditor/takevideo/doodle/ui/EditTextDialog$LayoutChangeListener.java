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
    int i = this.a.jdField_a_of_type_AndroidViewView.getBottom();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGlobalLayout third bottom:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" last:");
      ((StringBuilder)localObject).append(this.a.b);
      QLog.i("EditTextDialog", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout != null)
    {
      localObject = new int[2];
      this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout.getLocationOnScreen((int[])localObject);
      int j = localObject[1];
      int k = j - AIOUtils.b(62.0F, BaseApplicationImpl.getContext().getResources());
      if (k < EditTextDialog.b(this.a)) {
        EditTextDialog.b(this.a, k);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("max height");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append("preViewTextMaxHeight");
        ((StringBuilder)localObject).append(EditTextDialog.b(this.a));
        ((StringBuilder)localObject).append("y");
        ((StringBuilder)localObject).append(j);
        QLog.d("EditTextDialog", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (i - this.a.b > this.a.jdField_a_of_type_Int)
    {
      this.a.a(false);
      if (this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem != null) {
        this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.d = false;
      }
    }
    else
    {
      this.a.jdField_a_of_type_MqqOsMqqHandler.post(new EditTextDialog.LayoutChangeListener.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.LayoutChangeListener
 * JD-Core Version:    0.7.0.1
 */