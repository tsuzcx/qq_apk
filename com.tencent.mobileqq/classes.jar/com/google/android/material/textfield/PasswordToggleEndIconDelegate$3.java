package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import androidx.annotation.NonNull;

class PasswordToggleEndIconDelegate$3
  implements TextInputLayout.OnEndIconChangedListener
{
  PasswordToggleEndIconDelegate$3(PasswordToggleEndIconDelegate paramPasswordToggleEndIconDelegate) {}
  
  public void a(@NonNull TextInputLayout paramTextInputLayout, int paramInt)
  {
    paramTextInputLayout = paramTextInputLayout.a();
    if ((paramTextInputLayout != null) && (paramInt == 1))
    {
      paramTextInputLayout.setTransformationMethod(PasswordTransformationMethod.getInstance());
      paramTextInputLayout.post(new PasswordToggleEndIconDelegate.3.1(this, paramTextInputLayout));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.PasswordToggleEndIconDelegate.3
 * JD-Core Version:    0.7.0.1
 */