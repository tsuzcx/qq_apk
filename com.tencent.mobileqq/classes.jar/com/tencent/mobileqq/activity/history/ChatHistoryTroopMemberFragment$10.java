package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryTroopMemberFragment$10
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$10(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    ChatHistoryTroopMemberFragment localChatHistoryTroopMemberFragment = this.a;
    localChatHistoryTroopMemberFragment.A = true;
    localChatHistoryTroopMemberFragment.T.setVisibility(8);
    localChatHistoryTroopMemberFragment = this.a;
    localChatHistoryTroopMemberFragment.T = ((TextView)ChatHistoryTroopMemberFragment.b(localChatHistoryTroopMemberFragment, 2131436182));
    this.a.T.setVisibility(0);
    this.a.T.setText(HardCodeUtil.a(2131898212));
    this.a.T.setOnClickListener(new ChatHistoryTroopMemberFragment.10.1(this));
    ChatHistoryTroopMemberFragment.c(this.a);
    if (this.a.K != null) {
      this.a.K.c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.10
 * JD-Core Version:    0.7.0.1
 */