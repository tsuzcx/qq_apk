package com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler;

import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;

public class BubbleBgHandler$BubbleBgHandlerListenerInfo
  extends IChatLayoutListener.ChatLayoutListenerInfo
{
  public int a;
  
  public BubbleBgHandler$BubbleBgHandlerListenerInfo(int paramInt1, int paramInt2, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt3)
  {
    super(paramInt1, paramInt2, paramSessionInfo, paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
    this.a = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.BubbleBgHandler.BubbleBgHandlerListenerInfo
 * JD-Core Version:    0.7.0.1
 */