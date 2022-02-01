package com.google.android.material.textfield;

import android.widget.AutoCompleteTextView;
import androidx.annotation.NonNull;

class DropdownMenuEndIconDelegate$5
  implements TextInputLayout.OnEndIconChangedListener
{
  DropdownMenuEndIconDelegate$5(DropdownMenuEndIconDelegate paramDropdownMenuEndIconDelegate) {}
  
  public void a(@NonNull TextInputLayout paramTextInputLayout, int paramInt)
  {
    paramTextInputLayout = (AutoCompleteTextView)paramTextInputLayout.a();
    if ((paramTextInputLayout != null) && (paramInt == 3))
    {
      paramTextInputLayout.post(new DropdownMenuEndIconDelegate.5.1(this, paramTextInputLayout));
      if (paramTextInputLayout.getOnFocusChangeListener() == DropdownMenuEndIconDelegate.a(this.a)) {
        paramTextInputLayout.setOnFocusChangeListener(null);
      }
      paramTextInputLayout.setOnTouchListener(null);
      if (DropdownMenuEndIconDelegate.b()) {
        paramTextInputLayout.setOnDismissListener(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.DropdownMenuEndIconDelegate.5
 * JD-Core Version:    0.7.0.1
 */