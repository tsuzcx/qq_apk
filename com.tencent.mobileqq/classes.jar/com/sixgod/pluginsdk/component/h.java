package com.sixgod.pluginsdk.component;

import com.sixgod.pluginsdk.PluginLoadParams;
import com.sixgod.pluginsdk.SixGodHelper;
import com.sixgod.pluginsdk.b;
import com.sixgod.pluginsdk.e;
import com.sixgod.pluginsdk.log.SGLog;
import java.io.File;

final class h
  extends Thread
{
  h(SixGodPreLoadActivity paramSixGodPreLoadActivity) {}
  
  public final void run()
  {
    if (SixGodHelper.getPluginLoader(this.a.a.pkgName) == null)
    {
      SGLog.a("SixGodPreLoadActivity loadPlugin run ");
      this.a.a.pluginLoadCallBack = null;
      SixGodHelper.loadPlugin(this.a.getApplicationContext(), this.a.a);
    }
    for (;;)
    {
      this.a.finish();
      return;
      this.a.a.pluginLoadCallBack = null;
      if (!new File(this.a.a.apkPath).exists())
      {
        SGLog.b("异常场景，预加载的时候发现插件已经加载过，但是之前的apk文件已经不存在了");
        SixGodHelper.unLoadPlugin(this.a.getApplicationContext(), this.a.a.pkgName);
        this.a.finish();
        return;
      }
      SixGodHelper.getPluginLoader(this.a.a.pkgName).p.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.component.h
 * JD-Core Version:    0.7.0.1
 */