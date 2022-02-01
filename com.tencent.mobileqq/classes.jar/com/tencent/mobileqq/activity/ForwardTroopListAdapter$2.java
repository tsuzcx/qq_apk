package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardTroopListAdapter$2
  implements View.OnClickListener
{
  ForwardTroopListAdapter$2(ForwardTroopListAdapter paramForwardTroopListAdapter) {}
  
  public void onClick(View paramView)
  {
    ForwardTroopListAdapter.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListAdapter.2
 * JD-Core Version:    0.7.0.1
 */