import android.os.Bundle;

public abstract class biyb
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("_mqqpay_baseapi_appid");
    this.c = paramBundle.getString("_mqqpay_baseapi_apptype");
    this.b = paramBundle.getString("_mqqpay_baseapi_sdkversion");
    this.d = paramBundle.getString("_mqqpay_baseapi_apiname");
    this.jdField_a_of_type_Int = paramBundle.getInt("_mqqpay_baseapi_apimark");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("ai=" + this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("&sv=" + this.b);
    localStringBuilder.append("&at=" + this.c);
    localStringBuilder.append("&an=" + this.d);
    localStringBuilder.append("&am=" + this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biyb
 * JD-Core Version:    0.7.0.1
 */