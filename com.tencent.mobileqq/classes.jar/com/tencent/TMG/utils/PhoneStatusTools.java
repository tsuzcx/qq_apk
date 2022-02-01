package com.tencent.TMG.utils;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.tencent.kapalaiadapter.ReflecterHelper;

public class PhoneStatusTools
{
  static final String TAG = "PhoneStatusTools";
  
  public static NetworkInfo getNetWorkInfo(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null) {
      return paramContext.getActiveNetworkInfo();
    }
    return null;
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    Object localObject = paramContext.getActiveNetworkInfo();
    if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
    {
      localObject = ((NetworkInfo)localObject).getTypeName();
      if (((String)localObject).equalsIgnoreCase("WIFI")) {
        return 2;
      }
      if (((String)localObject).equalsIgnoreCase("MOBILE"))
      {
        paramContext = paramContext.getNetworkInfo(0);
        if (paramContext != null)
        {
          if (paramContext.getType() != 0) {
            return 0;
          }
          switch (paramContext.getSubtype())
          {
          default: 
            return 0;
          case 13: 
            return 5;
          case 3: 
          case 5: 
          case 6: 
          case 8: 
          case 9: 
          case 10: 
          case 12: 
          case 14: 
          case 15: 
            return 3;
          }
          return 4;
        }
      }
    }
    return 0;
  }
  
  public static boolean isCalling(Context paramContext)
  {
    Integer localInteger = Integer.valueOf(0);
    if (paramContext == null)
    {
      QLog.d("PhoneStatusTools", 0, "context is null");
      return false;
    }
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    boolean bool = true;
    if (localTelephonyManager != null)
    {
      if (localTelephonyManager.getCallState() != 0) {
        break label320;
      }
      try
      {
        if (((Integer)ReflecterHelper.invokeMethod(localTelephonyManager, "getCallStateGemini", new Class[] { Integer.TYPE }, new Object[] { localInteger })).intValue() != 0) {
          break label320;
        }
        int i = ((Integer)ReflecterHelper.invokeMethod(localTelephonyManager, "getCallStateGemini", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) })).intValue();
        if (i != 0) {
          break label320;
        }
        try
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone2");
        }
        catch (Exception paramContext)
        {
          break label158;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneStatusTools", 0, "1 isCalling Exception", localException);
        }
      }
    }
    label158:
    paramContext = null;
    if (paramContext != null)
    {
      if (paramContext.getCallState() != 0) {
        break label320;
      }
      try
      {
        if (((Integer)ReflecterHelper.invokeMethod(paramContext, "getCallStateGemini", new Object[] { localInteger })).intValue() != 0) {
          break label320;
        }
        i = ((Integer)ReflecterHelper.invokeMethod(paramContext, "getCallStateGemini", new Object[] { Integer.valueOf(1) })).intValue();
        if (i != 0) {
          break label320;
        }
        try
        {
          paramContext = ReflecterHelper.invokeStaticMethod("android.telephony.MSimTelephonyManager", "getDefault", null, null);
          if (paramContext != null)
          {
            if (((Integer)ReflecterHelper.invokeMethod(paramContext, "getCallState", new Object[] { localInteger })).intValue() != 0) {
              break label320;
            }
            i = ((Integer)ReflecterHelper.invokeMethod(paramContext, "getCallState", new Object[] { Integer.valueOf(1) })).intValue();
            if (i == 0) {}
          }
        }
        catch (Exception paramContext)
        {
          break label318;
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneStatusTools", 0, "2 isCalling Exception", paramContext);
        }
      }
    }
    label318:
    bool = false;
    label320:
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isCalling: ");
      paramContext.append(bool);
      QLog.d("PhoneStatusTools", 0, paramContext.toString());
    }
    return bool;
  }
  
  public static boolean isHardCodePhoneDevice()
  {
    String str1 = Build.MODEL;
    String str2 = Build.MANUFACTURER;
    if ((str2.equalsIgnoreCase("samsung")) && (str1.equalsIgnoreCase("SM-T230"))) {
      return true;
    }
    if (str2.equalsIgnoreCase("SF101")) {
      return true;
    }
    return (str2.equalsIgnoreCase("htc")) && (str1.equalsIgnoreCase("Nexus 9"));
  }
  
  public static boolean isHardCodeTabletDevice()
  {
    return false;
  }
  
  public static boolean isRingEqualsZero(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getStreamVolume(2) == 0);
  }
  
  public static boolean isRingerNormal(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getRingerMode() == 2);
  }
  
  public static boolean isRingerSilent(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getRingerMode() == 0);
  }
  
  public static boolean isRingerVibrate(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getRingerMode() == 1);
  }
  
  public static boolean isTablet(Context paramContext)
  {
    if (isHardCodePhoneDevice()) {
      return false;
    }
    if (isHardCodeTabletDevice()) {
      return true;
    }
    double d1 = 0.0D;
    for (;;)
    {
      try
      {
        DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
        float f1 = localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi;
        float f2 = localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi;
        double d2 = Math.sqrt(Math.pow(f1, 2.0D) + Math.pow(f2, 2.0D));
        d1 = d2;
      }
      catch (Throwable localThrowable)
      {
        int i;
        boolean bool;
        continue;
      }
      try
      {
        i = ((TelephonyManager)paramContext.getSystemService("phone")).getPhoneType();
        if (i == 0) {
          bool = false;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        bool = true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("device size : ");
      paramContext.append(d1);
      paramContext.append(", hasTelephone : ");
      paramContext.append(bool);
      QLog.d("PhoneStatusTools", 0, paramContext.toString());
    }
    return (d1 > 6.5D) && (!bool);
  }
  
  public static boolean isWifiEnv(Context paramContext)
  {
    paramContext = getNetWorkInfo(paramContext);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.getType() == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void listen(Context paramContext, PhoneStateListener paramPhoneStateListener, int paramInt)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    Integer localInteger1 = Integer.valueOf(1);
    Integer localInteger2 = Integer.valueOf(0);
    if (localTelephonyManager != null) {}
    try
    {
      ReflecterHelper.invokeMethod(localTelephonyManager, "listen", new Class[] { PhoneStateListener.class, Integer.TYPE }, new Object[] { paramPhoneStateListener, Integer.valueOf(paramInt) });
      ReflecterHelper.invokeMethod(localTelephonyManager, "listenGemini", new Class[] { Integer.TYPE, PhoneStateListener.class, Integer.TYPE }, new Object[] { localInteger2, paramPhoneStateListener, Integer.valueOf(paramInt) });
      ReflecterHelper.invokeMethod(localTelephonyManager, "listenGemini", new Class[] { Integer.TYPE, PhoneStateListener.class, Integer.TYPE }, new Object[] { localInteger1, paramPhoneStateListener, Integer.valueOf(paramInt) });
    }
    catch (Exception paramContext)
    {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone2");
        break label177;
        paramContext = null;
        label177:
        if (paramContext == null) {}
      }
      catch (Exception paramContext)
      {
        try
        {
          for (;;)
          {
            ReflecterHelper.invokeMethod(paramContext, "listen", new Class[] { PhoneStateListener.class, Integer.TYPE }, new Object[] { paramPhoneStateListener, Integer.valueOf(paramInt) });
            ReflecterHelper.invokeMethod(paramContext, "listenGemini", new Class[] { Integer.TYPE, PhoneStateListener.class, Integer.TYPE }, new Object[] { localInteger2, paramPhoneStateListener, Integer.valueOf(paramInt) });
            ReflecterHelper.invokeMethod(paramContext, "listenGemini", new Class[] { Integer.TYPE, PhoneStateListener.class, Integer.TYPE }, new Object[] { localInteger1, paramPhoneStateListener, Integer.valueOf(paramInt) });
            try
            {
              label313:
              ReflecterHelper.invokeMethod(ReflecterHelper.invokeStaticMethod("android.telephony.MSimTelephonyManager", "getDefault", null, null), "listen", new Class[] { PhoneStateListener.class, Integer.TYPE }, new Object[] { paramPhoneStateListener, Integer.valueOf(paramInt) });
              return;
            }
            catch (Exception paramContext) {}
            localException = localException;
          }
          paramContext = paramContext;
        }
        catch (Exception paramContext)
        {
          break label313;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.utils.PhoneStatusTools
 * JD-Core Version:    0.7.0.1
 */