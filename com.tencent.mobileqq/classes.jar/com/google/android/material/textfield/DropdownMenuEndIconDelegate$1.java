package com.google.android.material.textfield;

import android.text.Editable;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.TextWatcherAdapter;

class DropdownMenuEndIconDelegate$1
  extends TextWatcherAdapter
{
  DropdownMenuEndIconDelegate$1(DropdownMenuEndIconDelegate paramDropdownMenuEndIconDelegate) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = DropdownMenuEndIconDelegate.a(this.a.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a());
    if ((DropdownMenuEndIconDelegate.a(this.a).isTouchExplorationEnabled()) && (DropdownMenuEndIconDelegate.a(paramEditable)) && (!this.a.jdField_a_of_type_ComGoogleAndroidMaterialInternalCheckableImageButton.hasFocus())) {
      paramEditable.dismissDropDown();
    }
    paramEditable.post(new DropdownMenuEndIconDelegate.1.1(this, paramEditable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.DropdownMenuEndIconDelegate.1
 * JD-Core Version:    0.7.0.1
 */