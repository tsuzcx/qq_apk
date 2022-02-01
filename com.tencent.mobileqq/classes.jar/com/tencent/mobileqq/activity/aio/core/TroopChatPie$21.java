package com.tencent.mobileqq.activity.aio.core;

import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationFlagMsg;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TroopChatPie$21
  implements Runnable
{
  TroopChatPie$21(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (this.this$0.I) {}
    do
    {
      return;
      localObject = TroopNotificationHelper.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    } while ((localObject == null) || (((TroopNotificationFlagMsg)localObject).a.isEmpty()));
    Object localObject = (TroopInfoManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    if (localObject != null) {
      ((TroopInfoManager)localObject).a(Long.valueOf(Long.parseLong(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)), true).a();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.b, 2, "handleTroopNotificationMsg. sendMessage = MSG_SHOW_TROOP_FEEDS");
    }
    localObject = this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(29);
    ((Message)localObject).arg1 = 1;
    this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.21
 * JD-Core Version:    0.7.0.1
 */