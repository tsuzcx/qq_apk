package com.tencent.mobileqq.activity.contact.troop;

import aikq;
import aiks;
import java.util.Iterator;
import java.util.List;

public class TroopNotificationManager$4
  implements Runnable
{
  public TroopNotificationManager$4(aikq paramaikq, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = aikq.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((aiks)localIterator.next()).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotificationManager.4
 * JD-Core Version:    0.7.0.1
 */