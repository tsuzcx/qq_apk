import org.json.JSONObject;

public class asyc
{
  public long a;
  public asyb a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public String c;
  
  public static asyc a(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    if (paramJSONObject == null) {
      return null;
    }
    asyc localasyc = new asyc();
    localasyc.jdField_a_of_type_JavaLangString = paramJSONObject.optString("id");
    localasyc.jdField_a_of_type_Long = asxm.b(localasyc.jdField_a_of_type_JavaLangString);
    localasyc.jdField_b_of_type_Long = asxm.a(localasyc.jdField_a_of_type_JavaLangString);
    localasyc.jdField_b_of_type_JavaLangString = paramJSONObject.optString("name");
    if (paramJSONObject.optInt("enable") == 1)
    {
      bool1 = true;
      localasyc.jdField_a_of_type_Boolean = bool1;
      localasyc.c = paramJSONObject.optString("ruleWording");
      if (paramJSONObject.optInt("maybe_spread_user") != 1) {
        break label109;
      }
    }
    label109:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localasyc.jdField_b_of_type_Boolean = bool1;
      return localasyc;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asyc
 * JD-Core Version:    0.7.0.1
 */