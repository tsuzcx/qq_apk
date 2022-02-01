package com.tencent.mobileqq.app.notification.processor.business;

import android.graphics.Bitmap;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.struct.AbstractBusinessFoldedNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.qphone.base.util.BaseApplication;

public class LimitChatNotificationProcessor
  extends AbstractBusinessFoldedNotificationProcessor
{
  protected LimitChatNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  public int a(Message paramMessage)
  {
    return 266;
  }
  
  public NotificationElement a(Message paramMessage)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramMessage.frienduin, true);
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a((Bitmap)localObject);
    localObject = a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131698756);
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.c(str);
    str = (String)localObject + "(" + a() + "): " + c();
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b(str);
    localObject = (String)localObject + ": " + c();
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b(this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b() + this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a());
    a(paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement);
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.LimitChatNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */