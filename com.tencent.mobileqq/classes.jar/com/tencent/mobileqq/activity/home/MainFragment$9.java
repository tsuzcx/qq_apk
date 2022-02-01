package com.tencent.mobileqq.activity.home;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MainFragment$9
  implements View.OnClickListener
{
  MainFragment$9(MainFragment paramMainFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.g();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment.9
 * JD-Core Version:    0.7.0.1
 */