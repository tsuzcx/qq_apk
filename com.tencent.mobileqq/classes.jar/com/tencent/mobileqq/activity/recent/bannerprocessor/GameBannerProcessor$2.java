package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class GameBannerProcessor$2
  implements View.OnClickListener
{
  GameBannerProcessor$2(GameBannerProcessor paramGameBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    GameBannerProcessor.f(this.a).sendEmptyMessage(1000);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.GameBannerProcessor.2
 * JD-Core Version:    0.7.0.1
 */