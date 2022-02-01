package com.tencent.mobileqq.app.notification.processor.business;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.notification.struct.AbstractBusinessFoldedNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class DateNotificationProcessor
  extends AbstractBusinessFoldedNotificationProcessor
{
  protected DateNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  public int a(Message paramMessage)
  {
    if (paramMessage.istroop == 1001) {
      return b(paramMessage);
    }
    return -113;
  }
  
  public NotificationElement a(Message paramMessage)
  {
    Object localObject1;
    if (AppConstants.LBS_HELLO_UIN.equals(paramMessage.frienduin))
    {
      localObject2 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.senderuin);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramMessage.senderuin;
      }
    }
    else
    {
      localObject2 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramMessage.frienduin;
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("(");
    ((StringBuilder)localObject2).append(a());
    ((StringBuilder)localObject2).append("):");
    localObject2 = ((StringBuilder)localObject2).toString();
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b((String)localObject2);
    if (paramMessage.msgtype == -2053)
    {
      localObject1 = paramMessage.nickName;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131699037));
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(c());
      localObject1 = ((StringBuilder)localObject2).toString();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject1);
    }
    else if (paramMessage.msgtype == -2068)
    {
      localObject1 = c();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject1);
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNamePostfix(paramMessage));
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(": ");
      ((StringBuilder)localObject2).append(c());
      localObject1 = ((StringBuilder)localObject2).toString();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.b() == 1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getStrangerFaceBitmap(paramMessage.frienduin, 200);
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a((Bitmap)localObject1);
    }
    b(paramMessage);
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.DateNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */