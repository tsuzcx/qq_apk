package com.tencent.av.wtogether.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerProxy;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WatchTogetherAdminControlView$9
  implements View.OnClickListener
{
  WatchTogetherAdminControlView$9(WatchTogetherAdminControlView paramWatchTogetherAdminControlView) {}
  
  public void onClick(View paramView)
  {
    WatchTogetherAdminControlView.a(this.a, 1, 2);
    WatchTogetherAdminControlView.c(this.a);
    if (WatchTogetherAdminControlView.a(this.a) != null) {
      WatchTogetherAdminControlView.a(this.a).b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView.9
 * JD-Core Version:    0.7.0.1
 */