package com.tencent.mobileqq.activity.aio.core;

import afiw;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import bevt;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class BaseChatPie$87
  implements View.OnClickListener
{
  BaseChatPie$87(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.this$0.input.getTag(2131373788);
      if ((localObject instanceof bevt))
      {
        localObject = (bevt)localObject;
        if ((localObject != null) && (this.this$0.sessionInfo != null))
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.aio.BaseChatPie", 2, "TextItemBuilder onClickListener: isReplyMsg = true, mSourceMsgSeq = " + ((bevt)localObject).a);
          }
          BaseChatPie localBaseChatPie = this.this$0.mActivity.getChatFragment().a();
          if ((this.this$0.sessionInfo.curType == 0) && ((localBaseChatPie instanceof afiw)))
          {
            ((afiw)localBaseChatPie).a(22, ((bevt)localObject).d, ((bevt)localObject).c, null);
          }
          else if (localBaseChatPie.supportRefreshHeadMessage())
          {
            QQMessageFacade.Message localMessage = this.this$0.app.getMessageFacade().getLastMessage(this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType);
            localBaseChatPie.refreshHeadMessage(22, ((bevt)localObject).a, (int)(localMessage.shmsgseq - ((bevt)localObject).a), null);
            MessageForReplyText.reportReplyMsg(null, "typebox", "clk_original", this.this$0.sessionInfo.curFriendUin, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.87
 * JD-Core Version:    0.7.0.1
 */