package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Message;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import java.util.List;
import mqq.os.MqqHandler;

class MultiForwardChatPie$2
  implements Runnable
{
  MultiForwardChatPie$2(MultiForwardChatPie paramMultiForwardChatPie) {}
  
  public void run()
  {
    List localList = MultiMsgManager.a().a(this.this$0.d, this.this$0.bk);
    Message localMessage = this.this$0.bp.obtainMessage(0);
    localMessage.obj = localList;
    this.this$0.bp.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.2
 * JD-Core Version:    0.7.0.1
 */