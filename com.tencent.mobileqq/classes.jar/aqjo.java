import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqjo
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static aqjo a(aptx[] paramArrayOfaptx)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocAIOPlusPanelEntryConfigBean", 2, "AIO_TENCENTDOC_ENTRY_CONFIG handleAioPlusPenalTencentDocEntryCofig");
    }
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0))
    {
      paramArrayOfaptx = null;
      return paramArrayOfaptx;
    }
    aqjo localaqjo = new aqjo();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaptx[0].jdField_a_of_type_JavaLangString);
        paramArrayOfaptx = localaqjo;
        if (!localJSONObject.has("tencentDocAioSendEntry")) {
          break;
        }
        localJSONObject = localJSONObject.getJSONObject("tencentDocAioSendEntry");
        if (localJSONObject.has("aioSendDocSwitch"))
        {
          if (localJSONObject.getInt("aioSendDocSwitch") == 1) {
            localaqjo.jdField_a_of_type_Boolean = bool;
          }
        }
        else
        {
          paramArrayOfaptx = localaqjo;
          if (!localJSONObject.has("webDocSelectorUrl")) {
            break;
          }
          localaqjo.jdField_a_of_type_JavaLangString = localJSONObject.getString("webDocSelectorUrl");
          return localaqjo;
        }
      }
      catch (JSONException paramArrayOfaptx)
      {
        paramArrayOfaptx.printStackTrace();
        return localaqjo;
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
 * Qualified Name:     aqjo
 * JD-Core Version:    0.7.0.1
 */