package com.tencent.mobileqq.activity.recent.msgbox;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;

public abstract interface ITempMsgBoxCallback
{
  public abstract int a(AppInterface paramAppInterface, String paramString, int paramInt1, int paramInt2, Message paramMessage);
  
  public abstract String a(AppInterface paramAppInterface, String paramString, int paramInt1, int paramInt2, Message paramMessage);
  
  public abstract void a(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage, int paramInt, MsgSummary paramMsgSummary, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean a(AppInterface paramAppInterface, String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.ITempMsgBoxCallback
 * JD-Core Version:    0.7.0.1
 */