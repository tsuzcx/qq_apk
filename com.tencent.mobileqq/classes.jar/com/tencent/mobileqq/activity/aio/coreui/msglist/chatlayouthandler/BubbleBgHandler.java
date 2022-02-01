package com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor.ChatLayoutBubbleBgExecutor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor.ChatLayoutBubbleBgExecutorImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class BubbleBgHandler
  extends ChatLayoutHandler
{
  ChatLayoutBubbleBgExecutor a;
  
  public BubbleBgHandler(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IChatLayoutListenerController paramIChatLayoutListenerController)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext, paramOnClickListener, paramOnLongClickListener, paramIChatLayoutListenerController);
  }
  
  public void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor = new ChatLayoutBubbleBgExecutorImpl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramContext);
    }
    if (paramBundle != null)
    {
      boolean bool = paramBundle.getBoolean("shouldDownload", false);
      int i = paramBundle.getInt("bubbleType", 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor.a(paramChatMessage, paramViewHolder, paramInt1, paramInt2, bool, i);
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBubblebghandlerexecutorChatLayoutBubbleBgExecutor.a();
      paramChatMessage = new BubbleBgHandler.BubbleBgHandlerListenerInfo(paramInt1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramBaseChatItemLayout, paramViewHolder, i);
      a(ChatLayoutListenerController.c, paramChatMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.BubbleBgHandler
 * JD-Core Version:    0.7.0.1
 */