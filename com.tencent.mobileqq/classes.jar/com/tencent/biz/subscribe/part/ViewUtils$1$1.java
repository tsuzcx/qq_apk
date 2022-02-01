package com.tencent.biz.subscribe.part;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class ViewUtils$1$1
  implements Runnable
{
  ViewUtils$1$1(ViewUtils.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.a);
    QLog.d("ViewUtils", 2, " qrWhiteBitmap after blur =  bd" + localBitmapDrawable);
    this.this$0.a.setBackgroundDrawable(localBitmapDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.ViewUtils.1.1
 * JD-Core Version:    0.7.0.1
 */