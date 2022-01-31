package com.tencent.mobileqq.activity.qwallet.notifymsg;

import aivi;
import ajaf;
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
    QQAppInterface localQQAppInterface = ajaf.a();
    if (localQQAppInterface != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        aivi localaivi = (aivi)localIterator.next();
        if ((localaivi != null) && (localaivi.a != null)) {
          localQQAppInterface.a().a(localaivi.a.frienduin, localaivi.a.istroop, localaivi.a.uniseq, "extStr", localaivi.a.extStr);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.2
 * JD-Core Version:    0.7.0.1
 */