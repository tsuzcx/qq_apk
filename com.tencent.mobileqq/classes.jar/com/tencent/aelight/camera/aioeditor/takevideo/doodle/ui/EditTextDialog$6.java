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
    if (this.a.g == null) {
      return;
    }
    if (paramCharSequence == null) {
      return;
    }
    EditTextDialog.b(this.a, true);
    if (this.a.y != null) {
      this.a.t.setText(this.a.y.g(), paramCharSequence.toString());
    }
    if ((this.a.y instanceof NormalTextItem))
    {
      NormalTextItem localNormalTextItem = (NormalTextItem)this.a.y;
      EditTextDialog localEditTextDialog;
      if ((localNormalTextItem.b(paramCharSequence.toString())) && (paramInt3 != 0) && ((EditTextDialog.c(this.a) == null) || (!EditTextDialog.c(this.a).isShowing())))
      {
        localEditTextDialog = this.a;
        EditTextDialog.a(localEditTextDialog, QQToast.makeText(localEditTextDialog.getContext(), HardCodeUtil.a(2131901808), 0));
        EditTextDialog.c(this.a).show();
      }
      if ((this.a.y.d() != EditTextDialog.d(this.a)) && (localNormalTextItem.w() != EditTextDialog.e(this.a)))
      {
        if ((this.a.y.d() > EditTextDialog.f(this.a)) && (EditTextDialog.e(this.a) < localNormalTextItem.w()))
        {
          boolean bool = localNormalTextItem.a(EditTextDialog.a(this.a), paramCharSequence.toString(), EditTextDialog.f(this.a), EditTextDialog.g(this.a));
          EditTextDialog.a(this.a, localNormalTextItem.t());
          EditTextDialog.h(this.a);
          if ((bool) && ((EditTextDialog.c(this.a) == null) || (!EditTextDialog.c(this.a).isShowing())))
          {
            paramCharSequence = this.a;
            EditTextDialog.a(paramCharSequence, QQToast.makeText(paramCharSequence.getContext(), HardCodeUtil.a(2131901807), 0));
            EditTextDialog.c(this.a).show();
          }
        }
        else if ((this.a.y.d() < EditTextDialog.f(this.a)) && (EditTextDialog.g(this.a) < NormalTextItem.b) && (EditTextDialog.e(this.a) > localNormalTextItem.w()))
        {
          localEditTextDialog = this.a;
          EditTextDialog.a(localEditTextDialog, localNormalTextItem.b(EditTextDialog.a(localEditTextDialog), paramCharSequence.toString(), EditTextDialog.f(this.a), EditTextDialog.g(this.a)));
          EditTextDialog.h(this.a);
        }
        paramCharSequence = this.a;
        EditTextDialog.a(paramCharSequence, paramCharSequence.y.d());
        EditTextDialog.b(this.a, localNormalTextItem.w());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.6
 * JD-Core Version:    0.7.0.1
 */