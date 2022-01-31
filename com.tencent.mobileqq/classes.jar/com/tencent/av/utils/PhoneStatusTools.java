package com.tencent.av.utils;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
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
    return (paramContext != null) && (paramContext.getRingerMode() == 1);
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
    return (paramContext != null) && (paramContext.getRingerMode() == 2);
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
    return (paramContext != null) && (paramContext.getStreamVolume(2) == 0);
  }
  
  /* Error */
  public static boolean d(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 90
    //   3: invokevirtual 94	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 96	android/telephony/TelephonyManager
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull +215 -> 226
    //   14: aload_3
    //   15: invokevirtual 169	android/telephony/TelephonyManager:getCallState	()I
    //   18: ifeq +38 -> 56
    //   21: iconst_1
    //   22: istore_2
    //   23: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +28 -> 54
    //   29: ldc 176
    //   31: iconst_2
    //   32: new 178	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   39: ldc 181
    //   41: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: iload_2
    //   45: invokevirtual 188	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: iload_2
    //   55: ireturn
    //   56: getstatic 21	com/tencent/av/utils/PhoneStatusTools:a	Ljava/lang/Boolean;
    //   59: invokevirtual 198	java/lang/Boolean:booleanValue	()Z
    //   62: ifeq +69 -> 131
    //   65: aload_3
    //   66: ldc 200
    //   68: iconst_1
    //   69: anewarray 70	java/lang/Class
    //   72: dup
    //   73: iconst_0
    //   74: getstatic 106	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   77: aastore
    //   78: iconst_1
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: iconst_0
    //   85: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: invokestatic 114	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   92: checkcast 102	java/lang/Integer
    //   95: invokevirtual 203	java/lang/Integer:intValue	()I
    //   98: istore_1
    //   99: iload_1
    //   100: ifeq +31 -> 131
    //   103: iconst_1
    //   104: istore_2
    //   105: goto -82 -> 23
    //   108: astore 4
    //   110: iconst_0
    //   111: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   114: putstatic 21	com/tencent/av/utils/PhoneStatusTools:a	Ljava/lang/Boolean;
    //   117: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +11 -> 131
    //   123: ldc 176
    //   125: iconst_2
    //   126: ldc 205
    //   128: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: getstatic 23	com/tencent/av/utils/PhoneStatusTools:b	Ljava/lang/Boolean;
    //   134: invokevirtual 198	java/lang/Boolean:booleanValue	()Z
    //   137: ifeq +89 -> 226
    //   140: aload_3
    //   141: ldc 200
    //   143: iconst_1
    //   144: anewarray 70	java/lang/Class
    //   147: dup
    //   148: iconst_0
    //   149: getstatic 106	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   152: aastore
    //   153: iconst_1
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: iconst_1
    //   160: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: invokestatic 114	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   167: checkcast 102	java/lang/Integer
    //   170: invokevirtual 203	java/lang/Integer:intValue	()I
    //   173: istore_1
    //   174: iload_1
    //   175: ifeq +51 -> 226
    //   178: iconst_1
    //   179: istore_2
    //   180: goto -157 -> 23
    //   183: astore 4
    //   185: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq -57 -> 131
    //   191: ldc 176
    //   193: iconst_2
    //   194: ldc 207
    //   196: aload 4
    //   198: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   201: goto -70 -> 131
    //   204: astore_3
    //   205: iconst_0
    //   206: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   209: putstatic 23	com/tencent/av/utils/PhoneStatusTools:b	Ljava/lang/Boolean;
    //   212: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +11 -> 226
    //   218: ldc 176
    //   220: iconst_2
    //   221: ldc 212
    //   223: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: aload_0
    //   227: ldc 118
    //   229: invokevirtual 94	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   232: checkcast 96	android/telephony/TelephonyManager
    //   235: astore_0
    //   236: aload_0
    //   237: ifnull +187 -> 424
    //   240: aload_0
    //   241: invokevirtual 169	android/telephony/TelephonyManager:getCallState	()I
    //   244: ifeq +33 -> 277
    //   247: iconst_1
    //   248: istore_2
    //   249: goto -226 -> 23
    //   252: astore_3
    //   253: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq -30 -> 226
    //   259: ldc 176
    //   261: iconst_2
    //   262: ldc 214
    //   264: aload_3
    //   265: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   268: goto -42 -> 226
    //   271: astore_0
    //   272: aconst_null
    //   273: astore_0
    //   274: goto -38 -> 236
    //   277: getstatic 25	com/tencent/av/utils/PhoneStatusTools:c	Ljava/lang/Boolean;
    //   280: invokevirtual 198	java/lang/Boolean:booleanValue	()Z
    //   283: ifeq +58 -> 341
    //   286: aload_0
    //   287: ldc 200
    //   289: iconst_1
    //   290: anewarray 4	java/lang/Object
    //   293: dup
    //   294: iconst_0
    //   295: iconst_0
    //   296: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   299: aastore
    //   300: invokestatic 217	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   303: checkcast 102	java/lang/Integer
    //   306: invokevirtual 203	java/lang/Integer:intValue	()I
    //   309: istore_1
    //   310: iload_1
    //   311: ifeq +30 -> 341
    //   314: iconst_1
    //   315: istore_2
    //   316: goto -293 -> 23
    //   319: astore_3
    //   320: iconst_0
    //   321: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   324: putstatic 25	com/tencent/av/utils/PhoneStatusTools:c	Ljava/lang/Boolean;
    //   327: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   330: ifeq +11 -> 341
    //   333: ldc 176
    //   335: iconst_2
    //   336: ldc 219
    //   338: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: getstatic 27	com/tencent/av/utils/PhoneStatusTools:d	Ljava/lang/Boolean;
    //   344: invokevirtual 198	java/lang/Boolean:booleanValue	()Z
    //   347: ifeq +77 -> 424
    //   350: aload_0
    //   351: ldc 200
    //   353: iconst_1
    //   354: anewarray 4	java/lang/Object
    //   357: dup
    //   358: iconst_0
    //   359: iconst_1
    //   360: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   363: aastore
    //   364: invokestatic 217	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   367: checkcast 102	java/lang/Integer
    //   370: invokevirtual 203	java/lang/Integer:intValue	()I
    //   373: istore_1
    //   374: iload_1
    //   375: ifeq +49 -> 424
    //   378: iconst_1
    //   379: istore_2
    //   380: goto -357 -> 23
    //   383: astore_3
    //   384: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq -46 -> 341
    //   390: ldc 176
    //   392: iconst_2
    //   393: ldc 221
    //   395: aload_3
    //   396: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   399: goto -58 -> 341
    //   402: astore_0
    //   403: iconst_0
    //   404: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   407: putstatic 27	com/tencent/av/utils/PhoneStatusTools:d	Ljava/lang/Boolean;
    //   410: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   413: ifeq +11 -> 424
    //   416: ldc 176
    //   418: iconst_2
    //   419: ldc 223
    //   421: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   424: getstatic 29	com/tencent/av/utils/PhoneStatusTools:e	Ljava/lang/Boolean;
    //   427: invokevirtual 198	java/lang/Boolean:booleanValue	()Z
    //   430: ifeq +85 -> 515
    //   433: ldc 120
    //   435: ldc 122
    //   437: aconst_null
    //   438: aconst_null
    //   439: invokestatic 125	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
    //   442: ldc 224
    //   444: iconst_1
    //   445: anewarray 4	java/lang/Object
    //   448: dup
    //   449: iconst_0
    //   450: iconst_0
    //   451: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   454: aastore
    //   455: invokestatic 217	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   458: checkcast 102	java/lang/Integer
    //   461: invokevirtual 203	java/lang/Integer:intValue	()I
    //   464: istore_1
    //   465: iload_1
    //   466: ifeq +49 -> 515
    //   469: iconst_1
    //   470: istore_2
    //   471: goto -448 -> 23
    //   474: astore_0
    //   475: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq -54 -> 424
    //   481: ldc 176
    //   483: iconst_2
    //   484: ldc 226
    //   486: aload_0
    //   487: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   490: goto -66 -> 424
    //   493: astore_0
    //   494: iconst_0
    //   495: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   498: putstatic 29	com/tencent/av/utils/PhoneStatusTools:e	Ljava/lang/Boolean;
    //   501: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   504: ifeq +11 -> 515
    //   507: ldc 176
    //   509: iconst_2
    //   510: ldc 228
    //   512: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: getstatic 31	com/tencent/av/utils/PhoneStatusTools:f	Ljava/lang/Boolean;
    //   518: invokevirtual 198	java/lang/Boolean:booleanValue	()Z
    //   521: ifeq +86 -> 607
    //   524: ldc 120
    //   526: ldc 122
    //   528: aconst_null
    //   529: aconst_null
    //   530: invokestatic 125	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
    //   533: ldc 224
    //   535: iconst_1
    //   536: anewarray 4	java/lang/Object
    //   539: dup
    //   540: iconst_0
    //   541: iconst_1
    //   542: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   545: aastore
    //   546: invokestatic 217	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   549: checkcast 102	java/lang/Integer
    //   552: invokevirtual 203	java/lang/Integer:intValue	()I
    //   555: istore_1
    //   556: iload_1
    //   557: ifeq +8 -> 565
    //   560: iconst_1
    //   561: istore_2
    //   562: goto -539 -> 23
    //   565: iconst_0
    //   566: istore_2
    //   567: goto -544 -> 23
    //   570: astore_0
    //   571: iconst_0
    //   572: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   575: putstatic 31	com/tencent/av/utils/PhoneStatusTools:f	Ljava/lang/Boolean;
    //   578: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   581: ifeq +11 -> 592
    //   584: ldc 176
    //   586: iconst_2
    //   587: ldc 230
    //   589: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   592: iconst_0
    //   593: istore_2
    //   594: goto -571 -> 23
    //   597: astore_0
    //   598: iconst_0
    //   599: istore_2
    //   600: goto -577 -> 23
    //   603: astore_0
    //   604: goto -89 -> 515
    //   607: iconst_0
    //   608: istore_2
    //   609: goto -586 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	612	0	paramContext	Context
    //   98	459	1	i	int
    //   22	587	2	bool	boolean
    //   9	132	3	localTelephonyManager	TelephonyManager
    //   204	1	3	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   252	13	3	localException1	Exception
    //   319	1	3	localNoSuchMethodException2	java.lang.NoSuchMethodException
    //   383	13	3	localException2	Exception
    //   108	1	4	localNoSuchMethodException3	java.lang.NoSuchMethodException
    //   183	14	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   65	99	108	java/lang/NoSuchMethodException
    //   65	99	183	java/lang/Exception
    //   140	174	204	java/lang/NoSuchMethodException
    //   140	174	252	java/lang/Exception
    //   226	236	271	java/lang/Exception
    //   286	310	319	java/lang/NoSuchMethodException
    //   286	310	383	java/lang/Exception
    //   350	374	402	java/lang/NoSuchMethodException
    //   350	374	474	java/lang/Exception
    //   433	465	493	java/lang/NoSuchMethodException
    //   524	556	570	java/lang/NoSuchMethodException
    //   524	556	597	java/lang/Exception
    //   433	465	603	java/lang/Exception
  }
  
  public static boolean e(Context paramContext)
  {
    paramContext = a(paramContext);
    if (paramContext != null) {
      return paramContext.getType() == 1;
    }
    return false;
  }
  
  public static boolean f(Context paramContext)
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
            break label217;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusTools
 * JD-Core Version:    0.7.0.1
 */