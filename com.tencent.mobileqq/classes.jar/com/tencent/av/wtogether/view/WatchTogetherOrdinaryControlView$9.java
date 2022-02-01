package com.tencent.av.wtogether.view;

import android.widget.ProgressBar;

class WatchTogetherOrdinaryControlView$9
  implements Runnable
{
  WatchTogetherOrdinaryControlView$9(WatchTogetherOrdinaryControlView paramWatchTogetherOrdinaryControlView) {}
  
  public void run()
  {
    WatchTogetherOrdinaryControlView.q(this.this$0);
    WatchTogetherOrdinaryControlView.b(this.this$0, 0);
    WatchTogetherOrdinaryControlView.a(this.this$0, 0L);
    if (!WatchTogetherOrdinaryControlView.r(this.this$0)) {
      WatchTogetherOrdinaryControlView.a(this.this$0, 1, 1);
    } else {
      WatchTogetherOrdinaryControlView.a(this.this$0, 0, 1);
    }
    WatchTogetherOrdinaryControlView.s(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherOrdinaryControlView.9
 * JD-Core Version:    0.7.0.1
 */