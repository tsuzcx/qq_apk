package com.sixgod.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;

final class f
  extends BroadcastReceiver
{
  f(e parame) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((!paramIntent.hasExtra("plugin_pkg_name")) || (!paramIntent.hasExtra("is_kill_process"))) {}
    String str;
    do
    {
      boolean bool;
      do
      {
        return;
        str = paramIntent.getStringExtra("plugin_pkg_name");
        bool = paramIntent.getBooleanExtra("is_kill_process", false);
      } while ((str == null) || (!str.equals(this.a.d.pkgName)));
      if (bool)
      {
        Process.killProcess(Process.myPid());
        return;
      }
      if (str.equals(this.a.d.pkgName))
      {
        SixGodHelper.clearPluginLoaderInfo(paramContext, str);
        return;
      }
    } while (!str.equals("com.sixgod.pluginsdk.unload_all_plugin"));
    SixGodHelper.clearAllPluginLoaderInfo(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.f
 * JD-Core Version:    0.7.0.1
 */