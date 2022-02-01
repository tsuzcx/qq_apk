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
  
  public int a(Message paramMessage)
  {
    return -113;
  }
  
  public NotificationElement a(Message paramMessage)
  {
    Object localObject1;
    if (("device_groupchat".equals(paramMessage.extStr)) && ((paramMessage.msgtype == -4501) || (paramMessage.msgtype == -4508)))
    {
      Object localObject2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.senderuin, true);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramMessage.senderuin))
      {
        localObject1 = localObject2;
        if (paramMessage.senderuin.equals(paramMessage.frienduin)) {
          localObject1 = SmartDeviceUtil.a(((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(paramMessage.senderuin)));
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(": ");
      ((StringBuilder)localObject1).append(c());
      localObject1 = ((StringBuilder)localObject1).toString();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject1);
    }
    else
    {
      localObject1 = c();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject1);
    }
    b(paramMessage);
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.DeviceMsgNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */