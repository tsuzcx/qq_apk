package com.tencent.kingkong;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class Common
{
  public static Context a;
  public static SharedPreferences.Editor a;
  public static SharedPreferences a;
  public static Utils.InterProcessLock a;
  public static String a = "";
  public static boolean a = false;
  public static String b = "";
  public static boolean b = false;
  public static String c = "";
  public static boolean c = false;
  public static String d = File.separator;
  public static boolean d = false;
  public static String e = "";
  public static boolean e = false;
  public static String f = "";
  
  public static void EvilReportFromNative(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Evil Report ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString2);
    Common.Log.a("KingKongCommon", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("&str1=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&str2=");
    localStringBuilder.append(paramString2);
    ReportUtil.a(paramInt, 0, 0, localStringBuilder.toString());
  }
  
  public static void NotificationFromNative(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Notification From Native ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt3);
    Common.Log.a("KingKongCommon", localStringBuilder.toString());
    ReportUtil.a(paramInt1, paramInt2, paramInt3, "");
  }
  
  public static void OnLogin(Context paramContext, String paramString)
  {
    try
    {
      SetContext(paramContext);
      paramContext = jdField_a_of_type_AndroidContentContext;
      if (paramContext == null) {
        return;
      }
      SetQQUni(paramString);
      ThreadManager.getSubThreadHandler().postDelayed(new Common.1(), 1000L);
      return;
    }
    finally {}
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
  
  public static void SetSafeStatus(boolean paramBoolean)
  {
    try
    {
      boolean bool = a();
      if (!bool) {
        return;
      }
      Context localContext = jdField_a_of_type_AndroidContentContext;
      if (localContext == null) {
        return;
      }
      if ((paramBoolean) && (!jdField_a_of_type_Boolean) && (!jdField_b_of_type_Boolean))
      {
        jdField_b_of_type_Boolean = true;
        b();
        ThreadManager.excute(new Common.2(), 16, null, true);
        return;
      }
      return;
    }
    finally {}
  }
  
  public static int a()
  {
    return jdField_a_of_type_AndroidContentSharedPreferences.getInt("INITIALIZE_STATUS", 0);
  }
  
  public static int a(String paramString, ArrayList<String> paramArrayList)
  {
    int j = jdField_a_of_type_AndroidContentSharedPreferences.getInt(a("FINGERPRINT_LIB_COUNT", paramString), -1);
    if ((j != -1) && (j == paramArrayList.size()))
    {
      int i = 0;
      while (i < j)
      {
        String str1 = jdField_a_of_type_AndroidContentSharedPreferences.getString(a("FINGERPRINT_LIB", paramString, i), "");
        if (!((String)paramArrayList.get(i)).equals(str1))
        {
          paramString = new StringBuilder();
          paramString.append("Library name mismatch ");
          paramString.append(str1);
          paramString.append(", ");
          paramString.append((String)paramArrayList.get(i));
          Common.Log.a("KingKongCommon", paramString.toString());
          return -1;
        }
        String str2 = Utils.b(str1);
        if (TextUtils.isEmpty(str2))
        {
          paramString = new StringBuilder();
          paramString.append("Unable to get file SHA1 ");
          paramString.append(str1);
          Common.Log.a("KingKongCommon", paramString.toString());
          return -1;
        }
        String str3 = jdField_a_of_type_AndroidContentSharedPreferences.getString(a("FINGERPRINT_LIB_SHA1", paramString, i), "");
        if (!str3.equals(str2))
        {
          paramString = new StringBuilder();
          paramString.append("Library SHA1 mismatch ");
          paramString.append(str1);
          paramString.append(", ");
          paramString.append(str3);
          paramString.append(", ");
          paramString.append(str2);
          Common.Log.a("KingKongCommon", paramString.toString());
          return -1;
        }
        i += 1;
      }
      return jdField_a_of_type_AndroidContentSharedPreferences.getInt(a("SUBPATCH_INDEX", paramString), -1);
    }
    paramString = new StringBuilder();
    paramString.append("Library count mismatch ");
    paramString.append(j);
    paramString.append(", ");
    paramString.append(paramArrayList.size());
    Common.Log.a("KingKongCommon", paramString.toString());
    return -1;
  }
  
  public static String a()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append(d);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    int i = b();
    StringBuffer localStringBuffer = new StringBuffer();
    int j = d();
    try
    {
      localStringBuffer.append("&str1=");
      localStringBuffer.append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
      localStringBuffer.append("&str2=");
      localStringBuffer.append(URLEncoder.encode(Integer.toString(j), "UTF-8"));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    ReportUtil.a(2087, 0, 0, localStringBuffer.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("&str1=");
      localStringBuilder.append(URLEncoder.encode(paramString1, "UTF-8"));
      localStringBuilder.append("&str3=");
      localStringBuilder.append(URLEncoder.encode(paramString2, "UTF-8"));
      ReportUtil.a(paramInt, 0, 0, localStringBuilder.toString());
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Do patch ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString4);
    Common.Log.a("KingKongCommon", ((StringBuilder)localObject).toString());
    localObject = a("DO_PATCH", paramString1, paramInt);
    if (!jdField_a_of_type_AndroidContentSharedPreferences.getBoolean((String)localObject, false)) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("&str1=");
        localStringBuilder.append(URLEncoder.encode(paramString1, "UTF-8"));
        localStringBuilder.append("&str2=");
        localStringBuilder.append(URLEncoder.encode(paramString2, "UTF-8"));
        localStringBuilder.append("&str3=");
        localStringBuilder.append(URLEncoder.encode(paramString3, "UTF-8"));
        localStringBuilder.append("&v1=");
        localStringBuilder.append(URLEncoder.encode(paramString4, "UTF-8"));
        ReportUtil.a(2081, paramInt, 0, localStringBuilder.toString());
        jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean((String)localObject, true);
        jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
        return;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static void a(String paramString, int paramInt, ArrayList<String> paramArrayList)
  {
    int j = paramArrayList.size();
    if (j > 15) {
      return;
    }
    int i = 0;
    while (i < j)
    {
      String str1 = (String)paramArrayList.get(i);
      String str2 = Utils.b(str1);
      if (TextUtils.isEmpty(str2)) {
        return;
      }
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString(a("FINGERPRINT_LIB_SHA1", paramString, i), str2);
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString(a("FINGERPRINT_LIB", paramString, i), str1);
      i += 1;
    }
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(a("FINGERPRINT_LIB_COUNT", paramString), j);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(a("SUBPATCH_INDEX", paramString), paramInt);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public static void a(String paramString, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1.length == paramArrayOfInt2.length) && (paramArrayOfInt1.length <= 15) && (paramArrayOfInt1.length == paramInt))
    {
      int i = 0;
      while (i < paramInt)
      {
        jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(a("JUMPER", paramString, i), paramArrayOfInt1[i]);
        jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(a("GOTHOOK", paramString, i), paramArrayOfInt2[i]);
        i += 1;
      }
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(a("HOOKPOINT_COUNT", paramString), paramInt);
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      return;
    }
    paramString = new StringBuilder();
    paramString.append("Params count mismatch : ");
    paramString.append(paramArrayOfInt1.length);
    paramString.append(", ");
    paramString.append(paramArrayOfInt2.length);
    paramString.append(", ");
    paramString.append(paramInt);
    Common.Log.a("KingKongCommon", paramString.toString());
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      Constant.a += 1;
    } else {
      Constant.a = 0;
    }
    d(Constant.a);
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
    while (i < j)
    {
      arrayOfInt[i] = jdField_a_of_type_AndroidContentSharedPreferences.getInt(a("GOTHOOK", paramString, i), -1);
      if (arrayOfInt[i] == -1) {
        return null;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_c_of_type_JavaLangString);
    localStringBuilder.append(d);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void b()
  {
    try
    {
      boolean bool = jdField_c_of_type_Boolean;
      if (bool) {
        return;
      }
      jdField_c_of_type_Boolean = true;
      jdField_a_of_type_AndroidContentSharedPreferences = jdField_a_of_type_AndroidContentContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0);
      jdField_a_of_type_AndroidContentSharedPreferences$Editor = jdField_a_of_type_AndroidContentSharedPreferences.edit();
      jdField_a_of_type_JavaLangString = jdField_a_of_type_AndroidContentContext.getFilesDir().getAbsolutePath();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(d);
      localStringBuilder.append("kingkong");
      localStringBuilder.append(d);
      localStringBuilder.append("download");
      jdField_b_of_type_JavaLangString = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(d);
      localStringBuilder.append("kingkong");
      localStringBuilder.append(d);
      localStringBuilder.append("patches");
      jdField_c_of_type_JavaLangString = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(d);
      localStringBuilder.append("KingkongPatchInterprocess.Lock");
      e = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(d);
      localStringBuilder.append("KingkongUpdateInterprocess.Lock");
      f = localStringBuilder.toString();
      jdField_a_of_type_ComTencentKingkongUtils$InterProcessLock = new Utils.InterProcessLock(e);
      return;
    }
    finally {}
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
    while (i < j)
    {
      arrayOfInt[i] = jdField_a_of_type_AndroidContentSharedPreferences.getInt(a("JUMPER", paramString, i), -1);
      if (arrayOfInt[i] == -1) {
        return null;
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
      if (d() != 0)
      {
        b(i + 1);
        i = c();
        if (i >= 2)
        {
          b(false);
          a();
          return false;
        }
        c(i + 1);
        return true;
      }
      c(0);
    }
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kingkong.Common
 * JD-Core Version:    0.7.0.1
 */