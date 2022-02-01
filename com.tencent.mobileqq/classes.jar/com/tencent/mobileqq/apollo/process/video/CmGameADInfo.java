package com.tencent.mobileqq.apollo.process.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class CmGameADInfo
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
  
  public CmGameADInfo()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public static CmGameADInfo a(String paramString)
  {
    CmGameADInfo localCmGameADInfo = new CmGameADInfo();
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramString);
      localCmGameADInfo.jdField_b_of_type_Int = localJSONObject2.optInt("product_type");
      JSONObject localJSONObject3 = localJSONObject2.optJSONObject("display_info");
      JSONObject localJSONObject1 = localJSONObject3.optJSONObject("video_info");
      localCmGameADInfo.jdField_b_of_type_JavaLangString = localJSONObject1.optString("tencent_video_id");
      localCmGameADInfo.jdField_a_of_type_Int = localJSONObject3.optInt("creative_size");
      JSONObject localJSONObject4 = localJSONObject3.optJSONObject("basic_info");
      localCmGameADInfo.h = localJSONObject4.optString("img");
      localCmGameADInfo.e = localJSONObject4.optString("txt");
      localJSONObject3 = localJSONObject3.optJSONObject("advertiser_info");
      localCmGameADInfo.jdField_c_of_type_Int = localJSONObject3.optInt("advertiser_id");
      localCmGameADInfo.f = localJSONObject3.optString("corporate_logo");
      localCmGameADInfo.d = localJSONObject3.optString("corporate_image_name");
      localJSONObject3 = localJSONObject2.optJSONObject("report_info");
      localCmGameADInfo.g = localJSONObject3.optString("click_url");
      localCmGameADInfo.jdField_c_of_type_JavaLangString = localJSONObject3.optString("exposure_url");
      localJSONObject2 = localJSONObject2.optJSONObject("app_info");
      localCmGameADInfo.jdField_a_of_type_Long = localJSONObject2.optLong("download_num");
      localCmGameADInfo.j = localJSONObject1.optString("video_url");
      if ((!TextUtils.isEmpty(localCmGameADInfo.j)) && (localCmGameADInfo.j.startsWith("https://"))) {
        localCmGameADInfo.j = localCmGameADInfo.j.replaceFirst("https://", "http://");
      }
      if (localJSONObject2.has("app_score_num")) {
        localCmGameADInfo.jdField_a_of_type_Double = localJSONObject2.optDouble("app_score_num");
      }
      localCmGameADInfo.i = paramString;
      return localCmGameADInfo;
    }
    catch (Throwable paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramString, new Object[0]);
    }
    return localCmGameADInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameADInfo
 * JD-Core Version:    0.7.0.1
 */