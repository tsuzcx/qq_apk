package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.widget.QQToast;

class EditInfoActivity$20$1
  implements Runnable
{
  EditInfoActivity$20$1(EditInfoActivity.20 param20, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$20.a.b(false);
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$20.a.h);
      this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$20.a.setResult(-1, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$20.a.finish();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$20.a, 2, 2131694234, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$20.a.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$20.a.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.20.1
 * JD-Core Version:    0.7.0.1
 */