package com.tencent.mobileqq.activity.qwallet.notifymsg;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Iterator;

final class NotifyMsgManager$2
  implements Runnable
{
  NotifyMsgManager$2(ArrayList paramArrayList) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = QWalletTools.a();
    if (localQQAppInterface != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        NotifyMsgManager.WaitRecord localWaitRecord = (NotifyMsgManager.WaitRecord)localIterator.next();
        if ((localWaitRecord != null) && (localWaitRecord.a != null)) {
          localQQAppInterface.getMessageFacade().a(localWaitRecord.a.frienduin, localWaitRecord.a.istroop, localWaitRecord.a.uniseq, "extStr", localWaitRecord.a.extStr);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.2
 * JD-Core Version:    0.7.0.1
 */