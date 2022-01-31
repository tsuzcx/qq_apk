import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aosq
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static aosq a(aogf[] paramArrayOfaogf)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocAIOPlusPanelEntryConfigBean", 2, "AIO_TENCENTDOC_ENTRY_CONFIG handleAioPlusPenalTencentDocEntryCofig");
    }
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0))
    {
      paramArrayOfaogf = null;
      return paramArrayOfaogf;
    }
    aosq localaosq = new aosq();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaogf[0].jdField_a_of_type_JavaLangString);
        paramArrayOfaogf = localaosq;
        if (!localJSONObject.has("tencentDocAioSendEntry")) {
          break;
        }
        localJSONObject = localJSONObject.getJSONObject("tencentDocAioSendEntry");
        if (localJSONObject.has("aioSendDocSwitch"))
        {
          if (localJSONObject.getInt("aioSendDocSwitch") == 1) {
            localaosq.jdField_a_of_type_Boolean = bool;
          }
        }
        else
        {
          paramArrayOfaogf = localaosq;
          if (!localJSONObject.has("webDocSelectorUrl")) {
            break;
          }
          localaosq.jdField_a_of_type_JavaLangString = localJSONObject.getString("webDocSelectorUrl");
          return localaosq;
        }
      }
      catch (JSONException paramArrayOfaogf)
      {
        paramArrayOfaogf.printStackTrace();
        return localaosq;
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
 * Qualified Name:     aosq
 * JD-Core Version:    0.7.0.1
 */