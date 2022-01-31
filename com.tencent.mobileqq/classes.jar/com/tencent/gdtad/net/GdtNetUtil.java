package com.tencent.gdtad.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.gdtad.log.GdtLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GdtNetUtil
{
  public static int a(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return 0;
    }
    Object localObject3 = paramContext.getActiveNetworkInfo();
    switch (((NetworkInfo)localObject3).getType())
    {
    default: 
      return 0;
    case 1: 
    case 6: 
      return 1;
    }
    try
    {
      paramContext = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_2_G").get(TelephonyManager.class);
      Object localObject1 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_3_G").get(TelephonyManager.class);
      Object localObject2 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_4_G").get(TelephonyManager.class);
      localObject3 = TelephonyManager.class.getDeclaredMethod("getNetworkClass", new Class[] { Integer.TYPE }).invoke(TelephonyManager.class, new Object[] { Integer.valueOf(((NetworkInfo)localObject3).getSubtype()) });
      if (localObject3.equals(paramContext)) {
        return 2;
      }
      if (localObject3.equals(localObject1)) {
        return 3;
      }
      boolean bool = localObject3.equals(localObject2);
      if (bool) {
        return 4;
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      GdtLog.d("GdtNetUtil", "getType error", paramContext);
      return 0;
    }
    catch (InvocationTargetException paramContext)
    {
      for (;;)
      {
        GdtLog.d("GdtNetUtil", "getType error", paramContext);
      }
    }
    catch (IllegalAccessException paramContext)
    {
      for (;;)
      {
        GdtLog.d("GdtNetUtil", "getType error", paramContext);
      }
    }
    catch (NoSuchFieldException paramContext)
    {
      for (;;)
      {
        GdtLog.d("GdtNetUtil", "getType error", paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.net.GdtNetUtil
 * JD-Core Version:    0.7.0.1
 */