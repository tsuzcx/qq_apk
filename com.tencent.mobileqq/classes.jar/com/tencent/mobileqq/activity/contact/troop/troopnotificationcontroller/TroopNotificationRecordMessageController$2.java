package com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller;

import ajih;
import anyv;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class TroopNotificationRecordMessageController$2
  implements Runnable
{
  public TroopNotificationRecordMessageController$2(ajih paramajih) {}
  
  public void run()
  {
    QQMessageFacade localQQMessageFacade = this.this$0.a.getMessageFacade();
    List localList = ajih.a(this.this$0);
    String str = String.valueOf(this.this$0.a.getAccount());
    if ((anyv.a((ArrayList)ajih.a(this.this$0))) && (this.this$0.a.isBackgroundStop)) {}
    for (boolean bool = true;; bool = false)
    {
      localQQMessageFacade.addMessage(localList, str, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller.TroopNotificationRecordMessageController.2
 * JD-Core Version:    0.7.0.1
 */