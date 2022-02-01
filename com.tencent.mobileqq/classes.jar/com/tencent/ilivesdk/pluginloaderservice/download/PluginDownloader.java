package com.tencent.ilivesdk.pluginloaderservice.download;

import android.text.TextUtils;
import com.tencent.falco.utils.MD5Utils;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IDownloader;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil;
import java.io.File;

public class PluginDownloader
{
  private final IDownloader jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIDownloader;
  private IPlugin jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin;
  
  public PluginDownloader(IDownloader paramIDownloader)
  {
    this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIDownloader = paramIDownloader;
  }
  
  private File b()
  {
    File localFile;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.b()))
    {
      localFile = new File(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.b());
      if ((localFile.exists()) && (localFile.isFile()))
      {
        LogUtil.b("PluginDownloader", "loadLocalFile: load local plugin file success.", new Object[0]);
        return localFile;
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.k()))
    {
      localFile = new File(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.i() + "/" + this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.k());
      if ((!localFile.exists()) || (!localFile.isFile()))
      {
        LogUtil.b("PluginDownloader", "loadLocalFile: check copied file fail.", new Object[0]);
        return null;
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.d()))
    {
      localFile = new File(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.d() + "/" + this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.h());
      if ((localFile.exists()) && (localFile.isFile()) && ((TextUtils.equals(MD5Utils.getFileMd5String(localFile.getAbsolutePath()), this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.m())) || (!this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.b())))
      {
        LogUtil.b("PluginDownloader", "loadLocalFile: load local updater plugin file success. file path %s", new Object[] { localFile.getAbsolutePath() });
        return localFile;
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.e()))
    {
      localFile = new File(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.e());
      if ((localFile.exists()) && (localFile.isFile()) && (!this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.b()))
      {
        LogUtil.b("PluginDownloader", "loadLocalFile: load local installed plugin file success. file path %s", new Object[] { localFile.getAbsolutePath() });
        return localFile;
      }
    }
    return null;
  }
  
  public PluginDownloader a(IPlugin paramIPlugin)
  {
    this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin = paramIPlugin;
    return this;
  }
  
  public File a()
  {
    File localFile = b();
    if (localFile != null) {
      return localFile;
    }
    return Downloader.a(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.a(), this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.d(), this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.h());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.download.PluginDownloader
 * JD-Core Version:    0.7.0.1
 */