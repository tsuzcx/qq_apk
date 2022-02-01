package com.google.android.material.textfield;

import android.content.res.Resources;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R.drawable;
import com.google.android.material.R.string;

class PasswordToggleEndIconDelegate
  extends EndIconDelegate
{
  private final TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new PasswordToggleEndIconDelegate.1(this);
  private final TextInputLayout.OnEditTextAttachedListener jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout$OnEditTextAttachedListener = new PasswordToggleEndIconDelegate.2(this);
  private final TextInputLayout.OnEndIconChangedListener jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout$OnEndIconChangedListener = new PasswordToggleEndIconDelegate.3(this);
  
  PasswordToggleEndIconDelegate(@NonNull TextInputLayout paramTextInputLayout)
  {
    super(paramTextInputLayout);
  }
  
  private static boolean a(EditText paramEditText)
  {
    return (paramEditText != null) && ((paramEditText.getInputType() == 16) || (paramEditText.getInputType() == 128) || (paramEditText.getInputType() == 144) || (paramEditText.getInputType() == 224));
  }
  
  private boolean b()
  {
    EditText localEditText = this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a();
    return (localEditText != null) && ((localEditText.getTransformationMethod() instanceof PasswordTransformationMethod));
  }
  
  void a()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.jdField_a_of_type_AndroidContentContext, R.drawable.b));
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.setEndIconContentDescription(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.getResources().getText(R.string.R));
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.setEndIconOnClickListener(new PasswordToggleEndIconDelegate.4(this));
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout$OnEditTextAttachedListener);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout$OnEndIconChangedListener);
    EditText localEditText = this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a();
    if (a(localEditText)) {
      localEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.PasswordToggleEndIconDelegate
 * JD-Core Version:    0.7.0.1
 */