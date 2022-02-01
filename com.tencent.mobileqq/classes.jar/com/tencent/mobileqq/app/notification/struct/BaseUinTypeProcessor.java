package com.tencent.mobileqq.app.notification.struct;

import android.content.Intent;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public abstract class BaseUinTypeProcessor
  implements MessageProcessable
{
  protected final QQAppInterface a;
  protected final NotificationElement a;
  
  protected BaseUinTypeProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement = paramNotificationElement;
  }
  
  public abstract int a(Message paramMessage);
  
  protected final Intent a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a();
  }
  
  protected final String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.c();
  }
  
  protected final void a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b() + this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a();
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b(str);
  }
  
  protected final void a(Message paramMessage, NotificationElement paramNotificationElement)
  {
    String str;
    if (paramMessage.counter > 1)
    {
      str = paramNotificationElement.c();
      if (paramMessage.counter <= 100) {
        break label68;
      }
    }
    label68:
    for (paramMessage = str + " (" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694545) + ")";; paramMessage = str + " (" + paramMessage.counter + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694480) + ")")
    {
      paramNotificationElement.c(paramMessage);
      return;
    }
  }
  
  protected final String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d();
  }
  
  protected final String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.struct.BaseUinTypeProcessor
 * JD-Core Version:    0.7.0.1
 */