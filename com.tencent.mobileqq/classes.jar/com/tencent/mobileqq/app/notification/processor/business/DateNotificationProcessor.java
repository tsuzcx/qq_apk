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
  
  public NotificationElement a(Message paramMessage)
  {
    Object localObject1;
    if (AppConstants.LBS_HELLO_UIN.equals(paramMessage.frienduin))
    {
      localObject2 = ContactUtils.h(this.a, paramMessage.senderuin);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramMessage.senderuin;
      }
    }
    else
    {
      localObject2 = ContactUtils.h(this.a, paramMessage.frienduin);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramMessage.frienduin;
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("(");
    ((StringBuilder)localObject2).append(b());
    ((StringBuilder)localObject2).append("):");
    localObject2 = ((StringBuilder)localObject2).toString();
    this.b.b((String)localObject2);
    if (paramMessage.msgtype == -2053)
    {
      localObject1 = paramMessage.nickName;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.getApp().getString(2131897046));
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(d());
      localObject1 = ((StringBuilder)localObject2).toString();
      this.b.d((String)localObject1);
    }
    else if (paramMessage.msgtype == -2068)
    {
      localObject1 = d();
      this.b.d((String)localObject1);
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.getNamePostfix(paramMessage));
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(": ");
      ((StringBuilder)localObject2).append(d());
      localObject1 = ((StringBuilder)localObject2).toString();
      this.b.d((String)localObject1);
    }
    if (this.a.getMessageFacade().d.d() == 1)
    {
      localObject1 = this.a.getStrangerFaceBitmap(paramMessage.frienduin, 200);
      this.b.a((Bitmap)localObject1);
    }
    c(paramMessage);
    return this.b;
  }
  
  public int b(Message paramMessage)
  {
    if (paramMessage.istroop == 1001) {
      return d(paramMessage);
    }
    return -113;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.DateNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */