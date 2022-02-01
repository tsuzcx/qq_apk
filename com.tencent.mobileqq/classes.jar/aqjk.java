import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqjk
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static aqjk a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      paramArrayOfaptx = null;
    }
    aqjk localaqjk;
    for (;;)
    {
      return paramArrayOfaptx;
      localaqjk = new aqjk();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaptx[0].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("AndroidGroupListJumpURL"))
        {
          localaqjk.jdField_a_of_type_JavaLangString = localJSONObject.getString("AndroidGroupListJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig mAndroidGroupListJumpURL = " + localaqjk.jdField_a_of_type_JavaLangString);
          }
        }
        paramArrayOfaptx = localaqjk;
        if (localJSONObject.has("AndroidGroupListWebEnable"))
        {
          localaqjk.jdField_a_of_type_Boolean = localJSONObject.getBoolean("AndroidGroupListWebEnable");
          paramArrayOfaptx = localaqjk;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig AndroidGroupListWebEnable = " + localaqjk.jdField_a_of_type_Boolean);
            return localaqjk;
          }
        }
      }
      catch (JSONException paramArrayOfaptx)
      {
        paramArrayOfaptx.printStackTrace();
      }
    }
    return localaqjk;
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
 * Qualified Name:     aqjk
 * JD-Core Version:    0.7.0.1
 */