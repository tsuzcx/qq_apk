package com.tencent.mobileqq.auto.engine.enter;

import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import java.io.File;
import java.util.concurrent.Callable;

class ASPluginManager$1$1
  implements Callable<File>
{
  ASPluginManager$1$1(ASPluginManager.1 param1) {}
  
  public File a()
  {
    return new File(ASPluginManager.a(this.a.a).getPluginMangerApkPath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.enter.ASPluginManager.1.1
 * JD-Core Version:    0.7.0.1
 */