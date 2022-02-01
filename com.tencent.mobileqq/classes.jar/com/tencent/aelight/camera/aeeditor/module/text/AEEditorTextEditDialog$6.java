package com.tencent.aelight.camera.aeeditor.module.text;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.tavcut.bean.TextEditorData;

class AEEditorTextEditDialog$6
  implements TextWatcher
{
  AEEditorTextEditDialog$6(AEEditorTextEditDialog paramAEEditorTextEditDialog) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    String str = paramEditable.toString();
    if (paramEditable.length() > 120)
    {
      QQToast.makeText(this.a.getContext(), AEEditorTextEditDialog.e(this.a), 0).show();
      str = paramEditable.subSequence(0, 120).toString();
      AEEditorTextEditDialog.f(this.a).setText(str);
      AEEditorTextEditDialog.f(this.a).setSelection(str.length());
    }
    if (TextUtils.isEmpty(str.trim())) {
      AEEditorTextEditDialog.d(this.a).setContent("");
    } else {
      AEEditorTextEditDialog.d(this.a).setContent(str);
    }
    AEEditorTextEditDialog.b(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextEditDialog.6
 * JD-Core Version:    0.7.0.1
 */