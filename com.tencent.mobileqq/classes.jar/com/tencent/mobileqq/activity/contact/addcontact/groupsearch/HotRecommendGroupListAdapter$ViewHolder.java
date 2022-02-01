package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class HotRecommendGroupListAdapter$ViewHolder
  implements View.OnClickListener
{
  int a;
  String b;
  TextView c;
  
  protected HotRecommendGroupListAdapter$ViewHolder(HotRecommendGroupListAdapter paramHotRecommendGroupListAdapter) {}
  
  public void onClick(View paramView)
  {
    if (HotRecommendGroupListAdapter.a(this.d) != null) {
      HotRecommendGroupListAdapter.a(this.d).a(this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.HotRecommendGroupListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */