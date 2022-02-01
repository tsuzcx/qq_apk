package com.tencent.biz.qqcircle.flutter.animation.unzip;

import java.io.File;
import java.util.Comparator;

class QCircleFlutterZipFileFactory$4
  implements Comparator<File>
{
  QCircleFlutterZipFileFactory$4(QCircleFlutterZipFileFactory paramQCircleFlutterZipFileFactory) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareToIgnoreCase(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.animation.unzip.QCircleFlutterZipFileFactory.4
 * JD-Core Version:    0.7.0.1
 */