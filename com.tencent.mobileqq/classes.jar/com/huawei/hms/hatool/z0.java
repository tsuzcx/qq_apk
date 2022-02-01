package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class z0
  extends f
{
  public static String c()
  {
    try
    {
      localObject1 = Class.forName("com.huawei.android.os.BuildEx");
      localObject1 = (String)((Class)localObject1).getMethod("getUDID", new Class[0]).invoke(null, new Object[0]);
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      Object localObject1;
      Object localObject2;
      String str;
      break label82;
    }
    catch (AndroidRuntimeException localAndroidRuntimeException1)
    {
      break label73;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      break label64;
    }
    catch (IllegalAccessException localIllegalAccessException1)
    {
      break label55;
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      break label46;
    }
    catch (InvocationTargetException localInvocationTargetException1)
    {
      label37:
      label40:
      label46:
      label49:
      label55:
      label58:
      label64:
      label67:
      label73:
      label76:
      label82:
      label85:
      label92:
      break label37;
    }
    try
    {
      y.c("hmsSdk", "getUDID success");
      return localObject1;
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      break label85;
    }
    catch (AndroidRuntimeException localAndroidRuntimeException2)
    {
      InvocationTargetException localInvocationTargetException2 = localInvocationTargetException1;
      break label76;
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      InvocationTargetException localInvocationTargetException3 = localInvocationTargetException1;
      break label67;
    }
    catch (IllegalAccessException localIllegalAccessException2)
    {
      InvocationTargetException localInvocationTargetException4 = localInvocationTargetException1;
      break label58;
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      InvocationTargetException localInvocationTargetException5 = localInvocationTargetException1;
      break label49;
    }
    catch (InvocationTargetException localInvocationTargetException6)
    {
      InvocationTargetException localInvocationTargetException7 = localInvocationTargetException1;
      break label40;
    }
    localObject2 = "";
    localObject1 = "getUDID method invoke failed : InvocationTargetException";
    break label92;
    localObject2 = "";
    localObject1 = "getUDID method invoke failed : Illegal ArgumentException";
    break label92;
    localObject2 = "";
    localObject1 = "getUDID method invoke failed : Illegal AccessException";
    break label92;
    localObject2 = "";
    localObject1 = "getUDID method invoke failed : NoSuchMethodException";
    break label92;
    localObject2 = "";
    localObject1 = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
    break label92;
    localObject1 = "";
    str = "getUDID method invoke failed";
    localObject2 = localObject1;
    localObject1 = str;
    y.f("hmsSdk", (String)localObject1);
    return localObject2;
  }
  
  public static Pair<String, String> e(Context paramContext)
  {
    if (p0.a(paramContext, "android.permission.READ_PHONE_STATE"))
    {
      y.f("hmsSdk", "getMccAndMnc() Pair value is empty");
      return new Pair("", "");
    }
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return new Pair("", "");
    }
    if (paramContext.getSimState() != 5) {
      return new Pair("", "");
    }
    paramContext = paramContext.getNetworkOperator();
    if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.equals(paramContext, "null")))
    {
      if (paramContext.length() > 3) {
        return new Pair(paramContext.substring(0, 3), paramContext.substring(3));
      }
      return new Pair("", "");
    }
    return new Pair("", "");
  }
  
  @SuppressLint({"HardwareIds", "MissingPermission"})
  public static String f(Context paramContext)
  {
    if (p0.a(paramContext, "android.permission.READ_PHONE_STATE")) {
      return "";
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        break label40;
      }
      paramContext = PhoneInfoMonitor.getDeviceId(paramContext);
      return paramContext;
    }
    catch (SecurityException paramContext)
    {
      label33:
      label40:
      break label33;
    }
    y.b("hmsSdk", "getDeviceID Incorrect permissions!");
    return "";
  }
  
  public static String g(Context paramContext)
  {
    y.a("hmsSdk", "getSerial : is executed.");
    if (paramContext == null) {
      return "";
    }
    if (p0.a(paramContext, "android.permission.READ_PHONE_STATE")) {
      return "";
    }
    try
    {
      if (Build.VERSION.SDK_INT < 26) {
        break label47;
      }
      paramContext = Build.getSerial();
      return paramContext;
    }
    catch (SecurityException paramContext)
    {
      label40:
      break label40;
    }
    y.f("hmsSdk", "getSerial() Incorrect permissions!");
    label47:
    return "";
  }
  
  public static String h(Context paramContext)
  {
    String str = Build.SERIAL;
    if ((!TextUtils.isEmpty(str)) && (!str.equalsIgnoreCase("unknown"))) {
      return str;
    }
    return g(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.z0
 * JD-Core Version:    0.7.0.1
 */