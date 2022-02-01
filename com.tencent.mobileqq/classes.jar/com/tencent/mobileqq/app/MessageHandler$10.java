package com.tencent.mobileqq.app;

import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;

class MessageHandler$10
  implements Runnable
{
  MessageHandler$10(MessageHandler paramMessageHandler, QQNotificationManager paramQQNotificationManager) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(5000L);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg.MessageHandler", 4, "IPADonline time expired cancel now");
      }
      this.a.cancel("Q.msg.MessageHandler_IpadOnlineNotifition", 263);
      MessageHandler.a(this.this$0, false);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.MessageHandler", 2, "IPADonline thread Interrupt");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.10
 * JD-Core Version:    0.7.0.1
 */