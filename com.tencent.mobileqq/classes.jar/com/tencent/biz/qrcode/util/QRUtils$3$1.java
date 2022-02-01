package com.tencent.biz.qrcode.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class QRUtils$3$1
  implements Runnable
{
  QRUtils$3$1(QRUtils.3 param3, Bitmap paramBitmap) {}
  
  public void run()
  {
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.a);
    QLog.d("QRUtils", 2, " qrWhiteBitmap after blur =  bd" + localBitmapDrawable);
    this.this$0.a.setBackgroundDrawable(localBitmapDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.util.QRUtils.3.1
 * JD-Core Version:    0.7.0.1
 */