package com.tencent.aelight.camera.ae.download.old;

import java.io.File;

public class AEOldPath$CAMERA$CACHE
{
  public static final String a;
  public static final String b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEOldPathBase.BASE.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("camera");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("photo_compress");
    b = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.old.AEOldPath.CAMERA.CACHE
 * JD-Core Version:    0.7.0.1
 */