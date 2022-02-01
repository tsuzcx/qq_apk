package com.tencent.hydevteam.pluginframework.pluginloader;

import android.content.Context;
import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;

@API
public abstract interface PluginLoader
{
  @API
  public abstract ProgressFuture<RunningPlugin> loadPlugin(Context paramContext, InstalledPlugin paramInstalledPlugin);
  
  @API
  public abstract boolean setPluginDisabled(InstalledPlugin paramInstalledPlugin);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginloader.PluginLoader
 * JD-Core Version:    0.7.0.1
 */