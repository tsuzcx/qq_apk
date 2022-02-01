package com.google.android.material.textfield;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;

abstract class EndIconDelegate
{
  TextInputLayout a;
  Context b;
  CheckableImageButton c;
  
  EndIconDelegate(@NonNull TextInputLayout paramTextInputLayout)
  {
    this.a = paramTextInputLayout;
    this.b = paramTextInputLayout.getContext();
    this.c = paramTextInputLayout.getEndIconView();
  }
  
  abstract void a();
  
  void a(boolean paramBoolean) {}
  
  boolean a(int paramInt)
  {
    return true;
  }
  
  boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.EndIconDelegate
 * JD-Core Version:    0.7.0.1
 */