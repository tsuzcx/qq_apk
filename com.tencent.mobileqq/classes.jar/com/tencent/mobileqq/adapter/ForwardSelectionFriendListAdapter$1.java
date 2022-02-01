package com.tencent.mobileqq.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardSelectionFriendListAdapter$1
  implements View.OnClickListener
{
  ForwardSelectionFriendListAdapter$1(ForwardSelectionFriendListAdapter paramForwardSelectionFriendListAdapter) {}
  
  public void onClick(View paramView)
  {
    ForwardSelectionFriendListAdapter.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter.1
 * JD-Core Version:    0.7.0.1
 */