package com.google.android.material.textfield;

import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.TextWatcherAdapter;

class PasswordToggleEndIconDelegate$1
  extends TextWatcherAdapter
{
  PasswordToggleEndIconDelegate$1(PasswordToggleEndIconDelegate paramPasswordToggleEndIconDelegate) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a.setChecked(PasswordToggleEndIconDelegate.a(this.a) ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.PasswordToggleEndIconDelegate.1
 * JD-Core Version:    0.7.0.1
 */