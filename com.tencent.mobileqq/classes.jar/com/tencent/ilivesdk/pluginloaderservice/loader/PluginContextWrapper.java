package com.tencent.ilivesdk.pluginloaderservice.loader;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.view.LayoutInflater;

public class PluginContextWrapper
  extends ContextWrapper
{
  private Resources a;
  private LayoutInflater b;
  private final ClassLoader c;
  
  public PluginContextWrapper(Context paramContext, String paramString, ClassLoader paramClassLoader)
  {
    super(paramContext);
    this.c = paramClassLoader;
    this.a = a(paramString, paramContext);
  }
  
  private Resources a(String paramString, Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    PackageInfo localPackageInfo = paramContext.getPackageArchiveInfo(paramString, 128);
    localPackageInfo.applicationInfo.publicSourceDir = paramString;
    localPackageInfo.applicationInfo.sourceDir = paramString;
    try
    {
      paramString = paramContext.getResourcesForApplication(localPackageInfo.applicationInfo);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public AssetManager getAssets()
  {
    return this.a.getAssets();
  }
  
  public ClassLoader getClassLoader()
  {
    return this.c;
  }
  
  public Resources getResources()
  {
    return this.a;
  }
  
  public Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.b == null) {
        this.b = ((LayoutInflater)super.getSystemService(paramString)).cloneInContext(this);
      }
      return this.b;
    }
    return super.getSystemService(paramString);
  }
  
  public Resources.Theme getTheme()
  {
    return this.a.newTheme();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.loader.PluginContextWrapper
 * JD-Core Version:    0.7.0.1
 */