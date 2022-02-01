package com.tencent.biz.qcircleshadow.lib.variation;

import java.io.File;

public class HostFileUtils
{
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    return cooperation.qzone.util.FileUtils.copyFile(paramFile1, paramFile2);
  }
  
  public static void createFileIfNotExits(String paramString)
  {
    com.tencent.mobileqq.utils.FileUtils.c(paramString);
  }
  
  public static void delete(String paramString, boolean paramBoolean)
  {
    com.tencent.mobileqq.utils.FileUtils.a(paramString, paramBoolean);
  }
  
  public static void deleteDirectory(String paramString)
  {
    com.tencent.mobileqq.utils.FileUtils.a(paramString);
  }
  
  public static void deleteFile(File paramFile)
  {
    cooperation.qzone.util.FileUtils.deleteFile(paramFile);
  }
  
  public static String estimateFileType(String paramString)
  {
    return com.tencent.mobileqq.utils.FileUtils.b(paramString);
  }
  
  public static boolean fileExists(String paramString)
  {
    return com.tencent.mobileqq.utils.FileUtils.a(paramString);
  }
  
  public static boolean fileExistsAndNotEmpty(String paramString)
  {
    return com.tencent.mobileqq.utils.FileUtils.b(paramString);
  }
  
  public static boolean isFileJPEG(String paramString)
  {
    return estimateFileType(paramString).equals("jpg");
  }
  
  public static boolean moveFile(String paramString1, String paramString2)
  {
    return com.tencent.mobileqq.utils.FileUtils.b(paramString1, paramString2);
  }
  
  public static String readFileContent(File paramFile)
  {
    return com.tencent.mobileqq.utils.FileUtils.a(paramFile);
  }
  
  public static boolean unzip(File paramFile1, File paramFile2)
  {
    return cooperation.qzone.util.FileUtils.unzip(paramFile1, paramFile2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils
 * JD-Core Version:    0.7.0.1
 */