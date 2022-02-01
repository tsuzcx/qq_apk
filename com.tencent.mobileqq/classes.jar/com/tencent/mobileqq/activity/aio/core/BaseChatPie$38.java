package com.tencent.mobileqq.activity.aio.core;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

class BaseChatPie$38
  implements Runnable
{
  BaseChatPie$38(BaseChatPie paramBaseChatPie, long paramLong1, int paramInt1, long paramLong2, int paramInt2, Runnable paramRunnable) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.this$0.app.getMessageFacade().queryMsgItemByUniseq(this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType, this.val$valueFinal);
    this.this$0.getActivity().runOnUiThread(new BaseChatPie.38.1(this, localMessageRecord));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.38
 * JD-Core Version:    0.7.0.1
 */