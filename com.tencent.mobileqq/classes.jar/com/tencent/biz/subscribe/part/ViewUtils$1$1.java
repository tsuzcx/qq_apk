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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" qrWhiteBitmap after blur =  bd");
    localStringBuilder.append(localBitmapDrawable);
    QLog.d("ViewUtils", 2, localStringBuilder.toString());
    this.this$0.a.setBackgroundDrawable(localBitmapDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.ViewUtils.1.1
 * JD-Core Version:    0.7.0.1
 */