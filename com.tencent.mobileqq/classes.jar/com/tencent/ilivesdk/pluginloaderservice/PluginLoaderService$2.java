package com.tencent.ilivesdk.pluginloaderservice;

import com.tencent.ilivesdk.pluginloaderservice.interfaces.ClassLoaderListener;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IGetInstallPlugins;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.report.DataReport;
import com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil;
import java.util.List;

class PluginLoaderService$2
  implements IGetInstallPlugins
{
  PluginLoaderService$2(PluginLoaderService paramPluginLoaderService, String paramString1, Class paramClass, String paramString2, ClassLoaderListener paramClassLoaderListener) {}
  
  public void a(List<IPlugin> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      DataReport.e(String.format("get plugin[%s] success", new Object[] { this.a }));
      PluginLoaderService.a(this.e).addAll(paramList);
      this.e.a(this.a, this.b, this.c, this.d);
      return;
    }
    paramList = String.format("load: the to install plugin[%s] is empty", new Object[] { this.a });
    DataReport.d(paramList);
    LogUtil.b("PluginLoaderService", paramList, new Object[0]);
    PluginLoaderService.a(this.e, null, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.PluginLoaderService.2
 * JD-Core Version:    0.7.0.1
 */