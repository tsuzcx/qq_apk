import org.json.JSONException;
import org.json.JSONObject;

public class anma
  extends ankz
{
  public anmb a;
  public String b;
  public boolean b;
  
  public static anma a(JSONObject paramJSONObject)
  {
    anma localanma = new anma();
    localanma.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name");
    localanma.jdField_b_of_type_JavaLangString = paramJSONObject.optString("action");
    localanma.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isChecked", true);
    localanma.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("isAddByUser");
    return localanma;
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
    if (this.jdField_a_of_type_Anmb == null) {
      return this.jdField_a_of_type_Boolean;
    }
    return this.jdField_a_of_type_Anmb.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anma
 * JD-Core Version:    0.7.0.1
 */