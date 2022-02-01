package com.huawei.hms.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx.VERSION;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;

public abstract class w
{
  private static final Object a = new Object();
  private static int b = -1;
  
  public static boolean a()
  {
    return HwBuildEx.VERSION.EMUI_SDK_INT >= 21;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = true;
    HMSLog.d("CommFun", "existFrameworkPush:" + b);
    for (;;)
    {
      synchronized (a)
      {
        if (-1 != b)
        {
          if (1 != b) {
            break label88;
          }
          return bool;
        }
        if (c(paramContext))
        {
          b = 1;
          if (1 != b) {
            return false;
          }
        }
        else
        {
          b = 0;
        }
      }
      return true;
      label88:
      bool = false;
    }
  }
  
  public static boolean a(JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString)
  {
    return (paramJSONObject1 == null) || ((TextUtils.isEmpty(paramString)) && (paramJSONObject2 == null));
  }
  
  public static long b(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 0).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      HMSLog.e("CommFun", "get nc versionCode error");
    }
    return -1L;
  }
  
  private static boolean b()
  {
    try
    {
      Object localObject = Class.forName("huawei.cust.HwCfgFilePolicy");
      int i = ((Integer)((Class)localObject).getDeclaredField("CUST_TYPE_CONFIG").get(localObject)).intValue();
      localObject = (File)((Class)localObject).getDeclaredMethod("getCfgFile", new Class[] { String.class, Integer.TYPE }).invoke(localObject, new Object[] { "jars/hwpush.jar", Integer.valueOf(i) });
      if ((localObject != null) && (((File)localObject).exists()))
      {
        HMSLog.d("CommFun", "get push cust File path is " + ((File)localObject).getCanonicalPath());
        return true;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      HMSLog.e("CommFun", "HwCfgFilePolicy ClassNotFoundException");
      return false;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        HMSLog.e("CommFun", "check cust exist push SecurityException.");
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        HMSLog.e("CommFun", "check cust exist push NoSuchFieldException.");
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        HMSLog.e("CommFun", "check cust exist push NoSuchMethodException.");
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        HMSLog.e("CommFun", "check cust exist push IllegalArgumentException.");
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        HMSLog.e("CommFun", "check cust exist push IllegalAccessException.");
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        HMSLog.e("CommFun", "check cust exist push InvocationTargetException.");
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        HMSLog.e("CommFun", "check jarFile exist but get not path");
      }
    }
  }
  
  private static boolean c(Context paramContext)
  {
    boolean bool = false;
    HMSLog.d("CommFun", "existFrameworkPush:" + b);
    try
    {
      paramContext = new File("/system/framework/" + "hwpush.jar");
      if (b())
      {
        HMSLog.d("CommFun", "push jarFile is exist");
      }
      else
      {
        if (!paramContext.isFile()) {
          return bool;
        }
        HMSLog.d("CommFun", "push jarFile is exist");
      }
    }
    catch (Exception paramContext)
    {
      HMSLog.e("CommFun", "get Apk version faild ,Exception e= " + paramContext.toString());
      return false;
    }
    bool = true;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.w
 * JD-Core Version:    0.7.0.1
 */