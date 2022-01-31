import org.json.JSONObject;

public class auoz
{
  public long a;
  public auoy a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public String c;
  
  public static auoz a(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    if (paramJSONObject == null) {
      return null;
    }
    auoz localauoz = new auoz();
    localauoz.jdField_a_of_type_JavaLangString = paramJSONObject.optString("id");
    localauoz.jdField_a_of_type_Long = auoj.b(localauoz.jdField_a_of_type_JavaLangString);
    localauoz.jdField_b_of_type_Long = auoj.a(localauoz.jdField_a_of_type_JavaLangString);
    localauoz.jdField_b_of_type_JavaLangString = paramJSONObject.optString("name");
    if (paramJSONObject.optInt("enable") == 1)
    {
      bool1 = true;
      localauoz.jdField_a_of_type_Boolean = bool1;
      localauoz.c = paramJSONObject.optString("ruleWording");
      if (paramJSONObject.optInt("maybe_spread_user") != 1) {
        break label109;
      }
    }
    label109:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localauoz.jdField_b_of_type_Boolean = bool1;
      return localauoz;
      bool1 = false;
      break;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=").append(this.jdField_a_of_type_JavaLangString).append("|");
    localStringBuilder.append("type=").append(this.jdField_a_of_type_Long).append("|");
    localStringBuilder.append("level=").append(this.jdField_b_of_type_Long).append("|");
    localStringBuilder.append("name=").append(this.jdField_b_of_type_JavaLangString).append("|");
    localStringBuilder.append("enable=").append(this.jdField_a_of_type_Boolean).append("|");
    localStringBuilder.append("maybeSpreadUser=").append(this.jdField_b_of_type_Boolean).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auoz
 * JD-Core Version:    0.7.0.1
 */