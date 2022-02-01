import org.json.JSONObject;

public class bmvl
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public static bmvl a(JSONObject paramJSONObject)
  {
    bmvl localbmvl = new bmvl();
    localbmvl.jdField_a_of_type_JavaLangString = paramJSONObject.optString("resurl");
    localbmvl.jdField_b_of_type_JavaLangString = paramJSONObject.optString("md5");
    localbmvl.c = paramJSONObject.optString("name");
    localbmvl.jdField_a_of_type_Int = paramJSONObject.optInt("text_id");
    localbmvl.jdField_b_of_type_Int = paramJSONObject.optInt("progress");
    return localbmvl;
  }
  
  public String a()
  {
    return this.c + "_" + this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvl
 * JD-Core Version:    0.7.0.1
 */