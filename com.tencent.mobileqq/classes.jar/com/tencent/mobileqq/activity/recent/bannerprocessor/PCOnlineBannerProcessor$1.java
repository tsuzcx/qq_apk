package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PCOnlineBannerProcessor$1
  implements View.OnClickListener
{
  PCOnlineBannerProcessor$1(PCOnlineBannerProcessor paramPCOnlineBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    if (PCOnlineBannerProcessor.a(this.a) == 77313L) {
      PCOnlineBannerProcessor.a(this.a, true);
    }
    this.a.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.PCOnlineBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */