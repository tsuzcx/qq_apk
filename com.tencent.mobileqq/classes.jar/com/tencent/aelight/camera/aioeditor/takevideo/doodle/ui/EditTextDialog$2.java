package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.capture.text.NormalTextItem;

class EditTextDialog$2
  implements View.OnClickListener
{
  EditTextDialog$2(EditTextDialog paramEditTextDialog) {}
  
  public void onClick(View paramView)
  {
    EditTextDialog.a(this.a, true);
    if (this.a.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem != null)
    {
      EditTextDialog.b(this.a, false);
      paramView = this.a;
      paramView.a = paramView.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
      this.a.a.a(EditTextDialog.a(this.a), this.a.jdField_b_of_type_JavaLangString);
      this.a.a.c(this.a.i);
      if ((this.a.a instanceof NormalTextItem)) {
        ((NormalTextItem)this.a.a).a(this.a.h);
      }
      this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.2
 * JD-Core Version:    0.7.0.1
 */