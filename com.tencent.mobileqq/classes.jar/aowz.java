import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aowz
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static aowz a(aoko[] paramArrayOfaoko)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocAIOPlusPanelEntryConfigBean", 2, "AIO_TENCENTDOC_ENTRY_CONFIG handleAioPlusPenalTencentDocEntryCofig");
    }
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0))
    {
      paramArrayOfaoko = null;
      return paramArrayOfaoko;
    }
    aowz localaowz = new aowz();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaoko[0].jdField_a_of_type_JavaLangString);
        paramArrayOfaoko = localaowz;
        if (!localJSONObject.has("tencentDocAioSendEntry")) {
          break;
        }
        localJSONObject = localJSONObject.getJSONObject("tencentDocAioSendEntry");
        if (localJSONObject.has("aioSendDocSwitch"))
        {
          if (localJSONObject.getInt("aioSendDocSwitch") == 1) {
            localaowz.jdField_a_of_type_Boolean = bool;
          }
        }
        else
        {
          paramArrayOfaoko = localaowz;
          if (!localJSONObject.has("webDocSelectorUrl")) {
            break;
          }
          localaowz.jdField_a_of_type_JavaLangString = localJSONObject.getString("webDocSelectorUrl");
          return localaowz;
        }
      }
      catch (JSONException paramArrayOfaoko)
      {
        paramArrayOfaoko.printStackTrace();
        return localaowz;
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
 * Qualified Name:     aowz
 * JD-Core Version:    0.7.0.1
 */