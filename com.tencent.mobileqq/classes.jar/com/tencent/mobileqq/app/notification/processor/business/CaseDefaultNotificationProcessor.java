package com.tencent.mobileqq.app.notification.processor.business;

import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.notification.struct.AbstractBusinessFoldedNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;

public class CaseDefaultNotificationProcessor
  extends AbstractBusinessFoldedNotificationProcessor
{
  public CaseDefaultNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  private void a(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.b() == 1)
    {
      if ((AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(paramMessage.frienduin)) || (AppConstants.MAYKNOW_RECOMMEND_UIN.equals(paramMessage.frienduin)) || (AppConstants.FRIEND_ANNIVER_UIN.equals(paramMessage.frienduin)))
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramMessage.senderuin, true);
        this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a(paramMessage);
      }
    }
    else {
      return;
    }
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramMessage.frienduin, true);
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a(paramMessage);
  }
  
  public int a(Message paramMessage)
  {
    return -113;
  }
  
  public NotificationElement a(Message paramMessage)
  {
    a(paramMessage);
    String str = a() + ": ";
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b(str);
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d(c());
    b(paramMessage);
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.CaseDefaultNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */