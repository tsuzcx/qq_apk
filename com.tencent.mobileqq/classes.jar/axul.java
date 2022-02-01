import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class axul
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
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { anzj.a(2131706294), "18-22岁", "23-26岁", "27-35岁", "35岁以上" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { anzj.a(2131706302), anzj.a(2131706289), anzj.a(2131706298), anzj.a(2131706300), anzj.a(2131706305), anzj.a(2131706291), anzj.a(2131706309), anzj.a(2131706293) };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { anzj.a(2131706306), anzj.a(2131706311), anzj.a(2131706308), anzj.a(2131706295), anzj.a(2131706296), anzj.a(2131706301), anzj.a(2131706310), anzj.a(2131706299), anzj.a(2131706292), anzj.a(2131706297), anzj.a(2131706307), anzj.a(2131706290), anzj.a(2131706304) };
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 2130845582, 2130845578, 2130845577, 2130845583, 2130845580, 2130845581, 2130845579 };
    jdField_b_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3 };
  }
  
  public axul()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 4;
    this.jdField_d_of_type_ArrayOfJavaLangString = new String[] { "0", "0", "0", "0" };
    this.jdField_a_of_type_JavaLangString = "不限";
    this.jdField_b_of_type_JavaLangString = "不限";
    this.jdField_c_of_type_JavaLangString = "不限";
    this.jdField_d_of_type_JavaLangString = "不限";
  }
  
  public static axul a(String paramString)
  {
    return a(paramString, "nearpeople_filters");
  }
  
  public static axul a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      do
      {
        return null;
        paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences(paramString2 + paramString1, 4);
      } while (paramString1 == null);
      paramString2 = new axul();
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
  
  public static void a(String paramString, axul paramaxul)
  {
    a(paramString, paramaxul, "nearpeople_filters");
  }
  
  public static void a(String paramString1, axul paramaxul, String paramString2)
  {
    if ((paramaxul == null) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences(paramString2 + paramString1, 4);
    } while (paramString1 == null);
    paramString1.edit().putBoolean("byuser", paramaxul.jdField_a_of_type_Boolean).putInt("gender", paramaxul.jdField_a_of_type_Int).putInt("time", paramaxul.jdField_b_of_type_Int).putInt("age", paramaxul.jdField_c_of_type_Int).putInt("xingzuo", paramaxul.e).putInt("key_career", paramaxul.f).putString("key_hometown_country", paramaxul.jdField_d_of_type_ArrayOfJavaLangString[0]).putString("key_hometown_province", paramaxul.jdField_d_of_type_ArrayOfJavaLangString[1]).putString("key_hometown_city", paramaxul.jdField_d_of_type_ArrayOfJavaLangString[2]).putString("key_hometown_string", paramaxul.jdField_a_of_type_JavaLangString).putString("str_country", paramaxul.jdField_b_of_type_JavaLangString).putString("str_province", paramaxul.jdField_c_of_type_JavaLangString).putString("str_city", paramaxul.jdField_d_of_type_JavaLangString).putInt("interest", paramaxul.jdField_d_of_type_Int).commit();
  }
  
  public boolean equals(Object paramObject)
  {
    int i = 0;
    boolean bool1;
    if ((paramObject == null) || (!(paramObject instanceof axul)))
    {
      bool1 = false;
      return bool1;
    }
    paramObject = (axul)paramObject;
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
      if ((this.f != 0) && (this.f < bhhu.e.length))
      {
        String str2 = bhhu.e[this.f];
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = anzj.a(2131706303);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axul
 * JD-Core Version:    0.7.0.1
 */