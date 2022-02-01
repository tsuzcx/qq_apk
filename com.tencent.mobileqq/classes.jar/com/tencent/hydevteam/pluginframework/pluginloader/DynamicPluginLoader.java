package com.tencent.hydevteam.pluginframework.pluginloader;

import android.content.Context;
import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.installedplugin.UseDynamicPluginLoaderInstalledPlugin;
import com.tencent.hydevteam.pluginframework.plugincontainer.DelegateProvider;
import com.tencent.hydevteam.pluginframework.plugincontainer.DelegateProviderHolder;
import com.tencent.hydevteam.pluginframework.pluginloader.exceptions.DynamicPluginLoaderLoadException;

@API
public class DynamicPluginLoader
  implements PluginLoader
{
  private static PluginLoader a;
  
  private static void a(Object paramObject)
  {
    if (paramObject != null) {
      return;
    }
    throw new AssertionError();
  }
  
  @API
  private void initPluginLoaderIfNeeded(InstalledPlugin paramInstalledPlugin)
  {
    if (a == null)
    {
      paramInstalledPlugin = (UseDynamicPluginLoaderInstalledPlugin)paramInstalledPlugin;
      paramInstalledPlugin = new DynamicPluginLoaderLoader(paramInstalledPlugin.dynamicPluginLoaderVersion, paramInstalledPlugin.dynamicPluginLoaderFile, paramInstalledPlugin.dynamicPluginLoaderClassname, paramInstalledPlugin.dynamicPluginLoaderInterfacePackageNames);
      try
      {
        a = paramInstalledPlugin.a();
        DelegateProviderHolder.setDelegateProvider((DelegateProvider)a);
        return;
      }
      catch (DynamicPluginLoaderLoadException paramInstalledPlugin)
      {
        throw new LoadPluginException(paramInstalledPlugin);
      }
    }
  }
  
  @API
  public ProgressFuture<RunningPlugin> loadPlugin(Context paramContext, InstalledPlugin paramInstalledPlugin)
  {
    if ((paramInstalledPlugin instanceof UseDynamicPluginLoaderInstalledPlugin)) {
      try
      {
        Object localObject = (UseDynamicPluginLoaderInstalledPlugin)paramInstalledPlugin;
        a(((UseDynamicPluginLoaderInstalledPlugin)localObject).dynamicPluginLoaderVersion);
        a(((UseDynamicPluginLoaderInstalledPlugin)localObject).dynamicPluginLoaderFile);
        a(((UseDynamicPluginLoaderInstalledPlugin)localObject).pluginPackageName);
        a(((UseDynamicPluginLoaderInstalledPlugin)localObject).pluginVersionForConfigPluginLoader);
        a(((UseDynamicPluginLoaderInstalledPlugin)localObject).pluginVersionForPluginLoaderManage);
        a(((UseDynamicPluginLoaderInstalledPlugin)localObject).pluginFile);
        initPluginLoaderIfNeeded(paramInstalledPlugin);
        localObject = a;
        if (localObject != null) {
          return ((PluginLoader)localObject).loadPlugin(paramContext, paramInstalledPlugin);
        }
        throw new LoadPluginException("sActualPluginLoader 为 null");
      }
      catch (AssertionError paramContext)
      {
        throw new LoadPluginException("检查启动插件参数时发生错误", paramContext);
      }
    }
    paramContext = new StringBuilder();
    paramContext.append(paramInstalledPlugin);
    paramContext.append("不是一个");
    paramContext.append(UseDynamicPluginLoaderInstalledPlugin.class);
    throw new LoadPluginException(paramContext.toString());
  }
  
  @API
  public boolean setPluginDisabled(InstalledPlugin paramInstalledPlugin)
  {
    PluginLoader localPluginLoader = a;
    if (localPluginLoader == null) {
      return false;
    }
    return localPluginLoader.setPluginDisabled(paramInstalledPlugin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginloader.DynamicPluginLoader
 * JD-Core Version:    0.7.0.1
 */