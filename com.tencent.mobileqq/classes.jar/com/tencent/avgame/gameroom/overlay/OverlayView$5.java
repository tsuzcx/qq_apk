package com.tencent.avgame.gameroom.overlay;

import android.widget.TextView;

class OverlayView$5
  implements Runnable
{
  OverlayView$5(OverlayView paramOverlayView, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    OverlayView.a(this.this$0).setVisibility(0);
    new ScoreValueUpdater(OverlayView.a(this.this$0), this.a, this.b).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.overlay.OverlayView.5
 * JD-Core Version:    0.7.0.1
 */