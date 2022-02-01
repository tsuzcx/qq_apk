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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNamePostfix(paramMessage);
    Object localObject2;
    if ((paramMessage.nickName != null) && (!"".equals(paramMessage.nickName)))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramMessage.nickName);
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append(a());
      ((StringBuilder)localObject2).append("):");
      localObject2 = ((StringBuilder)localObject2).toString();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b((String)localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramMessage.nickName);
      ((StringBuilder)localObject2).append(": ");
      ((StringBuilder)localObject2).append(c());
      localObject1 = ((StringBuilder)localObject2).toString();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject1);
    }
    else
    {
      localObject2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.senderuin, 0);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("(");
      ((StringBuilder)localObject3).append(a());
      ((StringBuilder)localObject3).append("):");
      localObject3 = ((StringBuilder)localObject3).toString();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b((String)localObject3);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(": ");
      ((StringBuilder)localObject3).append(c());
      localObject1 = ((StringBuilder)localObject3).toString();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.b() == 1)
    {
      localObject1 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
      if (localObject1 != null)
      {
        localObject1 = ((DiscussionHandler)localObject1).a(paramMessage.frienduin, true);
        this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a((Bitmap)localObject1);
      }
    }
    return b(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.basemessage.DiscussionNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */