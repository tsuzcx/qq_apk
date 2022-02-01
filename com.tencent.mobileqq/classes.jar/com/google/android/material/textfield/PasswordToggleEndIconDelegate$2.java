package com.google.android.material.textfield;

import android.widget.EditText;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;

class PasswordToggleEndIconDelegate$2
  implements TextInputLayout.OnEditTextAttachedListener
{
  PasswordToggleEndIconDelegate$2(PasswordToggleEndIconDelegate paramPasswordToggleEndIconDelegate) {}
  
  public void a(@NonNull TextInputLayout paramTextInputLayout)
  {
    EditText localEditText = paramTextInputLayout.getEditText();
    paramTextInputLayout.setEndIconVisible(true);
    paramTextInputLayout.setEndIconCheckable(true);
    this.a.c.setChecked(true ^ PasswordToggleEndIconDelegate.a(this.a));
    localEditText.removeTextChangedListener(PasswordToggleEndIconDelegate.b(this.a));
    localEditText.addTextChangedListener(PasswordToggleEndIconDelegate.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.PasswordToggleEndIconDelegate.2
 * JD-Core Version:    0.7.0.1
 */