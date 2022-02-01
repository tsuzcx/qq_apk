import android.content.SharedPreferences;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class awrs
{
  public static int a;
  public static long a;
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  boolean a;
  protected int b;
  boolean b;
  protected int c;
  protected int d;
  protected String e = "";
  protected String f = "";
  protected String g = "";
  protected String h = "";
  protected String i = "";
  protected String j = "";
  protected String k = "";
  protected String l = "";
  protected String m = "";
  protected String n = "";
  protected String o = "";
  protected String p = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
    jdField_c_of_type_JavaLangString = "";
    jdField_d_of_type_JavaLangString = "";
  }
  
  public awrs()
  {
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public awrs a()
  {
    this.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public awrs a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.m = String.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + paramQQAppInterface.getCurrentAccountUin(), 4).getInt("charm_level", 0));
    }
    if (this.jdField_b_of_type_Boolean) {
      this.m = ("" + awka.a(paramQQAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1)));
    }
    long l1 = System.currentTimeMillis() - jdField_a_of_type_Long;
    if (l1 % 1000L > 500L) {}
    for (l1 = (int)l1 / 1000 + 1;; l1 = (int)l1 / 1000)
    {
      this.e = (l1 + "");
      this.f = jdField_c_of_type_JavaLangString;
      this.g = jdField_b_of_type_JavaLangString;
      this.h = jdField_a_of_type_JavaLangString;
      this.i = (HttpUtil.getNetWorkType() + "");
      bcef.b(paramQQAppInterface, "dc02676", "grp_lbs", this.l, this.j, this.k, this.jdField_d_of_type_Int, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.m, this.n, this.o, this.p + "|" + this.e + "|" + this.f + "|" + this.g + "|" + this.h + "|" + this.i);
      return;
    }
  }
  
  public awrs b()
  {
    this.jdField_b_of_type_Boolean = true;
    return this;
  }
  
  public awrs b(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramQQAppInterface != null)) {
      this.m = String.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + paramQQAppInterface.getCurrentAccountUin(), 4).getInt("charm_level", 0));
    }
    if ((this.jdField_b_of_type_Boolean) && (paramQQAppInterface != null))
    {
      this.jdField_b_of_type_Boolean = true;
      this.m = String.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + paramQQAppInterface.getCurrentAccountUin(), 4).getInt("gender", 0));
    }
    this.i = (HttpUtil.getNetWorkType() + "");
    bcef.b(paramQQAppInterface, "dc02676", "grp_lbs", this.l, this.j, this.k, this.jdField_d_of_type_Int, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.m, this.n, this.o, this.p + "|" + this.e + "|" + this.f + "|" + this.g + "|" + this.h + "|" + this.i);
  }
  
  public awrs c(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public awrs d(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public awrs e(String paramString)
  {
    this.m = paramString;
    return this;
  }
  
  public awrs f(String paramString)
  {
    this.n = paramString;
    return this;
  }
  
  public awrs g(String paramString)
  {
    this.p = paramString;
    return this;
  }
  
  public awrs h(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public awrs i(String paramString)
  {
    this.k = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrs
 * JD-Core Version:    0.7.0.1
 */