package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Message;
import aubr;
import bbnl;
import bckq;
import bckr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TroopChatPie$26
  implements Runnable
{
  TroopChatPie$26(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (this.this$0.N) {}
    do
    {
      return;
      localObject = bckr.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localObject == null) || (((bckq)localObject).jdField_a_of_type_JavaLangString.isEmpty()));
    Object localObject = (aubr)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    if (localObject != null) {
      ((aubr)localObject).a(Long.valueOf(Long.parseLong(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)), true).a();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "handleTroopNotificationMsg. sendMessage = MSG_SHOW_TROOP_FEEDS");
    }
    localObject = TroopChatPie.i(this.this$0).obtainMessage(29);
    ((Message)localObject).arg1 = 1;
    TroopChatPie.j(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.26
 * JD-Core Version:    0.7.0.1
 */