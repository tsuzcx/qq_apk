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
    Object localObject2 = a().getStringExtra("subAccountLatestNick");
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = paramMessage.senderuin;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(a());
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(c());
    localObject2 = ((StringBuilder)localObject2).toString();
    this.a.b((String)localObject2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(c());
    Object localObject1 = ((StringBuilder)localObject2).toString();
    this.a.d((String)localObject1);
    this.a.a(null);
    b(paramMessage);
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.SubAccountAssistantNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */