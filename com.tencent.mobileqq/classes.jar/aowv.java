import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aowv
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static aowv a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      paramArrayOfaoko = null;
    }
    aowv localaowv;
    for (;;)
    {
      return paramArrayOfaoko;
      localaowv = new aowv();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaoko[0].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("AndroidGroupListJumpURL"))
        {
          localaowv.jdField_a_of_type_JavaLangString = localJSONObject.getString("AndroidGroupListJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig mAndroidGroupListJumpURL = " + localaowv.jdField_a_of_type_JavaLangString);
          }
        }
        paramArrayOfaoko = localaowv;
        if (localJSONObject.has("AndroidGroupListWebEnable"))
        {
          localaowv.jdField_a_of_type_Boolean = localJSONObject.getBoolean("AndroidGroupListWebEnable");
          paramArrayOfaoko = localaowv;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig AndroidGroupListWebEnable = " + localaowv.jdField_a_of_type_Boolean);
            return localaowv;
          }
        }
      }
      catch (JSONException paramArrayOfaoko)
      {
        paramArrayOfaoko.printStackTrace();
      }
    }
    return localaowv;
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
 * Qualified Name:     aowv
 * JD-Core Version:    0.7.0.1
 */