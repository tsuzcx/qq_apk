package com.tencent.hydevteam.pluginframework.installedplugin;

import com.tencent.hydevteam.common.annotation.API;
import java.io.File;
import java.io.Serializable;

@API
public class InstalledPlugin
  implements Serializable
{
  public static final String PLUGIN_FILE_PATH = "PLUGIN_FILE_PATH";
  public static final String PLUGIN_LAUNCH_FAILED_TAG = "launch.failed";
  public static final String PLUGIN_PACKAGE_NAME = "PLUGIN_PACKAGE_NAME";
  public static final String PLUGIN_VERSION = "PLUGIN_VERSION";
  private static final long serialVersionUID = -6006001380938520517L;
  public final File pluginFile;
  public int pluginFileType;
  public final String pluginPackageName;
  public final String pluginVersionForConfigPluginLoader;
  public final String pluginVersionForPluginLoaderManage;
  
  public InstalledPlugin(String paramString1, String paramString2, File paramFile)
  {
    this.pluginPackageName = paramString1;
    this.pluginVersionForConfigPluginLoader = paramString2;
    this.pluginVersionForPluginLoaderManage = Long.toString(paramFile.lastModified(), 36);
    this.pluginFile = paramFile;
  }
  
  public InstalledPlugin(String paramString1, String paramString2, File paramFile, int paramInt)
  {
    this(paramString1, paramString2, paramFile);
    this.pluginFileType = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (InstalledPlugin)paramObject;
      if (!this.pluginPackageName.equals(paramObject.pluginPackageName)) {
        return false;
      }
      if (!this.pluginVersionForConfigPluginLoader.equals(paramObject.pluginVersionForConfigPluginLoader)) {
        return false;
      }
      if (!this.pluginVersionForPluginLoaderManage.equals(paramObject.pluginVersionForPluginLoaderManage)) {
        return false;
      }
      return this.pluginFile.equals(paramObject.pluginFile);
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((this.pluginPackageName.hashCode() * 31 + this.pluginVersionForConfigPluginLoader.hashCode()) * 31 + this.pluginVersionForPluginLoaderManage.hashCode()) * 31 + this.pluginFile.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("InstalledPlugin{pluginPackageName='");
    localStringBuilder.append(this.pluginPackageName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pluginVersionForConfigPluginLoader='");
    localStringBuilder.append(this.pluginVersionForConfigPluginLoader);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pluginVersionForPluginLoaderManage='");
    localStringBuilder.append(this.pluginVersionForPluginLoaderManage);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pluginFile=");
    localStringBuilder.append(this.pluginFile);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin
 * JD-Core Version:    0.7.0.1
 */