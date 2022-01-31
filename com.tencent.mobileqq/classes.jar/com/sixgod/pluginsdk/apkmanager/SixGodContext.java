package com.sixgod.pluginsdk.apkmanager;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import com.sixgod.pluginsdk.SixGodHelper;
import com.sixgod.pluginsdk.b.b;
import com.sixgod.pluginsdk.component.f;
import com.sixgod.pluginsdk.e;
import com.sixgod.pluginsdk.log.SGLog;
import java.io.File;
import java.util.HashMap;

public class SixGodContext
  extends ContextWrapper
  implements IContext
{
  ClassLoader a;
  Resources b;
  AssetManager c;
  String d;
  boolean e = false;
  a f;
  Context g;
  SixGodPackageManager h;
  
  public SixGodContext(Context paramContext1, String paramString, a parama, Context paramContext2)
  {
    super(paramContext1);
    this.f = parama;
    this.g = paramContext2;
    this.d = paramString;
  }
  
  public SixGodContext(Context paramContext1, String paramString, ClassLoader paramClassLoader, Resources paramResources, AssetManager paramAssetManager, a parama, Context paramContext2)
  {
    super(paramContext1);
    this.a = paramClassLoader;
    this.b = paramResources;
    this.c = paramAssetManager;
    this.d = paramString;
    this.e = true;
    this.f = parama;
    this.g = paramContext2;
  }
  
  public boolean bindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    SGLog.a("use SixgodContext bindService");
    return super.bindService(f.a(this.g, paramIntent, this.d), paramServiceConnection, paramInt);
  }
  
  public Context getApplicationContext()
  {
    a locala = this.f;
    String str = this.d;
    if ((c)locala.e.get(str) != null)
    {
      locala = this.f;
      str = this.d;
      return ((c)locala.e.get(str)).e.getApplicationContext();
    }
    return this.g;
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
    return this.g.getContentResolver();
  }
  
  public File getExternalCacheDir()
  {
    return this.g.getExternalCacheDir();
  }
  
  public File getExternalFilesDir(String paramString)
  {
    return this.g.getExternalFilesDir(paramString);
  }
  
  public String getOpPackageName()
  {
    if (b.a()) {
      return this.g.getPackageName();
    }
    if (this.e) {
      return this.d;
    }
    return super.getPackageName();
  }
  
  public PackageManager getPackageManager()
  {
    if (this.h == null) {
      this.h = new SixGodPackageManager(super.getPackageManager(), getPackageName(), this.g);
    }
    return this.h;
  }
  
  public String getPackageName()
  {
    if (b.a()) {
      return this.g.getPackageName();
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
    if (paramString.equals("layout_inflater")) {
      return super.getSystemService(paramString);
    }
    return this.g.getSystemService(paramString);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    return this.g.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler)
  {
    return this.g.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler);
  }
  
  public void removeStickyBroadcast(Intent paramIntent)
  {
    this.g.removeStickyBroadcast(paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent)
  {
    this.g.sendBroadcast(paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent, String paramString)
  {
    this.g.sendBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString)
  {
    this.g.sendOrderedBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle)
  {
    this.g.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
  }
  
  public void sendStickyBroadcast(Intent paramIntent)
  {
    this.g.sendStickyBroadcast(paramIntent);
  }
  
  public void sendStickyOrderedBroadcast(Intent paramIntent, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle)
  {
    this.g.sendStickyOrderedBroadcast(paramIntent, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
  }
  
  public void startActivity(Intent paramIntent)
  {
    super.startActivity(f.a(this.g, paramIntent));
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    return super.startService(f.a(this.g, paramIntent, this.d));
  }
  
  public boolean stopService(Intent paramIntent)
  {
    return super.stopService(f.a(this.g, paramIntent, this.d));
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    this.g.unregisterReceiver(paramBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.apkmanager.SixGodContext
 * JD-Core Version:    0.7.0.1
 */