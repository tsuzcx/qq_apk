package com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

class TroopNotificationRecordMessageController$2
  implements Runnable
{
  TroopNotificationRecordMessageController$2(TroopNotificationRecordMessageController paramTroopNotificationRecordMessageController) {}
  
  public void run()
  {
    QQMessageFacade localQQMessageFacade = this.this$0.a.getMessageFacade();
    List localList = TroopNotificationRecordMessageController.a(this.this$0);
    String str = String.valueOf(this.this$0.a.getAccount());
    if ((MessageHandlerUtils.a((ArrayList)TroopNotificationRecordMessageController.a(this.this$0))) && (this.this$0.a.isBackgroundStop)) {}
    for (boolean bool = true;; bool = false)
    {
      localQQMessageFacade.a(localList, str, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller.TroopNotificationRecordMessageController.2
 * JD-Core Version:    0.7.0.1
 */