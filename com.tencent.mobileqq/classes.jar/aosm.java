import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aosm
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static aosm a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      paramArrayOfaogf = null;
    }
    aosm localaosm;
    for (;;)
    {
      return paramArrayOfaogf;
      localaosm = new aosm();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaogf[0].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("AndroidGroupListJumpURL"))
        {
          localaosm.jdField_a_of_type_JavaLangString = localJSONObject.getString("AndroidGroupListJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig mAndroidGroupListJumpURL = " + localaosm.jdField_a_of_type_JavaLangString);
          }
        }
        paramArrayOfaogf = localaosm;
        if (localJSONObject.has("AndroidGroupListWebEnable"))
        {
          localaosm.jdField_a_of_type_Boolean = localJSONObject.getBoolean("AndroidGroupListWebEnable");
          paramArrayOfaogf = localaosm;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig AndroidGroupListWebEnable = " + localaosm.jdField_a_of_type_Boolean);
            return localaosm;
          }
        }
      }
      catch (JSONException paramArrayOfaogf)
      {
        paramArrayOfaogf.printStackTrace();
      }
    }
    return localaosm;
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
 * Qualified Name:     aosm
 * JD-Core Version:    0.7.0.1
 */