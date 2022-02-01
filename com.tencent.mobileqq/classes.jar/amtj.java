import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amtj
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
  
  public amtj()
  {
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public static amtj a(String paramString)
  {
    amtj localamtj = new amtj();
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramString);
      localamtj.jdField_b_of_type_Int = localJSONObject2.optInt("product_type");
      JSONObject localJSONObject3 = localJSONObject2.optJSONObject("display_info");
      JSONObject localJSONObject1 = localJSONObject3.optJSONObject("video_info");
      localamtj.jdField_b_of_type_JavaLangString = localJSONObject1.optString("tencent_video_id");
      localamtj.jdField_a_of_type_Int = localJSONObject3.optInt("creative_size");
      JSONObject localJSONObject4 = localJSONObject3.optJSONObject("basic_info");
      localamtj.h = localJSONObject4.optString("img");
      localamtj.e = localJSONObject4.optString("txt");
      localJSONObject3 = localJSONObject3.optJSONObject("advertiser_info");
      localamtj.jdField_c_of_type_Int = localJSONObject3.optInt("advertiser_id");
      localamtj.f = localJSONObject3.optString("corporate_logo");
      localamtj.d = localJSONObject3.optString("corporate_image_name");
      localJSONObject3 = localJSONObject2.optJSONObject("report_info");
      localamtj.g = localJSONObject3.optString("click_url");
      localamtj.jdField_c_of_type_JavaLangString = localJSONObject3.optString("exposure_url");
      localJSONObject2 = localJSONObject2.optJSONObject("app_info");
      localamtj.jdField_a_of_type_Long = localJSONObject2.optLong("download_num");
      localamtj.j = localJSONObject1.optString("video_url");
      if ((!TextUtils.isEmpty(localamtj.j)) && (localamtj.j.startsWith("https://"))) {
        localamtj.j = localamtj.j.replaceFirst("https://", "http://");
      }
      if (localJSONObject2.has("app_score_num")) {
        localamtj.jdField_a_of_type_Double = localJSONObject2.optDouble("app_score_num");
      }
      localamtj.i = paramString;
      return localamtj;
    }
    catch (Throwable paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramString, new Object[0]);
    }
    return localamtj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtj
 * JD-Core Version:    0.7.0.1
 */