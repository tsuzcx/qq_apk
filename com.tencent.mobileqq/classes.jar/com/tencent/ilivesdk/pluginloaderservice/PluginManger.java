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
  private static ConcurrentHashMap<String, Object> a = new ConcurrentHashMap();
  private static HashMap<String, Future> b = new HashMap();
  private static HashMap<String, Future> c = new HashMap();
  
  public static void a(Plugin paramPlugin, PluginInstallListener paramPluginInstallListener)
  {
    if ((paramPlugin != null) && (!paramPlugin.l()))
    {
      String str = paramPlugin.e();
      if (TextUtils.isEmpty(str))
      {
        LogUtil.b("PluginManger", "install plugin name is null.", new Object[0]);
        return;
      }
      ThreadManagerExecutor.a().submit(new PluginManger.1(str, paramPlugin, paramPluginInstallListener));
      return;
    }
    LogUtil.b("PluginManger", "install plugin is null or plugin had installed.", new Object[0]);
    if (paramPluginInstallListener != null) {
      paramPluginInstallListener.a(paramPlugin);
    }
  }
  
  private static void a(String paramString, Future paramFuture)
  {
    synchronized (b)
    {
      b.put(paramString, paramFuture);
      return;
    }
  }
  
  private static IPlugin b(IPlugin paramIPlugin, File paramFile)
  {
    return new PluginInstaller().a((AbstractPlugin)paramIPlugin).a(paramFile).a();
  }
  
  private static Future<IPlugin> b(Plugin paramPlugin)
  {
    String str = paramPlugin.e();
    Object localObject2 = a.get(str);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new Object();
      a.put(str, localObject1);
    }
    if (c(str))
    {
      LogUtil.b("PluginManger", "install plugin in installing.", new Object[0]);
      return (Future)b.get(str);
    }
    try
    {
      if (c(str))
      {
        LogUtil.b("PluginManger", "install plugin in installing.", new Object[0]);
        paramPlugin = (Future)b.get(str);
        return paramPlugin;
      }
      localObject2 = ThreadManagerExecutor.a().submit(new PluginManger.2(str, paramPlugin));
      a(paramPlugin.e(), (Future)localObject2);
      return localObject2;
    }
    finally {}
  }
  
  private static void b(String paramString)
  {
    synchronized (b)
    {
      b.remove(paramString);
      return;
    }
  }
  
  private static boolean c(String paramString)
  {
    synchronized (b)
    {
      if ((Future)b.get(paramString) != null)
      {
        LogUtil.b("PluginManger", "isInstalling: the plugin is installing.", new Object[0]);
        return true;
      }
      return false;
    }
  }
  
  private static File d(IPlugin paramIPlugin)
  {
    return new PluginDownloader(null).a(paramIPlugin).a();
  }
  
  private static IPluginClassLoader e(IPlugin paramIPlugin)
  {
    return new PluginLoader(paramIPlugin).a();
  }
  
  private static void f(IPlugin paramIPlugin)
  {
    if (c.containsKey(paramIPlugin.e()))
    {
      LogUtil.b("PluginManger", "updaterPlugin: on updating plugin[%s]", new Object[] { paramIPlugin.e() });
      return;
    }
    synchronized (c)
    {
      if (c.containsKey(paramIPlugin.e()))
      {
        LogUtil.b("PluginManger", "updaterPlugin: on updating plugin[%s]", new Object[] { paramIPlugin.e() });
        return;
      }
      Future localFuture = ThreadManagerExecutor.a().submit(new PluginManger.3(paramIPlugin));
      c.put(paramIPlugin.e(), localFuture);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.PluginManger
 * JD-Core Version:    0.7.0.1
 */