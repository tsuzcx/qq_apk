package com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller;

import ajih;
import bdzy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopNotificationRecordMessageController$1
  implements Runnable
{
  public TroopNotificationRecordMessageController$1(ajih paramajih) {}
  
  public void run()
  {
    ajih.a(this.this$0, this.this$0.a.getMessageFacade().getAllMessages(AppConstants.TROOP_SYSTEM_MSG_UIN, 0, null), bdzy.a().a(this.this$0.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller.TroopNotificationRecordMessageController.1
 * JD-Core Version:    0.7.0.1
 */