import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bcwi
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public static bcwi a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if ((paramJSONObject.has("retcode")) && (paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.has("data")))
        {
          bcwi localbcwi = new bcwi();
          paramJSONObject = paramJSONObject.getJSONObject("data");
          if (paramJSONObject != null)
          {
            localbcwi.jdField_a_of_type_JavaLangString = paramJSONObject.optString("url");
            localbcwi.jdField_b_of_type_JavaLangString = paramJSONObject.optString("title");
            localbcwi.jdField_a_of_type_Int = paramJSONObject.optInt("localPadId");
            localbcwi.c = paramJSONObject.optString("localPadId");
            localbcwi.d = paramJSONObject.optString("doc_id");
            localbcwi.jdField_b_of_type_Int = paramJSONObject.optInt("doc_type");
            localbcwi.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isCache");
          }
          return localbcwi;
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
 * Qualified Name:     bcwi
 * JD-Core Version:    0.7.0.1
 */