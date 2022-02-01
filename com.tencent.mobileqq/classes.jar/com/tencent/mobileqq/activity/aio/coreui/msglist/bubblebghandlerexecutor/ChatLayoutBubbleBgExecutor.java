package com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public abstract class ChatLayoutBubbleBgExecutor
{
  protected QQAppInterface a;
  protected SessionInfo b;
  protected Context c;
  
  public ChatLayoutBubbleBgExecutor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext)
  {
    this.a = paramQQAppInterface;
    this.b = paramSessionInfo;
    this.c = paramContext;
  }
  
  public abstract int a();
  
  public abstract void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3);
  
  public abstract boolean a(int paramInt, ChatMessage paramChatMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor.ChatLayoutBubbleBgExecutor
 * JD-Core Version:    0.7.0.1
 */