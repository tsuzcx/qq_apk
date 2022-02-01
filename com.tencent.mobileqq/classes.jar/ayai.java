import android.app.Application;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.qphone.base.util.BaseApplication;

public class ayai
{
  private Application jdField_a_of_type_AndroidAppApplication;
  private final Bundle jdField_a_of_type_AndroidOsBundle;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public ayai()
  {
    this(BaseApplication.getContext());
  }
  
  public ayai(Application paramApplication)
  {
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
    this.jdField_a_of_type_JavaLangString = bgln.c();
    this.b = ayam.a();
    this.jdField_a_of_type_AndroidOsBundle = a(this.jdField_a_of_type_AndroidAppApplication);
    this.jdField_a_of_type_AndroidOsBundle.putString("tid", "personal_live_base");
    this.jdField_a_of_type_AndroidOsBundle.putString("bid", "b_sng_im_personal_live");
  }
  
  private Bundle a(Application paramApplication)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("platform", "Android");
    localBundle.putString("uin_type", "0");
    localBundle.putString("manufacturer", Build.MANUFACTURER);
    localBundle.putString("deviceID", String.valueOf(ayam.a(paramApplication)));
    localBundle.putString("osversion", Build.VERSION.RELEASE);
    localBundle.putString("qqversion", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("actiontime", String.valueOf(System.currentTimeMillis() / 1000L));
    localBundle.putString("network", String.valueOf(ayam.a(paramApplication)));
    localBundle.putString("imei", this.b);
    return localBundle;
  }
  
  public ayai a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", paramString);
    return this;
  }
  
  public ayai a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "null";
    }
    this.jdField_a_of_type_AndroidOsBundle.putString(paramString1, str.replace("&", "_"));
    return this;
  }
  
  public void a()
  {
    ayak.a.a(this.jdField_a_of_type_AndroidOsBundle);
  }
  
  public ayai b(String paramString)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString("module", paramString);
    return this;
  }
  
  public ayai c(String paramString)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString("action", paramString);
    return this;
  }
  
  public ayai d(String paramString)
  {
    return a("extcol1", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayai
 * JD-Core Version:    0.7.0.1
 */