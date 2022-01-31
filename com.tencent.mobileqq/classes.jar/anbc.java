import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class anbc
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static anbc a(ampi[] paramArrayOfampi)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocAIOPlusPanelEntryConfigBean", 2, "AIO_TENCENTDOC_ENTRY_CONFIG handleAioPlusPenalTencentDocEntryCofig");
    }
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0))
    {
      paramArrayOfampi = null;
      return paramArrayOfampi;
    }
    anbc localanbc = new anbc();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfampi[0].jdField_a_of_type_JavaLangString);
        paramArrayOfampi = localanbc;
        if (!localJSONObject.has("tencentDocAioSendEntry")) {
          break;
        }
        localJSONObject = localJSONObject.getJSONObject("tencentDocAioSendEntry");
        if (localJSONObject.has("aioSendDocSwitch"))
        {
          if (localJSONObject.getInt("aioSendDocSwitch") == 1) {
            localanbc.jdField_a_of_type_Boolean = bool;
          }
        }
        else
        {
          paramArrayOfampi = localanbc;
          if (!localJSONObject.has("webDocSelectorUrl")) {
            break;
          }
          localanbc.jdField_a_of_type_JavaLangString = localJSONObject.getString("webDocSelectorUrl");
          return localanbc;
        }
      }
      catch (JSONException paramArrayOfampi)
      {
        paramArrayOfampi.printStackTrace();
        return localanbc;
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
 * Qualified Name:     anbc
 * JD-Core Version:    0.7.0.1
 */