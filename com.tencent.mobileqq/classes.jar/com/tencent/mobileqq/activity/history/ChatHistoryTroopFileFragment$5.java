package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryTroopFileFragment$5
  implements View.OnClickListener
{
  ChatHistoryTroopFileFragment$5(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (((i == 2131447868) || (i == 2131447870)) && (ChatHistoryTroopFileFragment.d(this.a) != null)) {
      ChatHistoryTroopFileFragment.d(this.a).setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.5
 * JD-Core Version:    0.7.0.1
 */