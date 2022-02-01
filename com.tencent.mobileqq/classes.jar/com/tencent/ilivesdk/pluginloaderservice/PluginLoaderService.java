package com.tencent.ilivesdk.pluginloaderservice;

import android.content.Context;
import com.tencent.ilivesdk.pluginloaderservice.download.Downloader;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.ClassLoaderListener;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPluginLoaderService;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPluginLoaderServiceAdapter;
import com.tencent.ilivesdk.pluginloaderservice.report.DataReport;
import com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;

public class PluginLoaderService
  implements IPluginLoaderService
{
  private Context a;
  private IPluginLoaderServiceAdapter b;
  private List<IPlugin> c = new ArrayList();
  
  private <T> void a(IPlugin paramIPlugin, Class<T> paramClass, String paramString, ClassLoaderListener paramClassLoaderListener)
  {
    if (paramIPlugin.l())
    {
      LogUtil.b("PluginLoaderService", "load: the plugin has been installed.", new Object[0]);
      b(paramIPlugin, paramClass, paramString, paramClassLoaderListener);
      return;
    }
    PluginManger.a((Plugin)paramIPlugin, new PluginLoaderService.3(this, paramClass, paramString, paramClassLoaderListener));
  }
  
  private <T> void b(IPlugin paramIPlugin, Class<T> paramClass, String paramString, ClassLoaderListener paramClassLoaderListener)
  {
    if (paramClassLoaderListener == null)
    {
      DataReport.p("notifyLoadClassCompile: the listener is null");
      LogUtil.b("PluginLoaderService", "notifyLoadClassCompile: the listener is null", new Object[0]);
      return;
    }
    if ((paramIPlugin != null) && (paramIPlugin.l())) {
      try
      {
        paramClass = paramIPlugin.a(paramClass, paramString);
        if (paramClass == null)
        {
          paramIPlugin = String.format("notifyLoadClassCompile: can not load class %s", new Object[] { paramString });
          DataReport.p(paramIPlugin);
          LogUtil.b("PluginLoaderService", paramIPlugin, new Object[0]);
          paramClassLoaderListener.a(null, null);
          return;
        }
        if (a())
        {
          paramIPlugin = String.format("notifyLoadClassCompile: opensdk service is destroy load class [%s] fail.", new Object[] { paramString });
          LogUtil.b("PluginLoaderService", paramIPlugin, new Object[0]);
          DataReport.p(paramIPlugin);
          paramClassLoaderListener.a(null, null);
          return;
        }
        paramString = String.format("notifyLoadClassCompile: load class [%s] success", new Object[] { paramString });
        LogUtil.b("PluginLoaderService", paramString, new Object[0]);
        paramClassLoaderListener.a(paramClass, paramIPlugin.a(this.a));
        DataReport.q(paramString);
        return;
      }
      catch (ClassNotFoundException paramIPlugin)
      {
        DataReport.p(String.format("notifyLoadClassCompile: ClassNotFoundException: %s", new Object[] { paramIPlugin.getCause() }));
        LogUtil.c("PluginLoaderService", paramIPlugin.getMessage(), new Object[0]);
        return;
      }
      catch (IllegalAccessException paramIPlugin)
      {
        paramIPlugin = String.format("notifyLoadClassCompile: IllegalAccessException: %s", new Object[] { paramIPlugin.getCause() });
        DataReport.p(paramIPlugin);
        LogUtil.c("PluginLoaderService", paramIPlugin, new Object[0]);
        return;
      }
      catch (InstantiationException paramIPlugin)
      {
        paramIPlugin = String.format("notifyLoadClassCompile: InstantiationException: %s", new Object[] { paramIPlugin.getCause() });
        DataReport.p(paramIPlugin);
        LogUtil.c("PluginLoaderService", paramIPlugin, new Object[0]);
        return;
      }
    }
    paramClassLoaderListener.a(null, null);
    DataReport.p("notifyLoadClassCompile: the plugin is null");
    LogUtil.b("PluginLoaderService", "notifyLoadClassCompile: the plugin is null", new Object[0]);
  }
  
  public void a(IPluginLoaderServiceAdapter paramIPluginLoaderServiceAdapter)
  {
    this.b = paramIPluginLoaderServiceAdapter;
    ThreadManagerExecutor.a(paramIPluginLoaderServiceAdapter.b());
    LogUtil.a("PluginLoaderService", paramIPluginLoaderServiceAdapter.d());
    DataReport.a(paramIPluginLoaderServiceAdapter.c());
    Downloader.a(paramIPluginLoaderServiceAdapter.a());
    paramIPluginLoaderServiceAdapter = new StringBuilder();
    paramIPluginLoaderServiceAdapter.append("init: need to install plugin size ");
    paramIPluginLoaderServiceAdapter.append(this.c.size());
    LogUtil.b("PluginLoaderService", paramIPluginLoaderServiceAdapter.toString(), new Object[0]);
  }
  
  public <T> void a(Class<T> paramClass, String paramString, ClassLoaderListener paramClassLoaderListener)
  {
    if (this.c.size() == 0)
    {
      this.b.a(new PluginLoaderService.1(this, paramClass, paramString, paramClassLoaderListener));
      return;
    }
    IPlugin localIPlugin = (IPlugin)this.c.get(0);
    if (localIPlugin == null)
    {
      LogUtil.b("PluginLoaderService", "load: the default  plugin is null", new Object[0]);
      DataReport.p("load: the default  plugin is null");
    }
    else
    {
      LogUtil.b("PluginLoaderService", "load: the default plugin[%s] load class %s", new Object[] { localIPlugin.e(), paramString });
    }
    a(localIPlugin, paramClass, paramString, paramClassLoaderListener);
  }
  
  public <T> void a(String paramString1, Class<T> paramClass, String paramString2, ClassLoaderListener paramClassLoaderListener)
  {
    if (this.c.size() == 0)
    {
      this.b.a(new PluginLoaderService.2(this, paramString1, paramClass, paramString2, paramClassLoaderListener));
      return;
    }
    IPlugin localIPlugin = null;
    int i = 0;
    while (i < this.c.size())
    {
      localIPlugin = (IPlugin)this.c.get(i);
      i += 1;
    }
    if (localIPlugin == null)
    {
      paramString1 = String.format("load: the plugin[%s] is null", new Object[] { paramString1 });
      DataReport.p(paramString1);
      LogUtil.b("PluginLoaderService", paramString1, new Object[0]);
    }
    else
    {
      LogUtil.b("PluginLoaderService", "load: the plugin[%s] load class %s", new Object[] { paramString1, paramString2 });
    }
    a(localIPlugin, paramClass, paramString2, paramClassLoaderListener);
  }
  
  public boolean a()
  {
    return this.a == null;
  }
  
  public void clearEventOutput() {}
  
  public void onCreate(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void onDestroy()
  {
    this.a = null;
    LogUtil.a();
    Downloader.a();
    DataReport.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.PluginLoaderService
 * JD-Core Version:    0.7.0.1
 */