package com.tencent.mobileqq.app.notification.processor.business;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.activateFriend.QQNotifyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.struct.AbstractBusinessFoldedNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class ActivateFriendsNotificationProcessor
  extends AbstractBusinessFoldedNotificationProcessor
{
  protected ActivateFriendsNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  public NotificationElement a(Message paramMessage)
  {
    Object localObject = SkinUtils.a(this.a.getApp().getResources().getDrawable(2130846157));
    this.b.a((Bitmap)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(b());
    ((StringBuilder)localObject).append(": ");
    localObject = ((StringBuilder)localObject).toString();
    this.b.b((String)localObject);
    localObject = d();
    this.b.d((String)localObject);
    localObject = paramMessage.getExtInfoFromExtStr("key_msg_notify_summary");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.b.d((String)localObject);
    }
    c(paramMessage);
    if (paramMessage.msgtype == -7090) {
      QQNotifyHelper.a(this.a, "push_exp", null, null, null, String.valueOf(QQNotifyHelper.a(paramMessage.msgData)));
    }
    return this.b;
  }
  
  public int b(Message paramMessage)
  {
    return -113;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.ActivateFriendsNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */