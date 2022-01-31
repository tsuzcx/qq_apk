import BOSSStrategyCenter.tAdvDesc;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bgqo
  extends ahac
{
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public String g;
  public String h;
  
  public bgqo(tAdvDesc paramtAdvDesc)
  {
    super(paramtAdvDesc);
  }
  
  protected void a()
  {
    super.a();
    if ((this.a == null) || (TextUtils.isEmpty(this.a.res_data)))
    {
      QLog.e("QbossADBannerConfigInfo", 1, "parseJsonFromAdvDesc error with data = null");
      return;
    }
    String str = this.a.res_data;
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      this.jdField_d_of_type_Int = localJSONObject.optInt("enableCountdown");
      this.jdField_e_of_type_Int = localJSONObject.optInt("countdownMinute");
      this.jdField_f_of_type_Int = localJSONObject.optInt("countdownSecond");
      this.c = localJSONObject.optString("topText");
      this.jdField_d_of_type_JavaLangString = localJSONObject.optString("bottomText");
      this.jdField_e_of_type_JavaLangString = localJSONObject.optString("textColor");
      this.jdField_f_of_type_JavaLangString = localJSONObject.optString("coutdownBgColor");
      this.g = localJSONObject.optString("coutdownTextColor");
      this.h = localJSONObject.optString("buttonTitle");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QbossADBannerConfigInfo", 1, "qboss banner parseJson error msg = " + localException.getMessage());
      bgbr.a().a(2741, this.a.task_id, 102, "CountDownBanner json parseError exception = " + localException.getMessage() + " json string = " + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgqo
 * JD-Core Version:    0.7.0.1
 */