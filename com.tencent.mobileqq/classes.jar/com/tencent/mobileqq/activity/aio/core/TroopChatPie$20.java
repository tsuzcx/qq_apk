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

class TroopChatPie$20
  implements Runnable
{
  TroopChatPie$20(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (this.this$0.B) {
      return;
    }
    Object localObject = TroopNotificationHelper.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if ((localObject != null) && (!((TroopNotificationFlagMsg)localObject).a.isEmpty()))
    {
      localObject = (TroopInfoManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.20
 * JD-Core Version:    0.7.0.1
 */