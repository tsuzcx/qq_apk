import android.content.SharedPreferences;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.net.URL;

public class bfri
{
  protected static bfri a;
  protected static final String a;
  protected volatile WeakReference<SharedPreferences> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bfri.class.getName();
  }
  
  public static bfri a()
  {
    try
    {
      if (jdField_a_of_type_Bfri == null) {
        jdField_a_of_type_Bfri = new bfri();
      }
      bfri localbfri = jdField_a_of_type_Bfri;
      return localbfri;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    return a(paramString, null);
  }
  
  public String a(String paramString, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(bfrh.a(bfbm.a().a(), "OpenSettings"));
    }
    String str1 = paramString;
    String str2;
    SharedPreferences localSharedPreferences;
    String str3;
    try
    {
      str2 = new URL(paramString).getHost();
      if (str2 == null)
      {
        str1 = paramString;
        bflp.e(jdField_a_of_type_JavaLangString, "Get host error. url=" + paramString);
        return paramString;
      }
      str1 = paramString;
      localSharedPreferences = (SharedPreferences)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      str1 = paramString;
      if (localSharedPreferences == null) {
        return str1;
      }
      str1 = paramString;
      str3 = localSharedPreferences.getString(str2, null);
      if (str3 != null)
      {
        str1 = paramString;
        if (!str2.equals(str3)) {}
      }
      else
      {
        str1 = paramString;
        bflp.c(jdField_a_of_type_JavaLangString, "host=" + str2 + ", envHost=" + str3);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      bflp.e(jdField_a_of_type_JavaLangString, "getEnvUrl error. url=" + str1);
      return str1;
    }
    if (paramBundle != null)
    {
      str1 = paramString;
      paramBundle.putString("env", localSharedPreferences.getString("OpenEnvironment", "formal"));
    }
    str1 = paramString;
    paramString = paramString.replace(str2, str3);
    str1 = paramString;
    bflp.c(jdField_a_of_type_JavaLangString, "return environment url : " + paramString);
    str1 = paramString;
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfri
 * JD-Core Version:    0.7.0.1
 */