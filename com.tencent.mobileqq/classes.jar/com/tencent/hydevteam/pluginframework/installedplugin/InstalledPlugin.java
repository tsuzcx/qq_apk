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
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (paramObject == null);
            bool1 = bool2;
          } while (getClass() != paramObject.getClass());
          paramObject = (InstalledPlugin)paramObject;
          bool1 = bool2;
        } while (!this.pluginPackageName.equals(paramObject.pluginPackageName));
        bool1 = bool2;
      } while (!this.pluginVersionForConfigPluginLoader.equals(paramObject.pluginVersionForConfigPluginLoader));
      bool1 = bool2;
    } while (!this.pluginVersionForPluginLoaderManage.equals(paramObject.pluginVersionForPluginLoaderManage));
    return this.pluginFile.equals(paramObject.pluginFile);
  }
  
  public int hashCode()
  {
    return ((this.pluginPackageName.hashCode() * 31 + this.pluginVersionForConfigPluginLoader.hashCode()) * 31 + this.pluginVersionForPluginLoaderManage.hashCode()) * 31 + this.pluginFile.hashCode();
  }
  
  public String toString()
  {
    return "InstalledPlugin{pluginPackageName='" + this.pluginPackageName + '\'' + ", pluginVersionForConfigPluginLoader='" + this.pluginVersionForConfigPluginLoader + '\'' + ", pluginVersionForPluginLoaderManage='" + this.pluginVersionForPluginLoaderManage + '\'' + ", pluginFile=" + this.pluginFile + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin
 * JD-Core Version:    0.7.0.1
 */