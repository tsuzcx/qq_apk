package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TimDouFuGuideItemBuilder$1
  implements View.OnClickListener
{
  TimDouFuGuideItemBuilder$1(TimDouFuGuideItemBuilder paramTimDouFuGuideItemBuilder, AppGuideTipsConfig paramAppGuideTipsConfig) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.b.c, QQBrowserActivity.class);
    localIntent.putExtra("url", this.a.tipsUrl);
    this.b.c.startActivity(localIntent);
    ReportController.b(null, "dc00898", "", "", this.a.opkey, this.a.opkey, 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TimDouFuGuideItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */