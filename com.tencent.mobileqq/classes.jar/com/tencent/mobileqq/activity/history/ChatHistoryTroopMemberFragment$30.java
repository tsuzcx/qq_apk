package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ChatHistoryTroopMemberFragment$30
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$30(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.a.b.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(Long.valueOf(Long.parseLong((String)localIterator.next())));
    }
    ChatHistoryTroopMemberFragment.a(this.a, localArrayList);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.30
 * JD-Core Version:    0.7.0.1
 */