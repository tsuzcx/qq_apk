package com.tencent.mobileqq.activity.history;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryTroopMemberFragment$6
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$6(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().setResult(0, this.a.getActivity().getIntent());
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.6
 * JD-Core Version:    0.7.0.1
 */