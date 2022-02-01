package com.tencent.mobileqq.activity.qwallet.notifymsg;

import albw;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public final class NotifyMsgManager$3
  implements Runnable
{
  public NotifyMsgManager$3(MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = albw.a();
    if ((localQQAppInterface != null) && (this.a != null)) {
      localQQAppInterface.getMessageFacade().updateMsgFieldByUniseq(this.a.frienduin, this.a.istroop, this.a.uniseq, "extStr", this.a.extStr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.3
 * JD-Core Version:    0.7.0.1
 */