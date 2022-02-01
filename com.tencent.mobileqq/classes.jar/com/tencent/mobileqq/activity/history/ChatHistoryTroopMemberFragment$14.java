package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryTroopMemberFragment$14
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$14(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    ChatHistoryTroopMemberFragment localChatHistoryTroopMemberFragment = this.a;
    localChatHistoryTroopMemberFragment.z = false;
    localChatHistoryTroopMemberFragment.br = "";
    localChatHistoryTroopMemberFragment.N.setVisibility(8);
    this.a.O.setVisibility(0);
    if (this.a.az != 22) {
      this.a.P.setVisibility(0);
    }
    if (this.a.K != null) {
      this.a.K.c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.14
 * JD-Core Version:    0.7.0.1
 */