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
  private Context jdField_a_of_type_AndroidContentContext;
  private IPluginLoaderServiceAdapter jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPluginLoaderServiceAdapter;
  private List<IPlugin> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private <T> void a(IPlugin paramIPlugin, Class<T> paramClass, String paramString, ClassLoaderListener paramClassLoaderListener)
  {
    if (paramIPlugin.a())
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
    if ((paramIPlugin == null) || (!paramIPlugin.a()))
    {
      paramClassLoaderListener.a(null, null);
      DataReport.p("notifyLoadClassCompile: the plugin is null");
      LogUtil.b("PluginLoaderService", "notifyLoadClassCompile: the plugin is null", new Object[0]);
      return;
    }
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
    }
    catch (InstantiationException paramIPlugin)
    {
      paramIPlugin = String.format("notifyLoadClassCompile: InstantiationException: %s", new Object[] { paramIPlugin.getCause() });
      DataReport.p(paramIPlugin);
      LogUtil.c("PluginLoaderService", paramIPlugin, new Object[0]);
      return;
      if (a())
      {
        paramIPlugin = String.format("notifyLoadClassCompile: opensdk service is destroy load class [%s] fail.", new Object[] { paramString });
        LogUtil.b("PluginLoaderService", paramIPlugin, new Object[0]);
        DataReport.p(paramIPlugin);
        paramClassLoaderListener.a(null, null);
        return;
      }
    }
    catch (IllegalAccessException paramIPlugin)
    {
      paramIPlugin = String.format("notifyLoadClassCompile: IllegalAccessException: %s", new Object[] { paramIPlugin.getCause() });
      DataReport.p(paramIPlugin);
      LogUtil.c("PluginLoaderService", paramIPlugin, new Object[0]);
      return;
      paramString = String.format("notifyLoadClassCompile: load class [%s] success", new Object[] { paramString });
      LogUtil.b("PluginLoaderService", paramString, new Object[0]);
      paramClassLoaderListener.a(paramClass, paramIPlugin.a(this.jdField_a_of_type_AndroidContentContext));
      DataReport.q(paramString);
      return;
    }
    catch (ClassNotFoundException paramIPlugin)
    {
      DataReport.p(String.format("notifyLoadClassCompile: ClassNotFoundException: %s", new Object[] { paramIPlugin.getCause() }));
      LogUtil.c("PluginLoaderService", paramIPlugin.getMessage(), new Object[0]);
    }
  }
  
  public void a(IPluginLoaderServiceAdapter paramIPluginLoaderServiceAdapter)
  {
    this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPluginLoaderServiceAdapter = paramIPluginLoaderServiceAdapter;
    ThreadManagerExecutor.a(paramIPluginLoaderServiceAdapter.a());
    LogUtil.a("PluginLoaderService", paramIPluginLoaderServiceAdapter.a());
    DataReport.a(paramIPluginLoaderServiceAdapter.a());
    Downloader.a(paramIPluginLoaderServiceAdapter.a());
    LogUtil.b("PluginLoaderService", "init: need to install plugin size " + this.jdField_a_of_type_JavaUtilList.size(), new Object[0]);
  }
  
  public <T> void a(Class<T> paramClass, String paramString, ClassLoaderListener paramClassLoaderListener)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPluginLoaderServiceAdapter.a(new PluginLoaderService.1(this, paramClass, paramString, paramClassLoaderListener));
      return;
    }
    IPlugin localIPlugin = (IPlugin)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localIPlugin == null)
    {
      LogUtil.b("PluginLoaderService", "load: the default  plugin is null", new Object[0]);
      DataReport.p("load: the default  plugin is null");
    }
    for (;;)
    {
      a(localIPlugin, paramClass, paramString, paramClassLoaderListener);
      return;
      LogUtil.b("PluginLoaderService", "load: the default plugin[%s] load class %s", new Object[] { localIPlugin.c(), paramString });
    }
  }
  
  public <T> void a(String paramString1, Class<T> paramClass, String paramString2, ClassLoaderListener paramClassLoaderListener)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPluginLoaderServiceAdapter.a(new PluginLoaderService.2(this, paramString1, paramClass, paramString2, paramClassLoaderListener));
      return;
    }
    IPlugin localIPlugin = null;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localIPlugin = (IPlugin)this.jdField_a_of_type_JavaUtilList.get(i);
      i += 1;
    }
    if (localIPlugin == null)
    {
      paramString1 = String.format("load: the plugin[%s] is null", new Object[] { paramString1 });
      DataReport.p(paramString1);
      LogUtil.b("PluginLoaderService", paramString1, new Object[0]);
    }
    for (;;)
    {
      a(localIPlugin, paramClass, paramString2, paramClassLoaderListener);
      return;
      LogUtil.b("PluginLoaderService", "load: the plugin[%s] load class %s", new Object[] { paramString1, paramString2 });
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidContentContext == null;
  }
  
  public void clearEventOutput() {}
  
  public void onCreate(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    LogUtil.a();
    Downloader.a();
    DataReport.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.PluginLoaderService
 * JD-Core Version:    0.7.0.1
 */