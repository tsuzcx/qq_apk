package com.tencent.mobileqq.app.notification.processor.business;

import android.text.TextUtils;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.struct.AbstractBusinessFoldedNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.utils.ContactUtils;

public class DeviceMsgNotificationProcessor
  extends AbstractBusinessFoldedNotificationProcessor
{
  protected DeviceMsgNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  public NotificationElement a(Message paramMessage)
  {
    Object localObject1;
    if (("device_groupchat".equals(paramMessage.extStr)) && ((paramMessage.msgtype == -4501) || (paramMessage.msgtype == -4508)))
    {
      Object localObject2 = ContactUtils.a(this.a, paramMessage.senderuin, true);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramMessage.senderuin))
      {
        localObject1 = localObject2;
        if (paramMessage.senderuin.equals(paramMessage.frienduin)) {
          localObject1 = SmartDeviceUtil.a(((SmartDeviceProxyMgr)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).g(Long.parseLong(paramMessage.senderuin)));
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(": ");
      ((StringBuilder)localObject1).append(d());
      localObject1 = ((StringBuilder)localObject1).toString();
      this.b.d((String)localObject1);
    }
    else
    {
      localObject1 = d();
      this.b.d((String)localObject1);
    }
    c(paramMessage);
    return this.b;
  }
  
  public int b(Message paramMessage)
  {
    return -113;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.DeviceMsgNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */