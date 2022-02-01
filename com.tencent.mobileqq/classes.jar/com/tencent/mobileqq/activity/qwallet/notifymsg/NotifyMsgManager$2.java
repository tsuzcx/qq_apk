package com.tencent.mobileqq.activity.qwallet.notifymsg;

import aldb;
import alil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Iterator;

public final class NotifyMsgManager$2
  implements Runnable
{
  public NotifyMsgManager$2(ArrayList paramArrayList) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = alil.a();
    if (localQQAppInterface != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        aldb localaldb = (aldb)localIterator.next();
        if ((localaldb != null) && (localaldb.a != null)) {
          localQQAppInterface.a().a(localaldb.a.frienduin, localaldb.a.istroop, localaldb.a.uniseq, "extStr", localaldb.a.extStr);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.2
 * JD-Core Version:    0.7.0.1
 */