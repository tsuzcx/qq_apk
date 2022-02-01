package com.tencent.ilivesdk.pluginloaderservice;

import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.report.DataReport;
import com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import org.json.JSONException;

final class PluginManger$2
  implements Callable<IPlugin>
{
  PluginManger$2(String paramString, Plugin paramPlugin) {}
  
  public IPlugin a()
  {
    Object localObject1 = String.format("install: start install plugin[%s]", new Object[] { this.a });
    LogUtil.b("PluginManger", (String)localObject1, new Object[0]);
    DataReport.g((String)localObject1);
    localObject1 = this.b.u();
    try
    {
      Object localObject2 = PluginManger.b((IPlugin)localObject1);
      if (localObject2 == null)
      {
        localObject1 = String.format("install; download plugin[%s] fail.", new Object[] { this.a });
        DataReport.h((String)localObject1);
        LogUtil.a("PluginManger", (String)localObject1, new Object[0]);
        return null;
      }
      DataReport.i(String.format("install; download plugin[%s] Success.", new Object[] { this.a }));
      try
      {
        localObject1 = PluginManger.a((IPlugin)localObject1, (File)localObject2);
        if (localObject1 == null)
        {
          localObject1 = String.format("install; install plugin[%s] fail.", new Object[] { this.a });
          DataReport.j((String)localObject1);
          LogUtil.c("PluginManger", (String)localObject1, new Object[0]);
          return null;
        }
        DataReport.l(String.format("install; install plugin[%s] success.", new Object[] { this.a }));
        ((IPlugin)localObject1).a(PluginManger.c((IPlugin)localObject1));
        if (((IPlugin)localObject1).l())
        {
          localObject2 = String.format("install; install plugin[%s] success.", new Object[] { this.a });
          DataReport.q((String)localObject2);
          LogUtil.b("PluginManger", (String)localObject2, new Object[0]);
          return localObject1;
        }
        localObject2 = String.format("install; install plugin[%s] fail.", new Object[] { this.a });
        DataReport.k((String)localObject2);
        LogUtil.b("PluginManger", (String)localObject2, new Object[0]);
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        String str1 = String.format("install; install plugin[%s] exception: %s", new Object[] { this.a, localJSONException.getMessage() });
        DataReport.j(str1);
        LogUtil.c("PluginManger", str1, new Object[0]);
        return null;
      }
      catch (IOException localIOException1)
      {
        String str2 = String.format("install; install plugin[%s] exception: %s", new Object[] { this.a, localIOException1.getMessage() });
        DataReport.j(str2);
        LogUtil.c("PluginManger", str2, new Object[0]);
        return null;
      }
      String str3;
      return null;
    }
    catch (IOException localIOException2)
    {
      str3 = String.format("install; download plugin[%s] exception: %s", new Object[] { this.a, localIOException2.getMessage() });
      DataReport.h(str3);
      LogUtil.c("PluginManger", str3, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.PluginManger.2
 * JD-Core Version:    0.7.0.1
 */