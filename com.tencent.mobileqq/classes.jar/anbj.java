import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class anbj
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static anbj a(amph[] paramArrayOfamph)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocAIOPlusPanelEntryConfigBean", 2, "AIO_TENCENTDOC_ENTRY_CONFIG handleAioPlusPenalTencentDocEntryCofig");
    }
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0))
    {
      paramArrayOfamph = null;
      return paramArrayOfamph;
    }
    anbj localanbj = new anbj();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfamph[0].jdField_a_of_type_JavaLangString);
        paramArrayOfamph = localanbj;
        if (!localJSONObject.has("tencentDocAioSendEntry")) {
          break;
        }
        localJSONObject = localJSONObject.getJSONObject("tencentDocAioSendEntry");
        if (localJSONObject.has("aioSendDocSwitch"))
        {
          if (localJSONObject.getInt("aioSendDocSwitch") == 1) {
            localanbj.jdField_a_of_type_Boolean = bool;
          }
        }
        else
        {
          paramArrayOfamph = localanbj;
          if (!localJSONObject.has("webDocSelectorUrl")) {
            break;
          }
          localanbj.jdField_a_of_type_JavaLangString = localJSONObject.getString("webDocSelectorUrl");
          return localanbj;
        }
      }
      catch (JSONException paramArrayOfamph)
      {
        paramArrayOfamph.printStackTrace();
        return localanbj;
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
 * Qualified Name:     anbj
 * JD-Core Version:    0.7.0.1
 */