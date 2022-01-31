import org.json.JSONObject;

public class asya
{
  public long a;
  public asxz a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public String c;
  
  public static asya a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramJSONObject == null) {
      return null;
    }
    asya localasya = new asya();
    localasya.jdField_a_of_type_JavaLangString = paramJSONObject.optString("id");
    localasya.jdField_a_of_type_Long = asxk.b(localasya.jdField_a_of_type_JavaLangString);
    localasya.jdField_b_of_type_Long = asxk.a(localasya.jdField_a_of_type_JavaLangString);
    localasya.jdField_b_of_type_JavaLangString = paramJSONObject.optString("name");
    if (paramJSONObject.optInt("enable") == 1) {}
    for (;;)
    {
      localasya.jdField_a_of_type_Boolean = bool;
      localasya.c = paramJSONObject.optString("ruleWording");
      return localasya;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asya
 * JD-Core Version:    0.7.0.1
 */