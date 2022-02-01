package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import com.tencent.aelight.camera.aioeditor.capture.text.EditTextPreView;
import com.tencent.aelight.camera.aioeditor.capture.text.NormalTextItem;

class EditTextDialog$8
  implements AEHorizontalSelectColorLayout.IColorSelectListener
{
  EditTextDialog$8(EditTextDialog paramEditTextDialog) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerModelTextInfo.a = paramInt2;
      EditTextDialog localEditTextDialog = this.a;
      localEditTextDialog.c = paramInt2;
      if ((localEditTextDialog.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem instanceof NormalTextItem))
      {
        ((NormalTextItem)this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem).a(paramInt2);
        this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView.invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.8
 * JD-Core Version:    0.7.0.1
 */