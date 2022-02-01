package com.tencent.ilivesdk.playview.view;

import android.os.Handler;
import com.tencent.ilivesdk.utils.LogUtils;

class PlayTextureView$5
  implements Runnable
{
  PlayTextureView$5(PlayTextureView paramPlayTextureView) {}
  
  public void run()
  {
    PlayTextureView.access$1800(this.this$0);
    PlayTextureView.access$600(this.this$0).post(new PlayTextureView.5.1(this));
    long l = System.currentTimeMillis();
    for (;;)
    {
      if (this.this$0.getVisibility() != 8) {
        LogUtils.i("Render|PlayTextureView", "==============PlayView wait set GONE");
      }
      try
      {
        Thread.sleep(50L);
        if (System.currentTimeMillis() - l <= 3000L) {
          continue;
        }
        LogUtils.i("Render|PlayTextureView", "==============PlayView set GONE time out");
        LogUtils.i("Render|PlayTextureView", "==============PlayView set GONE over");
        PlayTextureView.access$1902(this.this$0, false);
        PlayTextureView.access$2002(this.this$0, false);
        if (PlayTextureView.access$2100(this.this$0)) {
          PlayTextureView.access$600(this.this$0).post(new PlayTextureView.5.2(this));
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayTextureView.5
 * JD-Core Version:    0.7.0.1
 */