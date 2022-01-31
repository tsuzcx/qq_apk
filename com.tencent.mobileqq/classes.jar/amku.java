import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amku
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static amku a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      paramArrayOfalzs = null;
    }
    amku localamku;
    for (;;)
    {
      return paramArrayOfalzs;
      localamku = new amku();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfalzs[0].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("AndroidGroupListJumpURL"))
        {
          localamku.jdField_a_of_type_JavaLangString = localJSONObject.getString("AndroidGroupListJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig mAndroidGroupListJumpURL = " + localamku.jdField_a_of_type_JavaLangString);
          }
        }
        paramArrayOfalzs = localamku;
        if (localJSONObject.has("AndroidGroupListWebEnable"))
        {
          localamku.jdField_a_of_type_Boolean = localJSONObject.getBoolean("AndroidGroupListWebEnable");
          paramArrayOfalzs = localamku;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig AndroidGroupListWebEnable = " + localamku.jdField_a_of_type_Boolean);
            return localamku;
          }
        }
      }
      catch (JSONException paramArrayOfalzs)
      {
        paramArrayOfalzs.printStackTrace();
      }
    }
    return localamku;
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
 * Qualified Name:     amku
 * JD-Core Version:    0.7.0.1
 */