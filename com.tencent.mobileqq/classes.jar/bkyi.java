import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bkyi
{
  public static final Object a;
  private static String a;
  private static String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      Object localObject = BaseApplicationImpl.getContext();
      if (localObject == null) {
        break label65;
      }
      localObject = ((Context)localObject).getFilesDir();
      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
        jdField_a_of_type_JavaLangString = ((File)localObject).getParent() + "/txlib/" + "cmshow/";
      }
    }
    for (;;)
    {
      return jdField_a_of_type_JavaLangString;
      label65:
      QLog.w("ApolloSoLoader_preLoader", 2, "getSoLibPath but context is null");
    }
  }
  
  public static void a(String paramString)
  {
    QLog.d("ApolloSoLoader_preLoader", 1, new Object[] { "setLibJscPath, libJscPath=", paramString });
    b = paramString;
    BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4).edit().putString("apollo_sp_key_jsc_lib_path", paramString).commit();
  }
  
  public static String b()
  {
    if (TextUtils.isEmpty(b)) {
      b = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4).getString("apollo_sp_key_jsc_lib_path", null);
    }
    QLog.d("ApolloSoLoader_preLoader", 1, new Object[] { "getLibJscPath, sLibJscPath=", b });
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyi
 * JD-Core Version:    0.7.0.1
 */