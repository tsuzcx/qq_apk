package com.tencent.avgame.videorecord;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import mqq.util.WeakReference;
import niq;

public class GuessSongGameRecordCtrl$5
  implements Runnable
{
  public GuessSongGameRecordCtrl$5(niq paramniq, View paramView) {}
  
  public void run()
  {
    if (this.a != null)
    {
      this.a.destroyDrawingCache();
      Bitmap localBitmap = this.a.getDrawingCache();
      if (localBitmap != null)
      {
        Context localContext = (Context)this.this$0.a.get();
        if (localContext != null)
        {
          float f = 720.0F / localContext.getResources().getDisplayMetrics().widthPixels;
          int i = (int)(this.a.getWidth() * f);
          int j = (int)(this.a.getHeight() * f);
          int k = (int)(this.a.getLeft() * f);
          int m = (int)(f * this.a.getTop());
          this.this$0.a(localBitmap, i, j, k, m);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.5
 * JD-Core Version:    0.7.0.1
 */