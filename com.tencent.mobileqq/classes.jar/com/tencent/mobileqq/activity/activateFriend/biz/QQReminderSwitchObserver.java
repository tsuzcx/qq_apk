package com.tencent.mobileqq.activity.activateFriend.biz;

import com.tencent.mobileqq.app.CardObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class QQReminderSwitchObserver
  extends CardObserver
{
  ArrayList<WeakReference<QQReminderSwitchObserver.QQReminderSwitchListener>> a = new ArrayList();
  
  public void a(WeakReference<QQReminderSwitchObserver.QQReminderSwitchListener> paramWeakReference)
  {
    try
    {
      this.a.add(paramWeakReference);
      return;
    }
    finally
    {
      paramWeakReference = finally;
      throw paramWeakReference;
    }
  }
  
  protected void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        QQReminderSwitchObserver.QQReminderSwitchListener localQQReminderSwitchListener = (QQReminderSwitchObserver.QQReminderSwitchListener)((WeakReference)localIterator.next()).get();
        if (localQQReminderSwitchListener != null) {
          localQQReminderSwitchListener.a(paramBoolean2);
        }
        localIterator.remove();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.QQReminderSwitchObserver
 * JD-Core Version:    0.7.0.1
 */