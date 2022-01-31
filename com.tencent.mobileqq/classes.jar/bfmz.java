import android.content.SharedPreferences;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.net.URL;

public class bfmz
{
  protected static bfmz a;
  protected static final String a;
  protected volatile WeakReference<SharedPreferences> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bfmz.class.getName();
  }
  
  public static bfmz a()
  {
    try
    {
      if (jdField_a_of_type_Bfmz == null) {
        jdField_a_of_type_Bfmz = new bfmz();
      }
      bfmz localbfmz = jdField_a_of_type_Bfmz;
      return localbfmz;
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
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(bfmy.a(bexd.a().a(), "OpenSettings"));
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
        bfhg.e(jdField_a_of_type_JavaLangString, "Get host error. url=" + paramString);
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
        bfhg.c(jdField_a_of_type_JavaLangString, "host=" + str2 + ", envHost=" + str3);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      bfhg.e(jdField_a_of_type_JavaLangString, "getEnvUrl error. url=" + str1);
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
    bfhg.c(jdField_a_of_type_JavaLangString, "return environment url : " + paramString);
    str1 = paramString;
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfmz
 * JD-Core Version:    0.7.0.1
 */