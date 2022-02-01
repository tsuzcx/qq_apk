package com.tencent.mobileqq.app.msgnotify;

import com.tencent.imcore.message.Message;

public abstract interface MsgNotifyManager$Callback
{
  public abstract int a(Message paramMessage, MsgNotifyManager paramMsgNotifyManager);
  
  public abstract void a(int paramInt, Message paramMessage, MsgNotifyManager paramMsgNotifyManager);
  
  public abstract void a(Message paramMessage1, Message paramMessage2, MsgNotifyManager paramMsgNotifyManager);
  
  public abstract void a(String paramString, int paramInt, Message paramMessage, MsgNotifyManager paramMsgNotifyManager);
  
  public abstract boolean a(boolean paramBoolean, Message paramMessage, MsgNotifyManager paramMsgNotifyManager);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyManager.Callback
 * JD-Core Version:    0.7.0.1
 */