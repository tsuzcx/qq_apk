package com.tencent.mobileqq.app.notification.processor.business;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.struct.AbstractBusinessFoldedNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class ConfessNotificationProcessor
  extends AbstractBusinessFoldedNotificationProcessor
{
  protected ConfessNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  public NotificationElement a(Message paramMessage)
  {
    Object localObject1 = SkinUtils.a(this.a.getApp().getResources().getDrawable(2130846430));
    this.b.a((Bitmap)localObject1);
    localObject1 = this.a.getApp().getString(2131896664);
    this.b.c((String)localObject1);
    localObject1 = new ConfessInfo();
    ((ConfessInfo)localObject1).parseFromJsonStr(paramMessage.getExtInfoFromExtStr("ext_key_confess_info"));
    localObject1 = ConfessMsgUtil.a(this.a, (ConfessInfo)localObject1, paramMessage.senderuin);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("(");
    ((StringBuilder)localObject2).append(b());
    ((StringBuilder)localObject2).append("):");
    ((StringBuilder)localObject2).append(d());
    localObject2 = ((StringBuilder)localObject2).toString();
    this.b.b((String)localObject2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(d());
    localObject1 = ((StringBuilder)localObject2).toString();
    this.b.d((String)localObject1);
    c(paramMessage);
    return this.b;
  }
  
  public int b(Message paramMessage)
  {
    return -113;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.ConfessNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */