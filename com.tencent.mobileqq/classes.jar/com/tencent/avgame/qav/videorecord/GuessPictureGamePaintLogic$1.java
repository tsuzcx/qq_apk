package com.tencent.avgame.qav.videorecord;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class GuessPictureGamePaintLogic$1
  implements Runnable
{
  GuessPictureGamePaintLogic$1(GuessPictureGamePaintLogic paramGuessPictureGamePaintLogic, View paramView, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    this.a.setDrawingCacheEnabled(true);
    Bitmap localBitmap = this.a.getDrawingCache();
    if (localBitmap != null)
    {
      int j = this.a.getWidth();
      int i = this.a.getHeight();
      j = (GuessPictureGamePaintLogic.a(this.this$0) - j) / 2;
      i = (GuessPictureGamePaintLogic.b(this.this$0) - i) / 2;
      synchronized (GuessPictureGamePaintLogic.c(this.this$0))
      {
        GuessPictureGamePaintLogic.a(this.this$0, new GameImageData());
        GuessPictureGamePaintLogic.d(this.this$0).a = localBitmap.copy(Bitmap.Config.ARGB_8888, false);
        GuessPictureGamePaintLogic.d(this.this$0).f = this.b;
        GuessPictureGamePaintLogic.d(this.this$0).d = j;
        GuessPictureGamePaintLogic.d(this.this$0).e = i;
        GuessPictureGamePaintLogic.d(this.this$0).g = "Answer";
        GuessPictureGamePaintLogic.d(this.this$0).i = this.c;
        GuessPictureGamePaintLogic.a(this.this$0, true);
      }
    }
    this.a.setDrawingCacheEnabled(false);
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGamePaintLogic", 2, "onAnswerViewShow indeed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.videorecord.GuessPictureGamePaintLogic.1
 * JD-Core Version:    0.7.0.1
 */