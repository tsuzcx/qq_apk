package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TofuAioMiniProfileItemBuilder$2
  implements View.OnClickListener
{
  TofuAioMiniProfileItemBuilder$2(TofuAioMiniProfileItemBuilder paramTofuAioMiniProfileItemBuilder) {}
  
  public void onClick(View paramView)
  {
    TofuAioMiniProfileItemBuilder.a(this.a);
    ReportController.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", TofuAioMiniProfileItemBuilder.b(this.a), "空间");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAioMiniProfileItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */