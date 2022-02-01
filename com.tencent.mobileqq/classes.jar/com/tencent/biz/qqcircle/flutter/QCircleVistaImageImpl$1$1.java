package com.tencent.biz.qqcircle.flutter;

import android.graphics.Bitmap;
import com.qflutter.vistaimage.IVistaImage.LoadBitmapCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class QCircleVistaImageImpl$1$1
  implements Runnable
{
  QCircleVistaImageImpl$1$1(QCircleVistaImageImpl.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    QCircleVistaImageImpl.access$000(this.b.c).put(this.b.b, this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onLoadUrl] cache size=");
      localStringBuilder.append(QCircleVistaImageImpl.access$000(this.b.c).size());
      QLog.d("QCircleVistaImageImpl", 2, localStringBuilder.toString());
    }
    this.b.a.onLoaded(this.b.b, QCircleVistaImageImpl.access$100(this.b.c, this.a), false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QCircleVistaImageImpl.1.1
 * JD-Core Version:    0.7.0.1
 */