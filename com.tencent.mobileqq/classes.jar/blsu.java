import org.json.JSONObject;

public class blsu
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public static blsu a(JSONObject paramJSONObject)
  {
    blsu localblsu = new blsu();
    localblsu.jdField_a_of_type_JavaLangString = paramJSONObject.optString("resurl");
    localblsu.jdField_b_of_type_JavaLangString = paramJSONObject.optString("md5");
    localblsu.c = paramJSONObject.optString("name");
    localblsu.jdField_a_of_type_Int = paramJSONObject.optInt("text_id");
    localblsu.jdField_b_of_type_Int = paramJSONObject.optInt("progress");
    return localblsu;
  }
  
  public String a()
  {
    return this.c + "_" + this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blsu
 * JD-Core Version:    0.7.0.1
 */