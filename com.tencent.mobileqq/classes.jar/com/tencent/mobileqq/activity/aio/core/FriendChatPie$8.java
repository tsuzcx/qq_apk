package com.tencent.mobileqq.activity.aio.core;

import android.os.Bundle;
import com.tencent.mobileqq.observer.VipGifObserver;

class FriendChatPie$8
  extends VipGifObserver
{
  FriendChatPie$8(FriendChatPie paramFriendChatPie) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBoolean == true))
    {
      paramBundle.getInt("gif_ui_show_bid");
      long l = paramBundle.getLong("gif_ui_show_seq");
      this.a.g(65536);
      FriendChatPie.a(this.a, Long.valueOf(l).longValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.8
 * JD-Core Version:    0.7.0.1
 */