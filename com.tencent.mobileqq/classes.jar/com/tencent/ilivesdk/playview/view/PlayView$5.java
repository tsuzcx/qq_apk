package com.tencent.ilivesdk.playview.view;

import android.os.Handler;
import com.tencent.ilivesdk.utils.LogUtils;

class PlayView$5
  implements Runnable
{
  PlayView$5(PlayView paramPlayView) {}
  
  public void run()
  {
    PlayView.access$1800(this.this$0);
    PlayView.access$600(this.this$0).post(new PlayView.5.1(this));
    long l = System.currentTimeMillis();
    while (this.this$0.getVisibility() != 8)
    {
      LogUtils.i("MediaPESdk|PlayView", "==============PlayView wait set GONE");
      try
      {
        Thread.sleep(50L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      if (System.currentTimeMillis() - l > 3000L) {
        LogUtils.i("MediaPESdk|PlayView", "==============PlayView set GONE time out");
      }
    }
    LogUtils.i("MediaPESdk|PlayView", "==============PlayView set GONE over");
    PlayView.access$1902(this.this$0, false);
    PlayView.access$2002(this.this$0, false);
    if (PlayView.access$2100(this.this$0)) {
      PlayView.access$600(this.this$0).post(new PlayView.5.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayView.5
 * JD-Core Version:    0.7.0.1
 */