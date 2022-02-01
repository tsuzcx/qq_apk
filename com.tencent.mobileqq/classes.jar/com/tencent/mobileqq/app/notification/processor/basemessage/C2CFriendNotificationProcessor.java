package com.tencent.mobileqq.app.notification.processor.basemessage;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.notification.struct.BaseConversationMessageNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.mutualmark.oldlogic.ReactivePushHelper;
import com.tencent.util.notification.NotifyIdManager;

public final class C2CFriendNotificationProcessor
  extends BaseConversationMessageNotificationProcessor
{
  protected C2CFriendNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  private void a(Message paramMessage)
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a();
    localIntent.putExtra("need_report", true);
    localIntent.putExtra("incoming_msguid", paramMessage.msgUid);
    localIntent.putExtra("incoming_shmsgseq", paramMessage.shmsgseq);
    localIntent.putExtra("KEY_FROM", "notifcation");
    if (ReactivePushHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage)) {
      localIntent.putExtra("key_reactive_push_tip", true);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a(localIntent);
  }
  
  public int a(Message paramMessage)
  {
    return b(paramMessage);
  }
  
  public NotificationElement a(Message paramMessage)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.b();
    int i = 1;
    if (j == 1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramMessage.frienduin, true);
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a((Bitmap)localObject1);
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(a());
    ((StringBuilder)localObject1).append(": ");
    localObject1 = ((StringBuilder)localObject1).toString();
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b((String)localObject1);
    localObject1 = c();
    Object localObject2 = NotifyIdManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject2 != null)
    {
      localObject2 = ((NotifyIdManager)localObject2).a(a(), paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.c((String)localObject2);
    }
    localObject1 = MessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((String)localObject1, paramMessage);
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject1);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.b() > 1) {
      i = 0;
    }
    if (i != 0) {
      a(paramMessage);
    }
    return b(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.basemessage.C2CFriendNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */