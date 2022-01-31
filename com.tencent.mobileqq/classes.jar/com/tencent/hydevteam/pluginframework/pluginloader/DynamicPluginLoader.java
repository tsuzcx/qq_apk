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
    if (paramObject == null) {
      throw new AssertionError();
    }
  }
  
  @API
  private void initPluginLoaderIfNeeded(InstalledPlugin paramInstalledPlugin)
  {
    if (a == null)
    {
      paramInstalledPlugin = (UseDynamicPluginLoaderInstalledPlugin)paramInstalledPlugin;
      paramInstalledPlugin = new DynamicPluginLoaderLoader(paramInstalledPlugin.dynamicPluginLoaderVersion, paramInstalledPlugin.dynamicPluginLoaderFile, paramInstalledPlugin.dynamicPluginLoaderClassname, paramInstalledPlugin.dynamicPluginLoaderInterfacePackageNames);
    }
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
  
  @API
  public ProgressFuture<RunningPlugin> loadPlugin(Context paramContext, InstalledPlugin paramInstalledPlugin)
  {
    if ((paramInstalledPlugin instanceof UseDynamicPluginLoaderInstalledPlugin)) {
      try
      {
        UseDynamicPluginLoaderInstalledPlugin localUseDynamicPluginLoaderInstalledPlugin = (UseDynamicPluginLoaderInstalledPlugin)paramInstalledPlugin;
        a(localUseDynamicPluginLoaderInstalledPlugin.dynamicPluginLoaderVersion);
        a(localUseDynamicPluginLoaderInstalledPlugin.dynamicPluginLoaderFile);
        a(localUseDynamicPluginLoaderInstalledPlugin.pluginPackageName);
        a(localUseDynamicPluginLoaderInstalledPlugin.pluginVersionForConfigPluginLoader);
        a(localUseDynamicPluginLoaderInstalledPlugin.pluginVersionForPluginLoaderManage);
        a(localUseDynamicPluginLoaderInstalledPlugin.pluginFile);
        initPluginLoaderIfNeeded(paramInstalledPlugin);
        if (a != null) {
          break label119;
        }
        throw new LoadPluginException("sActualPluginLoader 为 null");
      }
      catch (AssertionError paramContext)
      {
        throw new LoadPluginException("检查启动插件参数时发生错误", paramContext);
      }
    } else {
      throw new LoadPluginException(paramInstalledPlugin + "不是一个" + UseDynamicPluginLoaderInstalledPlugin.class);
    }
    label119:
    return a.loadPlugin(paramContext, paramInstalledPlugin);
  }
  
  @API
  public boolean setPluginDisabled(InstalledPlugin paramInstalledPlugin)
  {
    if (a == null) {
      return false;
    }
    return a.setPluginDisabled(paramInstalledPlugin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginloader.DynamicPluginLoader
 * JD-Core Version:    0.7.0.1
 */