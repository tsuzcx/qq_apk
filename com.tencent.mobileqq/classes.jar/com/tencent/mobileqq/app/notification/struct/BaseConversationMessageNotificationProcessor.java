package com.tencent.mobileqq.app.notification.struct;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageNotifiableChecker;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.notification.NotifyIdManager;

public abstract class BaseConversationMessageNotificationProcessor
  extends BaseUinTypeProcessor
{
  protected BaseConversationMessageNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = MessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a(), paramMessage);
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a(paramMessage);
  }
  
  private void b(Message paramMessage)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.b() > 1) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool = NotifyIdManager.a(paramMessage);
    if ((i != 0) && (bool))
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a();
      if (paramMessage.istroop == 0) {
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramMessage.frienduin, true);
      } else if (paramMessage.istroop == 1) {
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopFaceBitmap(paramMessage.frienduin, (byte)3, false, false);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a(localBitmap);
    }
  }
  
  private void c(Message paramMessage)
  {
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.messageNotifiableChecker().a(paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a());
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a(paramMessage);
  }
  
  private void d(Message paramMessage)
  {
    paramMessage = MessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.c(), paramMessage);
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.c(paramMessage);
  }
  
  private void e(Message paramMessage)
  {
    BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    if (((paramMessage.istroop == 0) || (paramMessage.istroop == 1) || (paramMessage.istroop == 3000)) && (paramMessage.msgtype == -2016))
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(localBaseApplication, paramMessage, true);
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a(paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b(paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d(paramMessage);
    }
  }
  
  protected final int b(Message paramMessage)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isShowMsgContent();
    int i = paramMessage.istroop;
    paramMessage = paramMessage.frienduin;
    if (NotifyIdManager.a(i, paramMessage))
    {
      if (bool) {
        return NotifyIdManager.a().a(paramMessage);
      }
      return 265;
    }
    return -113;
  }
  
  @Nullable
  protected final NotificationElement b(Message paramMessage)
  {
    a();
    a(paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement);
    d(paramMessage);
    e(paramMessage);
    b(paramMessage);
    a(paramMessage);
    c(paramMessage);
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.struct.BaseConversationMessageNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */