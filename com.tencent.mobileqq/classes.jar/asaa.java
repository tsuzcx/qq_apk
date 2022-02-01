import org.json.JSONException;
import org.json.JSONObject;

public class asaa
  extends aryz
{
  public asab a;
  public String b;
  public boolean b;
  
  public static asaa a(JSONObject paramJSONObject)
  {
    asaa localasaa = new asaa();
    localasaa.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name");
    localasaa.jdField_b_of_type_JavaLangString = paramJSONObject.optString("action");
    localasaa.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isChecked", true);
    localasaa.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("isAddByUser");
    return localasaa;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("action", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("isChecked", this.jdField_a_of_type_Boolean);
      localJSONObject.put("isAddByUser", this.jdField_b_of_type_Boolean);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Asab == null) {
      return this.jdField_a_of_type_Boolean;
    }
    return this.jdField_a_of_type_Asab.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     asaa
 * JD-Core Version:    0.7.0.1
 */