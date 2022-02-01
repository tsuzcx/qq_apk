package com.tencent.mobileqq.activity.aio.core;

import aikg;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class BaseChatPie$68
  implements Runnable
{
  BaseChatPie$68(BaseChatPie paramBaseChatPie, long paramLong) {}
  
  public void run()
  {
    if ((this.this$0.mFraudTipsBar != null) && (this.val$fUin == Long.parseLong(this.this$0.sessionInfo.curFriendUin))) {
      this.this$0.mFraudTipsBar.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.68
 * JD-Core Version:    0.7.0.1
 */