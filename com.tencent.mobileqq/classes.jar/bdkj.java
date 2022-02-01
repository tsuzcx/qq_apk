import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class bdkj
{
  private static int jdField_a_of_type_Int = -1;
  public static String a;
  static boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GeneralConfigUtils";
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      jdField_a_of_type_Int = -1;
    }
    try
    {
      paramString2 = Integer.valueOf(paramString2);
      BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putInt(paramString1, paramString2.intValue()).commit();
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "parseConfig(): e = " + paramString1);
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Int == -1) {
      if (BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("pic_thumb_400Enable", 0) == 1)
      {
        jdField_a_of_type_Boolean = true;
        jdField_a_of_type_Int = 1;
      }
    }
    for (;;)
    {
      return jdField_a_of_type_Boolean;
      jdField_a_of_type_Boolean = false;
      jdField_a_of_type_Int = 0;
      continue;
      if (jdField_a_of_type_Int == 1) {
        jdField_a_of_type_Boolean = true;
      } else {
        jdField_a_of_type_Boolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkj
 * JD-Core Version:    0.7.0.1
 */