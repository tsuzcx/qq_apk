package com.google.android.material.textfield;

import android.widget.EditText;
import androidx.annotation.NonNull;

class ClearTextEndIconDelegate$4
  implements TextInputLayout.OnEndIconChangedListener
{
  ClearTextEndIconDelegate$4(ClearTextEndIconDelegate paramClearTextEndIconDelegate) {}
  
  public void a(@NonNull TextInputLayout paramTextInputLayout, int paramInt)
  {
    paramTextInputLayout = paramTextInputLayout.a();
    if ((paramTextInputLayout != null) && (paramInt == 2))
    {
      paramTextInputLayout.post(new ClearTextEndIconDelegate.4.1(this, paramTextInputLayout));
      if (paramTextInputLayout.getOnFocusChangeListener() == ClearTextEndIconDelegate.a(this.a)) {
        paramTextInputLayout.setOnFocusChangeListener(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.ClearTextEndIconDelegate.4
 * JD-Core Version:    0.7.0.1
 */