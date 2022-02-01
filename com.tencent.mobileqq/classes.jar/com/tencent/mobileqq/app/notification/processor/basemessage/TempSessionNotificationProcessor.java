package com.tencent.mobileqq.app.notification.processor.basemessage;

import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.notification.struct.BaseConversationMessageNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;

public final class TempSessionNotificationProcessor
  extends BaseConversationMessageNotificationProcessor
{
  protected TempSessionNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  private void e(Message paramMessage)
  {
    if (this.a.getMessageFacade().d.d() == 1)
    {
      if ((!AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(paramMessage.frienduin)) && (!AppConstants.MAYKNOW_RECOMMEND_UIN.equals(paramMessage.frienduin)) && (!AppConstants.FRIEND_ANNIVER_UIN.equals(paramMessage.frienduin)))
      {
        paramMessage = this.a.getFaceBitmap(paramMessage.frienduin, true);
        this.b.a(paramMessage);
        return;
      }
      paramMessage = this.a.getFaceBitmap(paramMessage.senderuin, true);
      this.b.a(paramMessage);
    }
  }
  
  public NotificationElement a(Message paramMessage)
  {
    e(paramMessage);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(b());
    ((StringBuilder)localObject).append(": ");
    localObject = ((StringBuilder)localObject).toString();
    this.b.b((String)localObject);
    this.b.d(d());
    return c(paramMessage);
  }
  
  public int b(Message paramMessage)
  {
    return d(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.basemessage.TempSessionNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */