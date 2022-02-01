import org.json.JSONObject;

public class bold
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public static bold a(JSONObject paramJSONObject)
  {
    bold localbold = new bold();
    localbold.jdField_a_of_type_JavaLangString = paramJSONObject.optString("resurl");
    localbold.jdField_b_of_type_JavaLangString = paramJSONObject.optString("md5");
    localbold.c = paramJSONObject.optString("name");
    localbold.jdField_a_of_type_Int = paramJSONObject.optInt("text_id");
    localbold.jdField_b_of_type_Int = paramJSONObject.optInt("progress");
    return localbold;
  }
  
  public String a()
  {
    return this.c + "_" + this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bold
 * JD-Core Version:    0.7.0.1
 */