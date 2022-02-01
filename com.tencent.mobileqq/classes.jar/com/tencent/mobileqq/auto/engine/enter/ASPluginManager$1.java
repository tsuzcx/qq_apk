package com.tencent.mobileqq.auto.engine.enter;

import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class ASPluginManager$1
  implements PluginManagerUpdater
{
  ASPluginManager$1(ASPluginManager paramASPluginManager) {}
  
  public File getLatest()
  {
    return new File(ASPluginManager.a(this.a).getPluginMangerApkPath());
  }
  
  public Future<Boolean> isAvailable(File paramFile)
  {
    return null;
  }
  
  public Future<File> update()
  {
    return ASPluginManager.b(this.a).submit(new ASPluginManager.1.1(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.enter.ASPluginManager.1
 * JD-Core Version:    0.7.0.1
 */