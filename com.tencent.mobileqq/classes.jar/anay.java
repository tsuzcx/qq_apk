import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class anay
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static anay a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      paramArrayOfampi = null;
    }
    anay localanay;
    for (;;)
    {
      return paramArrayOfampi;
      localanay = new anay();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfampi[0].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("AndroidGroupListJumpURL"))
        {
          localanay.jdField_a_of_type_JavaLangString = localJSONObject.getString("AndroidGroupListJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig mAndroidGroupListJumpURL = " + localanay.jdField_a_of_type_JavaLangString);
          }
        }
        paramArrayOfampi = localanay;
        if (localJSONObject.has("AndroidGroupListWebEnable"))
        {
          localanay.jdField_a_of_type_Boolean = localJSONObject.getBoolean("AndroidGroupListWebEnable");
          paramArrayOfampi = localanay;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig AndroidGroupListWebEnable = " + localanay.jdField_a_of_type_Boolean);
            return localanay;
          }
        }
      }
      catch (JSONException paramArrayOfampi)
      {
        paramArrayOfampi.printStackTrace();
      }
    }
    return localanay;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return null;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anay
 * JD-Core Version:    0.7.0.1
 */