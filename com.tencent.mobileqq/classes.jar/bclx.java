import org.json.JSONException;
import org.json.JSONObject;

public class bclx
{
  public static bclx[] a;
  public String a;
  
  static
  {
    jdField_a_of_type_ArrayOfBclx = new bclx[] { new bclx("BulkChatMessageConfig") };
  }
  
  public bclx(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  final JSONObject a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      return a(paramString);
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString = new JSONObject();
      }
    }
  }
  
  JSONObject a(JSONObject paramJSONObject)
  {
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bclx
 * JD-Core Version:    0.7.0.1
 */