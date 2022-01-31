package com.tencent.mobileqq.activity;

import acdv;
import android.widget.TextView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.FriendInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class AddRequestActivity$8$1$1
  implements Runnable
{
  AddRequestActivity$8$1$1(AddRequestActivity.8.1 param1, Card paramCard) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity$8$1.a.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity$8$1.a.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity$8$1.a.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity$8$1.a.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.has() == true))
    {
      AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity$8$1.a.a).setText(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity$8$1.a.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.get());
      AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity$8$1.a.a).setVisibility(0);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.AddRequestActivity", 2, "Card find Uin :" + this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity$8$1.a.a.jdField_a_of_type_JavaLangString + "age:" + this.jdField_a_of_type_ComTencentMobileqqDataCard.age + "gender:" + this.jdField_a_of_type_ComTencentMobileqqDataCard.shGender);
      }
      return;
      AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity$8$1.a.a).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity$8$1.a.a.a(this.jdField_a_of_type_ComTencentMobileqqDataCard);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.8.1.1
 * JD-Core Version:    0.7.0.1
 */