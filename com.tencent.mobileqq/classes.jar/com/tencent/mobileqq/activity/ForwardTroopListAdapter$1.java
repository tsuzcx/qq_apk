package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.adapter.contact.GroupTag;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardTroopListAdapter$1
  implements View.OnClickListener
{
  ForwardTroopListAdapter$1(ForwardTroopListAdapter paramForwardTroopListAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    ForwardTroopListAdapter.a(this.a, (GroupTag)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListAdapter.1
 * JD-Core Version:    0.7.0.1
 */