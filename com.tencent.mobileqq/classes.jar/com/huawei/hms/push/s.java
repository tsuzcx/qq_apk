package com.huawei.hms.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx.VERSION;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;

public abstract class s
{
  public static final Object a = new Object();
  public static int b = -1;
  
  public static boolean a()
  {
    try
    {
      Object localObject1 = Class.forName("huawei.cust.HwCfgFilePolicy");
      int i = ((Integer)((Class)localObject1).getDeclaredField("CUST_TYPE_CONFIG").get(localObject1)).intValue();
      Object localObject2 = ((Class)localObject1).getDeclaredMethod("getCfgFile", new Class[] { String.class, Integer.TYPE });
      localObject1 = (File)((Method)localObject2).invoke(localObject1, new Object[] { "jars/hwpush.jar", Integer.valueOf(i) });
      if ((localObject1 == null) || (!((File)localObject1).exists())) {
        break label186;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("get push cust File path is ");
      ((StringBuilder)localObject2).append(((File)localObject1).getCanonicalPath());
      HMSLog.d("CommFun", ((StringBuilder)localObject2).toString());
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label179;
    }
    catch (SecurityException localSecurityException)
    {
      break label170;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label161;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label152;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label143;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label134;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label134:
      label143:
      label152:
      label161:
      label170:
      label179:
      label186:
      break label125;
    }
    catch (IOException localIOException)
    {
      label116:
      label125:
      break label116;
    }
    HMSLog.e("CommFun", "check jarFile exist but get not path");
    return false;
    HMSLog.e("CommFun", "check cust exist push InvocationTargetException.");
    return false;
    HMSLog.e("CommFun", "check cust exist push IllegalAccessException.");
    return false;
    HMSLog.e("CommFun", "check cust exist push IllegalArgumentException.");
    return false;
    HMSLog.e("CommFun", "check cust exist push NoSuchMethodException.");
    return false;
    HMSLog.e("CommFun", "check cust exist push NoSuchFieldException.");
    return false;
    HMSLog.e("CommFun", "check cust exist push SecurityException.");
    return false;
    HMSLog.e("CommFun", "HwCfgFilePolicy ClassNotFoundException");
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = new StringBuilder();
    paramContext.append("existFrameworkPush:");
    paramContext.append(b);
    HMSLog.d("CommFun", paramContext.toString());
    try
    {
      paramContext = new StringBuilder();
      paramContext.append("/system/framework/");
      paramContext.append("hwpush.jar");
      paramContext = new File(paramContext.toString());
      boolean bool = a();
      if (bool)
      {
        HMSLog.d("CommFun", "push jarFile is exist");
      }
      else
      {
        if (!paramContext.isFile()) {
          break label100;
        }
        HMSLog.d("CommFun", "push jarFile is exist");
      }
      return true;
      label100:
      return false;
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get Apk version faild ,Exception e= ");
      localStringBuilder.append(paramContext.toString());
      HMSLog.e("CommFun", localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean a(JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString)
  {
    return (paramJSONObject1 == null) || ((TextUtils.isEmpty(paramString)) && (paramJSONObject2 == null));
  }
  
  public static long b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager();
      int i = paramContext.getPackageInfo("com.huawei.android.pushagent", 0).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      label19:
      break label19;
    }
    HMSLog.e("CommFun", "get nc versionCode error");
    return -1L;
  }
  
  public static boolean b()
  {
    return HwBuildEx.VERSION.EMUI_SDK_INT >= 21;
  }
  
  public static String c(Context paramContext)
  {
    return AGConnectServicesConfig.fromContext(paramContext).getString("client/project_id");
  }
  
  public static boolean c()
  {
    return HwBuildEx.VERSION.EMUI_SDK_INT < 19;
  }
  
  public static boolean d(Context paramContext)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("existFrameworkPush:");
    ((StringBuilder)???).append(b);
    HMSLog.d("CommFun", ((StringBuilder)???).toString());
    synchronized (a)
    {
      int i = b;
      boolean bool2 = false;
      boolean bool1 = false;
      if (-1 != i)
      {
        if (1 == b) {
          bool1 = true;
        }
        return bool1;
      }
      if (a(paramContext)) {
        b = 1;
      } else {
        b = 0;
      }
      bool1 = bool2;
      if (1 == b) {
        bool1 = true;
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.push.s
 * JD-Core Version:    0.7.0.1
 */