import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bdjw
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public static bdjw a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if ((paramJSONObject.has("retcode")) && (paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.has("data")))
        {
          bdjw localbdjw = new bdjw();
          paramJSONObject = paramJSONObject.getJSONObject("data");
          if (paramJSONObject != null)
          {
            localbdjw.jdField_a_of_type_JavaLangString = paramJSONObject.optString("url");
            localbdjw.jdField_b_of_type_JavaLangString = paramJSONObject.optString("title");
            localbdjw.jdField_a_of_type_Int = paramJSONObject.optInt("localPadId");
            localbdjw.c = paramJSONObject.optString("localPadId");
            localbdjw.d = paramJSONObject.optString("doc_id");
            localbdjw.jdField_b_of_type_Int = paramJSONObject.optInt("doc_type");
            localbdjw.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isCache");
          }
          return localbdjw;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("ImportFormData", 1, paramJSONObject.getLocalizedMessage(), paramJSONObject);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjw
 * JD-Core Version:    0.7.0.1
 */