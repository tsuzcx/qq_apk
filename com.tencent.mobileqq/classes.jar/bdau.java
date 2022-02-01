import org.json.JSONException;
import org.json.JSONObject;

public class bdau
{
  public int a;
  public String a;
  private JSONObject a;
  
  public bdau(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", this.jdField_a_of_type_Int);
      localJSONObject.put("message", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("data", this.jdField_a_of_type_OrgJsonJSONObject);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdau
 * JD-Core Version:    0.7.0.1
 */