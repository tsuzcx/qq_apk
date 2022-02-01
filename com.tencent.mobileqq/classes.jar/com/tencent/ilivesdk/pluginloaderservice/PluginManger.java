package com.tencent.ilivesdk.pluginloaderservice;

import android.text.TextUtils;
import com.tencent.ilivesdk.pluginloaderservice.download.PluginDownloader;
import com.tencent.ilivesdk.pluginloaderservice.install.PluginInstaller;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPluginClassLoader;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPluginLoader;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.PluginInstallListener;
import com.tencent.ilivesdk.pluginloaderservice.loader.PluginLoader;
import com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class PluginManger
{
  private static HashMap<String, Future> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static ConcurrentHashMap<String, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static HashMap<String, Future> b = new HashMap();
  
  public static void a(Plugin paramPlugin, PluginInstallListener paramPluginInstallListener)
  {
    if ((paramPlugin == null) || (paramPlugin.a()))
    {
      LogUtil.b("PluginManger", "install plugin is null or plugin had installed.", new Object[0]);
      if (paramPluginInstallListener != null) {
        paramPluginInstallListener.a(paramPlugin);
      }
      return;
    }
    String str = paramPlugin.c();
    if (TextUtils.isEmpty(str))
    {
      LogUtil.b("PluginManger", "install plugin name is null.", new Object[0]);
      return;
    }
    ThreadManagerExecutor.a().submit(new PluginManger.1(str, paramPlugin, paramPluginInstallListener));
  }
  
  private static void a(String paramString, Future paramFuture)
  {
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, paramFuture);
      return;
    }
  }
  
  private static boolean a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      if ((Future)jdField_a_of_type_JavaUtilHashMap.get(paramString) != null)
      {
        LogUtil.b("PluginManger", "isInstalling: the plugin is installing.", new Object[0]);
        return true;
      }
      return false;
    }
  }
  
  private static IPlugin b(IPlugin paramIPlugin, File paramFile)
  {
    return new PluginInstaller().a((AbstractPlugin)paramIPlugin).a(paramFile).a();
  }
  
  private static IPluginClassLoader b(IPlugin paramIPlugin)
  {
    return new PluginLoader(paramIPlugin).a();
  }
  
  private static File b(IPlugin paramIPlugin)
  {
    return new PluginDownloader(null).a(paramIPlugin).a();
  }
  
  private static Future<IPlugin> b(Plugin paramPlugin)
  {
    Object localObject2 = paramPlugin.c();
    Object localObject1 = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2);
    if (localObject1 == null)
    {
      localObject1 = new Object();
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, localObject1);
    }
    for (;;)
    {
      if (a((String)localObject2))
      {
        LogUtil.b("PluginManger", "install plugin in installing.", new Object[0]);
        return (Future)jdField_a_of_type_JavaUtilHashMap.get(localObject2);
      }
      try
      {
        if (a((String)localObject2))
        {
          LogUtil.b("PluginManger", "install plugin in installing.", new Object[0]);
          paramPlugin = (Future)jdField_a_of_type_JavaUtilHashMap.get(localObject2);
          return paramPlugin;
        }
      }
      finally {}
      localObject2 = ThreadManagerExecutor.a().submit(new PluginManger.2((String)localObject2, paramPlugin));
      a(paramPlugin.c(), (Future)localObject2);
      return localObject2;
    }
  }
  
  private static void b(IPlugin paramIPlugin)
  {
    if (b.containsKey(paramIPlugin.c()))
    {
      LogUtil.b("PluginManger", "updaterPlugin: on updating plugin[%s]", new Object[] { paramIPlugin.c() });
      return;
    }
    synchronized (b)
    {
      if (b.containsKey(paramIPlugin.c()))
      {
        LogUtil.b("PluginManger", "updaterPlugin: on updating plugin[%s]", new Object[] { paramIPlugin.c() });
        return;
      }
    }
    Future localFuture = ThreadManagerExecutor.a().submit(new PluginManger.3(paramIPlugin));
    b.put(paramIPlugin.c(), localFuture);
  }
  
  private static void b(String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.PluginManger
 * JD-Core Version:    0.7.0.1
 */