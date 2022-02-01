import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class armv
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static armv a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      paramArrayOfaqxa = null;
    }
    armv localarmv;
    for (;;)
    {
      return paramArrayOfaqxa;
      localarmv = new armv();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("AndroidGroupListJumpURL"))
        {
          localarmv.jdField_a_of_type_JavaLangString = localJSONObject.getString("AndroidGroupListJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig mAndroidGroupListJumpURL = " + localarmv.jdField_a_of_type_JavaLangString);
          }
        }
        paramArrayOfaqxa = localarmv;
        if (localJSONObject.has("AndroidGroupListWebEnable"))
        {
          localarmv.jdField_a_of_type_Boolean = localJSONObject.getBoolean("AndroidGroupListWebEnable");
          paramArrayOfaqxa = localarmv;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig AndroidGroupListWebEnable = " + localarmv.jdField_a_of_type_Boolean);
            return localarmv;
          }
        }
      }
      catch (JSONException paramArrayOfaqxa)
      {
        paramArrayOfaqxa.printStackTrace();
      }
    }
    return localarmv;
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
 * Qualified Name:     armv
 * JD-Core Version:    0.7.0.1
 */