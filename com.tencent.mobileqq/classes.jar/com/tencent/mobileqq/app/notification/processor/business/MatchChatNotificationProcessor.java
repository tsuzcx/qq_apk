package com.tencent.mobileqq.app.notification.processor.business;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;

public class MatchChatNotificationProcessor
  extends CaseDefaultNotificationProcessor
{
  protected MatchChatNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  public int b(Message paramMessage)
  {
    return 266;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.MatchChatNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */