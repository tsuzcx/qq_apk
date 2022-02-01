package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardTroopListFragment$2
  implements View.OnClickListener
{
  ForwardTroopListFragment$2(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void onClick(View paramView)
  {
    ForwardTroopListFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment.2
 * JD-Core Version:    0.7.0.1
 */