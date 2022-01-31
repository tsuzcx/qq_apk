import org.json.JSONObject;

public class bjgs
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public static bjgs a(JSONObject paramJSONObject)
  {
    bjgs localbjgs = new bjgs();
    localbjgs.jdField_a_of_type_JavaLangString = paramJSONObject.optString("resurl");
    localbjgs.jdField_b_of_type_JavaLangString = paramJSONObject.optString("md5");
    localbjgs.c = paramJSONObject.optString("name");
    localbjgs.jdField_a_of_type_Int = paramJSONObject.optInt("text_id");
    localbjgs.jdField_b_of_type_Int = paramJSONObject.optInt("progress");
    return localbjgs;
  }
  
  public String a()
  {
    return this.c + "_" + this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjgs
 * JD-Core Version:    0.7.0.1
 */