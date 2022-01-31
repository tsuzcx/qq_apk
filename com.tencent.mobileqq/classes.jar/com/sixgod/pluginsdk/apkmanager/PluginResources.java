package com.sixgod.pluginsdk.apkmanager;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.lang.reflect.Method;

public class PluginResources
{
  public static final int FLAG_RESOURCE_USE_BOTH = 2;
  public static final int FLAG_RESOURCE_USE_HOST = 1;
  public static final int FLAG_RESOURCE_USE_PLUGIN = 0;
  int a = 0;
  String b;
  Context c;
  
  public PluginResources(Context paramContext, int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramContext;
  }
  
  private String c()
  {
    String str = this.c.getPackageName();
    try
    {
      str = this.c.getPackageManager().getApplicationInfo(str, 8192).sourceDir;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "";
  }
  
  public final Resources a()
  {
    if (this.a == 1) {
      return this.c.getResources();
    }
    DisplayMetrics localDisplayMetrics = this.c.getResources().getDisplayMetrics();
    Configuration localConfiguration = this.c.getResources().getConfiguration();
    return new Resources(b(), localDisplayMetrics, localConfiguration);
  }
  
  public final AssetManager b()
  {
    try
    {
      localAssetManager = (AssetManager)AssetManager.class.newInstance();
      Method localMethod;
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localMethod = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
        localMethod.invoke(localAssetManager, new Object[] { this.b });
        if (this.a == 2) {
          localMethod.invoke(localAssetManager, new Object[] { c() });
        }
        return localAssetManager;
      }
      catch (Throwable localThrowable2)
      {
        AssetManager localAssetManager;
        break label73;
      }
      localThrowable1 = localThrowable1;
      localAssetManager = null;
    }
    label73:
    return localAssetManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.apkmanager.PluginResources
 * JD-Core Version:    0.7.0.1
 */