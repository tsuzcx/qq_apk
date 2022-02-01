package com.huawei.hms.push;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.Field;

public class v
{
  public static int a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        paramContext = paramContext.metaData;
        if (paramContext != null)
        {
          int i = paramContext.getInt(paramString);
          return i;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      HMSLog.w("ResourceLoader", "load meta data resource failed.");
    }
    return 0;
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      int j = paramContext.getResources().getIdentifier(paramString2, paramString1, paramContext.getPackageName());
      int i = j;
      if (j == 0)
      {
        paramContext = Class.forName(paramContext.getPackageName() + ".R$" + paramString1).getField(paramString2);
        j = Integer.parseInt(paramContext.get(paramContext.getName()).toString());
        i = j;
        if (j == 0)
        {
          HMSLog.i("ResourceLoader", "Error-resourceType=" + paramString1 + "--resourceName=" + paramString2 + "--resourceId =" + j);
          i = j;
        }
      }
      return i;
    }
    catch (ClassNotFoundException paramContext)
    {
      HMSLog.e("ResourceLoader", "!!!! ResourceLoader: ClassNotFoundException-resourceType=" + paramString1 + "--resourceName=" + paramString2, paramContext);
      return 0;
    }
    catch (NoSuchFieldException paramContext)
    {
      for (;;)
      {
        HMSLog.e("ResourceLoader", "!!!! ResourceLoader: NoSuchFieldException-resourceType=" + paramString1 + "--resourceName=" + paramString2, paramContext);
      }
    }
    catch (NumberFormatException paramContext)
    {
      for (;;)
      {
        HMSLog.e("ResourceLoader", "!!!! ResourceLoader: NumberFormatException-resourceType=" + paramString1 + "--resourceName=" + paramString2, paramContext);
      }
    }
    catch (IllegalAccessException paramContext)
    {
      for (;;)
      {
        HMSLog.e("ResourceLoader", "!!!! ResourceLoader: IllegalAccessException-resourceType=" + paramString1 + "--resourceName=" + paramString2, paramContext);
      }
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        HMSLog.e("ResourceLoader", "!!!! ResourceLoader: IllegalArgumentException-resourceType=" + paramString1 + "--resourceName=" + paramString2, paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.v
 * JD-Core Version:    0.7.0.1
 */