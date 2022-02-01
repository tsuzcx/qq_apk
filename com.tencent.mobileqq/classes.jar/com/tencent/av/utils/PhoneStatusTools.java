package com.tencent.av.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class PhoneStatusTools
{
  static Boolean a = Boolean.valueOf(true);
  static Boolean b = Boolean.valueOf(true);
  static Boolean c = Boolean.valueOf(true);
  static Boolean d = Boolean.valueOf(true);
  static Boolean e = Boolean.valueOf(true);
  static Boolean f = Boolean.valueOf(true);
  
  public static int a(Context paramContext)
  {
    int i = 1;
    int j = NetworkUtil.a(paramContext);
    if (j == 1) {
      i = 0;
    }
    while (j == 4) {
      return i;
    }
    if (j == 3) {
      return 2;
    }
    if (j == 2) {
      return 3;
    }
    return -1;
  }
  
  public static NetworkInfo a(Context paramContext)
  {
    return AppNetConnInfo.getRecentNetworkInfo();
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { new String(paramString) });
      return paramContext;
    }
    catch (IllegalArgumentException paramContext)
    {
      throw paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  /* Error */
  public static void a(Context paramContext, android.telephony.PhoneStateListener paramPhoneStateListener, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 90
    //   3: invokevirtual 94	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 96	android/telephony/TelephonyManager
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull +140 -> 151
    //   14: aload_3
    //   15: ldc 98
    //   17: iconst_2
    //   18: anewarray 70	java/lang/Class
    //   21: dup
    //   22: iconst_0
    //   23: ldc 100
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: getstatic 106	java/lang/Integer:TYPE	Ljava/lang/Class;
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
    //   43: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: aastore
    //   47: invokestatic 114	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: aload_3
    //   52: ldc 116
    //   54: iconst_3
    //   55: anewarray 70	java/lang/Class
    //   58: dup
    //   59: iconst_0
    //   60: getstatic 106	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: ldc 100
    //   68: aastore
    //   69: dup
    //   70: iconst_2
    //   71: getstatic 106	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   74: aastore
    //   75: iconst_3
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: iconst_0
    //   82: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload_1
    //   89: aastore
    //   90: dup
    //   91: iconst_2
    //   92: iload_2
    //   93: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: aastore
    //   97: invokestatic 114	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: aload_3
    //   102: ldc 116
    //   104: iconst_3
    //   105: anewarray 70	java/lang/Class
    //   108: dup
    //   109: iconst_0
    //   110: getstatic 106	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: ldc 100
    //   118: aastore
    //   119: dup
    //   120: iconst_2
    //   121: getstatic 106	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   124: aastore
    //   125: iconst_3
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: iconst_1
    //   132: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: aload_1
    //   139: aastore
    //   140: dup
    //   141: iconst_2
    //   142: iload_2
    //   143: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: aastore
    //   147: invokestatic 114	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: aload_0
    //   152: ldc 118
    //   154: invokevirtual 94	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   157: checkcast 96	android/telephony/TelephonyManager
    //   160: astore_0
    //   161: aload_0
    //   162: ifnull +140 -> 302
    //   165: aload_0
    //   166: ldc 98
    //   168: iconst_2
    //   169: anewarray 70	java/lang/Class
    //   172: dup
    //   173: iconst_0
    //   174: ldc 100
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: getstatic 106	java/lang/Integer:TYPE	Ljava/lang/Class;
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
    //   194: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: aastore
    //   198: invokestatic 114	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   201: pop
    //   202: aload_0
    //   203: ldc 116
    //   205: iconst_3
    //   206: anewarray 70	java/lang/Class
    //   209: dup
    //   210: iconst_0
    //   211: getstatic 106	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   214: aastore
    //   215: dup
    //   216: iconst_1
    //   217: ldc 100
    //   219: aastore
    //   220: dup
    //   221: iconst_2
    //   222: getstatic 106	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   225: aastore
    //   226: iconst_3
    //   227: anewarray 4	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: iconst_0
    //   233: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   236: aastore
    //   237: dup
    //   238: iconst_1
    //   239: aload_1
    //   240: aastore
    //   241: dup
    //   242: iconst_2
    //   243: iload_2
    //   244: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   247: aastore
    //   248: invokestatic 114	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   251: pop
    //   252: aload_0
    //   253: ldc 116
    //   255: iconst_3
    //   256: anewarray 70	java/lang/Class
    //   259: dup
    //   260: iconst_0
    //   261: getstatic 106	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   264: aastore
    //   265: dup
    //   266: iconst_1
    //   267: ldc 100
    //   269: aastore
    //   270: dup
    //   271: iconst_2
    //   272: getstatic 106	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   275: aastore
    //   276: iconst_3
    //   277: anewarray 4	java/lang/Object
    //   280: dup
    //   281: iconst_0
    //   282: iconst_1
    //   283: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   286: aastore
    //   287: dup
    //   288: iconst_1
    //   289: aload_1
    //   290: aastore
    //   291: dup
    //   292: iconst_2
    //   293: iload_2
    //   294: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   297: aastore
    //   298: invokestatic 114	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   301: pop
    //   302: ldc 120
    //   304: ldc 122
    //   306: aconst_null
    //   307: aconst_null
    //   308: invokestatic 125	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
    //   311: ldc 98
    //   313: iconst_2
    //   314: anewarray 70	java/lang/Class
    //   317: dup
    //   318: iconst_0
    //   319: ldc 100
    //   321: aastore
    //   322: dup
    //   323: iconst_1
    //   324: getstatic 106	java/lang/Integer:TYPE	Ljava/lang/Class;
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
    //   339: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: aastore
    //   343: invokestatic 114	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   346: pop
    //   347: return
    //   348: astore_0
    //   349: aconst_null
    //   350: astore_0
    //   351: goto -190 -> 161
    //   354: astore_0
    //   355: return
    //   356: astore_0
    //   357: return
    //   358: astore_0
    //   359: goto -57 -> 302
    //   362: astore_3
    //   363: goto -212 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	paramContext	Context
    //   0	366	1	paramPhoneStateListener	android.telephony.PhoneStateListener
    //   0	366	2	paramInt	int
    //   9	93	3	localTelephonyManager	TelephonyManager
    //   362	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   151	161	348	java/lang/Exception
    //   0	10	354	java/lang/Exception
    //   302	347	356	java/lang/Exception
    //   165	302	358	java/lang/Exception
    //   14	151	362	java/lang/Exception
  }
  
  public static boolean a()
  {
    String str = Build.MODEL;
    return (Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (str.equalsIgnoreCase("SM-T230"));
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getRingerMode() == 0);
  }
  
  public static boolean b()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    boolean bool1 = bool2;
    if ("samsung".equalsIgnoreCase(Build.MANUFACTURER)) {
      if (!"SM-T805C".equalsIgnoreCase(str))
      {
        bool1 = bool2;
        if (!"SM-T800".equalsIgnoreCase(str)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getRingerMode() == 1);
  }
  
  public static boolean c()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    return (str1.equalsIgnoreCase("ZTE")) && (str2.equalsIgnoreCase("ZTE U950"));
  }
  
  public static boolean c(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getRingerMode() == 2);
  }
  
  public static boolean d()
  {
    boolean bool = true;
    Object localObject = BaseApplication.getContext();
    if (localObject == null)
    {
      QLog.w("PhoneStatusTools", 2, "isAutoRotateDisabled returns false when context null");
      return false;
    }
    localObject = ((Context)localObject).getContentResolver();
    if (localObject == null)
    {
      QLog.w("PhoneStatusTools", 2, "isAutoRotateDisabled returns false when contentResolver null");
      return false;
    }
    for (;;)
    {
      try
      {
        i = Settings.System.getInt((ContentResolver)localObject, "accelerometer_rotation", 1);
        j = i;
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("PhoneStatusTools", 2, "isAutoRotateDisabled getInt res: " + i);
            j = i;
          }
          if (j == 1) {
            break label101;
          }
          return bool;
        }
        catch (Exception localException2)
        {
          int i;
          int j;
          break label92;
        }
        localException1 = localException1;
        i = 1;
      }
      label92:
      j = i;
      continue;
      label101:
      bool = false;
    }
  }
  
  public static boolean d(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getStreamVolume(2) == 0);
  }
  
  /* Error */
  public static boolean e(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +13 -> 14
    //   4: ldc 168
    //   6: iconst_1
    //   7: ldc 224
    //   9: invokestatic 176	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   12: iconst_0
    //   13: ireturn
    //   14: aload_0
    //   15: ldc 90
    //   17: invokevirtual 94	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   20: checkcast 96	android/telephony/TelephonyManager
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +224 -> 249
    //   28: aload_3
    //   29: invokevirtual 227	android/telephony/TelephonyManager:getCallState	()I
    //   32: istore_1
    //   33: iload_1
    //   34: ifeq +45 -> 79
    //   37: iconst_1
    //   38: istore_2
    //   39: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +28 -> 70
    //   45: ldc 168
    //   47: iconst_2
    //   48: new 195	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   55: ldc 229
    //   57: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_2
    //   61: invokevirtual 232	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   64: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: iload_2
    //   71: ireturn
    //   72: astore 4
    //   74: iconst_0
    //   75: istore_1
    //   76: goto -43 -> 33
    //   79: getstatic 21	com/tencent/av/utils/PhoneStatusTools:a	Ljava/lang/Boolean;
    //   82: invokevirtual 235	java/lang/Boolean:booleanValue	()Z
    //   85: ifeq +69 -> 154
    //   88: aload_3
    //   89: ldc 237
    //   91: iconst_1
    //   92: anewarray 70	java/lang/Class
    //   95: dup
    //   96: iconst_0
    //   97: getstatic 106	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   100: aastore
    //   101: iconst_1
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: iconst_0
    //   108: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   111: aastore
    //   112: invokestatic 114	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   115: checkcast 102	java/lang/Integer
    //   118: invokevirtual 240	java/lang/Integer:intValue	()I
    //   121: istore_1
    //   122: iload_1
    //   123: ifeq +31 -> 154
    //   126: iconst_1
    //   127: istore_2
    //   128: goto -89 -> 39
    //   131: astore 4
    //   133: iconst_0
    //   134: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   137: putstatic 21	com/tencent/av/utils/PhoneStatusTools:a	Ljava/lang/Boolean;
    //   140: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +11 -> 154
    //   146: ldc 168
    //   148: iconst_2
    //   149: ldc 242
    //   151: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: getstatic 23	com/tencent/av/utils/PhoneStatusTools:b	Ljava/lang/Boolean;
    //   157: invokevirtual 235	java/lang/Boolean:booleanValue	()Z
    //   160: ifeq +89 -> 249
    //   163: aload_3
    //   164: ldc 237
    //   166: iconst_1
    //   167: anewarray 70	java/lang/Class
    //   170: dup
    //   171: iconst_0
    //   172: getstatic 106	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   175: aastore
    //   176: iconst_1
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: iconst_1
    //   183: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: aastore
    //   187: invokestatic 114	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   190: checkcast 102	java/lang/Integer
    //   193: invokevirtual 240	java/lang/Integer:intValue	()I
    //   196: istore_1
    //   197: iload_1
    //   198: ifeq +51 -> 249
    //   201: iconst_1
    //   202: istore_2
    //   203: goto -164 -> 39
    //   206: astore 4
    //   208: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq -57 -> 154
    //   214: ldc 168
    //   216: iconst_2
    //   217: ldc 244
    //   219: aload 4
    //   221: invokestatic 247	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   224: goto -70 -> 154
    //   227: astore_3
    //   228: iconst_0
    //   229: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   232: putstatic 23	com/tencent/av/utils/PhoneStatusTools:b	Ljava/lang/Boolean;
    //   235: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +11 -> 249
    //   241: ldc 168
    //   243: iconst_2
    //   244: ldc 249
    //   246: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload_0
    //   250: ldc 118
    //   252: invokevirtual 94	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   255: checkcast 96	android/telephony/TelephonyManager
    //   258: astore_0
    //   259: aload_0
    //   260: ifnull +198 -> 458
    //   263: aload_0
    //   264: invokevirtual 227	android/telephony/TelephonyManager:getCallState	()I
    //   267: istore_1
    //   268: iload_1
    //   269: ifeq +39 -> 308
    //   272: iconst_1
    //   273: istore_2
    //   274: goto -235 -> 39
    //   277: astore_3
    //   278: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq -32 -> 249
    //   284: ldc 168
    //   286: iconst_2
    //   287: ldc 251
    //   289: aload_3
    //   290: invokestatic 247	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   293: goto -44 -> 249
    //   296: astore_0
    //   297: aconst_null
    //   298: astore_0
    //   299: goto -40 -> 259
    //   302: astore_3
    //   303: iconst_0
    //   304: istore_1
    //   305: goto -37 -> 268
    //   308: getstatic 25	com/tencent/av/utils/PhoneStatusTools:c	Ljava/lang/Boolean;
    //   311: invokevirtual 235	java/lang/Boolean:booleanValue	()Z
    //   314: ifeq +59 -> 373
    //   317: aload_0
    //   318: ldc 237
    //   320: iconst_1
    //   321: anewarray 4	java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: iconst_0
    //   327: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   330: aastore
    //   331: invokestatic 254	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   334: checkcast 102	java/lang/Integer
    //   337: invokevirtual 240	java/lang/Integer:intValue	()I
    //   340: istore_1
    //   341: iload_1
    //   342: ifeq +31 -> 373
    //   345: iconst_1
    //   346: istore_2
    //   347: goto -308 -> 39
    //   350: astore_3
    //   351: iconst_0
    //   352: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   355: putstatic 25	com/tencent/av/utils/PhoneStatusTools:c	Ljava/lang/Boolean;
    //   358: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq +12 -> 373
    //   364: ldc 168
    //   366: iconst_2
    //   367: ldc_w 256
    //   370: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: getstatic 27	com/tencent/av/utils/PhoneStatusTools:d	Ljava/lang/Boolean;
    //   376: invokevirtual 235	java/lang/Boolean:booleanValue	()Z
    //   379: ifeq +79 -> 458
    //   382: aload_0
    //   383: ldc 237
    //   385: iconst_1
    //   386: anewarray 4	java/lang/Object
    //   389: dup
    //   390: iconst_0
    //   391: iconst_1
    //   392: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   395: aastore
    //   396: invokestatic 254	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   399: checkcast 102	java/lang/Integer
    //   402: invokevirtual 240	java/lang/Integer:intValue	()I
    //   405: istore_1
    //   406: iload_1
    //   407: ifeq +51 -> 458
    //   410: iconst_1
    //   411: istore_2
    //   412: goto -373 -> 39
    //   415: astore_3
    //   416: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq -46 -> 373
    //   422: ldc 168
    //   424: iconst_2
    //   425: ldc_w 258
    //   428: aload_3
    //   429: invokestatic 247	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   432: goto -59 -> 373
    //   435: astore_0
    //   436: iconst_0
    //   437: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   440: putstatic 27	com/tencent/av/utils/PhoneStatusTools:d	Ljava/lang/Boolean;
    //   443: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq +12 -> 458
    //   449: ldc 168
    //   451: iconst_2
    //   452: ldc_w 260
    //   455: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: getstatic 29	com/tencent/av/utils/PhoneStatusTools:e	Ljava/lang/Boolean;
    //   461: invokevirtual 235	java/lang/Boolean:booleanValue	()Z
    //   464: ifeq +88 -> 552
    //   467: ldc 120
    //   469: ldc 122
    //   471: aconst_null
    //   472: aconst_null
    //   473: invokestatic 125	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
    //   476: ldc_w 261
    //   479: iconst_1
    //   480: anewarray 4	java/lang/Object
    //   483: dup
    //   484: iconst_0
    //   485: iconst_0
    //   486: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   489: aastore
    //   490: invokestatic 254	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   493: checkcast 102	java/lang/Integer
    //   496: invokevirtual 240	java/lang/Integer:intValue	()I
    //   499: istore_1
    //   500: iload_1
    //   501: ifeq +51 -> 552
    //   504: iconst_1
    //   505: istore_2
    //   506: goto -467 -> 39
    //   509: astore_0
    //   510: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   513: ifeq -55 -> 458
    //   516: ldc 168
    //   518: iconst_2
    //   519: ldc_w 263
    //   522: aload_0
    //   523: invokestatic 247	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   526: goto -68 -> 458
    //   529: astore_0
    //   530: iconst_0
    //   531: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   534: putstatic 29	com/tencent/av/utils/PhoneStatusTools:e	Ljava/lang/Boolean;
    //   537: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   540: ifeq +12 -> 552
    //   543: ldc 168
    //   545: iconst_2
    //   546: ldc_w 265
    //   549: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   552: getstatic 31	com/tencent/av/utils/PhoneStatusTools:f	Ljava/lang/Boolean;
    //   555: invokevirtual 235	java/lang/Boolean:booleanValue	()Z
    //   558: ifeq +88 -> 646
    //   561: ldc 120
    //   563: ldc 122
    //   565: aconst_null
    //   566: aconst_null
    //   567: invokestatic 125	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
    //   570: ldc_w 261
    //   573: iconst_1
    //   574: anewarray 4	java/lang/Object
    //   577: dup
    //   578: iconst_0
    //   579: iconst_1
    //   580: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   583: aastore
    //   584: invokestatic 254	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   587: checkcast 102	java/lang/Integer
    //   590: invokevirtual 240	java/lang/Integer:intValue	()I
    //   593: istore_1
    //   594: iload_1
    //   595: ifeq +8 -> 603
    //   598: iconst_1
    //   599: istore_2
    //   600: goto -561 -> 39
    //   603: iconst_0
    //   604: istore_2
    //   605: goto -566 -> 39
    //   608: astore_0
    //   609: iconst_0
    //   610: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   613: putstatic 31	com/tencent/av/utils/PhoneStatusTools:f	Ljava/lang/Boolean;
    //   616: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   619: ifeq +12 -> 631
    //   622: ldc 168
    //   624: iconst_2
    //   625: ldc_w 267
    //   628: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   631: iconst_0
    //   632: istore_2
    //   633: goto -594 -> 39
    //   636: astore_0
    //   637: iconst_0
    //   638: istore_2
    //   639: goto -600 -> 39
    //   642: astore_0
    //   643: goto -91 -> 552
    //   646: iconst_0
    //   647: istore_2
    //   648: goto -609 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	651	0	paramContext	Context
    //   32	563	1	i	int
    //   38	610	2	bool	boolean
    //   23	141	3	localTelephonyManager	TelephonyManager
    //   227	1	3	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   277	13	3	localException1	Exception
    //   302	1	3	localThrowable1	Throwable
    //   350	1	3	localNoSuchMethodException2	java.lang.NoSuchMethodException
    //   415	14	3	localException2	Exception
    //   72	1	4	localThrowable2	Throwable
    //   131	1	4	localNoSuchMethodException3	java.lang.NoSuchMethodException
    //   206	14	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   28	33	72	java/lang/Throwable
    //   88	122	131	java/lang/NoSuchMethodException
    //   88	122	206	java/lang/Exception
    //   163	197	227	java/lang/NoSuchMethodException
    //   163	197	277	java/lang/Exception
    //   249	259	296	java/lang/Exception
    //   263	268	302	java/lang/Throwable
    //   317	341	350	java/lang/NoSuchMethodException
    //   317	341	415	java/lang/Exception
    //   382	406	435	java/lang/NoSuchMethodException
    //   382	406	509	java/lang/Exception
    //   467	500	529	java/lang/NoSuchMethodException
    //   561	594	608	java/lang/NoSuchMethodException
    //   561	594	636	java/lang/Exception
    //   467	500	642	java/lang/Exception
  }
  
  public static boolean f(Context paramContext)
  {
    paramContext = a(paramContext);
    if (paramContext != null) {
      return paramContext.getType() == 1;
    }
    return false;
  }
  
  public static boolean g(Context paramContext)
  {
    boolean bool3 = true;
    boolean bool1;
    if (a()) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool3;
      if (b()) {
        continue;
      }
      bool1 = bool3;
      if (a(paramContext, "ro.qq.istablet").equalsIgnoreCase("true")) {
        continue;
      }
      bool1 = bool3;
      if (a(paramContext, "ro.lenovo.device").equalsIgnoreCase("tablet")) {
        continue;
      }
      try
      {
        DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
        float f1 = localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi;
        float f2 = localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi;
        d1 = Math.pow(f1, 2.0D);
        d1 = Math.sqrt(Math.pow(f2, 2.0D) + d1);
        try
        {
          int i = ((TelephonyManager)paramContext.getSystemService("phone")).getPhoneType();
          if (i != 0) {
            break label221;
          }
          bool2 = false;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
            boolean bool2 = true;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("PhoneStatusTools", 2, "device size : " + d1 + ", hasTelephone : " + bool2);
        }
        if (d1 > 6.5D)
        {
          bool1 = bool3;
          if (!bool2) {
            continue;
          }
        }
        return false;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          double d1 = 0.0D;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusTools
 * JD-Core Version:    0.7.0.1
 */