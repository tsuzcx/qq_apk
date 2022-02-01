package com.tencent.imcore.message.core;

import android.content.Context;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import mqq.app.AppRuntime;

public abstract interface ExtractMessageSummaryCallback
{
  public abstract boolean a(Context paramContext, AppRuntime paramAppRuntime, Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean a(Message paramMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.core.ExtractMessageSummaryCallback
 * JD-Core Version:    0.7.0.1
 */