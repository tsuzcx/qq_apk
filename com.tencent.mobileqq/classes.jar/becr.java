import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class becr
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public static becr a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if ((paramJSONObject.has("retcode")) && (paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.has("data")))
        {
          becr localbecr = new becr();
          paramJSONObject = paramJSONObject.getJSONObject("data");
          if (paramJSONObject != null)
          {
            localbecr.jdField_a_of_type_JavaLangString = paramJSONObject.optString("url");
            localbecr.jdField_b_of_type_JavaLangString = paramJSONObject.optString("title");
            localbecr.jdField_a_of_type_Int = paramJSONObject.optInt("localPadId");
            localbecr.c = paramJSONObject.optString("localPadId");
            localbecr.d = paramJSONObject.optString("doc_id");
            localbecr.jdField_b_of_type_Int = paramJSONObject.optInt("doc_type");
            localbecr.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isCache");
          }
          return localbecr;
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
 * Qualified Name:     becr
 * JD-Core Version:    0.7.0.1
 */