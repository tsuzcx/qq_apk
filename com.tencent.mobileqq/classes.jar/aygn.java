import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aygn
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public static aygn a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if ((paramJSONObject.has("retcode")) && (paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.has("data")))
        {
          aygn localaygn = new aygn();
          paramJSONObject = paramJSONObject.getJSONObject("data");
          if (paramJSONObject != null)
          {
            localaygn.jdField_a_of_type_JavaLangString = paramJSONObject.optString("url");
            localaygn.jdField_b_of_type_JavaLangString = paramJSONObject.optString("title");
            localaygn.jdField_a_of_type_Int = paramJSONObject.optInt("localPadId");
            localaygn.c = paramJSONObject.optString("localPadId");
            localaygn.d = paramJSONObject.optString("doc_id");
            localaygn.jdField_b_of_type_Int = paramJSONObject.optInt("doc_type");
            localaygn.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isCache");
          }
          return localaygn;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aygn
 * JD-Core Version:    0.7.0.1
 */