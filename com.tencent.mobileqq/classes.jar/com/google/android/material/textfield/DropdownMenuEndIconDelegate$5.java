package com.google.android.material.textfield;

import android.widget.AutoCompleteTextView;
import androidx.annotation.NonNull;

class DropdownMenuEndIconDelegate$5
  implements TextInputLayout.OnEndIconChangedListener
{
  DropdownMenuEndIconDelegate$5(DropdownMenuEndIconDelegate paramDropdownMenuEndIconDelegate) {}
  
  public void a(@NonNull TextInputLayout paramTextInputLayout, int paramInt)
  {
    paramTextInputLayout = (AutoCompleteTextView)paramTextInputLayout.getEditText();
    if ((paramTextInputLayout != null) && (paramInt == 3))
    {
      paramTextInputLayout.post(new DropdownMenuEndIconDelegate.5.1(this, paramTextInputLayout));
      if (paramTextInputLayout.getOnFocusChangeListener() == DropdownMenuEndIconDelegate.d(this.a)) {
        paramTextInputLayout.setOnFocusChangeListener(null);
      }
      paramTextInputLayout.setOnTouchListener(null);
      if (DropdownMenuEndIconDelegate.c()) {
        paramTextInputLayout.setOnDismissListener(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.DropdownMenuEndIconDelegate.5
 * JD-Core Version:    0.7.0.1
 */