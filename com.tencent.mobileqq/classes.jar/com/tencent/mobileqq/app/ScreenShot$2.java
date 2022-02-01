package com.tencent.mobileqq.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

class ScreenShot$2
  implements Runnable
{
  public void run()
  {
    synchronized (this.this$0.o)
    {
      View localView = this.this$0.b.getDecorView();
      localView.setDrawingCacheEnabled(true);
      localView.buildDrawingCache();
      Bitmap localBitmap = localView.getDrawingCache();
      Rect localRect = new Rect();
      this.this$0.b.getDecorView().getWindowVisibleDisplayFrame(localRect);
      int i = localRect.top;
      int j = ((Activity)this.this$0.a).getWindowManager().getDefaultDisplay().getWidth();
      int k = ((Activity)this.this$0.a).getWindowManager().getDefaultDisplay().getHeight();
      try
      {
        this.this$0.n = Bitmap.createBitmap(localBitmap, 0, i, j, k - i);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScreenShot", 2, localOutOfMemoryError, new Object[0]);
        }
      }
      localView.destroyDrawingCache();
      this.this$0.o.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ScreenShot.2
 * JD-Core Version:    0.7.0.1
 */