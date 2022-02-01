package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push;

import com.tencent.commonsdk.util.notification.QQNotificationManager;

final class RIJPushNotification$1
  implements Runnable
{
  public void run()
  {
    QQNotificationManager.getInstance().cancel("RIJPushNotification", 526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJPushNotification.1
 * JD-Core Version:    0.7.0.1
 */