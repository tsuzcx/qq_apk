package com.tencent.featuretoggle;

import android.text.TextUtils;
import com.tencent.featuretoggle.utils.LogUtils;
import com.tencent.featuretoggle.utils.Utils;
import java.util.Map;

public class ToggleConfig
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 120000L;
  private String jdField_a_of_type_JavaLangString;
  private Map<String, String> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = (int)(Runtime.getRuntime().totalMemory() / 1024L / 8L);
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private String d = "";
  private String e;
  private String f = "";
  private String g = "";
  private String h = "";
  
  public ToggleConfig() {}
  
  public ToggleConfig(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString3;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public Map<String, String> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 10L)
    {
      LogUtils.a("The time must be greater than 10, Unit: second ,set duration 10", new Object[0]);
      l = 10L;
    }
    this.jdField_a_of_type_Long = (l * 1000L);
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(String paramString)
  {
    if (Utils.a(paramString)) {
      return;
    }
    this.e = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.f = str;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.h = paramString;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public void e(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public void f(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public String g()
  {
    return this.g;
  }
  
  public void g(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public String h()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.ToggleConfig
 * JD-Core Version:    0.7.0.1
 */