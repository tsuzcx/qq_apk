package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TofuAioMiniProfileItemBuilder$4
  implements View.OnClickListener
{
  TofuAioMiniProfileItemBuilder$4(TofuAioMiniProfileItemBuilder paramTofuAioMiniProfileItemBuilder) {}
  
  public void onClick(View paramView)
  {
    TofuAioMiniProfileItemBuilder.b(this.a);
    ReportController.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", TofuAioMiniProfileItemBuilder.a(this.a), "个性签名");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAioMiniProfileItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */