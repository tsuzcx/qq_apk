package com.tencent.featuretoggle;

import com.tencent.featuretoggle.mmkv.MMKVPersitence;
import com.tencent.featuretoggle.utils.PreferenceUtil;

public class SpManager
{
  public static final String a;
  public static final String b;
  private static volatile SpManager c = null;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ToggleSetting.s());
    localStringBuilder.append("feature");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(ToggleSetting.s());
    localStringBuilder.append("persist");
    b = localStringBuilder.toString();
  }
  
  public static SpManager a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new SpManager();
        }
      }
      finally {}
    }
    return c;
  }
  
  public String a(String paramString1, String paramString2)
  {
    return PreferenceUtil.a().a(ToggleSetting.j(), a, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    PreferenceUtil.a().b(ToggleSetting.j(), b, "f_t_s", paramLong);
  }
  
  public void a(String paramString)
  {
    PreferenceUtil.a().b(ToggleSetting.j(), b, "f_as_id", paramString);
  }
  
  public String b()
  {
    return PreferenceUtil.a().a(ToggleSetting.j(), b, "f_as_id", null);
  }
  
  public void b(long paramLong)
  {
    long l = System.currentTimeMillis();
    PreferenceUtil.a().b(ToggleSetting.j(), b, "f_s_t", l - paramLong * 1000L);
  }
  
  public void b(String paramString)
  {
    PreferenceUtil.a().b(ToggleSetting.j(), b, "f_s_n", paramString);
  }
  
  public String c()
  {
    return PreferenceUtil.a().a(ToggleSetting.j(), b, "f_s_n", "");
  }
  
  public void c(String paramString)
  {
    PreferenceUtil.a().b(ToggleSetting.j(), b, "f_t_id", paramString);
  }
  
  public String d()
  {
    return PreferenceUtil.a().a(ToggleSetting.j(), b, "f_t_id", "");
  }
  
  public void d(String paramString)
  {
    PreferenceUtil.a().b(ToggleSetting.j(), b, "f_t_v", paramString);
  }
  
  public String e()
  {
    return PreferenceUtil.a().a(ToggleSetting.j(), b, "f_t_v", "");
  }
  
  public void e(String paramString)
  {
    PreferenceUtil.a().b(ToggleSetting.j(), b, "f_f_u", paramString);
  }
  
  public long f()
  {
    return PreferenceUtil.a().a(ToggleSetting.j(), b, "f_t_s", 0L);
  }
  
  public boolean f(String paramString)
  {
    return PreferenceUtil.a().a(ToggleSetting.j(), a, paramString);
  }
  
  public long g()
  {
    return PreferenceUtil.a().a(ToggleSetting.j(), b, "f_s_t", 0L);
  }
  
  public MMKVPersitence g(String paramString)
  {
    paramString = PreferenceUtil.a().a(paramString, ToggleSetting.j());
    if ((paramString != null) && (paramString.a() != null)) {
      return paramString;
    }
    return null;
  }
  
  public String h()
  {
    return PreferenceUtil.a().a(ToggleSetting.j(), b, "f_f_u", "");
  }
  
  public String[] i()
  {
    return PreferenceUtil.a().a(ToggleSetting.j(), a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.SpManager
 * JD-Core Version:    0.7.0.1
 */