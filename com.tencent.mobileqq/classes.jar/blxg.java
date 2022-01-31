import org.json.JSONObject;

public class blxg
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public static blxg a(JSONObject paramJSONObject)
  {
    blxg localblxg = new blxg();
    localblxg.jdField_a_of_type_JavaLangString = paramJSONObject.optString("resurl");
    localblxg.jdField_b_of_type_JavaLangString = paramJSONObject.optString("md5");
    localblxg.c = paramJSONObject.optString("name");
    localblxg.jdField_a_of_type_Int = paramJSONObject.optInt("text_id");
    localblxg.jdField_b_of_type_Int = paramJSONObject.optInt("progress");
    return localblxg;
  }
  
  public String a()
  {
    return this.c + "_" + this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxg
 * JD-Core Version:    0.7.0.1
 */