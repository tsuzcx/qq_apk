package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class ReaderBannerProcessor$2
  implements View.OnClickListener
{
  ReaderBannerProcessor$2(ReaderBannerProcessor paramReaderBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    ReaderBannerProcessor.a(this.a).sendEmptyMessage(3001);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ReaderBannerProcessor.2
 * JD-Core Version:    0.7.0.1
 */