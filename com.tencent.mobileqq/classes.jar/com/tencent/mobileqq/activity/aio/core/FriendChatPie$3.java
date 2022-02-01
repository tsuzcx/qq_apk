package com.tencent.mobileqq.activity.aio.core;

import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class FriendChatPie$3
  implements Runnable
{
  FriendChatPie$3(FriendChatPie paramFriendChatPie) {}
  
  public void run()
  {
    AVNotifyCenter localAVNotifyCenter = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter();
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return;
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) {
      return;
    }
    try
    {
      long l = Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
      if (localAVNotifyCenter.a(l))
      {
        FriendChatPie localFriendChatPie = this.this$0;
        localFriendChatPie.a(localFriendChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, localAVNotifyCenter.a(Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue()));
        localAVNotifyCenter.a(Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), false, -1);
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.3
 * JD-Core Version:    0.7.0.1
 */