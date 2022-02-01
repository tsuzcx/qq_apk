import org.json.JSONException;
import org.json.JSONObject;

public class amck
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  static amck a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new amck();
    }
    amck localamck = new amck();
    try
    {
      localamck.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localamck.jdField_a_of_type_JavaLangString = paramJSONObject.getString("name");
      localamck.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localamck.jdField_b_of_type_JavaLangString = paramJSONObject.optString("soundVersion", "0");
      localamck.jdField_c_of_type_JavaLangString = paramJSONObject.getString("soundUrl");
      localamck.jdField_d_of_type_JavaLangString = paramJSONObject.getString("whiteList");
      localamck.jdField_c_of_type_Int = paramJSONObject.getInt("isShow");
      localamck.jdField_e_of_type_Int = paramJSONObject.getInt("classify");
      localamck.g = paramJSONObject.getString("classifyName");
      localamck.jdField_e_of_type_JavaLangString = paramJSONObject.getString("backgroundUrl");
      localamck.f = String.valueOf(paramJSONObject.getInt("vip_type"));
      localamck.jdField_d_of_type_Int = paramJSONObject.getInt("useNum");
      localamck.h = paramJSONObject.getString("trialstartday");
      localamck.i = paramJSONObject.getString("trialendday");
      return localamck;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localamck;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amck
 * JD-Core Version:    0.7.0.1
 */