package com.tencent.mobileqq.activity.aio.item;

import android.widget.Scroller;

class ClickedWaveView$MovingRadiusRunnable
  implements Runnable
{
  ClickedWaveView$MovingRadiusRunnable(ClickedWaveView paramClickedWaveView) {}
  
  public void run()
  {
    if ((this.this$0.a.computeScrollOffset()) || (this.this$0.d > 0))
    {
      ClickedWaveView localClickedWaveView = this.this$0;
      localClickedWaveView.c = localClickedWaveView.a.getCurrX();
      if (this.this$0.d > 0)
      {
        localClickedWaveView = this.this$0;
        localClickedWaveView.d -= 3;
      }
      if (this.this$0.d < 0) {
        this.this$0.d = 0;
      }
      this.this$0.postInvalidate();
      this.this$0.postDelayed(this, 20L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ClickedWaveView.MovingRadiusRunnable
 * JD-Core Version:    0.7.0.1
 */