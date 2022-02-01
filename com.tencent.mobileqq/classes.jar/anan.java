import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class anan
{
  public static String a;
  public double a;
  public int a;
  public long a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  
  static
  {
    jdField_a_of_type_JavaLangString = "cmgame_process.CmGameADInfo";
  }
  
  public anan()
  {
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public static anan a(String paramString)
  {
    anan localanan = new anan();
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramString);
      localanan.jdField_b_of_type_Int = localJSONObject2.optInt("product_type");
      JSONObject localJSONObject3 = localJSONObject2.optJSONObject("display_info");
      JSONObject localJSONObject1 = localJSONObject3.optJSONObject("video_info");
      localanan.jdField_b_of_type_JavaLangString = localJSONObject1.optString("tencent_video_id");
      localanan.jdField_a_of_type_Int = localJSONObject3.optInt("creative_size");
      JSONObject localJSONObject4 = localJSONObject3.optJSONObject("basic_info");
      localanan.h = localJSONObject4.optString("img");
      localanan.e = localJSONObject4.optString("txt");
      localJSONObject3 = localJSONObject3.optJSONObject("advertiser_info");
      localanan.jdField_c_of_type_Int = localJSONObject3.optInt("advertiser_id");
      localanan.f = localJSONObject3.optString("corporate_logo");
      localanan.d = localJSONObject3.optString("corporate_image_name");
      localJSONObject3 = localJSONObject2.optJSONObject("report_info");
      localanan.g = localJSONObject3.optString("click_url");
      localanan.jdField_c_of_type_JavaLangString = localJSONObject3.optString("exposure_url");
      localJSONObject2 = localJSONObject2.optJSONObject("app_info");
      localanan.jdField_a_of_type_Long = localJSONObject2.optLong("download_num");
      localanan.j = localJSONObject1.optString("video_url");
      if ((!TextUtils.isEmpty(localanan.j)) && (localanan.j.startsWith("https://"))) {
        localanan.j = localanan.j.replaceFirst("https://", "http://");
      }
      if (localJSONObject2.has("app_score_num")) {
        localanan.jdField_a_of_type_Double = localJSONObject2.optDouble("app_score_num");
      }
      localanan.i = paramString;
      return localanan;
    }
    catch (Throwable paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramString, new Object[0]);
    }
    return localanan;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anan
 * JD-Core Version:    0.7.0.1
 */