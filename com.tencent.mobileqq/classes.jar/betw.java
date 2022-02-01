import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;

public class betw
  extends betu
{
  public int a;
  public qq_ad_get.QQAdGetRsp.AdInfo a;
  public int b;
  public boolean b;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public betw(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = ((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(achn.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject)));
    this.jdField_a_of_type_Int = paramJSONObject.optInt("product_type");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("display_info");
    JSONObject localJSONObject2 = localJSONObject1.optJSONObject("basic_info");
    this.b = localJSONObject2.optString("img");
    this.f = localJSONObject2.optString("txt");
    localJSONObject2 = localJSONObject1.optJSONObject("video_info");
    this.jdField_a_of_type_JavaLangString = localJSONObject2.optString("video_url");
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.startsWith("https"))) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.replaceFirst("https", "http");
    }
    this.jdField_a_of_type_Long = (localJSONObject2.optInt("media_duration") * 1000);
    if (this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo != null) {
      if (this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.display_info.basic_info.pic_width.get() / this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.display_info.basic_info.pic_height.get() <= 0.75F) {
        break label293;
      }
    }
    label293:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      localJSONObject1 = localJSONObject1.optJSONObject("advertiser_info");
      this.d = localJSONObject1.optString("corporate_image_name");
      this.e = localJSONObject1.optString("corporate_logo");
      localJSONObject1 = paramJSONObject.optJSONObject("report_info");
      this.h = localJSONObject1.optString("negative_feedback_url");
      if (!TextUtils.isEmpty(this.h)) {
        this.h = this.h.replace("__ACT_TYPE__", "2001");
      }
      this.i = localJSONObject1.optString("exposure_url");
      this.g = paramJSONObject.optJSONObject("app_info").optString("app_package_name");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betw
 * JD-Core Version:    0.7.0.1
 */