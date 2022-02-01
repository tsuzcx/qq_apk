package com.tencent.mobileqq.activity.home;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MainFragment$10
  implements View.OnClickListener
{
  MainFragment$10(MainFragment paramMainFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.j();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment.10
 * JD-Core Version:    0.7.0.1
 */