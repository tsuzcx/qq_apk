package com.tencent.featuretoggle;

import com.tencent.featuretoggle.mmkv.MMKVPersitence;
import com.tencent.featuretoggle.utils.PreferenceUtil;

public class SpManager
{
  private static volatile SpManager a;
  public static final String a;
  public static final String b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ToggleSetting.h());
    localStringBuilder.append("feature");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(ToggleSetting.h());
    localStringBuilder.append("persist");
    b = localStringBuilder.toString();
    jdField_a_of_type_ComTencentFeaturetoggleSpManager = null;
  }
  
  public static SpManager a()
  {
    if (jdField_a_of_type_ComTencentFeaturetoggleSpManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentFeaturetoggleSpManager == null) {
          jdField_a_of_type_ComTencentFeaturetoggleSpManager = new SpManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentFeaturetoggleSpManager;
  }
  
  public long a()
  {
    return PreferenceUtil.a().a(ToggleSetting.a(), b, "f_t_s", 0L);
  }
  
  public MMKVPersitence a(String paramString)
  {
    paramString = PreferenceUtil.a().a(paramString, ToggleSetting.a());
    if ((paramString != null) && (paramString.a() != null)) {
      return paramString;
    }
    return null;
  }
  
  public String a()
  {
    return PreferenceUtil.a().a(ToggleSetting.a(), b, "f_id", "");
  }
  
  public String a(String paramString1, String paramString2)
  {
    return PreferenceUtil.a().a(ToggleSetting.a(), jdField_a_of_type_JavaLangString, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    PreferenceUtil.a().a(ToggleSetting.a(), b, "f_t_s", paramLong);
  }
  
  public void a(String paramString)
  {
    PreferenceUtil.a().a(ToggleSetting.a(), b, "f_id", paramString);
  }
  
  public boolean a(String paramString)
  {
    return PreferenceUtil.a().a(ToggleSetting.a(), jdField_a_of_type_JavaLangString, paramString);
  }
  
  public String[] a()
  {
    return PreferenceUtil.a().a(ToggleSetting.a(), jdField_a_of_type_JavaLangString);
  }
  
  public long b()
  {
    return PreferenceUtil.a().a(ToggleSetting.a(), b, "f_s_t", 0L);
  }
  
  public String b()
  {
    return PreferenceUtil.a().a(ToggleSetting.a(), b, "f_as_id", null);
  }
  
  public void b(long paramLong)
  {
    long l = System.currentTimeMillis();
    PreferenceUtil.a().a(ToggleSetting.a(), b, "f_s_t", l - paramLong * 1000L);
  }
  
  public void b(String paramString)
  {
    PreferenceUtil.a().a(ToggleSetting.a(), b, "f_as_id", paramString);
  }
  
  public String c()
  {
    return PreferenceUtil.a().a(ToggleSetting.a(), b, "f_s_n", "");
  }
  
  public void c(String paramString)
  {
    PreferenceUtil.a().a(ToggleSetting.a(), b, "f_s_n", paramString);
  }
  
  public String d()
  {
    return PreferenceUtil.a().a(ToggleSetting.a(), b, "f_t_id", "");
  }
  
  public void d(String paramString)
  {
    PreferenceUtil.a().a(ToggleSetting.a(), b, "f_t_id", paramString);
  }
  
  public String e()
  {
    return PreferenceUtil.a().a(ToggleSetting.a(), b, "f_t_v", "");
  }
  
  public void e(String paramString)
  {
    PreferenceUtil.a().a(ToggleSetting.a(), b, "f_t_v", paramString);
  }
  
  public String f()
  {
    return PreferenceUtil.a().a(ToggleSetting.a(), b, "f_f_u", "");
  }
  
  public void f(String paramString)
  {
    PreferenceUtil.a().a(ToggleSetting.a(), b, "f_f_u", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.SpManager
 * JD-Core Version:    0.7.0.1
 */