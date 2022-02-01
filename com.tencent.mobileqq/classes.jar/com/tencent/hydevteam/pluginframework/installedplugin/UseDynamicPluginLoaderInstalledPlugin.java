package com.tencent.hydevteam.pluginframework.installedplugin;

import java.io.File;
import java.util.Arrays;

public class UseDynamicPluginLoaderInstalledPlugin
  extends InstalledPlugin
{
  public static final String DYNAMIC_PLUGIN_CONTAINER_PATH = "DYNAMIC_PLUGIN_CONTAINER_PATH";
  public static final String DYNAMIC_PLUGIN_CONTAINER_VERSION = "DYNAMIC_PLUGIN_CONTAINER_VERSION";
  public static final String DYNAMIC_PLUGIN_LOADER_CLASSNAME = "DYNAMIC_PLUGIN_LOADER_CLASSNAME";
  public static final String DYNAMIC_PLUGIN_LOADER_INTERFACE_PACKAGE_NAMES = "DYNAMIC_PLUGIN_LOADER_INTERFACE_PACKAGE_NAMES";
  public static final String DYNAMIC_PLUGIN_LOADER_PATH = "DYNAMIC_PLUGIN_LOADER_PATH";
  public static final String DYNAMIC_PLUGIN_LOADER_VERSION = "DYNAMIC_PLUGIN_LOADER_VERSION";
  public static final String DYNAMIC_PLUGIN_PLUGIN_FILE_TYPE = "DYNAMIC_PLUGIN_PLUGIN_FILE_TYPE";
  private static final long serialVersionUID = 8964590057389188960L;
  public final File dynamicPluginContainerFile;
  public final String dynamicPluginContainerVersion;
  public final String dynamicPluginLoaderClassname;
  public final File dynamicPluginLoaderFile;
  public final String[] dynamicPluginLoaderInterfacePackageNames;
  public final String dynamicPluginLoaderVersion;
  public final File pluginUnpackDir;
  
  public UseDynamicPluginLoaderInstalledPlugin(String paramString1, String paramString2, File paramFile1, String paramString3, String paramString4, File paramFile2, File paramFile3, String paramString5, String[] paramArrayOfString, File paramFile4)
  {
    super(paramString1, paramString2, paramFile1);
    this.dynamicPluginLoaderVersion = paramString3;
    this.dynamicPluginContainerVersion = paramString4;
    this.dynamicPluginLoaderFile = paramFile2;
    this.dynamicPluginContainerFile = paramFile3;
    this.dynamicPluginLoaderClassname = paramString5;
    this.dynamicPluginLoaderInterfacePackageNames = paramArrayOfString;
    this.pluginUnpackDir = paramFile4;
  }
  
  public UseDynamicPluginLoaderInstalledPlugin(String paramString1, String paramString2, File paramFile1, String paramString3, String paramString4, File paramFile2, File paramFile3, String paramString5, String[] paramArrayOfString, File paramFile4, int paramInt)
  {
    super(paramString1, paramString2, paramFile1, paramInt);
    this.dynamicPluginLoaderVersion = paramString3;
    this.dynamicPluginContainerVersion = paramString4;
    this.dynamicPluginLoaderFile = paramFile2;
    this.dynamicPluginContainerFile = paramFile3;
    this.dynamicPluginLoaderClassname = paramString5;
    this.dynamicPluginLoaderInterfacePackageNames = paramArrayOfString;
    this.pluginUnpackDir = paramFile4;
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
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (UseDynamicPluginLoaderInstalledPlugin)paramObject;
      if (!this.dynamicPluginLoaderVersion.equals(paramObject.dynamicPluginLoaderVersion)) {
        return false;
      }
      if (!this.dynamicPluginContainerVersion.equals(paramObject.dynamicPluginContainerVersion)) {
        return false;
      }
      if (!this.dynamicPluginLoaderFile.equals(paramObject.dynamicPluginLoaderFile)) {
        return false;
      }
      if (!this.dynamicPluginContainerFile.equals(paramObject.dynamicPluginContainerFile)) {
        return false;
      }
      if (!this.dynamicPluginLoaderClassname.equals(paramObject.dynamicPluginLoaderClassname)) {
        return false;
      }
      if (!Arrays.equals(this.dynamicPluginLoaderInterfacePackageNames, paramObject.dynamicPluginLoaderInterfacePackageNames)) {
        return false;
      }
      return this.pluginUnpackDir.equals(paramObject.pluginUnpackDir);
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((((((super.hashCode() * 31 + this.dynamicPluginLoaderVersion.hashCode()) * 31 + this.dynamicPluginContainerVersion.hashCode()) * 31 + this.dynamicPluginLoaderFile.hashCode()) * 31 + this.dynamicPluginContainerFile.hashCode()) * 31 + this.dynamicPluginLoaderClassname.hashCode()) * 31 + Arrays.hashCode(this.dynamicPluginLoaderInterfacePackageNames)) * 31 + this.pluginUnpackDir.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("UseDynamicPluginLoaderInstalledPlugin{dynamicPluginLoaderVersion='");
    localStringBuilder.append(this.dynamicPluginLoaderVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dynamicPluginContainerVersion='");
    localStringBuilder.append(this.dynamicPluginContainerVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dynamicPluginLoaderFile=");
    localStringBuilder.append(this.dynamicPluginLoaderFile);
    localStringBuilder.append(", dynamicPluginContainerFile=");
    localStringBuilder.append(this.dynamicPluginContainerFile);
    localStringBuilder.append(", dynamicPluginLoaderClassname='");
    localStringBuilder.append(this.dynamicPluginLoaderClassname);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dynamicPluginLoaderInterfacePackageNames=");
    localStringBuilder.append(Arrays.toString(this.dynamicPluginLoaderInterfacePackageNames));
    localStringBuilder.append(", pluginUnpackDir=");
    localStringBuilder.append(this.pluginUnpackDir);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.installedplugin.UseDynamicPluginLoaderInstalledPlugin
 * JD-Core Version:    0.7.0.1
 */