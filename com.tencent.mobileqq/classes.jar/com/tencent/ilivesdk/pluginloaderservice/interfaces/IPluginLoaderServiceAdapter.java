package com.tencent.ilivesdk.pluginloaderservice.interfaces;

import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import java.util.concurrent.ExecutorService;

public abstract interface IPluginLoaderServiceAdapter
{
  public abstract DownLoaderInterface a();
  
  public abstract void a(IGetInstallPlugins paramIGetInstallPlugins);
  
  public abstract ExecutorService b();
  
  public abstract DataReportInterface c();
  
  public abstract LogInterface d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.interfaces.IPluginLoaderServiceAdapter
 * JD-Core Version:    0.7.0.1
 */