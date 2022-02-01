package com.tencent.mobileqq.activity.contact.addcontact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchBaseActivity$4
  implements View.OnClickListener
{
  SearchBaseActivity$4(SearchBaseActivity paramSearchBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.setResult(1);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity.4
 * JD-Core Version:    0.7.0.1
 */