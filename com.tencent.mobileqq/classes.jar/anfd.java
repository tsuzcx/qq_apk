import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class anfd
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
  
  public anfd()
  {
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public static anfd a(String paramString)
  {
    anfd localanfd = new anfd();
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramString);
      localanfd.jdField_b_of_type_Int = localJSONObject2.optInt("product_type");
      JSONObject localJSONObject3 = localJSONObject2.optJSONObject("display_info");
      JSONObject localJSONObject1 = localJSONObject3.optJSONObject("video_info");
      localanfd.jdField_b_of_type_JavaLangString = localJSONObject1.optString("tencent_video_id");
      localanfd.jdField_a_of_type_Int = localJSONObject3.optInt("creative_size");
      JSONObject localJSONObject4 = localJSONObject3.optJSONObject("basic_info");
      localanfd.h = localJSONObject4.optString("img");
      localanfd.e = localJSONObject4.optString("txt");
      localJSONObject3 = localJSONObject3.optJSONObject("advertiser_info");
      localanfd.jdField_c_of_type_Int = localJSONObject3.optInt("advertiser_id");
      localanfd.f = localJSONObject3.optString("corporate_logo");
      localanfd.d = localJSONObject3.optString("corporate_image_name");
      localJSONObject3 = localJSONObject2.optJSONObject("report_info");
      localanfd.g = localJSONObject3.optString("click_url");
      localanfd.jdField_c_of_type_JavaLangString = localJSONObject3.optString("exposure_url");
      localJSONObject2 = localJSONObject2.optJSONObject("app_info");
      localanfd.jdField_a_of_type_Long = localJSONObject2.optLong("download_num");
      localanfd.j = localJSONObject1.optString("video_url");
      if ((!TextUtils.isEmpty(localanfd.j)) && (localanfd.j.startsWith("https://"))) {
        localanfd.j = localanfd.j.replaceFirst("https://", "http://");
      }
      if (localJSONObject2.has("app_score_num")) {
        localanfd.jdField_a_of_type_Double = localJSONObject2.optDouble("app_score_num");
      }
      localanfd.i = paramString;
      return localanfd;
    }
    catch (Throwable paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramString, new Object[0]);
    }
    return localanfd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfd
 * JD-Core Version:    0.7.0.1
 */