package com.tencent.mobileqq.app;

import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;

class MessageHandler$9
  implements Runnable
{
  MessageHandler$9(MessageHandler paramMessageHandler, QQNotificationManager paramQQNotificationManager) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(5000L);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg.MessageHandler", 4, "PConline time expired cancel now");
      }
      this.a.cancel("Q.msg.MessageHandler_PcOnlineNotifition", 264);
      MessageHandler.a(this.this$0, false);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "PConline thread Interrupt");
      }
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.9
 * JD-Core Version:    0.7.0.1
 */