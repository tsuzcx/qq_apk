package com.tencent.mobileqq.activity.qwallet.notifymsg;

import akwn;
import albw;
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
    QQAppInterface localQQAppInterface = albw.a();
    if (localQQAppInterface != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        akwn localakwn = (akwn)localIterator.next();
        if ((localakwn != null) && (localakwn.a != null)) {
          localQQAppInterface.getMessageFacade().updateMsgFieldByUniseq(localakwn.a.frienduin, localakwn.a.istroop, localakwn.a.uniseq, "extStr", localakwn.a.extStr);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.2
 * JD-Core Version:    0.7.0.1
 */