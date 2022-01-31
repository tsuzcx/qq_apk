package com.sixgod.pluginsdk.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.sixgod.pluginsdk.PluginLoadParams;
import com.sixgod.pluginsdk.SixGodHelper;

final class e
  extends BroadcastReceiver
{
  e(ContainerActivity paramContainerActivity) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((!paramIntent.hasExtra("plugin_pkg_name")) || (!paramIntent.hasExtra("is_kill_process"))) {}
    String str;
    do
    {
      return;
      str = paramIntent.getStringExtra("plugin_pkg_name");
      boolean bool = paramIntent.getBooleanExtra("is_kill_process", false);
      if ((str != null) && ((str.equals(this.a.d.pkgName)) || (str.equals("com.sixgod.pluginsdk.unload_all_plugin")))) {
        this.a.finish();
      }
      if (bool)
      {
        if (!TextUtils.isEmpty(str)) {
          SixGodHelper.clearPluginLoaderInfo(paramContext, str);
        }
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
 * Qualified Name:     com.sixgod.pluginsdk.component.e
 * JD-Core Version:    0.7.0.1
 */