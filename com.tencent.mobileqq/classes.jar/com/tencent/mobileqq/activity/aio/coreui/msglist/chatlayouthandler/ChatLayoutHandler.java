package com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public abstract class ChatLayoutHandler
{
  private IChatLayoutListenerController a;
  protected QQAppInterface b;
  protected SessionInfo c;
  protected Context d;
  protected View.OnClickListener e;
  protected View.OnLongClickListener f;
  
  public ChatLayoutHandler(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IChatLayoutListenerController paramIChatLayoutListenerController)
  {
    this.b = paramQQAppInterface;
    this.c = paramSessionInfo;
    this.d = paramContext;
    this.e = paramOnClickListener;
    this.f = paramOnLongClickListener;
    this.a = paramIChatLayoutListenerController;
  }
  
  public abstract void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle);
  
  protected final void a(int paramInt, IChatLayoutListener.ChatLayoutListenerInfo paramChatLayoutListenerInfo)
  {
    IChatLayoutListenerController localIChatLayoutListenerController = this.a;
    if (localIChatLayoutListenerController != null) {
      localIChatLayoutListenerController.a(paramInt, paramChatLayoutListenerInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutHandler
 * JD-Core Version:    0.7.0.1
 */