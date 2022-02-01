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
  protected Context a;
  public View.OnClickListener a;
  protected View.OnLongClickListener a;
  public SessionInfo a;
  private IChatLayoutListenerController a;
  public QQAppInterface a;
  
  public ChatLayoutHandler(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IChatLayoutListenerController paramIChatLayoutListenerController)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListenerController = paramIChatLayoutListenerController;
  }
  
  public abstract void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle);
  
  protected final void a(int paramInt, IChatLayoutListener.ChatLayoutListenerInfo paramChatLayoutListenerInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListenerController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListenerController.a(paramInt, paramChatLayoutListenerInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutHandler
 * JD-Core Version:    0.7.0.1
 */