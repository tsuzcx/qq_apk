package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Iterator;
import java.util.List;

public class h
{
  private static final String TAG = h.class.getSimpleName();
  
  public static boolean g(String paramString)
  {
    Object localObject = c.k();
    if (localObject == null) {
      return false;
    }
    localObject = ((Context)localObject).getPackageManager();
    if (localObject != null) {}
    try
    {
      localObject = ((PackageManager)localObject).getInstalledApplications(0);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        boolean bool;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          bool = ((ApplicationInfo)((Iterator)localObject).next()).packageName.equals(paramString);
        } while (!bool);
        return true;
      }
    }
    catch (Exception paramString)
    {
      g.e(TAG, "exception");
      return false;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        g.e(TAG, "throwable");
      }
    }
  }
  
  public static String h(String paramString)
  {
    Context localContext = c.k();
    if (localContext == null) {
      return "";
    }
    try
    {
      paramString = localContext.getPackageManager().getPackageInfo(paramString, 0).versionName;
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      g.e(TAG, "getVersion NameNotFoundException : " + paramString.getMessage());
      return "";
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        g.e(TAG, "getVersion: " + paramString.getMessage());
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        g.e(TAG, "throwable");
      }
    }
  }
  
  public static int i(String paramString)
  {
    Context localContext = c.k();
    if (localContext == null) {
      return 0;
    }
    try
    {
      int i = localContext.getPackageManager().getPackageInfo(paramString, 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      g.e(TAG, "getVersion NameNotFoundException");
      return 0;
    }
    catch (Exception paramString)
    {
      g.e(TAG, "getVersion: " + paramString.getMessage());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.h
 * JD-Core Version:    0.7.0.1
 */