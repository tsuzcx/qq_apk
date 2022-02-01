package com.tencent.aelight.camera.aeeditor.module.text;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.bean.TextEditorData;

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
      QQToast.a(this.a.getContext(), AEEditorTextEditDialog.a(this.a), 0).a();
      str = paramEditable.subSequence(0, 120).toString();
      AEEditorTextEditDialog.a(this.a).setText(str);
      AEEditorTextEditDialog.a(this.a).setSelection(str.length());
    }
    if (TextUtils.isEmpty(str.trim())) {
      AEEditorTextEditDialog.a(this.a).setContent("");
    } else {
      AEEditorTextEditDialog.a(this.a).setContent(str);
    }
    AEEditorTextEditDialog.b(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextEditDialog.6
 * JD-Core Version:    0.7.0.1
 */