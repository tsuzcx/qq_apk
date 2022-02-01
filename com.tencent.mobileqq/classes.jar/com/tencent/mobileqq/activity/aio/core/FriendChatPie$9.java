package com.tencent.mobileqq.activity.aio.core;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandlerConstants.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.managers.PushNotificationManager;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;

class FriendChatPie$9
  extends MessageObserver
{
  FriendChatPie$9(FriendChatPie paramFriendChatPie) {}
  
  public void onMsgStartSendingUI(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
    }
    this.a.j(131072);
  }
  
  protected void onRecvEmoticonRandomResult(String paramString, long paramLong)
  {
    if (TextUtils.equals(this.a.ah.b, paramString)) {
      this.a.a(262144, null, paramLong);
    }
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    onSendResult(paramBoolean, paramString, paramLong, null);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong, MessageHandlerConstants.MsgSendCostParams paramMsgSendCostParams)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (paramString.equals(this.a.ah.b))
      {
        paramString = this.a;
        paramString.as = true;
        paramString.a(262144, paramMsgSendCostParams, paramLong);
        ((PushNotificationManager)this.a.d.getManager(QQManagerFactory.PUSH_NOTIFICATION_MANAGER)).a(this.a.ah, PushNotificationManager.a);
      }
    }
  }
  
  protected void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.j(65536);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.equals(this.a.ah.b)) && (paramInt1 == this.a.ah.a))
    {
      FriendChatPie.a(this.a, paramString1, paramInt1, paramLong2);
      this.a.j(196608);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramSendMessageHandler = this.a.c;
      paramString2 = new StringBuilder();
      paramString2.append("onUpdateSendMsgError exception uin ");
      paramString2.append(paramString1);
      paramString2.append(" type ");
      paramString2.append(paramInt1);
      paramString2.append(" uniseq ");
      paramString2.append(paramLong2);
      QLog.d(paramSendMessageHandler, 2, paramString2.toString());
    }
    paramString1 = this.a.d.getMessageFacade().a(paramString1, paramInt1, paramLong2);
    if ((paramString1 != null) && (paramString1.msgtype == -2058) && ((paramString1.extraflag == 32768) || (paramString1.sendFailCode == 41)))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a.c, 2, "onUpdateSendMsgError, sticker msg is failed!, now remove!");
      }
      this.a.d.getMessageFacade().a(paramString1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.9
 * JD-Core Version:    0.7.0.1
 */