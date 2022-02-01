package com.tencent.av.wtogether.view;

import android.os.Handler;

class WatchTogetherOrdinaryControlView$1
  implements Runnable
{
  WatchTogetherOrdinaryControlView$1(WatchTogetherOrdinaryControlView paramWatchTogetherOrdinaryControlView) {}
  
  public void run()
  {
    if (WatchTogetherOrdinaryControlView.a(this.this$0) == null) {
      return;
    }
    if ((WatchTogetherOrdinaryControlView.b(this.this$0) == 1) && (WatchTogetherOrdinaryControlView.c(this.this$0) == 2))
    {
      WatchTogetherOrdinaryControlView.a(this.this$0, 0, 2);
      return;
    }
    WatchTogetherOrdinaryControlView.d(this.this$0).removeCallbacks(this);
    WatchTogetherOrdinaryControlView.d(this.this$0).postDelayed(this, WatchTogetherOrdinaryControlView.e(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherOrdinaryControlView.1
 * JD-Core Version:    0.7.0.1
 */