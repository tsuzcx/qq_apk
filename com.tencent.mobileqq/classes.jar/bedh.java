import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bedh
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public static bedh a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if ((paramJSONObject.has("retcode")) && (paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.has("data")))
        {
          bedh localbedh = new bedh();
          paramJSONObject = paramJSONObject.getJSONObject("data");
          if (paramJSONObject != null)
          {
            localbedh.jdField_a_of_type_JavaLangString = paramJSONObject.optString("url");
            localbedh.jdField_b_of_type_JavaLangString = paramJSONObject.optString("title");
            localbedh.jdField_a_of_type_Int = paramJSONObject.optInt("localPadId");
            localbedh.c = paramJSONObject.optString("localPadId");
            localbedh.d = paramJSONObject.optString("doc_id");
            localbedh.jdField_b_of_type_Int = paramJSONObject.optInt("doc_type");
            localbedh.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isCache");
          }
          return localbedh;
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
 * Qualified Name:     bedh
 * JD-Core Version:    0.7.0.1
 */