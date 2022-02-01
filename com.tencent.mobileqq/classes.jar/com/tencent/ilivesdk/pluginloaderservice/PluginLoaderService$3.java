package com.tencent.ilivesdk.pluginloaderservice;

import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.ClassLoaderListener;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.PluginInstallListener;

class PluginLoaderService$3
  implements PluginInstallListener
{
  PluginLoaderService$3(PluginLoaderService paramPluginLoaderService, Class paramClass, String paramString, ClassLoaderListener paramClassLoaderListener) {}
  
  public void a(IPlugin paramIPlugin)
  {
    ThreadCenter.postDefaultUITask(new PluginLoaderService.3.1(this, paramIPlugin));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.PluginLoaderService.3
 * JD-Core Version:    0.7.0.1
 */