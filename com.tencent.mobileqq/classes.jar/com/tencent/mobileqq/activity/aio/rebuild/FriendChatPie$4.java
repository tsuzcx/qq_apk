package com.tencent.mobileqq.activity.aio.rebuild;

import aeom;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class FriendChatPie$4
  implements Runnable
{
  public FriendChatPie$4(aeom paramaeom) {}
  
  public void run()
  {
    AVNotifyCenter localAVNotifyCenter = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {}
    for (;;)
    {
      return;
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null)) {
        try
        {
          long l = Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
          if (localAVNotifyCenter.a(l))
          {
            this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, localAVNotifyCenter.a(Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue()));
            localAVNotifyCenter.a(Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), false, -1);
            return;
          }
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.4
 * JD-Core Version:    0.7.0.1
 */