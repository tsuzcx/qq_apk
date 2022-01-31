package com.tencent.kingkong;

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
  public static Context a;
  public static SharedPreferences.Editor a;
  public static SharedPreferences a;
  public static ReportThread a;
  public static Utils.InterProcessLock a;
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
    Common.Log.a("KingKongCommon", "Evil Report " + paramString1 + ", " + paramString2);
    if (jdField_a_of_type_ComTencentKingkongReportThread != null)
    {
      paramString1 = "&str1=" + paramString1 + "&str2=" + paramString2;
      jdField_a_of_type_ComTencentKingkongReportThread.a(paramInt, 0, 0, paramString1);
    }
  }
  
  public static void NotificationFromNative(int paramInt1, int paramInt2, int paramInt3)
  {
    Common.Log.a("KingKongCommon", "Notification From Native " + paramInt1 + ", " + paramInt2 + ", " + paramInt3);
    if (jdField_a_of_type_ComTencentKingkongReportThread != null) {
      jdField_a_of_type_ComTencentKingkongReportThread.a(paramInt1, paramInt2, paramInt3, "");
    }
  }
  
  /* Error */
  public static void OnLogin(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 90	com/tencent/kingkong/Common:SetContext	(Landroid/content/Context;)V
    //   7: getstatic 92	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnonnull +7 -> 19
    //   15: ldc 2
    //   17: monitorexit
    //   18: return
    //   19: aload_1
    //   20: invokestatic 96	com/tencent/kingkong/Common:SetQQUni	(Ljava/lang/String;)V
    //   23: getstatic 68	com/tencent/kingkong/Common:jdField_a_of_type_ComTencentKingkongReportThread	Lcom/tencent/kingkong/ReportThread;
    //   26: ifnonnull +19 -> 45
    //   29: new 74	com/tencent/kingkong/ReportThread
    //   32: dup
    //   33: invokespecial 97	com/tencent/kingkong/ReportThread:<init>	()V
    //   36: putstatic 68	com/tencent/kingkong/Common:jdField_a_of_type_ComTencentKingkongReportThread	Lcom/tencent/kingkong/ReportThread;
    //   39: getstatic 68	com/tencent/kingkong/Common:jdField_a_of_type_ComTencentKingkongReportThread	Lcom/tencent/kingkong/ReportThread;
    //   42: invokevirtual 100	com/tencent/kingkong/ReportThread:start	()V
    //   45: new 102	rcp
    //   48: dup
    //   49: invokespecial 103	rcp:<init>	()V
    //   52: invokevirtual 104	rcp:start	()V
    //   55: goto -40 -> 15
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramContext	Context
    //   0	64	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	11	58	finally
    //   19	45	58	finally
    //   45	55	58	finally
  }
  
  public static void SetContext(Context paramContext)
  {
    if ((paramContext != null) && (jdField_a_of_type_AndroidContentContext == null))
    {
      jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
      DataReport.a(jdField_a_of_type_AndroidContentContext);
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
    DataReport.a(paramString);
  }
  
  /* Error */
  public static void SetSafeStatus(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 146	com/tencent/kingkong/Common:a	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 92	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   18: ifnull -7 -> 11
    //   21: iload_0
    //   22: ifeq -11 -> 11
    //   25: getstatic 148	com/tencent/kingkong/Common:jdField_a_of_type_Boolean	Z
    //   28: ifne -17 -> 11
    //   31: getstatic 150	com/tencent/kingkong/Common:jdField_b_of_type_Boolean	Z
    //   34: ifne -23 -> 11
    //   37: iconst_1
    //   38: putstatic 150	com/tencent/kingkong/Common:jdField_b_of_type_Boolean	Z
    //   41: invokestatic 152	com/tencent/kingkong/Common:b	()V
    //   44: new 154	rcq
    //   47: dup
    //   48: invokespecial 155	rcq:<init>	()V
    //   51: invokevirtual 156	rcq:start	()V
    //   54: goto -43 -> 11
    //   57: astore_2
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_2
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramBoolean	boolean
    //   6	2	1	bool	boolean
    //   57	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	57	finally
    //   15	21	57	finally
    //   25	54	57	finally
  }
  
  public static int a()
  {
    return jdField_a_of_type_AndroidContentSharedPreferences.getInt("INITIALIZE_STATUS", 0);
  }
  
  public static int a(String paramString, ArrayList paramArrayList)
  {
    int j = jdField_a_of_type_AndroidContentSharedPreferences.getInt(a("FINGERPRINT_LIB_COUNT", paramString), -1);
    if ((j == -1) || (j != paramArrayList.size()))
    {
      Common.Log.a("KingKongCommon", "Library count mismatch " + j + ", " + paramArrayList.size());
      return -1;
    }
    int i = 0;
    while (i < j)
    {
      String str1 = jdField_a_of_type_AndroidContentSharedPreferences.getString(a("FINGERPRINT_LIB", paramString, i), "");
      if (!((String)paramArrayList.get(i)).equals(str1))
      {
        Common.Log.a("KingKongCommon", "Library name mismatch " + str1 + ", " + (String)paramArrayList.get(i));
        return -1;
      }
      String str2 = Utils.b(str1);
      if (TextUtils.isEmpty(str2))
      {
        Common.Log.a("KingKongCommon", "Unable to get file SHA1 " + str1);
        return -1;
      }
      String str3 = jdField_a_of_type_AndroidContentSharedPreferences.getString(a("FINGERPRINT_LIB_SHA1", paramString, i), "");
      if (!str3.equals(str2))
      {
        Common.Log.a("KingKongCommon", "Library SHA1 mismatch " + str1 + ", " + str3 + ", " + str2);
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
      if (jdField_a_of_type_ComTencentKingkongReportThread != null) {
        jdField_a_of_type_ComTencentKingkongReportThread.a(2087, 0, 0, localStringBuffer.toString());
      }
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
    if (jdField_a_of_type_ComTencentKingkongReportThread != null) {}
    try
    {
      jdField_a_of_type_ComTencentKingkongReportThread.a(paramInt, 0, 0, "&str1=" + URLEncoder.encode(paramString1, "UTF-8") + "&str3=" + URLEncoder.encode(paramString2, "UTF-8"));
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Common.Log.a("KingKongCommon", "Do patch " + paramInt + ", " + paramString1 + ", " + paramString2 + ", " + paramString3 + ", " + paramString4);
    String str = a("DO_PATCH", paramString1, paramInt);
    if ((!jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(str, false)) && (jdField_a_of_type_ComTencentKingkongReportThread != null)) {}
    try
    {
      jdField_a_of_type_ComTencentKingkongReportThread.a(2081, paramInt, 0, "&str1=" + URLEncoder.encode(paramString1, "UTF-8") + "&str2=" + URLEncoder.encode(paramString2, "UTF-8") + "&str3=" + URLEncoder.encode(paramString3, "UTF-8") + "&v1=" + URLEncoder.encode(paramString4, "UTF-8"));
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean(str, true);
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt, ArrayList paramArrayList)
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
      String str2 = Utils.b(str1);
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
      Common.Log.a("KingKongCommon", "Params count mismatch : " + paramArrayOfInt1.length + ", " + paramArrayOfInt2.length + ", " + paramInt);
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
    for (Constant.a += 1;; Constant.a = 0)
    {
      d(Constant.a);
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
    //   3: getstatic 313	com/tencent/kingkong/Common:jdField_c_of_type_Boolean	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 313	com/tencent/kingkong/Common:jdField_c_of_type_Boolean	Z
    //   19: getstatic 92	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   22: ldc 118
    //   24: iconst_0
    //   25: invokevirtual 122	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   28: putstatic 159	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   31: getstatic 159	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   34: invokeinterface 128 1 0
    //   39: putstatic 250	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentSharedPreferences$Editor	Landroid/content/SharedPreferences$Editor;
    //   42: getstatic 92	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   45: invokevirtual 317	android/content/Context:getFilesDir	()Ljava/io/File;
    //   48: invokevirtual 320	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: putstatic 23	com/tencent/kingkong/Common:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   54: new 48	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   61: getstatic 23	com/tencent/kingkong/Common:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   64: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 34	com/tencent/kingkong/Common:d	Ljava/lang/String;
    //   70: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc_w 322
    //   76: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: getstatic 34	com/tencent/kingkong/Common:d	Ljava/lang/String;
    //   82: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 324
    //   88: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: putstatic 25	com/tencent/kingkong/Common:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   97: new 48	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   104: getstatic 23	com/tencent/kingkong/Common:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   107: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: getstatic 34	com/tencent/kingkong/Common:d	Ljava/lang/String;
    //   113: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 322
    //   119: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: getstatic 34	com/tencent/kingkong/Common:d	Ljava/lang/String;
    //   125: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc_w 326
    //   131: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: putstatic 27	com/tencent/kingkong/Common:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   140: new 48	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   147: getstatic 23	com/tencent/kingkong/Common:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   150: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: getstatic 34	com/tencent/kingkong/Common:d	Ljava/lang/String;
    //   156: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc_w 328
    //   162: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: putstatic 36	com/tencent/kingkong/Common:e	Ljava/lang/String;
    //   171: new 48	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   178: getstatic 23	com/tencent/kingkong/Common:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   181: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: getstatic 34	com/tencent/kingkong/Common:d	Ljava/lang/String;
    //   187: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc_w 330
    //   193: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: putstatic 38	com/tencent/kingkong/Common:f	Ljava/lang/String;
    //   202: new 332	com/tencent/kingkong/Utils$InterProcessLock
    //   205: dup
    //   206: getstatic 36	com/tencent/kingkong/Common:e	Ljava/lang/String;
    //   209: invokespecial 334	com/tencent/kingkong/Utils$InterProcessLock:<init>	(Ljava/lang/String;)V
    //   212: putstatic 336	com/tencent/kingkong/Common:jdField_a_of_type_ComTencentKingkongUtils$InterProcessLock	Lcom/tencent/kingkong/Utils$InterProcessLock;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.kingkong.Common
 * JD-Core Version:    0.7.0.1
 */