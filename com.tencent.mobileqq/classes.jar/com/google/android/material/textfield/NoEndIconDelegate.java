package com.google.android.material.textfield;

import androidx.annotation.NonNull;

class NoEndIconDelegate
  extends EndIconDelegate
{
  NoEndIconDelegate(@NonNull TextInputLayout paramTextInputLayout)
  {
    super(paramTextInputLayout);
  }
  
  void a()
  {
    this.a.setEndIconOnClickListener(null);
    this.a.setEndIconDrawable(null);
    this.a.setEndIconContentDescription(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.NoEndIconDelegate
 * JD-Core Version:    0.7.0.1
 */