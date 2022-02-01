package com.tencent.mobileqq.activity;

import android.os.Handler.Callback;
import android.os.Message;

class RewardNoticeActivity$1
  implements Handler.Callback
{
  RewardNoticeActivity$1(RewardNoticeActivity paramRewardNoticeActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    paramMessage = new RewardNoticeActivity.1.1(this);
    RewardNoticeActivity localRewardNoticeActivity = this.a;
    localRewardNoticeActivity.a(localRewardNoticeActivity.c, paramMessage, 4.0F, 500L, 4);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RewardNoticeActivity.1
 * JD-Core Version:    0.7.0.1
 */