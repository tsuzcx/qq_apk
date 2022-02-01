package com.tencent.mobileqq.app;

import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.pushnotice.PushNoticeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.notification.NotifyIdManager;

class QQAppInterface$9
  implements Runnable
{
  QQAppInterface$9(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 265);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 267);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 274);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 236);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 268);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 272);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 271);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 273);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 239);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 266);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 524);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 527);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 3000529);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 3000531);
      NotifyIdManager localNotifyIdManager = (NotifyIdManager)this.this$0.getManager(QQManagerFactory.NOTIFY_ID_MANAGER);
      if (localNotifyIdManager != null) {
        localNotifyIdManager.a();
      }
      ((PushNoticeManager)this.this$0.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER)).a(localQQNotificationManager, -1);
      PushNoticeUtil.a(this.this$0.getApplication());
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "removeNotification");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("notification", 2, "removeNotification", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.9
 * JD-Core Version:    0.7.0.1
 */