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
    localChatHistoryTroopMemberFragment.g = true;
    localChatHistoryTroopMemberFragment.d.setVisibility(8);
    localChatHistoryTroopMemberFragment = this.a;
    localChatHistoryTroopMemberFragment.d = ((TextView)ChatHistoryTroopMemberFragment.a(localChatHistoryTroopMemberFragment, 2131369204));
    this.a.d.setVisibility(0);
    this.a.d.setText(HardCodeUtil.a(2131701874));
    this.a.d.setOnClickListener(new ChatHistoryTroopMemberFragment.10.1(this));
    ChatHistoryTroopMemberFragment.a(this.a);
    if (this.a.a != null) {
      this.a.a.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.10
 * JD-Core Version:    0.7.0.1
 */