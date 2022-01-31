import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class auuh
{
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String[] b;
  public static final String[] c;
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String[] d;
  public int e;
  public int f;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { alud.a(2131707796), "18-22岁", "23-26岁", "27-35岁", "35岁以上" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { alud.a(2131707804), alud.a(2131707791), alud.a(2131707800), alud.a(2131707802), alud.a(2131707807), alud.a(2131707793), alud.a(2131707811), alud.a(2131707795) };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { alud.a(2131707808), alud.a(2131707813), alud.a(2131707810), alud.a(2131707797), alud.a(2131707798), alud.a(2131707803), alud.a(2131707812), alud.a(2131707801), alud.a(2131707794), alud.a(2131707799), alud.a(2131707809), alud.a(2131707792), alud.a(2131707806) };
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 2130845171, 2130845167, 2130845166, 2130845172, 2130845169, 2130845170, 2130845168 };
    jdField_b_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3 };
  }
  
  public auuh()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 4;
    this.jdField_d_of_type_ArrayOfJavaLangString = new String[] { "0", "0", "0", "0" };
    this.jdField_a_of_type_JavaLangString = "不限";
    this.jdField_b_of_type_JavaLangString = "不限";
    this.jdField_c_of_type_JavaLangString = "不限";
    this.jdField_d_of_type_JavaLangString = "不限";
  }
  
  public static auuh a(String paramString)
  {
    return a(paramString, "nearpeople_filters");
  }
  
  public static auuh a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      do
      {
        return null;
        paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences(paramString2 + paramString1, 4);
      } while (paramString1 == null);
      paramString2 = new auuh();
      paramString2.jdField_a_of_type_Int = paramString1.getInt("gender", -1);
    } while (paramString2.jdField_a_of_type_Int == -1);
    paramString2.jdField_a_of_type_Boolean = paramString1.getBoolean("byuser", false);
    paramString2.jdField_c_of_type_Int = paramString1.getInt("age", 0);
    paramString2.jdField_d_of_type_Int = paramString1.getInt("interest", 0);
    paramString2.jdField_b_of_type_Int = paramString1.getInt("time", 3);
    paramString2.e = paramString1.getInt("xingzuo", 0);
    paramString2.f = paramString1.getInt("key_career", 0);
    paramString2.jdField_d_of_type_ArrayOfJavaLangString[0] = paramString1.getString("key_hometown_country", "0");
    paramString2.jdField_d_of_type_ArrayOfJavaLangString[1] = paramString1.getString("key_hometown_province", "0");
    paramString2.jdField_d_of_type_ArrayOfJavaLangString[2] = paramString1.getString("key_hometown_city", "0");
    paramString2.jdField_a_of_type_JavaLangString = paramString1.getString("key_hometown_string", "不限");
    paramString2.jdField_b_of_type_JavaLangString = paramString1.getString("str_country", "不限");
    paramString2.jdField_c_of_type_JavaLangString = paramString1.getString("str_province", "不限");
    paramString2.jdField_d_of_type_JavaLangString = paramString1.getString("str_city", "不限");
    if ("-1".equals(paramString2.jdField_d_of_type_ArrayOfJavaLangString[0])) {
      paramString2.jdField_d_of_type_ArrayOfJavaLangString[0] = "0";
    }
    if ("-1".equals(paramString2.jdField_d_of_type_ArrayOfJavaLangString[1])) {
      paramString2.jdField_d_of_type_ArrayOfJavaLangString[1] = "0";
    }
    if ("-1".equals(paramString2.jdField_d_of_type_ArrayOfJavaLangString[2])) {
      paramString2.jdField_d_of_type_ArrayOfJavaLangString[2] = "0";
    }
    return paramString2;
  }
  
  public static void a(String paramString, auuh paramauuh)
  {
    a(paramString, paramauuh, "nearpeople_filters");
  }
  
  public static void a(String paramString1, auuh paramauuh, String paramString2)
  {
    if ((paramauuh == null) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences(paramString2 + paramString1, 4);
    } while (paramString1 == null);
    paramString1.edit().putBoolean("byuser", paramauuh.jdField_a_of_type_Boolean).putInt("gender", paramauuh.jdField_a_of_type_Int).putInt("time", paramauuh.jdField_b_of_type_Int).putInt("age", paramauuh.jdField_c_of_type_Int).putInt("xingzuo", paramauuh.e).putInt("key_career", paramauuh.f).putString("key_hometown_country", paramauuh.jdField_d_of_type_ArrayOfJavaLangString[0]).putString("key_hometown_province", paramauuh.jdField_d_of_type_ArrayOfJavaLangString[1]).putString("key_hometown_city", paramauuh.jdField_d_of_type_ArrayOfJavaLangString[2]).putString("key_hometown_string", paramauuh.jdField_a_of_type_JavaLangString).putString("str_country", paramauuh.jdField_b_of_type_JavaLangString).putString("str_province", paramauuh.jdField_c_of_type_JavaLangString).putString("str_city", paramauuh.jdField_d_of_type_JavaLangString).putInt("interest", paramauuh.jdField_d_of_type_Int).commit();
  }
  
  public boolean equals(Object paramObject)
  {
    int i = 0;
    boolean bool1;
    if ((paramObject == null) || (!(paramObject instanceof auuh)))
    {
      bool1 = false;
      return bool1;
    }
    paramObject = (auuh)paramObject;
    if ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && ((this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) || (((this.jdField_b_of_type_Int == 4) || (this.jdField_b_of_type_Int == 3)) && ((paramObject.jdField_b_of_type_Int == 4) || (paramObject.jdField_b_of_type_Int == 3)))) && (this.jdField_c_of_type_Int == paramObject.jdField_c_of_type_Int) && (this.e == paramObject.e) && (this.f == paramObject.f) && (this.jdField_d_of_type_Int == paramObject.jdField_d_of_type_Int)) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i >= 3) {
          break;
        }
        bool2 &= this.jdField_d_of_type_ArrayOfJavaLangString[i].equalsIgnoreCase(paramObject.jdField_d_of_type_ArrayOfJavaLangString[i]);
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("筛选：");
    String str1;
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      if ((this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int < jdField_a_of_type_ArrayOfJavaLangString.length)) {
        localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]).append(',');
      }
      if ((this.jdField_d_of_type_Int != 0) && (this.jdField_d_of_type_Int < jdField_b_of_type_ArrayOfJavaLangString.length)) {
        localStringBuilder.append(jdField_b_of_type_ArrayOfJavaLangString[this.jdField_d_of_type_Int]).append(',');
      }
      if ((this.f != 0) && (this.f < bdda.e.length))
      {
        String str2 = bdda.e[this.f];
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = alud.a(2131707805);
        }
        localStringBuilder.append(str1).append(',');
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaLangString.equals("不限")))
      {
        i = this.jdField_a_of_type_JavaLangString.lastIndexOf("-");
        if (i > 0)
        {
          str1 = this.jdField_a_of_type_JavaLangString.substring(i + 1);
          label223:
          localStringBuilder.append(str1).append(',');
        }
      }
      else
      {
        if ((this.e != 0) && (this.e < jdField_c_of_type_ArrayOfJavaLangString.length)) {
          localStringBuilder.append(jdField_c_of_type_ArrayOfJavaLangString[this.e]).append(',');
        }
        switch (this.jdField_b_of_type_Int)
        {
        }
      }
      break;
    }
    for (;;)
    {
      str1 = localStringBuilder.toString();
      if (TextUtils.isEmpty(str1)) {
        break label418;
      }
      i = localStringBuilder.lastIndexOf(",");
      if (i <= 0) {
        break label418;
      }
      return str1.substring(0, i);
      localStringBuilder.append("男,");
      break;
      localStringBuilder.append("女,");
      break;
      str1 = this.jdField_a_of_type_JavaLangString;
      break label223;
      localStringBuilder.append("30分钟内,");
      continue;
      localStringBuilder.append("1个小时内,");
      continue;
      localStringBuilder.append("4小时内,");
      continue;
      localStringBuilder.append("8小时内,");
    }
    label418:
    return "全部";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auuh
 * JD-Core Version:    0.7.0.1
 */