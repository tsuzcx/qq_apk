package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.common.config.AppSetting;

class ClassificationSearchActivity$2
  implements TextWatcher
{
  ClassificationSearchActivity$2(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    paramEditable = this.a.jdField_a_of_type_AndroidWidgetImageButton;
    if (str.equals("")) {
      i = 8;
    } else {
      i = 0;
    }
    paramEditable.setVisibility(i);
    int j = this.a.f;
    int k = ClassificationSearchActivity.c;
    int i = 2131690728;
    if (j == k)
    {
      this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.getResources().getString(2131690728));
    }
    else
    {
      Button localButton = this.a.jdField_a_of_type_AndroidWidgetButton;
      if (!str.equals(""))
      {
        paramEditable = this.a.getResources();
        i = 2131718623;
      }
      else
      {
        paramEditable = this.a.getResources();
      }
      localButton.setText(paramEditable.getString(i));
    }
    if (AppSetting.d) {
      this.a.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.a.jdField_a_of_type_AndroidWidgetButton.getText().toString());
    }
    if ((str.equals("")) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment != null))
    {
      if ((this.a.f != ClassificationSearchActivity.jdField_a_of_type_Int) && (this.a.f != ClassificationSearchActivity.d))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.d();
        return;
      }
      ClassificationSearchActivity.a(this.a);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.2
 * JD-Core Version:    0.7.0.1
 */