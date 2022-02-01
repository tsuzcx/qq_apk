package com.tencent.mobileqq.app.notification.struct;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.notification.NotifyIdManager;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractBusinessFoldedNotificationProcessor
  extends BaseUinTypeProcessor
{
  protected AbstractBusinessFoldedNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  private void f()
  {
    Intent localIntent = this.b.b();
    String str3 = this.b.c();
    String str1 = this.b.d();
    String str2 = this.b.e();
    Bitmap localBitmap = this.b.f();
    int i = this.a.getMessageFacade().d.a(true);
    StringBuffer localStringBuffer = new StringBuffer();
    int j = this.a.getMessageFacade().d.b(true);
    localStringBuffer.append(String.format(this.a.getApp().getString(2131892190), new Object[] { Integer.valueOf(j) }));
    if (i > 1000)
    {
      localStringBuffer.append(this.a.getApp().getString(2131892191));
    }
    else
    {
      localStringBuffer.append(i);
      localStringBuffer.append(this.a.getApp().getString(2131892125));
    }
    if (j > 1)
    {
      localIntent = new Intent(this.a.getApp(), SplashActivity.class);
      localIntent.addFlags(335544320);
      localIntent.putExtra("tab_index", FrameControllerUtil.a);
      str1 = this.a.getApp().getString(2131892207);
      str2 = localStringBuffer.toString();
      localBitmap = null;
    }
    else
    {
      QLog.d("[NotificationRebuild] [NotificationProcessor] AbstractBuildLastDefaultNotificationProcessor", 1, new Object[] { "[notification] buildNotificationElement: invoked. 非独立会话数<=1，保持旧的跳转、图标、wording 已经从上面switch-case中获取 ", " conversationSizeNotSeparate: ", Integer.valueOf(j) });
    }
    this.b.a(localBitmap);
    this.b.a(localIntent);
    this.b.c(str1);
    this.b.d(str2);
    this.b.b(str3);
  }
  
  @NotNull
  protected final NotificationElement c(Message paramMessage)
  {
    e();
    a(paramMessage, this.b);
    int i;
    if (this.a.getMessageFacade().d.d() > 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (this.a.getMessageFacade().d.a(true) == 0) {
        return null;
      }
      f();
    }
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
 * Qualified Name:     com.tencent.mobileqq.app.notification.struct.AbstractBusinessFoldedNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */