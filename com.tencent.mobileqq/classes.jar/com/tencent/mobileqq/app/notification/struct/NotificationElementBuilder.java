package com.tencent.mobileqq.app.notification.struct;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.MessageBriefGenerator;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class NotificationElementBuilder
{
  private final Message a;
  private final QQAppInterface b;
  private NotificationElement c;
  private final boolean d;
  
  public NotificationElementBuilder(QQAppInterface paramQQAppInterface, Message paramMessage, boolean paramBoolean)
  {
    this.a = paramMessage;
    this.b = paramQQAppInterface;
    this.c = new NotificationElement();
    this.d = paramBoolean;
  }
  
  private void b()
  {
    Object localObject = MessageBriefGenerator.a(this.b, this.a);
    this.c.a((String)localObject);
    String str = e().getStringExtra("uinname");
    if (str != null)
    {
      localObject = str;
      if (!"".equals(str)) {}
    }
    else
    {
      localObject = e().getStringExtra("uin");
    }
    this.c.c((String)localObject);
  }
  
  private void c()
  {
    Object localObject = this.b;
    localObject = ((QQAppInterface)localObject).getIntentByMessage(((QQAppInterface)localObject).getApp(), this.a, true);
    this.c.a((Intent)localObject);
    e().putExtra("entrance", 6);
    e().putExtra("key_notification_click_action", true);
  }
  
  private void d()
  {
    if (!this.d) {
      this.c.b(null);
    }
  }
  
  private Intent e()
  {
    return this.c.b();
  }
  
  private String f()
  {
    return this.c.c();
  }
  
  private String g()
  {
    return this.c.d();
  }
  
  private String h()
  {
    return this.c.e();
  }
  
  private Bitmap i()
  {
    return this.c.f();
  }
  
  @Nullable
  public NotificationElement a()
  {
    c();
    b();
    int i = this.a.istroop;
    Object localObject = ProcessorFactory.a(this.b, i, this.c);
    if (localObject != null)
    {
      this.c = ((BaseUinTypeProcessor)localObject).a(this.a);
      if (this.c == null) {
        return null;
      }
      i = ((BaseUinTypeProcessor)localObject).b(this.a);
      if (e() == null)
      {
        localObject = new Intent();
        this.c.a((Intent)localObject);
      }
      e().putExtra("KEY_NOTIFY_ID_FROM_PROCESSOR", i);
      e().putExtra("param_notifyid", i);
      d();
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] NotificationElementBuilder", 2, new Object[] { "[create] build: invoked. ", " notificationElement: ", this.c });
      }
      return this.c;
    }
    return null;
  }
  
  @NotNull
  public String toString()
  {
    if (this.c == null) {
      return "notificationElement: null";
    }
    Bundle localBundle = null;
    if (e() != null) {
      localBundle = e().getExtras();
    }
    String str;
    if (i() != null) {
      str = String.valueOf(i().getHeight());
    } else {
      str = "using default bitmap";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NotificationElementBuilder{contentIntentExtras=");
    localStringBuilder.append(localBundle);
    localStringBuilder.append(", ticker='");
    localStringBuilder.append(f());
    localStringBuilder.append('\'');
    localStringBuilder.append(", contentTitle='");
    localStringBuilder.append(g());
    localStringBuilder.append('\'');
    localStringBuilder.append(", notificationContentText='");
    localStringBuilder.append(h());
    localStringBuilder.append('\'');
    localStringBuilder.append(", notificationIconBitmapStr=");
    localStringBuilder.append(str);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.struct.NotificationElementBuilder
 * JD-Core Version:    0.7.0.1
 */