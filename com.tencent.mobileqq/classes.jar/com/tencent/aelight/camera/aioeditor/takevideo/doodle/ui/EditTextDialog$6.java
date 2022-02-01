package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.capture.text.EditTextPreView;
import com.tencent.aelight.camera.aioeditor.capture.text.NormalTextItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class EditTextDialog$6
  implements TextWatcher
{
  EditTextDialog$6(EditTextDialog paramEditTextDialog) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener == null) {
      return;
    }
    if (paramCharSequence == null) {
      return;
    }
    EditTextDialog.b(this.a, true);
    if (this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem != null) {
      this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView.setText(this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.b(), paramCharSequence.toString());
    }
    if ((this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem instanceof NormalTextItem))
    {
      NormalTextItem localNormalTextItem = (NormalTextItem)this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
      EditTextDialog localEditTextDialog;
      if ((localNormalTextItem.a(paramCharSequence.toString())) && (paramInt3 != 0) && ((EditTextDialog.a(this.a) == null) || (!EditTextDialog.a(this.a).d())))
      {
        localEditTextDialog = this.a;
        EditTextDialog.a(localEditTextDialog, QQToast.a(localEditTextDialog.getContext(), HardCodeUtil.a(2131703862), 0));
        EditTextDialog.a(this.a).a();
      }
      if ((this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.b() != EditTextDialog.a(this.a)) && (localNormalTextItem.f() != EditTextDialog.b(this.a)))
      {
        if ((this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.b() > EditTextDialog.b(this.a)) && (EditTextDialog.b(this.a) < localNormalTextItem.f()))
        {
          boolean bool = localNormalTextItem.a(EditTextDialog.a(this.a), paramCharSequence.toString(), EditTextDialog.b(this.a), EditTextDialog.c(this.a));
          EditTextDialog.a(this.a, localNormalTextItem.d());
          EditTextDialog.a(this.a);
          if ((bool) && ((EditTextDialog.a(this.a) == null) || (!EditTextDialog.a(this.a).d())))
          {
            paramCharSequence = this.a;
            EditTextDialog.a(paramCharSequence, QQToast.a(paramCharSequence.getContext(), HardCodeUtil.a(2131703861), 0));
            EditTextDialog.a(this.a).a();
          }
        }
        else if ((this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.b() < EditTextDialog.b(this.a)) && (EditTextDialog.c(this.a) < NormalTextItem.c) && (EditTextDialog.b(this.a) > localNormalTextItem.f()))
        {
          localEditTextDialog = this.a;
          EditTextDialog.a(localEditTextDialog, localNormalTextItem.a(EditTextDialog.a(localEditTextDialog), paramCharSequence.toString(), EditTextDialog.b(this.a), EditTextDialog.c(this.a)));
          EditTextDialog.a(this.a);
        }
        paramCharSequence = this.a;
        EditTextDialog.a(paramCharSequence, paramCharSequence.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.b());
        EditTextDialog.b(this.a, localNormalTextItem.f());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.6
 * JD-Core Version:    0.7.0.1
 */