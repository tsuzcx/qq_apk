package com.tencent.ilivesdk.pluginloaderservice.download;

import android.text.TextUtils;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil;
import java.io.File;

public class PluginUpdater
{
  private IPlugin a;
  
  private boolean b()
  {
    if (TextUtils.isEmpty(this.a.a()))
    {
      LogUtil.b("PluginUpdater", "isNeedUpdate: the plugin download url is empty.", new Object[0]);
      return false;
    }
    if (TextUtils.isEmpty(this.a.g()))
    {
      LogUtil.b("PluginUpdater", "isNeedUpdate: the install path is empty.", new Object[0]);
      return false;
    }
    File localFile = new File(this.a.g());
    if ((localFile.exists()) && (localFile.isFile()))
    {
      if ((new File(this.a.g()).exists()) && (!new File(this.a.m(), this.a.p()).exists()))
      {
        LogUtil.b("PluginUpdater", "isNeedUpdate: the version copied had not been installed.", new Object[0]);
        return true;
      }
      return false;
    }
    LogUtil.b("PluginUpdater", "isNeedUpdate: the plugin had not been installed.", new Object[0]);
    return false;
  }
  
  public PluginUpdater a(IPlugin paramIPlugin)
  {
    this.a = paramIPlugin;
    return this;
  }
  
  public File a()
  {
    if (!b())
    {
      LogUtil.b("PluginUpdater", "update: no need to update the plugin.", new Object[0]);
      return null;
    }
    return Downloader.a(this.a.a(), this.a.f(), this.a.k());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.download.PluginUpdater
 * JD-Core Version:    0.7.0.1
 */