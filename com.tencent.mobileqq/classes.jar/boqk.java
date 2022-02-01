import org.json.JSONObject;

public class boqk
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public static boqk a(JSONObject paramJSONObject)
  {
    boqk localboqk = new boqk();
    localboqk.jdField_a_of_type_JavaLangString = paramJSONObject.optString("resurl");
    localboqk.jdField_b_of_type_JavaLangString = paramJSONObject.optString("md5");
    localboqk.c = paramJSONObject.optString("name");
    localboqk.jdField_a_of_type_Int = paramJSONObject.optInt("text_id");
    localboqk.jdField_b_of_type_Int = paramJSONObject.optInt("progress");
    return localboqk;
  }
  
  public String a()
  {
    return this.c + "_" + this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boqk
 * JD-Core Version:    0.7.0.1
 */