package com.tencent.aelight.camera.aioeditor.capture.util;

import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import java.io.File;

public class InfoStickerSaveUtils
{
  private static File jdField_a_of_type_JavaIoFile = new File(QIMFileUtils.a(), "information_paster");
  private static String jdField_a_of_type_JavaLangString;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaIoFile.getPath());
    localStringBuilder.append(File.separator);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public static File a()
  {
    return jdField_a_of_type_JavaIoFile;
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String a(InformationFacePackage.Item paramItem)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramItem.g);
    localStringBuilder.append("_");
    localStringBuilder.append(paramItem.f);
    localStringBuilder.append(".zip");
    paramItem = localStringBuilder.toString();
    return new File(jdField_a_of_type_JavaIoFile, paramItem).getPath();
  }
  
  public static String b(InformationFacePackage.Item paramItem)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(paramItem.g);
    localStringBuilder.append("_");
    localStringBuilder.append(paramItem.f);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramItem.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.util.InfoStickerSaveUtils
 * JD-Core Version:    0.7.0.1
 */