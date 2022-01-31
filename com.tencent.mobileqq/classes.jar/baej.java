import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class baej
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public static baej a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if ((paramJSONObject.has("retcode")) && (paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.has("data")))
        {
          baej localbaej = new baej();
          paramJSONObject = paramJSONObject.getJSONObject("data");
          if (paramJSONObject != null)
          {
            localbaej.jdField_a_of_type_JavaLangString = paramJSONObject.optString("url");
            localbaej.jdField_b_of_type_JavaLangString = paramJSONObject.optString("title");
            localbaej.jdField_a_of_type_Int = paramJSONObject.optInt("localPadId");
            localbaej.c = paramJSONObject.optString("localPadId");
            localbaej.d = paramJSONObject.optString("doc_id");
            localbaej.jdField_b_of_type_Int = paramJSONObject.optInt("doc_type");
            localbaej.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isCache");
          }
          return localbaej;
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
 * Qualified Name:     baej
 * JD-Core Version:    0.7.0.1
 */