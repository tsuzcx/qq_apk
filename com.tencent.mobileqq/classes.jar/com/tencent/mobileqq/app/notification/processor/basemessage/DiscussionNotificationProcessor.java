package com.tencent.mobileqq.app.notification.processor.basemessage;

import android.graphics.Bitmap;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.notification.struct.BaseConversationMessageNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.utils.ContactUtils;

public final class DiscussionNotificationProcessor
  extends BaseConversationMessageNotificationProcessor
{
  protected DiscussionNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  public int a(Message paramMessage)
  {
    return b(paramMessage);
  }
  
  public NotificationElement a(Message paramMessage)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNamePostfix(paramMessage);
    String str1;
    if ((paramMessage.nickName != null) && (!"".equals(paramMessage.nickName)))
    {
      str1 = (String)localObject + paramMessage.nickName + "(" + a() + "):";
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b(str1);
      localObject = (String)localObject + paramMessage.nickName + ": " + c();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.b() == 1)
      {
        localObject = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
        if (localObject != null)
        {
          localObject = ((DiscussionHandler)localObject).a(paramMessage.frienduin, true);
          this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a((Bitmap)localObject);
        }
      }
      return b(paramMessage);
      str1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.senderuin, 0);
      String str2 = (String)localObject + str1 + "(" + a() + "):";
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b(str2);
      localObject = (String)localObject + str1 + ": " + c();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.basemessage.DiscussionNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */