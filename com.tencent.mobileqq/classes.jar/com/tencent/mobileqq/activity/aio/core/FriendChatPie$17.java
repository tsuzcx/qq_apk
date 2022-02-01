package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FriendChatPie$17
  implements View.OnClickListener
{
  FriendChatPie$17(FriendChatPie paramFriendChatPie) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.aY) {
      ChatActivityFacade.a(this.a.ah, this.a.d, this.a.aX());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.17
 * JD-Core Version:    0.7.0.1
 */