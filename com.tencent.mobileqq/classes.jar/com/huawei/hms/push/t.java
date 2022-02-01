package com.huawei.hms.push;

import android.annotation.SuppressLint;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.huawei.hms.aaid.utils.PushPreferences;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class t
{
  public static boolean a(Context paramContext)
  {
    if (new PushPreferences(paramContext, "push_notify_flag").getBoolean("notify_msg_enable")) {
      return false;
    }
    int i = Build.VERSION.SDK_INT;
    if (i >= 24) {
      return b(paramContext);
    }
    if (i >= 19) {
      return b(paramContext);
    }
    return true;
  }
  
  @SuppressLint({"NewApi", "InlinedApi"})
  public static boolean b(Context paramContext)
  {
    AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
    Object localObject = paramContext.getApplicationInfo();
    paramContext = paramContext.getApplicationContext().getPackageName();
    int i = ((ApplicationInfo)localObject).uid;
    try
    {
      localObject = Class.forName(AppOpsManager.class.getName());
      Method localMethod = ((Class)localObject).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
      i = ((Integer)localMethod.invoke(localAppOpsManager, new Object[] { Integer.valueOf(((Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), paramContext })).intValue();
      return i == 0;
    }
    catch (ClassNotFoundException|NoSuchMethodException|NoSuchFieldException|InvocationTargetException|IllegalAccessException|RuntimeException paramContext) {}
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.t
 * JD-Core Version:    0.7.0.1
 */