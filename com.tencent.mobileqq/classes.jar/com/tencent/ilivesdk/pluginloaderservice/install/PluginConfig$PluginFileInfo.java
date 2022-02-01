package com.tencent.ilivesdk.pluginloaderservice.install;

import java.io.File;

public class PluginConfig$PluginFileInfo
  extends PluginConfig.FileInfo
{
  public final String[] a;
  public final String b;
  public final String[] b;
  
  PluginConfig$PluginFileInfo(String paramString, PluginConfig.FileInfo paramFileInfo, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this(paramString, paramFileInfo.jdField_a_of_type_JavaIoFile, paramFileInfo.jdField_a_of_type_JavaLangString, paramArrayOfString1, paramArrayOfString2);
  }
  
  PluginConfig$PluginFileInfo(String paramString1, File paramFile, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    super(paramFile, paramString2);
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.a = paramArrayOfString1;
    this.jdField_b_of_type_ArrayOfJavaLangString = paramArrayOfString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.install.PluginConfig.PluginFileInfo
 * JD-Core Version:    0.7.0.1
 */