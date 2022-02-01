package com.tencent.mobileqq.app.notification.struct;

import android.content.Intent;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

abstract class BaseUinTypeProcessor
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b());
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a());
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b((String)localObject);
  }
  
  protected final void a(Message paramMessage, NotificationElement paramNotificationElement)
  {
    if (paramMessage.counter > 1)
    {
      String str = paramNotificationElement.c();
      if (paramMessage.counter > 100)
      {
        paramMessage = new StringBuilder();
        paramMessage.append(str);
        paramMessage.append(" (");
        paramMessage.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694510));
        paramMessage.append(")");
        paramMessage = paramMessage.toString();
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(" (");
        localStringBuilder.append(paramMessage.counter);
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694445));
        localStringBuilder.append(")");
        paramMessage = localStringBuilder.toString();
      }
      paramNotificationElement.c(paramMessage);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.struct.BaseUinTypeProcessor
 * JD-Core Version:    0.7.0.1
 */