package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DiscussionInfoCardActivity$1
  implements View.OnClickListener
{
  DiscussionInfoCardActivity$1(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onClick(View paramView)
  {
    DiscussionInfoCardActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.1
 * JD-Core Version:    0.7.0.1
 */