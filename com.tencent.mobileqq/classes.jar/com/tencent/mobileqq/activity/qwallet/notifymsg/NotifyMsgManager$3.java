package com.tencent.mobileqq.activity.qwallet.notifymsg;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

final class NotifyMsgManager$3
  implements Runnable
{
  NotifyMsgManager$3(MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = QWalletTools.a();
    if ((localQQAppInterface != null) && (this.a != null)) {
      localQQAppInterface.getMessageFacade().a(this.a.frienduin, this.a.istroop, this.a.uniseq, "extStr", this.a.extStr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.3
 * JD-Core Version:    0.7.0.1
 */