package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class FriendProfileMoreInfoActivity$MaxBytesTextWatcher
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  private int c;
  
  public FriendProfileMoreInfoActivity$MaxBytesTextWatcher(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity, int paramInt, EditText paramEditText)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    paramEditable = (Editable)localObject2;
    if (((String)localObject2).getBytes().length > this.jdField_a_of_type_Int) {
      localObject1 = localObject2;
    }
    try
    {
      String str1 = ((String)localObject2).substring(0, this.jdField_b_of_type_Int);
      localObject1 = localObject2;
      String str2 = ((String)localObject2).substring(this.jdField_b_of_type_Int + this.c, ((String)localObject2).length());
      localObject1 = localObject2;
      Object localObject3 = ((String)localObject2).substring(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int + this.c);
      paramEditable = (Editable)localObject2;
      localObject1 = localObject2;
      if (str1.getBytes().length + str2.getBytes().length <= this.jdField_a_of_type_Int)
      {
        paramEditable = (Editable)localObject2;
        localObject2 = localObject3;
        for (;;)
        {
          localObject1 = paramEditable;
          if (paramEditable.getBytes().length <= this.jdField_a_of_type_Int) {
            break;
          }
          localObject1 = paramEditable;
          if (((String)localObject2).length() <= 0) {
            break;
          }
          localObject1 = paramEditable;
          localObject2 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
          localObject1 = paramEditable;
          localObject3 = new StringBuilder();
          localObject1 = paramEditable;
          ((StringBuilder)localObject3).append(str1);
          localObject1 = paramEditable;
          ((StringBuilder)localObject3).append((String)localObject2);
          localObject1 = paramEditable;
          ((StringBuilder)localObject3).append(str2);
          localObject1 = paramEditable;
          paramEditable = ((StringBuilder)localObject3).toString();
        }
        localObject1 = paramEditable;
        this.jdField_a_of_type_AndroidWidgetEditText.setText(paramEditable);
        localObject1 = paramEditable;
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str1.length() + ((String)localObject2).length());
      }
    }
    catch (Exception paramEditable)
    {
      for (;;)
      {
        paramEditable = (Editable)localObject1;
      }
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    } else {
      this.jdField_b_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.jdField_a_of_type_AndroidWidgetEditText)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity;
      ((FriendProfileMoreInfoActivity)localObject1).a(FriendProfileMoreInfoActivity.d((FriendProfileMoreInfoActivity)localObject1), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.getString(2131695067), paramEditable);
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.b)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity;
      ((FriendProfileMoreInfoActivity)localObject1).a(FriendProfileMoreInfoActivity.e((FriendProfileMoreInfoActivity)localObject1), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.getString(2131695020), paramEditable);
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.c)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity;
      ((FriendProfileMoreInfoActivity)localObject1).a(FriendProfileMoreInfoActivity.f((FriendProfileMoreInfoActivity)localObject1), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.c, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.getString(2131695116), paramEditable);
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.d)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity;
      ((FriendProfileMoreInfoActivity)localObject1).a(FriendProfileMoreInfoActivity.g((FriendProfileMoreInfoActivity)localObject1), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.d, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.getString(2131695050), paramEditable);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt3;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.MaxBytesTextWatcher
 * JD-Core Version:    0.7.0.1
 */