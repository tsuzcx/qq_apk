import org.json.JSONException;
import org.json.JSONObject;

public class amjr
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
  
  static amjr a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new amjr();
    }
    amjr localamjr = new amjr();
    try
    {
      localamjr.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localamjr.jdField_a_of_type_JavaLangString = paramJSONObject.getString("name");
      localamjr.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localamjr.jdField_b_of_type_JavaLangString = paramJSONObject.optString("soundVersion", "0");
      localamjr.jdField_c_of_type_JavaLangString = paramJSONObject.getString("soundUrl");
      localamjr.jdField_d_of_type_JavaLangString = paramJSONObject.getString("whiteList");
      localamjr.jdField_c_of_type_Int = paramJSONObject.getInt("isShow");
      localamjr.jdField_e_of_type_Int = paramJSONObject.getInt("classify");
      localamjr.g = paramJSONObject.getString("classifyName");
      localamjr.jdField_e_of_type_JavaLangString = paramJSONObject.getString("backgroundUrl");
      localamjr.f = String.valueOf(paramJSONObject.getInt("vip_type"));
      localamjr.jdField_d_of_type_Int = paramJSONObject.getInt("useNum");
      localamjr.h = paramJSONObject.getString("trialstartday");
      localamjr.i = paramJSONObject.getString("trialendday");
      return localamjr;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localamjr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjr
 * JD-Core Version:    0.7.0.1
 */