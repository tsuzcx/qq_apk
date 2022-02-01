import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class armz
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static armz a(aqxa[] paramArrayOfaqxa)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocAIOPlusPanelEntryConfigBean", 2, "AIO_TENCENTDOC_ENTRY_CONFIG handleAioPlusPenalTencentDocEntryCofig");
    }
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0))
    {
      paramArrayOfaqxa = null;
      return paramArrayOfaqxa;
    }
    armz localarmz = new armz();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString);
        paramArrayOfaqxa = localarmz;
        if (!localJSONObject.has("tencentDocAioSendEntry")) {
          break;
        }
        localJSONObject = localJSONObject.getJSONObject("tencentDocAioSendEntry");
        if (localJSONObject.has("aioSendDocSwitch"))
        {
          if (localJSONObject.getInt("aioSendDocSwitch") == 1) {
            localarmz.jdField_a_of_type_Boolean = bool;
          }
        }
        else
        {
          paramArrayOfaqxa = localarmz;
          if (!localJSONObject.has("webDocSelectorUrl")) {
            break;
          }
          localarmz.jdField_a_of_type_JavaLangString = localJSONObject.getString("webDocSelectorUrl");
          return localarmz;
        }
      }
      catch (JSONException paramArrayOfaqxa)
      {
        paramArrayOfaqxa.printStackTrace();
        return localarmz;
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
 * Qualified Name:     armz
 * JD-Core Version:    0.7.0.1
 */