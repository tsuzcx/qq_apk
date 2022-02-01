package com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler;

import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;

public class IChatLayoutListener$ChatLayoutListenerInfo
{
  public BaseBubbleBuilder.ViewHolder a;
  public BaseChatItemLayout a;
  public SessionInfo a;
  public ChatMessage a;
  public int b;
  public int c;
  
  public IChatLayoutListener$ChatLayoutListenerInfo() {}
  
  public IChatLayoutListener$ChatLayoutListenerInfo(int paramInt1, int paramInt2, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = paramViewHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutListener.ChatLayoutListenerInfo
 * JD-Core Version:    0.7.0.1
 */