import org.json.JSONObject;

public class bjhj
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public static bjhj a(JSONObject paramJSONObject)
  {
    bjhj localbjhj = new bjhj();
    localbjhj.jdField_a_of_type_JavaLangString = paramJSONObject.optString("resurl");
    localbjhj.jdField_b_of_type_JavaLangString = paramJSONObject.optString("md5");
    localbjhj.c = paramJSONObject.optString("name");
    localbjhj.jdField_a_of_type_Int = paramJSONObject.optInt("text_id");
    localbjhj.jdField_b_of_type_Int = paramJSONObject.optInt("progress");
    return localbjhj;
  }
  
  public String a()
  {
    return this.c + "_" + this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjhj
 * JD-Core Version:    0.7.0.1
 */