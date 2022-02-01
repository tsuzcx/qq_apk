package com.tencent.ilivesdk.pluginloaderservice;

import com.tencent.ilivesdk.pluginloaderservice.interfaces.ClassLoaderListener;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IGetInstallPlugins;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.report.DataReport;
import com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil;
import java.util.List;

class PluginLoaderService$1
  implements IGetInstallPlugins
{
  PluginLoaderService$1(PluginLoaderService paramPluginLoaderService, Class paramClass, String paramString, ClassLoaderListener paramClassLoaderListener) {}
  
  public void a(List<IPlugin> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      DataReport.e(String.format("get plugin[%s] success", new Object[] { this.b }));
      PluginLoaderService.a(this.d).addAll(paramList);
      this.d.a(this.a, this.b, this.c);
      return;
    }
    PluginLoaderService.a(this.d, null, this.a, this.b, this.c);
    paramList = String.format("load: the to install plugin is empty. classname[%s]", new Object[] { this.b });
    DataReport.d(paramList);
    LogUtil.b("PluginLoaderService", paramList, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.PluginLoaderService.1
 * JD-Core Version:    0.7.0.1
 */