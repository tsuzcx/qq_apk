package com.tencent.mobileqq.app.notification.processor.basemessage;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.notification.struct.BaseConversationMessageNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.mutualmark.oldlogic.ReactivePushHelper;
import com.tencent.util.notification.NotifyIdManager;

public final class C2CFriendNotificationProcessor
  extends BaseConversationMessageNotificationProcessor
{
  protected C2CFriendNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  private void e(Message paramMessage)
  {
    Intent localIntent = this.b.b();
    localIntent.putExtra("need_report", true);
    localIntent.putExtra("incoming_msguid", paramMessage.msgUid);
    localIntent.putExtra("incoming_shmsgseq", paramMessage.shmsgseq);
    localIntent.putExtra("KEY_FROM", "notifcation");
    if (ReactivePushHelper.a(this.a, paramMessage)) {
      localIntent.putExtra("key_reactive_push_tip", true);
    }
    this.b.a(localIntent);
  }
  
  public NotificationElement a(Message paramMessage)
  {
    int j = this.a.getMessageFacade().d.d();
    int i = 1;
    if (j == 1)
    {
      localObject1 = this.a.getFaceBitmap(paramMessage.frienduin, true);
      this.b.a((Bitmap)localObject1);
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(b());
    ((StringBuilder)localObject1).append(": ");
    localObject1 = ((StringBuilder)localObject1).toString();
    this.b.b((String)localObject1);
    localObject1 = d();
    Object localObject2 = NotifyIdManager.a(this.a);
    if (localObject2 != null)
    {
      localObject2 = ((NotifyIdManager)localObject2).a(b(), paramMessage);
      this.b.c((String)localObject2);
    }
    localObject1 = MessageNotificationSettingManager.a(this.a).a((String)localObject1, paramMessage);
    this.b.d((String)localObject1);
    if (this.a.getMessageFacade().d.d() > 1) {
      i = 0;
    }
    if (i != 0) {
      e(paramMessage);
    }
    return c(paramMessage);
  }
  
  public int b(Message paramMessage)
  {
    return d(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.basemessage.C2CFriendNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */