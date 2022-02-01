package com.tencent.biz.qqcircle.flutter.animation.unzip;

import java.util.Map;

class QCircleFlutterZipFileFactory$2
  implements Runnable
{
  QCircleFlutterZipFileFactory$2(QCircleFlutterZipFileFactory paramQCircleFlutterZipFileFactory, QCircleFlutterZipOption paramQCircleFlutterZipOption, String[] paramArrayOfString) {}
  
  public void run()
  {
    Object localObject = this.a;
    QCircleFlutterZipFileFactory.OnZipFileListener localOnZipFileListener = null;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((QCircleFlutterZipOption)localObject).b();
    }
    if (QCircleFlutterZipFileFactory.a(this.this$0) != null) {
      localOnZipFileListener = (QCircleFlutterZipFileFactory.OnZipFileListener)QCircleFlutterZipFileFactory.a(this.this$0).get(localObject);
    }
    if (localOnZipFileListener != null) {
      localOnZipFileListener.a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.animation.unzip.QCircleFlutterZipFileFactory.2
 * JD-Core Version:    0.7.0.1
 */