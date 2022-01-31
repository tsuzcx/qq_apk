import org.json.JSONObject;

public class bhma
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public static bhma a(JSONObject paramJSONObject)
  {
    bhma localbhma = new bhma();
    localbhma.jdField_a_of_type_JavaLangString = paramJSONObject.optString("resurl");
    localbhma.jdField_b_of_type_JavaLangString = paramJSONObject.optString("md5");
    localbhma.c = paramJSONObject.optString("name");
    localbhma.jdField_a_of_type_Int = paramJSONObject.optInt("text_id");
    localbhma.jdField_b_of_type_Int = paramJSONObject.optInt("progress");
    return localbhma;
  }
  
  public String a()
  {
    return this.c + "_" + this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhma
 * JD-Core Version:    0.7.0.1
 */