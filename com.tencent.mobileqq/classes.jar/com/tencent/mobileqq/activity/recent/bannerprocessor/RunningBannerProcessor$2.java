package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class RunningBannerProcessor$2
  implements View.OnClickListener
{
  RunningBannerProcessor$2(RunningBannerProcessor paramRunningBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    RunningBannerProcessor.b(this.a).sendEmptyMessage(3000);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.RunningBannerProcessor.2
 * JD-Core Version:    0.7.0.1
 */