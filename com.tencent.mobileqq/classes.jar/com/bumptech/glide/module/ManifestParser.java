package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Deprecated
public final class ManifestParser
{
  private final Context a;
  
  public ManifestParser(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private static GlideModule a(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      paramString = null;
      try
      {
        Object localObject = localClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        paramString = localObject;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        a(localClass, localInvocationTargetException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        a(localClass, localNoSuchMethodException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        a(localClass, localIllegalAccessException);
      }
      catch (InstantiationException localInstantiationException)
      {
        a(localClass, localInstantiationException);
      }
      if ((paramString instanceof GlideModule)) {
        return (GlideModule)paramString;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected instanceof GlideModule, but found: ");
      localStringBuilder.append(paramString);
      throw new RuntimeException(localStringBuilder.toString());
    }
    catch (ClassNotFoundException paramString)
    {
      throw new IllegalArgumentException("Unable to find GlideModule implementation", paramString);
    }
  }
  
  private static void a(Class<?> paramClass, Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unable to instantiate GlideModule implementation for ");
    localStringBuilder.append(paramClass);
    throw new RuntimeException(localStringBuilder.toString(), paramException);
  }
  
  public List<GlideModule> a()
  {
    if (Log.isLoggable("ManifestParser", 3)) {
      Log.d("ManifestParser", "Loading Glide modules");
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      ApplicationInfo localApplicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
      if (localApplicationInfo.metaData == null)
      {
        if (Log.isLoggable("ManifestParser", 3))
        {
          Log.d("ManifestParser", "Got null app info metadata");
          return localArrayList;
        }
      }
      else
      {
        if (Log.isLoggable("ManifestParser", 2))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Got app info metadata: ");
          ((StringBuilder)localObject).append(localApplicationInfo.metaData);
          Log.v("ManifestParser", ((StringBuilder)localObject).toString());
        }
        Object localObject = localApplicationInfo.metaData.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if ("GlideModule".equals(localApplicationInfo.metaData.get(str)))
          {
            localArrayList.add(a(str));
            if (Log.isLoggable("ManifestParser", 3))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Loaded Glide module: ");
              localStringBuilder.append(str);
              Log.d("ManifestParser", localStringBuilder.toString());
            }
          }
        }
        if (Log.isLoggable("ManifestParser", 3)) {
          Log.d("ManifestParser", "Finished loading Glide modules");
        }
        return localArrayList;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      RuntimeException localRuntimeException = new RuntimeException("Unable to find metadata to parse GlideModules", localNameNotFoundException);
      for (;;)
      {
        throw localRuntimeException;
      }
      return localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.module.ManifestParser
 * JD-Core Version:    0.7.0.1
 */