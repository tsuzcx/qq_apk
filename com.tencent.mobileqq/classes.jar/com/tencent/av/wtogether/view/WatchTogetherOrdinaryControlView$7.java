package com.tencent.av.wtogether.view;

import android.widget.ProgressBar;

class WatchTogetherOrdinaryControlView$7
  implements Runnable
{
  WatchTogetherOrdinaryControlView$7(WatchTogetherOrdinaryControlView paramWatchTogetherOrdinaryControlView) {}
  
  public void run()
  {
    WatchTogetherOrdinaryControlView.f(this.this$0);
    WatchTogetherOrdinaryControlView.a(this.this$0, 0);
    WatchTogetherOrdinaryControlView.a(this.this$0, 0L);
    if (!WatchTogetherOrdinaryControlView.b(this.this$0)) {
      WatchTogetherOrdinaryControlView.a(this.this$0, 1, 1);
    } else {
      WatchTogetherOrdinaryControlView.a(this.this$0, 0, 1);
    }
    WatchTogetherOrdinaryControlView.a(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherOrdinaryControlView.7
 * JD-Core Version:    0.7.0.1
 */