package com.tencent.livesdk.servicefactory.builder.notification;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.notification.NotificationInterface;
import com.tencent.ilive.notification.NotificationService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class NotificationServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    NotificationService localNotificationService = new NotificationService();
    localNotificationService.setAdapter(new NotificationServiceBuilder.1(this, paramServiceAccessor));
    return localNotificationService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.notification.NotificationServiceBuilder
 * JD-Core Version:    0.7.0.1
 */