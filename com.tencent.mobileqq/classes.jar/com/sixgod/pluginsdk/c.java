package com.sixgod.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sixgod.pluginsdk.log.SGLog;
import java.util.Iterator;
import java.util.List;

final class c
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    SGLog.a("onReceive callbacks:");
    paramContext = SixGodHelper.c.iterator();
    while (paramContext.hasNext())
    {
      d locald = (d)paramContext.next();
      String str1 = paramIntent.getStringExtra("packageName");
      String str2 = paramIntent.getStringExtra("plugin_id");
      String str3 = paramIntent.getStringExtra("processName");
      int i = paramIntent.getIntExtra("callback", 0);
      SGLog.a("pkg = " + str1 + " pluginName = " + str2 + " processName = " + str3 + " method = " + i);
      if ((str2 != null) && (str2.equals(locald.b))) {
        switch (i)
        {
        case 1004: 
        default: 
          break;
        case 1001: 
          locald.a.loadPluginSucc(str1, str2, str3);
          break;
        case 1002: 
          i = paramIntent.getIntExtra("errorcode", -1);
          str3 = paramIntent.getStringExtra("errormsg");
          locald.a.loadPluginFailed(str1, str2, i, str3);
          break;
        case 1005: 
          str3 = paramIntent.getStringExtra("className");
          i = paramIntent.getIntExtra("errorcode", -1);
          String str4 = paramIntent.getStringExtra("errormsg");
          locald.a.startMainActivityFailed(str1, str2, str3, i, str4);
          break;
        case 1003: 
          str3 = paramIntent.getStringExtra("className");
          locald.a.startMainActivitySucc(str1, str2, str3);
          break;
        case 1006: 
          i = paramIntent.getIntExtra("errorcode", -1);
          str3 = paramIntent.getStringExtra("errormsg");
          locald.a.callAppCreateFailed(str1, str2, i, str3);
          break;
        case 1007: 
          locald.a.callAppCreateSucc(str1, str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.c
 * JD-Core Version:    0.7.0.1
 */