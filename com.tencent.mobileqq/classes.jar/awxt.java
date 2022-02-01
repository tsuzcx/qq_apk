import android.os.Bundle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.HashSet;
import java.util.Set;

public class awxt
{
  public int a;
  public long a;
  public Bundle a;
  public String a;
  public Set<String> a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f = "";
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  
  public awxt(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.h = a(paramString, paramInt);
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramInt + "_" + paramString;
  }
  
  public static String[] a(String paramString)
  {
    return paramString.split("_");
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Long > NetConnInfoCenter.getServerTimeMillis();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Long > NetConnInfoCenter.getServerTimeMillis();
  }
  
  public String toString()
  {
    return "MiniAppInfo: appId=" + this.jdField_a_of_type_JavaLangString + ", appType=" + this.jdField_a_of_type_Int + ", platform=" + this.jdField_b_of_type_Int + ", appName=" + this.jdField_b_of_type_JavaLangString + ", appState=" + this.jdField_c_of_type_Int + ", appVersion=" + this.d + ", appPkgUrl=" + this.f + ", wording=" + this.g + ", infoNextReqMillis=" + this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxt
 * JD-Core Version:    0.7.0.1
 */