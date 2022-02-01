package com.tencent.mobileqq.activity.contact.addcontact;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;

class SearchContactsActivity$1
  implements TextWatcher
{
  SearchContactsActivity$1(SearchContactsActivity paramSearchContactsActivity, boolean paramBoolean) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    SearchContactsActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity, paramEditable);
    ImageButton localImageButton = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.jdField_a_of_type_AndroidWidgetImageButton;
    int i;
    if (paramEditable.equals("")) {
      i = 8;
    } else {
      i = 0;
    }
    localImageButton.setVisibility(i);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.h != 1)) {
      ((SearchContactsFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).c(paramEditable);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity.1
 * JD-Core Version:    0.7.0.1
 */