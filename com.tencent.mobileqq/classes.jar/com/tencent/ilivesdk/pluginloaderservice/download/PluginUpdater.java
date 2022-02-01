package com.tencent.ilivesdk.pluginloaderservice.download;

import android.text.TextUtils;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil;
import java.io.File;

public class PluginUpdater
{
  private IPlugin a;
  
  private boolean a()
  {
    if (TextUtils.isEmpty(this.a.a())) {
      LogUtil.b("PluginUpdater", "isNeedUpdate: the plugin download url is empty.", new Object[0]);
    }
    do
    {
      return false;
      if (TextUtils.isEmpty(this.a.e()))
      {
        LogUtil.b("PluginUpdater", "isNeedUpdate: the install path is empty.", new Object[0]);
        return false;
      }
      File localFile = new File(this.a.e());
      if ((!localFile.exists()) || (!localFile.isFile()))
      {
        LogUtil.b("PluginUpdater", "isNeedUpdate: the plugin had not been installed.", new Object[0]);
        return false;
      }
    } while ((!new File(this.a.e()).exists()) || (new File(this.a.i(), this.a.l()).exists()));
    LogUtil.b("PluginUpdater", "isNeedUpdate: the version copied had not been installed.", new Object[0]);
    return true;
  }
  
  public PluginUpdater a(IPlugin paramIPlugin)
  {
    this.a = paramIPlugin;
    return this;
  }
  
  public File a()
  {
    if (!a())
    {
      LogUtil.b("PluginUpdater", "update: no need to update the plugin.", new Object[0]);
      return null;
    }
    return Downloader.a(this.a.a(), this.a.d(), this.a.h());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.download.PluginUpdater
 * JD-Core Version:    0.7.0.1
 */