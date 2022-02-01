package com.google.android.material.textfield;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;

abstract class EndIconDelegate
{
  Context jdField_a_of_type_AndroidContentContext;
  CheckableImageButton jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton;
  TextInputLayout jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout;
  
  EndIconDelegate(@NonNull TextInputLayout paramTextInputLayout)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout = paramTextInputLayout;
    this.jdField_a_of_type_AndroidContentContext = paramTextInputLayout.getContext();
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton = paramTextInputLayout.a();
  }
  
  abstract void a();
  
  void a(boolean paramBoolean) {}
  
  boolean a()
  {
    return false;
  }
  
  boolean a(int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.EndIconDelegate
 * JD-Core Version:    0.7.0.1
 */