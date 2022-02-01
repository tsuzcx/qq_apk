package com.tencent.mobileqq.app.notification.processor.business;

import android.content.Intent;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.struct.AbstractBusinessFoldedNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;

public class SubAccountAssistantNotificationProcessor
  extends AbstractBusinessFoldedNotificationProcessor
{
  protected SubAccountAssistantNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  public int a(Message paramMessage)
  {
    return -113;
  }
  
  public NotificationElement a(Message paramMessage)
  {
    String str2 = a().getStringExtra("subAccountLatestNick");
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = paramMessage.senderuin;
    }
    str2 = a() + "-" + str1 + ":" + c();
    this.a.b(str2);
    String str1 = str1 + ":" + c();
    this.a.d(str1);
    this.a.a(null);
    b(paramMessage);
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.SubAccountAssistantNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */