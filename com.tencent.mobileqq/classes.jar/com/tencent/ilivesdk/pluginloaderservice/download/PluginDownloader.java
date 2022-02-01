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
    Object localObject;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.b()))
    {
      localObject = new File(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.b());
      if ((((File)localObject).exists()) && (((File)localObject).isFile()))
      {
        LogUtil.b("PluginDownloader", "loadLocalFile: load local plugin file success.", new Object[0]);
        return localObject;
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.k()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.i());
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.k());
      localObject = new File(((StringBuilder)localObject).toString());
      if ((!((File)localObject).exists()) || (!((File)localObject).isFile()))
      {
        LogUtil.b("PluginDownloader", "loadLocalFile: check copied file fail.", new Object[0]);
        return null;
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.d()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.d());
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.h());
      localObject = new File(((StringBuilder)localObject).toString());
      if ((((File)localObject).exists()) && (((File)localObject).isFile()) && ((TextUtils.equals(MD5Utils.getFileMd5String(((File)localObject).getAbsolutePath()), this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.m())) || (!this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.b())))
      {
        LogUtil.b("PluginDownloader", "loadLocalFile: load local updater plugin file success. file path %s", new Object[] { ((File)localObject).getAbsolutePath() });
        return localObject;
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.e()))
    {
      localObject = new File(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.e());
      if ((((File)localObject).exists()) && (((File)localObject).isFile()) && (!this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.b()))
      {
        LogUtil.b("PluginDownloader", "loadLocalFile: load local installed plugin file success. file path %s", new Object[] { ((File)localObject).getAbsolutePath() });
        return localObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.download.PluginDownloader
 * JD-Core Version:    0.7.0.1
 */