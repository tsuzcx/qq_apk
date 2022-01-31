package com.tencent.mobileqq.activity.qwallet.notifymsg;

import ahbd;
import ahiw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Iterator;

public final class NotifyMsgManager$2
  implements Runnable
{
  public NotifyMsgManager$2(ArrayList paramArrayList) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = ahiw.a();
    if (localQQAppInterface != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ahbd localahbd = (ahbd)localIterator.next();
        if ((localahbd != null) && (localahbd.a != null)) {
          localQQAppInterface.a().a(localahbd.a.frienduin, localahbd.a.istroop, localahbd.a.uniseq, "extStr", localahbd.a.extStr);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.2
 * JD-Core Version:    0.7.0.1
 */