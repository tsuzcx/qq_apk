package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.annotation.NonNull;

class ClearTextEndIconDelegate$1
  implements TextWatcher
{
  ClearTextEndIconDelegate$1(ClearTextEndIconDelegate paramClearTextEndIconDelegate) {}
  
  public void afterTextChanged(@NonNull Editable paramEditable)
  {
    if (this.a.a.getSuffixText() != null) {
      return;
    }
    ClearTextEndIconDelegate.a(this.a, ClearTextEndIconDelegate.a(paramEditable));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.ClearTextEndIconDelegate.1
 * JD-Core Version:    0.7.0.1
 */