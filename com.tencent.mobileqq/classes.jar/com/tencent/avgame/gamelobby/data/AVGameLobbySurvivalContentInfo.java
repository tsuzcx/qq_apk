package com.tencent.avgame.gamelobby.data;

import androidx.annotation.NonNull;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AVGameLobbySurvivalContentInfo
  extends AVGameBaseData
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private String g;
  
  public AVGameLobbySurvivalContentInfo(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    long l1 = this.jdField_a_of_type_Long;
    if (l1 > 0L)
    {
      long l2 = this.jdField_b_of_type_Long;
      if ((l2 > 0L) && (l1 <= l2))
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM月dd日 HH:mm");
        localStringBuffer.append("时间：");
        localStringBuffer.append(localSimpleDateFormat.format(Long.valueOf(this.jdField_a_of_type_Long * 1000L)));
        localStringBuffer.append("～");
        if (l2 - l1 >= 86400L) {
          localStringBuffer.append(new SimpleDateFormat("MM月dd日 HH:mm").format(Long.valueOf(this.jdField_b_of_type_Long * 1000L)));
        } else {
          localStringBuffer.append(new SimpleDateFormat("HH:mm").format(Long.valueOf(this.jdField_b_of_type_Long * 1000L)));
        }
        return localStringBuffer.toString();
      }
    }
    return "";
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return c() <= 2;
  }
  
  @NonNull
  public int b()
  {
    return 5;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Long >= this.jdField_b_of_type_Long) {
      return 0;
    }
    long l1 = System.currentTimeMillis() / 1000L;
    if (l1 >= this.jdField_b_of_type_Long) {
      return 4;
    }
    long l2 = this.jdField_a_of_type_Long;
    if (l1 >= l2) {
      return 3;
    }
    if (l2 - l1 > 900L) {
      return 1;
    }
    return 2;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String d()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void d(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void d(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public boolean d()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int e()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String e()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void e(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void e(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public int f()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String f()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void f(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public int g()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public String g()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public void g(String paramString)
  {
    this.g = paramString;
  }
  
  public String h()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.data.AVGameLobbySurvivalContentInfo
 * JD-Core Version:    0.7.0.1
 */