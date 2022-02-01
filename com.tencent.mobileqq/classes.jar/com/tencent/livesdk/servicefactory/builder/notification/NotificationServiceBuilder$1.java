package com.tencent.livesdk.servicefactory.builder.notification;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.notification.NotificationServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class NotificationServiceBuilder$1
  implements NotificationServiceAdapter
{
  NotificationServiceBuilder$1(NotificationServiceBuilder paramNotificationServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.notification.NotificationServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */