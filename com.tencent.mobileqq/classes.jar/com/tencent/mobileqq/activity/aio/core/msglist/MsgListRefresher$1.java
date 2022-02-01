package com.tencent.mobileqq.activity.aio.core.msglist;

import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.selectable.ChatPieSelectableHelper;

class MsgListRefresher$1
  implements Runnable
{
  MsgListRefresher$1(MsgListRefresher paramMsgListRefresher, ChatPieSelectableHelper paramChatPieSelectableHelper) {}
  
  public void run()
  {
    if (!this.a.b()) {
      MsgListRefresher.a(this.this$0).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher.1
 * JD-Core Version:    0.7.0.1
 */