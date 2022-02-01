package com.tencent.mobileqq.activity.editservice;

import android.content.Intent;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.widget.QQToast;

class EditMyNickService$2$1
  implements Runnable
{
  EditMyNickService$2$1(EditMyNickService.2 param2, boolean paramBoolean, Card paramCard, int paramInt) {}
  
  public void run()
  {
    EditMyNickService.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditserviceEditMyNickService$2.a).loadingProgress(false);
    if (this.jdField_a_of_type_Boolean)
    {
      EditMyNickService.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditserviceEditMyNickService$2.a).putExtra("result", this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
      EditMyNickService.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditserviceEditMyNickService$2.a).onFinishForResult(-1, EditMyNickService.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditserviceEditMyNickService$2.a));
      return;
    }
    if (this.jdField_a_of_type_Int == 40) {
      QQToast.a(EditMyNickService.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditserviceEditMyNickService$2.a), 1, 2131718812, 0).a();
    } else {
      QQToast.a(EditMyNickService.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditserviceEditMyNickService$2.a), 2, 2131694199, 0).a();
    }
    EditMyNickService.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditserviceEditMyNickService$2.a).onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditMyNickService.2.1
 * JD-Core Version:    0.7.0.1
 */