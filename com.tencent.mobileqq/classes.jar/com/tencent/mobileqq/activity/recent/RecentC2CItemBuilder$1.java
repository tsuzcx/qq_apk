package com.tencent.mobileqq.activity.recent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class RecentC2CItemBuilder$1
  implements View.OnClickListener
{
  RecentC2CItemBuilder$1(RecentC2CItemBuilder paramRecentC2CItemBuilder, AppRuntime paramAppRuntime, RecentBaseData paramRecentBaseData) {}
  
  public void onClick(View paramView)
  {
    RecentC2CItemBuilder.a(this.c, this.a, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentC2CItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */