package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardRecentActivity$25
  implements View.OnClickListener
{
  ForwardRecentActivity$25(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.directShareTips != null) && (this.a.directShareTips.getVisibility() == 0)) {
      this.a.directShareTips.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.25
 * JD-Core Version:    0.7.0.1
 */