import org.json.JSONException;
import org.json.JSONObject;

public class bceh
  extends bcdy
{
  public int a;
  public String a;
  public boolean a;
  public boolean c;
  
  public bceh(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("type", "str");
      this.jdField_a_of_type_OrgJsonJSONObject.put("text", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public bceh(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaLangString.length();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("text");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaLangString.length();
  }
  
  public int b()
  {
    return 0;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("text", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bceh
 * JD-Core Version:    0.7.0.1
 */