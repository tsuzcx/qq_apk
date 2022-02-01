package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.votelist.VoteItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VisitorsActivity$VisitorAdapter$3
  implements View.OnClickListener
{
  VisitorsActivity$VisitorAdapter$3(VisitorsActivity.VisitorAdapter paramVisitorAdapter, VisitorsActivity.CustomViewHolder paramCustomViewHolder) {}
  
  public void onClick(View paramView)
  {
    this.b.a.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.VisitorAdapter.3
 * JD-Core Version:    0.7.0.1
 */