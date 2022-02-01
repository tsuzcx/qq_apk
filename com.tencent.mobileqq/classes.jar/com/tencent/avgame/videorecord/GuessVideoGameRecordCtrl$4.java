package com.tencent.avgame.videorecord;

import android.graphics.Bitmap;
import android.view.View;

class GuessVideoGameRecordCtrl$4
  implements Runnable
{
  GuessVideoGameRecordCtrl$4(GuessVideoGameRecordCtrl paramGuessVideoGameRecordCtrl, View paramView) {}
  
  public void run()
  {
    if (this.a != null)
    {
      this.a.destroyDrawingCache();
      Bitmap localBitmap = this.a.getDrawingCache();
      if (localBitmap != null) {
        this.this$0.a(localBitmap, this.a.getWidth(), this.a.getHeight(), this.a.getLeft(), this.a.getTop());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessVideoGameRecordCtrl.4
 * JD-Core Version:    0.7.0.1
 */