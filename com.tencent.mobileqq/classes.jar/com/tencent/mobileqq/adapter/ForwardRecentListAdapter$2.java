package com.tencent.mobileqq.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardRecentListAdapter$2
  implements View.OnClickListener
{
  ForwardRecentListAdapter$2(ForwardRecentListAdapter paramForwardRecentListAdapter) {}
  
  public void onClick(View paramView)
  {
    ForwardRecentListAdapter.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardRecentListAdapter.2
 * JD-Core Version:    0.7.0.1
 */