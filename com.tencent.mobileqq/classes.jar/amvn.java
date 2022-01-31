import org.json.JSONException;
import org.json.JSONObject;

public class amvn
  extends amum
{
  public amvo a;
  public String b;
  public boolean b;
  
  public static amvn a(JSONObject paramJSONObject)
  {
    amvn localamvn = new amvn();
    localamvn.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name");
    localamvn.jdField_b_of_type_JavaLangString = paramJSONObject.optString("action");
    localamvn.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isChecked", true);
    localamvn.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("isAddByUser");
    return localamvn;
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
    if (this.jdField_a_of_type_Amvo == null) {
      return this.jdField_a_of_type_Boolean;
    }
    return this.jdField_a_of_type_Amvo.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amvn
 * JD-Core Version:    0.7.0.1
 */