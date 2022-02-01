package com.tencent.mobileqq.app.notification.struct;

import android.content.Intent;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

abstract class BaseUinTypeProcessor
  implements MessageProcessable
{
  protected final QQAppInterface a;
  protected final NotificationElement b;
  
  protected BaseUinTypeProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    this.a = paramQQAppInterface;
    this.b = paramNotificationElement;
  }
  
  protected final Intent a()
  {
    return this.b.b();
  }
  
  protected final void a(Message paramMessage, NotificationElement paramNotificationElement)
  {
    if (paramMessage.counter > 1)
    {
      String str = paramNotificationElement.d();
      if (paramMessage.counter > 100)
      {
        paramMessage = new StringBuilder();
        paramMessage.append(str);
        paramMessage.append(" (");
        paramMessage.append(this.a.getApp().getString(2131892193));
        paramMessage.append(")");
        paramMessage = paramMessage.toString();
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(" (");
        localStringBuilder.append(paramMessage.counter);
        localStringBuilder.append(this.a.getApp().getString(2131892125));
        localStringBuilder.append(")");
        paramMessage = localStringBuilder.toString();
      }
      paramNotificationElement.c(paramMessage);
    }
  }
  
  public abstract int b(Message paramMessage);
  
  protected final String b()
  {
    return this.b.d();
  }
  
  protected final String c()
  {
    return this.b.e();
  }
  
  protected final String d()
  {
    return this.b.a();
  }
  
  protected final void e()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b.c());
    ((StringBuilder)localObject).append(this.b.a());
    localObject = ((StringBuilder)localObject).toString();
    this.b.b((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.struct.BaseUinTypeProcessor
 * JD-Core Version:    0.7.0.1
 */