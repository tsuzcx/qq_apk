package com.google.android.material.textfield;

import android.widget.EditText;
import androidx.annotation.NonNull;

class ClearTextEndIconDelegate$3
  implements TextInputLayout.OnEditTextAttachedListener
{
  ClearTextEndIconDelegate$3(ClearTextEndIconDelegate paramClearTextEndIconDelegate) {}
  
  public void a(@NonNull TextInputLayout paramTextInputLayout)
  {
    EditText localEditText = paramTextInputLayout.a();
    boolean bool;
    if ((localEditText.hasFocus()) && (ClearTextEndIconDelegate.a(localEditText.getText()))) {
      bool = true;
    } else {
      bool = false;
    }
    paramTextInputLayout.setEndIconVisible(bool);
    paramTextInputLayout.setEndIconCheckable(false);
    localEditText.setOnFocusChangeListener(ClearTextEndIconDelegate.a(this.a));
    localEditText.removeTextChangedListener(ClearTextEndIconDelegate.a(this.a));
    localEditText.addTextChangedListener(ClearTextEndIconDelegate.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.ClearTextEndIconDelegate.3
 * JD-Core Version:    0.7.0.1
 */