import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arpq
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static arpq a(araj[] paramArrayOfaraj)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocAIOPlusPanelEntryConfigBean", 2, "AIO_TENCENTDOC_ENTRY_CONFIG handleAioPlusPenalTencentDocEntryCofig");
    }
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0))
    {
      paramArrayOfaraj = null;
      return paramArrayOfaraj;
    }
    arpq localarpq = new arpq();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaraj[0].jdField_a_of_type_JavaLangString);
        paramArrayOfaraj = localarpq;
        if (!localJSONObject.has("tencentDocAioSendEntry")) {
          break;
        }
        localJSONObject = localJSONObject.getJSONObject("tencentDocAioSendEntry");
        if (localJSONObject.has("aioSendDocSwitch"))
        {
          if (localJSONObject.getInt("aioSendDocSwitch") == 1) {
            localarpq.jdField_a_of_type_Boolean = bool;
          }
        }
        else
        {
          paramArrayOfaraj = localarpq;
          if (!localJSONObject.has("webDocSelectorUrl")) {
            break;
          }
          localarpq.jdField_a_of_type_JavaLangString = localJSONObject.getString("webDocSelectorUrl");
          return localarpq;
        }
      }
      catch (JSONException paramArrayOfaraj)
      {
        paramArrayOfaraj.printStackTrace();
        return localarpq;
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
 * Qualified Name:     arpq
 * JD-Core Version:    0.7.0.1
 */