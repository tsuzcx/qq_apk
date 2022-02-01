import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arpm
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static arpm a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      paramArrayOfaraj = null;
    }
    arpm localarpm;
    for (;;)
    {
      return paramArrayOfaraj;
      localarpm = new arpm();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaraj[0].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("AndroidGroupListJumpURL"))
        {
          localarpm.jdField_a_of_type_JavaLangString = localJSONObject.getString("AndroidGroupListJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig mAndroidGroupListJumpURL = " + localarpm.jdField_a_of_type_JavaLangString);
          }
        }
        paramArrayOfaraj = localarpm;
        if (localJSONObject.has("AndroidGroupListWebEnable"))
        {
          localarpm.jdField_a_of_type_Boolean = localJSONObject.getBoolean("AndroidGroupListWebEnable");
          paramArrayOfaraj = localarpm;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig AndroidGroupListWebEnable = " + localarpm.jdField_a_of_type_Boolean);
            return localarpm;
          }
        }
      }
      catch (JSONException paramArrayOfaraj)
      {
        paramArrayOfaraj.printStackTrace();
      }
    }
    return localarpm;
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
 * Qualified Name:     arpm
 * JD-Core Version:    0.7.0.1
 */