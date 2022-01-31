import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aygl
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public static aygl a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if ((paramJSONObject.has("retcode")) && (paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.has("data")))
        {
          aygl localaygl = new aygl();
          paramJSONObject = paramJSONObject.getJSONObject("data");
          if (paramJSONObject != null)
          {
            localaygl.jdField_a_of_type_JavaLangString = paramJSONObject.optString("url");
            localaygl.jdField_b_of_type_JavaLangString = paramJSONObject.optString("title");
            localaygl.jdField_a_of_type_Int = paramJSONObject.optInt("localPadId");
            localaygl.c = paramJSONObject.optString("localPadId");
            localaygl.d = paramJSONObject.optString("doc_id");
            localaygl.jdField_b_of_type_Int = paramJSONObject.optInt("doc_type");
            localaygl.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isCache");
          }
          return localaygl;
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
 * Qualified Name:     aygl
 * JD-Core Version:    0.7.0.1
 */