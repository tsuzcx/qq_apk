package com.tencent.luggage.wxa.re;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class a
{
  private static Boolean a;
  private static String b;
  
  public static boolean a()
  {
    if (a == null)
    {
      String str = Build.BRAND;
      o.d("MicroMsg.Vendor.Huawei", "Build.BRAND = %s", new Object[] { str });
      if ("HONOR".equalsIgnoreCase(str)) {
        a = Boolean.valueOf(true);
      } else if ("HUAWEI".equalsIgnoreCase(str)) {
        a = Boolean.valueOf(true);
      } else {
        a = Boolean.valueOf(false);
      }
    }
    return a.booleanValue();
  }
  
  public static boolean a(Context paramContext)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      boolean bool = ((Boolean)paramContext.getMethod("hasNotchInScreen", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
      o.e("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    catch (ClassNotFoundException paramContext) {}catch (NoSuchMethodException paramContext) {}catch (IllegalAccessException paramContext) {}catch (InvocationTargetException paramContext) {}finally
    {
      break label162;
    }
    o.b("MicroMsg.Vendor.Huawei", "hasCutOut, InvocationTargetException!!");
    o.e("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { localBoolean });
    return false;
    o.b("MicroMsg.Vendor.Huawei", "hasCutOut, IllegalAccessException!!");
    o.e("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { localBoolean });
    return false;
    o.b("MicroMsg.Vendor.Huawei", "hasCutOut, NoSuchMethodException!!");
    o.e("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { localBoolean });
    return false;
    o.b("MicroMsg.Vendor.Huawei", "hasCutOut, ClassNotFoundException!!");
    o.e("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { localBoolean });
    return false;
    label162:
    o.e("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { localBoolean });
    return false;
  }
  
  public static boolean b()
  {
    boolean bool1 = false;
    try
    {
      Class localClass = Class.forName("com.huawei.android.os.SystemPropertiesEx");
      if (!"tablet".equals(localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass.newInstance(), new Object[] { "ro.build.characteristics", "" })))
      {
        boolean bool2 = r.a().getPackageManager().hasSystemFeature("com.huawei.software.features.pad");
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean c()
  {
    if ((a()) && (!b()))
    {
      String str = Build.DEVICE;
      if ((!str.equals("HWTAH")) && (!str.equals("HWTAH-C")) && (!str.equals("unknownRLI")) && (!str.equals("unknownTXL")) && (!str.equals("unknownRHA")))
      {
        if (str.equals("HWTET")) {
          return true;
        }
        if (!r.a().getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture")) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.re.a
 * JD-Core Version:    0.7.0.1
 */