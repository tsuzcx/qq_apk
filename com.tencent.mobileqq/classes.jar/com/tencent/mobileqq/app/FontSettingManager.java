package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class FontSettingManager
{
  private static float jdField_a_of_type_Float;
  public static DisplayMetrics a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.mobileqq:tool", "com.tencent.mobileqq:picture", "com.tencent.mobileqq:qqreader", "com.tencent.mobileqq:story", "com.tencent.mobileqq:qzone", "com.tencent.mobileqq:qwallet", "com.tencent.mobileqq:qqwifi", "com.tencent.mobileqq:qqfav", "com.tencent.mobileqq:dingdong", "com.tencent.mobileqq:buscard", "com.tencent.mobileqq:qqhotspot", "com.tencent.mobileqq" };
  public static DisplayMetrics b;
  private static final String[] b;
  
  static
  {
    jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    jdField_b_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    jdField_a_of_type_Float = 16.0F;
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "com.tencent.mobileqq:qqreader", "com.tencent.mobileqq:photoplus", "com.tencent.mobileqq:video" };
  }
  
  public static float a()
  {
    return jdField_a_of_type_Float;
  }
  
  /* Error */
  public static float a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +8 -> 9
    //   4: ldc 66
    //   6: fstore_1
    //   7: fload_1
    //   8: freturn
    //   9: getstatic 72	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   12: astore_3
    //   13: aload_3
    //   14: ifnonnull +240 -> 254
    //   17: new 74	java/util/Properties
    //   20: dup
    //   21: invokespecial 75	java/util/Properties:<init>	()V
    //   24: astore 4
    //   26: new 77	java/io/File
    //   29: dup
    //   30: new 79	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 86	android/content/Context:getFilesDir	()Ljava/io/File;
    //   41: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: ldc 92
    //   46: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 106	java/io/File:exists	()Z
    //   60: ifeq +177 -> 237
    //   63: new 108	java/io/FileInputStream
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: astore_3
    //   72: aload_3
    //   73: astore_0
    //   74: aload 4
    //   76: aload_3
    //   77: invokevirtual 115	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   80: aload_3
    //   81: astore_0
    //   82: aload 4
    //   84: ldc 117
    //   86: invokevirtual 121	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic 127	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   92: invokevirtual 130	java/lang/Float:floatValue	()F
    //   95: putstatic 51	com/tencent/mobileqq/app/FontSettingManager:jdField_a_of_type_Float	F
    //   98: aload_3
    //   99: astore_0
    //   100: getstatic 51	com/tencent/mobileqq/app/FontSettingManager:jdField_a_of_type_Float	F
    //   103: ldc 131
    //   105: fcmpg
    //   106: iflt +14 -> 120
    //   109: aload_3
    //   110: astore_0
    //   111: getstatic 51	com/tencent/mobileqq/app/FontSettingManager:jdField_a_of_type_Float	F
    //   114: ldc 132
    //   116: fcmpl
    //   117: ifle +10 -> 127
    //   120: aload_3
    //   121: astore_0
    //   122: ldc 49
    //   124: putstatic 51	com/tencent/mobileqq/app/FontSettingManager:jdField_a_of_type_Float	F
    //   127: aload_3
    //   128: astore_0
    //   129: getstatic 51	com/tencent/mobileqq/app/FontSettingManager:jdField_a_of_type_Float	F
    //   132: fstore_2
    //   133: aload_3
    //   134: invokevirtual 135	java/io/FileInputStream:close	()V
    //   137: fload_2
    //   138: freturn
    //   139: astore_0
    //   140: fload_2
    //   141: fstore_1
    //   142: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq -138 -> 7
    //   148: ldc 142
    //   150: iconst_2
    //   151: ldc 144
    //   153: aload_0
    //   154: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   157: fload_2
    //   158: freturn
    //   159: astore 4
    //   161: aconst_null
    //   162: astore_3
    //   163: aload_3
    //   164: astore_0
    //   165: aload 4
    //   167: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   170: aload_3
    //   171: astore_0
    //   172: ldc 49
    //   174: putstatic 51	com/tencent/mobileqq/app/FontSettingManager:jdField_a_of_type_Float	F
    //   177: aload_3
    //   178: astore_0
    //   179: getstatic 51	com/tencent/mobileqq/app/FontSettingManager:jdField_a_of_type_Float	F
    //   182: fstore_2
    //   183: aload_3
    //   184: invokevirtual 135	java/io/FileInputStream:close	()V
    //   187: fload_2
    //   188: freturn
    //   189: astore_0
    //   190: fload_2
    //   191: fstore_1
    //   192: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq -188 -> 7
    //   198: ldc 142
    //   200: iconst_2
    //   201: ldc 144
    //   203: aload_0
    //   204: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   207: fload_2
    //   208: freturn
    //   209: astore_3
    //   210: aconst_null
    //   211: astore_0
    //   212: aload_0
    //   213: invokevirtual 135	java/io/FileInputStream:close	()V
    //   216: aload_3
    //   217: athrow
    //   218: astore_0
    //   219: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq -6 -> 216
    //   225: ldc 142
    //   227: iconst_2
    //   228: ldc 144
    //   230: aload_0
    //   231: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   234: goto -18 -> 216
    //   237: ldc 49
    //   239: putstatic 51	com/tencent/mobileqq/app/FontSettingManager:jdField_a_of_type_Float	F
    //   242: ldc 49
    //   244: freturn
    //   245: astore_3
    //   246: goto -34 -> 212
    //   249: astore 4
    //   251: goto -88 -> 163
    //   254: aload_3
    //   255: astore_0
    //   256: goto -239 -> 17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramContext	Context
    //   6	186	1	f1	float
    //   132	76	2	f2	float
    //   12	172	3	localObject1	Object
    //   209	8	3	localObject2	Object
    //   245	10	3	localObject3	Object
    //   24	59	4	localProperties	java.util.Properties
    //   159	7	4	localIOException1	java.io.IOException
    //   249	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   133	137	139	java/lang/Exception
    //   63	72	159	java/io/IOException
    //   183	187	189	java/lang/Exception
    //   63	72	209	finally
    //   212	216	218	java/lang/Exception
    //   74	80	245	finally
    //   82	98	245	finally
    //   100	109	245	finally
    //   111	120	245	finally
    //   122	127	245	finally
    //   129	133	245	finally
    //   165	170	245	finally
    //   172	177	245	finally
    //   179	183	245	finally
    //   74	80	249	java/io/IOException
    //   82	98	249	java/io/IOException
    //   100	109	249	java/io/IOException
    //   111	120	249	java/io/IOException
    //   122	127	249	java/io/IOException
    //   129	133	249	java/io/IOException
  }
  
  public static void a()
  {
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      a(BaseApplicationImpl.getContext(), str);
      i += 1;
    }
  }
  
  public static void a(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    paramContext.density = jdField_b_of_type_AndroidUtilDisplayMetrics.density;
    paramContext.scaledDensity = jdField_b_of_type_AndroidUtilDisplayMetrics.density;
    paramContext.densityDpi = jdField_b_of_type_AndroidUtilDisplayMetrics.densityDpi;
  }
  
  /* Error */
  public static void a(Context paramContext, float paramFloat)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ifnonnull +4 -> 7
    //   6: return
    //   7: getstatic 72	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +167 -> 179
    //   15: new 74	java/util/Properties
    //   18: dup
    //   19: invokespecial 75	java/util/Properties:<init>	()V
    //   22: astore 4
    //   24: new 77	java/io/File
    //   27: dup
    //   28: new 79	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   35: aload_0
    //   36: invokevirtual 86	android/content/Context:getFilesDir	()Ljava/io/File;
    //   39: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   42: ldc 92
    //   44: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 106	java/io/File:exists	()Z
    //   58: ifne +8 -> 66
    //   61: aload_0
    //   62: invokevirtual 183	java/io/File:createNewFile	()Z
    //   65: pop
    //   66: aload 4
    //   68: ldc 117
    //   70: fload_1
    //   71: invokestatic 186	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   74: invokevirtual 190	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: new 192	java/io/FileOutputStream
    //   81: dup
    //   82: aload_0
    //   83: invokevirtual 195	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   86: invokespecial 196	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   89: astore_2
    //   90: aload_2
    //   91: astore_0
    //   92: aload 4
    //   94: aload_2
    //   95: aconst_null
    //   96: invokevirtual 200	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   99: aload_2
    //   100: ifnull -94 -> 6
    //   103: aload_2
    //   104: invokevirtual 201	java/io/FileOutputStream:close	()V
    //   107: return
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   113: return
    //   114: astore_2
    //   115: aload_2
    //   116: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   119: goto -53 -> 66
    //   122: astore_3
    //   123: aconst_null
    //   124: astore_2
    //   125: aload_2
    //   126: astore_0
    //   127: aload_3
    //   128: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   131: aload_2
    //   132: ifnull -126 -> 6
    //   135: aload_2
    //   136: invokevirtual 201	java/io/FileOutputStream:close	()V
    //   139: return
    //   140: astore_0
    //   141: aload_0
    //   142: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   145: return
    //   146: astore_0
    //   147: aload_3
    //   148: astore_2
    //   149: aload_2
    //   150: ifnull +7 -> 157
    //   153: aload_2
    //   154: invokevirtual 201	java/io/FileOutputStream:close	()V
    //   157: aload_0
    //   158: athrow
    //   159: astore_2
    //   160: aload_2
    //   161: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   164: goto -7 -> 157
    //   167: astore_3
    //   168: aload_0
    //   169: astore_2
    //   170: aload_3
    //   171: astore_0
    //   172: goto -23 -> 149
    //   175: astore_3
    //   176: goto -51 -> 125
    //   179: aload_2
    //   180: astore_0
    //   181: goto -166 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramContext	Context
    //   0	184	1	paramFloat	float
    //   10	94	2	localObject1	Object
    //   114	2	2	localIOException1	java.io.IOException
    //   124	30	2	localIOException2	java.io.IOException
    //   159	2	2	localIOException3	java.io.IOException
    //   169	11	2	localContext	Context
    //   1	1	3	localObject2	Object
    //   122	26	3	localIOException4	java.io.IOException
    //   167	4	3	localObject3	Object
    //   175	1	3	localIOException5	java.io.IOException
    //   22	71	4	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   103	107	108	java/io/IOException
    //   61	66	114	java/io/IOException
    //   66	90	122	java/io/IOException
    //   135	139	140	java/io/IOException
    //   66	90	146	finally
    //   153	157	159	java/io/IOException
    //   92	99	167	finally
    //   127	131	167	finally
    //   92	99	175	java/io/IOException
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    Resources localResources = paramContext.getResources();
    if ((localResources != null) && ((Math.abs(jdField_b_of_type_AndroidUtilDisplayMetrics.density - localResources.getDisplayMetrics().density) > 0.01F) || (Math.abs(jdField_b_of_type_AndroidUtilDisplayMetrics.scaledDensity - localResources.getDisplayMetrics().scaledDensity) > 0.01F) || (jdField_b_of_type_AndroidUtilDisplayMetrics.densityDpi != localResources.getDisplayMetrics().densityDpi)))
    {
      jdField_a_of_type_AndroidUtilDisplayMetrics.setTo(localResources.getDisplayMetrics());
      if (QLog.isColorLevel()) {
        QLog.i("FontSettingManager", 2, "current density: " + jdField_a_of_type_AndroidUtilDisplayMetrics.density + ", custom density: " + jdField_b_of_type_AndroidUtilDisplayMetrics.density);
      }
      b(paramContext, paramBoolean1, paramBoolean2);
    }
  }
  
  private static void a(DisplayMetrics paramDisplayMetrics)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo(paramDisplayMetrics);
    localDisplayMetrics.density = jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    localDisplayMetrics.scaledDensity = jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity;
    localDisplayMetrics.densityDpi = jdField_a_of_type_AndroidUtilDisplayMetrics.densityDpi;
    if (QLog.isColorLevel())
    {
      QLog.d("FontSettingManager", 2, "systemMetrics.density : " + jdField_a_of_type_AndroidUtilDisplayMetrics.density);
      QLog.d("FontSettingManager", 2, "systemMetrics.scaledDensity : " + jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity);
      QLog.d("FontSettingManager", 2, "systemMetrics.densityDpi : " + jdField_a_of_type_AndroidUtilDisplayMetrics.densityDpi);
    }
    jdField_a_of_type_AndroidUtilDisplayMetrics = localDisplayMetrics;
  }
  
  public static boolean a()
  {
    String str1 = DeviceInfoUtil.i();
    String str2 = DeviceInfoUtil.e();
    if (QLog.isColorLevel()) {
      QLog.d("FontSettingManager", 2, "current machine brandName:" + str1 + ", modelName:" + str2);
    }
    if (((str1.equals("OPPO")) && (str2.equals("R815T"))) || ((str1.equals("PHILIPS")) && (str2.equals("W6500"))) || ((str1.equals("KONKA")) && (str2.equals("K5"))) || ((str1.equals("Sony")) && (str2.equals("S39h"))) || ((str1.equals("Meitu")) && (str2.equals("MK150"))) || ((str1.equals("GiONEE")) && (str2.equals("GN137"))) || ((str1.equals("GiONEE")) && (str2.equals("GN705T"))) || ((str1.equals("GiONEE")) && (str2.equals("GN708T"))) || ((str1.equals("GiONEE")) && (str2.equals("E3T"))) || ((str1.equals("alps")) && (str2.equals("K5"))) || ((str1.equals("Xiaomi")) && (str2.equals("Mi-4c"))) || ((str1.equals("Xiaomi")) && (str2.equals("MI 4S"))) || ((str1.equals("Xiaomi")) && (str2.equals("MI NOTE Pro"))) || ((str1.equals("Huawei")) && (str2.equals("Nexus 6P"))) || ((str1.equals("BBK")) && (str2.equals("vivo X3S W"))) || ((str1.equals("LGE")) && (str2.equals("Nexus 5X")))) {}
    while ((str2.equals("vivo Y13")) || (str2.equals("vivo X3t")) || (str2.equals("vivo Y11i T")) || (str2.equals("MI-ONE Plus")) || (str2.equals("vivoY11iT")) || (str2.equals("Coolpad 7270")) || (str2.equals("Coolpad 8122")) || (str2.equals("Lenovo A708T")) || (str2.equals("Lenovo S820")) || (str2.equals("Lenovo S898t")) || (str2.equals("GT-I9050")) || (str2.equals("GT-S7568")) || (str2.equals("DOOV S2y")) || (str2.equals("TCL J928")) || (str2.equals("vivo Y22")) || (str2.equals("ChanghongZ8t")) || (str2.equals("HUAWEI Y516-T00")) || (str2.equals("Lenovo A678t")) || (str2.equals("K-Touch T60")) || (str2.equals("vivo X710L")) || (str2.equals("HM MOTE 1TD")) || (str2.equals("Redmi 3"))) {
      return false;
    }
    return true;
  }
  
  private static boolean a(float paramFloat)
  {
    return (paramFloat > 13.82F) && (paramFloat < 18.1F);
  }
  
  private static boolean a(Context paramContext)
  {
    paramContext = BaseApplicationImpl.processName;
    String[] arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramContext)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean a(Context paramContext, float paramFloat, boolean paramBoolean)
  {
    if (!a(paramFloat)) {
      if (QLog.isColorLevel()) {
        QLog.d("FontSettingManager", 2, "wrong scale vale : " + paramFloat);
      }
    }
    do
    {
      DisplayMetrics localDisplayMetrics;
      do
      {
        return false;
        float f = paramFloat / 16.0F;
        localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
        a(localDisplayMetrics);
        localDisplayMetrics.density = (jdField_a_of_type_AndroidUtilDisplayMetrics.density * f);
        localDisplayMetrics.scaledDensity = (jdField_a_of_type_AndroidUtilDisplayMetrics.density * f);
        localDisplayMetrics.densityDpi = ((int)(f * jdField_a_of_type_AndroidUtilDisplayMetrics.densityDpi));
        if (QLog.isColorLevel()) {
          QLog.d("FontSettingManager", 2, localDisplayMetrics.density + ", " + localDisplayMetrics.scaledDensity + ", " + localDisplayMetrics.densityDpi);
        }
      } while (!paramBoolean);
      jdField_b_of_type_AndroidUtilDisplayMetrics.setTo(localDisplayMetrics);
    } while (jdField_a_of_type_Float == paramFloat);
    jdField_a_of_type_Float = paramFloat;
    a(paramContext, paramFloat);
    return true;
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.processName.equals(paramString))
      {
        Process.killProcess(localRunningAppProcessInfo.pid);
        return true;
      }
    }
    return false;
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext.getResources().getDisplayMetrics().density != jdField_a_of_type_AndroidUtilDisplayMetrics.density) {
      a(paramContext, 16.0F, true);
    }
  }
  
  public static void b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!a(paramContext))
    {
      jdField_b_of_type_AndroidUtilDisplayMetrics.setTo(paramContext.getResources().getDisplayMetrics());
      return;
    }
    if (paramBoolean1) {}
    for (float f = jdField_a_of_type_Float;; f = a(paramContext))
    {
      a(paramContext, f, paramBoolean2);
      return;
    }
  }
  
  public static boolean b()
  {
    String str1 = DeviceInfoUtil.i();
    String str2 = DeviceInfoUtil.e();
    if (QLog.isColorLevel()) {
      QLog.d("FontSettingManager", 2, "current machine brandName:" + str1 + ", modelName:" + str2);
    }
    return ((!str1.equals("Xiaomi")) || (!str2.equals("MI 4S"))) && ((!str1.equals("Huawei")) || (!str2.equals("Nexus 6P"))) && ((!str1.equals("BBK")) || (!str2.equals("vivo X3S W"))) && ((!str1.equals("LGE")) || (!str2.equals("Nexus 5X"))) && (!str2.equals("Redmi 3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FontSettingManager
 * JD-Core Version:    0.7.0.1
 */