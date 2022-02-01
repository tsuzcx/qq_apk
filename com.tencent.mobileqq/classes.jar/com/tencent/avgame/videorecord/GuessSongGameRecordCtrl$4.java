package com.tencent.avgame.videorecord;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import mqq.util.WeakReference;

class GuessSongGameRecordCtrl$4
  implements Runnable
{
  GuessSongGameRecordCtrl$4(GuessSongGameRecordCtrl paramGuessSongGameRecordCtrl, int paramInt, View paramView) {}
  
  public void run()
  {
    if (this.this$0.k())
    {
      int i = this.a;
      float f1 = (i >> 16 & 0xFF) / 255.0F;
      float f2 = (i >> 8 & 0xFF) / 255.0F;
      float f3 = (i & 0xFF) / 255.0F;
      float f4 = (i >> 24 & 0xFF) / 255.0F;
      if (f4 > 0.0F) {
        this.this$0.a(true, f1, f2, f3, f4);
      } else {
        this.this$0.a(false, 0.0F, 0.0F, 0.0F, 0.0F);
      }
      this.b.destroyDrawingCache();
      Bitmap localBitmap = this.b.getDrawingCache();
      if (localBitmap != null)
      {
        Context localContext = (Context)this.this$0.e.get();
        if (localContext != null)
        {
          f1 = 720.0F / localContext.getResources().getDisplayMetrics().widthPixels;
          i = (int)(this.b.getWidth() * f1);
          int j = (int)(this.b.getHeight() * f1);
          int k = (720 - i) / 2;
          int m = (720 - j) / 2;
          this.this$0.b(localBitmap, i, j, k, m);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.4
 * JD-Core Version:    0.7.0.1
 */