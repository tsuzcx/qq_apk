package com.tencent.mobileqq.activity.recent.msgbox.businesshandler;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;

public abstract interface ITempMsgBoxBusinessHandler
{
  public abstract String a(AppInterface paramAppInterface, String paramString);
  
  public abstract void a(AppInterface paramAppInterface, int paramInt, String paramString);
  
  public abstract void a(AppInterface paramAppInterface, Message paramMessage, int paramInt, MsgSummary paramMsgSummary);
  
  public abstract void a(AppInterface paramAppInterface, Object paramObject);
  
  public abstract boolean a(AppInterface paramAppInterface, int paramInt);
  
  public abstract boolean a(AppInterface paramAppInterface, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.businesshandler.ITempMsgBoxBusinessHandler
 * JD-Core Version:    0.7.0.1
 */