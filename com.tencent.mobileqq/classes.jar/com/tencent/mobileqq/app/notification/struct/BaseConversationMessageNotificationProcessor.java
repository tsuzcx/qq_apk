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
  
  private void e(Message paramMessage)
  {
    paramMessage = MessageNotificationSettingManager.a(this.a).a(this.b.f(), paramMessage);
    this.b.a(paramMessage);
  }
  
  private void f(Message paramMessage)
  {
    int i;
    if (this.a.getMessageFacade().d.d() > 1) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool = NotifyIdManager.a(paramMessage);
    if ((i != 0) && (bool))
    {
      Bitmap localBitmap = this.b.f();
      if (paramMessage.istroop == 0)
      {
        paramMessage = this.a.getFaceBitmap(paramMessage.frienduin, true);
      }
      else if (paramMessage.istroop == 1)
      {
        paramMessage = this.a.getTroopFaceBitmap(paramMessage.frienduin, (byte)3, false, false);
      }
      else
      {
        i = paramMessage.istroop;
        paramMessage = localBitmap;
      }
      this.b.a(paramMessage);
    }
  }
  
  private void g(Message paramMessage)
  {
    paramMessage = this.a.messageNotifiableChecker().a(paramMessage, this.b.b());
    this.b.a(paramMessage);
  }
  
  private void h(Message paramMessage)
  {
    paramMessage = MessageNotificationSettingManager.a(this.a).b(this.b.d(), paramMessage);
    this.b.c(paramMessage);
  }
  
  private void i(Message paramMessage)
  {
    BaseApplication localBaseApplication = this.a.getApp();
    if (((paramMessage.istroop == 0) || (paramMessage.istroop == 1) || (paramMessage.istroop == 3000)) && (paramMessage.msgtype == -2016))
    {
      paramMessage = this.a.getMessageFacade().c(localBaseApplication, paramMessage, true);
      this.b.a(paramMessage);
      this.b.b(paramMessage);
      this.b.d(paramMessage);
    }
  }
  
  @Nullable
  protected final NotificationElement c(Message paramMessage)
  {
    e();
    a(paramMessage, this.b);
    h(paramMessage);
    i(paramMessage);
    f(paramMessage);
    e(paramMessage);
    g(paramMessage);
    return this.b;
  }
  
  protected final int d(Message paramMessage)
  {
    boolean bool = this.a.isShowMsgContent();
    int i = paramMessage.istroop;
    paramMessage = paramMessage.frienduin;
    if (NotifyIdManager.a(i, paramMessage))
    {
      if (bool) {
        return NotifyIdManager.b().a(paramMessage);
      }
      return 265;
    }
    return -113;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.struct.BaseConversationMessageNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */