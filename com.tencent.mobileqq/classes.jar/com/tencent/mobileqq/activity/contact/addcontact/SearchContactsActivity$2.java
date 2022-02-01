package com.tencent.mobileqq.activity.contact.addcontact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchContactsActivity$2
  implements View.OnClickListener
{
  SearchContactsActivity$2(SearchContactsActivity paramSearchContactsActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.setResult(0);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity.2
 * JD-Core Version:    0.7.0.1
 */