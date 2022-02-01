package com.google.android.material.textfield;

import androidx.annotation.NonNull;

class CustomEndIconDelegate
  extends EndIconDelegate
{
  CustomEndIconDelegate(@NonNull TextInputLayout paramTextInputLayout)
  {
    super(paramTextInputLayout);
  }
  
  void a()
  {
    this.a.setEndIconOnClickListener(null);
    this.a.setEndIconOnLongClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.CustomEndIconDelegate
 * JD-Core Version:    0.7.0.1
 */