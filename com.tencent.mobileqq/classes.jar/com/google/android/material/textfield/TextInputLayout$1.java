package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.annotation.NonNull;

class TextInputLayout$1
  implements TextWatcher
{
  TextInputLayout$1(TextInputLayout paramTextInputLayout) {}
  
  public void afterTextChanged(@NonNull Editable paramEditable)
  {
    TextInputLayout localTextInputLayout = this.a;
    localTextInputLayout.a(TextInputLayout.a(localTextInputLayout) ^ true);
    if (this.a.a) {
      this.a.a(paramEditable.length());
    }
    if (TextInputLayout.b(this.a)) {
      TextInputLayout.a(this.a, paramEditable.length());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.TextInputLayout.1
 * JD-Core Version:    0.7.0.1
 */