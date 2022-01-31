import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amky
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static amky a(alzs[] paramArrayOfalzs)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocAIOPlusPanelEntryConfigBean", 2, "AIO_TENCENTDOC_ENTRY_CONFIG handleAioPlusPenalTencentDocEntryCofig");
    }
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0))
    {
      paramArrayOfalzs = null;
      return paramArrayOfalzs;
    }
    amky localamky = new amky();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfalzs[0].jdField_a_of_type_JavaLangString);
        paramArrayOfalzs = localamky;
        if (!localJSONObject.has("tencentDocAioSendEntry")) {
          break;
        }
        localJSONObject = localJSONObject.getJSONObject("tencentDocAioSendEntry");
        if (localJSONObject.has("aioSendDocSwitch"))
        {
          if (localJSONObject.getInt("aioSendDocSwitch") == 1) {
            localamky.jdField_a_of_type_Boolean = bool;
          }
        }
        else
        {
          paramArrayOfalzs = localamky;
          if (!localJSONObject.has("webDocSelectorUrl")) {
            break;
          }
          localamky.jdField_a_of_type_JavaLangString = localJSONObject.getString("webDocSelectorUrl");
          return localamky;
        }
      }
      catch (JSONException paramArrayOfalzs)
      {
        paramArrayOfalzs.printStackTrace();
        return localamky;
      }
      bool = false;
    }
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
 * Qualified Name:     amky
 * JD-Core Version:    0.7.0.1
 */