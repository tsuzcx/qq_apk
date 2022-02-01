import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqwr
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static aqwr a(String paramString)
  {
    aqwr localaqwr = new aqwr();
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("deep_clean_switch")) {
        localaqwr.jdField_a_of_type_Int = localJSONObject.optInt("deep_clean_switch");
      }
      if (localJSONObject.has("already_installed_tip")) {
        localaqwr.jdField_a_of_type_JavaLangString = localJSONObject.optString("already_installed_tip");
      }
      if (localJSONObject.has("first_not_installed_tip")) {
        localaqwr.b = localJSONObject.optString("first_not_installed_tip");
      }
      if (localJSONObject.has("second_not_installed_tip")) {
        localaqwr.c = localJSONObject.optString("second_not_installed_tip");
      }
      if (localJSONObject.has("third_not_installed_tip")) {
        localaqwr.d = localJSONObject.optString("third_not_installed_tip");
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DeepCleanConfigProcessor", 2, "parse DeepCleanConfigBean: " + paramString);
    }
    return localaqwr;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqwr
 * JD-Core Version:    0.7.0.1
 */