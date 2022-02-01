package com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.ChatMessage;

public abstract interface IChatLayoutHandlerFactory
{
  public abstract ChatLayoutHandler a();
  
  public abstract ChatLayoutHandler a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle);
  
  public abstract void a(int paramInt, View paramView);
  
  public abstract void a(int paramInt, IChatLayoutListener paramIChatLayoutListener);
  
  public abstract boolean a(int paramInt, View paramView);
  
  public abstract ChatLayoutHandler b();
  
  public abstract void b(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle);
  
  public abstract void b(int paramInt, IChatLayoutListener paramIChatLayoutListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutHandlerFactory
 * JD-Core Version:    0.7.0.1
 */