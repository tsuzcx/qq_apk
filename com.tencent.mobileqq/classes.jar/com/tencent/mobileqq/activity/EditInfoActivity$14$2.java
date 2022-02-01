package com.tencent.mobileqq.activity;

import android.graphics.Color;
import android.widget.TextView;

class EditInfoActivity$14$2
  implements Runnable
{
  EditInfoActivity$14$2(EditInfoActivity.14 param14, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$14.a.b.setText(this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$14.a.c);
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$14.a.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$14.a.b.setTextColor(-65536);
      this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$14.a.rightViewText.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$14.a.b.setTextColor(Color.rgb(119, 119, 119));
    this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$14.a.rightViewText.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.14.2
 * JD-Core Version:    0.7.0.1
 */