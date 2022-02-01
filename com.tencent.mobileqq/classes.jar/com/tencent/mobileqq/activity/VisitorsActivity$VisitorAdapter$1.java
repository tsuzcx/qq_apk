package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.votelist.VoteItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VisitorsActivity$VisitorAdapter$1
  implements View.OnClickListener
{
  VisitorsActivity$VisitorAdapter$1(VisitorsActivity.VisitorAdapter paramVisitorAdapter) {}
  
  public void onClick(View paramView)
  {
    this.a.a.b(paramView.getTag());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.VisitorAdapter.1
 * JD-Core Version:    0.7.0.1
 */