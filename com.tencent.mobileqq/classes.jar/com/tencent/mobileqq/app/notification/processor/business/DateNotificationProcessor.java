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
    String str;
    Object localObject;
    if (AppConstants.LBS_HELLO_UIN.equals(paramMessage.frienduin))
    {
      str = ContactUtils.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.senderuin);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = paramMessage.senderuin;
      }
      str = (String)localObject + "(" + a() + "):";
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b(str);
      if (paramMessage.msgtype != -2053) {
        break label219;
      }
      localObject = paramMessage.nickName;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131698958) + (String)localObject + c();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.b() == 1)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getStrangerFaceBitmap(paramMessage.frienduin, 200);
        this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a((Bitmap)localObject);
      }
      b(paramMessage);
      return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement;
      str = ContactUtils.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin);
      localObject = str;
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      localObject = paramMessage.frienduin;
      break;
      label219:
      if (paramMessage.msgtype == -2068)
      {
        localObject = c();
        this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject);
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNamePostfix(paramMessage) + (String)localObject + ": " + c();
        this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.DateNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */