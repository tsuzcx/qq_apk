package com.tencent.mobileqq.activity.selectmember;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter.GroupTag;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopDiscussionMemSelectAdapter$1
  implements View.OnClickListener
{
  TroopDiscussionMemSelectAdapter$1(TroopDiscussionMemSelectAdapter paramTroopDiscussionMemSelectAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    TroopDiscussionMemSelectAdapter.a(this.a, (BuddyListAdapter.GroupTag)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionMemSelectAdapter.1
 * JD-Core Version:    0.7.0.1
 */