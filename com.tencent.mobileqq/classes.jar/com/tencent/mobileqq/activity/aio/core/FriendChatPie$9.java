package com.tencent.mobileqq.activity.aio.core;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.servlet.ReduFriendObserver;

class FriendChatPie$9
  extends ReduFriendObserver
{
  FriendChatPie$9(FriendChatPie paramFriendChatPie) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (this.a.a != null)) {
      this.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.9
 * JD-Core Version:    0.7.0.1
 */