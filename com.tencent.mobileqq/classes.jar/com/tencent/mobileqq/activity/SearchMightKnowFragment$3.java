package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchMightKnowFragment$3
  implements View.OnClickListener
{
  SearchMightKnowFragment$3(SearchMightKnowFragment paramSearchMightKnowFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getBaseActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchMightKnowFragment.3
 * JD-Core Version:    0.7.0.1
 */