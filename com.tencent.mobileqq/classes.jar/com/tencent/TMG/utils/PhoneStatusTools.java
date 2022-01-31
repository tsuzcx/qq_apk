package com.tencent.TMG.utils;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
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
        if (paramContext == null) {}
      }
    }
    switch (paramContext.getType())
    {
    default: 
      return 0;
    }
    switch (paramContext.getSubtype())
    {
    default: 
      return 0;
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
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return 4;
    }
    return 5;
  }
  
  public static boolean isCalling(Context paramContext)
  {
    if (paramContext == null)
    {
      QLog.d("PhoneStatusTools", 0, "context is null");
      return false;
    }
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    boolean bool;
    if (localTelephonyManager != null) {
      if (localTelephonyManager.getCallState() != 0) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneStatusTools", 0, "isCalling: " + bool);
      }
      return bool;
      int i;
      try
      {
        if (((Integer)ReflecterHelper.invokeMethod(localTelephonyManager, "getCallStateGemini", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) })).intValue() != 0)
        {
          bool = true;
          continue;
        }
        i = ((Integer)ReflecterHelper.invokeMethod(localTelephonyManager, "getCallStateGemini", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) })).intValue();
        if (i != 0) {
          bool = true;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneStatusTools", 0, "1 isCalling Exception", localException);
        }
      }
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone2");
        if (paramContext != null) {
          if (paramContext.getCallState() != 0) {
            bool = true;
          }
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext = null;
        }
        try
        {
          if (((Integer)ReflecterHelper.invokeMethod(paramContext, "getCallStateGemini", new Object[] { Integer.valueOf(0) })).intValue() != 0)
          {
            bool = true;
            continue;
          }
          i = ((Integer)ReflecterHelper.invokeMethod(paramContext, "getCallStateGemini", new Object[] { Integer.valueOf(1) })).intValue();
          if (i != 0) {
            bool = true;
          }
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhoneStatusTools", 0, "2 isCalling Exception", paramContext);
          }
        }
        try
        {
          paramContext = ReflecterHelper.invokeStaticMethod("android.telephony.MSimTelephonyManager", "getDefault", null, null);
          if (paramContext != null)
          {
            if (((Integer)ReflecterHelper.invokeMethod(paramContext, "getCallState", new Object[] { Integer.valueOf(0) })).intValue() != 0)
            {
              bool = true;
              continue;
            }
            i = ((Integer)ReflecterHelper.invokeMethod(paramContext, "getCallState", new Object[] { Integer.valueOf(1) })).intValue();
            if (i != 0)
            {
              bool = true;
              continue;
            }
          }
          bool = false;
        }
        catch (Exception paramContext)
        {
          bool = false;
        }
      }
    }
  }
  
  public static boolean isHardCodePhoneDevice()
  {
    String str1 = Build.MODEL;
    String str2 = Build.MANUFACTURER;
    if ((str2.equalsIgnoreCase("samsung")) && (str1.equalsIgnoreCase("SM-T230"))) {}
    while ((str2.equalsIgnoreCase("SF101")) || ((str2.equalsIgnoreCase("htc")) && (str1.equalsIgnoreCase("Nexus 9")))) {
      return true;
    }
    return false;
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
    if (isHardCodePhoneDevice()) {}
    for (;;)
    {
      return false;
      if (isHardCodeTabletDevice()) {
        return true;
      }
      try
      {
        DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
        float f1 = localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi;
        float f2 = localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi;
        d = Math.pow(f1, 2.0D);
        d = Math.sqrt(Math.pow(f2, 2.0D) + d);
        try
        {
          int i = ((TelephonyManager)paramContext.getSystemService("phone")).getPhoneType();
          if (i != 0) {
            break label166;
          }
          bool = false;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
            boolean bool = true;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("PhoneStatusTools", 0, "device size : " + d + ", hasTelephone : " + bool);
        }
        if ((d <= 6.5D) || (bool)) {
          continue;
        }
        return true;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          double d = 0.0D;
        }
      }
    }
  }
  
  public static boolean isWifiEnv(Context paramContext)
  {
    paramContext = getNetWorkInfo(paramContext);
    if (paramContext != null) {
      return paramContext.getType() == 1;
    }
    return false;
  }
  
  /* Error */
  public static void listen(Context paramContext, android.telephony.PhoneStateListener paramPhoneStateListener, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 76
    //   3: invokevirtual 23	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 78	android/telephony/TelephonyManager
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull +140 -> 151
    //   14: aload_3
    //   15: ldc 244
    //   17: iconst_2
    //   18: anewarray 103	java/lang/Class
    //   21: dup
    //   22: iconst_0
    //   23: ldc 246
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: getstatic 109	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   31: aastore
    //   32: iconst_2
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_1
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: iload_2
    //   43: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: aastore
    //   47: invokestatic 119	com/tencent/kapalaiadapter/ReflecterHelper:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: aload_3
    //   52: ldc 248
    //   54: iconst_3
    //   55: anewarray 103	java/lang/Class
    //   58: dup
    //   59: iconst_0
    //   60: getstatic 109	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: ldc 246
    //   68: aastore
    //   69: dup
    //   70: iconst_2
    //   71: getstatic 109	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   74: aastore
    //   75: iconst_3
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: iconst_0
    //   82: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload_1
    //   89: aastore
    //   90: dup
    //   91: iconst_2
    //   92: iload_2
    //   93: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: aastore
    //   97: invokestatic 119	com/tencent/kapalaiadapter/ReflecterHelper:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: aload_3
    //   102: ldc 248
    //   104: iconst_3
    //   105: anewarray 103	java/lang/Class
    //   108: dup
    //   109: iconst_0
    //   110: getstatic 109	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: ldc 246
    //   118: aastore
    //   119: dup
    //   120: iconst_2
    //   121: getstatic 109	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   124: aastore
    //   125: iconst_3
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: iconst_1
    //   132: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: aload_1
    //   139: aastore
    //   140: dup
    //   141: iconst_2
    //   142: iload_2
    //   143: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: aastore
    //   147: invokestatic 119	com/tencent/kapalaiadapter/ReflecterHelper:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: aload_0
    //   152: ldc 129
    //   154: invokevirtual 23	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   157: checkcast 78	android/telephony/TelephonyManager
    //   160: astore_0
    //   161: aload_0
    //   162: ifnull +140 -> 302
    //   165: aload_0
    //   166: ldc 244
    //   168: iconst_2
    //   169: anewarray 103	java/lang/Class
    //   172: dup
    //   173: iconst_0
    //   174: ldc 246
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: getstatic 109	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   182: aastore
    //   183: iconst_2
    //   184: anewarray 4	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_1
    //   190: aastore
    //   191: dup
    //   192: iconst_1
    //   193: iload_2
    //   194: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: aastore
    //   198: invokestatic 119	com/tencent/kapalaiadapter/ReflecterHelper:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   201: pop
    //   202: aload_0
    //   203: ldc 248
    //   205: iconst_3
    //   206: anewarray 103	java/lang/Class
    //   209: dup
    //   210: iconst_0
    //   211: getstatic 109	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   214: aastore
    //   215: dup
    //   216: iconst_1
    //   217: ldc 246
    //   219: aastore
    //   220: dup
    //   221: iconst_2
    //   222: getstatic 109	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   225: aastore
    //   226: iconst_3
    //   227: anewarray 4	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: iconst_0
    //   233: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   236: aastore
    //   237: dup
    //   238: iconst_1
    //   239: aload_1
    //   240: aastore
    //   241: dup
    //   242: iconst_2
    //   243: iload_2
    //   244: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   247: aastore
    //   248: invokestatic 119	com/tencent/kapalaiadapter/ReflecterHelper:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   251: pop
    //   252: aload_0
    //   253: ldc 248
    //   255: iconst_3
    //   256: anewarray 103	java/lang/Class
    //   259: dup
    //   260: iconst_0
    //   261: getstatic 109	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   264: aastore
    //   265: dup
    //   266: iconst_1
    //   267: ldc 246
    //   269: aastore
    //   270: dup
    //   271: iconst_2
    //   272: getstatic 109	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   275: aastore
    //   276: iconst_3
    //   277: anewarray 4	java/lang/Object
    //   280: dup
    //   281: iconst_0
    //   282: iconst_1
    //   283: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   286: aastore
    //   287: dup
    //   288: iconst_1
    //   289: aload_1
    //   290: aastore
    //   291: dup
    //   292: iconst_2
    //   293: iload_2
    //   294: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   297: aastore
    //   298: invokestatic 119	com/tencent/kapalaiadapter/ReflecterHelper:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   301: pop
    //   302: ldc 136
    //   304: ldc 138
    //   306: aconst_null
    //   307: aconst_null
    //   308: invokestatic 142	com/tencent/kapalaiadapter/ReflecterHelper:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
    //   311: ldc 244
    //   313: iconst_2
    //   314: anewarray 103	java/lang/Class
    //   317: dup
    //   318: iconst_0
    //   319: ldc 246
    //   321: aastore
    //   322: dup
    //   323: iconst_1
    //   324: getstatic 109	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   327: aastore
    //   328: iconst_2
    //   329: anewarray 4	java/lang/Object
    //   332: dup
    //   333: iconst_0
    //   334: aload_1
    //   335: aastore
    //   336: dup
    //   337: iconst_1
    //   338: iload_2
    //   339: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: aastore
    //   343: invokestatic 119	com/tencent/kapalaiadapter/ReflecterHelper:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   346: pop
    //   347: return
    //   348: astore_0
    //   349: aconst_null
    //   350: astore_0
    //   351: goto -190 -> 161
    //   354: astore_0
    //   355: return
    //   356: astore_0
    //   357: goto -55 -> 302
    //   360: astore_3
    //   361: goto -210 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	paramContext	Context
    //   0	364	1	paramPhoneStateListener	android.telephony.PhoneStateListener
    //   0	364	2	paramInt	int
    //   9	93	3	localTelephonyManager	TelephonyManager
    //   360	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   151	161	348	java/lang/Exception
    //   302	347	354	java/lang/Exception
    //   165	302	356	java/lang/Exception
    //   14	151	360	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.utils.PhoneStatusTools
 * JD-Core Version:    0.7.0.1
 */