package com.tencent.av.wtogether.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WatchTogetherOrdinaryControlView$5
  implements View.OnClickListener
{
  WatchTogetherOrdinaryControlView$5(WatchTogetherOrdinaryControlView paramWatchTogetherOrdinaryControlView) {}
  
  public void onClick(View paramView)
  {
    WatchTogetherOrdinaryControlView.d(this.a);
    WatchTogetherOrdinaryControlView.c(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherOrdinaryControlView.5
 * JD-Core Version:    0.7.0.1
 */