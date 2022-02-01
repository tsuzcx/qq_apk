package com.tencent.mobileqq.activity.aio.item;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LongMsgItemBuilder$5
  implements View.OnClickListener
{
  LongMsgItemBuilder$5(LongMsgItemBuilder paramLongMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = AIOUtils.a(paramView);
      if (!(localObject instanceof MessageForLongMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForLongMsg");
        }
      }
      else
      {
        localObject = (MessageForLongMsg)localObject;
        if ((((MessageForLongMsg)localObject).mSourceMsgInfo != null) && ((this.a.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: isReplyMsg = true");
          }
          BaseChatPie localBaseChatPie = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
          if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 0) && ((localBaseChatPie instanceof FriendChatPie)))
          {
            ((FriendChatPie)localBaseChatPie).a(22, ((MessageForLongMsg)localObject).mSourceMsgInfo.origUid, ((MessageForLongMsg)localObject).mSourceMsgInfo.mSourceMsgTime, null);
          }
          else if (localBaseChatPie.h())
          {
            localBaseChatPie.a(22, ((MessageForLongMsg)localObject).mSourceMsgInfo.mSourceMsgSeq, (int)(((MessageForLongMsg)localObject).shmsgseq - ((MessageForLongMsg)localObject).mSourceMsgInfo.mSourceMsgSeq), (MessageRecord)localObject);
            MessageForReplyText.reportReplyMsg(null, "replyMsg_bubble", "clk_original", ((MessageForLongMsg)localObject).frienduin, (ChatMessage)localObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */