package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Message;
import askq;
import azpa;
import balp;
import balq;
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
      localObject = balq.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localObject == null) || (((balp)localObject).jdField_a_of_type_JavaLangString.isEmpty()));
    Object localObject = (askq)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    if (localObject != null) {
      ((askq)localObject).a(Long.valueOf(Long.parseLong(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)), true).a();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "handleTroopNotificationMsg. sendMessage = MSG_SHOW_TROOP_FEEDS");
    }
    localObject = TroopChatPie.i(this.this$0).obtainMessage(29);
    ((Message)localObject).arg1 = 1;
    TroopChatPie.j(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.26
 * JD-Core Version:    0.7.0.1
 */