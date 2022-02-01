package com.tencent.av.wtogether.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WatchTogetherAdminControlView$8
  implements View.OnClickListener
{
  WatchTogetherAdminControlView$8(WatchTogetherAdminControlView paramWatchTogetherAdminControlView) {}
  
  public void onClick(View paramView)
  {
    WatchTogetherAdminControlView.f(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView.8
 * JD-Core Version:    0.7.0.1
 */