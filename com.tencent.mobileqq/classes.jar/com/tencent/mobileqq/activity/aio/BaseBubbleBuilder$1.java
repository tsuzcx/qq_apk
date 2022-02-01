package com.tencent.mobileqq.activity.aio;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor.ChatLayoutBubbleBgExecutorImpl;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.BubbleBgHandler.BubbleBgHandlerListenerInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutListenerController;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutListener;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutListener.ChatLayoutListenerInfo;
import com.tencent.mobileqq.activity.aio.vasbubbleanimation.BubbleAnimation;
import com.tencent.mobileqq.data.ChatMessage;

class BaseBubbleBuilder$1
  implements IChatLayoutListener
{
  BaseBubbleBuilder$1(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  public void a(int paramInt, IChatLayoutListener.ChatLayoutListenerInfo paramChatLayoutListenerInfo)
  {
    if ((paramInt == ChatLayoutListenerController.c) && (paramChatLayoutListenerInfo != null))
    {
      boolean bool = paramChatLayoutListenerInfo instanceof BubbleBgHandler.BubbleBgHandlerListenerInfo;
      if ((bool) && (((BubbleBgHandler.BubbleBgHandlerListenerInfo)paramChatLayoutListenerInfo).a != ChatLayoutBubbleBgExecutorImpl.b))
      {
        this.a.a(paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder, paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
        this.a.a(paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder, paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        this.a.b(paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder, paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      if ((bool) && (!BubbleAnimation.a().a(paramChatLayoutListenerInfo)) && (((BubbleBgHandler.BubbleBgHandlerListenerInfo)paramChatLayoutListenerInfo).a == ChatLayoutBubbleBgExecutorImpl.a))
      {
        if ((paramChatLayoutListenerInfo.b == paramChatLayoutListenerInfo.c - 1) && (paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqDataChatMessage.mAnimFlag)) {
          BaseBubbleBuilder.jdField_a_of_type_AndroidOsHandler.post(new BaseBubbleBuilder.1.1(this, paramChatLayoutListenerInfo));
        }
        paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqDataChatMessage.mAnimFlag = false;
      }
      if (paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_AndroidViewView != null)
      {
        paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setBubbleView(paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_AndroidViewView);
        this.a.a(paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_AndroidViewView, paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_AndroidViewView.setTag(2131364116, paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
        paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_AndroidViewView.setTag(2131364568, paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      this.a.a(paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.a.jdField_a_of_type_AndroidContentContext, paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramChatLayoutListenerInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder, paramChatLayoutListenerInfo.b, paramChatLayoutListenerInfo.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.1
 * JD-Core Version:    0.7.0.1
 */