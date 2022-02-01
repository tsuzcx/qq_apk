package com.tencent.kingkong;

import adax;
import aday;
import adaz;
import adbk;
import adbl;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class Common
{
  public static adbl a;
  public static Context a;
  public static SharedPreferences.Editor a;
  public static SharedPreferences a;
  public static String a;
  public static boolean a;
  public static String b;
  public static boolean b;
  public static String c;
  public static boolean c;
  public static String d = File.separator;
  public static String e = "";
  public static String f = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
    jdField_c_of_type_JavaLangString = "";
  }
  
  public static void EvilReportFromNative(int paramInt, String paramString1, String paramString2)
  {
    adax.a("KingKongCommon", "Evil Report " + paramString1 + ", " + paramString2);
    ReportUtil.a(paramInt, 0, 0, "&str1=" + paramString1 + "&str2=" + paramString2);
  }
  
  public static void NotificationFromNative(int paramInt1, int paramInt2, int paramInt3)
  {
    adax.a("KingKongCommon", "Notification From Native " + paramInt1 + ", " + paramInt2 + ", " + paramInt3);
    ReportUtil.a(paramInt1, paramInt2, paramInt3, "");
  }
  
  /* Error */
  public static void OnLogin(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 87	com/tencent/kingkong/Common:SetContext	(Landroid/content/Context;)V
    //   7: getstatic 89	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnonnull +7 -> 19
    //   15: ldc 2
    //   17: monitorexit
    //   18: return
    //   19: aload_1
    //   20: invokestatic 93	com/tencent/kingkong/Common:SetQQUni	(Ljava/lang/String;)V
    //   23: invokestatic 99	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   26: new 101	com/tencent/kingkong/Common$1
    //   29: dup
    //   30: invokespecial 102	com/tencent/kingkong/Common$1:<init>	()V
    //   33: ldc2_w 103
    //   36: invokevirtual 110	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   39: pop
    //   40: goto -25 -> 15
    //   43: astore_0
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	paramContext	Context
    //   0	49	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	11	43	finally
    //   19	40	43	finally
  }
  
  public static void SetContext(Context paramContext)
  {
    if ((paramContext != null) && (jdField_a_of_type_AndroidContentContext == null))
    {
      jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
      adaz.a(jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public static void SetDPCStatus(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0).edit();
    paramContext.putBoolean("DPC_STATUS", paramBoolean);
    paramContext.commit();
  }
  
  public static void SetQQUni(String paramString)
  {
    adaz.a(paramString);
  }
  
  /* Error */
  public static void SetSafeStatus(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 152	com/tencent/kingkong/Common:a	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 89	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   18: ifnull -7 -> 11
    //   21: iload_0
    //   22: ifeq -11 -> 11
    //   25: getstatic 154	com/tencent/kingkong/Common:jdField_a_of_type_Boolean	Z
    //   28: ifne -17 -> 11
    //   31: getstatic 156	com/tencent/kingkong/Common:jdField_b_of_type_Boolean	Z
    //   34: ifne -23 -> 11
    //   37: iconst_1
    //   38: putstatic 156	com/tencent/kingkong/Common:jdField_b_of_type_Boolean	Z
    //   41: invokestatic 158	com/tencent/kingkong/Common:b	()V
    //   44: new 160	com/tencent/kingkong/Common$2
    //   47: dup
    //   48: invokespecial 161	com/tencent/kingkong/Common$2:<init>	()V
    //   51: bipush 16
    //   53: aconst_null
    //   54: iconst_1
    //   55: invokestatic 165	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   58: goto -47 -> 11
    //   61: astore_2
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_2
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramBoolean	boolean
    //   6	2	1	bool	boolean
    //   61	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	61	finally
    //   15	21	61	finally
    //   25	58	61	finally
  }
  
  public static int a()
  {
    return jdField_a_of_type_AndroidContentSharedPreferences.getInt("INITIALIZE_STATUS", 0);
  }
  
  public static int a(String paramString, ArrayList<String> paramArrayList)
  {
    int j = jdField_a_of_type_AndroidContentSharedPreferences.getInt(a("FINGERPRINT_LIB_COUNT", paramString), -1);
    if ((j == -1) || (j != paramArrayList.size()))
    {
      adax.a("KingKongCommon", "Library count mismatch " + j + ", " + paramArrayList.size());
      return -1;
    }
    int i = 0;
    while (i < j)
    {
      String str1 = jdField_a_of_type_AndroidContentSharedPreferences.getString(a("FINGERPRINT_LIB", paramString, i), "");
      if (!((String)paramArrayList.get(i)).equals(str1))
      {
        adax.a("KingKongCommon", "Library name mismatch " + str1 + ", " + (String)paramArrayList.get(i));
        return -1;
      }
      String str2 = adbk.b(str1);
      if (TextUtils.isEmpty(str2))
      {
        adax.a("KingKongCommon", "Unable to get file SHA1 " + str1);
        return -1;
      }
      String str3 = jdField_a_of_type_AndroidContentSharedPreferences.getString(a("FINGERPRINT_LIB_SHA1", paramString, i), "");
      if (!str3.equals(str2))
      {
        adax.a("KingKongCommon", "Library SHA1 mismatch " + str1 + ", " + str3 + ", " + str2);
        return -1;
      }
      i += 1;
    }
    return jdField_a_of_type_AndroidContentSharedPreferences.getInt(a("SUBPATCH_INDEX", paramString), -1);
  }
  
  public static String a()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  public static String a(String paramString)
  {
    return jdField_b_of_type_JavaLangString + d + paramString;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  private static String a(String paramString1, String paramString2, int paramInt)
  {
    return paramString1 + "_" + paramString2 + "_" + paramInt;
  }
  
  public static void a()
  {
    int i = b();
    StringBuffer localStringBuffer = new StringBuffer();
    int j = d();
    try
    {
      localStringBuffer.append("&str1=").append(URLEncoder.encode(Integer.toString(i), "UTF-8")).append("&str2=").append(URLEncoder.encode(Integer.toString(j), "UTF-8"));
      ReportUtil.a(2087, 0, 0, localStringBuffer.toString());
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("INITIALIZE_STATUS", paramInt);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      ReportUtil.a(paramInt, 0, 0, "&str1=" + URLEncoder.encode(paramString1, "UTF-8") + "&str3=" + URLEncoder.encode(paramString2, "UTF-8"));
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    adax.a("KingKongCommon", "Do patch " + paramInt + ", " + paramString1 + ", " + paramString2 + ", " + paramString3 + ", " + paramString4);
    String str = a("DO_PATCH", paramString1, paramInt);
    if (!jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(str, false)) {}
    try
    {
      ReportUtil.a(2081, paramInt, 0, "&str1=" + URLEncoder.encode(paramString1, "UTF-8") + "&str2=" + URLEncoder.encode(paramString2, "UTF-8") + "&str3=" + URLEncoder.encode(paramString3, "UTF-8") + "&v1=" + URLEncoder.encode(paramString4, "UTF-8"));
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean(str, true);
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt, ArrayList<String> paramArrayList)
  {
    int j = paramArrayList.size();
    if (j > 15) {
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label90;
      }
      String str1 = (String)paramArrayList.get(i);
      String str2 = adbk.b(str1);
      if (TextUtils.isEmpty(str2)) {
        break;
      }
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString(a("FINGERPRINT_LIB_SHA1", paramString, i), str2);
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString(a("FINGERPRINT_LIB", paramString, i), str1);
      i += 1;
    }
    label90:
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(a("FINGERPRINT_LIB_COUNT", paramString), j);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(a("SUBPATCH_INDEX", paramString), paramInt);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public static void a(String paramString, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1.length != paramArrayOfInt2.length) || (paramArrayOfInt1.length > 15) || (paramArrayOfInt1.length != paramInt))
    {
      adax.a("KingKongCommon", "Params count mismatch : " + paramArrayOfInt1.length + ", " + paramArrayOfInt2.length + ", " + paramInt);
      return;
    }
    int i = 0;
    while (i < paramInt)
    {
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(a("JUMPER", paramString, i), paramArrayOfInt1[i]);
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(a("GOTHOOK", paramString, i), paramArrayOfInt2[i]);
      i += 1;
    }
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(a("HOOKPOINT_COUNT", paramString), paramInt);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (aday.a += 1;; aday.a = 0)
    {
      d(aday.a);
      return;
    }
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT < 14) {
      return false;
    }
    return Build.CPU_ABI.contains("armeabi");
  }
  
  public static boolean a(String paramString)
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 13) {
        break;
      }
      String str = a("DO_PATCH", paramString, i);
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(str);
      i += 1;
    }
    while (j < 15)
    {
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(a("FINGERPRINT_LIB", paramString, j));
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(a("FINGERPRINT_LIB_SHA1", paramString, j));
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(a("GOTHOOK", paramString, j));
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(a("JUMPER", paramString, j));
      j += 1;
    }
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(a("FINGERPRINT_LIB_COUNT", paramString));
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(a("SUBPATCH_INDEX", paramString));
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(a("HOOKPOINT_COUNT", paramString));
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
    return true;
  }
  
  public static int[] a(String paramString)
  {
    int j = jdField_a_of_type_AndroidContentSharedPreferences.getInt(a("HOOKPOINT_COUNT", paramString), -1);
    if (j == -1) {
      return null;
    }
    int[] arrayOfInt = new int[j];
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return arrayOfInt;
      }
      arrayOfInt[i] = jdField_a_of_type_AndroidContentSharedPreferences.getInt(a("GOTHOOK", paramString, i), -1);
      if (arrayOfInt[i] == -1) {
        break;
      }
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static int b()
  {
    return jdField_a_of_type_AndroidContentSharedPreferences.getInt("POINT_LOG_CRASH_COUNT", 0);
  }
  
  public static String b()
  {
    return jdField_c_of_type_JavaLangString;
  }
  
  public static String b(String paramString)
  {
    return jdField_c_of_type_JavaLangString + d + paramString;
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 325	com/tencent/kingkong/Common:jdField_c_of_type_Boolean	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 325	com/tencent/kingkong/Common:jdField_c_of_type_Boolean	Z
    //   19: getstatic 89	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   22: ldc 124
    //   24: iconst_0
    //   25: invokevirtual 128	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   28: putstatic 168	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   31: getstatic 168	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   34: invokeinterface 134 1 0
    //   39: putstatic 261	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentSharedPreferences$Editor	Landroid/content/SharedPreferences$Editor;
    //   42: getstatic 89	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   45: invokevirtual 329	android/content/Context:getFilesDir	()Ljava/io/File;
    //   48: invokevirtual 332	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: putstatic 22	com/tencent/kingkong/Common:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   54: new 47	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   61: getstatic 22	com/tencent/kingkong/Common:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   64: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 33	com/tencent/kingkong/Common:d	Ljava/lang/String;
    //   70: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc_w 334
    //   76: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: getstatic 33	com/tencent/kingkong/Common:d	Ljava/lang/String;
    //   82: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 336
    //   88: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: putstatic 24	com/tencent/kingkong/Common:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   97: new 47	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   104: getstatic 22	com/tencent/kingkong/Common:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   107: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: getstatic 33	com/tencent/kingkong/Common:d	Ljava/lang/String;
    //   113: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 334
    //   119: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: getstatic 33	com/tencent/kingkong/Common:d	Ljava/lang/String;
    //   125: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc_w 338
    //   131: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: putstatic 26	com/tencent/kingkong/Common:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   140: new 47	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   147: getstatic 22	com/tencent/kingkong/Common:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   150: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: getstatic 33	com/tencent/kingkong/Common:d	Ljava/lang/String;
    //   156: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc_w 340
    //   162: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: putstatic 35	com/tencent/kingkong/Common:e	Ljava/lang/String;
    //   171: new 47	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   178: getstatic 22	com/tencent/kingkong/Common:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   181: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: getstatic 33	com/tencent/kingkong/Common:d	Ljava/lang/String;
    //   187: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc_w 342
    //   193: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: putstatic 37	com/tencent/kingkong/Common:f	Ljava/lang/String;
    //   202: new 344	adbl
    //   205: dup
    //   206: getstatic 35	com/tencent/kingkong/Common:e	Ljava/lang/String;
    //   209: invokespecial 346	adbl:<init>	(Ljava/lang/String;)V
    //   212: putstatic 348	com/tencent/kingkong/Common:jdField_a_of_type_Adbl	Ladbl;
    //   215: goto -204 -> 11
    //   218: astore_1
    //   219: ldc 2
    //   221: monitorexit
    //   222: aload_1
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   218	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	218	finally
    //   15	215	218	finally
  }
  
  private static void b(int paramInt)
  {
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("POINT_LOG_CRASH_COUNT", paramInt);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public static void b(boolean paramBoolean)
  {
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean("PATCH_STATUS", paramBoolean);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public static int[] b(String paramString)
  {
    int j = jdField_a_of_type_AndroidContentSharedPreferences.getInt(a("HOOKPOINT_COUNT", paramString), -1);
    if (j == -1) {
      return null;
    }
    int[] arrayOfInt = new int[j];
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return arrayOfInt;
      }
      arrayOfInt[i] = jdField_a_of_type_AndroidContentSharedPreferences.getInt(a("JUMPER", paramString, i), -1);
      if (arrayOfInt[i] == -1) {
        break;
      }
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static int c()
  {
    return jdField_a_of_type_AndroidContentSharedPreferences.getInt("POINT_LOG_CONTINUOUS_COUNT", 0);
  }
  
  private static void c(int paramInt)
  {
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("POINT_LOG_CONTINUOUS_COUNT", paramInt);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  private static int d()
  {
    return jdField_a_of_type_AndroidContentSharedPreferences.getInt("POINT_LOG", 0);
  }
  
  private static void d(int paramInt)
  {
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("POINT_LOG", paramInt);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  private static boolean e()
  {
    int i = b();
    if (i >= 0)
    {
      if (d() == 0) {
        break label46;
      }
      b(i + 1);
      i = c();
      if (i >= 2)
      {
        b(false);
        a();
        return false;
      }
      c(i + 1);
    }
    for (;;)
    {
      return true;
      label46:
      c(0);
    }
  }
  
  private static boolean f()
  {
    return jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("PATCH_STATUS", true);
  }
  
  private static boolean g()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.kingkong.Common
 * JD-Core Version:    0.7.0.1
 */