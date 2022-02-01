package com.huawei.hms.push;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.Field;

public class r
{
  public static int a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext == null) {
        break label43;
      }
      paramContext = paramContext.metaData;
      if (paramContext == null) {
        break label43;
      }
      int i = paramContext.getInt(paramString);
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label36:
      label43:
      break label36;
    }
    HMSLog.w("ResourceLoader", "load meta data resource failed.");
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
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext.getPackageName());
        localStringBuilder.append(".R$");
        localStringBuilder.append(paramString1);
        paramContext = Class.forName(localStringBuilder.toString()).getField(paramString2);
        j = Integer.parseInt(paramContext.get(paramContext.getName()).toString());
        i = j;
        if (j == 0)
        {
          paramContext = new StringBuilder();
          paramContext.append("Error-resourceType=");
          paramContext.append(paramString1);
          paramContext.append("--resourceName=");
          paramContext.append(paramString2);
          paramContext.append("--resourceId =");
          paramContext.append(j);
          HMSLog.i("ResourceLoader", paramContext.toString());
          i = j;
        }
      }
      return i;
    }
    catch (IllegalArgumentException paramContext)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("!!!! ResourceLoader: IllegalArgumentException-resourceType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("--resourceName=");
      localStringBuilder.append(paramString2);
      HMSLog.e("ResourceLoader", localStringBuilder.toString(), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("!!!! ResourceLoader: IllegalAccessException-resourceType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("--resourceName=");
      localStringBuilder.append(paramString2);
      HMSLog.e("ResourceLoader", localStringBuilder.toString(), paramContext);
    }
    catch (NumberFormatException paramContext)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("!!!! ResourceLoader: NumberFormatException-resourceType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("--resourceName=");
      localStringBuilder.append(paramString2);
      HMSLog.e("ResourceLoader", localStringBuilder.toString(), paramContext);
    }
    catch (NoSuchFieldException paramContext)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("!!!! ResourceLoader: NoSuchFieldException-resourceType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("--resourceName=");
      localStringBuilder.append(paramString2);
      HMSLog.e("ResourceLoader", localStringBuilder.toString(), paramContext);
    }
    catch (ClassNotFoundException paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("!!!! ResourceLoader: ClassNotFoundException-resourceType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("--resourceName=");
      localStringBuilder.append(paramString2);
      HMSLog.e("ResourceLoader", localStringBuilder.toString(), paramContext);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.r
 * JD-Core Version:    0.7.0.1
 */