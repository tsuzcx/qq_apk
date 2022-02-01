package com.tencent.mobileqq.app.msgnotify;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.util.notification.NotifyIdManager;

public class MsgNotifyManagerCallback
  implements MsgNotifyManager.Callback
{
  public int a(Message paramMessage, MsgNotifyManager paramMsgNotifyManager)
  {
    paramMsgNotifyManager = (ISubAccountService)((QQAppInterface)paramMsgNotifyManager.g()).getRuntimeService(ISubAccountService.class, null);
    if (paramMsgNotifyManager != null) {
      return paramMsgNotifyManager.getUnNotifySenderNum(paramMessage.frienduin);
    }
    return 0;
  }
  
  public void a(int paramInt, Message paramMessage, MsgNotifyManager paramMsgNotifyManager)
  {
    ((QQAppInterface)paramMsgNotifyManager.g()).showReadedMsgNotification(paramMessage, null);
  }
  
  public void a(Message paramMessage1, Message paramMessage2, MsgNotifyManager paramMsgNotifyManager)
  {
    ((QQAppInterface)paramMsgNotifyManager.g()).showReadedMsgNotification(paramMessage2, paramMessage1);
  }
  
  public void a(String paramString, int paramInt, Message paramMessage, MsgNotifyManager paramMsgNotifyManager)
  {
    paramMsgNotifyManager = (QQAppInterface)paramMsgNotifyManager.g();
    if (NotifyIdManager.a(paramInt, paramString))
    {
      NotifyIdManager.a(paramMsgNotifyManager).c(paramString);
      return;
    }
    paramMsgNotifyManager.showReadedMsgNotification(paramMessage, null);
  }
  
  public boolean a(boolean paramBoolean, Message paramMessage, MsgNotifyManager paramMsgNotifyManager)
  {
    return (paramBoolean) && (NotifyIdManager.a(paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyManagerCallback
 * JD-Core Version:    0.7.0.1
 */