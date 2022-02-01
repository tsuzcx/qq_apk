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
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      View localView = this.this$0.jdField_a_of_type_AndroidViewWindow.getDecorView();
      localView.setDrawingCacheEnabled(true);
      localView.buildDrawingCache();
      Bitmap localBitmap = localView.getDrawingCache();
      Rect localRect = new Rect();
      this.this$0.jdField_a_of_type_AndroidViewWindow.getDecorView().getWindowVisibleDisplayFrame(localRect);
      int i = localRect.top;
      int j = ((Activity)this.this$0.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getWidth();
      int k = ((Activity)this.this$0.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getHeight();
      try
      {
        this.this$0.d = Bitmap.createBitmap(localBitmap, 0, i, j, k - i);
        localView.destroyDrawingCache();
        this.this$0.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ScreenShot", 2, localOutOfMemoryError, new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ScreenShot.2
 * JD-Core Version:    0.7.0.1
 */