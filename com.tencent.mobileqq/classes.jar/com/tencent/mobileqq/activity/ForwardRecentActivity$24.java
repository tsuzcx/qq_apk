package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardRecentActivity$24
  implements View.OnClickListener
{
  ForwardRecentActivity$24(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (this.a.a.getVisibility() == 0)) {
      this.a.a.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.24
 * JD-Core Version:    0.7.0.1
 */