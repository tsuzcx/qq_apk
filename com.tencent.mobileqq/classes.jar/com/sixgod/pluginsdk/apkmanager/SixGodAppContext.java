package com.sixgod.pluginsdk.apkmanager;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.sixgod.pluginsdk.SixGodHelper;
import com.sixgod.pluginsdk.b.b;
import com.sixgod.pluginsdk.component.f;
import com.sixgod.pluginsdk.e;
import com.sixgod.pluginsdk.log.SGLog;
import java.io.File;
import java.util.HashMap;

public class SixGodAppContext
  extends Application
  implements IContext
{
  ClassLoader a;
  Resources b;
  AssetManager c;
  String d;
  boolean e = false;
  protected Context f;
  SixGodPackageManager g;
  
  public SixGodAppContext(Context paramContext1, String paramString, Context paramContext2)
  {
    attachBaseContext(paramContext1);
    this.f = paramContext2;
    this.d = paramString;
  }
  
  public SixGodAppContext(Context paramContext1, String paramString, ClassLoader paramClassLoader, Resources paramResources, AssetManager paramAssetManager, Context paramContext2)
  {
    attachBaseContext(paramContext1);
    this.a = paramClassLoader;
    this.b = paramResources;
    this.c = paramAssetManager;
    this.d = paramString;
    this.e = true;
    this.f = paramContext2;
  }
  
  public boolean bindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    SGLog.a("use SixgodAppContext bindService");
    paramIntent = f.a(this.f, paramIntent, this.d);
    SGLog.a("bindService conn = " + paramServiceConnection);
    return super.bindService(paramIntent, paramServiceConnection, paramInt);
  }
  
  public Context getApplicationContext()
  {
    return this;
  }
  
  public AssetManager getAssets()
  {
    if (this.e) {
      return this.c;
    }
    return super.getAssets();
  }
  
  public ClassLoader getClassLoader()
  {
    if (this.e) {
      return this.a;
    }
    return super.getClassLoader();
  }
  
  public ContentResolver getContentResolver()
  {
    return this.f.getContentResolver();
  }
  
  public File getExternalCacheDir()
  {
    return this.f.getExternalCacheDir();
  }
  
  public File getExternalFilesDir(String paramString)
  {
    return this.f.getExternalFilesDir(paramString);
  }
  
  public String getOpPackageName()
  {
    if (b.a()) {
      return this.f.getPackageName();
    }
    if (this.e) {
      return this.d;
    }
    return super.getPackageName();
  }
  
  public PackageManager getPackageManager()
  {
    if (this.g == null) {
      this.g = new SixGodPackageManager(super.getPackageManager(), getPackageName(), this.f);
    }
    return this.g;
  }
  
  public String getPackageName()
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int i = 0;
    while (i < arrayOfStackTraceElement.length)
    {
      if (arrayOfStackTraceElement[i] != null)
      {
        String str = arrayOfStackTraceElement[i].getClassName();
        if ((str.equals("android.app.PendingIntent")) || (str.startsWith("android.widget.Toast")) || (str.startsWith("com.tencent.mm.sdk.openapi")) || (str.startsWith("android.server.InputMethodManagerService"))) {
          return this.f.getPackageName();
        }
        if ((str.equals("oicq.wlogin_sdk.tools.util")) && (this.d.equals("com.tencent.intervideo.xplatform"))) {
          return "com.tencent.huayang";
        }
      }
      i += 1;
    }
    if (this.e) {
      return this.d;
    }
    return super.getPackageName();
  }
  
  public Resources getResources()
  {
    if (this.e) {
      localObject1 = this.b;
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = super.getResources();
      localObject1 = localObject2;
    } while (localObject2 != null);
    if (this.b != null) {
      return this.b;
    }
    Object localObject1 = SixGodHelper.getPluginLoader(getPackageName());
    if (localObject1 != null)
    {
      localObject1 = ((e)localObject1).c();
      localObject2 = getPackageName();
      localObject1 = (c)((a)localObject1).e.get(localObject2);
      if (localObject1 != null) {
        this.b = ((c)localObject1).k.a();
      }
    }
    return this.b;
  }
  
  public Object getSystemService(String paramString)
  {
    if (paramString.equals("location")) {
      return (LocationManager)this.f.getSystemService(paramString);
    }
    if (paramString.equals("layout_inflater")) {
      return super.getSystemService(paramString);
    }
    return this.f.getSystemService(paramString);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    return this.f.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler)
  {
    return this.f.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler);
  }
  
  public void removeStickyBroadcast(Intent paramIntent)
  {
    this.f.removeStickyBroadcast(paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getPackage()))) {
      paramIntent.setPackage(this.f.getPackageName());
    }
    this.f.sendBroadcast(paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent, String paramString)
  {
    this.f.sendBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString)
  {
    this.f.sendOrderedBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle)
  {
    this.f.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
  }
  
  public void sendStickyBroadcast(Intent paramIntent)
  {
    this.f.sendStickyBroadcast(paramIntent);
  }
  
  public void sendStickyOrderedBroadcast(Intent paramIntent, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle)
  {
    this.f.sendStickyOrderedBroadcast(paramIntent, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
  }
  
  public void startActivity(Intent paramIntent)
  {
    paramIntent = f.a(this.f, paramIntent);
    if (paramIntent != null)
    {
      paramIntent.addFlags(268435456);
      super.startActivity(paramIntent);
    }
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    try
    {
      ComponentName localComponentName = super.startService(f.a(this.f, paramIntent, this.d));
      return localComponentName;
    }
    catch (Exception localException) {}
    return paramIntent.getComponent();
  }
  
  public boolean stopService(Intent paramIntent)
  {
    return super.stopService(f.a(this.f, paramIntent, this.d));
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    this.f.unregisterReceiver(paramBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.apkmanager.SixGodAppContext
 * JD-Core Version:    0.7.0.1
 */