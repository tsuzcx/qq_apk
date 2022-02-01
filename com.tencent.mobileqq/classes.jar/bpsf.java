import org.json.JSONObject;

public class bpsf
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public static bpsf a(JSONObject paramJSONObject)
  {
    bpsf localbpsf = new bpsf();
    localbpsf.jdField_a_of_type_JavaLangString = paramJSONObject.optString("resurl");
    localbpsf.jdField_b_of_type_JavaLangString = paramJSONObject.optString("md5");
    localbpsf.c = paramJSONObject.optString("name");
    localbpsf.jdField_a_of_type_Int = paramJSONObject.optInt("text_id");
    localbpsf.jdField_b_of_type_Int = paramJSONObject.optInt("progress");
    return localbpsf;
  }
  
  public String a()
  {
    return this.c + "_" + this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpsf
 * JD-Core Version:    0.7.0.1
 */