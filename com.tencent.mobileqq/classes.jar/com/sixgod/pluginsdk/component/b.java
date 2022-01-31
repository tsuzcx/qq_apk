package com.sixgod.pluginsdk.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import com.sixgod.pluginsdk.apkmanager.c;
import java.util.HashMap;

public final class b
  extends BroadcastReceiver
{
  private ActivityInfo b;
  
  public b(a parama, ActivityInfo paramActivityInfo)
  {
    this.b = paramActivityInfo;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = this.a.c;
    try
    {
      String str = this.b.packageName;
      if ((c)((com.sixgod.pluginsdk.apkmanager.a)localObject).e.get(str) == null) {
        return;
      }
      str = this.b.packageName;
      localObject = (c)((com.sixgod.pluginsdk.apkmanager.a)localObject).e.get(str);
      if (localObject != null) {
        break label96;
      }
      localObject = null;
    }
    catch (InstantiationException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        return;
        localObject = ((c)localObject).b;
      }
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    localObject = (BroadcastReceiver)((ClassLoader)localObject).loadClass(this.b.name).newInstance();
    if (localObject != null)
    {
      ((BroadcastReceiver)localObject).onReceive(paramContext, paramIntent);
      return;
    }
    label96:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.component.b
 * JD-Core Version:    0.7.0.1
 */