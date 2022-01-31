import android.text.TextUtils;
import java.io.File;
import java.util.regex.Pattern;

public class aonk
{
  public static int a;
  public static final String a;
  public static boolean a;
  public static final char[] a;
  public static final String[] a;
  public static int b;
  public static final String b;
  public static final char[] b;
  public static int c;
  public static final String c;
  public static int d;
  public static int e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "file:///android_asset" + File.separator + "Page/system/qapp_center_ico_loading.gif";
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
    d = 4;
    e = 5;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { ".doc|.docx|.wps|.pages|", ".xls|.xlsx|.et|.numbers|" };
    jdField_a_of_type_ArrayOfChar = new char[] { '…' };
    jdField_b_of_type_JavaLangString = new String(jdField_a_of_type_ArrayOfChar);
    jdField_b_of_type_ArrayOfChar = new char[] { '‥' };
    jdField_c_of_type_JavaLangString = new String(jdField_b_of_type_ArrayOfChar);
  }
  
  public static final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.matches("(https|http)?(://)?docs.qq.com/(doc|sheet|slide|form/edit|form/fill)/.*", paramString);
  }
  
  public static final boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.matches("(https|http)?(://)?docs.qq.com/(doc)/.*", paramString);
  }
  
  public static final boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.matches("(https|http)?(://)?docs.qq.com/(sheet)/.*", paramString);
  }
  
  public static final boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.matches("(https|http)?(://)?docs.qq.com/(slide)/.*", paramString);
  }
  
  public static final boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.matches("(https|http)?(://)?docs.qq.com/(form/edit|form/fill)/.*", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aonk
 * JD-Core Version:    0.7.0.1
 */