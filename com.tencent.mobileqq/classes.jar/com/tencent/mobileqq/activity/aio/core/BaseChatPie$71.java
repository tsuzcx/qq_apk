package com.tencent.mobileqq.activity.aio.core;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.text.ReplyedMessageSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class BaseChatPie$71
  implements View.OnClickListener
{
  BaseChatPie$71(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    BaseChatPie localBaseChatPie;
    if (paramView.getId() == 2131369141)
    {
      localObject = this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131374320);
      if ((localObject instanceof ReplyedMessageSpan))
      {
        localObject = (ReplyedMessageSpan)localObject;
        if ((localObject != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.aio.BaseChatPie", 2, "TextItemBuilder onClickListener: isReplyMsg = true, mSourceMsgSeq = " + ((ReplyedMessageSpan)localObject).a);
          }
          localBaseChatPie = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getChatFragment().a();
          if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) || (!(localBaseChatPie instanceof FriendChatPie))) {
            break label142;
          }
          ((FriendChatPie)localBaseChatPie).a(22, ((ReplyedMessageSpan)localObject).d, ((ReplyedMessageSpan)localObject).c, null);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label142:
      if (localBaseChatPie.h())
      {
        Message localMessage = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        localBaseChatPie.a(22, ((ReplyedMessageSpan)localObject).a, (int)(localMessage.shmsgseq - ((ReplyedMessageSpan)localObject).a), null);
        MessageForReplyText.reportReplyMsg(null, "typebox", "clk_original", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.71
 * JD-Core Version:    0.7.0.1
 */