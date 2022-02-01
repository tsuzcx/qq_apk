package com.tencent.biz.qqcircle.flutter.animation.unzip;

import java.io.File;
import java.io.FileFilter;

class QCircleFlutterZipFileFactory$3
  implements FileFilter
{
  QCircleFlutterZipFileFactory$3(QCircleFlutterZipFileFactory paramQCircleFlutterZipFileFactory) {}
  
  public boolean accept(File paramFile)
  {
    return (!paramFile.getName().endsWith(".")) && (!paramFile.getName().equalsIgnoreCase("__MACOSX"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.animation.unzip.QCircleFlutterZipFileFactory.3
 * JD-Core Version:    0.7.0.1
 */