package com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;

class TroopNotificationRecordMessageController$1
  implements Runnable
{
  TroopNotificationRecordMessageController$1(TroopNotificationRecordMessageController paramTroopNotificationRecordMessageController) {}
  
  public void run()
  {
    TroopNotificationRecordMessageController.a(this.this$0, this.this$0.a.getMessageFacade().a(AppConstants.TROOP_SYSTEM_MSG_UIN, 0, null), GroupSystemMsgController.a().a(this.this$0.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller.TroopNotificationRecordMessageController.1
 * JD-Core Version:    0.7.0.1
 */