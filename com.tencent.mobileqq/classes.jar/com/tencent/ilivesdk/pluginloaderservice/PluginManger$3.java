package com.tencent.ilivesdk.pluginloaderservice;

import com.tencent.ilivesdk.pluginloaderservice.download.PluginUpdater;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.report.DataReport;
import com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

final class PluginManger$3
  implements Runnable
{
  PluginManger$3(IPlugin paramIPlugin) {}
  
  public void run()
  {
    try
    {
      if (new PluginUpdater().a(this.a).a().exists())
      {
        DataReport.o(String.format("updater %s success.", new Object[] { this.a.c() }));
        return;
      }
      DataReport.n(String.format("updater %s fail.", new Object[] { this.a.c() }));
      return;
    }
    catch (IOException localIOException)
    {
      String str = String.format("updaterPlugin[%s] IOException: %s", new Object[] { this.a.c(), localIOException.getMessage() });
      DataReport.n(str);
      LogUtil.c("PluginManger", str, new Object[0]);
      PluginManger.a().remove(this.a.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.PluginManger.3
 * JD-Core Version:    0.7.0.1
 */