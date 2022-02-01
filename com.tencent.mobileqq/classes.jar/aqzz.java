import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqzz
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static aqzz a(aqlg[] paramArrayOfaqlg)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocAIOPlusPanelEntryConfigBean", 2, "AIO_TENCENTDOC_ENTRY_CONFIG handleAioPlusPenalTencentDocEntryCofig");
    }
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0))
    {
      paramArrayOfaqlg = null;
      return paramArrayOfaqlg;
    }
    aqzz localaqzz = new aqzz();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString);
        paramArrayOfaqlg = localaqzz;
        if (!localJSONObject.has("tencentDocAioSendEntry")) {
          break;
        }
        localJSONObject = localJSONObject.getJSONObject("tencentDocAioSendEntry");
        if (localJSONObject.has("aioSendDocSwitch"))
        {
          if (localJSONObject.getInt("aioSendDocSwitch") == 1) {
            localaqzz.jdField_a_of_type_Boolean = bool;
          }
        }
        else
        {
          paramArrayOfaqlg = localaqzz;
          if (!localJSONObject.has("webDocSelectorUrl")) {
            break;
          }
          localaqzz.jdField_a_of_type_JavaLangString = localJSONObject.getString("webDocSelectorUrl");
          return localaqzz;
        }
      }
      catch (JSONException paramArrayOfaqlg)
      {
        paramArrayOfaqlg.printStackTrace();
        return localaqzz;
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
 * Qualified Name:     aqzz
 * JD-Core Version:    0.7.0.1
 */