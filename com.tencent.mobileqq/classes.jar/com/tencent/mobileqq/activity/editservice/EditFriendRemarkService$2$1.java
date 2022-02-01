package com.tencent.mobileqq.activity.editservice;

import android.content.Intent;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.widget.QQToast;

class EditFriendRemarkService$2$1
  implements Runnable
{
  EditFriendRemarkService$2$1(EditFriendRemarkService.2 param2, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    EditFriendRemarkService.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditserviceEditFriendRemarkService$2.a).loadingProgress(false);
    if (this.jdField_a_of_type_Boolean)
    {
      EditFriendRemarkService.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditserviceEditFriendRemarkService$2.a).putExtra("result", this.jdField_a_of_type_JavaLangString);
      EditFriendRemarkService.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditserviceEditFriendRemarkService$2.a).onFinishForResult(-1, EditFriendRemarkService.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditserviceEditFriendRemarkService$2.a));
      return;
    }
    QQToast.a(EditFriendRemarkService.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditserviceEditFriendRemarkService$2.a), 2, 2131694199, 0).a();
    EditFriendRemarkService.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditserviceEditFriendRemarkService$2.a).onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditFriendRemarkService.2.1
 * JD-Core Version:    0.7.0.1
 */