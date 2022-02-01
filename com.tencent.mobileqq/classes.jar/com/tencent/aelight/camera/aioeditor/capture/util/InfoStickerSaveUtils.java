package com.tencent.aelight.camera.aioeditor.capture.util;

import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import java.io.File;

public class InfoStickerSaveUtils
{
  private static File a = new File(QIMFileUtils.a(), "information_paster");
  private static String b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a.getPath());
    localStringBuilder.append(File.separator);
    b = localStringBuilder.toString();
  }
  
  public static File a()
  {
    return a;
  }
  
  public static String a(InformationFacePackage.Item paramItem)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramItem.i);
    localStringBuilder.append("_");
    localStringBuilder.append(paramItem.h);
    localStringBuilder.append(".zip");
    paramItem = localStringBuilder.toString();
    return new File(a, paramItem).getPath();
  }
  
  public static String b()
  {
    return b;
  }
  
  public static String b(InformationFacePackage.Item paramItem)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(paramItem.i);
    localStringBuilder.append("_");
    localStringBuilder.append(paramItem.h);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramItem.i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.util.InfoStickerSaveUtils
 * JD-Core Version:    0.7.0.1
 */