package com.tencent.biz.qqcircle.flutter.animation.unzip;

import android.text.TextUtils;

class QCircleFlutterZipFileFactory$1
  implements Runnable
{
  QCircleFlutterZipFileFactory$1(QCircleFlutterZipFileFactory paramQCircleFlutterZipFileFactory, QCircleFlutterZipOption paramQCircleFlutterZipOption) {}
  
  public void run()
  {
    Object localObject = this.a.b();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = this.this$0.a((String)localObject);
      QCircleFlutterZipFileFactory.a(this.this$0, this.a, (String[])localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.animation.unzip.QCircleFlutterZipFileFactory.1
 * JD-Core Version:    0.7.0.1
 */