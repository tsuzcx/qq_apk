package com.tencent.hydevteam.pluginframework.pluginmanager;

import android.content.Context;
import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import java.util.List;

@API
public abstract interface PluginManager
{
  @API
  public static final String DEFAULT_STORE_DIR_NAME = "PluginManager";
  
  @API
  public abstract List<InstalledPlugin> getCachedLatestPlugin(String paramString);
  
  @API
  public abstract VersionChecker getVersionChecker();
  
  @API
  public abstract ProgressFuture preloadApk(Context paramContext, InstalledPlugin paramInstalledPlugin, boolean paramBoolean);
  
  @API
  public abstract List<ProgressFuture<InstalledPlugin>> updatePlugin(String paramString1, TargetDownloadInfo paramTargetDownloadInfo, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.PluginManager
 * JD-Core Version:    0.7.0.1
 */