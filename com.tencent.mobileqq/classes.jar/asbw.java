import org.json.JSONObject;

public class asbw
{
  public long a;
  public asbv a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public String c;
  
  public static asbw a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramJSONObject == null) {
      return null;
    }
    asbw localasbw = new asbw();
    localasbw.jdField_a_of_type_JavaLangString = paramJSONObject.optString("id");
    localasbw.jdField_a_of_type_Long = asbg.b(localasbw.jdField_a_of_type_JavaLangString);
    localasbw.jdField_b_of_type_Long = asbg.a(localasbw.jdField_a_of_type_JavaLangString);
    localasbw.jdField_b_of_type_JavaLangString = paramJSONObject.optString("name");
    if (paramJSONObject.optInt("enable") == 1) {}
    for (;;)
    {
      localasbw.jdField_a_of_type_Boolean = bool;
      localasbw.c = paramJSONObject.optString("ruleWording");
      return localasbw;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asbw
 * JD-Core Version:    0.7.0.1
 */