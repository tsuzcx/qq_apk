package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.readinjoy.ReadInJoyHelper;

class ReadinjoyTabFrame$10
  implements View.OnClickListener
{
  ReadinjoyTabFrame$10(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    EventCollector.getInstance().onViewClicked(ReadinjoyTabFrame.a(this.a));
    ReadinjoyTabFrame.a(this.a).postDelayed(new ReadinjoyTabFrame.10.1(this, paramView), 300L);
    if ((!RecommendFeedsDiandianEntranceManager.a().a()) && (!ReadInJoyHelper.x())) {
      RecommendFeedsDiandianEntranceManager.a().b(0, this.a.a());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.10
 * JD-Core Version:    0.7.0.1
 */