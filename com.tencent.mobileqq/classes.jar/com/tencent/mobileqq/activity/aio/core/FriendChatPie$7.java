package com.tencent.mobileqq.activity.aio.core;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.servlet.ReduFriendObserver;

class FriendChatPie$7
  extends ReduFriendObserver
{
  FriendChatPie$7(FriendChatPie paramFriendChatPie) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (this.a.bi != null)) {
      this.a.bi.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.7
 * JD-Core Version:    0.7.0.1
 */