package com.sixgod.pluginsdk;

import android.content.Context;
import android.content.Intent;

public final class b
{
  protected PluginLoadParams a;
  Context b;
  String c;
  
  public b(Context paramContext, PluginLoadParams paramPluginLoadParams, String paramString)
  {
    this.a = paramPluginLoadParams;
    this.b = paramContext;
    this.c = paramString;
  }
  
  private void a(int paramInt, Object[] paramArrayOfObject)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.sixgod.pluginsdk.callback.ACTION");
    switch (paramInt)
    {
    }
    for (;;)
    {
      localIntent.putExtra("callback", paramInt);
      localIntent.setPackage(this.b.getPackageName());
      localIntent.putExtra("processName", this.c);
      localIntent.putExtra("packageName", this.a.pkgName);
      localIntent.putExtra("plugin_id", this.a.pluginName);
      this.b.sendBroadcast(localIntent);
      return;
      int i = ((Integer)paramArrayOfObject[0]).intValue();
      paramArrayOfObject = (String)paramArrayOfObject[1];
      localIntent.putExtra("errorcode", i);
      localIntent.putExtra("errormsg", paramArrayOfObject);
      continue;
      localIntent.putExtra("className", (String)paramArrayOfObject[0]);
      continue;
      String str = (String)paramArrayOfObject[0];
      i = ((Integer)paramArrayOfObject[1]).intValue();
      paramArrayOfObject = (String)paramArrayOfObject[2];
      localIntent.putExtra("errorcode", i);
      localIntent.putExtra("className", str);
      localIntent.putExtra("errormsg", paramArrayOfObject);
      continue;
      i = ((Integer)paramArrayOfObject[0]).intValue();
      paramArrayOfObject = (String)paramArrayOfObject[1];
      localIntent.putExtra("errorcode", i);
      localIntent.putExtra("errormsg", paramArrayOfObject);
    }
  }
  
  public final void a()
  {
    if (this.a.pluginLoadCallBack != null)
    {
      this.a.pluginLoadCallBack.loadPluginSucc(this.a.pkgName, this.a.pluginName, this.c);
      return;
    }
    a(1001, null);
  }
  
  public final void a(int paramInt, String paramString)
  {
    if (this.a.pluginLoadCallBack != null)
    {
      this.a.pluginLoadCallBack.loadPluginFailed(this.a.pkgName, this.a.pluginName, paramInt, paramString);
      return;
    }
    a(1002, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public final void a(String paramString)
  {
    if (this.a.pluginLoadCallBack != null)
    {
      this.a.pluginLoadCallBack.startMainActivitySucc(this.a.pkgName, this.a.pluginName, paramString);
      return;
    }
    a(1003, new Object[] { paramString });
  }
  
  public final void a(String paramString1, int paramInt, String paramString2)
  {
    if (this.a.pluginLoadCallBack != null)
    {
      this.a.pluginLoadCallBack.startMainActivityFailed(this.a.pkgName, this.a.pluginName, paramString1, paramInt, paramString2);
      return;
    }
    a(1005, new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
  }
  
  public final void b()
  {
    if (this.a.pluginLoadCallBack != null)
    {
      this.a.pluginLoadCallBack.callAppCreateSucc(this.a.pkgName, this.a.pluginName);
      return;
    }
    a(1007, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.b
 * JD-Core Version:    0.7.0.1
 */