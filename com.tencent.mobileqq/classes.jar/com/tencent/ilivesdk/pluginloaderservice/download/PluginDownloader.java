package com.tencent.ilivesdk.pluginloaderservice.download;

import android.text.TextUtils;
import com.tencent.falco.utils.MD5Utils;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IDownloader;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil;
import java.io.File;

public class PluginDownloader
{
  private IPlugin a;
  private final IDownloader b;
  
  public PluginDownloader(IDownloader paramIDownloader)
  {
    this.b = paramIDownloader;
  }
  
  private File b()
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.a.b()))
    {
      localObject = new File(this.a.b());
      if ((((File)localObject).exists()) && (((File)localObject).isFile()))
      {
        LogUtil.b("PluginDownloader", "loadLocalFile: load local plugin file success.", new Object[0]);
        return localObject;
      }
    }
    if (!TextUtils.isEmpty(this.a.o()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.m());
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.a.o());
      localObject = new File(((StringBuilder)localObject).toString());
      if ((!((File)localObject).exists()) || (!((File)localObject).isFile()))
      {
        LogUtil.b("PluginDownloader", "loadLocalFile: check copied file fail.", new Object[0]);
        return null;
      }
    }
    if (!TextUtils.isEmpty(this.a.f()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.f());
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.a.k());
      localObject = new File(((StringBuilder)localObject).toString());
      if ((((File)localObject).exists()) && (((File)localObject).isFile()) && ((TextUtils.equals(MD5Utils.getFileMd5String(((File)localObject).getAbsolutePath()), this.a.s())) || (!this.a.t())))
      {
        LogUtil.b("PluginDownloader", "loadLocalFile: load local updater plugin file success. file path %s", new Object[] { ((File)localObject).getAbsolutePath() });
        return localObject;
      }
    }
    if (!TextUtils.isEmpty(this.a.g()))
    {
      localObject = new File(this.a.g());
      if ((((File)localObject).exists()) && (((File)localObject).isFile()) && (!this.a.t()))
      {
        LogUtil.b("PluginDownloader", "loadLocalFile: load local installed plugin file success. file path %s", new Object[] { ((File)localObject).getAbsolutePath() });
        return localObject;
      }
    }
    return null;
  }
  
  public PluginDownloader a(IPlugin paramIPlugin)
  {
    this.a = paramIPlugin;
    return this;
  }
  
  public File a()
  {
    File localFile = b();
    if (localFile != null) {
      return localFile;
    }
    return Downloader.a(this.a.a(), this.a.f(), this.a.k());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.download.PluginDownloader
 * JD-Core Version:    0.7.0.1
 */