import org.json.JSONException;
import org.json.JSONObject;

public class azhl
{
  public static azhl[] a;
  public String a;
  
  static
  {
    jdField_a_of_type_ArrayOfAzhl = new azhl[] { new azhl("BulkChatMessageConfig") };
  }
  
  public azhl(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azhl
 * JD-Core Version:    0.7.0.1
 */