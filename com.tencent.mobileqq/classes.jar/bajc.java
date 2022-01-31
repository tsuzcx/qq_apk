import org.json.JSONException;
import org.json.JSONObject;

public class bajc
{
  public static bajc[] a;
  public String a;
  
  static
  {
    jdField_a_of_type_ArrayOfBajc = new bajc[] { new bajc("BulkChatMessageConfig") };
  }
  
  public bajc(String paramString)
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
 * Qualified Name:     bajc
 * JD-Core Version:    0.7.0.1
 */