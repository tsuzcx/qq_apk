package com.tencent.featuretoggle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.featuretoggle.utils.AppUtils;
import com.tencent.featuretoggle.utils.Utils;
import java.util.HashMap;
import java.util.Map;

public final class ToggleSetting
{
  private static volatile int jdField_a_of_type_Int = -1;
  private static long jdField_a_of_type_Long = 120000L;
  @SuppressLint({"StaticFieldLeak"})
  private static Context jdField_a_of_type_AndroidContentContext;
  private static ToggleConfig jdField_a_of_type_ComTencentFeaturetoggleToggleConfig;
  private static String jdField_a_of_type_JavaLangString = "Toggle";
  private static boolean jdField_a_of_type_Boolean = true;
  private static long jdField_b_of_type_Long = 0L;
  private static String jdField_b_of_type_JavaLangString = "";
  private static boolean jdField_b_of_type_Boolean = true;
  private static volatile long jdField_c_of_type_Long = SystemClock.elapsedRealtime() - 30000L;
  private static boolean jdField_c_of_type_Boolean = true;
  private static volatile long jdField_d_of_type_Long = SystemClock.elapsedRealtime() - 30000L;
  private static boolean jdField_d_of_type_Boolean = true;
  private static boolean e = false;
  
  public static int a()
  {
    ToggleConfig localToggleConfig = jdField_a_of_type_ComTencentFeaturetoggleToggleConfig;
    if (localToggleConfig == null) {
      return (int)(Runtime.getRuntime().totalMemory() / 1024L / 8L);
    }
    return localToggleConfig.b();
  }
  
  public static long a()
  {
    return jdField_c_of_type_Long;
  }
  
  public static Context a()
  {
    return jdField_a_of_type_AndroidContentContext;
  }
  
  public static ToggleConfig a()
  {
    return jdField_a_of_type_ComTencentFeaturetoggleToggleConfig;
  }
  
  public static String a()
  {
    ToggleConfig localToggleConfig = jdField_a_of_type_ComTencentFeaturetoggleToggleConfig;
    if (localToggleConfig == null) {
      return "";
    }
    return localToggleConfig.h();
  }
  
  public static Map<String, String> a()
  {
    ToggleConfig localToggleConfig = jdField_a_of_type_ComTencentFeaturetoggleToggleConfig;
    if ((localToggleConfig != null) && (localToggleConfig.a() != null)) {
      return jdField_a_of_type_ComTencentFeaturetoggleToggleConfig.a();
    }
    return new HashMap();
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(long paramLong)
  {
    jdField_c_of_type_Long = paramLong;
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static void a(Context paramContext, ToggleConfig paramToggleConfig)
  {
    a(paramContext);
    a(paramToggleConfig);
    if (AppUtils.a(paramContext))
    {
      a(true);
      paramToggleConfig.b(true);
    }
    if (Utils.a(paramToggleConfig.d()))
    {
      String str = AppUtils.a(paramContext, "TOGGLE_CHANNEL");
      if (str != null) {
        paramToggleConfig.a(str);
      } else {
        paramToggleConfig.a("Defalut");
      }
    }
    if (Utils.a(paramToggleConfig.e())) {
      paramToggleConfig.b(AppUtils.a(paramContext));
    }
    if ((!paramToggleConfig.a()) && (AppUtils.a(paramContext, "TOGGLE_IS_DEBUG", false))) {
      paramToggleConfig.a(true);
    }
    b(paramToggleConfig.a());
  }
  
  public static void a(ToggleConfig paramToggleConfig)
  {
    jdField_a_of_type_ComTencentFeaturetoggleToggleConfig = paramToggleConfig;
  }
  
  public static void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Toggle");
    localStringBuilder.append(paramString);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public static void a(boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  public static boolean a()
  {
    ToggleConfig localToggleConfig = jdField_a_of_type_ComTencentFeaturetoggleToggleConfig;
    if (localToggleConfig == null) {
      return true;
    }
    return localToggleConfig.c();
  }
  
  public static int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public static long b()
  {
    return jdField_d_of_type_Long;
  }
  
  public static String b()
  {
    ToggleConfig localToggleConfig = jdField_a_of_type_ComTencentFeaturetoggleToggleConfig;
    if (localToggleConfig == null) {
      return "";
    }
    return localToggleConfig.a();
  }
  
  static void b(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if ((paramInt & 0x2) != 2) {
      c(false);
    }
    if ((paramInt & 0x4) != 4) {
      b(false);
    }
    if ((paramInt & 0x8) != 8) {
      d(false);
    }
  }
  
  public static void b(long paramLong)
  {
    jdField_d_of_type_Long = paramLong;
  }
  
  public static void b(String paramString)
  {
    ToggleConfig localToggleConfig = jdField_a_of_type_ComTencentFeaturetoggleToggleConfig;
    if (localToggleConfig != null) {
      localToggleConfig.c(paramString);
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public static boolean b()
  {
    return e;
  }
  
  public static long c()
  {
    return jdField_b_of_type_Long;
  }
  
  public static String c()
  {
    ToggleConfig localToggleConfig = jdField_a_of_type_ComTencentFeaturetoggleToggleConfig;
    if (localToggleConfig == null) {
      return "";
    }
    return localToggleConfig.b();
  }
  
  public static void c(long paramLong)
  {
    jdField_b_of_type_Long = paramLong;
  }
  
  public static void c(String paramString)
  {
    jdField_b_of_type_JavaLangString = paramString;
  }
  
  public static void c(boolean paramBoolean)
  {
    jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public static boolean c()
  {
    ToggleConfig localToggleConfig = jdField_a_of_type_ComTencentFeaturetoggleToggleConfig;
    if (localToggleConfig == null) {
      return false;
    }
    return localToggleConfig.a();
  }
  
  public static long d()
  {
    return 30000L;
  }
  
  public static String d()
  {
    ToggleConfig localToggleConfig = jdField_a_of_type_ComTencentFeaturetoggleToggleConfig;
    if (localToggleConfig == null) {
      return "";
    }
    return localToggleConfig.c();
  }
  
  public static void d(long paramLong)
  {
    ToggleConfig localToggleConfig = jdField_a_of_type_ComTencentFeaturetoggleToggleConfig;
    if (localToggleConfig != null) {
      localToggleConfig.a(paramLong);
    }
  }
  
  public static void d(boolean paramBoolean)
  {
    jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public static boolean d()
  {
    ToggleConfig localToggleConfig = jdField_a_of_type_ComTencentFeaturetoggleToggleConfig;
    if (localToggleConfig == null) {
      return false;
    }
    return localToggleConfig.b();
  }
  
  public static long e()
  {
    ToggleConfig localToggleConfig = jdField_a_of_type_ComTencentFeaturetoggleToggleConfig;
    if (localToggleConfig == null) {
      return 120000L;
    }
    return localToggleConfig.a();
  }
  
  public static String e()
  {
    ToggleConfig localToggleConfig = jdField_a_of_type_ComTencentFeaturetoggleToggleConfig;
    if (localToggleConfig == null) {
      return "Default";
    }
    return localToggleConfig.d();
  }
  
  public static void e(long paramLong)
  {
    jdField_a_of_type_Long = paramLong;
  }
  
  public static boolean e()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public static long f()
  {
    return jdField_a_of_type_Long;
  }
  
  public static String f()
  {
    ToggleConfig localToggleConfig = jdField_a_of_type_ComTencentFeaturetoggleToggleConfig;
    if (localToggleConfig == null) {
      return "";
    }
    return localToggleConfig.e();
  }
  
  public static boolean f()
  {
    return jdField_c_of_type_Boolean;
  }
  
  public static String g()
  {
    return "1.0.7.2";
  }
  
  public static boolean g()
  {
    return jdField_d_of_type_Boolean;
  }
  
  public static String h()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String i()
  {
    ToggleConfig localToggleConfig = jdField_a_of_type_ComTencentFeaturetoggleToggleConfig;
    if (localToggleConfig == null) {
      return "";
    }
    return localToggleConfig.f();
  }
  
  public static String j()
  {
    return "Android";
  }
  
  public static String k()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  public static String l()
  {
    return jdField_a_of_type_ComTencentFeaturetoggleToggleConfig.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.ToggleSetting
 * JD-Core Version:    0.7.0.1
 */