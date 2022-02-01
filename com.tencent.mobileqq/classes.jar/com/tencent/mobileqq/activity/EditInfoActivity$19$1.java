package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.QQToast;

class EditInfoActivity$19$1
  implements Runnable
{
  EditInfoActivity$19$1(EditInfoActivity.19 param19, boolean paramBoolean, Card paramCard, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$19.a.b(false);
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$19.a.h);
      this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$19.a.setResult(-1, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$19.a.finish();
      return;
    }
    if (this.jdField_a_of_type_Int == 40) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$19.a, 1, 2131719095, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$19.a.getTitleBarHeight());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$19.a.onBackEvent();
      return;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$19.a, 2, 2131694234, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$19.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.19.1
 * JD-Core Version:    0.7.0.1
 */