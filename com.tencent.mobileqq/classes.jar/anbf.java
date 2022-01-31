import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class anbf
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static anbf a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      paramArrayOfamph = null;
    }
    anbf localanbf;
    for (;;)
    {
      return paramArrayOfamph;
      localanbf = new anbf();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfamph[0].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("AndroidGroupListJumpURL"))
        {
          localanbf.jdField_a_of_type_JavaLangString = localJSONObject.getString("AndroidGroupListJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig mAndroidGroupListJumpURL = " + localanbf.jdField_a_of_type_JavaLangString);
          }
        }
        paramArrayOfamph = localanbf;
        if (localJSONObject.has("AndroidGroupListWebEnable"))
        {
          localanbf.jdField_a_of_type_Boolean = localJSONObject.getBoolean("AndroidGroupListWebEnable");
          paramArrayOfamph = localanbf;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig AndroidGroupListWebEnable = " + localanbf.jdField_a_of_type_Boolean);
            return localanbf;
          }
        }
      }
      catch (JSONException paramArrayOfamph)
      {
        paramArrayOfamph.printStackTrace();
      }
    }
    return localanbf;
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
 * Qualified Name:     anbf
 * JD-Core Version:    0.7.0.1
 */