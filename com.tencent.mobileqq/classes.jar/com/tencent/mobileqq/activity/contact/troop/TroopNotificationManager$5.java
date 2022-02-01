package com.tencent.mobileqq.activity.contact.troop;

import aikq;
import aiks;
import apus;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class TroopNotificationManager$5
  implements Runnable
{
  public TroopNotificationManager$5(aikq paramaikq, apus paramapus) {}
  
  public void run()
  {
    Iterator localIterator = aikq.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      aiks localaiks = (aiks)localIterator.next();
      QLog.d("TroopNotificationManager", 1, "INewTroopNotificationUnreadCountChangedListener, newConf = " + this.a.toString());
      localaiks.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotificationManager.5
 * JD-Core Version:    0.7.0.1
 */