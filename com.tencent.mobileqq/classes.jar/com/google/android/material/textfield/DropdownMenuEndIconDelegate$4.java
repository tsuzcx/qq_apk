package com.google.android.material.textfield;

import android.widget.AutoCompleteTextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

class DropdownMenuEndIconDelegate$4
  implements TextInputLayout.OnEditTextAttachedListener
{
  DropdownMenuEndIconDelegate$4(DropdownMenuEndIconDelegate paramDropdownMenuEndIconDelegate) {}
  
  public void a(@NonNull TextInputLayout paramTextInputLayout)
  {
    AutoCompleteTextView localAutoCompleteTextView = DropdownMenuEndIconDelegate.a(paramTextInputLayout.getEditText());
    DropdownMenuEndIconDelegate.b(this.a, localAutoCompleteTextView);
    DropdownMenuEndIconDelegate.c(this.a, localAutoCompleteTextView);
    DropdownMenuEndIconDelegate.d(this.a, localAutoCompleteTextView);
    localAutoCompleteTextView.setThreshold(0);
    localAutoCompleteTextView.removeTextChangedListener(DropdownMenuEndIconDelegate.b(this.a));
    localAutoCompleteTextView.addTextChangedListener(DropdownMenuEndIconDelegate.b(this.a));
    paramTextInputLayout.setEndIconCheckable(true);
    paramTextInputLayout.setErrorIconDrawable(null);
    if (!DropdownMenuEndIconDelegate.b(localAutoCompleteTextView)) {
      ViewCompat.setImportantForAccessibility(this.a.c, 2);
    }
    paramTextInputLayout.setTextInputAccessibilityDelegate(DropdownMenuEndIconDelegate.c(this.a));
    paramTextInputLayout.setEndIconVisible(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.DropdownMenuEndIconDelegate.4
 * JD-Core Version:    0.7.0.1
 */