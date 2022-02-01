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
import com.tencent.mobileqq.utils.kapalaiadapter.ReflecterHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class PhoneStatusTools
{
  static Boolean a;
  static Boolean b;
  static Boolean c;
  static Boolean d;
  static Boolean e;
  static Boolean f;
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(true);
    a = localBoolean;
    b = localBoolean;
    c = localBoolean;
    d = localBoolean;
    e = localBoolean;
    f = localBoolean;
  }
  
  public static int a(Context paramContext)
  {
    int i = NetworkUtil.getSystemNetwork(paramContext);
    if (i == 1) {
      return 0;
    }
    if (i == 4) {
      return 1;
    }
    if (i == 3) {
      return 2;
    }
    if (i == 2) {
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
    catch (Exception paramContext)
    {
      label50:
      break label50;
    }
    return "";
  }
  
  /* Error */
  public static void a(Context paramContext, android.telephony.PhoneStateListener paramPhoneStateListener, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 91
    //   3: invokevirtual 95	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 97	android/telephony/TelephonyManager
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull +140 -> 151
    //   14: aload_3
    //   15: ldc 99
    //   17: iconst_2
    //   18: anewarray 71	java/lang/Class
    //   21: dup
    //   22: iconst_0
    //   23: ldc 101
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: getstatic 107	java/lang/Integer:TYPE	Ljava/lang/Class;
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
    //   43: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: aastore
    //   47: invokestatic 115	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: aload_3
    //   52: ldc 117
    //   54: iconst_3
    //   55: anewarray 71	java/lang/Class
    //   58: dup
    //   59: iconst_0
    //   60: getstatic 107	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: ldc 101
    //   68: aastore
    //   69: dup
    //   70: iconst_2
    //   71: getstatic 107	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   74: aastore
    //   75: iconst_3
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: iconst_0
    //   82: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload_1
    //   89: aastore
    //   90: dup
    //   91: iconst_2
    //   92: iload_2
    //   93: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: aastore
    //   97: invokestatic 115	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: aload_3
    //   102: ldc 117
    //   104: iconst_3
    //   105: anewarray 71	java/lang/Class
    //   108: dup
    //   109: iconst_0
    //   110: getstatic 107	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: ldc 101
    //   118: aastore
    //   119: dup
    //   120: iconst_2
    //   121: getstatic 107	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   124: aastore
    //   125: iconst_3
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: iconst_1
    //   132: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: aload_1
    //   139: aastore
    //   140: dup
    //   141: iconst_2
    //   142: iload_2
    //   143: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: aastore
    //   147: invokestatic 115	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: aload_0
    //   152: ldc 119
    //   154: invokevirtual 95	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   157: checkcast 97	android/telephony/TelephonyManager
    //   160: astore_0
    //   161: goto +5 -> 166
    //   164: aconst_null
    //   165: astore_0
    //   166: aload_0
    //   167: ifnull +140 -> 307
    //   170: aload_0
    //   171: ldc 99
    //   173: iconst_2
    //   174: anewarray 71	java/lang/Class
    //   177: dup
    //   178: iconst_0
    //   179: ldc 101
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: getstatic 107	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   187: aastore
    //   188: iconst_2
    //   189: anewarray 4	java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: aload_1
    //   195: aastore
    //   196: dup
    //   197: iconst_1
    //   198: iload_2
    //   199: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   202: aastore
    //   203: invokestatic 115	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   206: pop
    //   207: aload_0
    //   208: ldc 117
    //   210: iconst_3
    //   211: anewarray 71	java/lang/Class
    //   214: dup
    //   215: iconst_0
    //   216: getstatic 107	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: ldc 101
    //   224: aastore
    //   225: dup
    //   226: iconst_2
    //   227: getstatic 107	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   230: aastore
    //   231: iconst_3
    //   232: anewarray 4	java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: iconst_0
    //   238: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   241: aastore
    //   242: dup
    //   243: iconst_1
    //   244: aload_1
    //   245: aastore
    //   246: dup
    //   247: iconst_2
    //   248: iload_2
    //   249: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   252: aastore
    //   253: invokestatic 115	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   256: pop
    //   257: aload_0
    //   258: ldc 117
    //   260: iconst_3
    //   261: anewarray 71	java/lang/Class
    //   264: dup
    //   265: iconst_0
    //   266: getstatic 107	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   269: aastore
    //   270: dup
    //   271: iconst_1
    //   272: ldc 101
    //   274: aastore
    //   275: dup
    //   276: iconst_2
    //   277: getstatic 107	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   280: aastore
    //   281: iconst_3
    //   282: anewarray 4	java/lang/Object
    //   285: dup
    //   286: iconst_0
    //   287: iconst_1
    //   288: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   291: aastore
    //   292: dup
    //   293: iconst_1
    //   294: aload_1
    //   295: aastore
    //   296: dup
    //   297: iconst_2
    //   298: iload_2
    //   299: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   302: aastore
    //   303: invokestatic 115	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   306: pop
    //   307: ldc 121
    //   309: ldc 123
    //   311: aconst_null
    //   312: aconst_null
    //   313: invokestatic 126	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
    //   316: ldc 99
    //   318: iconst_2
    //   319: anewarray 71	java/lang/Class
    //   322: dup
    //   323: iconst_0
    //   324: ldc 101
    //   326: aastore
    //   327: dup
    //   328: iconst_1
    //   329: getstatic 107	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   332: aastore
    //   333: iconst_2
    //   334: anewarray 4	java/lang/Object
    //   337: dup
    //   338: iconst_0
    //   339: aload_1
    //   340: aastore
    //   341: dup
    //   342: iconst_1
    //   343: iload_2
    //   344: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   347: aastore
    //   348: invokestatic 115	com/tencent/mobileqq/utils/kapalaiadapter/ReflecterHelper:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   351: pop
    //   352: return
    //   353: astore_0
    //   354: return
    //   355: astore_3
    //   356: goto -205 -> 151
    //   359: astore_0
    //   360: goto -196 -> 164
    //   363: astore_0
    //   364: goto -57 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	paramContext	Context
    //   0	367	1	paramPhoneStateListener	android.telephony.PhoneStateListener
    //   0	367	2	paramInt	int
    //   9	93	3	localTelephonyManager	TelephonyManager
    //   355	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	10	353	java/lang/Exception
    //   307	352	353	java/lang/Exception
    //   14	151	355	java/lang/Exception
    //   151	161	359	java/lang/Exception
    //   170	307	363	java/lang/Exception
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
    String str = Build.MODEL;
    if ("samsung".equalsIgnoreCase(Build.MANUFACTURER)) {
      return ("SM-T805C".equalsIgnoreCase(str)) || ("SM-T800".equalsIgnoreCase(str));
    }
    return false;
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
    int i;
    try
    {
      i = Settings.System.getInt((ContentResolver)localObject, "accelerometer_rotation", 1);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i = 1;
    }
    return i != 1;
  }
  
  public static boolean d(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getStreamVolume(2) == 0);
  }
  
  private static boolean e()
  {
    boolean bool = e.booleanValue();
    Boolean localBoolean = Boolean.valueOf(false);
    if (bool) {}
    try
    {
      i = ((Integer)ReflecterHelper.a(ReflecterHelper.a("android.telephony.MSimTelephonyManager", "getDefault", null, null), "getCallState", new Object[] { Integer.valueOf(0) })).intValue();
      if (i == 0) {
        break label75;
      }
      return true;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      int i;
      break label57;
    }
    catch (Exception localException2)
    {
      label54:
      break label54;
    }
    break label75;
    label57:
    e = localBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusTools", 2, "5 isCalling NoSuchMethodException[getCallState]");
    }
    label75:
    if (f.booleanValue()) {}
    try
    {
      i = ((Integer)ReflecterHelper.a(ReflecterHelper.a("android.telephony.MSimTelephonyManager", "getDefault", null, null), "getCallState", new Object[] { Integer.valueOf(1) })).intValue();
      if (i == 0) {
        break label140;
      }
      return true;
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      label122:
      break label122;
    }
    catch (Exception localException1) {}
    f = localBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusTools", 2, "6 isCalling NoSuchMethodException[getCallState]");
    }
    label140:
    return false;
    return false;
  }
  
  public static boolean e(Context paramContext)
  {
    if (paramContext == null)
    {
      QLog.w("PhoneStatusTools", 1, "isCalling, context为null");
      return false;
    }
    boolean bool2 = h(paramContext);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = i(paramContext);
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = e();
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isCalling: ");
      paramContext.append(bool2);
      QLog.d("PhoneStatusTools", 2, paramContext.toString());
    }
    return bool2;
  }
  
  public static boolean f(Context paramContext)
  {
    paramContext = a(paramContext);
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
  
  public static boolean g(Context paramContext)
  {
    if (a()) {
      return false;
    }
    if (b()) {
      return true;
    }
    if (a(paramContext, "ro.qq.istablet").equalsIgnoreCase("true")) {
      return true;
    }
    if (a(paramContext, "ro.lenovo.device").equalsIgnoreCase("tablet")) {
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
      QLog.d("PhoneStatusTools", 2, paramContext.toString());
    }
    return (d1 > 6.5D) && (!bool);
  }
  
  private static boolean h(Context paramContext)
  {
    localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    paramContext = Boolean.valueOf(false);
    if (localTelephonyManager != null) {}
    try
    {
      i = localTelephonyManager.getCallState();
    }
    catch (Throwable localNoSuchMethodException2)
    {
      try
      {
        i = ((Integer)ReflecterHelper.a(localTelephonyManager, "getCallStateGemini", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) })).intValue();
        if (i == 0) {
          break label130;
        }
        return true;
      }
      catch (Exception localException)
      {
        break label92;
        break label111;
        if (!QLog.isColorLevel()) {
          break label130;
        }
        QLog.d("PhoneStatusTools", 2, "1 isCalling getCallStateGemini Exception", localException);
        break label130;
        a = paramContext;
        if (!QLog.isColorLevel()) {
          break label130;
        }
        QLog.d("PhoneStatusTools", 2, "1 isCalling NoSuchMethodException[getCallStateGemini]");
        if (!b.booleanValue()) {
          break label224;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        try
        {
          int i = ((Integer)ReflecterHelper.a(localTelephonyManager, "getCallStateGemini", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) })).intValue();
          if (i == 0) {
            break label224;
          }
          return true;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.d("PhoneStatusTools", 2, "2 isCalling getCallStateGemini Exception", paramContext);
              return false;
              b = paramContext;
              if (QLog.isColorLevel()) {
                QLog.d("PhoneStatusTools", 2, "2 isCalling NoSuchMethodException[getCallStateGemini]");
              }
            }
            return false;
            localThrowable = localThrowable;
          }
          localNoSuchMethodException2 = localNoSuchMethodException2;
        }
        catch (NoSuchMethodException localNoSuchMethodException1)
        {
          break label184;
        }
      }
    }
    i = 0;
    if (i != 0) {
      return true;
    }
    if (!a.booleanValue()) {}
  }
  
  private static boolean i(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone2");
    }
    catch (Exception localNoSuchMethodException)
    {
      try
      {
        i = paramContext.getCallState();
        break label29;
        i = 0;
        label29:
        if (i == 0) {
          break label35;
        }
        return true;
        label35:
        if (!c.booleanValue()) {
          break label123;
        }
      }
      catch (Throwable localNoSuchMethodException)
      {
        try
        {
          i = ((Integer)ReflecterHelper.a(paramContext, "getCallStateGemini", new Object[] { Integer.valueOf(0) })).intValue();
          if (i == 0) {
            break label123;
          }
          return true;
        }
        catch (Exception localException)
        {
          break label82;
          break label101;
          if (!QLog.isColorLevel()) {
            break label123;
          }
          QLog.d("PhoneStatusTools", 2, "3 isCalling getCallStateGemini Exception", localException);
          break label123;
          c = Boolean.valueOf(false);
          if (!QLog.isColorLevel()) {
            break label123;
          }
          QLog.d("PhoneStatusTools", 2, "3 isCalling NoSuchMethodException[getCallStateGemini]");
          if (!d.booleanValue()) {
            break label210;
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          try
          {
            label82:
            label101:
            label123:
            int i = ((Integer)ReflecterHelper.a(paramContext, "getCallStateGemini", new Object[] { Integer.valueOf(1) })).intValue();
            if (i == 0) {
              break label210;
            }
            return true;
          }
          catch (Exception paramContext)
          {
            for (;;)
            {
              if (QLog.isColorLevel())
              {
                QLog.d("PhoneStatusTools", 2, "4 isCalling getCallStateGemini Exception", paramContext);
                return false;
                d = Boolean.valueOf(false);
                if (QLog.isColorLevel()) {
                  QLog.d("PhoneStatusTools", 2, "4 isCalling NoSuchMethodException[getCallStateGemini]");
                }
              }
              return false;
              paramContext = paramContext;
              continue;
              localThrowable = localThrowable;
            }
            localNoSuchMethodException = localNoSuchMethodException;
          }
          catch (NoSuchMethodException paramContext)
          {
            label167:
            label210:
            break label167;
          }
        }
      }
    }
    paramContext = null;
    if (paramContext == null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusTools
 * JD-Core Version:    0.7.0.1
 */