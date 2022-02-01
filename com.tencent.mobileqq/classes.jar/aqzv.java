import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqzv
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static aqzv a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      paramArrayOfaqlg = null;
    }
    aqzv localaqzv;
    for (;;)
    {
      return paramArrayOfaqlg;
      localaqzv = new aqzv();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("AndroidGroupListJumpURL"))
        {
          localaqzv.jdField_a_of_type_JavaLangString = localJSONObject.getString("AndroidGroupListJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig mAndroidGroupListJumpURL = " + localaqzv.jdField_a_of_type_JavaLangString);
          }
        }
        paramArrayOfaqlg = localaqzv;
        if (localJSONObject.has("AndroidGroupListWebEnable"))
        {
          localaqzv.jdField_a_of_type_Boolean = localJSONObject.getBoolean("AndroidGroupListWebEnable");
          paramArrayOfaqlg = localaqzv;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig AndroidGroupListWebEnable = " + localaqzv.jdField_a_of_type_Boolean);
            return localaqzv;
          }
        }
      }
      catch (JSONException paramArrayOfaqlg)
      {
        paramArrayOfaqlg.printStackTrace();
      }
    }
    return localaqzv;
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
 * Qualified Name:     aqzv
 * JD-Core Version:    0.7.0.1
 */