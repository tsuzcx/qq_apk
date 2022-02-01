package com.tencent.mobileqq.app.notification.processor.business;

import android.graphics.Bitmap;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.struct.AbstractBusinessFoldedNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qroute.QRoute;

public class TempGameMsgNotificationProcessor
  extends AbstractBusinessFoldedNotificationProcessor
{
  protected TempGameMsgNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  public NotificationElement a(Message paramMessage)
  {
    Object localObject = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getMsgDescp(this.a, paramMessage, d());
    this.b.d((String)localObject);
    e();
    a(paramMessage, this.b);
    localObject = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getGameRoleBitmap(paramMessage, this.a);
    paramMessage = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getGameRoleNickName(paramMessage, this.a);
    this.b.a((Bitmap)localObject);
    this.b.c(paramMessage);
    return this.b;
  }
  
  public int b(Message paramMessage)
  {
    return 527;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.TempGameMsgNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */