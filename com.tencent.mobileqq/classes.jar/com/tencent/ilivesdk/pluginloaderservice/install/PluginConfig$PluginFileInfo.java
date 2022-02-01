package com.tencent.ilivesdk.pluginloaderservice.install;

import java.io.File;

public class PluginConfig$PluginFileInfo
  extends PluginConfig.FileInfo
{
  public final String[] c;
  public final String[] d;
  public final String e;
  
  PluginConfig$PluginFileInfo(String paramString, PluginConfig.FileInfo paramFileInfo, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this(paramString, paramFileInfo.a, paramFileInfo.b, paramArrayOfString1, paramArrayOfString2);
  }
  
  PluginConfig$PluginFileInfo(String paramString1, File paramFile, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    super(paramFile, paramString2);
    this.e = paramString1;
    this.c = paramArrayOfString1;
    this.d = paramArrayOfString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.install.PluginConfig.PluginFileInfo
 * JD-Core Version:    0.7.0.1
 */