import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bais
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public static bais a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if ((paramJSONObject.has("retcode")) && (paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.has("data")))
        {
          bais localbais = new bais();
          paramJSONObject = paramJSONObject.getJSONObject("data");
          if (paramJSONObject != null)
          {
            localbais.jdField_a_of_type_JavaLangString = paramJSONObject.optString("url");
            localbais.jdField_b_of_type_JavaLangString = paramJSONObject.optString("title");
            localbais.jdField_a_of_type_Int = paramJSONObject.optInt("localPadId");
            localbais.c = paramJSONObject.optString("localPadId");
            localbais.d = paramJSONObject.optString("doc_id");
            localbais.jdField_b_of_type_Int = paramJSONObject.optInt("doc_type");
            localbais.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isCache");
          }
          return localbais;
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
 * Qualified Name:     bais
 * JD-Core Version:    0.7.0.1
 */