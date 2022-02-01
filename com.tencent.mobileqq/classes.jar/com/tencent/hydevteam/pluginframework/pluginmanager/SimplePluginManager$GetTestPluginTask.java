package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.common.progress.Progress;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import java.util.concurrent.Callable;

class SimplePluginManager$GetTestPluginTask
  implements Progress, Callable<InstalledPlugin>
{
  private boolean a = false;
  
  SimplePluginManager$GetTestPluginTask(SimplePluginManager paramSimplePluginManager, boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public double getProgress()
  {
    return 1.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.SimplePluginManager.GetTestPluginTask
 * JD-Core Version:    0.7.0.1
 */