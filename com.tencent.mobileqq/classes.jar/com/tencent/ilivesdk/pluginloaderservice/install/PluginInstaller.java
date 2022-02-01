package com.tencent.ilivesdk.pluginloaderservice.install;

import com.tencent.ilivesdk.pluginloaderservice.AbstractPlugin;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.utils.FileUtil;
import com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil;
import java.io.File;
import java.util.Map;

public class PluginInstaller
{
  private AbstractPlugin jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin;
  private File jdField_a_of_type_JavaIoFile;
  
  private File a(File paramFile)
  {
    if (!paramFile.exists())
    {
      LogUtil.c("PluginInstaller", "parseConfigFile: parse config file fail. the config file is not exist.", new Object[0]);
      return null;
    }
    paramFile = PluginConfig.a(FileUtil.a(paramFile.getAbsolutePath()), paramFile.getParentFile());
    if (paramFile == null)
    {
      LogUtil.c("PluginInstaller", "parseConfigFile: parse config file fail. the config file is null.", new Object[0]);
      return null;
    }
    paramFile = (PluginConfig.PluginFileInfo)paramFile.a.get(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.c());
    if (paramFile == null)
    {
      LogUtil.c("PluginInstaller", "parseConfigFile: parse config file fail. the config file info is null.", new Object[0]);
      return null;
    }
    this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.a(paramFile);
    if ((paramFile.jdField_a_of_type_JavaIoFile != null) && (paramFile.jdField_a_of_type_JavaIoFile.exists())) {
      return paramFile.jdField_a_of_type_JavaIoFile;
    }
    return null;
  }
  
  private File a(File paramFile1, File paramFile2)
  {
    File localFile = new File(paramFile2, "config.json");
    if ((localFile.exists()) && (localFile.isFile()))
    {
      LogUtil.a("PluginInstaller", "unpackFile: delete config.json file.", new Object[0]);
      localFile.delete();
    }
    if (!FileUtil.a(paramFile1, paramFile2)) {
      LogUtil.a("PluginInstaller", "unpackFile: unpack file fail.", new Object[0]);
    }
    while ((!localFile.exists()) || (!localFile.isFile())) {
      return null;
    }
    LogUtil.a("PluginInstaller", "unpackFile: success return config.json file.", new Object[0]);
    return localFile;
  }
  
  private File a(File paramFile, String paramString)
  {
    paramFile = new File(paramString);
    if (paramFile.exists()) {
      FileUtil.a(paramFile);
    }
    if (!paramFile.exists())
    {
      LogUtil.b("PluginInstaller", "installODexDir: create oDex dir file.", new Object[0]);
      paramFile.mkdirs();
    }
    return paramFile;
  }
  
  private File a(File paramFile, String paramString, String[] paramArrayOfString)
  {
    if (!paramFile.exists())
    {
      LogUtil.c("PluginInstaller", "installLibs: install libs[%s] fail. the to install file is not exist.", new Object[0]);
      return null;
    }
    paramString = new File(paramString);
    if (paramString.exists()) {
      FileUtil.a(paramString);
    }
    if ((!paramString.exists()) && (!paramString.mkdirs()))
    {
      LogUtil.c("PluginInstaller", "installLibs: install libs[%s] fail.", new Object[] { paramString.getAbsolutePath() });
      return null;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      CopyBloc.b(paramFile, paramString, paramArrayOfString[i]);
      i += 1;
    }
    LogUtil.b("PluginInstaller", "installLibs: install libs success.", new Object[0]);
    return paramString;
  }
  
  private boolean a()
  {
    if ((new File(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.e()).exists()) && (!new File(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.i(), this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.k()).exists())) {
      LogUtil.b("PluginInstaller", "isNeedToInstall: the copied file had not exists.", new Object[0]);
    }
    do
    {
      return true;
      if (this.jdField_a_of_type_JavaIoFile.getAbsolutePath().equals(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.h()))
      {
        LogUtil.b("PluginInstaller", "isNeedToInstall: the updater plugin had in installPath.", new Object[0]);
        return true;
      }
      if (this.jdField_a_of_type_JavaIoFile.getAbsolutePath().equals(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.e()))
      {
        LogUtil.b("PluginInstaller", "isNeedToInstall: the plugin had been installed in installPath .", new Object[0]);
        return false;
      }
    } while (!this.jdField_a_of_type_JavaIoFile.getAbsolutePath().equals(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.b()));
    LogUtil.b("PluginInstaller", "isNeedToInstall: is local plugin file need to install .", new Object[0]);
    return true;
  }
  
  private IPlugin b()
  {
    File localFile1 = new File(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.d());
    if (!localFile1.exists()) {
      localFile1.mkdirs();
    }
    File localFile2 = new File(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.i());
    if (localFile2.exists()) {
      FileUtil.a(localFile2);
    }
    localFile2 = a(this.jdField_a_of_type_JavaIoFile, localFile1);
    if (localFile2 == null)
    {
      LogUtil.c("PluginInstaller", "installPlugin: unpack installation file fail.", new Object[0]);
      return null;
    }
    localFile2 = a(localFile2);
    if (this.jdField_a_of_type_JavaIoFile == null)
    {
      LogUtil.c("PluginInstaller", "installPlugin: parse installation file fail.", new Object[0]);
      return null;
    }
    localFile1 = b(localFile2, localFile1);
    if (!localFile1.exists())
    {
      LogUtil.c("PluginInstaller", "installPlugin: the installation file install fail.", new Object[0]);
      return null;
    }
    if (a(localFile1, this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.g(), this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.a()) == null)
    {
      LogUtil.c("PluginInstaller", "installPlugin: the libs install fail.", new Object[0]);
      return null;
    }
    if (a(localFile1, this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.f()) == null)
    {
      LogUtil.c("PluginInstaller", "installPlugin: the  oDex install fail.", new Object[0]);
      return null;
    }
    if (this.jdField_a_of_type_JavaIoFile.getAbsolutePath().equals(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.b()))
    {
      LogUtil.c("PluginInstaller", "installPlugin: local install file not need to install copied file.", new Object[0]);
      return this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin;
    }
    if (b(localFile1, this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.i()) == null)
    {
      LogUtil.c("PluginInstaller", "installPlugin: the  copy file install fail.", new Object[0]);
      return null;
    }
    if (this.jdField_a_of_type_JavaIoFile.exists())
    {
      LogUtil.a("PluginInstaller", "installPlugin: delete to install file.", new Object[0]);
      this.jdField_a_of_type_JavaIoFile.delete();
    }
    return this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin;
  }
  
  private File b(File paramFile1, File paramFile2)
  {
    if (!paramFile1.exists())
    {
      LogUtil.c("PluginInstaller", "installFile: install file fail. the to install file is not exist.", new Object[0]);
      return null;
    }
    File localFile = new File(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.e());
    if (paramFile1.getAbsolutePath().equals(localFile.getAbsolutePath()))
    {
      LogUtil.a("PluginInstaller", "installFile: the installation file has been installed", new Object[0]);
      return localFile;
    }
    if (localFile.exists()) {
      localFile.delete();
    }
    if (localFile.getParent().equals(paramFile1.getParent()))
    {
      LogUtil.a("PluginInstaller", "installFile: The installation file is already in the installation directory", new Object[0]);
      paramFile1.renameTo(localFile);
      return localFile;
    }
    CopyBloc.a(paramFile1, paramFile2, this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.c());
    LogUtil.a("PluginInstaller", "installFile: the installation files have been copied to the installation directory", new Object[0]);
    return localFile;
  }
  
  private File b(File paramFile, String paramString)
  {
    if (!paramFile.exists())
    {
      LogUtil.c("PluginInstaller", "installCopyFile: install copied fail. the installFile[%s] in not exists.", new Object[] { paramFile.getAbsolutePath() });
      return null;
    }
    paramFile = new File(paramString);
    if ((paramFile.exists()) && (paramFile.isDirectory())) {
      FileUtil.a(paramFile);
    }
    if (!paramFile.mkdirs())
    {
      LogUtil.c("PluginInstaller", "installCopyFile: install copied dir[] mkdirs fail.", new Object[] { paramFile.getAbsolutePath() });
      return null;
    }
    paramFile = new File(paramString, this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.k());
    paramFile.createNewFile();
    LogUtil.b("PluginInstaller", "installCopyFile: install frame version copied file %s", new Object[] { paramFile.getName() });
    paramFile = new File(paramString, this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.l());
    paramFile.createNewFile();
    LogUtil.b("PluginInstaller", "installCopyFile: install version copied file %s", new Object[] { paramFile.getName() });
    return paramFile;
  }
  
  public PluginInstaller a(AbstractPlugin paramAbstractPlugin)
  {
    this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin = paramAbstractPlugin;
    return this;
  }
  
  public PluginInstaller a(File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    return this;
  }
  
  public IPlugin a()
  {
    if ((this.jdField_a_of_type_JavaIoFile == null) || (!this.jdField_a_of_type_JavaIoFile.exists()))
    {
      LogUtil.b("PluginInstaller", "install: the to install file had not exists.", new Object[0]);
      return null;
    }
    if (a())
    {
      LogUtil.b("PluginInstaller", "install: need to install.", new Object[0]);
      return b();
    }
    a(new File(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin.j()));
    return this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceAbstractPlugin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.install.PluginInstaller
 * JD-Core Version:    0.7.0.1
 */