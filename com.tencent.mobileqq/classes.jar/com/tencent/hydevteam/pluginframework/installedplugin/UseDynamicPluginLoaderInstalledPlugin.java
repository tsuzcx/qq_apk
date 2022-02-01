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
                  bool1 = bool2;
                } while (!super.equals(paramObject));
                paramObject = (UseDynamicPluginLoaderInstalledPlugin)paramObject;
                bool1 = bool2;
              } while (!this.dynamicPluginLoaderVersion.equals(paramObject.dynamicPluginLoaderVersion));
              bool1 = bool2;
            } while (!this.dynamicPluginContainerVersion.equals(paramObject.dynamicPluginContainerVersion));
            bool1 = bool2;
          } while (!this.dynamicPluginLoaderFile.equals(paramObject.dynamicPluginLoaderFile));
          bool1 = bool2;
        } while (!this.dynamicPluginContainerFile.equals(paramObject.dynamicPluginContainerFile));
        bool1 = bool2;
      } while (!this.dynamicPluginLoaderClassname.equals(paramObject.dynamicPluginLoaderClassname));
      bool1 = bool2;
    } while (!Arrays.equals(this.dynamicPluginLoaderInterfacePackageNames, paramObject.dynamicPluginLoaderInterfacePackageNames));
    return this.pluginUnpackDir.equals(paramObject.pluginUnpackDir);
  }
  
  public int hashCode()
  {
    return ((((((super.hashCode() * 31 + this.dynamicPluginLoaderVersion.hashCode()) * 31 + this.dynamicPluginContainerVersion.hashCode()) * 31 + this.dynamicPluginLoaderFile.hashCode()) * 31 + this.dynamicPluginContainerFile.hashCode()) * 31 + this.dynamicPluginLoaderClassname.hashCode()) * 31 + Arrays.hashCode(this.dynamicPluginLoaderInterfacePackageNames)) * 31 + this.pluginUnpackDir.hashCode();
  }
  
  public String toString()
  {
    return "UseDynamicPluginLoaderInstalledPlugin{dynamicPluginLoaderVersion='" + this.dynamicPluginLoaderVersion + '\'' + ", dynamicPluginContainerVersion='" + this.dynamicPluginContainerVersion + '\'' + ", dynamicPluginLoaderFile=" + this.dynamicPluginLoaderFile + ", dynamicPluginContainerFile=" + this.dynamicPluginContainerFile + ", dynamicPluginLoaderClassname='" + this.dynamicPluginLoaderClassname + '\'' + ", dynamicPluginLoaderInterfacePackageNames=" + Arrays.toString(this.dynamicPluginLoaderInterfacePackageNames) + ", pluginUnpackDir=" + this.pluginUnpackDir + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.installedplugin.UseDynamicPluginLoaderInstalledPlugin
 * JD-Core Version:    0.7.0.1
 */