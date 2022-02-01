package com.tencent.avgame.videorecord;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import mqq.util.WeakReference;

class GuessSongGameRecordCtrl$5
  implements Runnable
{
  GuessSongGameRecordCtrl$5(GuessSongGameRecordCtrl paramGuessSongGameRecordCtrl, View paramView) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((View)localObject).destroyDrawingCache();
      localObject = this.a.getDrawingCache();
      if (localObject != null)
      {
        Context localContext = (Context)this.this$0.a.get();
        if (localContext != null)
        {
          float f = 720.0F / localContext.getResources().getDisplayMetrics().widthPixels;
          int i = (int)(this.a.getWidth() * f);
          int j = (int)(this.a.getHeight() * f);
          int k = (int)(this.a.getLeft() * f);
          int m = (int)(this.a.getTop() * f);
          this.this$0.a((Bitmap)localObject, i, j, k, m);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.5
 * JD-Core Version:    0.7.0.1
 */