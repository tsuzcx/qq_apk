import org.json.JSONException;
import org.json.JSONObject;

public class bgqp
{
  public static bgqp[] a;
  public String a;
  
  static
  {
    jdField_a_of_type_ArrayOfBgqp = new bgqp[] { new bgqp("BulkChatMessageConfig") };
  }
  
  public bgqp(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgqp
 * JD-Core Version:    0.7.0.1
 */