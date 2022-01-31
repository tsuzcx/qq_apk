import org.json.JSONObject;

public class auti
{
  public long a;
  public auth a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public String c;
  
  public static auti a(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    if (paramJSONObject == null) {
      return null;
    }
    auti localauti = new auti();
    localauti.jdField_a_of_type_JavaLangString = paramJSONObject.optString("id");
    localauti.jdField_a_of_type_Long = auss.b(localauti.jdField_a_of_type_JavaLangString);
    localauti.jdField_b_of_type_Long = auss.a(localauti.jdField_a_of_type_JavaLangString);
    localauti.jdField_b_of_type_JavaLangString = paramJSONObject.optString("name");
    if (paramJSONObject.optInt("enable") == 1)
    {
      bool1 = true;
      localauti.jdField_a_of_type_Boolean = bool1;
      localauti.c = paramJSONObject.optString("ruleWording");
      if (paramJSONObject.optInt("maybe_spread_user") != 1) {
        break label109;
      }
    }
    label109:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localauti.jdField_b_of_type_Boolean = bool1;
      return localauti;
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
 * Qualified Name:     auti
 * JD-Core Version:    0.7.0.1
 */